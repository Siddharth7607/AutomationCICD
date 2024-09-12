package eCommerce.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import eCommerce.PageObjects.CartPage;

public class AbstractComponent {
	WebDriver driver;
	@FindBy(css = ".fa-shopping-cart")
	WebElement cartButton;

	

	public AbstractComponent(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public CartPage goToCartPage() {
		cartButton.click();
		CartPage cartPage = new CartPage(driver);
		return cartPage;
	}

	public void elementDisApper(By load) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(load));

	}

	public void webElementToBeDisApper(WebElement anim) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOf(anim));

	}

	public void webElementToBeVisible(WebElement prods) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(prods));
	}

	public void elementToBeVisible(By toast) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(toast));
	}

	public void webElementToBeClickable(WebElement orderButton) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(orderButton));
	}
}
