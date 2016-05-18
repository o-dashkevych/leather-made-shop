package ua.shop.captcha;

import ua.shop.captcha.provider.CaptchaProvider;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Oleg Dashkevych.
 */
public class CaptchaSetter {

	private CaptchaProvider captchaProvider;

	public CaptchaSetter(CaptchaProvider captchaProvider) {
		this.captchaProvider = captchaProvider;
	}

	public void setCaptcha(HttpServletRequest request, HttpServletResponse response) {
		captchaProvider.setCaptcha(request, response);
	}
}
