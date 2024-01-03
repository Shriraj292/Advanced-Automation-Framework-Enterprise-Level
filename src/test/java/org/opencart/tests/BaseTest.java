package org.opencart.tests;

import java.util.Map;

import org.opencart.driverutils.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * BaseTest acts as a parent class for all the test classes in this framework.
 * All the test classes needs to extend this class. This class is responsible
 * for invoking and terminating browser under test.
 * 
 * @author Shriraj Ghorpade
 */
public class BaseTest {

	protected BaseTest() {
	}

	/**
	 * This method invokes browser.
	 * 
	 * @param data - test data passed as argument to test method
	 */
	@BeforeMethod
	public void setup(Object[] data) {
		@SuppressWarnings("unchecked")
		Map<String, String> map = (Map<String, String>) data[0];
		String browser = map.get("browser");
		String version = map.get("version");
		Driver.initializeDriver(browser, version);
	}

	/**
	 * This method quits browser.
	 */
	@AfterMethod
	public void teardown() {
		Driver.quitDriver();
	}
}
