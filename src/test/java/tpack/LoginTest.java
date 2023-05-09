package tpack;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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

//		Object[][] data = { { "navi@gmail.com", "n1234", "Successfull" },{ "navi@gmail.com", "n34", "Failure" } };
//		return data;
		String excelFilePath = System.getProperty("user.dir")+"\\src\\main\\java\\resources\\LoginData.xlsx";
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(excelFilePath);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		XSSFWorkbook workbook = null;
		try {
			workbook = new XSSFWorkbook(fis);
		} catch (IOException e) {

			e.printStackTrace();
		}

		XSSFSheet sheet = workbook.getSheet("login");

		int rowsCount = sheet.getPhysicalNumberOfRows();
		int colsCount = sheet.getRow(0).getLastCellNum();

		Object[][] data = new Object[rowsCount - 1][colsCount];

		for (int r = 0; r < rowsCount - 1; r++) {

			XSSFRow row = sheet.getRow(r + 1);

			for (int c = 0; c < colsCount; c++) {

				XSSFCell cell = row.getCell(c);

				CellType cellType = cell.getCellType();

				switch (cellType) {

				case STRING:
					data[r][c] = cell.getStringCellValue();
					break;

				case NUMERIC:
					data[r][c] = (int) cell.getNumericCellValue();
					break;

				case BOOLEAN:
					data[r][c] = cell.getBooleanCellValue();
					break;

				}

			}

		}

		return data;
	}
 
	
	@AfterMethod
	public static void closeBrowse() {

		driver.close();
		log.debug("Browser got closed");

	}

}