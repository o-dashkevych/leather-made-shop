package ua.shop.captcha.provider;

import ua.shop.captcha.Captcha;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Oleg Dashkevych.
 */
public interface ContextCaptchaProvider extends CaptchaProvider {

	ConcurrentHashMap<String, Captcha> getCaptchaConcurrentHashMap();
}
