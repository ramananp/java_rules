package pageObjects.securityTransferTabs;

import static org.junit.Assert.assertFalse;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AddressAndLetters {
	
	private WebDriverWait wait = null;
	
	public void wait(WebDriver driver){
		this.wait = new WebDriverWait(driver, 120);
	}
	
	public WebElement addAddressToDonorButton(WebDriver driver){
		wait(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("idAddAddressToDonorLetterBtn")));
		WebElement element = driver.findElement(By.id("idAddAddressToDonorLetterBtn"));
		return element;
	}
	
	public WebElement donorFullName(WebDriver driver){
		wait(driver);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("idDonorName")));
		WebElement element = driver.findElement(By.id("idDonorName"));
		return element;
	}
	
	public WebElement donorSalutationField(WebDriver driver){
		wait(driver);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("idDonorSalutation")));
		WebElement element = driver.findElement(By.id("idDonorSalutation"));
		return element;
	}
	
	public WebElement donorAddressField(WebDriver driver){
		wait(driver);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("idDonorAddress1")));
		WebElement element = driver.findElement(By.id("idDonorAddress1"));
		return element;
	}
	
	public WebElement doneeFullName(WebDriver driver){
		wait(driver);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("idDoneeName")));
		WebElement element = driver.findElement(By.id("idDoneeName"));
		return element;
	}
	
	public WebElement doneeSalutationField(WebDriver driver){
		wait(driver);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("idDoneeSalutation")));
		WebElement element = driver.findElement(By.id("idDoneeSalutation"));
		return element;
	}
	
	public WebElement doneeAddressField(WebDriver driver){
		wait(driver);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("idDoneeAddress1")));
		WebElement element = driver.findElement(By.id("idDoneeAddress1"));
		return element;
	}
	
	public WebElement signerName(WebDriver driver){
		wait(driver);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("idSignerName")));
		WebElement element = driver.findElement(By.id("idSignerName"));
		return element;
	}
	
	public WebElement signerTitle(WebDriver driver){
		wait(driver);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("idSignerTitle")));
		WebElement element = driver.findElement(By.id("idSignerTitle"));
		return element;
	}
	
	public WebElement signerPhone(WebDriver driver){
		wait(driver);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("idSignerPhone")));
		WebElement element = driver.findElement(By.id("idSignerPhone"));
		return element;
	}
	
	public WebElement saveAndContinueButton(WebDriver driver) throws InterruptedException{
		List<WebElement> buttons = driver.findElements(By.tagName("button"));
		WebElement element = null;
		Thread.sleep(5000);
		for(int i = 0; i < buttons.size(); i++){
			if(buttons.get(i).getText().equals("Save and Continue")){
				wait(driver);
				String id = buttons.get(i).getAttribute("id");
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
				element = driver.findElement(By.id(id));
			}
		}
		return element;
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