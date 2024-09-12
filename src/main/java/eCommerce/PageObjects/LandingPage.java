package eCommerce.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import eCommerce.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent{
	
	WebDriver driver;

	public LandingPage(WebDriver driver) {//constructor to inherit driver
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(css = "[class*='flyInOut']")
	WebElement errorMessage;
		
	public String errorValidation() {
		webElementToBeVisible(errorMessage);
		return errorMessage.getText();
	}
	
	
	// WebElement userEmail = driver.findElement(By.cssSelector("#userEmail"));
	@FindBy(css = "#userEmail")
	WebElement userEmail;

	// driver.findElement(By.cssSelector("#userPassword"));
	@FindBy(css = "#userPassword")
	WebElement password;

	// driver.findElement(By.cssSelector("#login"));
	@FindBy(css = "#login")
	WebElement login;
	
	public ProductCatalogue loginApplication(String email, String pass) 
	{

		userEmail.sendKeys(email);
		password.sendKeys(pass);
		login.click();
		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		return productCatalogue;

	}

	
	public void goTo() 
	{
		driver.get("https://rahulshettyacademy.com/client/");

	}
}
