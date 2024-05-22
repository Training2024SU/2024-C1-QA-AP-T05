Feature: Post a post using jsonplaceholder.typicode.com service
  As an user on jsonplaceholder.typicode.com platform
  I want to post a post
  So that I can share my experiences

  Scenario Outline: Post a publication
    Given the user is connected to the jsonplaceholder API
    When sends a POST request to submit its publication with the following information
      | userId   | title   | body   |
      | <userId> | <title> | <body> |
    Then should receive a response of 201
    And should see the posts with an id generated and the same data
    Examples:
      | userId | title                       | body                                      |
      | 1      | saludos                     | saludo a mi comunidad                     |
      | 2      | saludos desde otro user     | saludo a mi comunidad desde otro user     |
      | 2      | saludos desde el mismo user | saludo a mi comunidad desde el mismo user |
