package testScripts;

import java.util.List;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pageObjects.securityTransferTabs.SecTransferDetails;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import driver.RunIE;

public class _3_SecurityTransfer {

	_1_WorkStation workStation = new _1_WorkStation();
	WebDriver driver = workStation.getDriver();
	SecTransferDetails secDetails = new SecTransferDetails();
	public static String cusip;
	public static String assetTypeName;
	public static String receivingAcct;
	public static String otherReceivingAcct;

	@After("@SecTransRouting , @test, @CompleteTestSuite")
	public void shutdownPartial(){
		driver.quit();
	}
	
	public static String getReceivingAcct() {
		return receivingAcct;
	}

	public static String getOtherReceivingAcct() {
		return otherReceivingAcct;
	}

	public static void setReceivingAcct(String receivingAcct) {
		_3_SecurityTransfer.receivingAcct = receivingAcct;
	}

	public static void setOtherReceivingAcct(String otherReceivingAcct) {
		_3_SecurityTransfer.otherReceivingAcct = otherReceivingAcct;
	}

	public String getCusip() {
		return cusip;
	}

	public void setCusip(String cusip) {
		this.cusip = cusip;
	}
	
	public String getAssetTypeName() {
		return assetTypeName;
	}

	public static void setAssetTypeName(String assetTypeName) {
		_3_SecurityTransfer.assetTypeName = assetTypeName;
	}

	@When("^the user selects the asset to transfer \"([^\"]*)\" (\\d+) (\\d+)$")
	public void the_user_selects_the_asset_to_transfer(String assetTypeName, int assetTypeCode, int cusip) throws Throwable {
		//The cusip is used to identify which ass is going to be transferred
		//The other variables are only there for cleaner reporting
		System.out.println(">>> Asset Type: " + assetTypeName + " Asset Type Code: " + assetTypeCode + " Cusip: " + cusip);
		String cusipString = Integer.toString(cusip);
		setCusip(cusipString);
		setAssetTypeName(assetTypeName);
		secDetails.checkIfAssetUntransferable(driver, cusipString);
		secDetails.inputTransferQty(driver, cusipString, assetTypeName);
		secDetails.addAssetsButton(driver).click();
		secDetails.checkIfThereIsAnTechnicalError(driver);
	}
	
	@When("^the user selects the asset to transfer \"([^\"]*)\" (\\d+) \"([^\"]*)\"$")
	public void the_user_selects_the_asset_to_transfer(String assetTypeName, int assetTypeCode, String cusip) throws Throwable {
		//Thread.sleep(10000);
		System.out.println(">>> Asset Type: " + assetTypeName + " Asset Type Code: " + assetTypeCode + " Cusip: " + cusip);
		setCusip(cusip);
		setAssetTypeName(assetTypeName);
		secDetails.checkIfAssetUntransferable(driver, cusip);
		secDetails.inputTransferQty(driver, cusip, assetTypeName);
		secDetails.addAssetsButton(driver).click();	
		secDetails.checkIfThereIsAnTechnicalError(driver);
	}
	
//Partial Security Transfer
	
	@When("^the user enters an external account to recieve the assets$")
	public void the_user_enters_an_external_account_to_recieve_the_assets() throws Throwable {
		System.out.println(">>> Security Transfer Details");
		Thread.sleep(5000);
		secDetails.addAccountButtonExternal(driver).click();
		secDetails.addAccountButtonExternal(driver).click();
		secDetails.acctTitleExternal(driver).sendKeys("Some Other Banks");
		secDetails.acctNumberExternal(driver).sendKeys("1234");
		secDetails.entityNameExternal(driver).sendKeys("Mike Novack");
		secDetails.addressExternal(driver).sendKeys("123 Main St");
		secDetails.ssn_TinExternal(driver).sendKeys("123456789");
		secDetails.dateOfBirthExternal(driver).sendKeys("08/28/1992");
		secDetails.countryOfResExternal(driver).sendKeys("USA");
		secDetails.confirmWithOKExternal(driver).click();
	}
	
	@When("^the user enters an external account to recieve the assets with: Acct Title - \"([^\"]*)\", Acct Number - \"([^\"]*)\", Entity Name - \"([^\"]*)\", Address - \"([^\"]*)\", SSN/TIN - \"([^\"]*)\", Date of Birth - \"([^\"]*)\", and Country of Res - \"([^\"]*)\"$")
	public void the_user_enters_an_external_account_to_recieve_the_assets_with_Acct_Title_Acct_Number_Entity_Name_Address_SSN_TIN_Date_of_Birth_and_Country_of_Res_(String acctTitle, String acctNum, String entityName, String address, String ssn, String dateOfBirth, String countryOfRes) throws Throwable {
		System.out.println(">>> Security Transfer Details");
		Thread.sleep(5000);
		secDetails.addAccountButtonExternal(driver).click();
		secDetails.addAccountButtonExternal(driver).click();
		secDetails.acctTitleExternal(driver).sendKeys(acctTitle);
		secDetails.acctNumberExternal(driver).sendKeys(acctNum);
		secDetails.entityNameExternal(driver).sendKeys(entityName);
		secDetails.addressExternal(driver).sendKeys(address);
		secDetails.ssn_TinExternal(driver).sendKeys(ssn);
		secDetails.dateOfBirthExternal(driver).sendKeys(dateOfBirth);
		secDetails.countryOfResExternal(driver).sendKeys(countryOfRes);
		secDetails.confirmWithOKExternal(driver).click();
	}
	
	@When("^the user selects an internal account to recieve the assets \"([^\"]*)\"$")
	public void the_user_selects_an_internal_account_to_recieve_the_assets(String receivingAcct) throws Throwable {
		System.out.println(">>> Security Transfer Details");
		Thread.sleep(5000);
		setReceivingAcct(receivingAcct);
		secDetails.addAccountButton(driver).click();
		secDetails.addAccountButton(driver).click();
		secDetails.inputAcctNumInternal(driver).sendKeys(receivingAcct);
		secDetails.searchForInternalAcct(driver).click();
		secDetails.checkAcctInternalInfoIsLoaded(driver, receivingAcct);
		Thread.sleep(2000);
		secDetails.confirmWithOKInternalMargin(driver).click();
	}
	
	@When("^the user selects an internal account to recieve the assets (\\d+)$")
	public void the_user_selects_an_internal_account_to_recieve_the_assets(int receivingAcct) throws Throwable {
		System.out.println(">>> Security Transfer Details");
		String receivingAcctStr = Integer.toString(receivingAcct);
		Thread.sleep(5000);
		setReceivingAcct(receivingAcctStr);
		secDetails.addAccountButton(driver).click();
		secDetails.addAccountButton(driver).click();
		secDetails.inputAcctNumInternal(driver).sendKeys(receivingAcctStr);
		secDetails.searchForInternalAcct(driver).click();
		secDetails.checkAcctInternalInfoIsLoaded(driver, receivingAcctStr);
		Thread.sleep(2000);
		secDetails.confirmWithOKInternalMargin(driver).click();
	}
	
	@When("^the user selects an internal account to recieve the assets for margin (\\d+)$")
	public void the_user_selects_an_internal_account_to_recieve_the_assets_for_margin(String marginReceivingAcct) throws Throwable {
		System.out.println(">>> Security Transfer Details");
		Thread.sleep(5000);
		setReceivingAcct(marginReceivingAcct);
		secDetails.addAccountButton(driver).click();
		secDetails.addAccountButton(driver).click();
		secDetails.inputAcctNumInternal(driver).sendKeys(marginReceivingAcct);
		secDetails.searchForInternalAcct(driver).click();
		secDetails.checkAcctInternalInfoIsLoaded(driver, marginReceivingAcct);
		Thread.sleep(2000);
		secDetails.confirmWithOKInternalMargin(driver).click();
	}
	
	@Given("^the user sets an internal account to receive all of the assets of the account \"([^\"]*)\"$")
	public void the_user_sets_an_internal_account_to_receive_all_of_the_assets_of_the_account(String receivingAcct) throws Throwable {
		System.out.println(">>> Security Transfer Details");
		Thread.sleep(10000);
		setReceivingAcct(receivingAcct);
		secDetails.addAccountButton(driver).click();
		secDetails.inputAcctNumInternal(driver).sendKeys(receivingAcct);
		secDetails.searchForInternalAcct(driver).click();
		Thread.sleep(1000);
		secDetails.confirmWithOKInternalMargin(driver).click();
		secDetails.checkIfThereIsAnTechnicalError(driver);
		
		Thread.sleep(3000);
		List<WebElement> listOfOk = driver.findElements(By.xpath("//button[contains(text(), 'OK')]"));
		List<WebElement> listOfSpans = driver.findElements(By.xpath("//span[contains(text(), 'Confirm - Have all liens been removed in OMNI')]"));
		if(listOfOk.size() == 1 && listOfSpans.size() == 1){
			listOfOk.get(0).click();
		}
		
		secDetails.confirmWithOKAssetMovement(driver).click();
		
		//Tests if all of the rows of data transferred from the Delivery Account Asset Details to the Assets to be Transferred Grid
		checkIfTheRightNumberOfAssetsTransferred();

	}
	
	@Given("^the user enters in an external account to receive all of the assets of the account$")
	public void the_user_enters_in_an_external_account_to_receive_all_of_the_assets_of_the_account() throws Throwable {
		System.out.println(">>> Security Transfer Details");
		Thread.sleep(10000);
		secDetails.addAccountButtonExternal(driver).click();
		secDetails.acctTitleExternal(driver).sendKeys("Some Other Banks");
		secDetails.acctNumberExternal(driver).sendKeys("1234");
		secDetails.entityNameExternal(driver).sendKeys("Mike Novack");
		secDetails.addressExternal(driver).sendKeys("123 Main St");
		secDetails.ssn_TinExternal(driver).sendKeys("123456789");
		secDetails.dateOfBirthExternal(driver).sendKeys("08/28/1992");
		secDetails.countryOfResExternal(driver).sendKeys("USA");
		secDetails.confirmWithOKExternal(driver).click();
		secDetails.checkIfThereIsAnTechnicalError(driver);
		
		Thread.sleep(3000);
		List<WebElement> listOfOk = driver.findElements(By.xpath("//button[contains(text(), 'OK')]"));
		List<WebElement> listOfSpans = driver.findElements(By.xpath("//span[contains(text(), 'Confirm - Have all liens been removed in OMNI')]"));
		if(listOfOk.size() == 1 && listOfSpans.size() == 1){
			listOfOk.get(0).click();
		}
		
		secDetails.confirmWithOKAssetMovement(driver).click();
		
		//Tests if all of the rows of data transferred from the Delivery Account Asset Details to the Assets to be Transferred Grid
		checkIfTheRightNumberOfAssetsTransferred();
	}
	
	public void checkIfTheRightNumberOfAssetsTransferred() throws InterruptedException{
		
		List<WebElement> gridOfDeliveryAssets = secDetails.gridOfDeliveryAssets(driver);
		int gridOfDeliveryAssetsGreyed = secDetails.gridOfDeliveryAssetsGreyed(driver);
		List<WebElement> gridOfReceivingAssets = secDetails.gridOfReceivingAssets(driver);
		
		int numOfRowsInCurrentAssetsGrid = gridOfDeliveryAssets.size() - 1;
		numOfRowsInCurrentAssetsGrid = numOfRowsInCurrentAssetsGrid - gridOfDeliveryAssetsGreyed;
		int numOfRowsInAssetsToBeTransferredGrid = gridOfReceivingAssets.size();

		assertEquals(numOfRowsInCurrentAssetsGrid, numOfRowsInAssetsToBeTransferredGrid);		
	}
	
	@Given("^targeted asset is transfered \"([^\"]*)\" \"([^\"]*)\" (\\d+)$")
	public void targeted_asset_is_transfered(String assetTypeName, String assetTypeCode, int cusip) throws Throwable {
		System.out.println(">>> Asset Type: " + assetTypeName + " Asset Type Code: " + assetTypeCode + " Cusip: " + cusip);
		/*
		 * Even though a full transfer is executed the tests focuses on the routing of just one asset in the transfer
		 * This allows the test to be clear what it is testing because a given account can have multiple types of assets
		 * It also makes it so much of the code and method of the partial transfer tests can be leveraged
		 */
		String stringCusip = Integer.toString(cusip);
		setCusip(stringCusip);
		setAssetTypeName(assetTypeName);
		secDetails.checkIfAssetUntransferable(driver, stringCusip);
	}

	@Given("^targeted asset is transfered \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void targeted_asset_is_transfered(String assetTypeName, String assetTypeCode, String cusip) throws Throwable {
		System.out.println(">>> Asset Type: " + assetTypeName + " Asset Type Code: " + assetTypeCode + " Cusip: " + cusip);
		/*
		 * Even though a full transfer is executed the tests focuses on the routing of just one asset in the transfer
		 * This allows the test to be clear what it is testing because a given account can have multiple types of assets
		 * It also makes it so much of the code and method of the partial transfer tests can be leveraged
		 */
		setCusip(cusip);
		setAssetTypeName(assetTypeName);
		secDetails.checkIfAssetUntransferable(driver, cusip);
	}
	
	@Given("^targeted asset is transfered \"([^\"]*)\" (\\d+) \"([^\"]*)\"$")
	public void targeted_asset_is_transfered(String assetTypeName, int assetTypeCode, String cusip) throws Throwable {
		System.out.println(">>> Asset Type: " + assetTypeName + " Asset Type Code: " + assetTypeCode + " Cusip: " + cusip);
		setCusip(cusip);
		setAssetTypeName(assetTypeName);
		secDetails.checkIfAssetUntransferable(driver, cusip);
	}
	
//Full Security Transfer
	
	@Given("^the user add external account and assigns target asset to transfer \"([^\"]*)\" (\\d+) \"([^\"]*)\"$")
	public void the_user_add_external_account_and_assigns_target_asset_to_transfer_assetTypeName_assetTypeCode_cusip(String assetTypeName, int assetTypeCode, String cusip) throws Throwable {
		
		System.out.println(">>> Security Transfer Details");
		Thread.sleep(10000);
		secDetails.addAccountButtonExternal(driver).click();
		secDetails.acctTitleExternal(driver).sendKeys("Some Other Banks");
		secDetails.acctNumberExternal(driver).sendKeys("1234");
		secDetails.entityNameExternal(driver).sendKeys("Mike Novack");
		secDetails.addressExternal(driver).sendKeys("123 Main St");
		secDetails.ssn_TinExternal(driver).sendKeys("123456789");
		secDetails.dateOfBirthExternal(driver).sendKeys("08/28/1992");
		secDetails.countryOfResExternal(driver).sendKeys("USA");
		secDetails.confirmWithOKExternal(driver).click();
		
		
		System.out.println(">>> Asset Type: " + assetTypeName + " Asset Type Code: " + assetTypeCode + " Cusip: " + cusip);
		setCusip(cusip);
		setAssetTypeName(assetTypeName);
		secDetails.checkIfAssetUntransferable(driver, cusip);
		secDetails.inputTransferQty(driver, cusip, assetTypeName);
		secDetails.addAssetsButton(driver).click();
		secDetails.checkIfThereIsAnTechnicalError(driver);
		
		Thread.sleep(3000);
		List<WebElement> listOfOk = driver.findElements(By.xpath("//button[contains(text(), 'OK')]"));
		List<WebElement> listOfSpans = driver.findElements(By.xpath("//span[contains(text(), 'Confirm - Have all liens been removed in OMNI')]"));
		if(listOfOk.size() == 1 && listOfSpans.size() == 1){
			listOfOk.get(0).click();
		}
		
		secDetails.confirmWithOKAssetMovement(driver).click();
	}
	
	@Given("^the user add external account and assigns target asset to transfer \"([^\"]*)\" (\\d+) (\\d+)$")
	public void the_user_add_external_account_and_assigns_target_asset_to_transfer_assetTypeName_assetTypeCode_cusip(String assetTypeName, int assetTypeCode, int cusip) throws Throwable {
		
		System.out.println(">>> Security Transfer Details");
		Thread.sleep(10000);
		secDetails.addAccountButtonExternal(driver).click();
		secDetails.acctTitleExternal(driver).sendKeys("Some Other Banks");
		secDetails.acctNumberExternal(driver).sendKeys("1234");
		secDetails.entityNameExternal(driver).sendKeys("Mike Novack");
		secDetails.addressExternal(driver).sendKeys("123 Main St");
		secDetails.ssn_TinExternal(driver).sendKeys("123456789");
		secDetails.dateOfBirthExternal(driver).sendKeys("08/28/1992");
		secDetails.countryOfResExternal(driver).sendKeys("USA");
		secDetails.confirmWithOKExternal(driver).click();

		
		System.out.println(">>> Asset Type: " + assetTypeName + " Asset Type Code: " + assetTypeCode + " Cusip: " + cusip);
		String cusipString = Integer.toString(cusip);
		setCusip(cusipString);
		setAssetTypeName(assetTypeName);
		secDetails.checkIfAssetUntransferable(driver, cusipString);
		secDetails.inputTransferQty(driver, cusipString, assetTypeName);
		secDetails.addAssetsButton(driver).click();
		secDetails.checkIfThereIsAnTechnicalError(driver);
		
		Thread.sleep(3000);
		List<WebElement> listOfOk = driver.findElements(By.xpath("//button[contains(text(), 'OK')]"));
		List<WebElement> listOfSpans = driver.findElements(By.xpath("//span[contains(text(), 'Confirm - Have all liens been removed in OMNI')]"));
		if(listOfOk.size() == 1 && listOfSpans.size() == 1){
			listOfOk.get(0).click();
		}
		
		secDetails.confirmWithOKAssetMovement(driver).click();
	}

	@Given("^the user adds another external account and assigns the rest of the assets$")
	public void the_user_adds_another_external_account_and_assigns_the_rest_of_the_assets() throws Throwable {

		System.out.println(">>> Transfer the rest to another account");
		Thread.sleep(10000);
		secDetails.addAccountButtonExternal(driver).click();
		secDetails.addAccountButtonExternal(driver).click();
		secDetails.acctTitleExternal(driver).sendKeys("Some Other Bank 2");
		secDetails.acctNumberExternal(driver).sendKeys("12345");
		secDetails.entityNameExternal(driver).sendKeys("Mike Novack");
		secDetails.addressExternal(driver).sendKeys("123 Main St");
		secDetails.ssn_TinExternal(driver).sendKeys("123456789");
		secDetails.dateOfBirthExternal(driver).sendKeys("08/28/1992");
		secDetails.countryOfResExternal(driver).sendKeys("USA");
		secDetails.confirmWithOKExternal(driver).click();
		
		secDetails.moveAllAssets(driver).click();
		secDetails.confirmMoveAllAssets(driver).click();
		Thread.sleep(10000);
		secDetails.addAssetsButton(driver).click();
		secDetails.checkIfThereIsAnTechnicalError(driver);
		
		Thread.sleep(3000);
		List<WebElement> listOfOk = driver.findElements(By.xpath("//button[contains(text(), 'OK')]"));
		List<WebElement> listOfSpans = driver.findElements(By.xpath("//span[contains(text(), 'Confirm - Have all liens been removed in OMNI')]"));
		if(listOfOk.size() == 1 && listOfSpans.size() == 1){
			listOfOk.get(0).click();
		}
		
		secDetails.confirmWithOKAssetMovement(driver).click();
	}
	
	@Given("^the user add internal account and assigns target asset to transfer \"([^\"]*)\" (\\d+) \"([^\"]*)\" \"([^\"]*)\"$")
	public void the_user_add_internal_account_and_assigns_target_asset_to_transfer_assetTypeName_assetTypeCode_cusip(String assetTypeName, int assetTypeCode, String cusip, String receivingAcct) throws Throwable {
		System.out.println(">>> Security Transfer Details");
		Thread.sleep(10000);
		setReceivingAcct(receivingAcct);
		secDetails.addAccountButton(driver).click();
		secDetails.addAccountButton(driver).click();
		secDetails.inputAcctNumInternal(driver).sendKeys(receivingAcct);
		secDetails.searchForInternalAcct(driver).click();
		secDetails.checkAcctInternalInfoIsLoaded(driver, receivingAcct);
		Thread.sleep(2000);
		secDetails.confirmWithOKInternalMargin(driver).click();
		
		System.out.println(">>> Asset Type: " + assetTypeName + " Asset Type Code: " + assetTypeCode + " Cusip: " + cusip);
		setCusip(cusip);
		setAssetTypeName(assetTypeName);
		secDetails.checkIfAssetUntransferable(driver, cusip);
		secDetails.inputTransferQty(driver, cusip, assetTypeName);
		secDetails.addAssetsButton(driver).click();
		secDetails.checkIfThereIsAnTechnicalError(driver);
		
		Thread.sleep(3000);
		List<WebElement> listOfOk = driver.findElements(By.xpath("//button[contains(text(), 'OK')]"));
		List<WebElement> listOfSpans = driver.findElements(By.xpath("//span[contains(text(), 'Confirm - Have all liens been removed in OMNI')]"));
		if(listOfOk.size() == 1 && listOfSpans.size() == 1){
			listOfOk.get(0).click();
		}
		
		secDetails.confirmWithOKAssetMovement(driver).click();
	}
	
	@Given("^the user add internal account and assigns target asset to transfer \"([^\"]*)\" (\\d+) (\\d+) \"([^\"]*)\"$")
	public void the_user_add_internal_account_and_assigns_target_asset_to_transfer_assetTypeName_assetTypeCode_cusip(String assetTypeName, int assetTypeCode, int cusip, String receivingAcct) throws Throwable {
		System.out.println(">>> Security Transfer Details");
		Thread.sleep(10000);
		setReceivingAcct(receivingAcct);
		secDetails.addAccountButton(driver).click();
		secDetails.addAccountButton(driver).click();
		secDetails.inputAcctNumInternal(driver).sendKeys(receivingAcct);
		secDetails.searchForInternalAcct(driver).click();
		secDetails.checkAcctInternalInfoIsLoaded(driver, receivingAcct);
		Thread.sleep(2000);
		secDetails.confirmWithOKInternalMargin(driver).click();
		
		System.out.println(">>> Asset Type: " + assetTypeName + " Asset Type Code: " + assetTypeCode + " Cusip: " + cusip);
		String cusipString = Integer.toString(cusip);
		setCusip(cusipString);
		setAssetTypeName(assetTypeName);
		secDetails.checkIfAssetUntransferable(driver, cusipString);
		secDetails.inputTransferQty(driver, cusipString, assetTypeName);
		secDetails.addAssetsButton(driver).click();
		secDetails.checkIfThereIsAnTechnicalError(driver);
		
		Thread.sleep(3000);
		List<WebElement> listOfOk = driver.findElements(By.xpath("//button[contains(text(), 'OK')]"));
		List<WebElement> listOfSpans = driver.findElements(By.xpath("//span[contains(text(), 'Confirm - Have all liens been removed in OMNI')]"));
		if(listOfOk.size() == 1 && listOfSpans.size() == 1){
			listOfOk.get(0).click();
		}
		
		secDetails.confirmWithOKAssetMovement(driver).click();
	}
	
	@Given("^the user adds another internal account and assigns the rest of the assets \"([^\"]*)\"$")
	public void the_user_adds_another_internal_account_and_assigns_the_rest_of_the_assets(String otherReceivingAcct) throws Throwable {

		System.out.println(">>> Transfer the rest to another account");
		Thread.sleep(10000);
		setOtherReceivingAcct(otherReceivingAcct);
		secDetails.addAccountButton(driver).click();
		secDetails.addAccountButton(driver).click();
		secDetails.inputAcctNumInternal(driver).sendKeys(otherReceivingAcct);
		secDetails.searchForInternalAcct(driver).click();
		Thread.sleep(5000);
		secDetails.confirmWithOKInternalMargin(driver).click();
		
		secDetails.moveAllAssets(driver).click();
		secDetails.confirmMoveAllAssets(driver).click();
		Thread.sleep(10000);
		secDetails.addAssetsButton(driver).click();
		secDetails.checkIfThereIsAnTechnicalError(driver);
		
		Thread.sleep(3000);
		List<WebElement> listOfOk = driver.findElements(By.xpath("//button[contains(text(), 'OK')]"));
		List<WebElement> listOfSpans = driver.findElements(By.xpath("//span[contains(text(), 'Confirm - Have all liens been removed in OMNI')]"));
		if(listOfOk.size() == 1 && listOfSpans.size() == 1){
			listOfOk.get(0).click();
		}
		
		secDetails.confirmWithOKAssetMovement(driver).click();
	}
//DWAC
	
	@When("^the user adds a reference control number$")
	public void the_user_adds_a_reference_control_number() throws Throwable {
		System.out.println(">>> Security Transfer Details");
		Thread.sleep(15000);
		secDetails.dwacAddRefCtrlNum(driver).click();
	    secDetails.dwacReferenceControlNum(driver).sendKeys("1234");
	    secDetails.dwacReferenceControlNumConfirm(driver).click();
	}
	
	@When("^the user adds a reference control number for external transfers$")
	public void the_user_adds_a_reference_control_number_for_external_transfers() throws Throwable {
		System.out.println(">>> Security Transfer Details");
		Thread.sleep(15000);
		secDetails.dwacAddRefCtrlNumExternal(driver).click();
	    secDetails.dwacReferenceControlNum(driver).sendKeys("1234");
	    secDetails.dwacReferenceControlNumConfirm(driver).click();
	}

	@When("^the user enters in the data for the expected assets \"([^\"]*)\" (\\d+) \"([^\"]*)\"$")
	public void the_user_enters_in_the_data_for_the_expected_assets(String assetTypeName, int assetTypeCode, String cusip) throws Throwable {
		System.out.println(">>> Asset Type: " + assetTypeName + " Asset Type Code: " + assetTypeCode + " Cusip: " + cusip);
		setCusip(cusip);
		setAssetTypeName(assetTypeName);
		secDetails.dwacCusipSearch(driver).sendKeys(cusip);
	    secDetails.dwacCusipSearchButton(driver).click();
	    secDetails.dwacQty(driver).sendKeys("1000");
	    secDetails.dwacAddAssets(driver).click();
	}
	
	@When("^the user enters in the data for the expected assets \"([^\"]*)\" (\\d+) (\\d+)$")
	public void the_user_enters_in_the_data_for_the_expected_assets(String assetTypeName, int assetTypeCode, int cusip) throws Throwable {
		System.out.println(">>> Asset Type: " + assetTypeName + " Asset Type Code: " + assetTypeCode + " Cusip: " + cusip);
		String cusipString = Integer.toString(cusip);
		setCusip(cusipString);
		setAssetTypeName(assetTypeName);
		secDetails.dwacCusipSearch(driver).sendKeys(cusipString);
	    secDetails.dwacCusipSearchButton(driver).click();
	    secDetails.dwacQty(driver).sendKeys("1000");
	    secDetails.dwacAddAssets(driver).click();
	}
	
	@When("^the user enters in the data for the expected assets for a SPS transaction \"([^\"]*)\" (\\d+) (\\d+)$")
	public void the_user_enters_in_the_data_for_the_expected_assets_for_a_SPS_transaction(String assetTypeName, int assetTypeCode, int cusip) throws Throwable {
		System.out.println(">>> Asset Type: " + assetTypeName + " Asset Type Code: " + assetTypeCode + " Cusip: " + cusip);
		Thread.sleep(5000);
		secDetails.spsAssetType(driver).click();
	    secDetails.spsAssetType(driver).click();
		String cusipString = Integer.toString(cusip);
		setCusip(cusipString);
		setAssetTypeName(assetTypeName);
		secDetails.dwacCusipSearch(driver).sendKeys(cusipString);
	    secDetails.dwacCusipSearchButton(driver).click();
	    secDetails.dwacQty(driver).sendKeys("1000");
	    secDetails.dwacAddAssets(driver).click();
	    Thread.sleep(5000);
	}
	
	@When("^the user enters in the data for the expected assets for a SPS transaction \"([^\"]*)\" (\\d+) \"([^\"]*)\"$")
	public void the_user_enters_in_the_data_for_the_expected_assets_for_a_SPS_transaction(String assetTypeName, int assetTypeCode, String cusip) throws Throwable {
		System.out.println(">>> Asset Type: " + assetTypeName + " Asset Type Code: " + assetTypeCode + " Cusip: " + cusip);
		Thread.sleep(5000);
		setCusip(cusip);
		setAssetTypeName(assetTypeName);
		secDetails.spsAssetType(driver).click();
		secDetails.spsAssetType(driver).click();
		secDetails.dwacCusipSearch(driver).sendKeys(cusip);
	    secDetails.dwacCusipSearchButton(driver).click();
	    secDetails.dwacQty(driver).sendKeys("1000");
	    secDetails.dwacAddAssets(driver).click();
	    Thread.sleep(3000);
	}
	
	@Given("^the user enters in the data for the expected assets for a SPS transaction \"([^\"]*)\" \"([^\"]*)\" (\\d+)$")
	public void the_user_enters_in_the_data_for_the_expected_assets_for_a_SPS_transaction(String assetTypeName, String assetTypeCode, int cusip) throws Throwable {
		System.out.println(">>> Asset Type: " + assetTypeName + " Asset Type Code: " + assetTypeCode + " Cusip: " + cusip);
		Thread.sleep(5000);
		secDetails.spsAssetType(driver).click();
	    secDetails.spsAssetType(driver).click();
		String cusipString = Integer.toString(cusip);
		setCusip(cusipString);
		setAssetTypeName(assetTypeName);
		secDetails.dwacCusipSearch(driver).sendKeys(cusipString);
	    secDetails.dwacCusipSearchButton(driver).click();
	    secDetails.dwacQty(driver).sendKeys("1000");
	    secDetails.dwacAddAssets(driver).click();
	    Thread.sleep(3000);
	}
	
//SPS Partial
	
	@When("^the user enters an external account to recieve the assets SPS$")
	public void the_user_enters_an_external_account_to_recieve_the_assets_SPS() throws Throwable {
		System.out.println(">>> Security Transfer Details");
		Thread.sleep(5000);
		secDetails.addAccountButtonSPS(driver).click();
		secDetails.addAccountButtonSPS(driver).click();
		secDetails.acctTitleExternal(driver).sendKeys("Some Other Banks");
		secDetails.acctNumberExternal(driver).sendKeys("1234");
		secDetails.entityNameExternal(driver).sendKeys("Mike Novack");
		secDetails.addressExternal(driver).sendKeys("123 Main St");
		secDetails.ssn_TinExternal(driver).sendKeys("123456789");
		secDetails.dateOfBirthExternal(driver).sendKeys("08/28/1992");
		secDetails.countryOfResExternal(driver).sendKeys("USA");
		secDetails.confirmWithOKExternal(driver).click();
	}
	
	@When("^the user selects an internal account to recieve the assets SPS \"([^\"]*)\"$")
	public void the_user_selects_an_internal_account_to_recieve_the_assets_SPS(String receivingAcct) throws Throwable {
		System.out.println(">>> Security Transfer Details");
		Thread.sleep(5000);
		setReceivingAcct(receivingAcct);
		secDetails.addAccountButtonSPS(driver).click();
		secDetails.inputAcctNumInternal(driver).sendKeys(receivingAcct);
		secDetails.searchForInternalAcctSPS(driver).click();
		secDetails.checkAcctInternalInfoIsLoaded(driver, receivingAcct);
		Thread.sleep(2000);
		secDetails.confirmWithOKInternalMargin(driver).click();
	}
	
	@When("^the user selects an internal account to recieve the assets SPS (\\d+)$")
	public void the_user_selects_an_internal_account_to_recieve_the_assets_SPS(int receivingAcct) throws Throwable {
		System.out.println(">>> Security Transfer Details");
		String receivingAcctStr = Integer.toString(receivingAcct);
		Thread.sleep(10000);
		setReceivingAcct(receivingAcctStr);
		secDetails.addAccountButtonSPS(driver).click();
		secDetails.inputAcctNumInternal(driver).sendKeys(receivingAcctStr);
		secDetails.searchForInternalAcctSPS(driver).click();
		secDetails.checkAcctInternalInfoIsLoaded(driver, receivingAcctStr);
		Thread.sleep(2000);
		secDetails.confirmWithOKInternalMargin(driver).click();
	}
	
}
