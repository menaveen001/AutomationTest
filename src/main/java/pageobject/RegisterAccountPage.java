package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterAccountPage {

	WebDriver driver;

	public RegisterAccountPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "input-firstname")
	private WebElement inputFirstNameField;

	@FindBy(id = "input-lastname")
	private WebElement inputLastNameField;

	@FindBy(id = "input-email")
	private WebElement inputEmailField;

	@FindBy(id = "input-telephone")
	private WebElement InputTelephonField;

	@FindBy(id = "input-password")
	private WebElement inputPasswordField;

	@FindBy(id = "input-confirm")
	private WebElement inputConfirmPasswoedField;

	@FindBy(xpath = "//input[@name='agree']")
	private WebElement checkBoxOption;

	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement continueButton;

	public WebElement inputFirstNameField() {
		return inputFirstNameField;
	}

	public WebElement inputLastNameField() {
		return inputLastNameField;
	}

	public WebElement inputEmailField() {
		return inputEmailField;
	}

	public WebElement InputTelephonField() {
		return InputTelephonField;
	}

	public WebElement inputPasswordField() {
		return inputPasswordField;
	}

	public WebElement inputConfirmPasswoedField() {
		return inputConfirmPasswoedField;
	}

	public WebElement checkBoxOption() {
		return checkBoxOption;
	}

	public WebElement continueButton() {
		return continueButton;
	}

}
