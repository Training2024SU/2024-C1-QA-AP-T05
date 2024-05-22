Feature: Test Iso Code
  I as the user of the soap WebServices
  Want to be able to use the services
  For having access to the Iso Code of the countries

  @isoCode
  @soap
  Scenario: get the Iso Code of one country
    Given the user wants to know the Iso code of the country "Colombia"
    When does the petition of the service
    Then it should get a 200 code
    And it should be able to see the Iso code "CO"