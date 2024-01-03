package org.opencart.pages;

import org.opencart.driverutils.DriverManager;
import org.opencart.enums.WaitStrategies;
import org.opencart.factories.ExplicitWaitFactory;
import org.openqa.selenium.By;
import org.testng.Assert;

public final class RegisterAccountPage extends BasePage {

	public RegisterAccountPage() {
	}

	private static final By txt_FirstName = By.id("input-firstname");
	private static final By txt_LastName = By.id("input-lastname");
	private static final By txt_Email = By.id("input-email");
	private static final By txt_Telephone = By.id("input-telephone");
	private static final By txt_Password = By.id("input-password");
	private static final By txt_ConfirmPassword = By.id("input-confirm");
	private static final By radio_No = By
			.xpath("//div[@class='form-group']/descendant::input[@type='radio' and @value='0']");
	private static final By radio_Yes = By
			.xpath("//div[@class='form-group']/descendant::input[@type='radio' and @value='1']");
	private static final By chkBox_AgreePolicy = By.name("agree");
	private static final By btn_Continue = By.xpath("//input[@value='Continue']");
	private static final By text_SuccessMessage = By.xpath("//div[@id='content']/h1");
	private static final By btn_AfterRegistrationContinue = By.xpath("//a[text()='Continue']");

	@Override
	public String getPageTitle() {
		return DriverManager.getDriver().getTitle();
	}

	public RegisterAccountPage enterRegistrationDetailsAndContinue(String firstName, String lastName, String email,
			String telephone, String password) {
		enterText(txt_FirstName, firstName, "first name textbox", false);
		enterText(txt_LastName, lastName, "last name textbox", false);
		enterText(txt_Email, email, "email textbox", false);
		enterText(txt_Telephone, telephone, "telephone textbox", false);
		enterText(txt_Password, password, "password textbox", false);
		enterText(txt_ConfirmPassword, password, "confirm password textbox", false);
		click(radio_Yes, "yes radio button", false);
		click(chkBox_AgreePolicy, "privacy policy checkbox", true);
		click(btn_Continue, "continue button", true);
		return this;
	}

	public RegisterAccountPage verifyRegistrationStatus() {
		String successMessage = ExplicitWaitFactory.explicitlyWaitFor(WaitStrategies.VISIBILITY_OF, text_SuccessMessage)
				.getText();
		Assert.assertEquals(successMessage, "Your Account Has Been Created!", "Registration failed.");
		return this;
	}

	public MyAccountPage clickOnContinue() {
		click(btn_AfterRegistrationContinue, "continue button", true);
		return new MyAccountPage();
	}

}
