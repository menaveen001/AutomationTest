package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features ="src/test/java/features",
		glue ="stepdefinitions",
		plugin = {
				"html:target/cucumber-html-report.html","pretty"
				
		}
		
		
		)
public class Runner extends AbstractTestNGCucumberTests {

	
	
}
