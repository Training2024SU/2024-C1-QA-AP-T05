Feature: Consulting countries information
  i as a user of the countries information service
  want to consult about currency, flags, capital cities
  to learn test the answers

  @Soap
    @Soap1
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

  @Soap
    @Soap2
  Scenario Outline: Consult capital city
    Given the user want to consult the country capital city
    When makes the request to consult by country "<code>"
    Then should obtain a status code 200
    And should get the capital city "<capitalCity>"
    Examples:
      | code | capitalCity |
      | JP   | Tokyo       |
      | CY   | Nicosia     |
      | VE   | Caracas     |

  @Soap
    @Soap3
  Scenario Outline: Consult all country names
    Given the user want to consult all country names
    When makes the request to consult them
    Then should get a status code 200
    And should see the country name "<countryName>" including its code "<code>"
    Examples:
      | countryName | code    |
      | Uruguay     | Uruguay |
      | Peru        | PE      |
      | China       | CN      |