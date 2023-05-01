package stepdefinitions;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobject.Header;
import pageobject.LoginPage;
import pageobject.PageBreadcrumb;
import resources.Base;

public class LogOut extends Base {

	WebDriver driver;
	LoginPage loginPage;
	Header header;

	@And("^Click on myAccount Dropdown and then Click on Logout option$")
	public void click_on_myaccount_dropdown_and_then_click_on_logout_option() {
		header = new Header(Login.driver);
		header.myAccountDropdown().click();
		header.logOutOption().click();

	}

	@Then("^User should be Logout Successfully$")
	public void user_should_be_logout_successfully() {

		PageBreadcrumb pageBreadcrumb = new PageBreadcrumb(Login.driver);
		pageBreadcrumb.logoutBreadcrumb().isDisplayed();
	}
	
	@After("@logout")
	public  void tearDown(Scenario scenario) throws IOException {
		 String testName = scenario.getName();
			if (scenario.isFailed()) {
		TakesScreenshot ts = (TakesScreenshot)driver;
		byte[] src = ts.getScreenshotAs(OutputType.BYTES);
		scenario.attach(src, "image/png", testName);
		}
    Login.driver.close();
	//log.debug("Browser got closed");
		

	}
}