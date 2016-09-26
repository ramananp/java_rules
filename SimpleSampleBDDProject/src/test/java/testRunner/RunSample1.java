package testRunner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(format = {"pretty",
							"html:target/sample1-html-reports",
							"json:target/sample1.json"},
				  glue = "testScripts",
				  tags = {"@Sample1"},
				  features = {"src/test/resources/"},
				  monochrome = true)

public class RunSample1 {

}
