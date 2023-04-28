package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
	WebDriver driver;

	public AccountPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(text(),'Edit your account information')]")
	private WebElement accountEditOption;


	@FindBy(id = "input-quantity")
	private WebElement qtyfildOption;

	@FindBy(id = "button-cart")
	private WebElement addToCartOption;

	@FindBy(css = "a[title='Shopping Cart'] span[class='hidden-xs hidden-sm hidden-md']")
	private WebElement shopingCartOption;

	@FindBy(xpath = "//a[@class='btn btn-primary']")
	private WebElement checkOutButtonOption;

	@FindBy(xpath = "//label[normalize-space()='I want to use a new address']//input[@name='payment_address']")
	private WebElement newAddressOption;

	@FindBy(id = "input-payment-firstname")
	private WebElement fNmaeField;

	@FindBy(id = "input-payment-lastname")
	private WebElement lNmaeField;

	@FindBy(id = "input-payment-address-1")
	private WebElement address1Field;

	@FindBy(id = "input-payment-address-2")
	private WebElement address2Field;

	@FindBy(id = "input-payment-city")
	private WebElement cityOption;

	@FindBy(id = "input-payment-postcode")
	private WebElement postCodeOption;

	@FindBy(id = "input-payment-country")
	private WebElement countryOption;

	@FindBy(id = "input-payment-zone")
	private WebElement regionOption;

	@FindBy(xpath = "(//input[@type='button'])[1]")
	private WebElement continueButtonOtions;

	@FindBy(xpath = "(//input[@type='radio'])[3]")
	private WebElement existingAddressOption;

	@FindBy(id = "button-shipping-address")
	private WebElement continueDeliveryDetails;

	@FindBy(id = "button-shipping-method")
	private WebElement continueShiping;

	@FindBy(xpath = "//input[@name='agree']")
	private WebElement termsAndCondition;

	@FindBy(xpath = "(//input[@type='button'])[4]")
	private WebElement continuePyment;

	@FindBy(xpath = "(//input[@type='button'])[5]")
	private WebElement confirmOrderButton;

	@FindBy(xpath = "//h1[normalize-space()='Your order has been placed!']")
	private WebElement orderPlaced;

	@FindBy(linkText = "Continue")
	private WebElement continueOption;

	public WebElement accounEditOption() {

		return accountEditOption;
	}


	public WebElement qtyfildOption() {

		return qtyfildOption;
	}

	public WebElement addToCartOption() {

		return addToCartOption;
	}

	public WebElement shopingCartOption() {

		return shopingCartOption;
	}

	public WebElement checkOutButtonOption() {

		return checkOutButtonOption;
	}

	public WebElement newAddressOption() {

		return newAddressOption;
	}

	public WebElement fNmaeField() {

		return fNmaeField;
	}

	public WebElement lNmaeField() {

		return lNmaeField;
	}

	public WebElement address1Field() {

		return address1Field;
	}

	public WebElement address2Field() {

		return address2Field;
	}

	public WebElement cityOption() {

		return cityOption;
	}

	public WebElement postCodeOption() {

		return postCodeOption;
	}

	public WebElement countryOption() {

		return countryOption;
	}

	public WebElement regionOption() {

		return regionOption;
	}

	public WebElement continueButtonOtions() {

		return continueButtonOtions;
	}

	public WebElement existingAddressOption() {

		return existingAddressOption;
	}

	public WebElement continueDeliveryDetails() {

		return continueDeliveryDetails;
	}

	public WebElement continueShiping() {

		return continueShiping;
	}

	public WebElement termsAndCondition() {

		return termsAndCondition;
	}

	public WebElement continuePyment() {

		return continuePyment;
	}

	public WebElement confirmOrderButton() {

		return confirmOrderButton;
	}

	public WebElement orderPlaced() {

		return orderPlaced;
	}

	public WebElement continueOption() {

		return continueOption;
	}

}