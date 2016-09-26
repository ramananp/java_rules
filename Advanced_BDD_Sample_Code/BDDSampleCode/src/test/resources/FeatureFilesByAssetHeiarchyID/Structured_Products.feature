@SecTransRouting @StructuredProducts
Feature: Structured Products

  @Internal @Partial @14060
Scenario Outline: Internal partial transfer, ID 14060
    Given the user is logged into Security Transfer
    And the user creates a ticket based off the account <deliveryAcct>
    And the user makes ticket an internal partial transfer
    When the user selects an internal account to recieve the assets <receivingAcct>
    And the user selects the asset to transfer <assetTypeName> <assetTypeCode> <cusip>
    And delivery instructions are entered
    And the Structured Products Instructions are entered
    And the user could review the content of the ticket and submits it
    And An authorized person approves the ticket
    Then a child ticket is created and is routed to the processing team <teamName> <teamCode>

Examples:
|assetTypeName|assetTypeCode|deliveryAcct|cusip|teamName|teamCode|receivingAcct|
|"Structured Products"|370|"A00095009"|"06741UQC1"|"Structured Product"|14060|"Q66651003"|

  @External @Partial @14310
Scenario Outline: External partial transfer, ID 14310
    Given the user is logged into Security Transfer
    And the user creates a ticket based off the account <deliveryAcct>
    And the user makes ticket an external partial transfer
    When the user enters an external account to recieve the assets
    And the user selects the asset to transfer <assetTypeName> <assetTypeCode> <cusip>
    And delivery instructions are entered
    And the ISIN/Sedol are entered
    And the Security Currency are entered
    And the Clearing Broker ID - Euroclear are entered
    And the YBEN or NBEN is entered
    And the Trailer Description is entered
    And the user could review the content of the ticket and submits it
    And An authorized person approves the ticket
    Then a child ticket is created and is routed to the processing team <teamName> <teamCode>

Examples:
|assetTypeName|assetTypeCode|deliveryAcct|cusip|teamName|teamCode|
|"Euroclear - Structured Products"|450|"M50973003"|"4631119A4"|"Structured Products"|14310|

  @OmniMargin @Partial @14310
Scenario Outline: Omni to Margin partial transfer, ID 14310
    Given the user is logged into Security Transfer
    And the user creates a ticket based off the account <deliveryAcct>
    And the user makes ticket an external partial transfer
    When the user enters an external account to recieve the assets
    And the user selects the asset to transfer <assetTypeName> <assetTypeCode> <cusip>
    And delivery instructions are entered
    And the user could review the content of the ticket and submits it
    And An authorized person approves the ticket
    Then a child ticket is created and is routed to the processing team <teamName> <teamCode>

Examples:
|assetTypeName|assetTypeCode|deliveryAcct|cusip|teamName|teamCode|receivingAcct|
|"Euroclear - Structured Products"|450|"M50973003"|"4631119A4"|"Structured Products"|14310|2410361220101|

  @External @Partial @14389
Scenario Outline: External partial transfer, ID 14389, Deliv Intr. Set 1
    Given the user is logged into Security Transfer
    And the user creates a ticket based off the account <deliveryAcct>
    And the user makes ticket an external partial transfer
    When the user enters an external account to recieve the assets
    And the user selects the asset to transfer <assetTypeName> <assetTypeCode> <cusip>
    And delivery instructions are entered
    And the DTC/Broker Name and DTC Number are entered
    And the Trailer Description is entered
    And the user could review the content of the ticket and submits it
    And An authorized person approves the ticket
    Then a child ticket is created and is routed to the processing team <teamName> <teamCode>

Examples:
|assetTypeName|assetTypeCode|deliveryAcct|cusip|teamName|teamCode|
|"DTC - Structured Product"|840|0|0|"Structured Product"|14389|

  @External @Partial @14389
Scenario Outline: External partial transfer, ID 14389, Deliv Intr. Set 2
    Given the user is logged into Security Transfer
    And the user creates a ticket based off the account <deliveryAcct>
    And the user makes ticket an external partial transfer
    When the user enters an external account to recieve the assets
    And the user selects the asset to transfer <assetTypeName> <assetTypeCode> <cusip>
    And delivery instructions are entered
    And the ISIN/Sedol are entered
    And the Security Currency are entered
    And the Trading Broker Name is entered
    And the Clearing Broker Name is entered
    And the Trading Broker BIC is entered
    And the Clearing Broker ID is entered
    And the Sub Account Info is entered
    And the NCBO or CBO are entered
    And the Local Currency Cost/Carry Value is entered
    And the USD Cost/Carry Value is entered
    And the Trailer Description is entered
    And the user could review the content of the ticket and submits it
    And An authorized person approves the ticket
    Then a child ticket is created and is routed to the processing team <teamName> <teamCode>

Examples:
|assetTypeName|assetTypeCode|deliveryAcct|cusip|teamName|teamCode|
|"Euroclear - Structured Product"|850|0|0|"Structured Product"|14389|

  @External @Partial @14440
Scenario Outline: External partial transfer, ID 14440
    Given the user is logged into Security Transfer
    And the user creates a ticket based off the account <deliveryAcct>
    And the user makes ticket an external partial transfer
    When the user enters an external account to recieve the assets
    And the user selects the asset to transfer <assetTypeName> <assetTypeCode> <cusip>
    And delivery instructions are entered
    And the DTC/Broker Name and DTC Number are entered
    And the user could review the content of the ticket and submits it
    And An authorized person approves the ticket
    Then a child ticket is created and is routed to the processing team <teamName> <teamCode>

Examples:
|assetTypeName|assetTypeCode|deliveryAcct|cusip|teamName|teamCode|
|"Structured Products"|370|"A00095009"|"06741UQC1"|"Structured Products External"|14440|

  @OmniMargin @Partial @14440
Scenario Outline: Omni to Margin partial transfer, ID 14440
    Given the user is logged into Security Transfer
    And the user creates a ticket based off the account <deliveryAcct>
    And the user makes ticket an external partial transfer
    When the user enters an external account to recieve the assets
    And the user selects the asset to transfer <assetTypeName> <assetTypeCode> <cusip>
    And delivery instructions are entered
    And the DTC/Broker Name and DTC Number are entered
    And the user could review the content of the ticket and submits it
    And An authorized person approves the ticket
    Then a child ticket is created and is routed to the processing team <teamName> <teamCode>

Examples:
|assetTypeName|assetTypeCode|deliveryAcct|cusip|teamName|teamCode|receivingAcct|
|"Structured Products"|370|"A00095009"|"06741UQC1"|"Structured Products External"|14440|2410361220101|
