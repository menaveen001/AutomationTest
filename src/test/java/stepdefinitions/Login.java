package stepdefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobject.AccountPage;
import pageobject.LandingPage;
import pageobject.LoginPage;
import resources.Base;

public class Login extends Base {
	WebDriver driver;
	LandingPage landingPage;
	LoginPage loginPage;
	AccountPage accountPage;

	@Given("^Open any Browser$")
	public void open_any_browser() throws IOException {
		driver = initializeBrowser();

	}

	@And("^Navigate to Login page$")
	public void navigate_to_login_page() {

		driver.get(prop.getProperty("url"));
		landingPage = new LandingPage(driver);
		landingPage.myAccountDropdown().click();
		landingPage.loginOption().click();

	}

	@When("^User enters username as \"([^\"]*)\" and password as \"([^\"]*)\" into the fields$")
	public void user_enters_username_as_something_and_password_as_something_into_the_fields(String strArg1,
			String strArg2) {

		loginPage = new LoginPage(driver);
		loginPage.emailAddressField().sendKeys(strArg1);
		loginPage.passwordField().sendKeys(strArg2);

	}

	@And("^User clicks on Login button$")
	public void user_clicks_on_login_button() throws Throwable {

		loginPage.loginButton().click();
	}

	@Then("^Verify user is able to successfully login$")
	public void verify_user_is_able_to_successfully_login() {
		accountPage = new AccountPage(driver);

		Assert.assertTrue(accountPage.accounEditOption().isDisplayed());
	}

	@After
	public void closeBrowser() {
		driver.close();
	}
	
	
	
}
