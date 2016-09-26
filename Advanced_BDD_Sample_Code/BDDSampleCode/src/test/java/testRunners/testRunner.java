package testRunners;

import org.junit.runner.RunWith;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(format = {"pretty",
							"html:target/Test-cucumber-html-reports",
							"json:target/Testcucumber.json"},
				  glue = "testScripts",
				  tags = {"@test"},
				  features = {"src/test/resources/"},
				  monochrome = true)

public class testRunner {
	
}