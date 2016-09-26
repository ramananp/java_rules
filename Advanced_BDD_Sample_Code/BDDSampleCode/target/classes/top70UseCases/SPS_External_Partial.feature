@CompleteTestSuite @SPS @External @Partial
Feature: SPS External Partial

Scenario Outline: DTC
    Given the user is logged into Security Transfer
    And the user creates a ticket based off the account <deliveryAcct>
    And the user makes ticket an external partial SPS transfer
    When the user enters an external account to recieve the assets SPS
    And the user enters in the data for the expected assets for a SPS transaction <assetTypeName> <assetTypeCode> <cusip>
    And delivery instructions are entered
    And the ABA Number, Bank Name, Feb Sub Account, and Trading Broker SPS is entered based off the Broker Search
    And the user could review the content of the ticket and submits it
    And An authorized person approves the ticket
    #And Two members of the credit team approve the parent ticket
    Then a child ticket is created and is routed to the processing team <teamName> <teamCode>

Examples:
|assetTypeName|assetTypeCode|deliveryAcct|cusip|teamName|teamCode|
|"DTC"|220|"A00028000"|"78462F103"|"Securities Pending Settlement"|14464|
