@CompleteTestSuite @DWACDelivery
Feature: DWAC Free Delivery

Scenario Outline: DTC
    Given the user is logged into Security Transfer
    And the user creates a ticket based off the account <deliveryAcct>
    And the user makes ticket a DWAC Free Delivery
    When the user adds a reference control number for external transfers
    And the user selects the asset to transfer <assetTypeName> <assetTypeCode> <cusip>
    And delivery instructions are entered
    And the DTC Agent Information is entered
    And the user could review the content of the ticket and submits it
    And An authorized person approves the ticket
    #And Two members of the credit team approve the parent ticket
    Then a child ticket is created and is routed to the processing team <teamName> <teamCode>

Examples:
|assetTypeName|assetTypeCode|deliveryAcct|cusip|teamName|teamCode|
|"DTC"|220|"A000000"|"78462F103"|"Direct STP"|14030|
