package pageObjects.otherPageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreditTeamApp {
private WebDriverWait wait = null;
	
	public void wait(WebDriver driver){
		this.wait = new WebDriverWait(driver, 120);
	}
	
	public WebElement claimButton(WebDriver driver){
		
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*/span[text() = 'Claim']")));
		WebElement element = driver.findElement(By.xpath("//*/span[text() = 'Claim']"));
		return element;
	}
	
	public WebElement approveButtonMain(WebDriver driver){
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*/span[text() = 'Approve']")));
		WebElement element = driver.findElement(By.xpath("//*/span[text() = 'Approve']"));
		return element;
	}

	public WebElement reasonSelect(WebDriver driver){
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.name("reasonCode")));
		WebElement element = driver.findElement(By.name("reasonCode"));
		return element;
	}
	
	public WebElement approveButtonReasonCode(WebDriver driver){
		wait(driver);
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*/span[text() = 'Approve']")));
		//WebElement element = driver.findElement(By.xpath("//*/span[text() = 'Approve']"));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*/span[text() = 'Approve']")));
		List<WebElement> list = driver.findElements(By.xpath("//*/span[text() = 'Approve']"));
		WebElement element = list.get(1);
		return element;
	}
	
	public WebElement closeComfirmation(WebDriver driver){
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*/span[text() = 'Close']")));
		WebElement element = driver.findElement(By.xpath("//*/span[text() = 'Close']"));
		return element;
	}
}
