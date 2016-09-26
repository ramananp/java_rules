@CompleteTestSuite @Gift @Partial @Internal
Feature: Gift Pending Disposition

Scenario Outline: DTC
    Given the user is logged into Security Transfer
    And the user creates a ticket based off the account <deliveryAcct>
    And the user makes ticket an internal gift transfer <giftType>
    When the user selects the asset to transfer <assetTypeName> <assetTypeCode> <cusip>
    And delivery instructions are entered
    And the Trailer Description is entered
    And information is entered in for the gift letters
    And the user could review the content of the ticket and submits it for a gift transfer
    And An authorized person approves the ticket
    And Mean Value Batch is executed
    Then a child ticket is created and is routed to the processing team <teamName> <teamCode>

Examples:
|assetTypeName|assetTypeCode|deliveryAcct|cusip|teamName|teamCode|giftType|
|"DTC"|220|"A00028000"|"78462F103"|"Direct STP"|14030|"Pending Disposition"|

Scenario Outline: 3rd Party
    Given the user is logged into Security Transfer
    And the user creates a ticket based off the account <deliveryAcct>
    And the user makes ticket an internal gift transfer <giftType>
    When the user selects the asset to transfer <assetTypeName> <assetTypeCode> <cusip>
    And delivery instructions are entered
    And the Trailer Description is entered
    And the Tax Code is entered
    And the Dividend Option - Reinvest or Cash is entered
    And information is entered in for the gift letters
    And the user could review the content of the ticket and submits it for a gift transfer
    And An authorized person approves the ticket
    And Mean Value Batch is executed
    Then a child ticket is created and is routed to the processing team <teamName> <teamCode>

Examples:
|assetTypeName|assetTypeCode|deliveryAcct|cusip|teamName|teamCode|giftType|
|"3rd Party Funds"|380|"A00028000"|"302933205"|"3rd Party MF"|14040|"Pending Disposition"|

Scenario Outline: JPM Fund
    Given the user is logged into Security Transfer
    And the user creates a ticket based off the account <deliveryAcct>
    And the user makes ticket an internal gift transfer <giftType>
    When the user selects the asset to transfer <assetTypeName> <assetTypeCode> <cusip>
    And delivery instructions are entered
    And the Trailer Description is entered
    And the Dividend Option - Reinvest or Cash is entered
    And information is entered in for the gift letters
    And the user could review the content of the ticket and submits it for a gift transfer
    And An authorized person approves the ticket
    And Mean Value Batch is executed
    Then a child ticket is created and is routed to the processing team <teamName> <teamCode>

Examples:
|assetTypeName|assetTypeCode|deliveryAcct|cusip|teamName|teamCode|giftType|
|"JPM Fund"|140|"A00028000"|"46637K513"|"Direct STP"|14030|"Pending Disposition"|
