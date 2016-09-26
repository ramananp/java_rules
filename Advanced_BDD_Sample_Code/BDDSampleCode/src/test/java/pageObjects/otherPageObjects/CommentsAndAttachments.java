package pageObjects.otherPageObjects;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.securityTransferTabs.GenReqInfo;


public class CommentsAndAttachments{
	
	GenReqInfo reqInfo = new GenReqInfo();
	private WebDriverWait wait = null;
	Actions actions = null;
	
	public void wait(WebDriver driver){
		this.wait = new WebDriverWait(driver, 120);
	}
	
	public void gridExpander(WebDriver driver) throws InterruptedException{
		wait(driver);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*/div[@id = 'idComment']/div/div[@class = 'x-tool x-tool-toggle']")));
		WebElement addComments = driver.findElement(By.xpath("//*/div[@id = 'idComment']/div/div[@class = 'x-tool x-tool-toggle']"));
		addComments.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*/div[@id = 'attachPanel']/div/div[@class = 'x-tool x-tool-toggle']")));
		WebElement addAttachments = driver.findElement(By.xpath("//*/div[@id = 'attachPanel']/div/div[@class = 'x-tool x-tool-toggle']"));
		addAttachments.click();
	}
	
	public WebElement addComment(WebDriver driver) throws InterruptedException{
		wait(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("commentName")));
		WebElement element = driver.findElement(By.name("commentName"));
		return element;
	}
	
	public WebElement addCommentButton(WebDriver driver) throws InterruptedException{
		wait(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*/table[@id = 'idCommentAdd']/tbody/tr/td/em/button[@class = ' x-btn-text']")));
		WebElement element = driver.findElement(By.xpath("//*/table[@id = 'idCommentAdd']/tbody/tr/td/em/button[@class = ' x-btn-text']"));
		return element;
	}
	
	public WebElement uploadAttachment(WebDriver driver) throws InterruptedException{
		wait(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("attachHidden-file")));
		WebElement element = driver.findElement(By.id("attachHidden-file"));
		return element;
	}
	
	public WebElement attachAttachmentButton(WebDriver driver) throws InterruptedException{
		wait(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*/table[@id = 'attachBtn']/tbody/tr/td/em/button[@class = ' x-btn-text']")));
		WebElement element = driver.findElement(By.xpath("//*/table[@id = 'attachBtn']/tbody/tr/td/em/button[@class = ' x-btn-text']"));
		return element;
	}
	
	public void addCommentAndAttachment(WebDriver driver) throws InterruptedException{
		gridExpander(driver);
		addComment(driver).sendKeys("It is a comment");
		addCommentButton(driver).click();
		Thread.sleep(5000);
		uploadAttachment(driver).sendKeys("C:\\FAST\\IEDriverServer\\test doc.docx");
		attachAttachmentButton(driver).click();
	}
	
}