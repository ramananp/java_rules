@CompleteTestSuite
Feature: DWAC

  @DWACFreeReceive @OmniReceive @14160
  Scenario Outline: DWAC Free Receive - Omni receiving account, ID 14160
    Given the user is logged into Security Transfer
    And the user creates a ticket based off the account <deliveryAcct>
    And the user makes ticket a DWAC Free Receive
    When the user adds a reference control number
    And the user enters in the data for the expected assets <assetTypeName> <assetTypeCode> <cusip>
    And delivery instructions are entered
    And the Trailer Description is entered
    And the DTC Agent Information is entered
    And the Penny Stock Deposit Indication is entered
    And the user could review the content of the ticket and submits it
    And An authorized person approves the ticket
    And Two members of the credit team approve the parent ticket
    Then a child ticket is created and is routed to the processing team <teamName> <teamCode>

    Examples: 
      | assetTypeName           | assetTypeCode | deliveryAcct | cusip     | teamName     | teamCode |
      | "Offshore Mutual Funds" | 420           | "M50973003"  | 234125912 | "Direct STP" | 14160    |

  @DWACFreeDelivery @OmniDeliv @14030
  Scenario Outline: DWAC Free Delivery, ID 14030
    Given the user is logged into Security Transfer
    And the user creates a ticket based off the account <deliveryAcct>
    And the user makes ticket a DWAC Free Delivery
    When the user adds a reference control number for external transfers
    And the user selects the asset to transfer <assetTypeName> <assetTypeCode> <cusip>
    And delivery instructions are entered
    And the DTC Agent Information is entered
    And the user could review the content of the ticket and submits it
    And An authorized person approves the ticket
    And Two members of the credit team approve the parent ticket
    Then a child ticket is created and is routed to the processing team <teamName> <teamCode>

    Examples: 
      | assetTypeName | assetTypeCode | deliveryAcct | cusip       | teamName     | teamCode |
      | "DTC"         | 310           | "M50973003"  | "527298BA0" | "Direct STP" | 14030    |
