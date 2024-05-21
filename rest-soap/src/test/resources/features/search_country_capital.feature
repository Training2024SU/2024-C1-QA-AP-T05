Feature: Search country capital using SOAP service
  As an user on jsonplaceholder.typicode.com platform
  I want to search country capitals
  So that I can see their details and learn more

  Scenario Outline: Search country capital
    Given the user is connected to the SOAP Services
    When sends a POST request entering the ISO country code "<isoCode>"
    Then response should contain the capital of the country "<capital>"
    And should receive a response of 200
    Examples:
      | isoCode | capital     |
      | USA     | Washington  |
      | JPN     | Tokyo       |
      | MX      | Mexico City |
