package testScripts;

import org.openqa.selenium.WebDriver;

import pageObjects.securityTransferTabs.AddressAndLetters;
import pageObjects.securityTransferTabs.DeliveryInstructions;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;

public class _5_GiftLetters {

	_1_WorkStation workStation = new _1_WorkStation();
	WebDriver driver = workStation.getDriver();
	DeliveryInstructions delInst = new DeliveryInstructions();
	AddressAndLetters addressAndLetters = new AddressAndLetters();

	@After("@SecTransRouting , @test, @CompleteTestSuite")
	public void shutdownPartial(){
		driver.quit();
	}

	@Given("^information is entered in for the gift letters$")
	public void information_is_entered_in_for_the_gift_letters_() throws Throwable {
		//This tab is unique for gift transfers, but any data can be entered into the required fields
		
		delInst.saveAndContinueButton(driver).click();
		Thread.sleep(45000);
		
		addressAndLetters.doneeFullName(driver).sendKeys("test Name");
		addressAndLetters.doneeSalutationField(driver).sendKeys("test Greeting");
		addressAndLetters.doneeAddressField(driver).sendKeys("test address");
		
		addressAndLetters.donorFullName(driver).sendKeys("test Name");
		addressAndLetters.donorSalutationField(driver).sendKeys("test greeting");
		addressAndLetters.donorAddressField(driver).sendKeys("test address");
		
		addressAndLetters.signerName(driver).sendKeys("test name");
		addressAndLetters.signerTitle(driver).sendKeys("test signer");
		addressAndLetters.signerPhone(driver).sendKeys("test phone");
		
		Thread.sleep(15000);
		addressAndLetters.saveAndContinueButton(driver).click();
		addressAndLetters.checkIfThereIsAnTechnicalError(driver);
	}
}
