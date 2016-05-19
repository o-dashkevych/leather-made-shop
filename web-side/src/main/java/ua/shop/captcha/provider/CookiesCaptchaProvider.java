package ua.shop.captcha.provider;

import ua.shop.captcha.Captcha;
import ua.shop.web.HttpAttributeNames;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.stream.Stream;

/**
 * @author Oleg Dashkevych.
 */
public class CookiesCaptchaProvider extends ContextCaptchaProvider {

	@Override
	public void setCaptcha(HttpServletRequest request, HttpServletResponse response, Captcha captcha) {
		String id = addCaptchaToMap(captcha);
		Cookie cookie = new Cookie(HttpAttributeNames.CAPTCHA_ID, id);
		response.addCookie(cookie);
	}

	@Override
	public Captcha getCaptcha(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		Cookie captchaCookie = Stream.of(cookies).filter(cookie -> cookie.getName().equals(HttpAttributeNames.CAPTCHA_ID)).findFirst().get();
		return captchaConcurrentHashMap.get(captchaCookie.getValue());
	}

}
