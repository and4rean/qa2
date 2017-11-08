Feature: Testing Delfi mainPageAS
  Scenario: Scenario 1
    Given Search for Title ("Neapturamais Porziņģis")
    And   Print testik ("Andruha privet!")
    Then Assert Titles
    And Assert Counts