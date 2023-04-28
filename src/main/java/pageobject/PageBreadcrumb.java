package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageBreadcrumb {
	WebDriver driver;

	public PageBreadcrumb(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(linkText = "Logout")
	private WebElement logoutBreadcrumb;
	@FindBy(linkText = "Login")
	private WebElement loginBreadcrumb;
	@FindBy(linkText = "Forgotten Password")
	private WebElement forgottenPasswordBreadCrumb;

	public WebElement logoutBreadcrumb() {
		return logoutBreadcrumb;
	}

	public WebElement loginBreadcrumb() {
		return loginBreadcrumb;

	}

	public WebElement forgottenPasswordBreadCrumb() {

		return forgottenPasswordBreadCrumb;
	}
}