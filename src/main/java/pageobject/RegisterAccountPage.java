package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterAccountPage {

	public WebDriver driver;

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

	@FindBy(xpath = "//input[@name='newsletter' and @value='1']")
	private WebElement newsLetterField;

	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement warningMessage;

	@FindBy(linkText = "Register")

	private WebElement registerBreadcrum;

	@FindBy(xpath = "//div[contains(text(),'First Name must be between 1 and 32 characters!')]")
	private WebElement firstNameWarning;
	
	@FindBy(xpath="//div[contains(text(),'Last Name must be between 1 and 32 characters!')]")
	private WebElement lastNmaeWarning;
	
	@FindBy(xpath="//div[contains(text(),'E-Mail Address does not appear to be valid!')]")
	private WebElement emailWarning;
	
	@FindBy(xpath="//div[contains(text(),'Telephone must be between 3 and 32 characters!')]")
    private WebElement telephoneWarning;
	
	@FindBy(xpath="//div[contains(text(),'Password must be between 4 and 20 characters!')]")
	private WebElement passwordWarning;
	
	
	@FindBy(xpath = "//div[contains(text(),'Password confirmation does not match password!')]")
	private WebElement passwordMatchError;
	
	 
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

	public WebElement newsLetterField() {
		return newsLetterField;

	}

	public WebElement warningMessage() {

		return warningMessage;
	}

	public WebElement registerBreadcrum() {

		return registerBreadcrum;
	}

	public WebElement firstNameWarning() {
		
		return firstNameWarning;
	}
	
	public WebElement lastNmaeWarning() {
		
		return lastNmaeWarning;
		
	}
	public WebElement emailWarning() {
		
		return emailWarning;
	}
	public WebElement telephoneWarning() {
		
		return telephoneWarning;
	}
	
	public WebElement passwordWarning() {
		return passwordWarning;
	}
	public WebElement passwordMatchErrore() {
		return passwordMatchError;
	}
}