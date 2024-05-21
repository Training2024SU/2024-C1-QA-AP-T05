Feature: Isbn validation

  Background:
    Given the user can access the validator service

  Scenario Outline: Isbn validation
    When David requests the validation of the "<isbn>" isbn
    Then he should receive a response with status 200
    And he should get is "<response>" as response
    Examples:
      | isbn              | response |
      | 978-1-4612-9090-2 | true     |
      | 9781461290902     | true     |
      | 9781461290903     | false    |
