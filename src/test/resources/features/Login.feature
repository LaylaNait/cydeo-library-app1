@smoke
Feature:  Library app login feature in environment 1
  Scenario: Login as librarian
    Given user is on the login page
    When user enters librarian username
    And user enters librarian password
    Then user should see the dashboard
  Scenario: Login as student
    Given user is on the login page
    When user enters student username
    And user enters student password
    Then user should see the Books

