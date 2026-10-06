package com.laa.technical.test.utils;

import io.qameta.allure.Allure;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RestAssuredUtils {

    static String baseUrl = ConfigLoader.getProperty("petstore.properties", "petstore.base.url");

    public static Response post(String requestBody, String endpoint) {
        Response response = given()
                .baseUri(baseUrl)
                .contentType("application/json")
                .body(requestBody)
                .when()
                .log().all()
                .post(endpoint)
                .then()
                .extract()
                .response();

        Allure.addAttachment("Request Body", requestBody);
        Allure.addAttachment("Response", response.prettyPrint());

        return response;
    }

    public static Response get(String endpoint) {
        return given()
                .baseUri(baseUrl)
                .when()
                .get(endpoint)
                .then()
                .extract()
                .response();
    }

    public static Response delete(String endpoint) {
        return given()
                .baseUri(baseUrl)
                .when()
                .delete(endpoint)
                .then()
                .extract()
                .response();
    }
}
