Feature: Number Conversion Service
  As a user of the Number Conversion service
  I want to convert numbers into words and dollar amounts
  So that I can read numbers in a more understandable format

  @NumberConversion
  Scenario Outline: Convert number to words
    Given the Number Conversion service is available
    When the user sends a request to convert "<number>"
    Then I should receive the number in words "<words>"

    Examples:
      | number | words                |
      | 123    | one hundred and twenty three dollars |
      | 456    | four hundred and fifty six dollars |
      | 7890   | seven thousand eight hundred and ninety dollars |
      | 1001   | one thousand one dollars|