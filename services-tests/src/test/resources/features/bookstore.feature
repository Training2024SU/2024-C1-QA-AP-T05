@service
Feature: Manage book collection
  As a user of the Bookstore
  I want to manage my book collection
  So that I can add new books to my collection

  Background:
    Given the user can access the bookstore service

  @CriticalRoute
  Scenario: Add a book to a collection
    Given David can access the Bookstore
    When he adds the book with ISBN "9781449365035" to my collection
    Then he should receive a response with status 201
    And he should be able to see the book in his collection