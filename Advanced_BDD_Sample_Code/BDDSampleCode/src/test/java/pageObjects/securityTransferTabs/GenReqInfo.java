package pageObjects.securityTransferTabs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenReqInfo {
	
	private WebDriverWait wait = null;
	public static String jpmcMargin = null;
	
	public void wait(WebDriver driver){
		this.wait = new WebDriverWait(driver, 120);
	}
	
	public WebElement externalRadioButton(WebDriver driver) throws InterruptedException{
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='radio'][value='Non-JPMC']")));
		WebElement element = driver.findElement(By.cssSelector("[type='radio'][value='Non-JPMC']"));
		return element;
	}
	
	public WebElement internalRadioButton(WebDriver driver) throws InterruptedException{
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='radio'][value='JPMC OMNI']")));
		WebElement element = driver.findElement(By.cssSelector("[type='radio'][value='JPMC OMNI']"));
		return element;
	}
	
	public WebElement jpmcMarginRadioButton(WebDriver driver) throws InterruptedException{
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='radio'][value='JPMC Margin']")));
		WebElement element = driver.findElement(By.cssSelector("[type='radio'][value='JPMC Margin']"));
		return element;
	}
	
	public WebElement partialRadioButton(WebDriver driver) throws InterruptedException{
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='radio'][value='P']")));
		WebElement element = driver.findElement(By.cssSelector("[type='radio'][value='P']"));
		return element;
	}
	
	public WebElement dwacRadioButton(WebDriver driver) throws InterruptedException{
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='radio'][value='DWAC']")));
		WebElement element = driver.findElement(By.cssSelector("[type='radio'][value='DWAC']"));
		return element;
	}

	public WebElement spsRadioButton(WebDriver driver) throws InterruptedException{
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='radio'][value='SPS']")));
		WebElement element = driver.findElement(By.cssSelector("[type='radio'][value='SPS']"));
		return element;
	}
	
	public WebElement dwacDepositRadioButton(WebDriver driver) throws InterruptedException{
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("idDeposit")));
		WebElement element = driver.findElement(By.id("idDeposit"));
		return element;
	}
	
	public WebElement dwacReceiveRadioButton(WebDriver driver) throws InterruptedException{
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("idWithdrawl")));
		WebElement element = driver.findElement(By.id("idWithdrawl"));
		return element;
	}
	
	public WebElement full_OneRadioButton(WebDriver driver) throws InterruptedException{
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='radio'][value='F']")));
		WebElement element = driver.findElement(By.cssSelector("[type='radio'][value='F']"));
		return element;
	}
	
	public WebElement full_ManyRadioButton(WebDriver driver) throws InterruptedException{
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='radio'][value='M']")));
		WebElement element = driver.findElement(By.cssSelector("[type='radio'][value='M']"));
		return element;
	}
	
	public WebElement waiveFeesRadioButton(WebDriver driver) throws InterruptedException{
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='radio'][value='W']")));
		WebElement element = driver.findElement(By.cssSelector("[type='radio'][value='W']"));
		return element;
	}
	
	public WebElement takeFeesRadioButton(WebDriver driver) throws InterruptedException{
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='radio'][value='T']")));
		WebElement element = driver.findElement(By.cssSelector("[type='radio'][value='T']"));
		return element;
	}
	
	
	public List<WebElement> dontSendFidCash(WebDriver driver){
		List<WebElement> list = driver.findElements(By.id("idRadFiduciaryCashDont"));
		return list;
	}
	
	public WebElement giftRadioButton(WebDriver driver) throws InterruptedException{
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='radio'][value='G']")));
		WebElement element = driver.findElement(By.cssSelector("[type='radio'][value='G']"));
		return element;
	}
	
	public WebElement saveAndContinueButton(WebDriver driver){
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("idSaveNContGenReqInfo")));
		WebElement element = driver.findElement(By.id("idSaveNContGenReqInfo"));
		return element;
	}
	
	public WebElement confirmGeneralInfoButton(WebDriver driver) throws InterruptedException{
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*/button[text() = 'Yes']")));
		WebElement element = driver.findElement(By.xpath("//*/button[text() = 'Yes']"));
		return element;
	}
	
	public WebElement giftTypeElectronic(WebDriver driver){
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='radio'][value='DTC']")));
		WebElement element = driver.findElement(By.cssSelector("[type='radio'][value='DTC']"));
		return element;
	}

	public WebElement giftTypeInternal(WebDriver driver){
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='radio'][value='INT']")));
		WebElement element = driver.findElement(By.cssSelector("[type='radio'][value='INT']"));
		return element;
	}	
	
	public WebElement giftTypePendingDisposition(WebDriver driver){
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='radio'][value='PD1']")));
		WebElement element = driver.findElement(By.cssSelector("[type='radio'][value='PD1']"));
		return element;
	}
	
	public WebElement giftTypeSellViaJpmcc(WebDriver driver){
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='radio'][value='SVJ']")));
		WebElement element = driver.findElement(By.cssSelector("[type='radio'][value='SVJ']"));
		return element;
	}
	
	public WebElement giftTypePhysicalReregister(WebDriver driver){
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='radio'][value='PHR']")));
		WebElement element = driver.findElement(By.cssSelector("[type='radio'][value='PHR']"));
		return element;
	}

	public WebElement giftTypeDTCReregister(WebDriver driver){
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='radio'][value='DTR']")));
		WebElement element = driver.findElement(By.cssSelector("[type='radio'][value='DTR']"));
		return element;
	}
	
	public WebElement confirmWithOK(WebDriver driver) throws InterruptedException{
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'OK')]")));
		WebElement element = driver.findElement(By.xpath("//button[contains(text(), 'OK')]"));
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
}