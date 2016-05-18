package ua.shop.web.controller.registration;

import ua.shop.captcha.provider.CaptchaProvider;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Oleg Dashkevych.
 */
@WebServlet(urlPatterns = {"/register"}, name = "registration")
public class RegistrationPage extends HttpServlet {

	/**
	 * Is used for providing form of registration
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CaptchaProvider provider = (CaptchaProvider) req.getServletContext().getAttribute("captcha.provider");
		provider.setCaptcha(req, resp);
		req.getRequestDispatcher("/pages/register.jsp").forward(req, resp);
	}

	/**
	 * Is used for registering user
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}
}