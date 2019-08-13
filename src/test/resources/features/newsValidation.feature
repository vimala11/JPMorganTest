@test
Feature: Verify a news article for validity
  As a product owner
  I want to search for an article in other sources
  So that I can confirm that the article is valid

  Scenario Outline:
    Given user opens the guardian page
    And saves the title of news article displayed in position "1"
    When user looks for the article title in "<searchEngine>"
    Then user should see valid articles from different sources in "<searchEngine>"
  Examples:
  | searchEngine |
  | google       |
  | bing         |


