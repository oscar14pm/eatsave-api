Feature: Clients Feature
  Scenario: As a Client i can create my account
      Given the following clients
        | username | businessName | password | firstName | lastName |
        | h1P3R    | Polleria 12  | 123456   | Peter     | Castle   |
        | hyper11  | Makis360     | 123456   | Arnold    | King     |
        | hyper12  | Test123      | 123456   | Dominic   | Smith    |
      When the clients register theirs accounts
      Then all the users are created successfully

    Scenario: As a Client i can register multiple restaurants
      Given the following district "Maven"
      Given the following restaurants
        | internalId | description        | address  | latitude | longitude |
        | chicken12  | only fried chicken | Fish St. | 0.44122  | -24.42342 |
        | chicken13  | only fried chicken | Test St. | 3.21098  | -13.42342 |
        | chicken14  | only fried chicken | Lake St. | 9.02393  | -8.42342  |
        | chicken15  | only fried chicken | Lava St. | 0.32133  | -41.42342 |
      When the client register his restaurants
      Then all the restaurants are registered