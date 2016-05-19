package ua.shop.util;

import org.apache.commons.lang3.StringUtils;
import ua.shop.entity.User;
import ua.shop.exceptions.*;

/**
 * @author Oleg Dashkevych.
 */
public class UserValidator {

	private UserValidator() {
	}

	public static void validateUser(User user) throws ValidationException {
		validateName(user.getName());
		validateSurname(user.getSurname());
		validateEmail(user.getEmail());
		validatePassword(user.getPassword());
	}

	public static void validateName(String name) throws NameException {
		if (isNotName(name)) {
			throw new NameException();
		}
	}

	public static void validateSurname(String surname) throws SurnameException {
		if (isNotName(surname)) {
			throw new SurnameException();
		}
	}

	public static void validatePassword(String password) throws PasswordException {
		String passwordPattern = "^[\\w+\\s]{4,10}$";
		if (StringUtils.isEmpty(password) || !password.matches(passwordPattern)) {
			throw new PasswordException();
		}
	}

	public static void validateRepeatPassword(String password, String repeatPassword) throws RepeatPasswordException {
		if (!areNotSimilar(password, repeatPassword)) {
			throw new RepeatPasswordException();
		}
	}

	public static void validateEmail(String email) throws EmailException {
		String emailPattern = "^\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
		if (StringUtils.isEmpty(email) || !email.matches(emailPattern)) {
			throw new EmailException();
		}

	}

	public static void validateRepeatEmail(String password, String repeatPassword) throws RepeatEmailException {
		if (!areNotSimilar(password, repeatPassword)) {
			throw new RepeatEmailException();
		}
	}

	private static boolean isNotName(String name) {
		String namePattern = "^([a-zA-Z]+[0-9]*){3,30}$";
		return (StringUtils.isEmpty(name) && name.matches(namePattern));
	}

	private static boolean areEmpty(String... args) {
		for (String argument : args) {
			if (StringUtils.isEmpty(argument)) {
				return true;
			}
		}
		return false;
	}

	private static boolean areNotSimilar(String firstParam, String secondParam) {
		return (!areEmpty(firstParam, secondParam) && firstParam.equals(secondParam));
	}
}
