package org.opencart.exceptions;

/**
 * Thrown when property key mentioned in
 * {@link org.opencart.enums.ConfigProperties} is not valid.
 * 
 * @author Shriraj Ghorpade
 * @see {@link org.opencart.enums.ConfigProperties}
 * @see {@link FrameworkExceptions}
 */
@SuppressWarnings("serial")
public class InvalidPropertyKeyException extends FrameworkExceptions {

	public InvalidPropertyKeyException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidPropertyKeyException(String message) {
		super(message);
	}

}
