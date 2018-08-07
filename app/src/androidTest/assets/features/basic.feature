Feature: Basic Test

  Scenario: Super simple
    Given 'Home' is selected
    Then Tap Nav item 'Dashboard'
    Then Text should equal 'Dashboard'
