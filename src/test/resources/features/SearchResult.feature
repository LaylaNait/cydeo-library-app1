Feature: Search functionality on the users page
  Scenario: Table columns names
    Given user is on the login page
    And user enters librarian "librarian4@library" and "7jrGZdaV"
    When user click on "Users" link
    Then table should have following column name:
      | Actions   |
      | User ID   |
      | Full Name |
      | Email     |
      | Group     |
      | Status    |