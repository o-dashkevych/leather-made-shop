package ua.shop.util;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author Oleg Dashkevych.
 */
public class BufferedImageByteConverter {

	public static byte[] convert(BufferedImage image) throws IOException {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		ImageIO.write(image, "jpg", stream);
		stream.flush();
		byte[] imageInByte = stream.toByteArray();
		stream.close();
		return imageInByte;
	}
}
