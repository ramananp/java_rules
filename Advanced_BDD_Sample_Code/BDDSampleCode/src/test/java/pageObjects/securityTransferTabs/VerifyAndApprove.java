package pageObjects.securityTransferTabs;

import java.util.List;

import static org.junit.Assert.assertFalse;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VerifyAndApprove{
	
	Actions actions = null;
	private WebDriverWait wait = null;
	
	public void wait(WebDriver driver){
		this.wait = new WebDriverWait(driver, 120);
	}

	public WebElement CallbackNARadioButton(WebDriver driver) throws InterruptedException{
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("idCBNA")));
		WebElement element = driver.findElement(By.id("idCBNA"));
		return element;
	}
	
	public WebElement CallbackNARadioGroup(WebDriver driver) throws InterruptedException{
		//WebElement element = findExtJs.findRadioInGrp(driver, "callBackRequiredNA", "D");
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='radio'][value='D'][name='callBackRequiredNA']")));
		WebElement element = driver.findElement(By.cssSelector("[type='radio'][value='D'][name='callBackRequiredNA']"));
		return element;
	}
	
	public WebElement CallbackNARadioGroupGift(WebDriver driver) throws InterruptedException{
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("idYinpersonGiftCallback")));
		WebElement element = driver.findElement(By.id("idYinpersonGiftCallback"));
		return element;
	}
	
	public WebElement sigVerifyRadioButton(WebDriver driver) throws InterruptedException{
		//WebElement element = findExtJs.findRadioInGrp(driver, "signatureRadio", "N");
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='radio'][value='N'][name='signatureRadio']")));
		WebElement element = driver.findElement(By.cssSelector("[type='radio'][value='N'][name='signatureRadio']"));
		return element;
	}
	
	public WebElement saveAndSubmitButton(WebDriver driver) throws InterruptedException{
		//WebElement element = findExtJs.findButtons(driver, "Save and Submit");
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Save and Submit')]")));
		WebElement element = driver.findElement(By.xpath("//button[contains(text(), 'Save and Submit')]"));
		return element;
	}

	public String selectApprover(WebDriver driver) throws InterruptedException{
		String approverName = null;
		String approverCatagory = null;
		boolean noApprovers = false;
		
		wait(driver);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("x-combo-list-item")));
		List<WebElement> approverOptions = driver.findElements(By.className("x-combo-list-item"));
		
		for(WebElement approvers : approverOptions){
			
			if(approvers.getText().equals("AMY BOHLER")){
				approverName = "AMY BOHLER";
				approverCatagory = "PrimaryAppover";
				noApprovers = false;
				break;
			}else if(approvers.getText().equals("MATTHEW D KEFFER")){
				approverName = "MATTHEW D KEFFER";
				approverCatagory = "FirstBackupApprover";
				noApprovers = false;
				break;
			}else if(approvers.getText().equals("SUSAN P AUGUST")){
				approverName = "SUSAN P AUGUST";
				approverCatagory = "SecondBackupApprover";
				noApprovers = false;
				break;
			}
			
			else{
				noApprovers = true;
			}
		}
		if(noApprovers == true){
			assertFalse("No valid approver could be selected from the test suite",true);
		}else{
			actions = new Actions(driver);	
			actions
			.sendKeys(approverName)
			.moveByOffset(50, -50)
			.click()
			.perform();			
		}

		return approverCatagory;
	}
	
	public boolean checkIfApproverIsBlank(WebDriver driver){
		boolean approverIsBlank = false;
		
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.className("x-combo-selected")));
		WebElement element = driver.findElement(By.className("x-combo-selected"));
		
		if(element.getText().isEmpty()){
			approverIsBlank = false;
		}else{
			approverIsBlank = true;
		}
		return approverIsBlank;
	}
	public WebElement confirmWithYes(WebDriver driver) throws InterruptedException{
		WebElement element = null;
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Yes')]")));
		List<WebElement> list = driver.findElements(By.xpath("//button[contains(text(), 'Yes')]"));
		for(WebElement item : list){
			if(item.getText().equals("Yes")){
			element = item;
			return element;
			}
		}
		return element;
	}
	
	public WebElement confirmWithOK(WebDriver driver) throws InterruptedException{
		WebElement element = null;
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'OK')]")));
		List<WebElement> list = driver.findElements(By.xpath("//button[contains(text(), 'OK')]"));
		for(WebElement item : list){
			if(item.getText().equals("OK")){
			element = item;
			return element;
			}
		}
		return element;
	}
	
	public String getTicketNumber(WebDriver driver) throws InterruptedException{	//To get Ticket# from Header Table
		 String ticketNo = null;
		 List<WebElement> allFormChildElements = driver.findElements(By.xpath("//form[@id='headerForm']/*"));
		 for (WebElement eachItem : allFormChildElements) {
			 if (eachItem.getTagName().equalsIgnoreCase("table")) {
				 List<WebElement> tableRows = eachItem.findElements(By.tagName("tr"));
				 List<WebElement> tableTd = tableRows.get(0).findElements(By.tagName("td"));
				 ticketNo = tableTd.get(2).getText();
			 }
		 }
		 return ticketNo;
	} 
	 
	public WebElement approveTicket(WebDriver driver) throws InterruptedException{
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*/table[@id = 'aataBtnApprove']/tbody/tr/td/em/button[@class = ' x-btn-text']")));
		WebElement element = driver.findElement(By.xpath("//*/table[@id = 'aataBtnApprove']/tbody/tr/td/em/button[@class = ' x-btn-text']"));
		return element;
	}
	
	public WebElement rejectTicket(WebDriver driver) throws InterruptedException{
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*/table[@id = 'aataBtnReject']/tbody/tr/td/em/button[@class = ' x-btn-text']")));
		WebElement element = driver.findElement(By.xpath("//*/table[@id = 'aataBtnReject']/tbody/tr/td/em/button[@class = ' x-btn-text']"));
		return element;
	}
	
	public WebElement creditExceptionTicket(WebDriver driver){
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("idGwmCreditLbl")));
		WebElement element = driver.findElement(By.id("idGwmCreditLbl"));
		return element;
	}
	
	public boolean checkIfCusipIsInChildTicket(WebDriver driver, String cusip){
		boolean isCusipPresent = false;
		
		wait(driver);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*/table[@class = 'x-grid3-row-table']/tbody/tr/td/div/div[text() = \'" + cusip + "\']")));
		List<WebElement> list = driver.findElements(By.xpath("//*/table[@class = 'x-grid3-row-table']/tbody/tr/td/div/div[text() = \'" + cusip + "\']"));
		for(WebElement item : list){
			if(item.getText().contains(cusip)){
				isCusipPresent = true;
				break;
			}else{
				isCusipPresent = false;
			}
		}
		return isCusipPresent;
	}
	
	public void checkIfDocumentWasAttachedWhenNEeded(WebDriver driver) throws InterruptedException{
		List<WebElement> list = driver.findElements(By.className("ext-mb-text"));
		if(list.size() <= 1){
			assertFalse("Document cannot be attached. The active link to Citadel most likely changed. Please update.", true);
		}
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