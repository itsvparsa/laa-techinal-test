package com.laa.technical.test.steps.api;

import com.laa.technical.test.utils.PayloadUtils;
import com.laa.technical.test.utils.RestAssuredUtils;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class petStoreSteps {

    Response response;
    int petId = ThreadLocalRandom.current().nextInt(100, 1000);

    @Given("I send POST request to {string}")
    public void createPet(String endpoint) {
        String requestBody = PayloadUtils.getRequestBody("create_pet.json", Map.of("pet_id", petId));
        response = RestAssuredUtils.post(requestBody, endpoint);
    }

    @And("I should see {int} response code")
    public void iShouldSeeResponseCode(int expectedStatusCode) {
        assertThat(response.statusCode(), equalTo(expectedStatusCode));
    }

    @Then("the pet should be created successfully")
    public void thePetShouldBeCreatedSuccessfully() {
        response.then()
                .body("id", equalTo(petId))
                .body("name", equalTo("happy_dog"))
                .body("status", equalTo("available"));
    }

    @Given("I send GET request to {string}")
    public void getPet(String endpoint) {
        String finalEndpoint = endpoint.replace("{petId}", String.valueOf(petId));
        response = RestAssuredUtils.get(finalEndpoint);
    }

    @Then("Pet details are loaded successfully")
    public void petDetailsAreLoadedSuccessfully() {
        response.then()
                .body("id", equalTo(petId))
                .body("name", equalTo("happy_dog"))
                .body("status", equalTo("available"));
    }

    @When("I send DELETE request to {string}")
    public void deletePet(String endpoint) {
        String finalEndpoint = endpoint.replace("{petId}", String.valueOf(petId));
        response = RestAssuredUtils.delete(finalEndpoint);
    }
}
