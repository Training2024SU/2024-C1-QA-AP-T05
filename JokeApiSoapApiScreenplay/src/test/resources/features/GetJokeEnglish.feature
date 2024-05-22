Feature: Get service Joke Api
  I as the user of the web page Joke Api
  want to be able to use the get services
  For having access to the jokes of the service

  @happyEnd1
    @rest
  Scenario Outline: Get one joke
    Given the user is in the web page Joke Api english
    When sent a GET petition to the resource "/joke/Any" of the type <type>
    Then it should obtain a answer code 200
    And it should be able to see the information of the joke in english
    Examples:
      | type        |
      | "religious" |
      | "political" |
      | "racist"    |
      | "sexist"    |
      | "explicit"  |