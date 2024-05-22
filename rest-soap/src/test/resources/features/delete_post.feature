Feature: Delete post using jsonplaceholder.typicode.com service
  As an user on jsonplaceholder.typicode.com platform
  I want to delete a post by id
  So that I can clean my history

  Scenario Outline: Delete post
    Given the user is connected to the jsonplaceholder API
    When sends a DELETE request to remove the post with id "<id>"
    Then should receive a response of 200
    Examples:
      | id |
      | 1  |
      | 2  |
      | 3  |