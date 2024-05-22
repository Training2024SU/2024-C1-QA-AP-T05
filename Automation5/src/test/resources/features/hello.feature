Feature: Hello Service

  Scenario Outline: Provide a custom greeting
    Given the Hello service is available
    When the user sends a request with "<name>"
    Then I should receive a greeting with the name "<name>"

    Examples:
      | name    |
      | Alice   |
      | Bob     |
      | Charlie |
