package ua.shop.captcha.util;

import com.octo.captcha.component.image.backgroundgenerator.BackgroundGenerator;
import com.octo.captcha.component.image.backgroundgenerator.FunkyBackgroundGenerator;
import com.octo.captcha.component.image.fontgenerator.FontGenerator;
import com.octo.captcha.component.image.fontgenerator.RandomFontGenerator;
import com.octo.captcha.component.image.textpaster.SimpleTextPaster;
import com.octo.captcha.component.image.textpaster.TextPaster;
import com.octo.captcha.component.image.wordtoimage.ComposedWordToImage;
import ua.shop.captcha.Captcha;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * @author Oleg Dashkevych.
 */
public class SimpleCaptchaGenerator {

	private final int wight;

	private final int height;

	private final int minFontSize;

	private final int maxFontSize;

	public SimpleCaptchaGenerator(int wight, int height, int minFontSize, int maxFontSize) {
		this.wight = wight;
		this.height = height;
		this.minFontSize = minFontSize;
		this.maxFontSize = maxFontSize;
	}

	public Captcha generateCaptcha(String word) {
		FontGenerator fontGenerator = new RandomFontGenerator(minFontSize, maxFontSize);
		BackgroundGenerator backgroundGenerator = new FunkyBackgroundGenerator(wight, height);
		TextPaster textPaster = new SimpleTextPaster(1, word.length(), Color.BLACK);
		BufferedImage image = new ComposedWordToImage(fontGenerator, backgroundGenerator, textPaster).getImage(word);
		long timeStamp = System.currentTimeMillis();
		return new Captcha(word, image, timeStamp);
	}

	public Captcha generateCaptchaWithRandomNumbers(Integer start, Integer end) {
		String word = RandomGenerator.getRandomString(start, end);
		return generateCaptcha(word);
	}
}
