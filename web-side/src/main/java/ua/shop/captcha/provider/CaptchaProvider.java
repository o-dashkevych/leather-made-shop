package ua.shop.captcha.provider;

import ua.shop.captcha.Captcha;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Oleg Dashkevych.
 */
public interface CaptchaProvider {

	void setCaptcha(HttpServletRequest request, HttpServletResponse response, Captcha captcha);

	Captcha getCaptcha(HttpServletRequest request, HttpServletResponse response);
}
