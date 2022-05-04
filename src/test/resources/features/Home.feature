Feature: the greet message from home can be retrieved
  Scenario: client makes call to GET /
    When the client calls /
    Then the client receives status code of 200
    And the client receives greet message "Welcome to the Eat Save JSON API"