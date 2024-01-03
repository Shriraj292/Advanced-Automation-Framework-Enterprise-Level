package org.opencart.exceptions;

/**
 * Thrown when value of property key mentioned in properties file is empty.
 * 
 * @author Shriraj Ghorpade
 * @see {@link FrameworkExceptions}
 */
@SuppressWarnings("serial")
public class PropertyValueEmptyException extends FrameworkExceptions {

	public PropertyValueEmptyException(String message, Throwable cause) {
		super(message, cause);
	}

	public PropertyValueEmptyException(String message) {
		super(message);
	}

}
