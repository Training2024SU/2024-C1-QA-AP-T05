@service
Feature: Manage book collection
  As a user of the Bookstore
  I want to manage my book collection
  So that I can add new books to my collection

  Background:
    Given the user can access the bookstore service

  Scenario: Get available books list
    When Maria requests the list of available books
    Then she should receive a response with status 200
    And she should get a list with all the books

  @CriticalRoute
  Scenario: Add a book to a collection
    Given David has his token access
    When he adds the book with ISBN "9781449365035" to my collection
    Then he should receive a response with status 201
    And he should be able to see the book in his collection