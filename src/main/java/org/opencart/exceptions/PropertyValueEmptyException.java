package org.opencart.exceptions;

@SuppressWarnings("serial")
public class PropertyValueEmptyException extends FrameworkExceptions {

	public PropertyValueEmptyException(String message, Throwable cause) {
		super(message, cause);
	}

	public PropertyValueEmptyException(String message) {
		super(message);
	}

}
