package ua.shop.captcha.provider;

import ua.shop.captcha.Captcha;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Oleg Dashkevych.
 */
public abstract class ContextCaptchaProvider implements CaptchaProvider {

	protected final ConcurrentHashMap<String, Captcha> captchaConcurrentHashMap = new ConcurrentHashMap<>();

	public ConcurrentHashMap<String, Captcha> getCaptchaConcurrentHashMap() {
		return captchaConcurrentHashMap;
	}

	protected String addCaptchaToMap(Captcha captcha) {
		String id = UUID.randomUUID().toString();
		captchaConcurrentHashMap.put(id, captcha);
		return id;
	}
}
