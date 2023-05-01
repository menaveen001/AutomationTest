package tpack;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageobject.AccountPage;

import pageobject.LandingPage;
import pageobject.LoginPage;
import resources.Base;

public class LoginTest extends Base {

	public static WebDriver driver;
	static Logger log;

	@BeforeMethod
	public static void OpenApplication() throws IOException {
		log = LogManager.getLogger(LoginTest.class.getName());
		driver = initializeBrowser();
		log.debug("Browser got launched");
		driver.get(prop.getProperty("url"));
		log.debug("Navigated to application URL");
	}

	@Test(dataProvider = "loginData")
	public static void login(String email, String Passsword, String expectedResult)
			throws IOException, InterruptedException {

		LandingPage landingPage = new LandingPage(driver);
		landingPage.myAccountDropdown().click();
		log.debug("Clicked on My Account dropdown");
		landingPage.loginOption().click();
		log.debug("Clicked on login option");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.emailAddressField().sendKeys(email);
		log.debug("Email addressed got entered");
		loginPage.passwordField().sendKeys(Passsword);
		log.debug("Password got entered");
		loginPage.loginButton().click();
		log.debug("Clicked on Login Button");

		AccountPage accountPage = new AccountPage(driver);

		String actualResult = null;

		try {
			if (accountPage.accounEditOption().isDisplayed()) {
				actualResult = "Successfull";
				log.debug("User got logged in");
			}
			;

		} catch (Exception e) {
			actualResult = "Failure";
			log.debug("User didn't log in");
		}
		Assert.assertEquals(actualResult, expectedResult);
		log.info("Login Test got passed");
	}

	@DataProvider
	public static Object[][] loginData() {

		Object[][] data = { { "navi@gmail.com", "n1234", "Successfull" },{ "navi@gmail.com", "n34", "Failure" } };
		return data;

	}

	@AfterMethod
	public static void closeBrowse() {

		driver.close();
		log.debug("Browser got closed");

	}

}