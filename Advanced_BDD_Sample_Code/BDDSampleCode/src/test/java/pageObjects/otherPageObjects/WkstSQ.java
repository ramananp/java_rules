package pageObjects.otherPageObjects;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driver.RunIE;
import excelUpdatesFeatureFile.backgroundSection.abstractProperties.ReadLogInfo;
import testScripts._1_WorkStation;
import testScripts._7_ParentTicketApproval;


public class WkstSQ {
	
	private WebDriverWait wait = null;
	SSOLogIn logIn = new SSOLogIn();
	ReadLogInfo readLogInfo = new ReadLogInfo();
	RunIE runIE = new RunIE();
	public void wait(WebDriver driver){
		this.wait = new WebDriverWait(driver, 120);
	}

	public void serviceTab(WebDriver driver){
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("L1_A_7")));
		driver.findElement(By.id("L1_A_7")).click();
	}
	
	public void serviceQueue(WebDriver driver){
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("selected")));
		driver.findElement(By.id("selected")).click();
	}
	
	
	public void serviceQueueAfterFilteringTicket(WebDriver driver){
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("1")));
		driver.findElement(By.id("1")).click();
	}
	
	public WebElement initiateReqTab(WebDriver driver) throws InterruptedException{
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("3")));
		WebElement element =  driver.findElement(By.id("3"));
		return element;
	}
	
	public void openTicketsTab(WebDriver driver){
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Open Tickets']")));
		driver.findElement(By.xpath("//*[text()='Open Tickets']")).click();
	}
	
	public WebElement searchCriteria(WebDriver driver){
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("OpenTkt_Quickfiltercombo_Advance")));
		WebElement element =  driver.findElement(By.id("OpenTkt_Quickfiltercombo_Advance"));
		return element;
	}
	
	
	public WebElement ticketNumSearchFilterButton(WebDriver driver){
		wait(driver);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("OpenTkt_FilterBtn_Advance")));
		WebElement element =  driver.findElement(By.xpath("//*/a[@id = 'OpenTkt_FilterBtn_Advance']/span"));
		return element;
	}
	
	public WebElement filterButton(WebDriver driver){
		wait(driver);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("OpenTkt_FilterBtn_Advance")));
		WebElement element =  driver.findElement(By.xpath("//*/a[@id = 'OpenTkt_FilterBtn_Advance']/span"));
		return element;
	}
	
	public WebElement ticketSearchField(WebDriver driver){
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("OpenTkt_quickfilterText_Advance")));
		WebElement element =  driver.findElement(By.id("OpenTkt_quickfilterText_Advance"));
		return element;
	}

	public WebElement openTicketInServiceQueue(WebDriver driver, String ticketNum) throws InterruptedException{
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='" + ticketNum + "']")));
		WebElement element = driver.findElement(By.xpath("//*[text()='" + ticketNum + "']"));
		return element;
	}
	
	
	public WebElement openTicketInServiceQueueOpenTicket(WebDriver driver, String ticketNum){
		
		wait(driver);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("x-grid3-col-0")));
		WebElement element = driver.findElement(By.className("x-grid3-col-0"));
		return element;
		
	}
	
	public void checkIfTicketIsTheCorrectStage(WebDriver driver, String ticketNum, String targetStage) throws Throwable{
		
		_1_WorkStation workStation = new _1_WorkStation();
		_7_ParentTicketApproval parentTicketApproval = new _7_ParentTicketApproval();
		//boolean creditTeamAttemptedTpProcessedOnce = workStation.isCreditTeamAttemptedTpProcessedOnce();
		boolean creditTeamAttemptedTpProcessedOnce = false;
		
		WebElement ticketNumber = openTicketInServiceQueue(driver, ticketNum);
		WebElement onelevelup = ticketNumber.findElement(By.xpath(".."));
		WebElement finalLevelUp = onelevelup.findElement(By.xpath(".."));
		
		String nodupValue = finalLevelUp.getAttribute("_nodup");
		List<WebElement> ticketStageStatus = driver.findElements(By.className("x-grid3-td-7"));
		for(WebElement stage : ticketStageStatus){
			if(stage.getAttribute("_nodup").equals(nodupValue)){
				assertEquals("Ticket was not in the correct stage for the test to handle it ",targetStage, stage.getText());
				/*
				if(stage.getText().equals("Credit Team Approval") && creditTeamAttemptedTpProcessedOnce == false){
					driver.close();
					System.out.println("Shutdown Browser As Initiator");
					
					parentTicketApproval.Two_members_of_the_credit_team_approve_the_parent_ticket();
				
					driver = runIE.getWorkstation();
					driver.manage().window().maximize();
					logIn.userName(driver).sendKeys(readLogInfo.getSIDClientService());
					logIn.userPass(driver).sendKeys(readLogInfo.getPasswordClientService());
					logIn.LogInButton(driver);
					System.out.println(">>> Initiator Logs Into WorkStation");
					
					serviceTab(driver);
					serviceQueue(driver);
					openTicketsTab(driver);
					Actions action = new Actions(driver);
					action
						.doubleClick(searchCriteria(driver))
						.sendKeys("Ticket #")
						.perform();
					ticketSearchField(driver).sendKeys(ticketNum);
					action
						.moveByOffset(0, 10)
						.click()
						.perform();
					Thread.sleep(5000);
					ticketNumSearchFilterButton(driver).click();
					workStation.setCreditTeamAttemptedTpProcessedOnce(true);
					checkIfTicketIsTheCorrectStageOpenTicket(driver, ticketNum, "Pending Complete");						
				}else{
					assertEquals("Ticket was not in the correct stage for the test to handle it ",targetStage, stage.getText());
				}
				*/
			}
		}
	}
	
	public void checkIfTicketIsTheCorrectStageOpenTicket(WebDriver driver, String ticketNum, String targetStage) throws Throwable{
		
		_1_WorkStation workStation = new _1_WorkStation();
		//boolean creditTeamAttemptedTpProcessedOnce = workStation.isCreditTeamAttemptedTpProcessedOnce();
		boolean creditTeamAttemptedTpProcessedOnce = false;
		
		wait(driver);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("x-grid3-col-7")));
		WebElement ticketStageStatus = driver.findElement(By.className("x-grid3-col-7"));
		System.out.println(">>> " + ticketStageStatus.getText());

				if(ticketStageStatus.getText().equals("Credit Team Approval") && creditTeamAttemptedTpProcessedOnce == false){
					
					driver.close();
					System.out.println("Shutdown Browser As Initiator");
					
					_7_ParentTicketApproval parentTicketApproval = new _7_ParentTicketApproval();
					parentTicketApproval.Two_members_of_the_credit_team_approve_the_parent_ticket();
				
					driver = runIE.getWorkstation();
					driver.manage().window().maximize();
					logIn.userName(driver).sendKeys(readLogInfo.getSIDClientService());
					logIn.userPass(driver).sendKeys(readLogInfo.getPasswordClientService());
					logIn.LogInButton(driver);
					System.out.println(">>> Initiator Logs Into WorkStation");
					
					serviceTab(driver);
					serviceQueue(driver);
					openTicketsTab(driver);
					Actions action = new Actions(driver);
					action
						.doubleClick(searchCriteria(driver))
						.sendKeys("Ticket #")
						.perform();
					ticketSearchField(driver).sendKeys(ticketNum);
					action
						.moveByOffset(0, 10)
						.click()
						.perform();
					Thread.sleep(5000);
					ticketNumSearchFilterButton(driver).click();
					workStation.setCreditTeamAttemptedTpProcessedOnce(true);
					checkIfTicketIsTheCorrectStageOpenTicket(driver, ticketNum, "Pending Complete");	
				}else{
					assertEquals("Ticket was not in the correct stage for the test to handle it ",targetStage, ticketStageStatus.getText());
				}			
	}

	public WebElement childTicket(WebDriver driver, String childTicket){
		wait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[data-qtip=\" + childTicket + \"]")));
		WebElement element = driver.findElement(By.cssSelector("div[data-qtip=\" + childTicket + \"]"));
		return element;
	}
}