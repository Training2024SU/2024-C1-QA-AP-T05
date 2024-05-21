Feature: Get posts using jsonplaceholder.typicode.com service
  As an user on jsonplaceholder.typicode.com platform
  I want to search all posts
  So that I can see their details

  Scenario: Get all posts
    Given the user is connected to the jsonplaceholder API
    When sends a GET request to retrieve all posts
    Then response should contain information about all posts including
      | userId | id | title                                                                      |
      | 1      | 1  | sunt aut facere repellat provident occaecati excepturi optio reprehenderit |
      | 1      | 2  | qui est esse                                                               |
      | 1      | 3  | ea molestias quasi exercitationem repellat qui ipsa sit aut                |
    And should receive a response of 200