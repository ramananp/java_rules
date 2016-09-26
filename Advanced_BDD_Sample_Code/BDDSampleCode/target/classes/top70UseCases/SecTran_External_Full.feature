@CompleteTestSuite @SecTrans @External @Full
Feature: SecTrans External Full

Scenario Outline: Security Transfer Full Transfer (Other Assets)
    Given the user is logged into Security Transfer
    And the user creates a ticket based off the account <deliveryAcct>
    And the user makes ticket an external full transfer
    And the user enters in an external account to receive all of the assets of the account
    And targeted asset is transfered <assetTypeName> <assetTypeCode> <cusip>
    And delivery instructions are entered for external full transfers
    When the user could review the content of the ticket and submits it
    And An authorized person approves the ticket
    #And Two members of the credit team approve the parent ticket
    Then child tickets are created and the targeted asset is routed to the correct processing team <teamName> <teamCode>

Examples:
|assetTypeName|assetTypeCode|deliveryAcct|cusip|teamName|teamCode|
|"DTC"|220|"A00028000"|"78462F103"|"Direct STP"|14030|
|"Cash - Non-Fiduciary"|100|"A00011006"|"0USDPRAA7"|"Cash - External Full"|14461|
|"Sweep"|440|"A00028000"|"870994969"|"Cash - External Full"|14461|
|"Physical Reg 91"|130|"M46935009"|"564553XX8"|"Physical Settlement External Request"|14400|
|"Physical Reg 93"|132|"C88737009"|"166400BH3"|"Physical Settlement External Request"|14400|
|"Euroclear"|310|"H85377002"|"3925009F3"|"International Settlements - External Full"|14460|
|"Local Market Global"|320|"H77318006"|"706327913"|"International Settlements - External Full"|14460|
|"JPM Fund"|140|"A00028000"|"46637K513"|"JPM Funds External Full"|14462|

Scenario Outline: 3rd Party
    Given the user is logged into Security Transfer
    And the user creates a ticket based off the account <deliveryAcct>
    And the user makes ticket an external full transfer
    And the user enters in an external account to receive all of the assets of the account
    And targeted asset is transfered <assetTypeName> <assetTypeCode> <cusip>
    And delivery instructions are entered for external full transfers
    And the Tax Code is entered
    When the user could review the content of the ticket and submits it
    And An authorized person approves the ticket
    #And Two members of the credit team approve the parent ticket
    Then child tickets are created and the targeted asset is routed to the correct processing team <teamName> <teamCode>

Examples:
|assetTypeName|assetTypeCode|deliveryAcct|cusip|teamName|teamCode|
|"3rd Party Funds"|380|"A00028000"|"302933205"|"3rd Party Mutual Funds - Full"|14350|
