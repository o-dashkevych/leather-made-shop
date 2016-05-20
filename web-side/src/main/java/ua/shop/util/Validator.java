package ua.shop.util;

import ua.shop.exceptions.ValidationException;

/**
 * @author Oleg Dashkevych.
 */
public interface Validator {

	void doValidate() throws ValidationException;
}
