Feature: Handling rest methods
  i as a user of the json placeholder web page
  want to create, update and delete information
  in order to learn how to consume rest services

  @Rest
    @Rest1
  Scenario Outline: create a new user
    Given the user is creating a new user with the service of jsonplaceholder
    When types the information for a new user "<name>" "<userName>" "<email>"
    Then should see obtain the status code 201
    And should see the id equals 11
    Examples:
      | name         | userName | email                      |  |
      | Luis Molina  | lemolina | lemolina@mail.com          |  |
      | Alicia Prada | Alice    | aliceinwonderland@mail.com |  |
      | Eric Cartman | the coon | ericcartman@mail.com       |  |

  @Rest
  @Rest2
  Scenario: Update a post
    Given the user is updating a user
    When sends a put request to the resource with user id 2 and the information "title updated" "body updated"
    Then should get status code 200
    And should see "title updated"

  @Rest
  @Rest3
  Scenario: Delete a todo
    Given The user is deleting a todo
    When sends a delete request to the resource with user id 3
    Then should obtain status code 200



