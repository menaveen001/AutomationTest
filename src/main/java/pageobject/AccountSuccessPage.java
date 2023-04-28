package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSuccessPage {

	WebDriver driver;

	public AccountSuccessPage(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//body[1]/div[2]/div[1]/div[1]/h1[1]")
	private WebElement accountSuccessStatus;

	@FindBy(xpath = "//a[normalize-space()='Continue']")
	private WebElement continueButton;

	public WebElement accountSuccessStatus() {
		return accountSuccessStatus;
	}

	public WebElement continueButton() {
		return continueButton;
	}
}
