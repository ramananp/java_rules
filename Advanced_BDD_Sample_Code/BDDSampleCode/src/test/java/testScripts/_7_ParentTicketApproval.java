package testScripts;

import static org.junit.Assert.assertFalse;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import pageObjects.otherPageObjects.CreditTeamApp;
import pageObjects.otherPageObjects.SSOLogIn;
import pageObjects.otherPageObjects.WkstSQ;
import pageObjects.securityTransferTabs.VerifyAndApprove;
import utilityPrograms.RunGiftMeanValueBatch;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import driver.RunIE;
import excelUpdatesFeatureFile.backgroundSection.abstractProperties.ReadLogInfo;

public class _7_ParentTicketApproval {

	_1_WorkStation workStation = new _1_WorkStation();
	WebDriver driver = workStation.getDriver();

	RunIE runIE = new RunIE();
	SSOLogIn logIn = new SSOLogIn();
	ReadLogInfo readLogInfo = new ReadLogInfo();
	WkstSQ wkstSQ = new WkstSQ();
	VerifyAndApprove approve = new VerifyAndApprove();
	CreditTeamApp creditTeamApp = new CreditTeamApp();
	_6_VerifyAndConfirm verifyAndConfirm = new _6_VerifyAndConfirm();
	String approverCatagory = verifyAndConfirm.getApproverCatagory();
	String ticketNum = workStation.getTicketNum();

	@After("@SecTransRouting , @test, @CompleteTestSuite")
	public void shutdownPartial(){
		driver.quit();
	}

	@When("^An authorized person approves the ticket$")
	public void An_authorized_person_approves_the_ticket() throws Throwable {
		
		//Application needs to be reopened for the approver to sign
		driver = runIE.getWorkstation();
		driver.manage().window().maximize();
		
		if(approverCatagory == "PrimaryAppover"){
			logIn.userName(driver).sendKeys(readLogInfo.getSIDPrimaryApprover());
			logIn.userPass(driver).sendKeys(readLogInfo.getPasswordPrimaryApprover());
		}else if(approverCatagory == "FirstBackupApprover"){
			logIn.userName(driver).sendKeys(readLogInfo.getSIDFistBackupApprover());
			logIn.userPass(driver).sendKeys(readLogInfo.getPasswordFirstBackupApprover());
		}else if(approverCatagory == "SecondBackupApprover"){
			logIn.userName(driver).sendKeys(readLogInfo.getSIDSecondBackupApprover());
			logIn.userPass(driver).sendKeys(readLogInfo.getPasswordSecondBackupApprover());
		}else{
			assertFalse("No approver credentials in test data",true);
		}
		logIn.LogInButton(driver);
		System.out.println(">>> Approver Logs Into WorkStation");
		
		//Approve opens up the parent ticket in the service queue
		wkstSQ.serviceTab(driver);
		wkstSQ.serviceQueue(driver);
		Thread.sleep(10000);
		
		//The ticket number value is stored when the Security Transfer ticket is initiated and on the General Information page
		wkstSQ.checkIfTicketIsTheCorrectStage(driver, ticketNum, "Service Team Approval");
		
		wkstSQ.openTicketInServiceQueue(driver, ticketNum).click();
		Thread.sleep(15000);
		approve.approveTicket(driver).click();
		
		
		Thread.sleep(3000);
		List<WebElement> listOfOk = driver.findElements(By.xpath("//button[contains(text(), 'OK')]"));
		if(listOfOk.size() == 1){
			listOfOk.get(0).click();
		}
		
		Thread.sleep(45000);
		
		System.out.println(">>> Ticket is Approved");

		driver.close();
		System.out.println("Shutdown Browser As Approver");
	}
	
	@Then("^An authorized person rejects the ticket$")
	public void An_authorized_person_rejects_the_ticket() throws Throwable {
		driver = runIE.getWorkstation();
		driver.manage().window().maximize();
		
		if(approverCatagory == "PrimaryAppover"){
			logIn.userName(driver).sendKeys(readLogInfo.getSIDPrimaryApprover());
			logIn.userPass(driver).sendKeys(readLogInfo.getPasswordPrimaryApprover());
		}else if(approverCatagory == "FirstBackupApprover"){
			logIn.userName(driver).sendKeys(readLogInfo.getSIDFistBackupApprover());
			logIn.userPass(driver).sendKeys(readLogInfo.getPasswordFirstBackupApprover());
		}else if(approverCatagory == "SecondBackupApprover"){
			logIn.userName(driver).sendKeys(readLogInfo.getSIDSecondBackupApprover());
			logIn.userPass(driver).sendKeys(readLogInfo.getPasswordSecondBackupApprover());
		}else{
			assertFalse("No approver credentials in test data",true);
		}
		logIn.LogInButton(driver);
		System.out.println(">>> Approver Logs Into WorkStation");
		
		//Approve opens up the parent ticket in the service queue
		wkstSQ.serviceTab(driver);
		wkstSQ.serviceQueue(driver);
		Thread.sleep(10000);
		
		//The ticket number value is stored when the Security Transfer ticket is initiated and on the General Information page
		wkstSQ.checkIfTicketIsTheCorrectStage(driver, ticketNum, "Service Team Approval");
		
		wkstSQ.openTicketInServiceQueue(driver, ticketNum).click();
		Thread.sleep(15000);
		approve.rejectTicket(driver).click();
		
		Thread.sleep(3000);
		List<WebElement> listOfOk = driver.findElements(By.xpath("//button[contains(text(), 'OK')]"));
		if(listOfOk.size() == 1){
			listOfOk.get(0).click();
		}
		
		Thread.sleep(45000);
		
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
		wkstSQ.checkIfTicketIsTheCorrectStage(driver, ticketNum, "Need More Info/Rejected");
		System.out.println(">>> Ticket is Rejected");

		driver.close();
		System.out.println("Shutdown Browser As Approver");
	}

	@When("^Two members of the credit team approve the parent ticket$")
	public void Two_members_of_the_credit_team_approve_the_parent_ticket() throws Throwable {
		driver = runIE.getWorkstation();
		driver.manage().window().maximize();
		
		logIn.userName(driver).sendKeys(readLogInfo.getSIDFirstCreditTeamApprover());
		logIn.userPass(driver).sendKeys(readLogInfo.getPasswordFirstCreditTeamApprover());
		logIn.LogInButton(driver);
		System.out.println(">>> First Credit Team Logs Into WorkStation");
		wkstSQ.serviceTab(driver);
		wkstSQ.serviceQueue(driver);
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
		wkstSQ.openTicketInServiceQueue(driver, ticketNum).click();

		String creditExceptionTicket = approve.creditExceptionTicket(driver).getText();
		String creditExceptionTicketNumber = creditExceptionTicket.substring(28);
		
		wkstSQ.serviceQueueAfterFilteringTicket(driver);
		
		action
			.doubleClick(wkstSQ.ticketSearchField(driver))
			.sendKeys(creditExceptionTicketNumber)
			.perform();
		
		Thread.sleep(5000);
		wkstSQ.filterButton(driver).click();
		wkstSQ.openTicketInServiceQueue(driver, creditExceptionTicketNumber).click();
		Thread.sleep(10000);
		driver.switchTo().frame("cgewIframe");
		
		creditTeamApp.claimButton(driver).click();
		creditTeamApp.approveButtonMain(driver).click();
		creditTeamApp.reasonSelect(driver).sendKeys("CA Approval Received");
		creditTeamApp.approveButtonReasonCode(driver).click();	
		driver.close();
		System.out.println(">>> Shutdown Browser As First Credit Team Member");
		
		System.out.println(">>> Second Credit Team Logs Into WorkStation");
		Actions action2 = new Actions(driver);
		driver = runIE.getWorkstationCreditApproval();
		driver.manage().window().maximize();
		
		logIn.userName(driver).sendKeys(readLogInfo.getSIDSecondCreditTeamApprover());
		logIn.userPass(driver).sendKeys(readLogInfo.getPasswordSecondCreditTeamApprover());
		logIn.LogInButton(driver);
		wkstSQ.serviceTab(driver);
		wkstSQ.serviceQueue(driver);;
		wkstSQ.openTicketsTab(driver);
		Thread.sleep(15000);
		wkstSQ.searchCriteria(driver).sendKeys("Ticket #");
		wkstSQ.ticketSearchField(driver).sendKeys(creditExceptionTicketNumber);	
		wkstSQ.ticketNumSearchFilterButton(driver).click();
		wkstSQ.ticketNumSearchFilterButton(driver).click();
		wkstSQ.openTicketInServiceQueue(driver, creditExceptionTicketNumber).click();
		Thread.sleep(10000);
		driver.switchTo().frame("cgewIframe");
		
		creditTeamApp.claimButton(driver).click();
		creditTeamApp.approveButtonMain(driver).click();
		creditTeamApp.reasonSelect(driver).sendKeys("CA Approval Received");
		creditTeamApp.approveButtonReasonCode(driver).click();	
		Thread.sleep(15000);
		driver.close();
		System.out.println(">>> Shutdown Browser As Second Credit Team Member");
	}
	
//Gift
	@When("^Mean Value Batch is executed$")
	public void Mean_Value_Batch_is_executed() throws Throwable {
		System.out.println(">>> Mean Batch Value Executed");
		
		RunGiftMeanValueBatch batch = new RunGiftMeanValueBatch();
		batch.ExecuteMeanValueBatch();
	}
}
