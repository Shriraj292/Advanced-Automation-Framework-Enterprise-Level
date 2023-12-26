package org.opencart.pages;

import org.opencart.driverutils.DriverManager;
import org.opencart.enums.WaitStrategies;
import org.opencart.factories.ExplicitWaitFactory;
import org.opencart.utilities.DynamicLocatorUtility;
import org.openqa.selenium.By;
import org.testng.Assert;

public final class MyAccountPage extends BasePage{
    public MyAccountPage(){}

    //Dynamic Locator Strings
    private static final String links_generic = "//div[@class='list-group']/a[text()='%s']";

    //Locators
    private static final By text_LogoutMessage = By.xpath("//div[@id='content']/h1");
    private static final By link_Continue = By.xpath("//a[text()='Continue']");

    @Override
    public String getPageTitle() {
        return DriverManager.getDriver().getTitle();
    }

    public MyAccountPage clickOnLogout(){
        click(By.xpath(DynamicLocatorUtility.getXpath(links_generic, "Logout")), 
        		"logout button", true);
        return this;
    }

    public MyAccountPage verifyLogoutSuccess(){
        String logoutMessage = ExplicitWaitFactory.explicitlyWaitFor(WaitStrategies.VISIBILITY_OF,
                text_LogoutMessage).getText();
        Assert.assertEquals(logoutMessage, "Account Logout");
        return this;
    }

    public YourStorePage clickOnContinue(){
        click(link_Continue, "continue button", true);
        return new YourStorePage();
    }
}
