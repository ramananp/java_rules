@SecTransRouting @3rdParty
Feature: 3rd Party

  @Internal @Partial @14040
Scenario Outline: Internal partial transfer, ID 14040
    Given the user is logged into Security Transfer
    And the user creates a ticket based off the account <deliveryAcct>
    And the user makes ticket an internal partial transfer
    When the user selects an internal account to recieve the assets <receivingAcct>
    And the user selects the asset to transfer <assetTypeName> <assetTypeCode> <cusip>
    And delivery instructions are entered
    And the Dividend Option - Reinvest or Cash is entered
    And the user could review the content of the ticket and submits it
    And An authorized person approves the ticket
    Then a child ticket is created and is routed to the processing team <teamName> <teamCode>

Examples:
|assetTypeName|assetTypeCode|deliveryAcct|cusip|teamName|teamCode|receivingAcct|
|"3rd Party Funds"|380|"R72468003"|"115233579"|"3rd Party MF"|14040|"Q66651003"|

  @Internal @Partial @14090
Scenario Outline: Internal partial transfer, ID 14090
    Given the user is logged into Security Transfer
    And the user creates a ticket based off the account <deliveryAcct>
    And the user makes ticket an internal partial transfer
    When the user selects an internal account to recieve the assets <receivingAcct>
    And the user selects the asset to transfer <assetTypeName> <assetTypeCode> <cusip>
    And delivery instructions are entered
    And the Dividend Option - Reinvest or Cash is entered
    And the user could review the content of the ticket and submits it
    And An authorized person approves the ticket
    Then a child ticket is created and is routed to the processing team <teamName> <teamCode>

Examples:
|assetTypeName|assetTypeCode|deliveryAcct|cusip|teamName|teamCode|receivingAcct|
|"3rd Party Funds - Manual (Issuer Direct Funds)"|390|0|0|"3rd Party MF - Issuer Direct"|14090|"Q66651003"|

  @External @Partial @14200
Scenario Outline: External partial transfer, ID 14200
    Given the user is logged into Security Transfer
    And the user creates a ticket based off the account <deliveryAcct>
    And the user makes ticket an external partial transfer
    When the user enters an external account to recieve the assets
    And the user selects the asset to transfer <assetTypeName> <assetTypeCode> <cusip>
    And delivery instructions are entered
    And the Mutual Fund Account Number is entered
    And the DTC/Broker Name and DTC Number are entered
    And the user could review the content of the ticket and submits it
    And An authorized person approves the ticket
    Then a child ticket is created and is routed to the processing team <teamName> <teamCode>

Examples:
|assetTypeName|assetTypeCode|deliveryAcct|cusip|teamName|teamCode|
|"3rd Party Funds - Manual (Issuer Direct Funds)"|390|0|0|"3rd Party MF - Issuer Direct"|14200|

  @OmniMargin @Partial @14200
Scenario Outline: Omni to Margin partial transfer, ID 14200
    Given the user is logged into Security Transfer
    And the user creates a ticket based off the account <deliveryAcct>
    And the user makes ticket a margin partial transfer
    When the user selects an internal account to recieve the assets for margin <receivingAcct>
    And the user selects the asset to transfer <assetTypeName> <assetTypeCode> <cusip>
    And delivery instructions are entered
    And the Trailer Description is entered
    And the user could review the content of the ticket and submits it
    And An authorized person approves the ticket
    Then a child ticket is created and is routed to the processing team <teamName> <teamCode>

Examples:
|assetTypeName|assetTypeCode|deliveryAcct|cusip|teamName|teamCode|receivingAcct|
|"3rd Party Funds - Manual (Issuer Direct Funds)"|390|0|0|"EXTERNAL - ATT"|14210|2410361220101|

  @External @Partial @14355
Scenario Outline: External partial transfer, ID 14355
    Given the user is logged into Security Transfer
    And the user creates a ticket based off the account <deliveryAcct>
    And the user makes ticket an external partial transfer
    When the user enters an external account to recieve the assets
    And the user selects the asset to transfer <assetTypeName> <assetTypeCode> <cusip>
    And delivery instructions are entered
    And the Mutual Fund Account Number is entered
    And the DTC/Broker Name and DTC Number are entered
    And the Tax Code is entered
    And the user could review the content of the ticket and submits it
    And An authorized person approves the ticket
    Then a child ticket is created and is routed to the processing team <teamName> <teamCode>

Examples:
|assetTypeName|assetTypeCode|deliveryAcct|cusip|teamName|teamCode|
|"3rd Party Funds"|380|"R72468003"|"115233579"|"3rd Party Mutual Funds - Partial"|14355|
