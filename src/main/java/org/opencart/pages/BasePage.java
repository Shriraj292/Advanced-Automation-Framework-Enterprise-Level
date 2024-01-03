package org.opencart.pages;

import org.opencart.driverutils.DriverManager;
import org.opencart.enums.WaitStrategies;
import org.opencart.factories.ExplicitWaitFactory;
import org.opencart.reports.ExtentLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * BasePage class acts as a parent class for all the page classes in this
 * framework. All the page classes needs to extend this class.
 * 
 * @author Shriraj Ghorpade
 */
public abstract class BasePage {

	protected BasePage() {
	}

	public abstract String getPageTitle();

	/**
	 * This method waits for the element and clicks on it.
	 * 
	 * @param by                 - locator of web element
	 * @param elementName        - element name for reporting
	 * @param isScreenshotNeeded - boolean value: true is screenshots is needed else
	 *                           false
	 */
	protected void click(By by, String elementName, boolean isScreenshotNeeded) {
		WebElement element = ExplicitWaitFactory.explicitlyWaitFor(WaitStrategies.CLICKABILITY_OF, by);
		element.click();
		ExtentLogger.pass(elementName + " field clicked successfully.", isScreenshotNeeded);
	}

	/**
	 * This method waits for the element and enters text in that web element (mostly
	 * text field).
	 * 
	 * @param by                 - locator of web element
	 * @param text               - string value of text to be entered
	 * @param elementName        - element name for reporting
	 * @param isScreenshotNeeded - boolean value: true is screenshots is needed else
	 *                           false
	 */
	protected void enterText(By by, String text, String elementName, boolean isScreenshotNeeded) {
		WebElement element = ExplicitWaitFactory.explicitlyWaitFor(WaitStrategies.VISIBILITY_OF, by);
		element.sendKeys(text);
		if (!text.isEmpty()) {
			ExtentLogger.pass("text: " + text + " entered in " + elementName + " field successfully.",
					isScreenshotNeeded);
		} else {
			ExtentLogger.pass(elementName + " field is kept empty.", isScreenshotNeeded);
		}
	}

	/**
	 * This method waits for the element and hovers mouse over that web element.
	 * 
	 * @param by                 - locator of web element
	 * @param elementName        - element name for reporting
	 * @param isScreenshotNeeded - boolean value: true is screenshots is needed else
	 *                           false
	 */
	protected void hoverOver(By by, String elementName, boolean isScreenshotNeeded) {
		WebElement element = ExplicitWaitFactory.explicitlyWaitFor(WaitStrategies.VISIBILITY_OF, by);
		Actions act = new Actions(DriverManager.getDriver());
		act.moveToElement(element);
		ExtentLogger.pass("hovered mouse over " + elementName + " succefully.", isScreenshotNeeded);
	}
}
