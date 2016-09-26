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
|"DTC"|220|"A000000"|"78462F103"|"Direct STP"|14030|"Q000000"|
|"Cash - Non-Fiduciary"|100|"A000000"|"0USDPRAA7"|"Cash - External Full"|14461|"Q000000"|
|"Sweep"|440|"A000000"|"870994969"|"Cash - External Full"|14461|"Q000000"|
|"Physical Reg 91"|130|"M000000"|"564553XX8"|"Physical Restricted"|14080|"Q000000"|
|"Physical Reg 93"|132|"C000000"|"166400BH3"|"Physical Restricted"|14080|"Q000000"|
|"Euroclear"|310|"H000000"|"3925009F3"|"International Settlements - STP"|14120|"Q000000"|
|"Local Market Global"|320|"H000000"|"706327913"|"International Settlements - STP"|14120|"Q000000"|
|"JPM Fund"|140|"A000000"|"46637K513"|"JPM Funds External Full"|14462|"Q000000"|
|"3rd Party Funds"|380|"A000000"|"302933205"|"3rd Party Mutual Funds - Full"|14350|"Q000000"|
