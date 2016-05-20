package ua.shop.web.controller.registration;

import ua.shop.captcha.CaptchaManager;
import ua.shop.entity.User;
import ua.shop.exceptions.ExceptionMessages;
import ua.shop.service.UserService;
import ua.shop.web.HttpAttributeNames;
import ua.shop.web.controller.registration.util.RegisterRequestDataOperator;

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
		synchronized (req.getSession()) {
			CaptchaManager captchaManager = (CaptchaManager) req.getServletContext().getAttribute(HttpAttributeNames.CAPTCHA_MANAGER);
			captchaManager.setCaptcha(req, resp);
			req.getRequestDispatcher("/pages/register.jsp").forward(req, resp);
		}
	}

	/**
	 * Is used for registering user
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		synchronized (req.getSession()) {
			RegisterRequestDataOperator operator = new RegisterRequestDataOperator();
			operator.setAttributesFromParams(req);
			operator.validateInputParametersAndPutExceptionsMap(req);
			validateCaptchaEquality(req, resp);
			validateUserRegistration(req, resp);
			resp.sendRedirect("/pages/index.jsp");
			//TODO move attributes from session to req and shoe exc on registration.jspf
		}
	}

	private void validateCaptchaEquality(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CaptchaManager captchaManager = (CaptchaManager) req.getServletContext().getAttribute(HttpAttributeNames.CAPTCHA_MANAGER);
		if (!captchaManager.validateCaptchaResponse(req, resp)) {
			req.setAttribute(HttpAttributeNames.REGISTRATION_EXCEPTION_ATTRIBUTE, ExceptionMessages.INVALID_CAPTCHA_EXCEPTION);
			doGet(req, resp);
		}
	}

	private void validateUserRegistration(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = RegisterRequestDataOperator.composeUserFromParams(req);
		UserService userService = new UserService();
		if (!userService.add(user)) {
			req.setAttribute(HttpAttributeNames.REGISTRATION_EXCEPTION_ATTRIBUTE, ExceptionMessages.EXIST_USER_EXCEPTION);
			doGet(req, resp);
		}
	}
}
