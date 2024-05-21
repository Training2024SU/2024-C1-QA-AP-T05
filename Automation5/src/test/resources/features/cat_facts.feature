Feature: Get Random Cat Facts
  As a user
  I want to know a random cat fact
  So that I can learn something new about these adorable animals

  @CatFacts
  Scenario: Get a Random Cat Fact
    Given I want to know a random cat fact
    When I make a GET request to "https://catfact.ninja/fact"
    Then the server should respond with a status code of 200 (OK)
    And the response body should contain a cat fact

