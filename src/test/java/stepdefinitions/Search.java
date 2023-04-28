package stepdefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobject.Header;
import pageobject.SearchResult;

public class Search {
	WebDriver driver;

	Header hearder;
	 SearchResult serarchResult ;
	 Logger log;

	@When("User search for a producr name as {string}")
	public void user_search_for_a_producr_name_as(String itemName) {
		log = LogManager.getLogger(Login.class.getName());
		hearder = new Header(Register.driver);
		hearder.searchFieldOption().sendKeys(itemName);
		log.debug("Searchr field got Entered");
		hearder.searchButtonOption().click();
		log.debug("Clicked on Search button");

	}

	@Then("User should see the product in to search Result")
	public void user_should_see_the_product_in_to_search_result() {
	          serarchResult = new SearchResult(Register.driver);
	          Assert.assertTrue(serarchResult.iphoneIsDisplay().isDisplayed());
	          log.info("Iphone got displayed in search result ");
	}

 @After("@sear")
	public void closeBrowser() {
	 
	 Register. driver.close();
		log.debug("Browser got closed");
	}
}