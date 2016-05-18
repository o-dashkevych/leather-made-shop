package ua.shop.exceptions;

/**
 * @author Oleg Dashkevych.
 */
public class NameException extends ValidationException {

	/**
	 * Returns the detail message string of this throwable.
	 *
	 * @return the detail message string of this {@code Throwable} instance
	 * (which may be {@code null}).
	 */
	@Override
	public String getMessage() {
		return ExceptionMessages.NAME_EXCEPTION;
	}
}

