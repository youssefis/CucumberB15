@regression
Feature: Testing the search functionality of Etsy

  Scenario: Validation Title of Etsy Hat
    When User Searches for 'Hat' for Etsy WebPage
    Then User validates the title 'Hat - Etsy' from Etsy

  Scenario: Validation Title of Etsy Hat
    When User Searches for 'Key' for Etsy WebPage
    Then User validates the title 'Key - Etsy' from Etsy

  Scenario: Validation Title of Etsy Hat
    When User Searches for 'Pin' for Etsy WebPage
    Then User validates the title 'Pin - Etsy' from Etsy