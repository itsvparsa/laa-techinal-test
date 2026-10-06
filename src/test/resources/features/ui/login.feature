@ui @login
Feature: Login to Swag Labs

  As a registered user,
  I want to log in to the swag lags using username and password,
  so that I can securely access swag labs site.

  Scenario: Login to swag labs site and verify the user successfully logged in
    Given the user navigated to the swag labs login page
    When the user enter valid login credentials
    And the user should see page title 'Swag Labs'
    Then the user should be successfully logged in

  Scenario: Login to swag labs site with invalid credentials and check error message is generated
    Given the user navigated to the swag labs login page
    When the user enter credentials as 'incorrect_username' 'incorrect_password'
    Then the user should see error message generated

