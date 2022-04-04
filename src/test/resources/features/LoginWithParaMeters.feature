Feature:  Library with parameters
  Scenario: Login as librarian 3
    Given user is on the login page
    When user enters librarian username "librarian3@library"
    And user enters librarian password "I6JMMwLb"
    And click the sign in button
    Then there should be 138 users

  Scenario: Login as librarian
    Given user is on the login page
    When user enters librarian "librarian4@library" and "7jrGZdaV"
    Then user should see the dashboard


