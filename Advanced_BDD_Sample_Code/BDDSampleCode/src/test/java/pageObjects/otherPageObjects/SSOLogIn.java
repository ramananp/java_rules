package pageObjects.otherPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SSOLogIn {
	
	private WebDriverWait wait = null;
	
	public void wait(WebDriver driver){
		this.wait = new WebDriverWait(driver, 120);
	}
	
	public WebElement userName(WebDriver driver){
		wait(driver);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("txtUserDefault")));
		WebElement element = driver.findElement(By.id("txtUserDefault"));
		return element;
	}
	
	public WebElement userPass(WebDriver driver){
		wait(driver);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("txtPassDefault")));
		WebElement element = driver.findElement(By.id("txtPassDefault"));
		return element;
	}
	
	public void LogInButton(WebDriver driver){
		wait(driver);
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.id("//input[@value='Login']")));
		driver.findElement(By.xpath("//input[@value='Login']")).click();
	}
}