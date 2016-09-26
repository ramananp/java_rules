@CompleteTestSuite
Feature: Gift

  @External @Partial @Gift
  Scenario Outline: Gift External Electronic partial transfer, ID 14340
    Given the user is logged into Security Transfer
    And the user creates a ticket based off the account <deliveryAcct>
    And the user makes ticket an external gift transfer <giftType>
    When the user enters an external account to recieve the assets
    And the user selects the asset to transfer <assetTypeName> <assetTypeCode> <cusip>
    And delivery instructions are entered
    And the DTC/Broker Name and DTC Number are entered
    And information is entered in for the gift letters
    And the user could review the content of the ticket and submits it for a gift transfer
    And An authorized person approves the ticket
    And Mean Value Batch is executed
    And Two members of the credit team approve the parent ticket
    Then a child ticket is created and is routed to the processing team <teamName> <teamCode>

    Examples: 
      | deliveryAcct | giftType     | assetTypeName | assetTypeCode | cusip       | teamName     | teamCode |
      | "S51227007"  | "Electronic" | "DTC"         | 300           | "922042874" | "Direct STP" | "14340"  |

  @Internal @Partial @Gift
  Scenario Outline: Gift Internal Electronic partial transfer, ID 14340
    Given the user is logged into Security Transfer
    And the user creates a ticket based off the account <deliveryAcct>
    And the user makes ticket an internal gift transfer <giftType>
    When the user selects an internal account to recieve the assets <receivingAcct>
    And the user selects the asset to transfer <assetTypeName> <assetTypeCode> <cusip>
    And delivery instructions are entered
    And the Trailer Description is entered
    And information is entered in for the gift letters
    And the user could review the content of the ticket and submits it for a gift transfer
    And An authorized person approves the ticket
    And Mean Value Batch is executed
    And Two members of the credit team approve the parent ticket
    Then a child ticket is created and is routed to the processing team <teamName> <teamCode>

    Examples: 
      | deliveryAcct | giftType   | assetTypeName | assetTypeCode | cusip       | teamName     | teamCode | receivingAcct |
      | "S51227007"  | "Internal" | "DTC"         | 300           | "922042874" | "Direct STP" | "14340"  | "Q66651003"   |
