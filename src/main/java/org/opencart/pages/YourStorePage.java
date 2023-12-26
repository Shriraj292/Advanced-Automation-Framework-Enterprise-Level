package org.opencart.pages;

import org.opencart.driverutils.DriverManager;
import org.opencart.pagelevelconstants.YourStorePage_Constants;
import org.opencart.utilities.DynamicLocatorUtility;
import org.openqa.selenium.By;

public final class YourStorePage extends BasePage {

	public YourStorePage() {
	}

	// Dynamic Locator Strings
	private static final String topLinks_generic = "//div[@id='top-links']/descendant::span[contains(text(),'%s')]";
	private static final String menuNavBar = "//ul[@class='nav navbar-nav']/li[@class='dropdown']/a[text()='%s']";
	private static final String menuDropDown = menuNavBar
			+ "/parent::li/div[@class='dropdown-menu']/descendant::a[contains(text(),'%s')]";

	// Locators
	private static final By link_Register = By.xpath("//div[@id='top-links']/descendant::a[text()='Register']");
	private static final By link_Login = By.xpath("//div[@id='top-links']/descendant::a[text()='Login']");
	private static final By txt_SearchBar = By.name("search");
	private static final By btn_Search = By.xpath("//i[@class='fa fa-search']/parent::button");
	private static final By btn_Currency = By.xpath("//button/span[text()='Currency']");

	@Override
	public String getPageTitle() {
		return DriverManager.getDriver().getTitle();
	}

	public YourStorePage clickOnTopLink(YourStorePage_Constants topLinkName) {
		click(By.xpath(DynamicLocatorUtility.getXpath(topLinks_generic, topLinkName.getValue())),
				"top-link " + topLinkName.getValue(), true);
		return this;
	}

	public RegisterAccountPage clickOnRegister() {
		click(link_Register, "register link", true);
		return new RegisterAccountPage();
	}

	public AccountLoginPage clickOnLogin() {
		click(link_Login, "login link", true);
		return new AccountLoginPage();
	}

	public YourStorePage searchProduct(String searchText) {
		enterText(txt_SearchBar, searchText, "search textbox", true);
		click(btn_Search, "search button", true);
		return this;
	}

	public Object hoverOverMenu_And_clickOnSubMenu(YourStorePage_Constants menu, YourStorePage_Constants subMenu) {
		hoverOver(By.xpath(DynamicLocatorUtility.getXpath(menuNavBar, menu.getValue())),"navigation bar menu: " + menu.getValue(), true);
		click(By.xpath(DynamicLocatorUtility.getXpath(menuDropDown, menu.getValue(), subMenu.getValue())), "submenu: ", true);

		Object targetPageObj = null;
		switch (subMenu.getValue().toLowerCase()) {
		case "desktops": {
			targetPageObj = new DesktopsPage();
		}
		case "laptops & notebooks": {
			targetPageObj = new Laptops_NotebooksPage();
		}
		case "components": {
			targetPageObj = new ComponentsPage();
		}
		case "mp3 players": {
			targetPageObj = new MP3_PlayersPage();
		}
		}
		return targetPageObj;
	}

}
