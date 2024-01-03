package org.opencart.pages;

import org.opencart.driverutils.DriverManager;

public final class DesktopsPage extends BasePage {
	public DesktopsPage() {
	}

	@Override
	public String getPageTitle() {
		return DriverManager.getDriver().getTitle();
	}
}
