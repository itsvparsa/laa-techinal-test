@ui @login
Feature: Login to Swag Labs

  As a registered user,
  I want to log in to the swag lags using credentials,
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


#. Additional Scenarios:

#  Scenario: End to checkout process
#  Scenario: Checkout process with multiple items
#  Scenario: Updating the basket and see Price is getting updated based on the updates
#  Scenario: Adding to the basket and Removing and see the basket is empty
#  Scenario: Verify product details
#  Scenario: Verify the different types of the sorting
#  Scenario: Verify the other menu items

