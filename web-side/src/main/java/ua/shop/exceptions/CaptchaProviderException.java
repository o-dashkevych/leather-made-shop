package ua.shop.exceptions;

/**
 * @author Oleg Dashkevych.
 */
public class CaptchaProviderException extends RuntimeException {

	/**
	 * Returns the detail message string of this throwable.
	 *
	 * @return the detail message string of this {@code Throwable} instance
	 * (which may be {@code null}).
	 */
	@Override
	public String getMessage() {
		return ExceptionMessages.PROVIDER_EXCEPTION;
	}
}

