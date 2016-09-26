package driver;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class RunIE {

	WebDriver driver = null;
	
	public WebDriver getDriver(String startingURL){
		System.out.println("OpenBrowser Called");
		String driverLocation = "C://FAST//IEDriverServer//IEDriverServer.exe";
		System.out.println("Driver Location: "+driverLocation);
		File file = new File(driverLocation);
		System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
			
		DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		capabilities.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, startingURL);
		capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
		WebDriver driver = new InternetExplorerDriver(capabilities);
		driver.navigate().to(startingURL);
		return driver;	
	}
	
	public WebDriver getWorkstation(){
		driver = getDriver("http://OfYourURL");
		return driver;
	}
	
	public WebDriver getWorkstationCreditApproval(){
		driver = getDriver("http://OfYourURL");
		return driver;
	}
	
	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	
	
	
	
}