package testRunner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(format = {"pretty",
							"html:target/sample2-html-reports",
							"json:target/sample2.json"},
				  glue = "testScripts",
				  tags = {"@Sample2"},
				  features = {"src/test/resources/"},
				  monochrome = true)

public class RunSample2 {

}
