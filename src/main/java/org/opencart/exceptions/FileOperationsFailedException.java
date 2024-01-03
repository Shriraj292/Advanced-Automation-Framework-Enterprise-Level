package org.opencart.exceptions;

/**
 * Thrown when file operations fail due to unknown reasons.
 * 
 * @author Shriraj Ghorpade
 * @see {@link FrameworkExceptions}
 */
@SuppressWarnings("serial")
public class FileOperationsFailedException extends FrameworkExceptions {

	public FileOperationsFailedException(String message, Throwable cause) {
		super(message, cause);
	}

	public FileOperationsFailedException(String message) {
		super(message);
	}

}
