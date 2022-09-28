Feature:Registration Action

 Scenario: Register user with Valid Credential
    Given User is on Home page
    When User click on Register link
    And User enter data on fields
    And User click on the register button
    Then Verify the registration
    And Close the Browser