package eCommerce.PageObjects;

import java.util.List;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import eCommerce.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent {

	WebDriver driver;

	public CartPage(WebDriver driver) {// constructor to inherit driver
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".cartSection h3")
	List<WebElement> cardList;

	@FindBy(css = ".totalRow button")
	WebElement checkoutBotton;

	public Boolean verifyProductDisplay(String productName) {
		Boolean match = cardList.stream().anyMatch(cart -> cart.getText().equalsIgnoreCase(productName));
		return match;
	}

	public CheckOutPage goToCheckOut() {
		checkoutBotton.click();
		return new CheckOutPage(driver); 
	}
}
