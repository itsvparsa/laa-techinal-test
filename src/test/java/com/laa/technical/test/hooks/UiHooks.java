package com.laa.technical.test.hooks;

import com.laa.technical.test.utils.DriverUtils;
import io.cucumber.java.*;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class UiHooks {

    @Before("@ui")
    public void setUp() {
        DriverUtils.initDriver();
        System.out.println("******* Launching browser*********");
        System.out.println("******* Driver in Before: " + DriverUtils.getDriver() + "*************");
    }

    @After("@ui")
    public void tearDown(Scenario scenario) {
        System.out.println("********* Driver in hook:(tearDown)  " + DriverUtils.getDriver());
        Allure.step("********* Driver in hook:(tearDown)  " + DriverUtils.getDriver());

        WebDriver driver = DriverUtils.getDriver();

        try {
            if (scenario.isFailed() && driver != null) {
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "Failed Step Screenshot");
                String currentUrl = driver.getCurrentUrl();
                assert currentUrl != null;
                Allure.addAttachment("Current URL", currentUrl);
            }
        } catch (Exception e) {
            System.out.println("Error during failure capture: " + e.getMessage());
        } finally {
            if (driver != null) {
                driver.quit();
            }
            System.out.println("*******Closing browser*********");
        }
    }

}