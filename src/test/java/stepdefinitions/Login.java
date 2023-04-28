package stepdefinitions;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobject.AccountPage;
import pageobject.ForgottenPasswordPage;
import pageobject.LandingPage;
import pageobject.LoginPage;
import pageobject.PageBreadcrumb;
import resources.Base;

public class Login extends Base {
	static WebDriver driver;
	LandingPage landingPage;
	LoginPage loginPage;
	AccountPage accountPage;
	ForgottenPasswordPage forgotPasswordPage;
	ExtentReports extentReport;
	PageBreadcrumb pageBreadcrumb;
	Logger log;

	@Given("^Open any Browser$")
	public void open_any_browser() throws IOException {
		log = LogManager.getLogger(Login.class.getName());
		driver = initializeBrowser();
         log.debug("Browser got lunched");
	}

	@And("^Navigate to Login page$")
	public void navigate_to_login_page() {

		driver.get(prop.getProperty("url"));
		log.debug("Navigate to the application Url");
		landingPage = new LandingPage(driver);
		landingPage.myAccountDropdown().click();
		log.debug("Clicked on myAccounnt dropdown");
		landingPage.loginOption().click();
		log.debug("Clicked on login Option");

	}

	@When("^User enters username as \"([^\"]*)\" and password as \"([^\"]*)\" into the fields$")
	public void user_enters_username_as_something_and_password_as_something_into_the_fields(String strArg1,
			String strArg2) {

		loginPage = new LoginPage(driver);
		loginPage.emailAddressField().sendKeys(strArg1);
		log.debug("Email address field got entered");
		loginPage.passwordField().sendKeys(strArg2);
		log.debug("Password address field got entered");

	}

	@And("^User clicks on Login button$")
	public void user_clicks_on_login_button() throws Throwable {
		loginPage = new LoginPage(driver);
		loginPage.loginButton().click();
		log.debug("Clicked on login button");
	}

	@Then("Verify user should able to successfully login")
	public void verify_user_should_able_to_successfully_login() {
		accountPage = new AccountPage(driver);

		Assert.assertTrue(accountPage.accounEditOption().isDisplayed());
		log.info("Account edit option got displayed");

	}

	@Then("^Verify user should not able to successfully login$")
	
	public void verify_user_should_not_able_to_successfully_login() {
        pageBreadcrumb = new PageBreadcrumb(driver);
		Assert.assertTrue(pageBreadcrumb.loginBreadcrumb().isDisplayed());
		log.info("Login breadcrumb got displayed");
	}

	@And("^User should see the error message No match for E-Mail Address and or Password$")
	public void user_should_see_the_error_message_no_match_for_email_address_andor_password() {

		Assert.assertTrue(loginPage.warningMessage().isDisplayed());
		log.info("Warring message got displayed");
	}

	@When("User enters username as {string}")
	public void user_enters_username_as(String email) {
		loginPage = new LoginPage(driver);
		loginPage.emailAddressField().sendKeys(email);
		log.debug("Email address got entered");

	}

	@When("User enters password as {string}")
	public void user_enters_password_as(String password) {
		loginPage = new LoginPage(driver);
		loginPage.passwordField().sendKeys(password);
		log.debug("Password field got entered");

	}

	@When("^Use enter Vaild Email as \"([^\"]*)\"$")
	public void use_enter_vaild_email_as_something(String email) {
		forgotPasswordPage = new ForgottenPasswordPage(driver);
		forgotPasswordPage.inputEmail().sendKeys(email);
		log.debug("Email address field got entered");
	}

	@Then("^Navigate to Forgotten Password page$")
	public void navigate_to_forgotten_password_page() {
		   pageBreadcrumb = new PageBreadcrumb(driver);
		Assert.assertTrue(pageBreadcrumb.forgottenPasswordBreadCrumb().isDisplayed());
		log.info("Forgotten password breadcrumb got displayed");

	}

	@Then("^Navigate to the Login page$")
	public void navigate_to_the_login_page() {
		   pageBreadcrumb = new PageBreadcrumb(driver);
		Assert.assertTrue(pageBreadcrumb.loginBreadcrumb().isDisplayed());
		log.info("Login breadcrumb got displayed");

	}

	@And("^Click on Forgotten Password$")
	public void click_on_forgotten_password() {
		loginPage = new LoginPage(driver);
		loginPage.forgottenPassword().click();
		log.debug("Clicked on forgot password button");
	}

	@And("^Click on continue button$")
	public void click_on_continue_button() throws Throwable {
	//	forgotPasswordPage = new ForgottenPasswordPage(driver);
		forgotPasswordPage.continueButton().click();
		log.debug("Clicked on continue");
	}

	@And("^User should See the message An email with a confirmation link has been sent your email address$")
	public void user_should_see_the_message_an_email_with_a_confirmation_link_has_been_sent_your_email_address() {
		Assert.assertTrue(loginPage.emailWithConfirmation().isDisplayed());
		log.info("Email with confirmation got displayed");

	}

	@When("^Use enter Invaild Email as \"([^\"]*)\"$")
	public void use_enter_invaild_email_as_something(String email) {
		//forgotPasswordPage = new ForgottenPasswordPage(driver);
		forgotPasswordPage.inputEmail().sendKeys(email);
		log.debug("Email address field got entered");
	}

	@Then("^User should see the warning message The E-Mail Address was not found in our records, please try again!$")
	public void user_should_see_the_warning_message_the_email_address_was_not_found_in_our_records_please_try_again() {

		Assert.assertTrue(forgotPasswordPage.errorWarningMessage().isDisplayed());
		log.info("Error warming message got displayed");
	}

	

	@After("@log")
	public  void tearDown() {
		driver.close();
		log.debug("Browser got closed");
		

	}
	

}