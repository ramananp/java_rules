@CompleteTestSuite @SecTrans @Internal @Full
Feature: SecTrans Internal Full

Scenario Outline: SecTrans Internal Full Transfers
    Given the user is logged into Security Transfer
    And the user creates a ticket based off the account <deliveryAcct>
    And the user makes ticket an internal full transfer
    And the user sets an internal account to receive all of the assets of the account <receivingAcct>
    And targeted asset is transfered <assetTypeName> <assetTypeCode> <cusip>
    And delivery instructions are entered for internal full transfers
    When the user could review the content of the ticket and submits it
    And An authorized person approves the ticket
    #And Two members of the credit team approve the parent ticket
    Then child tickets are created and the targeted asset is routed to the correct processing team <teamName> <teamCode>

Examples:
|assetTypeName|assetTypeCode|deliveryAcct|cusip|teamName|teamCode|receivingAcct|
|"DTC"|220|"A00028000"|"78462F103"|"Direct STP"|14030|"Q66651003"|
|"Cash - Non-Fiduciary"|100|"A00011006"|"0USDPRAA7"|"Cash - External Full"|14461|"Q66651003"|
|"Sweep"|440|"A00028000"|"870994969"|"Cash - External Full"|14461|"Q66651003"|
|"Physical Reg 91"|130|"M46935009"|"564553XX8"|"Physical Restricted"|14080|"Q66651003"|
|"Physical Reg 93"|132|"C88737009"|"166400BH3"|"Physical Restricted"|14080|"Q66651003"|
|"Euroclear"|310|"H85377002"|"3925009F3"|"International Settlements - STP"|14120|"Q66651003"|
|"Local Market Global"|320|"H77318006"|"706327913"|"International Settlements - STP"|14120|"Q66651003"|
|"JPM Fund"|140|"A00028000"|"46637K513"|"JPM Funds External Full"|14462|"Q66651003"|
|"3rd Party Funds"|380|"A00028000"|"302933205"|"3rd Party Mutual Funds - Full"|14350|"Q66651003"|
