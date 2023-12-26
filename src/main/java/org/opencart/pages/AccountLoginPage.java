package org.opencart.pages;

import org.opencart.driverutils.DriverManager;
import org.openqa.selenium.By;

public final class AccountLoginPage extends BasePage{

    public AccountLoginPage(){}

    @Override
    public String getPageTitle() {
        return DriverManager.getDriver().getTitle();
    }

    private static final By txt_Email = By.id("input-email");
    private static final By txt_Password = By.id("input-password");
    private static final By btn_Login = By.xpath("//input[@value='Login']");
    private static final By link_Continue = By.xpath("//a[text()='Continue']");

    public AccountLoginPage enterCredentials(String email, String password){
        enterText(txt_Email, email, "email text box", true);
        enterText(txt_Password, password, "password text box", true);
        return this;
    }

    public MyAccountPage clickOnLogin(){
        click(btn_Login, "login button", true);
        return new MyAccountPage();
    }
}
