package testScripts;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import pageObjects.securityTransferTabs.GenReqInfo;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;

public class _2_GeneralInformation {

	_1_WorkStation workStation = new _1_WorkStation();
	WebDriver driver = workStation.getDriver();
	GenReqInfo reqInfo = new GenReqInfo();

	@After("@SecTransRouting , @test, @CompleteTestSuite")
	public void shutdownPartial(){
		driver.quit();
	}

//Partial Security
	@Given("^the user makes ticket an external partial transfer$")
	public void the_user_makes_ticket_an_external_partial_transfer() throws Throwable {
		System.out.println(">>> General Information - External Partial Sec Transfer");
		reqInfo.externalRadioButton(driver).click();
		reqInfo.saveAndContinueButton(driver).click();
		reqInfo.confirmWithOK(driver).click();
		reqInfo.confirmGeneralInfoButton(driver).click();
	}
	
	@Given("^the user makes ticket an internal partial transfer$")
	public void the_user_makes_ticket_an_internal_partial_transfer() throws Throwable {
		System.out.println(">>> General Information - Internal Partial Sec Transfer");
		reqInfo.internalRadioButton(driver).click();
		reqInfo.saveAndContinueButton(driver).click();
		reqInfo.confirmGeneralInfoButton(driver).click();
	}
	
	@Given("^the user makes ticket a margin partial transfer$")
	public void the_user_makes_ticket_a_margin_partial_transfer() throws Throwable {
		System.out.println(">>> General Information - Margin Partial Sec Transfer");
		reqInfo.jpmcMarginRadioButton(driver).click();
		reqInfo.saveAndContinueButton(driver).click();
		reqInfo.confirmGeneralInfoButton(driver).click();
	}
	
//Full	Security Transfer
	@Given("^the user makes ticket an external full transfer$")
	public void the_user_creates_a_ticket_for_an_external_full_transfer() throws Throwable {
		System.out.println(">>> General Information - External Full Sec Transfer");
		reqInfo.externalRadioButton(driver).click();
		reqInfo.full_OneRadioButton(driver).click();
		reqInfo.takeFeesRadioButton(driver).click();
		
		if(reqInfo.dontSendFidCash(driver).size() == 1){
			reqInfo.dontSendFidCash(driver).get(0).click();
		}
		
		reqInfo.saveAndContinueButton(driver).click();
		reqInfo.confirmWithOK(driver).click();
		Thread.sleep(2000);
		reqInfo.confirmGeneralInfoButton(driver).click();
	}
	
	@Given("^the user makes ticket an internal full transfer$")
	public void the_user_creates_ticket_for_an_internal_full_transfer() throws Throwable {
		System.out.println(">>> General Information - Internal Full Sec Transfer");
		reqInfo.internalRadioButton(driver).click();
		reqInfo.internalRadioButton(driver).click();
		reqInfo.full_OneRadioButton(driver).click();
		reqInfo.takeFeesRadioButton(driver).click();
		
		if(reqInfo.dontSendFidCash(driver).size() == 1){
			reqInfo.dontSendFidCash(driver).get(0).click();
		}
		
		reqInfo.saveAndContinueButton(driver).click();
		reqInfo.confirmGeneralInfoButton(driver).click();
	}
	
	@Given("^the user makes ticket an external full to many transfer$")
	public void the_user_makes_ticket_an_external_full_to_many_transfer() throws Throwable {
		System.out.println(">>> General Information - External Full to Many Sec Transfer");
		reqInfo.externalRadioButton(driver).click();
		reqInfo.full_ManyRadioButton(driver).click();
		reqInfo.takeFeesRadioButton(driver).click();
		
		if(reqInfo.dontSendFidCash(driver).size() == 1){
			reqInfo.dontSendFidCash(driver).get(0).click();
		}
		
		reqInfo.saveAndContinueButton(driver).click();
		reqInfo.confirmWithOK(driver).click();
		reqInfo.confirmGeneralInfoButton(driver).click();
		
	}
	
	@Given("^the user makes ticket an internal full to many transfer$")
	public void the_user_makes_ticket_an_internal_full_to_many_transfer() throws Throwable {
		System.out.println(">>> General Information - Internal Full to Many Sec Transfer");
		reqInfo.internalRadioButton(driver).click();
		reqInfo.full_ManyRadioButton(driver).click();
		reqInfo.takeFeesRadioButton(driver).click();
		
		if(reqInfo.dontSendFidCash(driver).size() == 1){
			reqInfo.dontSendFidCash(driver).get(0).click();
		}
		
		reqInfo.saveAndContinueButton(driver).click();
		reqInfo.confirmGeneralInfoButton(driver).click();
	}

//Gift
	
	public void executeGiftType(String giftType) throws InterruptedException{
		
		if(giftType.equals("Electronic")){
			reqInfo.giftTypeElectronic(driver).click();
		}
		else if(giftType.equals("Internal")){
			reqInfo.giftTypeInternal(driver).click();
		}
		else if(giftType.equals("Pending Disposition")){
			reqInfo.giftTypePendingDisposition(driver).click();
		}
		else if(giftType.equals("Sell Via JPMCC")){
			reqInfo.giftTypeSellViaJpmcc(driver).click();
		}
		else if(giftType.equals("Physical Re-register")){
			reqInfo.giftTypePhysicalReregister(driver).click();
			reqInfo.confirmWithOK(driver).click();
		}
		else if(giftType.equals("DTC Re-register")){
			reqInfo.giftTypeDTCReregister(driver).click();
		}
		else{
			assertTrue("Not a valid gift Type", false);
		}
	}
	
	@Given("^the user makes ticket an external gift transfer \"([^\"]*)\"$")
	public void the_user_makes_ticket_an_external_gift_transfer(String giftType) throws Throwable {
		System.out.println(">>> General Information - External Gift");
		reqInfo.giftRadioButton(driver).click();
		reqInfo.giftRadioButton(driver).click();
		executeGiftType(giftType);
		reqInfo.externalRadioButton(driver).click();
		reqInfo.saveAndContinueButton(driver).click();
		reqInfo.confirmWithOK(driver).click();
		reqInfo.confirmGeneralInfoButton(driver).click();
	}
	
	@Given("^the user makes ticket an internal gift transfer \"([^\"]*)\"$")
	public void the_user_makes_ticket_an_internal_gift_transfer(String giftType) throws Throwable {
		System.out.println(">>> General Information - Internal Gift");
		reqInfo.giftRadioButton(driver).click();
		reqInfo.giftRadioButton(driver).click();
		executeGiftType(giftType);
		reqInfo.internalRadioButton(driver).click();
		reqInfo.saveAndContinueButton(driver).click();
		reqInfo.confirmGeneralInfoButton(driver).click();
	}
	
	@Given("^the user makes ticket an margin gift transfer \"([^\"]*)\"$")
	public void the_user_makes_ticket_an_margin_gift_transfer_(String giftType) throws Throwable {
		System.out.println(">>> General Information");
		reqInfo.giftRadioButton(driver).click();
		reqInfo.giftRadioButton(driver).click();
		executeGiftType(giftType);
		reqInfo.jpmcMarginRadioButton(driver).click();
		reqInfo.saveAndContinueButton(driver).click();
		reqInfo.confirmGeneralInfoButton(driver).click();
	}
	
//DWAC
	
	@Given("^the user makes ticket a DWAC Free Receive$")
	public void the_user_makes_ticket_a_DWAC_Free_Receive() throws Throwable {
		System.out.println(">>> General Information - DWAC_Free Receive");
		Thread.sleep(15000);
		reqInfo.dwacRadioButton(driver).click();
		reqInfo.dwacReceiveRadioButton(driver).click();
		reqInfo.saveAndContinueButton(driver).click();
		reqInfo.confirmGeneralInfoButton(driver).click();
	}
	
	@Given("^the user makes ticket a DWAC Free Delivery$")
	public void the_user_makes_ticket_a_DWAC_Free_Delivery() throws Throwable {
		System.out.println(">>> General Information - DWAC_Free Delivery");
		Thread.sleep(15000);
		reqInfo.dwacRadioButton(driver).click();
		reqInfo.dwacDepositRadioButton(driver).click();
		reqInfo.saveAndContinueButton(driver).click();
		reqInfo.confirmWithOK(driver).click();
		reqInfo.confirmGeneralInfoButton(driver).click();
	}

//SPS Partial
	
	@Given("^the user makes ticket an internal partial SPS transfer$")
	public void the_user_makes_ticket_an_internal_partial_SPS_transfer() throws Throwable {
		System.out.println(">>> General Information - Internal Partial SPS");
		Thread.sleep(40000);
		reqInfo.spsRadioButton(driver).click();
		reqInfo.confirmWithOK(driver).click();
		reqInfo.internalRadioButton(driver).click();
		reqInfo.saveAndContinueButton(driver).click();
		reqInfo.confirmGeneralInfoButton(driver).click();
	}

	@Given("^the user makes ticket an external partial SPS transfer$")
	public void the_user_makes_ticket_an_external_partial_SPS_transfer() throws Throwable {
		System.out.println(">>> General Information - External Partial SPS");
		Thread.sleep(40000);
		reqInfo.spsRadioButton(driver).click();
		reqInfo.confirmWithOK(driver).click();
		reqInfo.externalRadioButton(driver).click();
		reqInfo.saveAndContinueButton(driver).click();
		reqInfo.confirmWithOK(driver).click();
		reqInfo.confirmGeneralInfoButton(driver).click();
	}
	
	@Given("^the user makes ticket an margin partial SPS transfer$")
	public void the_user_makes_ticket_an_margin_partial_SPS_transfer() throws Throwable {
		System.out.println(">>> General Information - Margin Partial SPS");
		Thread.sleep(40000);
		reqInfo.spsRadioButton(driver).click();
		reqInfo.spsRadioButton(driver).click();
		reqInfo.confirmWithOK(driver).click();
		reqInfo.jpmcMarginRadioButton(driver).click();
		reqInfo.saveAndContinueButton(driver).click();
		reqInfo.confirmGeneralInfoButton(driver).click();
	}

}
