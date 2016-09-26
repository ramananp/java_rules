package pageObjects.securityTransferTabs;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertNull;

public class SecTransferDetails {
	
	private WebDriverWait wait = null;
	Actions actions = null;
	
	public void wait(WebDriver driver){
		this.wait = new WebDriverWait(driver, 120);
	}
	
	public WebElement confirmWithYes(WebDriver driver) throws InterruptedException{
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*/button[text() = 'Yes']")));
		WebElement element = driver.findElement(By.xpath("//*/button[text() = 'Yes']"));
		return element;
	}
	
	public WebElement addAccountButtonExternal(WebDriver driver) throws InterruptedException{
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("btAddExtAccId")));
		WebElement element = driver.findElement(By.xpath("//*/table[@id = 'btAddExtAccId']/tbody/tr/td/em/button[text() = 'Add Account']"));
		return element;
	}
	
	public WebElement addAccountButton(WebDriver driver) throws InterruptedException{
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("btAddId")));
		WebElement element = driver.findElement(By.xpath("//*/table[@id = 'btAddId']/tbody/tr/td/em/button[text() = 'Add Account']"));
		return element;
	}
	
	public WebElement addAccountButtonSPS(WebDriver driver) throws InterruptedException{
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("btAddInternalAgentId")));
		WebElement element = driver.findElement(By.xpath("//*/table[@id = 'btAddInternalAgentId']/tbody/tr/td/em/button[text() = 'Add Account']"));
		return element;
	}
	
	public WebElement acctTitleExternal(WebDriver driver){
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("idAddScAccountTitleTextField")));
		WebElement element = driver.findElement(By.id("idAddScAccountTitleTextField"));
		return element;
	}
	
	public WebElement acctNumberExternal(WebDriver driver){
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("idScAddAccountIdTextField")));
		WebElement element = driver.findElement(By.id("idScAddAccountIdTextField"));
		return element;
	}

	
	public WebElement entityNameExternal(WebDriver driver){
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("idScIndividualNamesField")));
		WebElement element = driver.findElement(By.id("idScIndividualNamesField"));
		return element;
	}
	
	public WebElement inputAcctTitleExternal(WebDriver driver){
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("idAddAccountTitleTextField")));
		WebElement element = driver.findElement(By.id("idAddAccountTitleTextField"));
		return element;
	}
	
	public WebElement inputAcctNumExternal(WebDriver driver){
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("idAddAccountIdTextField")));
		WebElement element = driver.findElement(By.id("idAddAccountIdTextField"));
		return element;
	}
	
	public WebElement addressExternal(WebDriver driver){
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("idScAddressField")));
		WebElement element = driver.findElement(By.id("idScAddressField"));
		return element;		
	}
	
	public WebElement ssn_TinExternal(WebDriver driver){
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("idScTaxIdField")));
		WebElement element = driver.findElement(By.id("idScTaxIdField"));
		return element;	
	}
	
	public WebElement dateOfBirthExternal(WebDriver driver){
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("idScDobField")));
		WebElement element = driver.findElement(By.id("idScDobField"));
		return element;			
	}
	
	public WebElement countryOfResExternal(WebDriver driver){
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("idScCountryField")));
		WebElement element = driver.findElement(By.id("idScCountryField"));
		return element;			
	}
	
	public WebElement inputAcctNumInternal(WebDriver driver){
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("idAccSearchTxt")));
		WebElement element = driver.findElement(By.id("idAccSearchTxt"));
		return element;
	}
	
	public WebElement searchForInternalAcctSPS(WebDriver driver) throws InterruptedException{
		wait(driver);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[contains(text(), 'Search')]")));
		List<WebElement> elements = driver.findElements(By.xpath("//button[contains(text(), 'Search')]"));
		WebElement element = elements.get(1);
		return element;
	}
	
	public WebElement searchForInternalAcct(WebDriver driver) throws InterruptedException{
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Search')]")));
		WebElement element = driver.findElement(By.xpath("//button[contains(text(), 'Search')]"));
		return element;
	}
	public WebElement confirmWithOKInternalMargin(WebDriver driver) throws InterruptedException{
		WebElement element = null;
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("idAccSearchTxt")));
		List<WebElement> list = driver.findElements(By.xpath("//button[contains(text(), 'OK')]"));
		for(WebElement item : list){
			if(item.getText().equals("OK")){
			element = item;
			return element;
			}
		}
		return element;
	}
	
	public WebElement confirmWithOKExternal(WebDriver driver) throws InterruptedException{
		WebElement element = null;
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("idScCountryField")));
		List<WebElement> list = driver.findElements(By.xpath("//button[contains(text(), 'OK')]"));
		for(WebElement item : list){
			if(item.getText().equals("OK")){
			element = item;
			return element;
			}
		}
		return element;
	}
	
	public WebElement confirmWithOKAssetMovement(WebDriver driver) throws InterruptedException{
		//WebElement element = findExtJs.findButtons(driver, "OK");
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'OK')]")));
		WebElement element = driver.findElement(By.xpath("//button[contains(text(), 'OK')]"));
		return element;
	}
	
	public void inputTransferQty(WebDriver driver, String cusip, String assetType) throws InterruptedException{
		wait(driver);
		String rowPath = "//td//div[text()=\'" + cusip + "\']";
		wait.until(ExpectedConditions.elementToBeClickable((By.xpath(rowPath))));
		WebElement row = driver.findElement((By.xpath(rowPath)));
		
		Thread.sleep(4000);
		String transferQty = null;
		

			row.click();
			if(assetType.contains("Structured Product") == true){
				transferQty = "5000";
			}else if(assetType.contains("FRB") || assetType.contains("FRB - Fractions")){
				transferQty = "100";
			}else if (assetType.contains("Local Vault Reg 31")){
				transferQty = "3.436";
			}
			else{
				transferQty = "1";
			}
			
			actions = new Actions(driver);
			actions
			.moveByOffset(225,0)
			.click()
			.sendKeys(transferQty)
			.moveByOffset(-100, 400) // click off the QTY to transfer input
			.click()
			.perform();		
	
	}
	
	public WebElement addAssetsButton(WebDriver driver) throws InterruptedException{	
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Add Assets')]")));
		WebElement element = driver.findElement(By.xpath("//button[contains(text(), 'Add Assets')]"));
		return element;
	}
	
	public WebElement saveAndContinueButton(WebDriver driver) throws InterruptedException{
		wait(driver);
		Thread.sleep(5000);
		List<WebElement> list = driver.findElements(By.xpath("//button[contains(text(), 'Save and Continue')]"));
		WebElement element = null;
		for(WebElement item : list){
			if(item.getText().equals("Save and Continue")){
			element = item;
			return element;
			}
		}
		return element;
	}
	
	
	public void checkAcctInternalInfoIsLoaded(WebDriver driver, String receivingAcct){
		wait(driver);
		wait.until(ExpectedConditions.textToBePresentInElement(By.className("x-grid3-col-0"), receivingAcct));	
	}
	
	public WebElement deliveryInstructionsTabCheck(WebDriver driver){
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("idMainTabPanel__idFreeDeliveryDevIns")));
		WebElement element = driver.findElement(By.id("idMainTabPanel__idFreeDeliveryDevIns"));
		return element;
	}
	
	public WebElement gridCurrentAssets(WebDriver driver){
		wait(driver);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("idGridJpm")));
		WebElement element = driver.findElement(By.id("idGridJpm"));
		return element;
	}
	
	public WebElement gridAssetsToBeTransferred(WebDriver driver, String cusip){
		/*
		wait(driver);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("idSelGrid")));
		WebElement element = driver.findElement(By.id("idSelGrid"));
		*/
		WebElement element = null;
		
		wait(driver);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*/div[@id = 'idSelGrid']*/table/tbody/tr/td/div[@class = ' x-grid3-col-cusip']")));
		List<WebElement> list = driver.findElements(By.xpath("//*/div[@id = 'idSelGrid']*/table/tbody/tr/td/div[@class = ' x-grid3-col-cusip']"));
		
		for(WebElement item : list){
			if(item.getText().equals(cusip)){
				element = item;
				break;
			}
		}
		
		return element;
	}
	
	public int gridOfDeliveryAssetsGreyed(WebDriver driver) throws InterruptedException{
		//Thread.sleep(3000);
		int numOfElement = 0;
		
		if(driver.findElements(By.className("HighLight-Grid-Row")).equals(null)){
			numOfElement = 0;
		}else{
			numOfElement = driver.findElements(By.className("HighLight-Grid-Row")).size();
		}
		
		return numOfElement;
	}
	
	public List<WebElement> gridOfDeliveryAssets(WebDriver driver) throws InterruptedException{
		//Thread.sleep(3000);
		wait(driver);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("x-grid3-td-description")));
		List<WebElement> element = driver.findElements(By.className("x-grid3-td-description"));
		return element;
	}

	
	public List<WebElement> gridOfReceivingAssets(WebDriver driver) throws InterruptedException{
		//Thread.sleep(3000);
		wait(driver);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("x-grid3-col-accNo")));
		List<WebElement> element = driver.findElements(By.className("x-grid3-col-accNo"));
		return element;
	}
	
	public void checkIfPresenceOfLoadingMask(WebDriver driver){
		wait(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("x-mask-loading")));
	}
	
	public void checkIfLoadingMaskIsGone(WebDriver driver){
		wait(driver);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("x-mask-loading")));
	}
	
	public WebElement dwacCusipSearch(WebDriver driver){
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("dwacCusipSearchId")));
		WebElement element = driver.findElement(By.id("dwacCusipSearchId"));
		return element;
	}
	
	public WebElement dwacCusipSearchButton(WebDriver driver) throws InterruptedException{
		wait(driver);
		Thread.sleep(5000);
		List<WebElement> list = driver.findElements(By.xpath("//button[contains(text(), 'Search')]"));
		WebElement element = null;
		for(WebElement item : list){
			if(item.getText().equals("Search")){
			element = item;
			return element;
			}
		}
		return element;
	}
	
	public WebElement dwacQty(WebDriver driver){
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("dwacQualityResultId")));
		WebElement element = driver.findElement(By.id("dwacQualityResultId"));
		return element;
	}
	
	public WebElement dwacAddRefCtrlNum(WebDriver driver) throws InterruptedException{
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("btAddInternalAgentId")));
		WebElement element = driver.findElement(By.xpath("//*/table[@id = 'btAddInternalAgentId']/tbody/tr/td/em/button[text() = 'Add Ref/Ctrl #']"));
		return element;
	}
	
	public WebElement dwacAddRefCtrlNumExternal(WebDriver driver) throws InterruptedException{
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("btAddExtAccId")));
		WebElement element = driver.findElement(By.xpath("//*/table[@id = 'btAddExtAccId']/tbody/tr/td/em/button[text() = 'Add Ref/Ctrl #']"));
		return element;
	}
	
	public WebElement dwacAddAssets(WebDriver driver) throws InterruptedException{
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("dwacAddAsset")));
		WebElement element = driver.findElement(By.xpath("//*/table[@id = 'dwacAddAsset']/tbody/tr/td/em/button[text() = 'Add Assets']"));
		return element;
	}
	
	public WebElement dwacReferenceControlNum(WebDriver driver) throws InterruptedException{
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("idAddRefControlNumberTextField")));
		WebElement element = driver.findElement(By.id("idAddRefControlNumberTextField"));
		return element;
	}
	
	public WebElement dwacReferenceControlNumConfirm(WebDriver driver) throws InterruptedException{
		wait(driver);
		Thread.sleep(5000);
		List<WebElement> list = driver.findElements(By.xpath("//button[contains(text(), 'OK')]"));
		WebElement element = null;
		for(WebElement item : list){
			if(item.getText().equals("OK")){
			element = item;
			return element;
			}
		}
		return element;
	}
	
	public WebElement addAssetsConfirm(WebDriver driver){
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*/button[contains(text(), 'OK')]")));
		WebElement element = driver.findElement(By.xpath("//*/button[contains(text(), 'OK')]"));
		return element;
	}
	
	public WebElement confirmMoveAllAssets(WebDriver driver){
		wait(driver);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*/button[contains(text(), 'Yes')]")));
		List<WebElement> list = driver.findElements(By.xpath("//*/button[contains(text(), 'Yes')]"));
		WebElement element = list.get(0);
		return element;
	}
	
	public WebElement dwacSaveAndContinue(WebDriver driver){
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("aataBtStSaveAndCont")));
		WebElement element = driver.findElement(By.xpath("//*/table[@id = 'aataBtStSaveAndCont']/tbody/tr/td/em/button[text() = 'Save and Continue']"));
		return element;
	}
	
	public WebElement spsAssetType(WebDriver driver){
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='radio'][value='240']")));
		WebElement element = driver.findElement(By.cssSelector("[type='radio'][value='240']"));
		return element;
	}
	
	public WebElement moveAllAssets(WebDriver driver) throws InterruptedException{
		Thread.sleep(5000);
		List<WebElement> imgList = driver.findElements(By.tagName("IMG"));
		List<WebElement> arrowImg = new ArrayList<WebElement>();
		for(WebElement img : imgList){
			if(img.getAttribute("src").contains("moveRight2.png")){
				arrowImg.add(img);
			}
		}
		WebElement element = arrowImg.get(0);
		return element;
	}
	
	public void checkIfAssetUntransferable(WebDriver driver, String cusip){
		wait(driver);
		String rowPath = "//td//div[text()=\'" + cusip + "\']";
		wait.until(ExpectedConditions.elementToBeClickable((By.xpath(rowPath))));
		WebElement row = driver.findElement((By.xpath(rowPath)));
		
		WebElement td = row.findElement(By.xpath(".."));
		WebElement tr = td.findElement(By.xpath(".."));
		WebElement tbody = tr.findElement(By.xpath(".."));
		WebElement table = tbody.findElement(By.xpath(".."));
		WebElement div = table.findElement(By.xpath(".."));
		
		String divClasses = div.getAttribute("class");
		if(divClasses.contains("HighLight-Grid-Row")){
			assertFalse("The target cusip " + cusip +" is greyed out and untransferable", true);
		}	
	}
	
	public void checkIfTheRightNumberOfAssetsTransferred(WebDriver driver) throws InterruptedException{
		
		List<WebElement> gridOfDeliveryAssets = gridOfDeliveryAssets(driver);
		int gridOfDeliveryAssetsGreyed = gridOfDeliveryAssetsGreyed(driver);
		List<WebElement> gridOfReceivingAssets = gridOfReceivingAssets(driver);
		
		int numOfRowsInCurrentAssetsGrid = gridOfDeliveryAssets.size() - 1;
		numOfRowsInCurrentAssetsGrid = numOfRowsInCurrentAssetsGrid - gridOfDeliveryAssetsGreyed;
		int numOfRowsInAssetsToBeTransferredGrid = gridOfReceivingAssets.size();

		assertEquals(numOfRowsInCurrentAssetsGrid, numOfRowsInAssetsToBeTransferredGrid);		
	}
	
	public void checkIfThereIsAnTechnicalError(WebDriver driver) throws InterruptedException{
		Thread.sleep(10000);
		String errorMessagePath = "//*/td[@class = 'Message_critical']/label";
		List<WebElement> errorMessages = driver.findElements((By.xpath(errorMessagePath)));
		
		if(errorMessages.size() >= 1){
			WebElement detailedMessage = driver.findElement((By.xpath("//*/legend/div")));
			detailedMessage.click();
			errorMessages = driver.findElements((By.xpath(errorMessagePath)));
			assertFalse("Technical Error when transfering assets below is the detailed error message : " + errorMessages.get(1).getText(),true);
		}
	}
	
}