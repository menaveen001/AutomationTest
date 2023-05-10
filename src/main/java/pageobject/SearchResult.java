package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResult {

	WebDriver driver;
	
	public SearchResult(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(linkText = "iPhone")
	private WebElement iphoneIsDisplay;
	
	@FindBy(linkText = "iMac")
	private WebElement iMack;
	public WebElement iphoneIsDisplay() {

		return iphoneIsDisplay;
	}
	
	public WebElement iMac() {
		return iMack;
	}
}