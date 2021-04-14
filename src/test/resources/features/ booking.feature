Feature: Testing of Booking website
  Scenario: Search and check by hotel name on Booking site
    Given Booking page is opened
    When I write "Adele Old Town Apartment" to search field
    And Click Search button
    Then Check hotel name
    Then Check rate of hotel