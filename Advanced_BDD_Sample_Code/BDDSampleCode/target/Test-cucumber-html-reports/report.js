$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("test.feature");
formatter.feature({
  "id": "sps",
  "tags": [
    {
      "name": "@test",
      "line": 1
    }
  ],
  "description": "",
  "name": "SPS",
  "keyword": "Feature",
  "line": 2
});
formatter.scenario({
  "id": "sps;dtc;;2",
  "tags": [
    {
      "name": "@test",
      "line": 1
    }
  ],
  "description": "",
  "name": "DTC",
  "keyword": "Scenario Outline",
  "line": 19,
  "type": "scenario"
});
formatter.step({
  "name": "the user is logged into Security Transfer",
  "keyword": "Given ",
  "line": 5
});
formatter.step({
  "name": "the user creates a ticket based off the account \"A00028000\"",
  "keyword": "And ",
  "line": 6,
  "matchedColumns": [
    2
  ]
});
formatter.step({
  "name": "the user makes ticket an external partial transfer",
  "keyword": "And ",
  "line": 7
});
formatter.step({
  "name": "the user enters an external account to recieve the assets",
  "keyword": "When ",
  "line": 8
});
formatter.step({
  "name": "the user selects the asset to transfer \"DTC\" 220 \"78462F103\"",
  "keyword": "And ",
  "line": 9,
  "matchedColumns": [
    0,
    1,
    3
  ]
});
formatter.step({
  "name": "delivery instructions are entered",
  "keyword": "And ",
  "line": 10
});
formatter.step({
  "name": "the DTC/Broker Name and DTC Number are entered",
  "keyword": "And ",
  "line": 11
});
formatter.step({
  "name": "the user could review the content of the ticket and submits it",
  "keyword": "And ",
  "line": 12
});
formatter.step({
  "name": "An authorized person approves the ticket",
  "keyword": "And ",
  "line": 13
});
formatter.step({
  "name": "a child ticket is created and is routed to the processing team \"Direct STP\" 14030",
  "keyword": "Then ",
  "line": 15,
  "matchedColumns": [
    4,
    5
  ],
  "comments": [
    {
      "value": "#And Two members of the credit team approve the parent ticket",
      "line": 14
    }
  ]
});
formatter.match({
  "location": "_1_WorkStation.the_user_is_logged_into_Security_Transfer()"
});
formatter.result({
  "duration": 21774087470,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "A00028000",
      "offset": 49
    }
  ],
  "location": "_1_WorkStation.the_user_creates_a_ticket_based_off_the_account(String)"
});
formatter.result({
  "duration": 50994385440,
  "status": "passed"
});
formatter.match({
  "location": "_2_GeneralInformation.the_user_makes_ticket_an_external_partial_transfer()"
});
formatter.result({
  "duration": 3716404400,
  "status": "passed"
});
formatter.match({
  "location": "_3_SecurityTransfer.the_user_enters_an_external_account_to_recieve_the_assets()"
});
formatter.result({
  "duration": 14997113896,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "DTC",
      "offset": 40
    },
    {
      "val": "220",
      "offset": 45
    },
    {
      "val": "78462F103",
      "offset": 50
    }
  ],
  "location": "_3_SecurityTransfer.the_user_selects_the_asset_to_transfer(String,int,String)"
});
formatter.result({
  "duration": 17756547514,
  "status": "passed"
});
formatter.match({
  "location": "_4_DeliveryInstructionsTab.delivery_instructions_are_entered()"
});
formatter.result({
  "duration": 47046445330,
  "status": "passed"
});
formatter.match({
  "location": "_4_DeliveryInstructionsTab.the_DTC_Broker_Name_and_DTC_Number_are_entered()"
});
formatter.result({
  "duration": 16094536520,
  "status": "passed"
});
formatter.match({
  "location": "_6_VerifyAndConfirm.the_user_could_review_the_content_of_the_ticket_and_submits_it()"
});
formatter.result({
  "duration": 140037920855,
  "status": "passed"
});
formatter.match({
  "location": "_7_ParentTicketApproval.An_authorized_person_approves_the_ticket()"
});
formatter.result({
  "duration": 94948793625,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Direct STP",
      "offset": 64
    },
    {
      "val": "14030",
      "offset": 76
    }
  ],
  "location": "_8_Status.a_child_ticket_is_created_and_is_routed_to_the_processing_team(String,int)"
});
formatter.result({
  "duration": 26562715072,
  "status": "failed",
  "error_message": "org.junit.ComparisonFailure: Ticket was not in the correct stage for the test to handle it  expected:\u003c[Pending Complete]\u003e but was:\u003c[Credit Team Approval]\u003e\r\n\tat org.junit.Assert.assertEquals(Assert.java:115)\r\n\tat pageObjects.otherPageObjects.WkstSQ.checkIfTicketIsTheCorrectStage(WkstSQ.java:126)\r\n\tat testScripts._8_Status.a_child_ticket_is_created_and_is_routed_to_the_processing_team(_8_Status.java:75)\r\n\tat ✽.Then a child ticket is created and is routed to the processing team \"Direct STP\" 14030(test.feature:15)\r\n"
});
formatter.after({
  "duration": 1014099621,
  "status": "passed"
});
formatter.after({
  "duration": 1376133,
  "status": "passed"
});
formatter.after({
  "duration": 1089885090,
  "status": "passed"
});
formatter.after({
  "duration": 86624,
  "status": "passed"
});
formatter.after({
  "duration": 60350,
  "status": "passed"
});
formatter.after({
  "duration": 1006102693,
  "status": "passed"
});
formatter.after({
  "duration": 84161,
  "status": "passed"
});
formatter.after({
  "duration": 107562,
  "status": "passed"
});
});