package stepdefinitions;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobject.AccountPage;
import pageobject.Header;
import pageobject.LandingPage;
import pageobject.Messages;
import pageobject.PageBreadcrumb;
import pageobject.SearchResult;
import resources.Base;

public class BookAnItem extends Base {
WebDriver driver;
Header header ;
AccountPage accountPage;
PageBreadcrumb pageBreadcrumb;
//	@Given("^Open any Browser$")
//	public void open_any_browser()  {
//		
//	}

	@And("^Naviagte to Login page$")
	public void naviagte_to_login_page() throws InterruptedException  {
		driver.get("https://tutorialsninja.com/demo/");
		LandingPage landingPage = new LandingPage(driver);
		landingPage.myAccountDropdown().click();
		landingPage.loginOption().click();
		Thread.sleep(2000);
		
	}

//	@When("^User enters username as \"([^\"]*)\" and password as \"([^\"]*)\" into the fields$")
//	public void user_enters_username_as_something_and_password_as_something_into_the_fields(String strArg1,
//			String strArg2)  {
//		
//	}

//	@And("^User clicks on Login button$")
//	public void user_clicks_on_login_button() {
//		
//	}
//
//	@Then("^Verify user should able to successfully login$")
//	public void verify_user_should_able_to_successfully_login()  {
//		
//	}

	@And("^User search for a product as \"([^\"]*)\" and Click on search button$")
	public void user_search_for_a_product_as_something_and_click_on_search_button(String strArg1) {
	
		header = new Header(Login.driver);
		header.searchFieldOption().sendKeys(strArg1);
		header.searchButtonOption().click();
		
	}
	

	@Then("^User should navigate to search results page and  see the product and clicked on it$")
	public void user_should_navigate_to_search_results_page_and_see_the_product_and_clicked_on_it()  {
		
		SearchResult searchResult = new SearchResult(Login.driver);
		searchResult.iMac().click();
	}

	@And("^User should naviagte to details page of product and Enter the quantity as \"([^\"]*)\" and clicked on add to cart$")
	public void user_should_naviagte_to_details_page_of_product_and_enter_the_quantity_as_something_and_clicked_on_add_to_cart(
			String strArg1)  {
		accountPage = new AccountPage(Login.driver);
		accountPage.qtyfildOption().clear();
		accountPage.qtyfildOption().sendKeys(strArg1);
		accountPage.addToCartOption().click();
	}

	@And("^user should see the success message of add to cart$")
	public void user_should_see_the_success_message_of_add_to_cart() {
		Messages message = new Messages(Login.driver);
	  boolean successmsg = message.addtoCardSuccessMessage().isDisplayed();
	 Assert.assertTrue(successmsg);
		
	}

	@And("^User clicked on shopping cart option then user should naviagte to the shopping cart page and clicked on checkout button$")
	public void user_clicked_on_shopping_cart_option_then_user_should_naviagte_to_the_shopping_cart_page_and_clicked_on_checkout_button()
			{
		header.shoppingCartOption().click();
		
		 pageBreadcrumb = new PageBreadcrumb(Login.driver);
		 Assert.assertTrue(pageBreadcrumb.shoppingCartBreadCrumb().isDisplayed());
		 accountPage.checkOutButtonOption().click();
		
		
	}

	@And("^User should navigate to the checkout page$")
	public void user_should_navigate_to_the_checkout_page()  {
		;
		Assert.assertTrue(pageBreadcrumb.checkoutBreadCrumb().isDisplayed());
		
	}

	@And("^User should see the exisiting billing address and clicked on continue button$")
	public void user_should_see_the_exisiting_billing_address_and_clicked_on_continue_button()  {
		
		accountPage.continueButtonOtions().click();;
	}

	@And("^user should see the existing Delivery details adress and click on continue button$")
	public void user_should_see_the_existing_delivery_details_adress_and_click_on_continue_button()  {
		
		accountPage.continueDeliveryDetails().click();
	}
	@And("^user should click on continue button$")
	public void user_should_click_on_continue_button() {
		accountPage.continueShiping().click();
		
	}

	@And("^User should see the Cash on delivery option and selecte privacy then clicked on continue button$")
	public void user_should_see_the_cash_on_delivery_option_and_selecte_privacy_then_clicked_on_continue_button()
			{
		accountPage.termsAndCondition().click();
		accountPage.continuePyment().click();
		
	}

	@Then("^User should see the confirm order details and clicked on confirm order$")
	public void user_should_see_the_confirm_order_details_and_clicked_on_confirm_order()  {
		accountPage.confirmOrderButton().click();
	}

	@And("^user should see the confirmation message of booking order$")
	public void user_should_see_the_confirmation_message_of_booking_order(){
	
		Assert.assertTrue(accountPage.orderPlaced().isDisplayed());
	}
	@After("@book")
	public  void tearDown(Scenario scenario) throws IOException {
		 String testName = scenario.getName();
	if (scenario.isFailed()) {
		TakesScreenshot ts = (TakesScreenshot)driver;
		byte[] src = ts.getScreenshotAs(OutputType.BYTES);
		scenario.attach(src, "image/png", testName);
		}
   Login.driver.close();
	
		

	}

}
