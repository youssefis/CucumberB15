@regression
Feature: WebOrder Page Food Order Functionality

  Background: Food Order repeated steps
    Given User provides 'guest1@microworks.com' and 'Guest1!' WebOrder
    And User validates the 'ORDER DETAILS - Weborder' from homepage
    When User clicks Group Order Box and Next Button
    And User sends the word 'Cucumber is cool' for note to the invitees Section
    And User sends e-mail address which are 'yusuf@gmail.com' and 'muhamad@gmail.com' to the invite List


  Scenario: Testing the happy path food order for My House
    And User choose the delivery address 'My House' and validate the address '3137 3137 Laguna Street'
    And user clicks the create Group order Button
    Then User validates the header of page 'View Group Order'
    And User validates that the description contains the words 'Your group order is now pending'

  Scenario: Testing the happy path food order for My Office
    And User choose the delivery address 'Office' and validate the address '2012 EMPIRE BLVD'
    And user clicks the create Group order Button
    Then User validates the header of page 'View Group Order'