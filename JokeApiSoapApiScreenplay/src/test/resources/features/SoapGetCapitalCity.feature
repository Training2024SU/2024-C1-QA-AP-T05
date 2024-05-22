Feature: Test city capital
  I as the user of the soap WebServices
  Want to be able to use the services
  For having access to the Capital cities

  @capitalCities
  @soap
  Scenario: get the capital of one city
    Given the user wants to know the name of the capital city of "COLOMBIA"
    When does the petition
    Then it should get a 200 code
    And it should be able to see the name of the capital city "Bogota"