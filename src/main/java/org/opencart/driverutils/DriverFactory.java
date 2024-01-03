package org.opencart.driverutils;

import java.net.MalformedURLException;
import java.net.URL;

import org.opencart.enums.ConfigProperties;
import org.opencart.exceptions.InvalidBrowserException;
import org.opencart.utilities.PropertyUtilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * This class is a driver factory.
 * 
 * @author Shriraj Ghorpade
 * @see {@link Driver}
 */
public final class DriverFactory {

	private DriverFactory() {
	}

	/**
	 * This method checks testmode (local/remote) and initializes driver based on
	 * testmode, browser and version.
	 * 
	 * @param browser - browser name
	 * @param version - browser version
	 * @return
	 * @throws MalformedURLException
	 */
	public static WebDriver getDriver(String browser, String version) throws MalformedURLException {
		String testMode = PropertyUtilities.getPropertyValue(ConfigProperties.TESTMODE);
		DesiredCapabilities cap = new DesiredCapabilities();
		WebDriver driver = null;

		if (testMode.equalsIgnoreCase("remote")) {
			switch (browser.toLowerCase()) {
			case "chrome": {
				cap.setBrowserName("chrome");
				cap.setVersion(version);
				break;
			}

			case "firefox": {
				cap.setBrowserName("firefox");
				cap.setVersion(version);
				break;
			}

			case "MicrosoftEdge": {
				cap.setBrowserName("MicrosoftEdge");
				cap.setVersion(version);
				break;
			}

			default: {
				throw new InvalidBrowserException("Invalid browser value. Please check TestData.xlsx file.");
			}

			}

			driver = new RemoteWebDriver(new URL(PropertyUtilities.getPropertyValue(ConfigProperties.REMOTEURL)), cap);

		} else if (testMode.equalsIgnoreCase("local")) {
			switch (browser.toLowerCase()) {
			case "chrome": {
				driver = new ChromeDriver();
				break;
			}

			case "firefox": {
				driver = new FirefoxDriver();
				break;
			}

			case "MicrosoftEdge": {
				driver = new EdgeDriver();
				break;
			}

			default: {
				throw new InvalidBrowserException("Invalid browser value. Please check TestData.xlsx file.");
			}
			}
		}

		return driver;
	}
}
