package com.laa.technical.test.utils;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

public class DriverUtils {

    private static WebDriver driver;

    private DriverUtils() {
    }

    public static void initDriver() {
        String browser = System.getProperty("browser", "chrome");
        driver = DriverFactory.createDriver(browser);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            throw new IllegalStateException("Driver is not initialized. Call initDriver() first.");
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}