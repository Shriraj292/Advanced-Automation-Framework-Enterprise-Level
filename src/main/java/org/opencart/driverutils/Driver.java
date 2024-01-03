package org.opencart.driverutils;

import java.net.MalformedURLException;
import java.util.Objects;

import org.opencart.enums.ConfigProperties;
import org.opencart.exceptions.BrowserInitializationFailedException;
import org.opencart.utilities.PropertyUtilities;
import org.openqa.selenium.WebDriver;

/**
 * Driver class is responsible for driver invocation and quitting.
 * 
 * @author Shriraj Ghorpade
 * @see {@link DriverManager}
 * @see {@link DriverFactory}
 */
public final class Driver {

	private Driver() {
	}

	/**
	 * This method is responsible for driver initialization and making driver thread
	 * safe.
	 * 
	 * @param browser - browser name
	 * @param version - browser version
	 */
	public static void initializeDriver(String browser, String version) {
		if (Objects.isNull(DriverManager.getDriver())) {
			WebDriver driver;
			try {
				driver = DriverFactory.getDriver(browser, version);
			} catch (MalformedURLException e) {
				throw new BrowserInitializationFailedException(
						"Browser initialization failed due to some reason. (Browser version can be one of the possible cause. Please check browser version in excel file.)",
						e);
			}
			DriverManager.setDriver(driver);
			DriverManager.getDriver().manage().window().maximize();
			DriverManager.getDriver().get(PropertyUtilities.getPropertyValue(ConfigProperties.APPLICATIONURL));
		}
	}

	/**
	 * This method is responsible for quitting driver and removing driver instance
	 * from Threadlocal.
	 */
	public static void quitDriver() {
		if (Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}
}
