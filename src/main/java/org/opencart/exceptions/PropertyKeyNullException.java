package org.opencart.exceptions;

@SuppressWarnings("serial")
public class PropertyKeyNullException extends FrameworkExceptions {

	public PropertyKeyNullException(String message, Throwable cause) {
		super(message, cause);
	}

	public PropertyKeyNullException(String message) {
		super(message);
	}

}
