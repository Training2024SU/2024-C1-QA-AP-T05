Feature: Consulting countries information
  i as a user of the countries information service
  want to consult about currency, flags, capital cities
  to learn test the answers

  Scenario Outline: Consult currency by country
    Given the user want to consult the currency by country
    When makes the request to consult the currency of the country with code "<code>"
    Then should see the status code 200
    And the currency name "<currencyName>"
    Examples:
      | code | currencyName |
      | AD   | Euro         |
      | CO   | Pesos        |
      | SG   | Dollars      |


