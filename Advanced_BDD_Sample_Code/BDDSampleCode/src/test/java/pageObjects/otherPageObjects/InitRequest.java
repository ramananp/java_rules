package pageObjects.otherPageObjects;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import excelUpdatesFeatureFile.ReadExcelTestScriptDataProperties;

public class InitRequest {
	
	private WebDriverWait wait = null;
	
	Properties prop = new Properties();
	ReadExcelTestScriptDataProperties mainProperties = new ReadExcelTestScriptDataProperties();
	
	public void wait(WebDriver driver){
		this.wait = new WebDriverWait(driver, 120);
	}
	
	public WebElement accountNumberEntry(WebDriver driver){
		wait(driver);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("accountNumber")));
		WebElement element = driver.findElement(By.id("accountNumber"));
		return element;
	}
	
	public WebElement initATicket(WebDriver driver){
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*/div[@id = 'button1_left']/a")));
		WebElement element = driver.findElement(By.xpath("//*/div[@id = 'button1_left']/a"));
		return element;
	}
	
	public void initReqButton(WebDriver driver, String script){
		wait(driver);
		if(driver instanceof JavascriptExecutor)
		{
			((JavascriptExecutor) driver).executeScript(script);
		}
	}
	
	public WebElement selectTeam(WebDriver driver, String team){
		wait(driver);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("selectedTeam")));
		WebElement element = driver.findElement(By.id("selectedTeam"));
		Select select = new Select(element);
		select.selectByValue(team);
		return element;		
	}
	
	public void selectedRequestCategory(WebDriver driver, String paramValues) { 		
		
			wait(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("selectedCategory")));
			boolean f = driver.findElement(By.id("selectedCategory")).isEnabled();
			if (f) {
				driver.findElement(By.id("selectedCategory")).sendKeys(paramValues);
			} else {
				selectedRequestCategory(driver, paramValues);
			}
	}
	
	public WebElement requestType(WebDriver driver){
		wait(driver);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("selectedRequestType")));
		WebElement element = driver.findElement(By.id("selectedRequestType"));
		return element;
	}
	
	public WebElement initASpecificTicketType(WebDriver driver){
		wait(driver);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*/div[@id = 'button1_left']/a")));
		List<WebElement> list = driver.findElements(By.xpath("//*/div[@id = 'button1_left']/a"));
		
		WebElement element = list.get(1);
		
		return element;
	}
}