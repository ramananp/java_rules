package testScripts;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.otherPageObjects.CommentsAndAttachments;
import pageObjects.otherPageObjects.CreditTeamApp;
import pageObjects.otherPageObjects.InitRequest;
import pageObjects.otherPageObjects.SSOLogIn;
import pageObjects.otherPageObjects.WkstSQ;
import pageObjects.securityTransferTabs.AddressAndLetters;
import pageObjects.securityTransferTabs.DeliveryInstructions;
import pageObjects.securityTransferTabs.GenReqInfo;
import pageObjects.securityTransferTabs.SecTransferDetails;
import pageObjects.securityTransferTabs.StatusTab;
import pageObjects.securityTransferTabs.VerifyAndApprove;
//import utilityPrograms.RunGiftMeanValueBatch;







import utilityPrograms.RunGiftMeanValueBatch;

import com.google.common.base.Predicate;
import com.jpmchase.aata.services.to.AATAAssetDtlsTO;
import com.jpmchase.aata.services.to.AATAStatusTO;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import databaseObjects.DelTktSQ;
import driver.RunIE;
import excelUpdatesFeatureFile.backgroundSection.abstractProperties.ReadLogInfo;

//These step definations are shared between multiple feature files
public class _4_DeliveryInstructionsTab {
	
	_1_WorkStation workStation = new _1_WorkStation();
	_3_SecurityTransfer securityTransfer = new _3_SecurityTransfer();
	WebDriver driver = workStation.getDriver();
	SecTransferDetails secDetails = new SecTransferDetails();
	DeliveryInstructions delInst = new DeliveryInstructions();

	@After("@SecTransRouting , @test, @CompleteTestSuite")
	public void shutdownPartial(){
		driver.quit();
	}

//Partial Security Transfer
		@When("^delivery instructions are entered$")
		public void delivery_instructions_are_entered() throws Throwable {
			/*
			 * This step is a starting point for the delivery instructions to be entered
			 * Many assets and ticket types require a wide variety of different information
			 * These differences are covered by adding the relevant step definitions in the feature file
			 * This prevents a massive amount of conditional steps within this step definition and...
			 * easy code reuse between similar scenarios
			 */
			
			secDetails.confirmWithOKAssetMovement(driver).click();
			secDetails.saveAndContinueButton(driver).click();
			secDetails.checkIfThereIsAnTechnicalError(driver);
			
			if(securityTransfer.getAssetTypeName().equals("Option Reg 57") || securityTransfer.getAssetTypeName().equals("Option Reg 58")){
				secDetails.confirmWithOKAssetMovement(driver).click();
			}
			
			System.out.println(">>> Delivery Instructions");
			Thread.sleep(30000);
		}
//Full Security Transfer
		
		@Given("^delivery instructions are entered for external full transfers$")
		public void delivery_instructions_are_entered_for_external_full_transfers() throws Throwable {
			
			secDetails.saveAndContinueButton(driver).click();
			Thread.sleep(45000);
			System.out.println(">>> Delivery Instructions");
			Thread.sleep(30000);
			
			fillinDeliveryInstructionsForExternalFull("1234", "12345");
		}


		
		@Given("^delivery instructions are entered for internal full transfers$")
		public void delivery_instructions_are_entered_for_internal_full_transfers() throws Throwable {
			//secDetails.confirmWithOKInternalMargin(driver).click();
			
			secDetails.saveAndContinueButton(driver).click();
			Thread.sleep(45000);
			System.out.println(">>> Delivery Instructions");
			Thread.sleep(30000);
			
			fillinDeliveryInstructionsForInternalFull("nothing", "nothing2");
		}
//Full to Many
		
		@Given("^delivery instructions are entered for external full many transfers$")
		public void delivery_instructions_are_entered_for_external_full_many_transfers() throws Throwable {
			secDetails.saveAndContinueButton(driver).click();
			Thread.sleep(45000);
			System.out.println(">>> Delivery Instructions");
			Thread.sleep(30000);
			
			fillinDeliveryInstructionsForExternalFull("1234", "12345");
			
			List<WebElement> list = driver.findElements(By.className("x-grid3-col-0"));
			for(WebElement item : list){
				if(item.getText().equals("12345")){
					item.click();
					break;
				}
			}
			
			fillinDeliveryInstructionsForExternalFull("1234", "12345");
			
			Thread.sleep(20000);			
		}
		
		@Given("^delivery instructions are entered for internal full many transfers$")
		public void delivery_instructions_are_entered_for_internal_full_many_transfers() throws Throwable {

			secDetails.saveAndContinueButton(driver).click();
			Thread.sleep(75000);
			System.out.println(">>> Delivery Instructions");
			
			fillinDeliveryInstructionsForInternalFull(securityTransfer.getReceivingAcct(), securityTransfer.getOtherReceivingAcct());

			List<WebElement> list = driver.findElements(By.className("x-grid3-col-0"));
			for(WebElement item : list){
				if(item.getText().equals(securityTransfer.getOtherReceivingAcct())){
					item.click();
					break;
				}
			}
			
			fillinDeliveryInstructionsForInternalFull(securityTransfer.getReceivingAcct(), securityTransfer.getOtherReceivingAcct());
			
			Thread.sleep(20000);
			
		}
		
		public void fillinDeliveryInstructionsForInternalFull(String receivingAcct, String otherReceivingAcct) throws InterruptedException{
			List<WebElement> rows = driver.findElements(By.className("x-grid3-row"));
			List<WebElement> targetedRows = new ArrayList();
	//Gets all the rows from the Receiving Asset Grid
			for(WebElement row : rows){
				if(row.getAttribute("style").equals("WIDTH: 484px; width: 484px;: undefined")){
					targetedRows.add(row);
				}
			}

			for(WebElement targetedRow : targetedRows){
	//Check each row if it has an incomplete icon			
				WebElement img = targetedRow.findElement(By.tagName("img"));
				String classes = targetedRow.getClass().toString();
				if(img.getAttribute("src").contains("Incomplete_Icon.png")){
					WebElement assetType = targetedRow.findElement(By.className("x-grid3-col-3"));
					WebElement accounts = targetedRow.findElement(By.className("x-grid3-col-4"));
					//WebElement accounts = targetedRow.findElement(By.className("x-grid3-col-0"));
	//If the row has an incomplete icon check asset type of the row
	//according to the asset type click the row and execute the delivery instructions
					if(!accounts.getText().equals("")){
					//if(!accounts.getText().equals(receivingAcct) && !accounts.getText().equals(otherReceivingAcct)){
						if(assetType.getText().equals("Lux Fund")){
							assetType.click();
							delInst.dividendOptionReinvestOrCash(driver);
						}else if(assetType.getText().equals("Euroclear") || assetType.getText().equals("Euroclear - Structured Products") ||
								assetType.getText().equals("Local Market Global")){
							assetType.click();
							delInst.nbenOrYNben(driver).click();
						}else if(assetType.getText().equals("Structured Products")){
							assetType.click();
							delInst.structuredProductInstructions(driver).click();
						}else if(assetType.getText().equals("Offshore Mutual Funds")){
							assetType.click();
						}
						else{
							assertTrue("Asset type is not handled: " + assetType.getText() , false);
						}
					}
				}
			}			
		}
		
		public void fillinDeliveryInstructionsForExternalFull(String receivingAcct, String otherReceivingAcct) throws Throwable{
			List<WebElement> rows = driver.findElements(By.className("x-grid3-row"));
			List<WebElement> targetedRows = new ArrayList();
	//Gets all the rows from the Receiving Asset Grid
			for(WebElement row : rows){
				if(row.getAttribute("style").equals("WIDTH: 484px; width: 484px;: undefined")){
					targetedRows.add(row);
				}
			}
			
			for(WebElement targetedRow : targetedRows){
	//Check each row if it has an incomplete icon			
				WebElement img = targetedRow.findElement(By.tagName("img"));
				if(img.getAttribute("src").contains("Incomplete_Icon.png")){
					WebElement assetType = targetedRow.findElement(By.className("x-grid3-col-3"));
					WebElement accounts = targetedRow.findElement(By.className("x-grid3-col-4"));
					
	//If the row has an incomplete icon check asset type of the row
	//according to the asset type click the row and execute the delivery instructions
					if(!accounts.getText().equals("")){
						if(assetType.getText().equals("Lux Fund") || assetType.getText().equals("JPM Fund") || assetType.getText().equals("3rd Party Funds") ||
								assetType.getText().equals("Euroclear") || assetType.getText().equals("Structured Products") || assetType.getText().equals("Euroclear - Structured Products") ||
								assetType.getText().equals("DTC") || assetType.getText().equals("Offshore Mutual Funds") || assetType.getText().equals("Memo") || assetType.getText().equals("Sweep")){
							assetType.click();
							the_DTC_Broker_Name_and_DTC_Number_are_entered();
						}
						else if(assetType.getText().equals("FRB")){
							assetType.click();
							the_ABA_Number_Bank_Name_Feb_Sub_Account_and_Trading_Broker_is_entered_based_off_the_Broker_Search();
						}else if(assetType.getText().equals("Cash - Non-Fiduciary")){
							assetType.click();
						}
						else{
							assertTrue("Asset type is not handled: " + assetType.getText() , false);
						}
					}
				}
			}
		}
		//DWAC
//Partial SPS
//Full SPS
		
		@Given("^delivery instructions are entered for external full SPS transfers$")
		public void delivery_instructions_are_entered_for_external_full_SPS_transfers() throws Throwable {
			secDetails.saveAndContinueButton(driver).click();
			Thread.sleep(45000);
			System.out.println(">>> Delivery Instructions");
			Thread.sleep(30000);
			
			delInst.trailerDesc(driver).sendKeys("111");
		}

		@Given("^delivery instructions are entered for internal full SPS transfers$")
		public void delivery_instructions_are_entered_for_internal_full_SPS_transfers() throws Throwable {
			secDetails.saveAndContinueButton(driver).click();
			Thread.sleep(45000);
			System.out.println(">>> Delivery Instructions");
			Thread.sleep(30000);
			
			delInst.trailerDesc(driver).sendKeys("111");
		}
		
//Specific mandatory fields for delivery instructions
	
	/*
	 * The deliver instructions have different required fields for different asset and transfer types
	 * Instead of creating a specific step for each asset and transfer type
	 * It is easier to create a couple step definitions that target a few required fields
	 * and insert them in the appropriate scenarios
	 */
	
	@When("^the DTC/Broker Name and DTC Number are entered$")
	public void the_DTC_Broker_Name_and_DTC_Number_are_entered() throws Throwable {
		delInst.brokerSearchButton(driver).click();
		delInst.brokerSearchButton(driver).click();
		delInst.searchBrokerNameTextField(driver).sendKeys("JPM");
		delInst.searchButton(driver).click();
		Thread.sleep(2000);
		delInst.okButton(driver).click();
	}
	
	@When("^the Trailer Description is entered$")
	public void the_Trailer_Description_is_entered() throws Throwable {
		delInst.trailerDesc(driver).sendKeys("111");
	}
	
	@When("^the Structured Products Instructions are entered$")
	public void the_Structured_Products_Instructions_are_entered() throws Throwable {
		delInst.structuredProductInstructions(driver);

	}

	@When("^the ABA Number, Bank Name, and Feb Sub Account is entered based off the Broker Search$")
	public void the_ABA_Number_Bank_Name_and_Feb_Sub_Account_is_entered_based_off_the_Broker_Search() throws Throwable {
		delInst.brokerSearchButton(driver).click();
		delInst.brokerSearchButton(driver).click();
		delInst.searchBrokerNameTextField(driver).sendKeys("JPM");
		delInst.searchButton(driver).click();
		Thread.sleep(2000);
		delInst.okButton(driver).click();
	}
	
	@When("^the ABA Number, Bank Name, Feb Sub Account, and Trading Broker SPS is entered based off the Broker Search$")
	public void the_ABA_Number_Bank_Name_Feb_Sub_Account_and_Trading_Broker_SPS_is_entered_based_off_the_Broker_Search() throws Throwable {
		delInst.brokerSearchButton(driver).click();
		delInst.brokerSearchButton(driver).click();
		delInst.searchBrokerNameTextField(driver).sendKeys("JPM");
		delInst.searchButton2(driver).click();
		Thread.sleep(2000);
		delInst.okButton(driver).click();
	}
	
	@When("^the ABA Number, Bank Name, Feb Sub Account, and Trading Broker is entered based off the Broker Search$")
	public void the_ABA_Number_Bank_Name_Feb_Sub_Account_and_Trading_Broker_is_entered_based_off_the_Broker_Search() throws Throwable {
		delInst.brokerSearchButton(driver).click();
		delInst.brokerSearchButton(driver).click();
		delInst.searchBrokerNameTextField(driver).sendKeys("JPM");
		delInst.searchButton(driver).click();
		Thread.sleep(2000);
		delInst.okButton(driver).click();
	}

	@When("^the Mutual Fund Account Number is entered$")
	public void the_Mutual_Fund_Account_Number_is_entered() throws Throwable {
		delInst.mutualFundAccountNumber(driver).sendKeys("Mutual Fund Account Number");
	}
	
	@When("^the Signature of Vault Custodian is entered$")
	public void the_Signature_of_Vault_Custodian_is_entered() throws Throwable {
		delInst.signatureOfVaultCustodian(driver).sendKeys("Signature of Vault Custodian");
	}
	
	@When("^the Date is entered$")
	public void the_Date_is_entered() throws Throwable {
		delInst.date(driver).sendKeys("date");
	}

	@When("^the Fundsettle Account Number is entered$")
	public void the_Fundsettle_Account_Number_is_entered() throws Throwable {
		delInst.fundsettleAccountNumber(driver).sendKeys("Fundsettle Account Number");
	}

	@When("^the Dividend Option - Reinvest or Cash is entered$")
	public void the_Dividend_Option_Reinvest_or_Cash_is_entered() throws Throwable {
		delInst.dividendOptionReinvestOrCash(driver);
	}

	@When("^the YBEN or NBEN is entered$")
	public void the_YBEN_or_NBEN_is_entered() throws Throwable {
		delInst.nbenOrYNben(driver).click();
		delInst.nbenOrYNben(driver).click();	
	}

	@When("^the ISIN/Sedol are entered$")
	public void the_ISIN_Sedol_are_entered() throws Throwable {
		delInst.isinSedol(driver).sendKeys("ISIN/Sedol");
	}

	@When("^the Security Currency are entered$")
	public void the_Security_Currency_are_entered() throws Throwable {
		delInst.securityCurrency(driver).sendKeys("Security Currency");
	}

	@When("^the Clearing Broker ID - Euroclear are entered$")
	public void the_Clearing_Broker_ID_Euroclear_are_entered() throws Throwable {
		delInst.clearingBrokerIdEuroclear(driver).click();	
		delInst.clearingBrokerIdEuroclear(driver).click();	
	}

	@When("^the Clearing Broker ID - Euroclear is entered$")
	public void the_Clearing_Broker_ID_Euroclear_is_entered() throws Throwable {
		delInst.clearingBrokerIdEuroclear(driver).click();	
		delInst.clearingBrokerIdEuroclear(driver).click();	
	}

	@When("^the Clearing Broker ID is entered$")
	public void the_Clearing_Broker_ID_is_entered() throws Throwable {
		delInst.clearingBrokerIdCode(driver).sendKeys("Clear Broker ID");
	}

	@When("^the Clearing Broker BIC is entered$")
	public void the_Clearing_Broker_BIC_is_entered() throws Throwable {
		delInst.clearingBrokerBIC(driver).sendKeys("Clearing Broker BIC");
	}
	
	@When("^the Clearing Broker Code is entered$")
	public void the_Clearing_Broker_Code_is_entered() throws Throwable {
		delInst.clearingBrokerCode(driver);
	}

	@When("^the Clearing Broker Name is entered$")
	public void the_Clearing_Broker_Name_is_entered() throws Throwable {
	    delInst.clearingBrokerName(driver).sendKeys("Clearing Broker Name");
	}

	@When("^the Trading Broker BIC is entered$")
	public void the_Trading_Broker_BIC_is_entered() throws Throwable {
		delInst.tradingBrokerBIC(driver).sendKeys("Trading Broker BIC");
	}

	@When("^the Trading Broker Sub Account Info is entered$")
	public void the_Trading_Broker_Sub_Account_Info_is_entered() throws Throwable {
		delInst.tradingBrokerSubAccountInfo(driver).sendKeys("Trading Broker Sub Account Info");
	}

	@When("^the Trading Broker Name is entered$")
	public void the_Trading_Broker_Name_is_entered() throws Throwable {
	    delInst.tradingBrokerName(driver).sendKeys("Trading Broker Name");
	}

	@When("^the Contact Name is entered$")
	public void the_Contact_Name_is_entered() throws Throwable {
		delInst.contactName(driver).sendKeys("Contact Name");
	}

	@When("^the Contact Phone Number is entered$")
	public void the_Contact_Phone_Number_is_entered() throws Throwable {
		delInst.contactPhoneNumber(driver).sendKeys("Contact Phone #");
	}
	@When("^the Physical Mailing Address is entered$")
	public void the_Physical_Mailing_Address_is_entered() throws Throwable {
		delInst.physicalMailingAddress(driver).sendKeys("Physical Mailing Address");
	}

	@When("^the Name Of Individual is entered$")
	public void the_Name_Of_Individual_is_entered() throws Throwable {
		delInst.nameOfIndividual(driver).sendKeys("Name Of Individual");
	}

	@When("^the Beneficiary Info - SSN is entered$")
	public void the_Beneficiary_Info_SSN_is_entered() throws Throwable {
		delInst.beneficiaryInfoSSN(driver).sendKeys("123456789");
	}

	@When("^the Shares Registered To - Name is entered$")
	public void the_Shares_Registered_To_Name_is_entered() throws Throwable {
		delInst.sharesRegisteredName(driver).sendKeys("Shares Registered Name");
	}

	@When("^the Shares Registered To - Address is entered$")
	public void the_Shares_Registered_To_Address_is_entered() throws Throwable {
		delInst.sharesRegisteredAddress(driver).sendKeys("Shares Registered Address");
	}

	@When("^the Street Address is entered$")
	public void the_Street_Address_is_entered() throws Throwable {
		delInst.streetAddress(driver).sendKeys("Street Address");
	}

	@When("^the City, State, Zip is entered$")
	public void the_City_State_Zip_is_entered() throws Throwable {
		delInst.cityStateZip(driver).sendKeys("City, State, Zip");
	}

	@When("^the Receiving Firm name or Client Name is entered$")
	public void the_Receiving_Firm_name_or_Client_Name_is_entered() throws Throwable {
		delInst.receivingFirmNameOrClientName(driver).sendKeys("Receiving Firm Name or Client Name");
	}

	@When("^the Tax Code is entered$")
	public void the_Tax_Code_is_entered() throws Throwable {
		delInst.taxCode(driver);
	}
	
	@When("^the DTC Agent Information is entered$")
	public void the_DTC_Agent_Information_is_entered() throws Throwable {
	    delInst.agentSearchButton(driver).click();
	    delInst.transferAgentNameAutoInput(driver).sendKeys("Wel");
	    delInst.dwacSearchButton(driver).click();
	    delInst.dwacOKCannotFindTransferAgent(driver).click();
		delInst.dtcTransferAgentNameManual(driver).sendKeys("Mike Novack");
	}

	@When("^the Penny Stock Deposit Indication is entered$")
	public void the_Penny_Stock_Deposit_Indication_is_entered() throws Throwable {
	    delInst.pennyStockDepositNo(driver).click();
	}

}
