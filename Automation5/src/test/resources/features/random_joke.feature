Feature: Get Random Joke
  As a user
  I want to know a random joke
  So that I can have a good laugh and lighten my mood

  @RandomJoke
  Scenario: Get a Random Joke
    Given the user is on the "https://official-joke-api.appspot.com/" in page
    When I make a GET request to "random_joke"
    Then the server should respond with a status code of 200 (OK)
    And the response body should contain a joke
