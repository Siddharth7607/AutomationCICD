package eCommerce.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import eCommerce.AbstractComponents.AbstractComponent;

public class ConfirmationPage extends AbstractComponent{
WebDriver driver;
	
	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = ".hero-primary")
	WebElement confirmMessage;
	
	
	public String confirmOrder() {
		System.out.println(confirmMessage.getText());
		return confirmMessage.getText();
		
	}
	
}
