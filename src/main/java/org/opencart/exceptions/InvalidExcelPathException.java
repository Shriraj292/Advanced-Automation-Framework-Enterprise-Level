package org.opencart.exceptions;

/**
 * Thrown when the excel file is not found due to invalid path mentioned in
 * FrameworkConstants.
 * 
 * @author Shriraj Ghorpade
 * @see {@link org.opencart.constants.FrameworkConstants}
 * @see {@link FrameworkExceptions}
 */
@SuppressWarnings("serial")
public class InvalidExcelPathException extends FrameworkExceptions {

	public InvalidExcelPathException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidExcelPathException(String message) {
		super(message);
	}

}
