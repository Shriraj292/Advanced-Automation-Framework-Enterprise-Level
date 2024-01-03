package org.opencart.pages;

import org.opencart.driverutils.DriverManager;

public final class MP3_PlayersPage extends BasePage {
	public MP3_PlayersPage() {
	}

	@Override
	public String getPageTitle() {
		return DriverManager.getDriver().getTitle();
	}
}
