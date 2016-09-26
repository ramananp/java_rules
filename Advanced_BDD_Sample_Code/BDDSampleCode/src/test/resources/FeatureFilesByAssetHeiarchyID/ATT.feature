@SecTransRouting @ATT
Feature: ATT

  @Internal @Partial @14160
Scenario Outline: Internal partial transfer, ID 14160
    Given the user is logged into Security Transfer
    And the user creates a ticket based off the account <deliveryAcct>
    And the user makes ticket an internal partial transfer
    When the user selects an internal account to recieve the assets <receivingAcct>
    And the user selects the asset to transfer <assetTypeName> <assetTypeCode> <cusip>
    And delivery instructions are entered
    #And the Dividend Option - Reinvest or Cash is entered
    And the user could review the content of the ticket and submits it
    And An authorized person approves the ticket
    Then a child ticket is created and is routed to the processing team <teamName> <teamCode>

Examples:
|assetTypeName|assetTypeCode|deliveryAcct|cusip|teamName|teamCode|receivingAcct|
|"Offshore Mutual Funds"|420|"M50973003"|234125912|"ATT"|14160|"Q66651003"|
|"Liquidity Fund"|415|0|0|"ATT"|14160|"Q66651003"|
|"Stock Lending"|430|0|0|"ATT"|14160|"Q66651003"|

  @External @Partial @14260
Scenario Outline: External partial transfer, ID 14260, Deliv Intr. Set 1
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
|"Cash - Fiduciary"|102|0|0|"ATT"|14260|
|"Cash - Non-Fiduciary"|100|0|0|"ATT"|14260|
|"Stock Lending"|430|0|0|"ATT"|14260|
|"Sweep"|440|"A00558006"|870994969|"ATT"|14260|

  @External @Partial @14260
Scenario Outline: External partial transfer, ID 14260, Deliv Intr. Set 2
    Given the user is logged into Security Transfer
    And the user creates a ticket based off the account <deliveryAcct>
    And the user makes ticket an external partial transfer
    When the user enters an external account to recieve the assets
    And the user selects the asset to transfer <assetTypeName> <assetTypeCode> <cusip>
    And delivery instructions are entered
    And the Tax Code is entered
    And the ABA Number, Bank Name, and Feb Sub Account is entered based off the Broker Search
    And the user could review the content of the ticket and submits it
    And An authorized person approves the ticket
    Then a child ticket is created and is routed to the processing team <teamName> <teamCode>

Examples:
|assetTypeName|assetTypeCode|deliveryAcct|cusip|teamName|teamCode|
|"GNMA - Fractions"|192|"W45361008"|"36218B2U0"|"ATT"|14260|
|"GNMA"|190|0|0|"ATT"|14260|

  @External @Partial @14260
Scenario Outline: External partial transfer, ID 14260, Deliv Intr. Set 3
    Given the user is logged into Security Transfer
    And the user creates a ticket based off the account <deliveryAcct>
    And the user makes ticket an external partial transfer
    When the user enters an external account to recieve the assets
    And the user selects the asset to transfer <assetTypeName> <assetTypeCode> <cusip>
    And delivery instructions are entered
    And the Mutual Fund Account Number is entered
    And the DTC/Broker Name and DTC Number are entered
    #And the Trailer Description is entered
    And the user could review the content of the ticket and submits it
    And An authorized person approves the ticket
    Then a child ticket is created and is routed to the processing team <teamName> <teamCode>

Examples:
|assetTypeName|assetTypeCode|deliveryAcct|cusip|teamName|teamCode|
|"Liquidity Fund"|415|0|0|"ATT"|14260|
|"Lux Fund"|410|"W99870003"|"054099916"|"ATT"|14260|

  @External @Partial @14260
Scenario Outline: External partial transfer, ID 14260, Deliv Intr. Set 4
    Given the user is logged into Security Transfer
    And the user creates a ticket based off the account <deliveryAcct>
    And the user makes ticket an external partial transfer
    When the user enters an external account to recieve the assets
    And the user selects the asset to transfer <assetTypeName> <assetTypeCode> <cusip>
    And delivery instructions are entered
    And the Fundsettle Account Number is entered
    And the DTC/Broker Name and DTC Number are entered
   	#And the Trailer Description is entered
    And the user could review the content of the ticket and submits it
    And An authorized person approves the ticket
    Then a child ticket is created and is routed to the processing team <teamName> <teamCode>

Examples:
|assetTypeName|assetTypeCode|deliveryAcct|cusip|teamName|teamCode|
|"Offshore Mutual Funds"|420|"M50973003"|234125912|"ATT"|14260|

  @OmniMargin @Partial @14260
Scenario Outline: Omni to Margin partial transfer, ID 14260, Deliv Intr. Set 1
    Given the user is logged into Security Transfer
    And the user creates a ticket based off the account <deliveryAcct>
    And the user makes ticket a margin partial transfer
    When the user selects an internal account to recieve the assets for margin <receivingAcct>
    And the user selects the asset to transfer <assetTypeName> <assetTypeCode> <cusip>
    And delivery instructions are entered
    And the Tax Code is entered
    And the Trailer Description is entered
    And the ABA Number, Bank Name, and Feb Sub Account is entered based off the Broker Search
    And the user could review the content of the ticket and submits it
    And An authorized person approves the ticket
    Then a child ticket is created and is routed to the processing team <teamName> <teamCode>

Examples:
|assetTypeName|assetTypeCode|deliveryAcct|cusip|teamName|teamCode|receivingAcct|
|"GNMA - Fractions"|192|"W45361008"|"36218B2U0"|"ATT"|14260|2410361220101|
|"GNMA"|190|0|0|"ATT"|14260|2410361220101|

  @OmniMargin @Partial @14260
Scenario Outline: Omni to Margin partial transfer, ID 14260, Deliv Intr. Set 2
    Given the user is logged into Security Transfer
    And the user creates a ticket based off the account <deliveryAcct>
    And the user makes ticket a margin partial transfer
    When the user selects an internal account to recieve the assets for margin <receivingAcct>
    And the user selects the asset to transfer <assetTypeName> <assetTypeCode> <cusip>
    And delivery instructions are entered
    And the Trailer Description is entered
    And the Mutual Fund Account Number is entered
    And the user could review the content of the ticket and submits it
    And An authorized person approves the ticket
    Then a child ticket is created and is routed to the processing team <teamName> <teamCode>

Examples:
|assetTypeName|assetTypeCode|deliveryAcct|cusip|teamName|teamCode|receivingAcct|
|"Lux Fund"|410|"W99870003"|"054099916"|"ATT"|14260|2410361220101|

  @OmniMargin @Partial @14260
Scenario Outline: Omni to Margin partial transfer, ID 14260, Deliv Intr. Set 3
    Given the user is logged into Security Transfer
    And the user creates a ticket based off the account <deliveryAcct>
    And the user makes ticket a margin partial transfer
    When the user selects an internal account to recieve the assets for margin <receivingAcct>
    And the user selects the asset to transfer <assetTypeName> <assetTypeCode> <cusip>
    And delivery instructions are entered
    And the Trailer Description is entered
    And the Fundsettle Account Number is entered
    And the user could review the content of the ticket and submits it
    And An authorized person approves the ticket
    Then a child ticket is created and is routed to the processing team <teamName> <teamCode>

Examples:
|assetTypeName|assetTypeCode|deliveryAcct|cusip|teamName|teamCode|receivingAcct|
|"Offshore Mutual Funds"|420|"M50973003"|234125912|"ATT"|14260|2410361220101|
|"Liquidity Fund"|415|0|0|"ATT"|14260|2410361220101|
|"Stock Lending"|430|0|0|"ATT"|14260|2410361220101|

  @OmniMargin @Partial @14260
Scenario Outline: Omni to Margin partial transfer, ID 14260, Deliv Intr. Set 4
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
|"Closely Held - Non-Managed"|210|0|0|"ATT"|14260|2410361220101|

  @External @Partial @14360
Scenario Outline: External partial transfer, ID 14360
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
|"JPM Fund"|140|"A00095009"|"4812A1266"|"ATT"|14360|

  @OmniMargin @Partial @14360
Scenario Outline: Omni to Margin partial transfer, ID 14360
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
|"JPM Fund"|140|"A00095009"|"4812A1266"|"Foreign Time Deposit"|14380|2410361220101|
