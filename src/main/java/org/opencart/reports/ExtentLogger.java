package org.opencart.reports;

import org.opencart.utilities.ScreenshotUtils;

import com.aventstack.extentreports.MediaEntityBuilder;

/**
 * ExtentLogger class is responsible for logging the test steps in extent
 * report.
 * 
 * @author Shriraj Ghorpade
 */
public class ExtentLogger {

	private static void pass(String message) {
		ExtentReportManager.getExtTest().pass(message);
	}

	private static void fail(String message) {
		ExtentReportManager.getExtTest().fail(message);
	}

	private static void skip(String message) {
		ExtentReportManager.getExtTest().skip(message);
	}

	public static void pass(String message, boolean isScreenshotNeeded) {
		if (isScreenshotNeeded == true) {
			ExtentReportManager.getExtTest().pass(message, MediaEntityBuilder
					.createScreenCaptureFromBase64String(ScreenshotUtils.getScreenshotPath()).build());
		} else {
			pass(message);
		}
	}

	public static void fail(String message, boolean isScreenshotNeeded) {
		if (isScreenshotNeeded == true) {
			ExtentReportManager.getExtTest().fail(message, MediaEntityBuilder
					.createScreenCaptureFromBase64String(ScreenshotUtils.getScreenshotPath()).build());
		} else {
			fail(message);
		}
	}

	public static void skip(String message, boolean isScreenshotNeeded) {
		if (isScreenshotNeeded == true) {
			ExtentReportManager.getExtTest().skip(message, MediaEntityBuilder
					.createScreenCaptureFromBase64String(ScreenshotUtils.getScreenshotPath()).build());
		} else {
			skip(message);
		}
	}
}
