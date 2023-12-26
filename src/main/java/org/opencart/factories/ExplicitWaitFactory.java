package org.opencart.factories;

import org.opencart.driverutils.DriverManager;
import org.opencart.enums.WaitStrategies;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public final class ExplicitWaitFactory {

    private ExplicitWaitFactory() {}

    public static WebElement explicitlyWaitFor(WaitStrategies strategy, By by){
        WebElement element = null;
        switch (strategy){
            case PRESENCE_OF:
            {
                element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(20))
                        .until(ExpectedConditions.presenceOfElementLocated(by));
            }
            case VISIBILITY_OF:
            {
                element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(20))
                        .until(ExpectedConditions.visibilityOfElementLocated(by));
            }
            case CLICKABILITY_OF:
            {
                element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(20))
                        .until(ExpectedConditions.elementToBeClickable(by));
            }
            case NONE:
            {
                element = DriverManager.getDriver().findElement(by);
            }

        }

        return element;
    }
}
