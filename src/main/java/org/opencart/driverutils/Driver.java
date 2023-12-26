package org.opencart.driverutils;

import java.util.Objects;

import org.opencart.enums.ConfigProperties;
import org.opencart.utilities.PropertyUtilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public final class Driver {

    private Driver() {}

    public static void initializeDriver(String browser){
       if (Objects.isNull(DriverManager.getDriver())){
    	   WebDriver driver = null;
    	   
    	   if (browser.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();
			}else if (browser.equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();
			}else if (browser.equalsIgnoreCase("msedge")){
				driver = new EdgeDriver();
			}
    	   
    	   DriverManager.setDriver(driver);
           DriverManager.getDriver().manage().window().maximize();
           DriverManager.getDriver().get(PropertyUtilities.getPropertyValue(ConfigProperties.URL));
       }
    }

    public static void quitDriver(){
        if (Objects.nonNull(DriverManager.getDriver())){
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }
}
