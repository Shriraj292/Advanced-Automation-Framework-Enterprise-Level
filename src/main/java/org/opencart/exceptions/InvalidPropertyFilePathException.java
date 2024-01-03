package org.opencart.exceptions;

/**
 * Thrown when the properties file is not found due to invalid path mentioned in
 * FrameworkConstants.
 * 
 * @author Shriraj Ghorpade
 * @see {@link org.opencart.constants.FrameworkConstants}
 * @see {@link FrameworkExceptions}
 */
@SuppressWarnings("serial")
public class InvalidPropertyFilePathException extends FrameworkExceptions {

	public InvalidPropertyFilePathException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidPropertyFilePathException(String message) {
		super(message);
	}

}
