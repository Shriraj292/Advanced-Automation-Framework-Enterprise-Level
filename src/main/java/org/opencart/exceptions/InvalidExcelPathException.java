package org.opencart.exceptions;

@SuppressWarnings("serial")
public class InvalidExcelPathException extends FrameworkExceptions {

	public InvalidExcelPathException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidExcelPathException(String message) {
		super(message);
	}

}
