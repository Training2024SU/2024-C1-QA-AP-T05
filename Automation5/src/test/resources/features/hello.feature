Feature: Hello Service
  As a user of the Hello service
  I want to receive a custom greeting
  So that I feel recognized and valued

  @Hello
  Scenario Outline: Provide a custom greeting
    Given the Hello service is available
    When the user sends a request with "<name>"
    Then I should receive a greeting with the name "<name>"

    Examples:
      | name    |
      | Alice   |
      | Daniel   |
      | Sebastian|
      | Jimena   |