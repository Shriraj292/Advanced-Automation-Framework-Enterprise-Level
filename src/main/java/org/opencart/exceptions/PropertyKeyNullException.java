package org.opencart.exceptions;

/**
 * Thrown when null is passed where valid property key is required.
 * 
 * @author Shriraj Ghorpade
 * @see {@link FrameworkExceptions}
 */
@SuppressWarnings("serial")
public class PropertyKeyNullException extends FrameworkExceptions {

	public PropertyKeyNullException(String message, Throwable cause) {
		super(message, cause);
	}

	public PropertyKeyNullException(String message) {
		super(message);
	}

}
