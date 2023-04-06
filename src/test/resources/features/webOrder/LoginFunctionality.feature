@regression
Feature: Testing Login Functionality of WebOrder Page
@smoke @ahmet @mehmet @mahmut
  Scenario: Testing positive login(correct username + correct password)
    When User provides 'guest1@microworks.com' and 'Guest1!' WebOrder
    Then User validates the 'ORDER DETAILS - Weborder' from homepage

  Scenario: Testing negative login (correct username + wrong password)
    When User provides 'guest1@microworks.com' and 'Guesst1!' WebOrder
    Then User validates 'Sign in Failed' error message
@yusuf
  Scenario: Testing negative login (wrong username + wrong password)
    When User provides 'wrongguest@microworks.com' and 'Guesst1!' WebOrder
    Then User validates 'Sign in Failed' error message
@smoke @mahmut @ayse
  Scenario: Testing negative login (No username + No password)
    When User provides '' and '' WebOrder
    Then User validates 'Sign in Failed' error message

  Scenario: Testing negative login (wrong username + correct password)
    When User provides 'wrongguest@microworks.com' and 'Guesst1!' WebOrder
    Then User validates 'Sign in Failed' error message