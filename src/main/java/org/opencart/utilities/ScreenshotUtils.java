package org.opencart.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.opencart.constants.FrameworkConstants;
import org.opencart.driverutils.DriverManager;
import org.opencart.reports.ReportsManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

/**
 * ScreenshotUtils class is responsible for capturing the screenshot and storing
 * in screenshots folder in test reports.
 * 
 * @author Shriraj Ghorpade
 */
public final class ScreenshotUtils {

	private ScreenshotUtils() {
	}

	/**
	 * This method captures the screenshot wherever called and returns BASE64 value of the
	 * screenshot.
	 * 
	 * @return BASE64 string value of screenshot.
	 */
	public static String getScreenshotPath() {
		TakesScreenshot ts = (TakesScreenshot) (DriverManager.getDriver());
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		String screenshot = ts.getScreenshotAs(OutputType.BASE64);
		File destFile = new File(
				FrameworkConstants.getScreenshotsFolderPath() + "/" + ReportsManager.getTimeStamp() + ".png");
		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return screenshot;
	}
}
