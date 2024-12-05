Feature: Get Random Activity
  As a user
  I want to know a random activity
  So that I can find something interesting to do when I'm bored

  @RandomActivity
  Scenario Outline: Get a Random Activity
    Given the user is on the "https://www.boredapi.com/" in page
    When I make a GET request to "api/activity?participants=<participants>"
    Then the server should respond with a status code of 200 (OK)
    And the response body should contain an activity

    Examples:
      |participants|
      |1|
      |5|
      |3|


