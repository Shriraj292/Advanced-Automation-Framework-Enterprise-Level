package org.opencart.exceptions;

/**
 * {@link FrameworkExceptions} is a superclass for all the custom exceptions
 * that can occur. FrameworkExceptions extends {@link RuntimeException} class
 * and all the custom exceptions extending FrameworkExceptions stop the
 * execution of the program when thrown.
 * 
 * @author Shriraj Ghorpade
 */
@SuppressWarnings("serial")
public class FrameworkExceptions extends RuntimeException {

	public FrameworkExceptions(String message, Throwable cause) {
		super(message, cause);
	}

	public FrameworkExceptions(String message) {
		super(message);
	}

}
