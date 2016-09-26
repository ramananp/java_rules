@CompleteTestSuite @Gift @Partial @Internal
Feature: Gift Physical Re-register

  #Asset is greyed out
Scenario Outline: DTC
    Given the user is logged into Security Transfer
    And the user creates a ticket based off the account <deliveryAcct>
    And the user makes ticket an internal gift transfer <giftType>
    And the user selects the asset to transfer <assetTypeName> <assetTypeCode> <cusip>
    And delivery instructions are entered
    And the DTC/Broker Name and DTC Number are entered
    And information is entered in for the gift letters
    And the user could review the content of the ticket and submits it for a gift transfer
    And An authorized person approves the ticket
    And Mean Value Batch is executed
    Then a child ticket is created and is routed to the processing team <teamName> <teamCode>

Examples:
|assetTypeName|assetTypeCode|deliveryAcct|cusip|teamName|teamCode|giftType|
|"DTC"|220|"A00028000"|"78462F103"|"Direct STP"|14030|"Physical Re-register"|
