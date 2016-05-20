package ua.shop.web.controller.registration.util;

import ua.shop.entity.User;
import ua.shop.util.UserValidator;
import ua.shop.web.HttpAttributeNames;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author Oleg Dashkevych.
 */
public class RegisterRequestDataOperator {

	private UserValidator validator = new UserValidator();

	public void validateInputParametersAndPutExceptionsMap(HttpServletRequest request) {
		User user = composeUserFromParams(request);
		validator.putUserValidationExceptionsToMap(user);
		validateRepeatEmails(request);
		validateRepeatPasswords(request);
		request.setAttribute("exceptions", validator.getExceptionMapAndClear());
	}

	private void validateRepeatEmails(HttpServletRequest request) {
		String email = request.getParameter(HttpAttributeNames.REGISTRATION_EMAIL);
		String repeatEmail = request.getParameter(HttpAttributeNames.REGISTRATION_REPEAT_EMAIL);
		validator.putRepeatEmailValidationExceptionsToMap(email, repeatEmail);
	}

	private void validateRepeatPasswords(HttpServletRequest request) {
		String password = request.getParameter(HttpAttributeNames.REGISTRATION_PASSWORD);
		String repeatPassword = request.getParameter(HttpAttributeNames.REGISTRATION_REPEAT_PASSWORD);
		validator.putRepeatPasswordValidationExceptionsToMap(password, repeatPassword);
	}

	public static User composeUserFromParams(HttpServletRequest request) {
		User user = new User();
		user.setName(request.getParameter(HttpAttributeNames.REGISTRATION_NAME));
		user.setSurname(request.getParameter(HttpAttributeNames.REGISTRATION_SURNAME));
		user.setEmail(request.getParameter(HttpAttributeNames.REGISTRATION_EMAIL));
		user.setPassword(request.getParameter(HttpAttributeNames.REGISTRATION_PASSWORD));
		return user;
	}

	public void setAttributesFromParams(HttpServletRequest request) {
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
