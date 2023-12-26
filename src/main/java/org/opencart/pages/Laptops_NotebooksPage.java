package org.opencart.pages;

import org.opencart.driverutils.DriverManager;

public final class Laptops_NotebooksPage extends BasePage{
    public Laptops_NotebooksPage(){}

    @Override
    public String getPageTitle() {
        return DriverManager.getDriver().getTitle();
    }
}
