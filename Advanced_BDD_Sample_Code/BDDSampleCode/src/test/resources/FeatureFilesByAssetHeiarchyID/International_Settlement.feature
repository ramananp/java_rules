@SecTransRouting @InternationSettlements
Feature: International Settlements

  @Internal @Partial @14120
Scenario Outline: Internal partial transfer, ID 14120, Deliv Intr. Set 1
    Given the user is logged into Security Transfer
    And the user creates a ticket based off the account <deliveryAcct>
    And the user makes ticket an internal partial transfer
    When the user selects an internal account to recieve the assets <receivingAcct>
    And the user selects the asset to transfer <assetTypeName> <assetTypeCode> <cusip>
    And delivery instructions are entered
    And the YBEN or NBEN is entered
    And the user could review the content of the ticket and submits it
    And An authorized person approves the ticket
    Then a child ticket is created and is routed to the processing team <teamName> <teamCode>

Examples:
|assetTypeName|assetTypeCode|deliveryAcct|cusip|teamName|teamCode|receivingAcct|
|"Local Market Global"|320|"A77597002"|"J6571N923"|"International Settlements - STP"|14120|"Q66651003"|
|"Euroclear - Structured Products"|450|"M50973003"|"4631119A4"|"International Settlements - STP"|14120|"Q66651003"|
|"Euroclear"|310|"H85377002"|"3925009F3"|"International Settlements - STP"|14120|"Q66651003"|

  @Internal @Partial @14120
Scenario Outline: Internal partial transfer, ID 14120, Deliv Intr. Set 2
    Given the user is logged into Security Transfer
    And the user creates a ticket based off the account <deliveryAcct>
    And the user makes ticket an internal partial transfer
    When the user selects an internal account to recieve the assets <receivingAcct>
    And the user selects the asset to transfer <assetTypeName> <assetTypeCode> <cusip>
    And delivery instructions are entered
    And the user could review the content of the ticket and submits it
    And An authorized person approves the ticket
    Then a child ticket is created and is routed to the processing team <teamName> <teamCode>

Examples:
|assetTypeName|assetTypeCode|deliveryAcct|cusip|teamName|teamCode|receivingAcct|
|"Foreign Currency"|260|"A77597002"|"0GBPPRAA9"|"International Settlements - STP"|14120|"Q66651003"|

  @Internal @Partial @14130
Scenario Outline: Internal partial transfer, ID 14130
    Given the user is logged into Security Transfer
    And the user creates a ticket based off the account <deliveryAcct>
    And the user makes ticket an internal partial transfer
    When the user selects an internal account to recieve the assets <receivingAcct>
    And the user selects the asset to transfer <assetTypeName> <assetTypeCode> <cusip>
    And delivery instructions are entered
    And the user could review the content of the ticket and submits it
    And An authorized person approves the ticket
    Then a child ticket is created and is routed to the processing team <teamName> <teamCode>

Examples:
|assetTypeName|assetTypeCode|deliveryAcct|cusip|teamName|teamCode|receivingAcct|
|"FX forwards"|300|"W40626009"|"FXUSDBPPP"|"International Settlements - Manual"|14130|"Q66651003"|
|"Emerging Market Repurchase Agreement"|470|"W40998002"|"7165509C4"|"International Settlements - Manual"|14130|"Q66651003"|

  @External @Partial @14300
Scenario Outline: External partial transfer, ID 14300, Deliv Intr. Set 1
    Given the user is logged into Security Transfer
    And the user creates a ticket based off the account <deliveryAcct>
    And the user makes ticket an external partial transfer
    When the user enters an external account to recieve the assets
    And the user selects the asset to transfer <assetTypeName> <assetTypeCode> <cusip>
    And delivery instructions are entered
    And the ISIN/Sedol are entered
    And the Security Currency are entered
    And the Clearing Broker ID - Euroclear is entered
    And the Clearing Broker ID is entered
    And the YBEN or NBEN is entered
    And the user could review the content of the ticket and submits it
    And An authorized person approves the ticket
    Then a child ticket is created and is routed to the processing team <teamName> <teamCode>

Examples:
|assetTypeName|assetTypeCode|deliveryAcct|cusip|teamName|teamCode|
|"Local Market"|321|0|0|"International Settlements - Manual"|14300|
|"Euroclear"|310|"H85377002"|"3925009F3"|"International Settlements - Manual"|14300|

  @External @Partial @14300
Scenario Outline: External partial transfer, ID 14300, Deliv Intr. Set 2
    Given the user is logged into Security Transfer
    And the user creates a ticket based off the account <deliveryAcct>
    And the user makes ticket an external partial transfer
    When the user enters an external account to recieve the assets
    And the user selects the asset to transfer <assetTypeName> <assetTypeCode> <cusip>
    And delivery instructions are entered
    And the ISIN/Sedol are entered
    And the Security Currency are entered
    And the Trading Broker BIC is entered
    And the Trading Broker Sub Account Info is entered
    And the YBEN or NBEN is entered
    And the Clearing Broker BIC is entered
    And the Clearing Broker Code is entered
    And the user could review the content of the ticket and submits it
    And An authorized person approves the ticket
    Then a child ticket is created and is routed to the processing team <teamName> <teamCode>

Examples:
|assetTypeName|assetTypeCode|deliveryAcct|cusip|teamName|teamCode|
|"Local Market Global"|320|"A77597002"|"J6571N923"|"International Settlements - Manual"|14300|

  @Internal @Partial @14380
Scenario Outline: Internal partial transfer, ID 14380
    Given the user is logged into Security Transfer
    And the user creates a ticket based off the account <deliveryAcct>
    And the user makes ticket an internal partial transfer
    When the user selects an internal account to recieve the assets <receivingAcct>
    And the user selects the asset to transfer <assetTypeName> <assetTypeCode> <cusip>
    And delivery instructions are entered
    And the user could review the content of the ticket and submits it
    And An authorized person approves the ticket
    Then a child ticket is created and is routed to the processing team <teamName> <teamCode>

Examples:
|assetTypeName|assetTypeCode|deliveryAcct|cusip|teamName|teamCode|receivingAcct|
|"Foreign Time Deposit"|270|"M44802003"|"2551N99Y3"|"Foreign Time Deposit"|14380|"Q66651003"|

  @OmniMargin @Partial @14387
Scenario Outline: Omni to Margin partial transfer, ID 14387
    Given the user is logged into Security Transfer
    And the user creates a ticket based off the account <deliveryAcct>
    And the user makes ticket a margin partial transfer
    When the user selects an internal account to recieve the assets for margin <receivingAcct>
    And the user selects the asset to transfer <assetTypeName> <assetTypeCode> <cusip>
    And delivery instructions are entered
    And the Trailer Description is entered
    And the ISIN/Sedol are entered
    And the Security Currency are entered
    And the Clearing Broker Code is entered
    And the YBEN or NBEN is entered
    And the Trading Broker Name is entered
    And the Trading Broker BIC is entered
    And the Trading Broker Sub Account Info is entered
    And the Clearing Broker BIC is entered
    And the Clearing Broker Name is entered
    And the user could review the content of the ticket and submits it
    And An authorized person approves the ticket
    Then a child ticket is created and is routed to the processing team <teamName> <teamCode>

Examples:
|assetTypeName|assetTypeCode|deliveryAcct|cusip|teamName|teamCode|receivingAcct|
|"Euroclear"|310|"H85377002"|"3925009F3"|"OMNI/Margin Transfer"|14387|2410361220101|
|"Local Market Global"|320|"A77597002"|"J6571N923"|"OMNI/Margin Transfer"|14387|2410361220101|

  @MarginOmni @Partial @14387
Scenario Outline: Margin to Omni partial transfer, ID 14387
    Given the user is logged into Security Transfer
    And the user creates a ticket based off the account <deliveryAcct>
    And the user makes ticket an internal partial transfer
    When the user selects an internal account to recieve the assets <receivingAcct>
    And the user selects the asset to transfer <assetTypeName> <assetTypeCode> <cusip>
    And delivery instructions are entered
    And the user could review the content of the ticket and submits it
    And An authorized person approves the ticket
    Then a child ticket is created and is routed to the processing team <teamName> <teamCode>

Examples:
|assetTypeName|assetTypeCode|deliveryAcct|cusip|teamName|teamCode|receivingAcct|
|"Euroclear"|310|0|0|"OMNI/Margin Transfer"|14387|"Q66651003"|
|"Local Market Global"|320|0|0|"OMNI/Margin Transfer"|14387|"Q66651003"|

  @MarginExternal @Partial @14387
Scenario Outline: Margin to External partial transfer, ID 14387
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
|assetTypeName|assetTypeCode|deliveryAcct|cusip|teamName|teamCode|
|"Euroclear"|310|0|0|"OMNI/Margin Transfer"|14387|
|"Local Market Global"|320|0|0|"OMNI/Margin Transfer"|14387|
