package ua.shop.captcha.util;

import ua.shop.captcha.Captcha;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author Oleg Dashkevych.
 */
public class CaptchaCleaner implements Runnable {


	private final AtomicBoolean isRunning = new AtomicBoolean(true);

	private final long timeIntervalInMillis;

	private final ConcurrentHashMap<String, Captcha> captchaConcurrentHashMap;

	public CaptchaCleaner(long timeInterval, ConcurrentHashMap<String, Captcha> captchaConcurrentHashMap) {
		this.timeIntervalInMillis = timeInterval * 1000;
		this.captchaConcurrentHashMap = captchaConcurrentHashMap;
	}

	/**
	 * When an object implementing interface <code>Runnable</code> is used
	 * to create a thread, starting the thread causes the object's
	 * <code>run</code> method to be called in that separately executing
	 * thread.
	 *
	 * @see Thread#run()
	 */
	@Override
	public void run() {
		while (isRunning.get()) {
			waiting();
			cleanOldCaptcha();
		}
	}

	/**
	 * Stops cleaner
	 */
	public void stop() {
		isRunning.set(false);
	}

	private void cleanOldCaptcha() {
		captchaConcurrentHashMap.keySet().stream().filter(key -> isOld(captchaConcurrentHashMap.get(key))).forEach(captchaConcurrentHashMap::remove);
	}

	private boolean isOld(Captcha captcha) {
		long timeStamp = captcha.getTimeStamp();
		long currentTime = System.currentTimeMillis();
		return (currentTime - timeStamp < timeIntervalInMillis);
	}

	private synchronized void waiting() {
		try {
			this.wait(timeIntervalInMillis);
		} catch (InterruptedException e) {
			System.out.println("Worker ended");
		}
	}
}
