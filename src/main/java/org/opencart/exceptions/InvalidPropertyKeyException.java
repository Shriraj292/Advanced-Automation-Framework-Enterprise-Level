package org.opencart.exceptions;

@SuppressWarnings("serial")
public class InvalidPropertyKeyException extends FrameworkExceptions {

	public InvalidPropertyKeyException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidPropertyKeyException(String message) {
		super(message);
	}

}
