@service
Feature: Calculator operations

  Background:
    Given the user can access the calculator service

  Scenario: Sum numbers
    When Maria requests to sum 2 plus 4
    Then she gets 6 as sum response

  Scenario: Subtract numbers
    When David requests to subtract 8 from 4
    Then he gets -4 as subtract response

  Scenario: Multiply numbers
    When Maria requests to multiply 20 times 12
    Then she gets 240 as multiply response

  Scenario: Divide numbers
    When Maria requests to divide 6 by 3
    Then she gets 2 as divide response