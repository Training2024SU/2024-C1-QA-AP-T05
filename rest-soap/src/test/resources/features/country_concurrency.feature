Feature: Search country concurrency using SOAP service
  As an user on jsonplaceholder.typicode.com platform
  I want to search country concurrency
  So that I can see how much money im going to spend

  Scenario Outline: Search country concurrency
    Given the user is connected to the SOAP Services
    When sends a POST request entering the ISO country code "<isoCode>" for concurrency
    Then response should contain the concurrency of the country "<concurrency>"
    And should receive a response of 200
    Examples:
      | isoCode | concurrency   |
      | USA     | Dollars       |
      | JPN     | Yen           |
      | CN      | Yuan Renminbi |
