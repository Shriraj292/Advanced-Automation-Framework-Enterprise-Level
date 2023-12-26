package org.opencart.driverutils;

import org.openqa.selenium.WebDriver;

public final class DriverManager {

    private DriverManager(){}

    private static ThreadLocal<WebDriver> threadSafe_Dr = new ThreadLocal<>();

    public static void setDriver(WebDriver driverRef){
        threadSafe_Dr.set(driverRef);
    }

    public static WebDriver getDriver(){
        return threadSafe_Dr.get();
    }

    public static void unload(){
        threadSafe_Dr.remove();
    }
}
