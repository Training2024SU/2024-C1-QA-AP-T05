Feature: Get service Joke Api
  I as the user of the web page Joke Api
  want to be able to use the get services
  For having access to the jokes of the service

  @happyEnd
    @rest
  Scenario: Get A random Joke
    Given the user is in the web page Joke Api
    When sent a GET petition to the resource "joke/Any"
    Then it should obtain a answer code 200
    And it should be able to see the information of the joke