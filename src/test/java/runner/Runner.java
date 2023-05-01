package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features ="src/test/java/features/LogOut.feature",
		glue ="stepdefinitions",
	//	plugin = {
			//	"html:target/cucumber-html-report.html","pretty"
				
		//}
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
	
		
		)
public class Runner extends AbstractTestNGCucumberTests {

	
	
}
