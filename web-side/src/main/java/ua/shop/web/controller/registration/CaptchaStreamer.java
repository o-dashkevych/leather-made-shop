package ua.shop.web.controller.registration;

import ua.shop.captcha.CaptchaManager;
import ua.shop.util.BufferedImageByteConverter;
import ua.shop.web.HttpAttributeNames;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * @author Oleg Dashkevych.
 */
@WebServlet(urlPatterns = {"/register/captcha"}, name = "captcha-provide")
public class CaptchaStreamer extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		synchronized (req.getSession()) {
			sendImage(req, resp);
		}
	}

	private void sendImage(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		BufferedImage image = getImage(req, resp);
		byte[] imageInByte = BufferedImageByteConverter.convert(image);
		resp.setContentType("image/jpg");
		resp.setContentLength(imageInByte.length);
		writeImageBytesToStream(resp.getOutputStream(), imageInByte);
	}

	private BufferedImage getImage(HttpServletRequest req, HttpServletResponse resp) {
		CaptchaManager captchaManager = (CaptchaManager) req.getServletContext().getAttribute(HttpAttributeNames.CAPTCHA_MANAGER);
		return captchaManager.getCaptcha(req, resp).getImage();
	}

	private void writeImageBytesToStream(ServletOutputStream oStream, byte[] imageInByte) throws IOException {
		ByteArrayInputStream iStream = new ByteArrayInputStream(imageInByte);
		byte[] buffer = new byte[1024];
		int len;
		while ((len = iStream.read(buffer)) != -1) {
			oStream.write(buffer, 0, len);
		}
		iStream.close();
		oStream.flush();
		oStream.close();
	}
}
