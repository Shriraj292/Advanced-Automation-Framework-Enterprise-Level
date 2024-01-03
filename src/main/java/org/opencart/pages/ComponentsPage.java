package org.opencart.pages;

import org.opencart.driverutils.DriverManager;

public final class ComponentsPage extends BasePage {
	public ComponentsPage() {
	}

	@Override
	public String getPageTitle() {
		return DriverManager.getDriver().getTitle();
	}
}
