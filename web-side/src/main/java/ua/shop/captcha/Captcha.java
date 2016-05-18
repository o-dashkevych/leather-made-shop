package ua.shop.captcha;

import java.awt.image.BufferedImage;

/**
 * @author Oleg Dashkevych.
 */
public class Captcha {

	private String word;

	private BufferedImage image;

	private long timeStamp;

	public Captcha() {
	}

	public Captcha(String word, BufferedImage image, long timeStamp) {
		this.word = word;
		this.image = image;
		this.timeStamp = timeStamp;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}
}
