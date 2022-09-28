Feature:Search functionality

  Scenario: Searching the product
    Given User is on Home page of nopcommerce
    When User enter data in search and searching the product
    And Click on Search button
    Then User Verify the search product
    And Close browser