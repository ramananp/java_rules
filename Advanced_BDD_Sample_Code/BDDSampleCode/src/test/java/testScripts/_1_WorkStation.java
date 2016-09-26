package testScripts;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import pageObjects.otherPageObjects.InitRequest;
import pageObjects.otherPageObjects.SSOLogIn;
import pageObjects.otherPageObjects.WkstSQ;
import pageObjects.securityTransferTabs.GenReqInfo;
import pageObjects.securityTransferTabs.VerifyAndApprove;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import databaseObjects.DelTktSQ;
import driver.RunIE;
import excelUpdatesFeatureFile.backgroundSection.abstractProperties.ReadLogInfo;

public class _1_WorkStation {

	public static WebDriver driver;
	RunIE runIE = new RunIE();
	SSOLogIn logIn = new SSOLogIn();
	ReadLogInfo readLogInfo = new ReadLogInfo();
	WkstSQ wkstSQ = new WkstSQ();
	GenReqInfo reqInfo = new GenReqInfo();
	InitRequest request = new InitRequest();
	VerifyAndApprove approve = new VerifyAndApprove();
	DelTktSQ delTktSQ = new DelTktSQ();
	public static String ticketNum = null;
	public boolean creditTeamAttemptedTpProcessedOnce;
	
	/**
	 * @return the creditTeamAttemptedTpProcessedOnce
	 */
	public boolean isCreditTeamAttemptedTpProcessedOnce() {
		return creditTeamAttemptedTpProcessedOnce;
	}

	/**
	 * @param creditTeamAttemptedTpProcessedOnce the creditTeamAttemptedTpProcessedOnce to set
	 */
	public void setCreditTeamAttemptedTpProcessedOnce(
			boolean creditTeamAttemptedTpProcessedOnce) {
		this.creditTeamAttemptedTpProcessedOnce = creditTeamAttemptedTpProcessedOnce;
	}
	
	

	@After("@SecTransRouting , @test, @CompleteTestSuite")
	public void shutdownPartial(){
		driver.quit();
		System.out.println("Shutdown Browser");
		System.out.println("*************** Test Complete ***************");
	}

	public WebDriver getDriver(){
		return driver;
	}
	
	public String getTicketNum(){
		return ticketNum;
	}

	
	@Given("^the user is logged into Security Transfer$")
	public void the_user_is_logged_into_Security_Transfer() throws Throwable {

		driver = runIE.getWorkstation();
		driver.manage().window().maximize();
		setCreditTeamAttemptedTpProcessedOnce(false);
		logIn.userName(driver).sendKeys(readLogInfo.getSIDClientService());
		logIn.userPass(driver).sendKeys(readLogInfo.getPasswordClientService());
		logIn.LogInButton(driver);
		
		System.out.println(">>> Initiator Logs into WorkStation");
		wkstSQ.serviceTab(driver);
		wkstSQ.initiateReqTab(driver).click();
	}
	
	@Given("^the user creates a ticket based off the account \"([^\"]*)\"$")
	public void the_user_creates_a_ticket_based_off_the_account(String delivAcct) throws Throwable {
		
		//Delete previous any Full Transfer ticket with <delivAcct>
		delTktSQ.deleteTicket(delivAcct, readLogInfo.getSIDClientService());
        //Creates workstation ticket based off of an account from feature file
		assertTrue("There is no test delivery instruction account", "0" != delivAcct);
		request.accountNumberEntry(driver).sendKeys(delivAcct);
		request.initATicket(driver).click();
		//request.initReqButton(driver, "ns_7_KI17UOQ21O0JD02NLU09NK1004_initiateSR()");

	    //Make Workstation ticket a Security Transfer ticket
	    request.selectedRequestCategory(driver, "Security Transfers");
	    request.requestType(driver).sendKeys("Internal/External/Gift Transfers");
	    //request.initReqButton(driver, "ns_7_KI17UOQ21ONB502T2BOLCV0GE4_initiateRequestItem()");
	    request.initASpecificTicketType(driver).click();
	    
	    Thread.sleep(40000);
	    ticketNum = approve.getTicketNumber(driver);
	    System.out.println(">>> Ticket Number: " + ticketNum);
	    
	}
	
	@Given("^the user creates a ticket based off the account (\\d+)$")
	public void the_user_creates_a_ticket_based_off_the_account(int delivAcct) throws Throwable {
		
		//Delete previous any Full Transfer ticket with <delivAcct>
		String strDelivAcct = Integer.toString(delivAcct);
		delTktSQ.deleteTicket(strDelivAcct, readLogInfo.getSIDClientService());
		assertTrue("There is no test delivery account", 0 != delivAcct);
		String stringDelivAcct = Integer.toString(delivAcct);
		request.accountNumberEntry(driver).sendKeys(stringDelivAcct);
	    request.initReqButton(driver, "ns_7_KI17UOQ21O0JD02NLU09NK1004_initiateSR()");

	    //Make Workstation ticket a Security Transfer ticket
	    request.selectedRequestCategory(driver, "Security Transfers");
	    request.requestType(driver).sendKeys("Internal/External/Gift Transfers");
	    request.initReqButton(driver, "ns_7_KI17UOQ21ONB502T2BOLCV0GE4_initiateRequestItem()");

	    Thread.sleep(30000);
	    ticketNum = approve.getTicketNumber(driver);
	}
}
