package ua.shop.util;

import org.apache.commons.lang3.StringUtils;
import ua.shop.entity.User;
import ua.shop.exceptions.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Oleg Dashkevych.
 */
public class UserValidator {

	private Map<String, String> exceptionMap = new HashMap<>();

	public UserValidator() {
	}

	public void putUserValidationExceptionsToMap(User user) {
		putExceptionToMapIfInvalid(() -> validateName(user.getName()), ExceptionMessages.NAME_EXCEPTION);
		putExceptionToMapIfInvalid(() -> validatePassword(user.getPassword()), ExceptionMessages.PASSWORD_EXCEPTION);
		putExceptionToMapIfInvalid(() -> validateSurname(user.getSurname()), ExceptionMessages.SURNAME_EXCEPTION);
		putExceptionToMapIfInvalid(() -> validateEmail(user.getEmail()), ExceptionMessages.EMAIL_EXCEPTION);
	}

	public void putRepeatEmailValidationExceptionsToMap(String email, String repeatEmail) {
		putExceptionToMapIfInvalid(() -> validateRepeatEmail(email, repeatEmail), ExceptionMessages.NAME_EXCEPTION);
	}

	public void putRepeatPasswordValidationExceptionsToMap(String password, String repeatPassword) {
		putExceptionToMapIfInvalid(() -> validateRepeatPassword(password, repeatPassword), ExceptionMessages.NAME_EXCEPTION);
	}

	public Map<String, String> getExceptionMapAndClear() {
		Map<String, String> result = exceptionMap;
		exceptionMap = new HashMap<>();
		return result;
	}

	public void putExceptionToMapIfInvalid(Validator validator, String exceptionName) {
		try {
			validator.doValidate();
		} catch (ValidationException e) {
			exceptionMap.put(exceptionName, e.getMessage());
		}
	}

	public void validateName(String name) throws NameException {
		if (isNotName(name)) {
			throw new NameException();
		}
	}

	public void validateSurname(String surname) throws SurnameException {
		if (isNotName(surname)) {
			throw new SurnameException();
		}
	}

	public void validatePassword(String password) throws PasswordException {
		String passwordPattern = "^[\\w+\\s]{4,10}$";
		if (StringUtils.isEmpty(password) || !password.matches(passwordPattern)) {
			throw new PasswordException();
		}
	}

	public void validateRepeatPassword(String password, String repeatPassword) throws RepeatPasswordException {
		if (!areNotSimilar(password, repeatPassword)) {
			throw new RepeatPasswordException();
		}
	}

	public void validateEmail(String email) throws EmailException {
		String emailPattern = "^\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
		if (StringUtils.isEmpty(email) || !email.matches(emailPattern)) {
			throw new EmailException();
		}

	}

	public void validateRepeatEmail(String password, String repeatPassword) throws RepeatEmailException {
		if (!areNotSimilar(password, repeatPassword)) {
			throw new RepeatEmailException();
		}
	}

	private boolean isNotName(String name) {
		String namePattern = "^([a-zA-Z]+[0-9]*){3,30}$";
		return (StringUtils.isEmpty(name) && name.matches(namePattern));
	}

	private boolean areEmpty(String... args) {
		for (String argument : args) {
			if (StringUtils.isEmpty(argument)) {
				return true;
			}
		}
		return false;
	}

	private boolean areNotSimilar(String firstParam, String secondParam) {
		return (!areEmpty(firstParam, secondParam) && firstParam.equals(secondParam));
	}
}
