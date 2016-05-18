package ua.shop.captcha.util;

/**
 * @author Oleg Dashkevych.
 */
public class RandomGenerator {

	private RandomGenerator() {
	}

	public static String getRandomString(int min, int max) {
		return String.valueOf(min + (int) (Math.random() * ((max - min) + 1)));
	}
}
