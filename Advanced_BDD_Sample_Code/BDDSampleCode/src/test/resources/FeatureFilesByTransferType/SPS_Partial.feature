@CompleteTestSuite
Feature: SPS - Partial

  #MarginMargin
  #ExternalMargin
  @SPS @Internal @Partial @14030
  Scenario Outline: Internal Partial SPS, ID 14030
    Given the user is logged into Security Transfer
    And the user creates a ticket based off the account <deliveryAcct>
    And the user makes ticket an internal partial SPS transfer
    When the user selects an internal account to recieve the assets SPS <receivingAcct>
    And the user enters in the data for the expected assets for a SPS transaction <assetTypeName> <assetTypeCode> <cusip>
    And delivery instructions are entered
    And the Trailer Description is entered
    And the ABA Number, Bank Name, Feb Sub Account, and Trading Broker SPS is entered based off the Broker Search
    And the user could review the content of the ticket and submits it
    And An authorized person approves the ticket
    Then a child ticket is created and is routed to the processing team <teamName> <teamCode>

    Examples: 
      | assetTypeName | assetTypeCode | deliveryAcct | cusip       | teamName                        | teamCode | receivingAcct |
      | "DTC"         | 310           | "M50973003"  | "527298BA0" | "Securities Pending Settlement" | 14030    | "Q66651003"   |

  @SPS @External @Partial @14030
  Scenario Outline: External Partial SPS, ID 14030
    Given the user is logged into Security Transfer
    And the user creates a ticket based off the account <deliveryAcct>
    And the user makes ticket an external partial SPS transfer
    When the user enters an external account to recieve the assets SPS
    And the user enters in the data for the expected assets for a SPS transaction <assetTypeName> <assetTypeCode> <cusip>
    And delivery instructions are entered
    And the ABA Number, Bank Name, Feb Sub Account, and Trading Broker SPS is entered based off the Broker Search
    And the user could review the content of the ticket and submits it
    And An authorized person approves the ticket
    And Two members of the credit team approve the parent ticket
    Then a child ticket is created and is routed to the processing team <teamName> <teamCode>

    Examples: 
      | assetTypeName | assetTypeCode | deliveryAcct | cusip       | teamName                        | teamCode |
      | "DTC"         | 310           | "M50973003"  | "527298BA0" | "Securities Pending Settlement" | 14030    |

  @SPS @OmniMargin @Partial @14030
  Scenario Outline: Margin Partial SPS, ID 14030
    Given the user is logged into Security Transfer
    And the user creates a ticket based off the account <deliveryAcct>
    And the user makes ticket an margin partial SPS transfer
    When the user selects an internal account to recieve the assets <receivingAcct>
    And the user enters in the data for the expected assets for a SPS transaction <assetTypeName> <assetTypeCode> <cusip>
    And delivery instructions are entered
    And the Trailer Description is entered
    And the ABA Number, Bank Name, Feb Sub Account, and Trading Broker is entered based off the Broker Search
    And the user could review the content of the ticket and submits it
    And An authorized person approves the ticket
    And Two members of the credit team approve the parent ticket
    Then a child ticket is created and is routed to the processing team <teamName> <teamCode>

    Examples: 
      | assetTypeName | assetTypeCode | deliveryAcct | cusip       | teamName                        | teamCode | receivingAcct |
      | "DTC"         | 310           | "M50973003"  | "527298BA0" | "Securities Pending Settlement" | 14030    | 0024182129    |
