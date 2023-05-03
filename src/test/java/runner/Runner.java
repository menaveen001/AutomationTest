package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/features/LogOut.feature", glue = "stepdefinitions",

		plugin = { "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"html:target/cucumber-html-report.html", "pretty" }

)
public class Runner extends AbstractTestNGCucumberTests {

}
