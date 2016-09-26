@CompleteTestSuite @SPS @Internal @Partial
Feature: SPS Internal Partial

Scenario Outline: DTC
    Given the user is logged into Security Transfer
    And the user creates a ticket based off the account <deliveryAcct>
    And the user makes ticket an internal partial SPS transfer
    When the user selects an internal account to recieve the assets SPS <receivingAcct>
    And the user enters in the data for the expected assets for a SPS transaction <assetTypeName> <assetTypeCode> <cusip>
    And delivery instructions are entered
    And the Trailer Description is entered
    And the ABA Number, Bank Name, Feb Sub Account, and Trading Broker SPS is entered based off the Broker Search
    And the user could review the content of the ticket and submits it
    And An authorized person approves the ticket
    #And Two members of the credit team approve the parent ticket
    Then a child ticket is created and is routed to the processing team <teamName> <teamCode>

Examples:
|assetTypeName|assetTypeCode|deliveryAcct|cusip|teamName|teamCode|receivingAcct|
|"DTC"|220|"A000000"|"78462F103"|"Securities Pending Settlement"|14464|"Q000000"|
