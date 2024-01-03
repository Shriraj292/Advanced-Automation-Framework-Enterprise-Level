package org.opencart.driverutils;

import org.openqa.selenium.WebDriver;

/**
 * This class is responsible for driver safety.
 * 
 * @author Shriraj Ghorpade
 * @see {@link Driver}
 */
public final class DriverManager {

	private DriverManager() {
	}

	private static ThreadLocal<WebDriver> threadSafe_Dr = new ThreadLocal<>();

	/**
	 * This method sets driver instance to ThreadLocal.
	 * 
	 * @param driverRef
	 */
	public static void setDriver(WebDriver driverRef) {
		threadSafe_Dr.set(driverRef);
	}

	/**
	 * This method returns ThreadLocal driver.
	 * 
	 * @return
	 */
	public static WebDriver getDriver() {
		return threadSafe_Dr.get();
	}

	/**
	 * This method removes driver instance from ThreadLocal.
	 */
	public static void unload() {
		threadSafe_Dr.remove();
	}
}
