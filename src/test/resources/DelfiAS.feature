Feature: Testing Delfi mainPageAS
  Scenario: Scenario 1
    Given Given title Rahojs sola
    When Search for titles and counts
    Then Assert Titles
    And Assert Counts is: 88