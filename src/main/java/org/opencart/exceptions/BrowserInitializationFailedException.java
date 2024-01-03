package org.opencart.exceptions;

/**
 * Thrown when browser initialization fails due to some unknown reasons.
 * 
 * @author Shriraj Ghorpade
 * @see {@link FrameworkExceptions}
 */
@SuppressWarnings("serial")
public class BrowserInitializationFailedException extends FrameworkExceptions {

	public BrowserInitializationFailedException(String message) {
		super(message);
	}

	public BrowserInitializationFailedException(String message, Throwable cause) {
		super(message, cause);
	}

}
