package pageObjects.securityTransferTabs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class DeliveryInstructions{

	private WebDriverWait wait = null;
	Actions actions = null;
	
	public void wait(WebDriver driver){
		this.wait = new WebDriverWait(driver, 120);
	}
	public WebElement verifyAndConfirmTabCheck(WebDriver driver){
		wait(driver);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("idMainTabPanel__idFormverifyapprove")));
		WebElement element = driver.findElement(By.id("idMainTabPanel__idFormverifyapprove"));
		return element;
	}
	
	public WebElement saveAndContinueButton(WebDriver driver) throws InterruptedException{
		wait(driver);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("aataBtSiSaveAndCont")));
		WebElement element = null;
		while(element == null){
			List<WebElement> list = driver.findElements(By.xpath("//button[contains(text(), 'Save and Continue')]"));
			for(WebElement item : list){
				if(item.getText().contains("Save and Continue")){
					element = item;
				return element;
				}
			}
		}
		return element;
	}
	
	public WebElement brokerSearchButton(WebDriver driver) throws InterruptedException{
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*/button[contains(text(), 'Broker Search')]")));
		WebElement element = driver.findElement(By.xpath("//*/button[contains(text(), 'Broker Search')]"));
		return element;
	}
	
	public WebElement takeFees(WebDriver driver) throws InterruptedException{
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("idRadTakeFees")));
		WebElement element = driver.findElement(By.id("idRadTakeFees"));
		return element;
	}
	
	public WebElement searchButton(WebDriver driver) throws InterruptedException{
		//Thread.sleep(2000);
		//WebElement element = findExtJs.findButtons(driver, "Search");
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*/button[text() = 'Search']")));
		WebElement element = driver.findElement(By.xpath("//*/button[text() = 'Search']"));
		return element;
	}
	
	public WebElement searchButton2(WebDriver driver) throws InterruptedException{
		wait(driver);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*/button[text() = 'Search']")));
		List<WebElement> elements = driver.findElements(By.xpath("//*/button[text() = 'Search']"));
		WebElement element = elements.get(1);
		return element;
	}
	
	public WebElement dwacSearchButton(WebDriver driver) throws InterruptedException{
		Thread.sleep(5000);
		WebElement element = null;
		while(element == null){
			List<WebElement> list = driver.findElements(By.xpath("//*/button[contains(text(), 'Search')]"));
			for(WebElement item : list){
				if(item.getText().equals("Search")){
					element = item;
				return element;
				}
			}
		}
		return element;
	}
	
	public WebElement dwacOKCannotFindTransferAgent(WebDriver driver) throws InterruptedException{
		Thread.sleep(5000);
		WebElement element = null;
		while(element == null){
			List<WebElement> list = driver.findElements(By.xpath("//button[contains(text(), 'OK')]"));
			element = list.get(1);
		}
		return element;
	}

	public WebElement okButton(WebDriver driver) throws InterruptedException{
		List<WebElement> buttons = driver.findElements(By.tagName("button"));
		WebElement element = null;
		Thread.sleep(5000);
		for(int i = 0; i < buttons.size(); i++){
			if(buttons.get(i).getText().equals("OK")){
				wait(driver);
				String id = buttons.get(i).getAttribute("id");
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
				element = driver.findElement(By.id(id));
			}
		}
		return element;
	}
	
	public WebElement searchBrokerNameTextField(WebDriver driver){
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("idBrokerNameTextField")));
		WebElement element = driver.findElement(By.id("idBrokerNameTextField"));
		return element;
	}
	
	public WebElement trailerDesc(WebDriver driver){
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("idCreditTrailer1")));
		WebElement element = driver.findElement(By.id("idCreditTrailer1"));
		return element;
	}
	
	public WebElement structuredProductInstructions(WebDriver driver) throws InterruptedException{
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[id*='_70']")));
		WebElement element = driver.findElement(By.cssSelector("input[id*='_70']"));
		return element;	
	}
	
	public WebElement isinSedol(WebDriver driver){
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[id*='_25']")));
		WebElement element = driver.findElement(By.cssSelector("input[id*='_25']"));
		return element;
	}
	
	public WebElement clearingBrokerBIC(WebDriver driver){
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[id*='_68']")));
		WebElement element = driver.findElement(By.cssSelector("input[id*='_68']"));
		return element;
	}
	
	public WebElement tradingBrokerSubAccountInfo(WebDriver driver){
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[id*='_49']")));
		WebElement element = driver.findElement(By.cssSelector("input[id*='_49']"));
		return element;
	}
	
	public WebElement tradingBrokerBIC(WebDriver driver){
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[id*='_31']")));
		WebElement element = driver.findElement(By.cssSelector("input[id*='_31']"));
		return element;
	}
	
	public WebElement securityCurrency(WebDriver driver){
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[id*='_26']")));
		WebElement element = driver.findElement(By.cssSelector("input[id*='_26']"));
		return element;
	}
	
	public WebElement agentSearchButton(WebDriver driver){
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("table[id*='btAgent']")));
		WebElement closeToButton = driver.findElement(By.cssSelector("table[id*='btAgent']"));
		String id = closeToButton.getAttribute("id");

		wait.until(ExpectedConditions.elementToBeClickable(By.id(id)));
		WebElement element = driver.findElement(By.xpath("//*/table[@id = '" + id +"']/tbody/tr/td/em/button[text() = 'Agent Search']"));
		return element;
	}
	
	public WebElement transferAgentNameAutoInput(WebDriver driver){
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("idAgentNameTextField")));
		WebElement element = driver.findElement(By.id("idAgentNameTextField"));
		return element;	
	}
	
	public WebElement dtcTransferAgentNameManual(WebDriver driver){
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[id*='_113']")));
		WebElement element = driver.findElement(By.cssSelector("input[id*='_113']"));
		return element;
	}
	
	public WebElement pennyStockDepositNo(WebDriver driver) throws InterruptedException{
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='radio'][value='No']")));
		WebElement element = driver.findElement(By.cssSelector("[type='radio'][value='No']"));
		return element;
	}
	
	public WebElement nbenOrYNben(WebDriver driver) throws InterruptedException{
		//WebElement element = findExtJs.findRadioInputs(driver, "NBEN");
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='radio'][value='NBEN']")));
		WebElement element = driver.findElement(By.cssSelector("[type='radio'][value='NBEN']"));
		return element;
	}
	
	public void clearingBrokerCode(WebDriver driver) throws InterruptedException{
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[id*='_77']")));
		WebElement element = driver.findElement(By.cssSelector("input[id*='_77']"));
		element.click();
		Thread.sleep(2000);
		Keyboard keyboard = ((HasInputDevices) driver).getKeyboard();
		keyboard.sendKeys(Keys.chord(Keys.ENTER));
	}
	
	public WebElement clearingBrokerIdCode(WebDriver driver) throws InterruptedException{
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[id*='_47']")));
		WebElement element = driver.findElement(By.cssSelector("input[id*='_47']"));
		return element;
	}
	
	public WebElement contactName(WebDriver driver){
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[id*='_39']")));
		WebElement element = driver.findElement(By.cssSelector("input[id*='_39']"));
		return element;
	}
	
	public WebElement tradingBrokerName(WebDriver driver){
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[id*='_30']")));
		WebElement element = driver.findElement(By.cssSelector("input[id*='_30']"));
		return element;
	}
	
	public WebElement clearingBrokerName(WebDriver driver){
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[id*='_32']")));
		WebElement element = driver.findElement(By.cssSelector("input[id*='_32']"));
		return element;
	}
	
	public WebElement contactPhoneNumber(WebDriver driver){
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[id*='_40']")));
		WebElement element = driver.findElement(By.cssSelector("input[id*='_40']"));
		return element;
	}
	
	public WebElement physicalMailingAddress(WebDriver driver){
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[id*='_43']")));
		WebElement element = driver.findElement(By.cssSelector("input[id*='_43']"));
		return element;
	}
	
	public WebElement nameOfIndividual(WebDriver driver){
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[id*='_72']")));
		WebElement element = driver.findElement(By.cssSelector("input[id*='_72']"));
		return element;
	}
	
	public WebElement beneficiaryInfoSSN(WebDriver driver){
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[id*='_73']")));
		WebElement element = driver.findElement(By.cssSelector("input[id*='_73']"));
		return element;
	}
	
	public WebElement sharesRegisteredName(WebDriver driver){
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[id*='_74']")));
		WebElement element = driver.findElement(By.cssSelector("input[id*='_74']"));
		return element;
	}
	
	public WebElement sharesRegisteredAddress(WebDriver driver){
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[id*='_75']")));
		WebElement element = driver.findElement(By.cssSelector("input[id*='_75']"));
		return element;
	}
	
	public WebElement streetAddress(WebDriver driver){
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[id*='_87']")));
		WebElement element = driver.findElement(By.cssSelector("input[id*='_87']"));
		return element;
	}
	
	public WebElement cityStateZip(WebDriver driver){
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[id*='_88']")));
		WebElement element = driver.findElement(By.cssSelector("input[id*='_88']"));
		return element;
	}
	
	public WebElement receivingFirmNameOrClientName(WebDriver driver){
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[id*='_98']")));
		WebElement element = driver.findElement(By.cssSelector("input[id*='_98']"));
		return element;
	}
	
	public WebElement mutualFundAccountNumber(WebDriver driver){
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[id*='_44']")));
		WebElement element = driver.findElement(By.cssSelector("input[id*='_44']"));
		return element;
	}
	
	public WebElement signatureOfVaultCustodian(WebDriver driver){
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[id*='_13']")));
		WebElement element = driver.findElement(By.cssSelector("input[id*='_13']"));
		return element;
	}
	
	public WebElement date(WebDriver driver){
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[id*='_14']")));
		WebElement element = driver.findElement(By.cssSelector("input[id*='_14']"));
		return element;
	}
	
	public WebElement fundsettleAccountNumber(WebDriver driver){
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[id*='_45']")));
		WebElement element = driver.findElement(By.cssSelector("input[id*='_45']"));
		return element;
	}
	
	public WebElement clearingBrokerIdEuroclear(WebDriver driver) throws InterruptedException{
		//WebElement element = findExtJs.findRadioInputs(driver, "CEDE");
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='radio'][value='CEDE']")));
		WebElement element = driver.findElement(By.cssSelector("[type='radio'][value='CEDE']"));
		return element;
	}
	
	public void dividendOptionReinvestOrCash(WebDriver driver){
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[id*='_15']")));
		WebElement element = driver.findElement(By.cssSelector("input[id*='_15']"));
		element.click();
		Keyboard keyboard = ((HasInputDevices) driver).getKeyboard();
		keyboard.sendKeys(Keys.chord(Keys.ENTER));
	}
	
	public void taxCode(WebDriver driver) throws InterruptedException{
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("idMasterTaxCode")));
		WebElement element = driver.findElement(By.id("idMasterTaxCode"));
		while(element.getAttribute("value").contains("Select...")){
			element.click();
			actions = new Actions(driver);
			actions
			.moveByOffset(150, 0)
			.click()
			.moveByOffset(-50, 15)
			.click()
			.perform();
		}

	}
	
	public void checkIfPresenceOfLoadingMask(WebDriver driver){
		wait(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("x-mask-loading")));
	}
	
	public void checkIfLoadingMaskIsGone(WebDriver driver){
		wait(driver);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("x-mask-loading")));
	}
	
}