package testRunners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(format = {"pretty",
							"html:target/TransferTypeCucumber-html-reports",
							"json:target/TransferTypeCucumber.json"},
				  glue = "testScripts",
				  tags = {"@CompleteTestSuite"},
				  features = {"src/test/resources/top70UseCases/"},
				  monochrome = true)

public class completeTestSuite {

}
