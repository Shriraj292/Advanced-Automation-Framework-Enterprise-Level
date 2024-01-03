package org.opencart.utilities;

/**
 * DynamicLocatorUtility class contains methods that return String value of
 * locators.
 * 
 * @author Shriraj Ghorpade
 */
public final class DynamicLocatorUtility {

	private DynamicLocatorUtility() {
	}

	/**
	 * This method accepts generic xpath string and one replacement string which
	 * replaces the replaceable part of main xpath string and valid xpath string is
	 * returned.
	 * 
	 * @param main        - generic xpath string with replaceable key
	 * @param replacement - string value that will replace replaceable key
	 * @return valid xpath
	 */
	public static String getXpath(String main, String replacement) {
		return String.format(main, replacement);
	}

	/**
	 * This method accepts generic xpath string and two replacement string which
	 * replaces the replaceable part of main xpath string and valid xpath string is
	 * returned.
	 * 
	 * @param main         - generic xpath string with replaceable key
	 * @param replacement1 - string value that will replace replaceable key
	 * @param replacement2 - string value that will replace replaceable key
	 * @return
	 */
	public static String getXpath(String main, String replacement1, String replacement2) {
		return String.format(main, replacement1, replacement2);
	}
}
