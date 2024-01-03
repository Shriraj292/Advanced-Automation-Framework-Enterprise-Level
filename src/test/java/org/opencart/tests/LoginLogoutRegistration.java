package org.opencart.tests;

import java.util.Map;

import org.opencart.pagelevelconstants.YourStorePage_Constants;
import org.opencart.pages.MyAccountPage;
import org.opencart.pages.YourStorePage;
import org.opencart.utilities.DataProviderUtilities;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * This is a sample test class. All test classes should extend {@link BaseTest}.
 * All the methods mentioned in the test classes should follow same method
 * signature as mentioned in this class.
 * 
 * @author Shriraj Ghorpade
 * @see {@link BaseTest}
 */
public class LoginLogoutRegistration extends BaseTest {
	private LoginLogoutRegistration() {
	}

	@Test(dataProvider = "dataSupplier", dataProviderClass = DataProviderUtilities.class)
	public void loginLogoutTest(Map<String, String> map) {
		String pageTitle = new YourStorePage().clickOnTopLink(YourStorePage_Constants.MY_ACCOUNT).clickOnLogin()
				.enterCredentials(map.get("email"), map.get("password")).clickOnLogin().getPageTitle();
		Assert.assertEquals(pageTitle, "My Account", "Login unsuccessful. Please check credentials.");
		String actualPage = new MyAccountPage().clickOnLogout().verifyLogoutSuccess().clickOnContinue().getPageTitle();
		Assert.assertEquals(actualPage, "Your Store");
	}

	@Test(dataProvider = "dataSupplier", dataProviderClass = DataProviderUtilities.class)
	public void registrationTest(Map<String, String> map) {
		new YourStorePage().clickOnTopLink(YourStorePage_Constants.MY_ACCOUNT).clickOnRegister()
				.enterRegistrationDetailsAndContinue(map.get("firstname"), map.get("lastname"), map.get("email"),
						map.get("telephone"), map.get("password"))
				.verifyRegistrationStatus().clickOnContinue();
		String actualPageTitle = new MyAccountPage().getPageTitle();
		Assert.assertEquals(actualPageTitle, "My Account");
	}
}
