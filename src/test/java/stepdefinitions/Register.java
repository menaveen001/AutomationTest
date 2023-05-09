package stepdefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobject.AccountSuccessPage;
import pageobject.LandingPage;
import pageobject.RegisterAccountPage;
import resources.Base;

public class Register extends Base {
	 static WebDriver driver;
	LandingPage landingpage;
	RegisterAccountPage register;
	AccountSuccessPage success;
	static Logger log;

	@Given("^Open the appliction in any Browser$")
	public void open_the_appliction_in_any_browser() throws IOException {
		log = LogManager.getLogger(Register.class.getName());
		driver = initializeBrowser();
		log.debug("Browser got lunched");
		driver.get(prop.getProperty("url"));
		log.debug("Navigate to the Appliction URL");
	}

	@And("^Click on My Account Drop menu$")
	public void click_on_my_account_drop_menu() {
		landingpage = new LandingPage(driver);
		landingpage.myAccountDropdown().click();
		log.debug("Clicked on myAccount Dropdown");

	}

	@And("^Clicked on Register option$")
	public void clicked_on_register_option() throws InterruptedException {

		landingpage.registerOption().click();
		log.debug("Clicked on Register option ");
		Thread.sleep(3000);
	}

	@When("^Enter the below data new Account Details into the Mandatory Fields$")
	public void enter_the_below_data_new_account_details_into_the_mandatory_fields(DataTable data)
			throws InterruptedException {
		Map<String, String> dataMap = data.asMap(String.class, String.class);
		//List<Map<String, String>> dataMap = data.asMaps(String.class, String.class);
	      
		register = new RegisterAccountPage(driver);
		register.inputFirstNameField().sendKeys(dataMap.get("firstName"));
		log.debug("First name address got Entered");
		register.inputLastNameField().sendKeys(dataMap.get("lastName"));
		log.debug("Last name address got Entered");
		register.inputEmailField().sendKeys(System.currentTimeMillis() + dataMap.get("email"));
		log.debug("Email address got Entered");
		register.InputTelephonField().sendKeys(dataMap.get("telephone"));
		log.debug("Telephone address got Entered");
		register.inputPasswordField().sendKeys(dataMap.get("password"));
		log.debug("Password address got Entered");
		register.inputConfirmPasswoedField().sendKeys(dataMap.get("password"));
		log.debug("Confirm password address got Entered");
		
	      }
	
	
	@And("^Select Privacy Policy Fields$")
	public void select_privacy_policy_fields() {

		register.checkBoxOption().click();
		log.debug("Privacy policy got Selected");
	}

	@And("^Click on Continue button$")
	public void click_on_continue_button() {
		register = new RegisterAccountPage(driver);
		register.continueButton().click();
		log.debug("Clicked on Countinue button");
	}

	@Then("^User should be loged in taken to Account Success page and proper details should be displayed on the page$")
	public void user_should_be_loged_in_taken_to_account_success_page_and_proper_details_should_be_displayed_on_the_page() {
		success = new AccountSuccessPage(driver);
		success.accountSuccessStatus().isDisplayed();
		log.info("Account success status got Displayed");
	}

	@And("^Click on Continue button that is displayed in the Account Success page$")
	public void click_on_continue_button_that_is_displayed_in_the_account_success_page() {

		success.continueButton().click();
		log.debug("Clicked on Countinue button");
	}

	@Then("^User should be loged in taken to Account Success page and a confirm email should be sent to the register email address$")
	public void user_should_be_loged_in_taken_to_account_success_page_and_a_confirm_email_should_be_sent_to_the_register_email_address() {

	}

	@And("^Select Newsletter Subscribe Fields$")
	public void select_newsletter_subscribe_fields() {

		register.newsLetterField().click();
		log.debug("News letter field got Selected");
	}

	@And("^User should see Warning message You must agree to the Privacy policy$")
	public void user_should_see_warning_message_you_must_agree_to_the_privacy_policy() {
		Assert.assertTrue(register.warningMessage().isDisplayed());
		log.info("Select Privacy policy Warning got Displayed");

	}

	@Then("^Account should not created$")
	public void Account_should_not_created() {

		Assert.assertTrue(register.registerBreadcrum().isDisplayed());
		log.info("Register breadcrum got Displayed");

	}

	@Then("^User should see the error messgae informing the user to fill the mandatory fields$")
	public void user_should_see_the_error_messgae_informing_the_user_to_fill_the_mandatory_fields() {
		Assert.assertTrue(register.firstNameWarning().isDisplayed());
		log.info("Enter First name warning got Displayed");
		Assert.assertTrue(register.lastNmaeWarning().isDisplayed());
		log.info("Enter Last nmae warning got Displayed");
		Assert.assertTrue(register.emailWarning().isDisplayed());
		log.info("Enter Email warning got Displayed");
		Assert.assertTrue(register.telephoneWarning().isDisplayed());
		log.info("Enter Telephone warning got Displayed");
		Assert.assertTrue(register.passwordWarning().isDisplayed());
		log.info("Enter password warning got Displayed");

	}

	@When("^Enter new Account Details into the Mandatory Fields the below data but skip firstName$")
	public void enter_new_account_details_into_the_mandatory_fields_the_below_data_but_skip_firstName(
			DataTable dataTable) {
		Map<String, String> dataMap = dataTable.asMap(String.class, String.class);

		register = new RegisterAccountPage(driver);
		register.inputLastNameField().sendKeys(dataMap.get("lastName"));
		log.debug("Last name address got Entered");
		register.inputEmailField().sendKeys(System.currentTimeMillis() + dataMap.get("email"));
		log.debug("Email address got Entered");
		register.InputTelephonField().sendKeys(dataMap.get("telephone"));
		log.debug("Telephone address got Entered");
		register.inputPasswordField().sendKeys(dataMap.get("password"));
		log.debug("Password address got Entered");
		register.inputConfirmPasswoedField().sendKeys(dataMap.get("password"));
		log.debug("Confirm password address got Entered");

	}

	@And("^User should see the Warning message to fill the First name$")
	public void user_should_see_the_Waring_message_to_fill_the_First_name() {

		Assert.assertTrue(register.firstNameWarning().isDisplayed());
		log.info("Enter First name warning got Displayed");
	}

	@When("^Enter new Account Details into the Mandatory Fields the below data but skip lastName$")
	public void enter_new_Account_Details_into_the_Mandatory_Fields_the_below_data_but_skip_lastName(DataTable data) {
		Map<String, String> dataMap = data.asMap(String.class, String.class);

		register = new RegisterAccountPage(driver);
		register.inputFirstNameField().sendKeys(dataMap.get("firstName"));
		log.debug("First name address got Entered");
		register.inputEmailField().sendKeys(System.currentTimeMillis() + dataMap.get("email"));
		log.debug("Email address got Entered");
		register.InputTelephonField().sendKeys(dataMap.get("telephone"));
		log.debug("Telephone address got Entered");
		register.inputPasswordField().sendKeys(dataMap.get("password"));
		log.debug("Password address got Entered");
		register.inputConfirmPasswoedField().sendKeys(dataMap.get("password"));
		log.debug("Confirm password address got Entered");

	}

	@And("^User should see the Warning message to fill the Last name$")
	public void user_should_see_the_waring_message_to_fill_the_last_name() {
		Assert.assertTrue(register.lastNmaeWarning().isDisplayed());
		log.info("Enter Last name warning got Displayed");

	}

	@When("^Enter new Account Details into the Mandatory Fields the below data but skip Email$")
	public void enter_new_account_details_into_the_mandatory_fields_the_below_data_but_skip_email(DataTable data) {
		Map<String, String> dataMap = data.asMap(String.class, String.class);
		register = new RegisterAccountPage(driver);
		register.inputFirstNameField().sendKeys(dataMap.get("firstName"));
		log.debug("First name address got Entered");
		register .inputLastNameField().sendKeys(dataMap.get("lastName"));
		log.debug("Last namme address got Entered");
		register.InputTelephonField().sendKeys(dataMap.get("telephone"));
		log.debug("Telephone address got Entered");
		register.inputPasswordField().sendKeys(dataMap.get("password"));
		log.debug("Password address got Entered");
		register.inputConfirmPasswoedField().sendKeys(dataMap.get("password"));
		log.debug("Confirm password address got Entered");

	}
	@And("^User should see the Warning message to fill the Email$")
    public void user_should_see_the_warning_message_to_fill_the_email(){
      Assert.assertTrue(register.emailWarning().isDisplayed());
      log.info("Enter email warning got Displayed");
    }
	
	@When("^Enter new Account Details into the Mandatory Fields the below data but skip Telephone$")
	public void enter_new_Account_Details_into_the_Mandatory_Fields_the_below_data_but_skip_Telephone(DataTable data) {
		        Map<String, String> dataMap = data.asMap(String.class,String.class);
		        register = new RegisterAccountPage(driver);
		        register.inputFirstNameField().sendKeys(dataMap.get("firstName"));
				log.debug("First name address got Entered");
				register .inputLastNameField().sendKeys(dataMap.get("lastName"));
				log.debug("Last namme address got Entered");
				register.inputEmailField().sendKeys(System.currentTimeMillis() + dataMap.get("email"));
				log.debug("Email address got Entered");
				register.inputPasswordField().sendKeys(dataMap.get("password"));
				log.debug("Password address got Entered");
				register.inputConfirmPasswoedField().sendKeys(dataMap.get("password"));
				log.debug("Confirm password address got Entered");
				
	}
	
	@And("^User should see the Warning message to fill the Telephone$")
	public void user_should_see_the_Warning_message_to_fill_Telephone() {
		
		Assert.assertTrue(register.telephoneWarning().isDisplayed());
		 log.info("Enter Telephone warning got Displayed");
	}
	
	@When("^Enter new Account Details into the Mandatory Fields the below data but skip Password$")
	public void enter_new_account_details_into_the_mandatory_fields_the_below_data_but_skip_password(DataTable data) {
		Map<String, String> dataMap = data.asMap(String.class, String.class);
		register = new RegisterAccountPage(driver);
		register.inputFirstNameField().sendKeys(dataMap.get("firstName"));
		log.debug("First name address got Entered");
		register .inputLastNameField().sendKeys(dataMap.get("lastName"));
		log.debug("Last namme address got Entered");
		register.inputEmailField().sendKeys(System.currentTimeMillis() + dataMap.get("email"));
		log.debug("Email address got Entered");
		register.InputTelephonField().sendKeys(dataMap.get("telephone"));
		log.debug("Telephone address got Entered");
	}
	
	@And("^User should see the Warning message to fill the Password$")
	public void user_should_see_the_Waring_message_to_fill_the_Password() {
		
		Assert.assertTrue(register.passwordWarning().isDisplayed());
		log.debug("Password warning message got displayed");
	}
	
@And("^User should see the Warning message of invalid formate of Email$")
public void User_should_see_the_Warning_message_of_invalid_formate_of_Email() {
	
	 String validEmailError = register.inputEmailField().getAttribute("validationMessage");
	  Assert.assertTrue( validEmailError.contains("Please include an '@' in the email address"));
	  log.debug("Provide valid formate of email got displayed");
	 
	
	
}
@When("^Enter the below data new Account Details into the Mandatory Field$")
public void enter_the_below_data_new_account_details_into_the_mandatory_field(DataTable data)
		throws InterruptedException {
	Map<String, String> dataMap = data.asMap(String.class, String.class);
	register = new RegisterAccountPage(driver);
	register.inputFirstNameField().sendKeys(dataMap.get("firstName"));
	log.debug("First name address got Entered");
	register.inputLastNameField().sendKeys(dataMap.get("lastName"));
	log.debug("Last name address got Entered");
	register.inputEmailField().sendKeys(System.currentTimeMillis() + dataMap.get("email"));
	log.debug("Email address got Entered");
	register.InputTelephonField().sendKeys(dataMap.get("telephone"));
	log.debug("Telephone address got Entered");
	register.inputPasswordField().sendKeys(dataMap.get("password"));
	log.debug("Password address got Entered");
	register.inputConfirmPasswoedField().sendKeys(dataMap.get("confPass"));
	log.debug("Confirm password address got Entered");
}
@And("^User should see the Warning message Password confirmation does not match password!$")
public void user_should_see_the_warning_message_password_confirmation_does_not_match_password(){
      boolean message = register.passwordMatchErrore().isDisplayed();
         Assert.assertTrue(message);
         log.info("Password not match error got displayed");
}
	
	@After("@register")
	public  void tearDown(Scenario scenario) throws IOException {
		 String testName = scenario.getName();
			if (scenario.isFailed()) {
		TakesScreenshot ts = (TakesScreenshot)driver;
		byte[] src = ts.getScreenshotAs(OutputType.BYTES);
		scenario.attach(src, "image/png", testName);
		}
	driver.close();
	log.debug("Browser got closed");
		

	}
}