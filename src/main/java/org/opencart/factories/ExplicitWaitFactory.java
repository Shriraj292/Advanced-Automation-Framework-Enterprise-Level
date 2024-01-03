package org.opencart.factories;

import org.opencart.driverutils.DriverManager;
import org.opencart.enums.WaitStrategies;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * ExplicitWaitFactory is wait factory class which implements explicit wait.
 * 
 * @author Shriraj Ghorpade
 */
public final class ExplicitWaitFactory {

	private ExplicitWaitFactory() {
	}

	/**
	 * This method accepts wait strategy and By locator for the element. Based on
	 * the wait strategy, wait is applied for given time and returns web element.
	 * 
	 * @param strategy - wait strategy as per declared in
	 *                 {@link org.opencart.enums.WaitStrategies}
	 * @param by       - locator value for element
	 * @return WebElement
	 */
	public static WebElement explicitlyWaitFor(WaitStrategies strategy, By by) {
		WebElement element = null;
		switch (strategy) {
		case PRESENCE_OF: {
			element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(20))
					.until(ExpectedConditions.presenceOfElementLocated(by));
		}
		case VISIBILITY_OF: {
			element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(20))
					.until(ExpectedConditions.visibilityOfElementLocated(by));
		}
		case CLICKABILITY_OF: {
			element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(20))
					.until(ExpectedConditions.elementToBeClickable(by));
		}
		case NONE: {
			element = DriverManager.getDriver().findElement(by);
		}

		}

		return element;
	}
}
