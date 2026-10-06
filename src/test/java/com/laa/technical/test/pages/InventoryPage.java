package com.laa.technical.test.pages;

import com.laa.technical.test.utils.DriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {

    private final WebDriver driver;

    public InventoryPage() {
        this.driver = DriverUtils.getDriver();
    }

    private final By productsTitle = By.cssSelector(".title");

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getPageHeading() {
        return driver.findElement(productsTitle).getText();
    }

}
