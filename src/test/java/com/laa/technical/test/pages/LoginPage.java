package com.laa.technical.test.pages;

import com.laa.technical.test.utils.ConfigLoader;
import com.laa.technical.test.utils.DriverUtils;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private final WebDriver driver;
    String swagLabsLoginUrl = ConfigLoader.getProperty("swaglabs.properties", "swag.labs.url");

    public LoginPage() {
        this.driver = DriverUtils.getDriver();
    }

    private final By usernameInput = By.id("user-name");
    private final By passwordInput = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessage = By.cssSelector("[data-test='error']");

    public void navigateToUrl() {
        driver.get(swagLabsLoginUrl);
        System.out.println("Requested Login URL:" + swagLabsLoginUrl);
        Allure.addAttachment("Requested Login URL: ", swagLabsLoginUrl);
    }

    public void loginToSwagLabs() {
        String username = ConfigLoader.getProperty("swaglabs.properties", "user.email");
        String password = ConfigLoader.getProperty("swaglabs.properties", "user.password");
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }

    public void enterUsername(String username) {
        driver.findElement(usernameInput).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }
}