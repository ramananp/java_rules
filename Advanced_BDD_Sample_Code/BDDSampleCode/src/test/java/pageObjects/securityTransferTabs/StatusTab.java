package pageObjects.securityTransferTabs;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StatusTab {
	
	Actions actions = null;
	private WebDriverWait wait = null;
	
	public void wait(WebDriver driver){
		this.wait = new WebDriverWait(driver, 120);
	}
	
	public WebElement statusTabCheck(WebDriver driver){
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("idMainTabPanel__idFormstatus")));
		WebElement element = driver.findElement(By.id("idMainTabPanel__idFormstatus"));
		return element;
	}
	public WebElement clickStatusTab(WebDriver driver) throws InterruptedException{
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()=\'Status']")));
		WebElement element = driver.findElement(By.xpath("//span[text()=\'Status']"));
		return element;
	}

	public WebElement searchTeamType(WebDriver driver) throws InterruptedException{	
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.className("x-grid-group-title")));
		WebElement element = driver.findElement(By.className("x-grid-group-title"));
		
		return element;
	}
	
	public WebElement searchTeamTypeWithMultipleChildTickets(WebDriver driver, String processTeamName) throws InterruptedException{	
		wait(driver);
		//wait.until(ExpectedConditions.elementToBeClickable(By.className("x-grid-group-title")));
		List<WebElement> list = driver.findElements(By.className("x-grid-group-title"));
		assertNotNull("There are not child tickets found in the Status tab", list);
		List<String> webElementContents = new ArrayList();
		WebElement element = null;
		for(WebElement item : list){
			if(item.getText().contains(processTeamName)){
				element = item;
				break;
			}else{
				element = null;
			}
		}
		if(element == null){
			System.out.println("Processing Team Was Not Found");
			String teamsFound = "";
			for(WebElement item : list){
				String fullTeamInfo = item.getText();
				int whereTypeIs = fullTeamInfo.lastIndexOf("Type:");
				String justTeamName = fullTeamInfo.substring(whereTypeIs, (fullTeamInfo.length() - 1));
				teamsFound = teamsFound + " " + justTeamName;
			}
			assertFalse("Processing team was not found, this was what was found: " + teamsFound,false);
		}
		return element;
	}
}