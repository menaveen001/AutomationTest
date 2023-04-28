package tpack;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.testng.Assert;

import pageobject.AccountPage;
import pageobject.Header;
import pageobject.LandingPage;
import pageobject.LoginPage;
import pageobject.SearchResult;
import resources.Base;

public class BookAnItemTest extends Base {

	public WebDriver driver;
	LandingPage landingPage;
	LoginPage loginpage;
	AccountPage accountPage;
	Header header;
	SearchResult searchResult;
	
	Logger log;

	@BeforeMethod
	public void OpenApplication() throws IOException {
		log = LogManager.getLogger(RegisterAccountTest.class.getName());

		driver = initializeBrowser();
		log.debug("Browser got launched");
		driver.get(prop.getProperty("url"));
		log.debug("Navigated to application URL");
	}

	@Test
	public void bookingPhone() throws InterruptedException {

		landingPage = new LandingPage(driver);
		landingPage.myAccountDropdown().click();
		log.debug("Clicked on myAccount Dropdown");
		landingPage.loginOption().click();
		log.debug("Clicked on login option");

		loginpage = new LoginPage(driver);
		loginpage.emailAddressField().sendKeys("palankush@gmail.com");
		log.debug("Email address got entered");
		loginpage.passwordField().sendKeys("ankush123");
		log.debug("Password address got entered");
		loginpage.loginButton().click();
		log.debug("Clicked on login button");

		header = new Header(driver);
		header.searchFieldOption().sendKeys("iphone");
		log.debug("Search address got entered");
		header.searchButtonOption().click();
		log.debug("Clicke on search button");
		 searchResult = new SearchResult(driver);
	
		if (searchResult.iphoneIsDisplay().isDisplayed()) {

			searchResult.iphoneIsDisplay().click();
			log.debug("Clicked on iphone");

		}
		accountPage =new AccountPage(driver);
		accountPage.qtyfildOption().clear();
		log.debug("Quantity address got cleaned");
		accountPage.qtyfildOption().sendKeys("2");
		log.debug("Quantity address got entered");
		accountPage.addToCartOption().click();
		log.debug("Clicked on add to cart button");
		accountPage.shopingCartOption().click();
		log.debug("Clicked on shoping cart ");
		accountPage.checkOutButtonOption().click();
		log.debug("Clicked on check out");
		Thread.sleep(3000);
		if (accountPage.newAddressOption().isDisplayed()) {

			accountPage.newAddressOption().click();
			log.debug("Clicked on new address radio button");
			accountPage.fNmaeField().sendKeys("naveen");
			log.debug("First name address got entered");
			accountPage.lNmaeField().sendKeys("pal");
			log.debug("Last name address got entered");
			accountPage.address1Field().sendKeys("New Delhi");
			log.debug("Address 1  address got entered");
			accountPage.address2Field().sendKeys("new Delhi2");
			log.debug("Address 2  address got entered");
			accountPage.cityOption().sendKeys("Delhi");
			log.debug("City address got entered");
			accountPage.postCodeOption().sendKeys("11009");
			log.debug("Postal code address got entered");

			Thread.sleep(3000);

			Actions action = new Actions(driver);

			action.moveToElement(accountPage.countryOption()).click().sendKeys("i").sendKeys(Keys.DOWN).click().build()
					.perform();
			log.debug("Country address got entered");
			Thread.sleep(2000);
			action.moveToElement(accountPage.regionOption()).click().sendKeys("u").sendKeys(Keys.DOWN).click().build()
					.perform();
			log.debug("Region address got entered");

			accountPage.continueButtonOtions().click();
			log.debug("Clicked on Continue button");

		} else {

			accountPage.fNmaeField().sendKeys("priti");
			log.debug("First nsme address got entered");
			accountPage.lNmaeField().sendKeys("pal");
			log.debug("Last name address got entered");
			accountPage.address1Field().sendKeys("New Delhi");
			log.debug("Address 1  address got entered");
			accountPage.address2Field().sendKeys("new Delhi2");
			log.debug("Address 2  address got entered");
			accountPage.cityOption().sendKeys("Delhi");
			log.debug("City address got entered");
			accountPage.postCodeOption().sendKeys("11009");
			log.debug("Postal code address got entered");

			Thread.sleep(3000);

			Actions action = new Actions(driver);

			action.moveToElement(accountPage.countryOption()).click().sendKeys("i").sendKeys(Keys.DOWN).click().build()
					.perform();
			log.debug("Country address got entered");
			Thread.sleep(2000);
			action.moveToElement(accountPage.regionOption()).click().sendKeys("u").sendKeys(Keys.DOWN).click().build()
					.perform();
			log.debug("Region address got entered");

			accountPage.continueButtonOtions().click();
			log.debug("Clicked on Continue button");

		}
         Thread.sleep(3000);
		accountPage.continueDeliveryDetails().click();
		log.debug("Clicked on continue delivery details button");
		accountPage.continueShiping().click();
		log.debug("Clicked on continue shiping button");
		Thread.sleep(2000);
		accountPage.termsAndCondition().click();
		log.debug("Clicked on terms and conditions");
		accountPage.continuePyment().click();
		log.debug("Clicked on continue pyment button");
		accountPage.confirmOrderButton().click();
		log.debug("Clicked on confirm order button");

		String actualResult = null;
		try {
			if (accountPage.orderPlaced().isDisplayed()) {

				accountPage.continueOption().click();
				log.debug("Clicked on continue ");
				actualResult = "Successfull";
			}

		} catch (Exception e) {
			actualResult = "Failure";
			log.debug("User got logged in");

		}
		Assert.assertEquals(actualResult, "Successfull");
		log.info("Booking order tests got passes");

	}

	@AfterMethod
	public void close() {

		driver.close();
		log.debug("Browser got closed");
	}

}