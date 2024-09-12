package eCommerce.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import eCommerce.AbstractComponents.AbstractComponent;

public class ProductCatalogue extends AbstractComponent {
	WebDriver driver;

	public ProductCatalogue(WebDriver driver) {// constructor to inherit driver
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// List<WebElement> products = driver.findElements(By.cssSelector(".mb-3 b"));
	@FindBy(css = ".mb-3 b")
	List<WebElement> products;
	
	By load = By.cssSelector(".toast-container");
	
	//driver.findElement(By.cssSelector(".mb-3"));
	@FindBy (css=".mb-3") 
	WebElement prodList;
	
	By addToCart = By.xpath("parent::h5/following-sibling::button[2]");
	
	By tostContainer = By.cssSelector(".toast-container");
	
	//driver.findElement(By.cssSelector(".ng-animating");
	@FindBy (css=".ng-animating")
	WebElement animation;
	
	public List<WebElement> getProductList() {
		
		elementDisApper(load);
		webElementToBeVisible(prodList);

		return products;
		
	}
	
	public WebElement getProductByName(String productName) {
		WebElement prod = products.stream()
				.filter(p->p.getText().equalsIgnoreCase(productName)).findFirst().orElse(null);
		
		return prod;
	}
	
	public void addToCart(String productName) {
		WebElement prods = getProductByName(productName);
		prods.findElement(addToCart).click();
		elementToBeVisible(tostContainer);
		webElementToBeDisApper(animation);
	}
	

}
