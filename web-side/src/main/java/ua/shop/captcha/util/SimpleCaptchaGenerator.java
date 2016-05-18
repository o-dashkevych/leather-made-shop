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

	private int wight;

	private int height;

	public SimpleCaptchaGenerator(int wight, int height) {
		this.wight = wight;
		this.height = height;
	}

	public Captcha generateCaptcha(String word) {
		FontGenerator fontGenerator = new RandomFontGenerator(10, 15);
		BackgroundGenerator backgroundGenerator = new FunkyBackgroundGenerator(wight, height);
		TextPaster textPaster = new SimpleTextPaster(1, word.length(), Color.BLACK);
		BufferedImage image = new ComposedWordToImage(fontGenerator, backgroundGenerator, textPaster).getImage(word);
		long timeStamp = System.currentTimeMillis();
		return new Captcha(word, image, timeStamp);
	}

	public Captcha generateCaptchaWithRandomWord() {
		SimpleCaptchaGenerator generator = new SimpleCaptchaGenerator(100, 150);
		String word = RandomGenerator.getRandomString(1, 4);
		return generator.generateCaptcha(word);
	}

}
