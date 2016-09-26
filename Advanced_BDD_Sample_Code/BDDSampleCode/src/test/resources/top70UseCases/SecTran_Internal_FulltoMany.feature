@CompleteTestSuite @Internal @FullMany
Feature: SecTrans Internal Full to Many

Scenario Outline: 3rd Party
    Given the user is logged into Security Transfer
    And the user creates a ticket based off the account <deliveryAcct>
    And the user makes ticket an internal full to many transfer
    And the user add internal account and assigns target asset to transfer <assetTypeName> <assetTypeCode> <cusip> <receivingAcct>
    And the user adds another internal account and assigns the rest of the assets <otherReceivingAcct>
    And delivery instructions are entered for internal full many transfers
    When the user could review the content of the ticket and submits it
    And An authorized person approves the ticket
    #And Two members of the credit team approve the parent ticket
    Then child tickets are created and the targeted asset is routed to the correct processing team <teamName> <teamCode>

Examples:
|assetTypeName|assetTypeCode|deliveryAcct|cusip|teamName|teamCode|receivingAcct|otherReceivingAcct|
|"3rd Party Funds"|380|"A000000"|"302933205"|"3rd Party Mutual Funds - Partial"|14355|"Q000000"|"S000000"|

Scenario Outline: DTC
    Given the user is logged into Security Transfer
    And the user creates a ticket based off the account <deliveryAcct>
    And the user makes ticket an internal full to many transfer
    And the user add internal account and assigns target asset to transfer <assetTypeName> <assetTypeCode> <cusip> <receivingAcct>
    And the user adds another internal account and assigns the rest of the assets <otherReceivingAcct>
    And delivery instructions are entered for internal full many transfers
    When the user could review the content of the ticket and submits it
    And An authorized person approves the ticket
    #And Two members of the credit team approve the parent ticket
    Then child tickets are created and the targeted asset is routed to the correct processing team <teamName> <teamCode>

Examples:
|assetTypeName|assetTypeCode|deliveryAcct|cusip|teamName|teamCode|receivingAcct|otherReceivingAcct|
|"DTC"|220|"A000000"|"78462F103"|"Direct STP"|14030|"Q000000"|"S000000"|
