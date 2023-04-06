Feature: Testing Google Search Functionality
  #is a general description
  Scenario: Happy Path(positive) Testing for Search
    #is a test case
  Given User navigates to the Google
    When User Searchs for Codefish
    Then User gets more than ten links on the first page

  Scenario: Happy Path(positive) Testing Result from Search
    Given User navigates to the Google
    When User Searchs for kyrgyz food  in usa
    Then User validate the result

  Scenario: Happy Path (positive) Testing Second SearchTime from Search
    Given User navigates to the Google
    When User Searchs for turkish baklava
    Then User validate search is done less than one second