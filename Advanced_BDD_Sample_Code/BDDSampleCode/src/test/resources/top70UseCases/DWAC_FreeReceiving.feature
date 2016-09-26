@CompleteTestSuite @DWACRecieve
Feature: DWAC Free Receive

Scenario Outline: DTC
    Given the user is logged into Security Transfer
    And the user creates a ticket based off the account <deliveryAcct>
    And the user makes ticket a DWAC Free Receive
    When the user adds a reference control number
    And the user enters in the data for the expected assets <assetTypeName> <assetTypeCode> <cusip>
    And delivery instructions are entered
    And the Trailer Description is entered
    And the DTC Agent Information is entered
    And the Penny Stock Deposit Indication is entered
    And the user could review the content of the ticket and submits it
    And An authorized person approves the ticket
    #And Two members of the credit team approve the parent ticket
    Then a child ticket is created and is routed to the processing team <teamName> <teamCode>

Examples:
|assetTypeName|assetTypeCode|deliveryAcct|cusip|teamName|teamCode|
|"DTC"|220|"A000000"|"78462F103"|"Direct STP"|14030|
