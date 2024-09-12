package eCommerce.PageObjects;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import eCommerce.AbstractComponents.AbstractComponent;

public class CheckOutPage extends AbstractComponent{
	
	WebDriver driver;
	
	public CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = ".form-group input")
	WebElement countryInput;
	
	@FindBy(css = ".ta-results button")
	List<WebElement> nations;
	 
	@FindBy(xpath = "//a[contains(text(),'Place Order')]")
	WebElement orderButton;
	
	@FindBy(css = ".action__submit")
	WebElement submitButton;
	
	
	
	public ConfirmationPage nationList() {
		countryInput.sendKeys("india");
		nations.stream().filter(n->n.getText().equalsIgnoreCase("India")).iterator().next().click();
		webElementToBeClickable(orderButton);
		submitButton.click();
		return new ConfirmationPage(driver);
	}
	
}

