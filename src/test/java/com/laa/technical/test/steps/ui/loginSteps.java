package com.laa.technical.test.steps.ui;

import com.laa.technical.test.pages.InventoryPage;
import com.laa.technical.test.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class loginSteps {

    private final LoginPage loginPage = new LoginPage();
    private final InventoryPage inventoryPage = new InventoryPage();

    @Given("the user navigated to the swag labs login page")
    public void loginToSwagLabsPage() {
        loginPage.navigateToUrl();
    }

    @When("the user enter valid login credentials")
    public void enterCredentials() {
        loginPage.loginToSwagLabs();
    }

    @And("the user should see page title {string}")
    public void verifyPageTitle(String expectedTitle) {
        String actualTitle = inventoryPage.getPageTitle();
        assertThat("Page title is incorrect", actualTitle, is(expectedTitle));
    }

    @Then("the user should be successfully logged in")
    public void theUserShouldBeSuccessfullyLoggedIn() {
        assertThat("User should be logged in successfully",
                inventoryPage.getPageHeading(),
                is("Products")
        );
    }

    @When("the user enter credentials as {string} {string}")
    public void enterCredentials(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
    }

    @Then("the user should see error message generated")
    public void errorMessageGenerated() {
        assertThat(loginPage.getErrorMessage(), containsString("Username and password do not match any user in this service"));
    }
}
