package testScripts;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import pageObjects.otherPageObjects.SSOLogIn;
import pageObjects.otherPageObjects.WkstSQ;
import pageObjects.securityTransferTabs.StatusTab;
import pageObjects.securityTransferTabs.VerifyAndApprove;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.Then;
import driver.RunIE;
import excelUpdatesFeatureFile.backgroundSection.abstractProperties.ReadLogInfo;

public class _8_Status {

	_1_WorkStation workStation = new _1_WorkStation();
	_3_SecurityTransfer securityTransferTab = new _3_SecurityTransfer();

	WebDriver driver = workStation.getDriver();
	RunIE runIE = new RunIE();
	SSOLogIn logIn = new SSOLogIn();
	ReadLogInfo readLogInfo = new ReadLogInfo();
	WkstSQ wkstSQ = new WkstSQ();
	StatusTab statusTab = new StatusTab();
	VerifyAndApprove approve = new VerifyAndApprove();
	String ticketNum = workStation.getTicketNum();

	@After("@SecTransRouting , @test, @CompleteTestSuite")
	public void shutdownPartial(){
		driver.quit();
	}
	
//Partial
	@Then("^a child ticket is created and is routed to the processing team \"([^\"]*)\" (\\d+)$")
	public void a_child_ticket_is_created_and_is_routed_to_the_processing_team(String processTeamName, int processTeamCode) throws Throwable {
		/*
		 * The initiator should log in again after the ticket was approved to confirm that the child tickets that are generated and routes to the correct processing team
		 * The processTeamCode is only shown for reporting purposes
		 */
		
		driver = runIE.getWorkstation();
		driver.manage().window().maximize();
		logIn.userName(driver).sendKeys(readLogInfo.getSIDClientService());
		logIn.userPass(driver).sendKeys(readLogInfo.getPasswordClientService());
		logIn.LogInButton(driver);
		System.out.println(">>> Initiator Logs Into WorkStation");
		
		wkstSQ.serviceTab(driver);
		wkstSQ.serviceQueue(driver);
		/*
		wkstSQ.openTicketsTab(driver);
		Actions action = new Actions(driver);
		action
			.doubleClick(wkstSQ.searchCriteria(driver))
			.sendKeys("Ticket #")
			.perform();
		wkstSQ.ticketSearchField(driver).sendKeys(ticketNum);
		action
			.moveByOffset(0, 10)
			.click()
			.perform();
		Thread.sleep(5000);
		wkstSQ.ticketNumSearchFilterButton(driver).click();
		Thread.sleep(5000);
		wkstSQ.checkIfTicketIsTheCorrectStageOpenTicket(driver, ticketNum, "Pending Complete");
		*/
		
		Thread.sleep(10000);
		//The ticket number value is stored when the Security Transfer ticket is initiated and on the General Information page
		wkstSQ.checkIfTicketIsTheCorrectStage(driver, ticketNum, "Pending Complete");
		wkstSQ.openTicketInServiceQueue(driver, ticketNum).click();

		Thread.sleep(20000);
		
		long startTime = System.currentTimeMillis();
		
		while(statusTab.statusTabCheck(driver).getAttribute("class").contains("x-tab-strip-active") == false){
			if(statusTab.statusTabCheck(driver).getAttribute("class").contains("x-tab-strip-active") == true){
				break;
			}else if((System.currentTimeMillis()-startTime) > 30000){
				assertTrue("Unexpected error stoped the status tab from being open in the parent ticket", false);
				break;
			}else{
				statusTab.clickStatusTab(driver).click();
			}
		}
		Thread.sleep(20000);
		String childTicketStatusInfo = statusTab.searchTeamType(driver).getText();
		System.out.println("childTicketStatusInfo: "+ childTicketStatusInfo);
		String childTicketNum = childTicketStatusInfo.substring(15, 24);
		assertTrue("Expected team to be: " + processTeamName + " and was actually: "+ childTicketStatusInfo,childTicketStatusInfo.contains(processTeamName));
		System.out.println(">>> Confirm Child Ticket Routed Properally");

	}

//Full
	@Then("^child tickets are created and the targeted asset is routed to the correct processing team \"([^\"]*)\" (\\d+)$")
	public void child_tickets_are_created_and_the_targeted_asset_is_routed_to_the_correct_processing_team(String processTeamName, int heiarchyID) throws Throwable {

		driver = runIE.getWorkstation();
		driver.manage().window().maximize();
		logIn.userName(driver).sendKeys(readLogInfo.getSIDClientService());
		logIn.userPass(driver).sendKeys(readLogInfo.getPasswordClientService());
		logIn.LogInButton(driver);
		System.out.println(">>> Initiator Logs Into WorkStation");
		
		wkstSQ.serviceTab(driver);
		wkstSQ.serviceQueue(driver);
		/*
		wkstSQ.openTicketsTab(driver);
		Actions action = new Actions(driver);
		action
			.doubleClick(wkstSQ.searchCriteria(driver))
			.sendKeys("Ticket #")
			.perform();
		wkstSQ.ticketSearchField(driver).sendKeys(ticketNum);
		action
			.moveByOffset(0, 10)
			.click()
			.perform();
		Thread.sleep(5000);
		wkstSQ.ticketNumSearchFilterButton(driver).click();
		wkstSQ.checkIfTicketIsTheCorrectStage(driver, ticketNum, "Pending Complete");
		*/
		Thread.sleep(10000);
		//The ticket number value is stored when the Security Transfer ticket is initiated and on the General Information page
		wkstSQ.checkIfTicketIsTheCorrectStage(driver, ticketNum, "Pending Complete");
		wkstSQ.openTicketInServiceQueue(driver, ticketNum).click();
		
		Thread.sleep(30000);
		statusTab.clickStatusTab(driver).click();
		Thread.sleep(30000);
		String childTicketStatusInfo = statusTab.searchTeamTypeWithMultipleChildTickets(driver, processTeamName).getText();
		assertNotNull("Child ticket cannot be found and is null", childTicketStatusInfo);
		String childTicketNum = childTicketStatusInfo.substring(15, 24);
		System.out.println(">>> Targeted Child Ticket Number: " + childTicketNum);
		assertTrue("Expected team to be: " + processTeamName + " and was actually: "+ childTicketStatusInfo,childTicketStatusInfo.contains(processTeamName));
		
		wkstSQ.serviceQueueAfterFilteringTicket(driver);
		Thread.sleep(3000);
		wkstSQ.openTicketsTab(driver);
		Thread.sleep(5000);
		Actions action3 = new Actions(driver);
		action3
			.doubleClick(wkstSQ.searchCriteria(driver))
			.sendKeys("Ticket #")
			.perform();
		wkstSQ.ticketSearchField(driver).sendKeys(childTicketNum);
		action3
			.moveByOffset(0, 10)
			.click()
			.perform();
		Thread.sleep(5000);
		wkstSQ.ticketNumSearchFilterButton(driver).click();
		wkstSQ.openTicketInServiceQueue(driver, childTicketNum).click();
		
		
		String targetCusip = securityTransferTab.getCusip();
		System.out.println(">>> Targeted Cusip " + targetCusip);
		Thread.sleep(30000);
		assertTrue("The target cusip " + targetCusip + " is not on the child ticket " + childTicketNum, approve.checkIfCusipIsInChildTicket(driver, targetCusip));
		System.out.println(">>> Confirm Child Ticket Routed Properally");
	}
}
