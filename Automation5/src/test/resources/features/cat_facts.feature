Feature: Get Random Cat Facts
  As a user
  I want to know a random cat fact
  So that I can learn something new about these adorable animals

  @CatFacts
  Scenario Outline: Get a Random Cat Fact
    Given the user is on the "https://catfact.ninja/" in page
    When I make a GET request to "<fact>"
    Then the server should respond with a status code of 200 (OK)
    And the response body should contain a cat fact

Examples:
    |fact|
    |fact|
