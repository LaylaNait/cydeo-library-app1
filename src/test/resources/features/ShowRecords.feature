@smoke
Feature: Show records functionality
  Scenario: verity default values in Users page
    Given user is on the login page
    And user enters librarian "librarian4@library" and "7jrGZdaV"
    When user click on "Users" link
    Then show records default value should be 10
    And show records should have following options:
      | 5   |
      | 10  |
      | 15  |
      | 50  |
      | 100 |
      | 200 |
      | 500 |