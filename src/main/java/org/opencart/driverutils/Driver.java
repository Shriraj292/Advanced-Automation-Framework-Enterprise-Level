package org.opencart.driverutils;

import java.net.MalformedURLException;
import java.util.Objects;

import org.opencart.enums.ConfigProperties;
import org.opencart.utilities.PropertyUtilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public final class Driver {

	private Driver() {
	}

	public static void initializeDriver(String browser, String version) {
		if (Objects.isNull(DriverManager.getDriver())) {
			WebDriver driver;
			try {
				driver = DriverFactory.getDriver(browser, version);
			} catch (MalformedURLException e) {
				throw new RuntimeException("Browser initialization failed.");
			}
			DriverManager.setDriver(driver);
			DriverManager.getDriver().manage().window().maximize();
			DriverManager.getDriver().get(PropertyUtilities.getPropertyValue(ConfigProperties.URL));
		}
	}

	public static void quitDriver() {
		if (Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}
}
