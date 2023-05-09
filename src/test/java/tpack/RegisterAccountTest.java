package tpack;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
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
import pageobject.AccountSuccessPage;

import pageobject.LandingPage;
import pageobject.RegisterAccountPage;
import resources.Base;

public class RegisterAccountTest extends Base {
	public WebDriver driver;
	Logger log;

	@BeforeMethod
	public void OpenApplication() throws IOException {
		log = LogManager.getLogger(RegisterAccountTest.class.getName());

		driver = initializeBrowser();
		log.debug("Browser got launched");
		driver.get(prop.getProperty("url"));
		log.debug("Navigated to application URL");
	}

	@Test(dataProvider = "registerAccountData")
	public void registerAccount(String firstName, String lastName, String email, Number telephone, String password,
			String expectedResult) throws IOException {
	
	//	String telephone = tele.toString();

		LandingPage landingPage = new LandingPage(driver);

		landingPage.myAccountDropdown().click();
		log.debug("Clicked on My Account dropdown");
		landingPage.registerOption().click();
		log.debug("Clicked on register option");

		RegisterAccountPage registerAccounPage = new RegisterAccountPage(driver);
		registerAccounPage.inputFirstNameField().sendKeys(firstName);
		log.debug("Firstname addressed got entered");
		registerAccounPage.inputLastNameField().sendKeys(lastName);
		log.debug("Lastname addressed got entered");
		registerAccounPage.inputEmailField().sendKeys(email);
		log.debug("Email addressed got entered");
		registerAccounPage.InputTelephonField().sendKeys(String.valueOf(telephone));
		log.debug("Telephone addressed got entered");
		registerAccounPage.inputPasswordField().sendKeys(password);
		log.debug("Password addressed got entered");
		registerAccounPage.inputConfirmPasswoedField().sendKeys(password);
		log.debug("Confirm Password addressed got entered");
		registerAccounPage.checkBoxOption().click();
		log.debug("Clicked on checkBox option");
		registerAccounPage.continueButton().click();
		log.debug("Clicked on continue button");

		AccountSuccessPage accountStatusPage = new AccountSuccessPage(driver);
		String actualResult = null;
		try {

			if (accountStatusPage.accountSuccessStatus().isDisplayed()) {
				actualResult = "Successfull";
				log.debug("Account got created");
				accountStatusPage.continueButton().click();
				log.debug("Clicked on continue button");
			}
		} catch (Exception e) {

			actualResult = "Failure";
			log.debug("Account didn't created");
		}
		Assert.assertEquals(actualResult, expectedResult);
		log.info("RegisterAcoount Test got passed");
	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
		log.debug("Browser got closed");
	}

	@DataProvider
	public Object[][] registerAccountData() {

//		Object[][] data = { { "navi", "pal", "navipa65@gmail.com", "123456", "n1234", "Successfull" },
//				{ "navi", "pal", "navi@gmail.com", "123456", "n1234", "Failure" } };
//		return data;
		String excelFilePath = System.getProperty("user.dir") + "\\src\\main\\java\\resources\\RegisterData.xlsx";
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

		XSSFSheet sheet = workbook.getSheet("register");

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

}
