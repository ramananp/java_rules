@CompleteTestSuite
Feature: Security Transfer - Full Many

  @External @FullMany @14030
  Scenario Outline: External full to many transfer, ID 14340
    Given the user is logged into Security Transfer
    And the user creates a ticket based off the account <deliveryAcct>
    And the user makes ticket an external full to many transfer
    And the user add external account and assigns target asset to transfer <assetTypeName> <assetTypeCode> <cusip>
    And the user adds another external account and assigns the rest of the assets
    And delivery instructions are entered for external full transfers
    When the user could review the content of the ticket and submits it
    And An authorized person approves the ticket
    And Two members of the credit team approve the parent ticket
    Then child tickets are created and the targeted asset is routed to the correct processing team <teamName> <teamCode>

    Examples: 
      | assetTypeName           | assetTypeCode | deliveryAcct | cusip     | teamName | teamCode |
      | "Offshore Mutual Funds" | 420           | "M50973003"  | 234125912 | "ATT"    | 14160    |
