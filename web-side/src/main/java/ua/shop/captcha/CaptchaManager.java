package ua.shop.captcha;

import org.apache.log4j.Logger;
import ua.shop.captcha.provider.CaptchaProvider;
import ua.shop.captcha.provider.ContextCaptchaProvider;
import ua.shop.captcha.util.SimpleCaptchaGenerator;
import ua.shop.util.ConfigManager;
import ua.shop.util.PropertyKeyNames;
import ua.shop.web.HttpAttributeNames;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Oleg Dashkevych.
 */
public class CaptchaManager {

	private static final Logger LOGGER = Logger.getLogger(CaptchaManager.class);

	private final CaptchaProvider provider;

	private final ConfigManager configManager = new ConfigManager();

	public CaptchaManager(CaptchaProvider provider) {
		this.provider = provider;
	}

	public void setCaptcha(HttpServletRequest request, HttpServletResponse response) {
		provider.setCaptcha(request, response, generateCaptchaWithDefaultParameters());
	}

	public Captcha getCaptcha(HttpServletRequest request, HttpServletResponse response) {
		return provider.getCaptcha(request);
	}

	public boolean validateCaptchaResponse(HttpServletRequest request, HttpServletResponse response) {
		String enteredWord = request.getParameter(HttpAttributeNames.CAPTCHA_WORD);
		Captcha captcha = getCaptcha(request, response);
		if (captcha == null) return false;
		String realWord = captcha.getWord();
		return realWord.equals(enteredWord);
	}

	public boolean isContextManager() {
		return provider instanceof ContextCaptchaProvider;
	}

	public CaptchaProvider getProvider() {
		return provider;
	}

	private Captcha generateCaptchaWithDefaultParameters() {
		Integer width = configManager.getConfigInteger(PropertyKeyNames.CAPTCHA_WIDTH),
				height = configManager.getConfigInteger(PropertyKeyNames.CAPTCHA_HEIGHT),
				maxFontSize = configManager.getConfigInteger(PropertyKeyNames.CAPTCHA_MAX_FONT),
				minFontSize = configManager.getConfigInteger(PropertyKeyNames.CAPTCHA_MIN_FONT);
		return generateCaptchaWithDefaultNumberIntervals(new SimpleCaptchaGenerator(width, height, minFontSize, maxFontSize));
	}

	private Captcha generateCaptchaWithDefaultNumberIntervals(SimpleCaptchaGenerator generator) {
		Integer max = configManager.getConfigInteger(PropertyKeyNames.CAPTCHA_MAX),
				min = configManager.getConfigInteger(PropertyKeyNames.CAPTCHA_MIN);
		return generator.generateCaptchaWithRandomNumbers(min, max);
	}
}
