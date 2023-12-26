package org.opencart.pages;

import org.opencart.driverutils.DriverManager;
import org.opencart.enums.WaitStrategies;
import org.opencart.factories.ExplicitWaitFactory;
import org.opencart.reports.ExtentLogger;
import org.opencart.reports.ExtentReportManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public abstract class BasePage {

    protected BasePage(){}

    public abstract String getPageTitle();

    protected void click(By by, String elementName, boolean isScreenshotNeeded){
        WebElement element = ExplicitWaitFactory.explicitlyWaitFor(WaitStrategies.CLICKABILITY_OF, by);
        element.click();
        ExtentLogger.pass(elementName + " field clicked successfully.", isScreenshotNeeded);
    }

    protected void enterText(By by, String text, String elementName, boolean isScreenshotNeeded){
        WebElement element = ExplicitWaitFactory.explicitlyWaitFor(WaitStrategies.VISIBILITY_OF, by);
        element.sendKeys(text);
        if (!text.isEmpty()) {
        	ExtentLogger.pass("text: " + text + " entered in " 
        	        + elementName + " field successfully.", isScreenshotNeeded);
		}else {
			ExtentLogger.pass( elementName + " field is kept empty.", isScreenshotNeeded);
		}
    }

    protected void hoverOver(By by, String elementName, boolean isScreenshotNeeded){
        WebElement element = ExplicitWaitFactory.explicitlyWaitFor(WaitStrategies.VISIBILITY_OF,by);
        Actions act = new Actions(DriverManager.getDriver());
        act.moveToElement(element);
        ExtentLogger.pass("hovered mouse over " + elementName + " succefully.", isScreenshotNeeded);
    }
}
