@SecTransRouting @Other
Feature: Other

  @Internal @Partial @14100
Scenario Outline: Internal partial transfer, ID 14100
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
|"Listed Options"|360|0|0|"PCG Derivatives"|14100|"Q66651003"|
|"Listed Options - Negative"|362|0|0|"PCG Derivatives"|14100|"Q66651003"|

  @External @Partial @14140
Scenario Outline: External partial transfer, ID 14140
    Given the user is logged into Security Transfer
    And the user creates a ticket based off the account <deliveryAcct>
    And the user makes ticket an external partial transfer
    When the user enters an external account to recieve the assets
    And the user selects the asset to transfer <assetTypeName> <assetTypeCode> <cusip>
    And delivery instructions are entered
    And the Trailer Description is entered
    And the user could review the content of the ticket and submits it
    And An authorized person approves the ticket
    Then a child ticket is created and is routed to the processing team <teamName> <teamCode>

Examples:
|assetTypeName|assetTypeCode|deliveryAcct|cusip|teamName|teamCode|
|"Life Insurance Off-Site Memo"|340|0|0|"ILIT"|14140|

  @Internal @Partial @14140
Scenario Outline: Internal partial transfer, ID 14140
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
|"Life Insurance Off-Site Memo"|340|0|0|"ILIT"|14140|"Q66651003"|

  @OmniMargin @Partial @14140
Scenario Outline: Omni to Margin partial transfer, ID 14140
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
|"Life Insurance Off-Site Memo"|340|0|0|"ILIT"|14140|2410361220101|

  @Internal @Partial @14150
Scenario Outline: Internal partial transfer, ID 14150
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
|"NCAA Memo"|350|0|0|"NCAA"|14150|"Q66651003"|

  @MarginMargin @Partial @14270
Scenario Outline: Margin to Margin partial transfer, ID 14270
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
|"Memo"|120|0|0|"Margin"|14270|2410361220101|
|"Memo - Ext Above 90"|122|0|0|"Margin"|14270|2410361220101|
|"Physical"|130|0|0|"Margin"|14270|2410361220101|
|"Physical"|132|0|0|"Margin"|14270|2410361220101|
|"JPM Fund"|140|0|0|"Margin"|14270|2410361220101|
|"Private Placements"|150|0|0|"Margin"|14270|2410361220101|
|"Local Vault Physical"|160|0|0|"Margin"|14270|2410361220101|
|"Local Vault Physical - Chicago"|170|0|0|"Margin"|14270|2410361220101|
|"GIC/GAC Memo"|180|0|0|"Margin"|14270|2410361220101|
|"GNMA"|190|0|0|"Margin"|14270|2410361220101|
|"GNMA - Fractions"|192|0|0|"Margin"|14270|2410361220101|
|"Closely Held - Managed"|200|0|0|"Margin"|14270|2410361220101|
|"Closely Held - Non-Managed"|210|0|0|"Margin"|14270|2410361220101|
|"DTC"|220|0|0|"Margin"|14270|2410361220101|
|"DTC - Fractions"|222|0|0|"Margin"|14270|2410361220101|
|"Master trust"|230|0|0|"Margin"|14270|2410361220101|
|"FRB"|240|0|0|"Margin"|14270|2410361220101|
|"FRB - Fractions"|242|0|0|"Margin"|14270|2410361220101|
|"Euroclear"|310|0|0|"Margin"|14270|2410361220101|
|"Local Market Global"|320|0|0|"Margin"|14270|2410361220101|
|"Physical Restricted"|330|0|0|"Margin"|14270|2410361220101|
|"Physical Restricted - ATT"|332|0|0|"Margin"|14270|2410361220101|
|"Life Insurance Off-Site Memo"|340|0|0|"Margin"|14270|2410361220101|
|"NCAA Memo"|350|0|0|"Margin"|14270|2410361220101|
|"Listed Options"|360|0|0|"Margin"|14270|2410361220101|
|"Listed Options - Negative"|362|0|0|"Margin"|14270|2410361220101|
|"Structured Products"|370|0|0|"Margin"|14270|2410361220101|
|"3rd Party Funds"|380|0|0|"Margin"|14270|2410361220101|
|"3rd Party Funds - Manual (Issuer Direct Funds)"|390|0|0|"Margin"|14270|2410361220101|
|"3rd Party Funds (Credit Suisse Funds)"|400|0|0|"Margin"|14270|2410361220101|
|"Lux Fund"|410|0|0|"Margin"|14270|2410361220101|
|"Liquidity Fund"|415|0|0|"Margin"|14270|2410361220101|
|"Offshore Mutual Funds"|420|0|0|"Margin"|14270|2410361220101|
|"Stock Lending"|430|0|0|"Margin"|14270|2410361220101|
|"Euroclear - Structured Products"|450|0|0|"Margin"|14270|2410361220101|
|"Private Investments"|90|0|0|"Margin"|14270|2410361220101|

  @MarginOmni @Partial @14270
Scenario Outline: Margin to Omni partial transfer, ID 14270
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
|"Memo"|120|0|0|"Margin"|14270|"Q66651003"|
|"Memo - Ext Above 90"|122|0|0|"Margin"|14270|"Q66651003"|
|"Physical"|130|0|0|"Margin"|14270|"Q66651003"|
|"Physical"|132|0|0|"Margin"|14270|"Q66651003"|
|"JPM Fund"|140|0|0|"Margin"|14270|"Q66651003"|
|"Private Placements"|150|0|0|"Margin"|14270|"Q66651003"|
|"Local Vault Physical"|160|0|0|"Margin"|14270|"Q66651003"|
|"Local Vault Physical - Chicago"|170|0|0|"Margin"|14270|"Q66651003"|
|"GIC/GAC Memo"|180|0|0|"Margin"|14270|"Q66651003"|
|"GNMA"|190|0|0|"Margin"|14270|"Q66651003"|
|"GNMA - Fractions"|192|0|0|"Margin"|14270|"Q66651003"|
|"Closely Held - Managed"|200|0|0|"Margin"|14270|"Q66651003"|
|"Closely Held - Non-Managed"|210|0|0|"Margin"|14270|"Q66651003"|
|"DTC"|220|0|0|"Margin"|14270|"Q66651003"|
|"DTC - Fractions"|222|0|0|"Margin"|14270|"Q66651003"|
|"Master trust"|230|0|0|"Margin"|14270|"Q66651003"|
|"FRB"|240|0|0|"Margin"|14270|"Q66651003"|
|"FRB - Fractions"|242|0|0|"Margin"|14270|"Q66651003"|
|"Physical Restricted"|330|0|0|"Margin"|14270|"Q66651003"|
|"Physical Restricted - ATT"|332|0|0|"Margin"|14270|"Q66651003"|
|"Life Insurance Off-Site Memo"|340|0|0|"Margin"|14270|"Q66651003"|
|"NCAA Memo"|350|0|0|"Margin"|14270|"Q66651003"|
|"Listed Options"|360|0|0|"Margin"|14270|"Q66651003"|
|"Listed Options - Negative"|362|0|0|"Margin"|14270|"Q66651003"|
|"Structured Products"|370|0|0|"Margin"|14270|"Q66651003"|
|"3rd Party Funds"|380|0|0|"Margin"|14270|"Q66651003"|
|"3rd Party Funds - Manual (Issuer Direct Funds)"|390|0|0|"Margin"|14270|"Q66651003"|
|"3rd Party Funds (Credit Suisse Funds)"|400|0|0|"Margin"|14270|"Q66651003"|
|"Lux Fund"|410|0|0|"Margin"|14270|"Q66651003"|
|"Liquidity Fund"|415|0|0|"Margin"|14270|"Q66651003"|
|"Offshore Mutual Funds"|420|0|0|"Margin"|14270|"Q66651003"|
|"Stock Lending"|430|0|0|"Margin"|14270|"Q66651003"|
|"Euroclear - Structured Products"|450|0|0|"Margin"|14270|"Q66651003"|
|"Private Investments"|90|0|0|"Margin"|14270|"Q66651003"|

  @MarginExternal @Partial @14270
Scenario Outline: Margin to External partial transfer, ID 14270
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
|"Memo"|120|0|0|"Margin"|14270|
|"Memo - Ext Above 90"|122|0|0|"Margin"|14270|
|"Physical"|130|0|0|"Margin"|14270|
|"Physical"|132|0|0|"Margin"|14270|
|"JPM Fund"|140|0|0|"Margin"|14270|
|"Private Placements"|150|0|0|"Margin"|14270|
|"Local Vault Physical"|160|0|0|"Margin"|14270|
|"Local Vault Physical - Chicago"|170|0|0|"Margin"|14270|
|"GIC/GAC Memo"|180|0|0|"Margin"|14270|
|"GNMA"|190|0|0|"Margin"|14270|
|"GNMA - Fractions"|192|0|0|"Margin"|14270|
|"Closely Held - Managed"|200|0|0|"Margin"|14270|
|"Closely Held - Non-Managed"|210|0|0|"Margin"|14270|
|"DTC"|220|0|0|"Margin"|14270|
|"DTC - Fractions"|222|0|0|"Margin"|14270|
|"Master trust"|230|0|0|"Margin"|14270|
|"FRB"|240|0|0|"Margin"|14270|
|"FRB - Fractions"|242|0|0|"Margin"|14270|
|"Physical Restricted"|330|0|0|"Margin"|14270|
|"Physical Restricted - ATT"|332|0|0|"Margin"|14270|
|"Life Insurance Off-Site Memo"|340|0|0|"Margin"|14270|
|"NCAA Memo"|350|0|0|"Margin"|14270|
|"Listed Options"|360|0|0|"Margin"|14270|
|"Listed Options - Negative"|362|0|0|"Margin"|14270|
|"Structured Products"|370|0|0|"Margin"|14270|
|"3rd Party Funds"|380|0|0|"Margin"|14270|
|"3rd Party Funds - Manual (Issuer Direct Funds)"|390|0|0|"Margin"|14270|
|"OTC Equity Derivative"|40|0|0|"Margin"|14270|
|"3rd Party Funds (Credit Suisse Funds)"|400|0|0|"Margin"|14270|
|"Lux Fund"|410|0|0|"Margin"|14270|
|"Liquidity Fund"|415|0|0|"Margin"|14270|
|"Offshore Mutual Funds"|420|0|0|"Margin"|14270|
|"Stock Lending"|430|0|0|"Margin"|14270|
|"Euroclear - Structured Products"|450|0|0|"Margin"|14270|
|"Private Investments"|90|0|0|"Margin"|14270|

  @External @Partial @14320
Scenario Outline: External partial transfer, ID 14320
    Given the user is logged into Security Transfer
    And the user creates a ticket based off the account <deliveryAcct>
    And the user makes ticket an external partial transfer
    When the user enters an external account to recieve the assets
    And the user selects the asset to transfer <assetTypeName> <assetTypeCode> <cusip>
    And delivery instructions are entered
    And the Trailer Description is entered
    And the user could review the content of the ticket and submits it
    And An authorized person approves the ticket
    Then a child ticket is created and is routed to the processing team <teamName> <teamCode>

Examples:
|assetTypeName|assetTypeCode|deliveryAcct|cusip|teamName|teamCode|
|"Listed Options"|360|0|0|"PCG Derivatives - External"|14320|
|"Listed Options - Negative"|362|0|0|"PCG Derivatives - External"|14320|

  @OmniMargin @Partial @14320
Scenario Outline: Omni to Margin partial transfer, ID 14320
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
|"Listed Options"|360|0|0|"PCG Derivatives - External"|14320|2410361220101|
|"Listed Options - Negative"|362|0|0|"PCG Derivatives - External"|14320|2410361220101|

  @Internal @Partial @14370
Scenario Outline: Internal partial transfer, ID 14370
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
|"GNMA"|190|0|0|"ATT"|14370|"Q66651003"|
|"GNMA - Fractions"|192|"W45361008"|"36218B2U0"|"ATT"|14370|"Q66651003"|

  @External @Partial @14410
Scenario Outline: External partial transfer, ID 14410
    Given the user is logged into Security Transfer
    And the user creates a ticket based off the account <deliveryAcct>
    And the user makes ticket an external partial transfer
    When the user enters an external account to recieve the assets
    And the user selects the asset to transfer <assetTypeName> <assetTypeCode> <cusip>
    And delivery instructions are entered
    And the Trailer Description is entered
    And the user could review the content of the ticket and submits it
    And An authorized person approves the ticket
    Then a child ticket is created and is routed to the processing team <teamName> <teamCode>

Examples:
|assetTypeName|assetTypeCode|deliveryAcct|cusip|teamName|teamCode|receivingAcct|
|"GIC/GAC Memo"|180|0|0|"GIC/GAC Memo ILIT External Request"|14410|"Q66651003"|

  @External @Partial @14420
Scenario Outline: External partial transfer, ID 14420
    Given the user is logged into Security Transfer
    And the user creates a ticket based off the account <deliveryAcct>
    And the user makes ticket an external partial transfer
    When the user enters an external account to recieve the assets
    And the user selects the asset to transfer <assetTypeName> <assetTypeCode> <cusip>
    And delivery instructions are entered
    And the Trailer Description is entered
    And the user could review the content of the ticket and submits it
    And An authorized person approves the ticket
    Then a child ticket is created and is routed to the processing team <teamName> <teamCode>

Examples:
|assetTypeName|assetTypeCode|deliveryAcct|cusip|teamName|teamCode|
|"Fiduciary Loan Assets - Chicago Vault"|171|0|0|"Fiduciary Loan Assets - Chicago External"|14420|

  @Internal @Partial @14420
Scenario Outline: Internal partial transfer, ID 14420
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
|"Fiduciary Loan Assets - Chicago Vault"|171|0|0|"Fiduciary Loan Assets - Chicago External"|14420|"Q66651003"|
