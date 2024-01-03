package org.opencart.exceptions;

/**
 * Thrown when browser value passed via excel file is not valid.
 * 
 * @author Shriraj Ghorpade
 * @see {@link BrowserInitializationFailedException}
 * @see {@link FrameworkExceptions}
 */
@SuppressWarnings("serial")
public class InvalidBrowserException extends FrameworkExceptions {

	public InvalidBrowserException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidBrowserException(String message) {
		super(message);
	}

}
