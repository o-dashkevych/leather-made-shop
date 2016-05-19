package ua.shop.web.controller.registration;

import ua.shop.entity.User;
import ua.shop.exceptions.RepeatEmailException;
import ua.shop.exceptions.RepeatPasswordException;
import ua.shop.exceptions.ValidationException;
import ua.shop.util.UserValidator;
import ua.shop.web.HttpAttributeNames;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author Oleg Dashkevych.
 */
public class RegisterRequestDataOperator {

	public static void validateInputParameters(HttpServletRequest request) throws ValidationException {
		UserValidator.validateUser(composeUserFromParams(request));
		validateRepeatEmails(request);
		validateRepeatPasswords(request);
	}

	private static void validateRepeatEmails(HttpServletRequest request) throws RepeatEmailException {
		String email = request.getParameter(HttpAttributeNames.REGISTRATION_EMAIL);
		String repeatEmail = request.getParameter(HttpAttributeNames.REGISTRATION_REPEAT_EMAIL);
		UserValidator.validateRepeatEmail(email, repeatEmail);
	}

	private static void validateRepeatPasswords(HttpServletRequest request) throws RepeatPasswordException {
		String password = request.getParameter(HttpAttributeNames.REGISTRATION_PASSWORD);
		String repeatPassword = request.getParameter(HttpAttributeNames.REGISTRATION_REPEAT_PASSWORD);
		UserValidator.validateRepeatPassword(password, repeatPassword);
	}

	public static User composeUserFromParams(HttpServletRequest request) {
		User user = new User();
		user.setName(request.getParameter(HttpAttributeNames.REGISTRATION_NAME));
		user.setSurname(request.getParameter(HttpAttributeNames.REGISTRATION_SURNAME));
		user.setEmail(request.getParameter(HttpAttributeNames.REGISTRATION_EMAIL));
		user.setPassword(request.getParameter(HttpAttributeNames.REGISTRATION_PASSWORD));
		return user;
	}

	public static void setAttributesFromParams(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute(HttpAttributeNames.REGISTRATION_NAME, request.getParameter(HttpAttributeNames.REGISTRATION_NAME));
		session.setAttribute(HttpAttributeNames.REGISTRATION_SURNAME, request.getParameter(HttpAttributeNames.REGISTRATION_SURNAME));
		session.setAttribute(HttpAttributeNames.REGISTRATION_EMAIL, request.getParameter(HttpAttributeNames.REGISTRATION_EMAIL));
		session.setAttribute(HttpAttributeNames.REGISTRATION_REPEAT_EMAIL, request.getParameter(HttpAttributeNames.REGISTRATION_REPEAT_EMAIL));
		String[] newsletters = request.getParameterValues(HttpAttributeNames.REGISTRATION_NEWSLETTER);
		if (newsletters != null) {
			session.setAttribute(HttpAttributeNames.REGISTRATION_NEWSLETTER, newsletters[0]);
		}
	}
}
