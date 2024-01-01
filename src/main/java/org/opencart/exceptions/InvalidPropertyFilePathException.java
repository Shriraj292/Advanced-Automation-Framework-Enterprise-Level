package org.opencart.exceptions;

@SuppressWarnings("serial")
public class InvalidPropertyFilePathException extends FrameworkExceptions {

	public InvalidPropertyFilePathException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidPropertyFilePathException(String message) {
		super(message);
	}

}
