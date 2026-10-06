@api @pet_store
Feature: Pet store operations

  As a pet store API access user,
  I wanted to access all the endpoints of Create, Fetch, Update, Delete operations of the pet store,
  so I can create and amend the data

  @create_pet
  Scenario: Create a pet and get details
    Given I send POST request to '/pet'
    And I should see 200 response code
    Then the pet should be created successfully
    When I send GET request to '/pet/{petId}'
    And I should see 200 response code
    Then Pet details are loaded successfully

  @delete_pet
  Scenario: Create a pet and delete it after creation
    Given I send POST request to '/pet'
    And I should see 200 response code
    Then the pet should be created successfully
    When I send DELETE request to '/pet/{petId}'
    And I should see 200 response code
    When I send GET request to '/pet/{petId}'
    Then I should see 404 response code