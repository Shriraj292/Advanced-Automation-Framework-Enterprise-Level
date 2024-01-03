package org.opencart.utilities;

public final class DynamicLocatorUtility {

	private DynamicLocatorUtility() {
	}

	public static String getXpath(String main, String replacement) {
		return String.format(main, replacement);
	}

	public static String getXpath(String main, String replacement1, String replacement2) {
		return String.format(main, replacement1, replacement2);
	}
}
