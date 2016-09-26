@CompleteTestSuite @Reject @SecTrans
Feature: Reject

  @External @Full
  Scenario Outline: SecTrans External Full Transfer Reject
    Given the user is logged into Security Transfer
    And the user creates a ticket based off the account <deliveryAcct>
    And the user makes ticket an external full transfer
    And the user enters in an external account to receive all of the assets of the account
    And targeted asset is transfered <assetTypeName> <assetTypeCode> <cusip>
    And delivery instructions are entered for external full transfers
    When the user could review the content of the ticket and submits it
    Then An authorized person rejects the ticket

    Examples: 
      | assetTypeName          | assetTypeCode | deliveryAcct | cusip       |
      | "Cash - Non-Fiduciary" | 100           | "A00011006"  | "0USDPRAA7" |

  @Internal @Full
  Scenario Outline: SecTrans Internal Full Transfers Reject
    Given the user is logged into Security Transfer
    And the user creates a ticket based off the account <deliveryAcct>
    And the user makes ticket an internal full transfer
    And the user sets an internal account to receive all of the assets of the account <receivingAcct>
    And targeted asset is transfered <assetTypeName> <assetTypeCode> <cusip>
    And delivery instructions are entered for internal full transfers
    When the user could review the content of the ticket and submits it
    Then An authorized person rejects the ticket

    Examples: 
      | assetTypeName     | assetTypeCode | deliveryAcct | cusip       | receivingAcct |
      | "Physical Reg 93" | 132           | "C88737009"  | "166400BH3" | "Q66651003"   |

  @External @Partial
  Scenario Outline: SecTrans External Partial Transfers Reject
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
    Then An authorized person rejects the ticket

    Examples: 
      | assetTypeName     | assetTypeCode | deliveryAcct | cusip       |
      | "Physical Reg 93" | 132           | "C88737009"  | "166400BH3" |

  @Internal @Partial
  Scenario Outline: SecTrans Internal Partial Transfers Reject
    Given the user is logged into Security Transfer
    And the user creates a ticket based off the account <deliveryAcct>
    And the user makes ticket an internal partial transfer
    When the user selects an internal account to recieve the assets <receivingAcct>
    And the user selects the asset to transfer <assetTypeName> <assetTypeCode> <cusip>
    And delivery instructions are entered
    And the user could review the content of the ticket and submits it
    Then An authorized person rejects the ticket

    Examples: 
      | assetTypeName | assetTypeCode | deliveryAcct | cusip       | receivingAcct |
      | "DTC"         | 220           | "A00028000"  | "78462F103" | "Q66651003"   |
