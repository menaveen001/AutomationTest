package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgottenPasswordPage {

	WebDriver driver;

	public ForgottenPasswordPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	
	
	@FindBy(id="input-email")
	private WebElement inputEmail;

	@FindBy(xpath="//input[@value='Continue']")
	private WebElement continueButton;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	private WebElement errorWarningMessage;
	

	
	public WebElement inputEmail() {
		return inputEmail;
	}
	public WebElement continueButton() {
		return continueButton;
	}
	
	public WebElement errorWarningMessage() {
		return errorWarningMessage;
		
	}
	
}