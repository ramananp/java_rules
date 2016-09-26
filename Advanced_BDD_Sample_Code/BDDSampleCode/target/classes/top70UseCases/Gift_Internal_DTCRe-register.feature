@CompleteTestSuite @Gift @Partial @Internal
Feature: Gift DTC Re-register

Scenario Outline: DTC
    Given the user is logged into Security Transfer
    And the user creates a ticket based off the account <deliveryAcct>
    And the user makes ticket an internal gift transfer <giftType>
    When the user selects the asset to transfer <assetTypeName> <assetTypeCode> <cusip>
    And delivery instructions are entered
    And the Trailer Description is entered
    And the DTC/Broker Name and DTC Number are entered
    And the Contact Name is entered
    And the Contact Phone Number is entered
    And the Physical Mailing Address is entered
    And the Name Of Individual is entered
    And the Beneficiary Info - SSN is entered
    And the Shares Registered To - Name is entered
    And the Shares Registered To - Address is entered
    And information is entered in for the gift letters
    And the user could review the content of the ticket and submits it for a gift transfer
    And An authorized person approves the ticket
    And Mean Value Batch is executed
    Then a child ticket is created and is routed to the processing team <teamName> <teamCode>

Examples:
|assetTypeName|assetTypeCode|deliveryAcct|cusip|teamName|teamCode|giftType|
|"DTC"|220|"A00028000"|"78462F103"|"DTC Gift Re-Register"|14381|"DTC Re-register"|

Scenario Outline: 3rd Party
    Given the user is logged into Security Transfer
    And the user creates a ticket based off the account <deliveryAcct>
    And the user makes ticket an internal gift transfer <giftType>
    When the user selects the asset to transfer <assetTypeName> <assetTypeCode> <cusip>
    And delivery instructions are entered
    And the Trailer Description is entered
    And the DTC/Broker Name and DTC Number are entered
    And the Contact Name is entered
    And the Contact Phone Number is entered
    And the Physical Mailing Address is entered
    And the Name Of Individual is entered
    And the Beneficiary Info - SSN is entered
    And the Shares Registered To - Name is entered
    And the Shares Registered To - Address is entered
    And information is entered in for the gift letters
    And the user could review the content of the ticket and submits it for a gift transfer
    And An authorized person approves the ticket
    And Mean Value Batch is executed
    Then a child ticket is created and is routed to the processing team <teamName> <teamCode>

Examples:
|assetTypeName|assetTypeCode|deliveryAcct|cusip|teamName|teamCode|giftType|
|"3rd Party Funds"|380|"A00028000"|"302933205"|"DTC Gift Re-Register"|14381|"DTC Re-register"|

Scenario Outline: JPM Fund
    Given the user is logged into Security Transfer
    And the user creates a ticket based off the account <deliveryAcct>
    And the user makes ticket an internal gift transfer <giftType>
    When the user selects the asset to transfer <assetTypeName> <assetTypeCode> <cusip>
    And delivery instructions are entered
    And the Trailer Description is entered
    And the DTC/Broker Name and DTC Number are entered
    And the Contact Name is entered
    And the Contact Phone Number is entered
    And the Physical Mailing Address is entered
    And the Name Of Individual is entered
    And the Beneficiary Info - SSN is entered
    And the Shares Registered To - Name is entered
    And the Shares Registered To - Address is entered
    And information is entered in for the gift letters
    And the user could review the content of the ticket and submits it for a gift transfer
    And An authorized person approves the ticket
    And Mean Value Batch is executed
    Then a child ticket is created and is routed to the processing team <teamName> <teamCode>

Examples:
|assetTypeName|assetTypeCode|deliveryAcct|cusip|teamName|teamCode|giftType|
|"JPM Fund"|140|"A00028000"|"46637K513"|"DTC Gift Re-Register"|14381|"DTC Re-register"|
