Feature: Client Register
  Scenario: As a Client i can create my account
      Given the following clients
        | username | businessName | password | firstName | lastName |
        | h1P3R    | Polleria 12  | 123456   | firstName | lastName |
        | hyper11  | Makis360     | 123456   | firstName | lastName |
        | hyper12  | Test123      | 123456   | firstName | lastName |
      When the clients register theirs accounts
      Then all the users are created successfully