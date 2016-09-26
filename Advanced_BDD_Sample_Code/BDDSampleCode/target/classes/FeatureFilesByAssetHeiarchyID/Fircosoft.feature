@SecTransRouting @Fircosoft
Feature: Fircosoft

  @External @Partial @14355
  Scenario Outline: External partial transfer, ID 14340
    Given the user is logged into Security Transfer
    And the user creates a ticket based off the account <deliveryAcct>
    And the user makes ticket an external partial transfer
    When the user enters an external account to recieve the assets with: Acct Title - <acctTitle>, Acct Number - <acctNumber>, Entity Name - <entityName>, Address - <address>, SSN/TIN - <ssn>, Date of Birth - <dateOfBirth>, and Country of Res - <countryOfRes>
    And the user selects the asset to transfer <assetTypeName> <assetTypeCode> <cusip>
    And delivery instructions are entered
    And the user could review the content of the ticket and submits it
    And An authorized person approves the ticket
    Then a child ticket is created and is routed to the processing team <teamName> <teamCode>

    Examples: 
      | assetTypeName         | assetTypeCode | deliveryAcct | cusip     | teamName              | teamCode | acctTitle          | acctNumber | entityName    | address       | ssn         | dateOfBirth  | countryOfRes |
      | "Private Investments" | 90            | "C87917008"  | 676529910 | "Private Investments" | 14340    | "Some Other Banks" | "1234"     | "Mike Novack" | "123 Main St" | "123456789" | "08/28/1992" | "USA"        |
