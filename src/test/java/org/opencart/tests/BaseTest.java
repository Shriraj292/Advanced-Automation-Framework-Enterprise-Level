package org.opencart.tests;

import java.util.Map;

import org.opencart.driverutils.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected BaseTest() {}

    @BeforeMethod
    public void setup(Object[] data){
    	@SuppressWarnings("unchecked")
		Map<String, String> map = (Map<String, String>) data[0];
    	String browser = map.get("browser");
		Driver.initializeDriver(browser);
    }

    @AfterMethod
    public void teardown(){
        Driver.quitDriver();
    }
}
