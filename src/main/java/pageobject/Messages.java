package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Messages {
 WebDriver driver;
	public Messages(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver, this);
	
	}
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement addtoCardSuccessMessage;
	
	public WebElement addtoCardSuccessMessage() {
		return addtoCardSuccessMessage;
	}
		
	}

