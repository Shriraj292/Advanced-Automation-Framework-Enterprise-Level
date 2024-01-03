package org.opencart.reports;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentReportManager {

	private ExtentReportManager() {
	}

	private static ThreadLocal<ExtentTest> extTest = new ThreadLocal<ExtentTest>();

	static ExtentTest getExtTest() {
		return extTest.get();
	}

	static void setExtTest(ExtentTest test) {
		extTest.set(test);
	}

	static void unload() {
		extTest.remove();
	}
}
