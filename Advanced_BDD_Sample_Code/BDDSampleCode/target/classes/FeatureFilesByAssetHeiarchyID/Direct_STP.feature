@SecTransRouting @DirectSTP @14030
Feature: Direct STP

  @External @Partial
Scenario Outline: External partial transfer, ID 14030, Deliv Intr. Set 1
    Given the user is logged into Security Transfer
    And the user creates a ticket based off the account <deliveryAcct>
    And the user makes ticket an external partial transfer
    When the user enters an external account to recieve the assets
    And the user selects the asset to transfer <assetTypeName> <assetTypeCode> <cusip>
    And delivery instructions are entered
    And the Tax Code is entered
    And the user could review the content of the ticket and submits it
    And An authorized person approves the ticket
    Then a child ticket is created and is routed to the processing team <teamName> <teamCode>

Examples:
|assetTypeName|assetTypeCode|deliveryAcct|cusip|teamName|teamCode|
|"Master trust"|230|"A14239007"|"4812A3528"|"Direct STP"|14030|
|"3rd Party Funds (Credit Suisse Funds)"|400|0|0|"Direct STP"|14030|
|"NCAA Memo"|350|0|0|"Direct STP"|14030|
|"Memo"|120|"P19620304"|"999388531"|"Direct STP"|14030|
|"Memo - Ext Above 90"|122|0|0|"Direct STP"|14030|
|"Local Vault Physical"|160|0|0|"Direct STP"|14030|

  @External @Partial
Scenario Outline: External partial transfer, ID 14030, Deliv Intr. Set 2
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
|"DTC"|220|"A77597002"|"G5480U104"|"Direct STP"|14030|
|"DTC - Fractions"|222|"W40626009"|"02147RAN0"|"Direct STP"|14030|

  @External @Partial
Scenario Outline: External partial transfer, ID 14030, Deliv Intr. Set 3
    Given the user is logged into Security Transfer
    And the user creates a ticket based off the account <deliveryAcct>
    And the user makes ticket an external partial transfer
    When the user enters an external account to recieve the assets
    And the user selects the asset to transfer <assetTypeName> <assetTypeCode> <cusip>
    And delivery instructions are entered
    And the ABA Number, Bank Name, Feb Sub Account, and Trading Broker is entered based off the Broker Search
    And the user could review the content of the ticket and submits it
    And An authorized person approves the ticket
    Then a child ticket is created and is routed to the processing team <teamName> <teamCode>

Examples:
|assetTypeName|assetTypeCode|deliveryAcct|cusip|teamName|teamCode|
|"FRB"|240|"A42689009"|"912833KZ2"|"Direct STP"|14030|
|"FRB - Fractions"|242|"A42689009"|"3137A05F8"|"Direct STP"|14030|

  @Internal @Partial
Scenario Outline: Internal partial transfer, ID 14030, Deliv Intr. Set 1
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
|"Cash - Non-Fiduciary"|100|0|0|"Direct STP"|14030|"Q66651003"|
|"Cash - Fiduciary"|102|0|0|"Direct STP"|14030|"Q66651003"|
|"Closely Held - Non-Managed"|210|0|0|"Direct STP"|14030|"Q66651003"|
|"DTC"|220|"A77597002"|"G5480U104"|"Direct STP"|14030|"Q66651003"|
|"DTC - Fractions"|222|"W40626009"|"02147RAN0"|"Direct STP"|14030|"Q66651003"|
|"Master trust"|230|"A14239007"|"4812A3528"|"Direct STP"|14030|"Q66651003"|
|"FRB"|240|"A42689009"|"912833KZ2"|"Direct STP"|14030|"Q66651003"|
|"FRB - Fractions"|242|"A42689009"|"3137A05F8"|"Direct STP"|14030|"Q66651003"|
|"Trust Liabilities"|250|0|0|"Direct STP"|14030|"Q66651003"|
|"3rd Party Funds (Credit Suisse Funds)"|400|0|0|"Direct STP"|14030|"Q66651003"|
|"Sweep"|440|"A00558006"|870994969|"Direct STP"|14030|"Q66651003"|
|"GIC/GAC Memo"|180|0|0|"Direct STP"|14030|"Q66651003"|
|"Memo - Ext Above 90"|122|0|0|"Direct STP"|14030|"Q66651003"|
|"Local Vault Physical"|160|0|0|"Direct STP"|14030|"Q66651003"|

  @Internal @Partial
Scenario Outline: Internal partial transfer, ID 14030, Deliv Intr. Set 2
    Given the user is logged into Security Transfer
    And the user creates a ticket based off the account <deliveryAcct>
    And the user makes ticket an internal partial transfer
    When the user selects an internal account to recieve the assets <receivingAcct>
    And the user selects the asset to transfer <assetTypeName> <assetTypeCode> <cusip>
    And delivery instructions are entered
    And the Dividend Option - Reinvest or Cash is entered
    And the Tax Code is entered
    And the user could review the content of the ticket and submits it
    And An authorized person approves the ticket
    Then a child ticket is created and is routed to the processing team <teamName> <teamCode>

Examples:
|assetTypeName|assetTypeCode|deliveryAcct|cusip|teamName|teamCode|receivingAcct|
|"JPM Fund"|140|"A00095009"|"4812A1266"|"Direct STP"|14030|"Q66651003"|

  @Internal @Partial
Scenario Outline: Internal partial transfer, ID 14030, Deliv Intr. Set 3
    Given the user is logged into Security Transfer
    And the user creates a ticket based off the account <deliveryAcct>
    And the user makes ticket an internal partial transfer
    When the user selects an internal account to recieve the assets <receivingAcct>
    And the user selects the asset to transfer <assetTypeName> <assetTypeCode> <cusip>
    And delivery instructions are entered
    And the Tax Code is entered
    And the user could review the content of the ticket and submits it
    And An authorized person approves the ticket
    Then a child ticket is created and is routed to the processing team <teamName> <teamCode>

Examples:
|assetTypeName|assetTypeCode|deliveryAcct|cusip|teamName|teamCode|receivingAcct|
|"Memo"|120|"P19620304"|"999388531"|"Direct STP"|14030|"Q66651003"|

  @OmniMargin @Partial
Scenario Outline: Omni to Margin partial transfer, ID 14030
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
|"Memo"|120|"P19620304"|"999388531"|"Direct STP"|14030|2410361220101|
|"NCAA Memo"|350|0|0|"Direct STP"|14030|2410361220101|
|"Memo - Ext Above 90"|122|0|0|"Direct STP"|14030|2410361220101|
|"Local Vault Physical"|160|0|0|"Direct STP"|14030|2410361220101|

  @MarginMargin @Partial
Scenario Outline: Margin to Margin partial transfer, ID 14030
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
|"DTC"|220|0|0|"Direct STP"|14030|2410361220101|
|"DTC - Fractions"|222|0|0|"Direct STP"|14030|2410361220101|
|"Master trust"|230|0|0|"Direct STP"|14030|2410361220101|
|"FRB"|240|0|0|"Direct STP"|14030|2410361220101|
|"FRB - Fractions"|242|0|0|"Direct STP"|14030|2410361220101|
|"3rd Party Funds (Credit Suisse Funds)"|400|0|0|"Direct STP"|14030|2410361220101|
|"Structured Products"|370|0|0|"Direct STP"|14030|2410361220101|
|"NCAA Memo"|350|0|0|"Direct STP"|14030|2410361220101|
|"Memo - Ext Above 90"|122|0|0|"Direct STP"|14030|2410361220101|
|"Local Vault Physical"|160|0|0|"Direct STP"|14030|2410361220101|
