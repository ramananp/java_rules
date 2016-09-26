@SecTransRouting @Physical
Feature: Physical

  @Internal @Partial @14070
Scenario Outline: Internal partial transfer, ID 14070
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
|"Local Vault Physical - Chicago"|170|"W44769003"|"Z07197009"|"Physical Items - Chicago National Vault"|14070|"Q66651003"|

  @Internal @Partial @14080
Scenario Outline: Internal partial transfer, ID 14080
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
|"Physical"|130|0|0|"Physical Restricted"|14080|"Q66651003"|
|"Physical"|132|0|0|"Physical Restricted"|14080|"Q66651003"|
|"Private Placements"|150|0|0|"Physical Restricted"|14080|"Q66651003"|
|"Physical Restricted"|330|"W99905007"|"981245XX6"|"Physical Restricted"|14080|"Q66651003"|
|"Physical Restricted - ATT"|332|0|0|"Physical Restricted"|14080|"Q66651003"|

  @External @Partial @14330
Scenario Outline: External partial transfer, ID 14330
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
|"Local Vault Physical - Chicago"|170|"W44769003"|"Z07197009"|"Physical Items - Chicago National Vault"|14330|

  @OmniMargin @Partial @14330
Scenario Outline: Omni to Margin partial transfer, ID 14330
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
|"Local Vault Physical - Chicago"|170|"W44769003"|"Z07197009"|"Physical Items - Chicago National Vault"|14330|2410361220101|

  @External @Partial @14400
Scenario Outline: External partial transfer, ID 14400
    Given the user is logged into Security Transfer
    And the user creates a ticket based off the account <deliveryAcct>
    And the user makes ticket an external partial transfer
    When the user enters an external account to recieve the assets
    And the user selects the asset to transfer <assetTypeName> <assetTypeCode> <cusip>
    And delivery instructions are entered
    And the Contact Name is entered
    And the Contact Phone Number is entered
    And the Street Address is entered
    And the City, State, Zip is entered
    And the Receiving Firm name or Client Name is entered
    And the user could review the content of the ticket and submits it
    And An authorized person approves the ticket
    Then a child ticket is created and is routed to the processing team <teamName> <teamCode>

Examples:
|assetTypeName|assetTypeCode|deliveryAcct|cusip|teamName|teamCode|
|"Physical"|130|0|0|"Physical Settlement External Request"|14400|
|"Physical"|132|0|0|"Physical Settlement External Request"|14400|
|"Physical Restricted"|330|"W99905007"|"981245XX6"|"Physical Settlement External Request"|14400|
|"Physical Restricted - ATT"|332|0|0|"Physical Settlement External Request"|14400|

  @OmniMargin @Partial @14400
Scenario Outline: Omni to Margin partial transfer, ID 14400
    Given the user is logged into Security Transfer
    And the user creates a ticket based off the account <deliveryAcct>
    And the user makes ticket a margin partial transfer
    When the user selects an internal account to recieve the assets for margin <receivingAcct>
    And the user selects the asset to transfer <assetTypeName> <assetTypeCode> <cusip>
    And delivery instructions are entered
    And the Contact Name is entered
    And the Contact Phone Number is entered
    And the Trailer Description is entered
    And the user could review the content of the ticket and submits it
    And An authorized person approves the ticket
    Then a child ticket is created and is routed to the processing team <teamName> <teamCode>

Examples:
|assetTypeName|assetTypeCode|deliveryAcct|cusip|teamName|teamCode|receivingAcct|
|"Physical"|130|0|0|"Physical Settlement External Request"|14400|2410361220101|
|"Physical"|132|0|0|"Physical Settlement External Request"|14400|2410361220101|
|"Private Placements"|150|0|0|"Physical Settlement External Request"|14400|2410361220101|
|"Physical Restricted"|330|"W99905007"|"981245XX6"|"Physical Settlement External Request"|14400|2410361220101|
|"Physical Restricted - ATT"|332|0|0|"Physical Settlement External Request"|14400|2410361220101|
