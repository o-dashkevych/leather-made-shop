package ua.shop.captcha.provider;

import ua.shop.captcha.Captcha;
import ua.shop.captcha.util.SimpleCaptchaGenerator;
import ua.shop.web.HttpAttributeNames;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Oleg Dashkevych.
 */
public class HiddenFieldCaptchaProvider implements ContextCaptchaProvider {

	private final ConcurrentHashMap<String, Captcha> captchaConcurrentHashMap = new ConcurrentHashMap<>();

	public ConcurrentHashMap<String, Captcha> getCaptchaConcurrentHashMap() {
		return captchaConcurrentHashMap;
	}

	@Override
	public void setCaptcha(HttpServletRequest request, HttpServletResponse response) {
		Captcha captcha = new SimpleCaptchaGenerator(100, 150).generateCaptchaWithRandomWord();
		String id = addCaptchaToMap(captcha);
		request.setAttribute(HttpAttributeNames.CAPTCHA_ID, id);
	}

	private String addCaptchaToMap(Captcha captcha) {
		String id = UUID.randomUUID().toString();
		captchaConcurrentHashMap.put(id, captcha);
		return id;
	}

	@Override
	public Captcha getCaptcha(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		return captchaConcurrentHashMap.get(id);
	}
}
