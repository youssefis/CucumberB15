Feature: Testing Google Search Functionality

  Background: navigation to the website
    Given User navigates to the 'https://www.google.com/'

  Scenario: Happy Path(positive) Testing Search
   # Given User navigates to the 'https://www.google.com/'
    When User Searchs for 'Codefish'
    Then User gets more Than 5 links from first page

  Scenario: Happy Path (positive) Result Search
   # Given User navigates to the 'https://www.google.com/'
    When User Searchs for 'Kyrgyz Food in USA'
    Then User more than 100000000 results

