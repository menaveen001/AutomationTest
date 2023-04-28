package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Header{
	WebDriver driver;

	public Header(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//i[@class='fa fa-phone']")
	private WebElement phoneNumber;

	@FindBy(xpath = "//span[normalize-space()='My Account']")
	 private WebElement myAccountDropdown;

	@FindBy(xpath = "//span[normalize-space()='Wish List (0)']")
	private WebElement wishListOption;

	@FindBy(xpath = "//span[normalize-space()='Shopping Cart']")
	private WebElement shoppingCartOption;

	@FindBy(xpath = "//span[normalize-space()='Checkout']")
	private WebElement checkoutOption;
	@FindBy(xpath= "//a[contains(text(),'Login')]")
	private WebElement loginOption;
	
	@FindBy(linkText = "Logout")
	private WebElement logOutOption;
	@FindBy(xpath = "//input[@type='text']")
	private WebElement searchFieldOption;

	@FindBy(xpath = "//body[1]/header[1]/div[1]/div[1]/div[2]/div[1]/span[1]/button[1]/i[1]")
	private WebElement searchButtonOption;

	public WebElement phoneNumber() {

		return phoneNumber;
	}

	public WebElement myAccountDropdown() {

		return myAccountDropdown;

	}

	public WebElement wishListOption() {
		return wishListOption;
	}

	public WebElement shoppingCartOption() {
		return shoppingCartOption;
	}

	public WebElement checkoutOption() { 
		return checkoutOption();
	}
	public WebElement loginOption() {
		return loginOption;
		
	}
	
	public WebElement logOutOption() {
		return logOutOption;
	}
	public WebElement searchFieldOption() {

		return searchFieldOption;
	}
	public WebElement searchButtonOption() {

		return searchButtonOption;
	}

}