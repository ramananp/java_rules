@CompleteTestSuite @Gift @Partial @External
Feature: Gift Electonic

Scenario: Run Mean Value Batch to have quick tests
    When Mean Value Batch is executed

Scenario Outline: DTC
    Given the user is logged into Security Transfer
    And the user creates a ticket based off the account <deliveryAcct>
    And the user makes ticket an external gift transfer <giftType>
    When the user enters an external account to recieve the assets
    And the user selects the asset to transfer <assetTypeName> <assetTypeCode> <cusip>
    And delivery instructions are entered
    And the DTC/Broker Name and DTC Number are entered
    And information is entered in for the gift letters
    And the user could review the content of the ticket and submits it for a gift transfer
    And An authorized person approves the ticket
    And Mean Value Batch is executed
    #And Two members of the credit team approve the parent ticket
    Then a child ticket is created and is routed to the processing team <teamName> <teamCode>

Examples:
|assetTypeName|assetTypeCode|deliveryAcct|cusip|teamName|teamCode|giftType|
|"DTC"|220|"A00028000"|"78462F103"|"Direct STP"|14030|"Electronic"|

Scenario Outline: 3rd Party
    Given the user is logged into Security Transfer
    And the user creates a ticket based off the account <deliveryAcct>
    And the user makes ticket an external gift transfer <giftType>
    When the user enters an external account to recieve the assets
    And the user selects the asset to transfer <assetTypeName> <assetTypeCode> <cusip>
    And delivery instructions are entered
    And the DTC/Broker Name and DTC Number are entered
    And the Tax Code is entered
    And the Mutual Fund Account Number is entered
    And information is entered in for the gift letters
    And the user could review the content of the ticket and submits it for a gift transfer
    And An authorized person approves the ticket
    And Mean Value Batch is executed
    #And Two members of the credit team approve the parent ticket
    Then a child ticket is created and is routed to the processing team <teamName> <teamCode>

Examples:
|assetTypeName|assetTypeCode|deliveryAcct|cusip|teamName|teamCode|giftType|
|"3rd Party Funds"|380|"A00028000"|"302933205"|"3rd Party Mutual Funds - Partial"|14355|"Electronic"|

Scenario Outline: JPM Fund
    Given the user is logged into Security Transfer
    And the user creates a ticket based off the account <deliveryAcct>
    And the user makes ticket an external gift transfer <giftType>
    When the user enters an external account to recieve the assets
    And the user selects the asset to transfer <assetTypeName> <assetTypeCode> <cusip>
    And delivery instructions are entered
    And the DTC/Broker Name and DTC Number are entered
    And the Mutual Fund Account Number is entered
    And information is entered in for the gift letters
    And the user could review the content of the ticket and submits it for a gift transfer
    And An authorized person approves the ticket
    And Mean Value Batch is executed
    #And Two members of the credit team approve the parent ticket
    Then a child ticket is created and is routed to the processing team <teamName> <teamCode>

Examples:
|assetTypeName|assetTypeCode|deliveryAcct|cusip|teamName|teamCode|giftType|
|"JPM Fund"|140|"A00028000"|"46637K513"|"ATT"|14260|"Electronic"|
