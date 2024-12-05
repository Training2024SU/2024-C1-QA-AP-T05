Feature: Predict Age Based on Name

  As a user
  I want to predict the age of a person based on their name
  So that I can have an estimate of their age

  @PredictAge
  Scenario Outline: Predict Age Based on Name
    Given the user is on the "https://api.agify.io?name" in page
    When I make a GET request to "=<name>"
    Then the server should respond with a status code of 200 (OK)
    And the response body should contain predicted age

    Examples:
      | name   |
      | meelad |
      | john   |
      | emma   |
