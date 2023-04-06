@NegativeTesting
Feature:  Testing negative login functionality

  Scenario Outline: Testing different negative login functionalities
    When User provides '<username>' and '<password>' WebOrder
    Then User validates '<errorMessage>' error message
    Examples:
      | username                  | password | errorMessage   |
      | guest1@microworks.com     | Guesst1  | Sign in Failed |
      | wrongguest@microworks.com | wrong    | Sign in Failed |
      |                           |          | Sign in Failed |
      | wrongguest@microworks.com | Guesst1! | Sign in Failed |
