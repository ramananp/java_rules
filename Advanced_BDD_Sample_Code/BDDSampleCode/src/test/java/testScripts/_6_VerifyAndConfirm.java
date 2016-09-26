package testScripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pageObjects.otherPageObjects.CommentsAndAttachments;
import pageObjects.securityTransferTabs.DeliveryInstructions;
import pageObjects.securityTransferTabs.VerifyAndApprove;
import cucumber.api.java.After;
import cucumber.api.java.en.When;

public class _6_VerifyAndConfirm {

	_1_WorkStation workStation = new _1_WorkStation();
	WebDriver driver = workStation.getDriver();
	_3_SecurityTransfer securityTransfer = new _3_SecurityTransfer();
	DeliveryInstructions delInst = new DeliveryInstructions();
	VerifyAndApprove approve = new VerifyAndApprove();
	CommentsAndAttachments commentsAndAttach = new CommentsAndAttachments();
	public static String approverCatagory;

	@After("@SecTransRouting , @test, @CompleteTestSuite")
	public void shutdownPartial(){
		driver.quit();
	}

	public String getApproverCatagory() {
		return approverCatagory;
	}

	public void setApproverCatagory(String approverCatagory) {
		this.approverCatagory = approverCatagory;
	}

	@When("^the user could review the content of the ticket and submits it$")
	public void the_user_could_review_the_content_of_the_ticket_and_submits_it() throws Throwable {
		/*
		 * once all of the delivery instructions, including any specific mandatory fields are entered
		 * the save and continue button should be clicked. It is here instead of step definition that directly pertains to the delivery instructions because
		 * the specific mandatory fields for each asset and ticket type vary significantly, so it could not be put at the end of any given delivery instruction step definition
		 */

		Thread.sleep(30000);
		delInst.saveAndContinueButton(driver).click();
		approve.checkIfThereIsAnTechnicalError(driver);
		System.out.println(">>> Verify and Confirm");
		//This is the least number of steps to submit the ticket
		Thread.sleep(60000);

		approve.CallbackNARadioButton(driver).click();
		approve.CallbackNARadioButton(driver).click();
		
		approve.CallbackNARadioGroup(driver).click();
		approve.sigVerifyRadioButton(driver).click();
		
		approve.saveAndSubmitButton(driver).click();
		/*
		if(securityTransfer.getAssetTypeName().equals("3rd Party Funds")){
			approve.confirmWithOK(driver).click();
		}else{
		*/
		approve.confirmWithYes(driver).click();
		//}
		
		approverCatagory = approve.selectApprover(driver);
		commentsAndAttach.addCommentAndAttachment(driver);
		
		approve.saveAndSubmitButton(driver).click();//This will submit the ticket permanently
		Thread.sleep(15000);
		//approve.checkIfDocumentWasAttachedWhenNEeded(driver);
		System.out.println(">>> Ticket is Submitted");

		//the application is closed as the initiator
		driver.close();
		System.out.println("Shutdown Browser As Initiator");

	}
	
	@When("^the user could review the content of the ticket and submits it for a gift transfer$")
	public void the_user_could_review_the_content_of_the_ticket_and_submits_it_for_a_gift_transfer() throws Throwable {
		/*
		 * once all of the delivery instructions, including any specific mandatory fields are entered
		 * the save and continue button should be clicked. It is here instead of step definition that directly pertains to the delivery instructions because
		 * the specific mandatory fields for each asset and ticket type vary significantly, so it could not be put at the end of any given delivery instruction step definition
		 */

		System.out.println(">>> Verify and Confirm");
		//This is the least number of steps to submit the ticket
		Thread.sleep(40000);

		approve.CallbackNARadioButton(driver).click();
		approve.CallbackNARadioButton(driver).click();
		
		approve.CallbackNARadioGroupGift(driver).click(); // Replace with in-person gift(no callback)
		approve.sigVerifyRadioButton(driver).click();
		
		approve.saveAndSubmitButton(driver).click();
		/*
		if(securityTransfer.getAssetTypeName().equals("3rd Party Funds")){
			approve.confirmWithOK(driver).click();
		}else{
			approve.confirmWithYes(driver).click();//3rd party needs OK instead of Yes
		}
		*/
		approve.confirmWithYes(driver).click();
		approverCatagory = approve.selectApprover(driver);
		commentsAndAttach.addCommentAndAttachment(driver);
		
		approve.saveAndSubmitButton(driver).click();//This will submit the ticket permanently
		
		Thread.sleep(15000);
		//approve.checkIfDocumentWasAttachedWhenNEeded(driver);
		System.out.println(">>> Ticket is Submitted");

		//the application is closed as the initiator
		driver.close();
		System.out.println("Shutdown Browser As Initiator");

	}
	
}
