Feature: Get Programing Joke Api
  I as the user of the web page Joke Api
  want to be able to use the get services
  For having access to the jokes of the service

  @programingJoke
  @rest
  Scenario: Get A Programing Joke
    Given the user is in the webpage Joke Api
    When sent a GET petition to the resource "/joke/Programming" of the category "/Programming"
    Then it should obtain a answer code 200
    And it should be able to see the information of the joke about programing