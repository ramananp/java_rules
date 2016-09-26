@CompleteTestSuite @SingleOut
Feature: Security Transfer - Full


  @Internal @Full @14030
  Scenario Outline: Internal full transfer, ID 14340
    Given the user is logged into Security Transfer
    And the user creates a ticket based off the account <deliveryAcct>
    And the user makes ticket an internal full transfer
    And the user sets an internal account to receive all of the assets of the account <receivingAcct>
    And targeted asset is transfered <assetTypeName> <assetTypeCode> <cusip>
    And delivery instructions are entered for internal full transfers
    When the user could review the content of the ticket and submits it
    And An authorized person approves the ticket
    And Two members of the credit team approve the parent ticket
    Then child tickets are created and the targeted asset is routed to the correct processing team <teamName> <teamCode>

    Examples: 
      | assetTypeName           | assetTypeCode | deliveryAcct | cusip     | teamName | teamCode | receivingAcct |
      | "Offshore Mutual Funds" | "420"         | "M50973003"  | 234125912 | "ATT"    | 14160    | "Q66651003"   |

  @External @Full @14030
  Scenario Outline: External full transfer, ID 14340
    Given the user is logged into Security Transfer
    And the user creates a ticket based off the account <deliveryAcct>
    And the user makes ticket an external full transfer
    And the user enters in an external account to receive all of the assets of the account
    And targeted asset is transfered <assetTypeName> <assetTypeCode> <cusip>
    And delivery instructions are entered for external full transfers
    When the user could review the content of the ticket and submits it
    And An authorized person approves the ticket
    And Two members of the credit team approve the parent ticket
    Then child tickets are created and the targeted asset is routed to the correct processing team <teamName> <teamCode>

    Examples: 
      | assetTypeName           | assetTypeCode | deliveryAcct | cusip     | teamName | teamCode |
      | "Offshore Mutual Funds" | "420"         | "M50973003"  | 234125912 | "ATT"    | 14160    |
