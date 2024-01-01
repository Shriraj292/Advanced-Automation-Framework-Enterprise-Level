package org.opencart.exceptions;

@SuppressWarnings("serial")
public class InvalidBrowserException extends FrameworkExceptions {

	public InvalidBrowserException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidBrowserException(String message) {
		super(message);
	}

}
