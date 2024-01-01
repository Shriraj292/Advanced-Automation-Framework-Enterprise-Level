package org.opencart.exceptions;

@SuppressWarnings("serial")
public class FileOperationsFailedException extends FrameworkExceptions {

	public FileOperationsFailedException(String message, Throwable cause) {
		super(message, cause);
	}

	public FileOperationsFailedException(String message) {
		super(message);
	}

}
