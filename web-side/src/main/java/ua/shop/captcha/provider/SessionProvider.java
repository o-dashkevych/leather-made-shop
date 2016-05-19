package ua.shop.captcha.provider;

import ua.shop.captcha.Captcha;
import ua.shop.web.HttpAttributeNames;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Oleg Dashkevych.
 */
public class SessionProvider implements CaptchaProvider {
	@Override
	public void setCaptcha(HttpServletRequest request, HttpServletResponse response, Captcha captcha) {
		request.getSession().setAttribute(HttpAttributeNames.CAPTCHA_ID, captcha);
	}

	@Override
	public Captcha getCaptcha(HttpServletRequest request) {
		return (Captcha) request.getSession().getAttribute(HttpAttributeNames.CAPTCHA_ID);
	}
}
