package ecommerce.Tests;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import eCommerce.PageObjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {
	@Test
	public void mainTest() throws InterruptedException {

		String productName = "ADIDAS ORIGINAL";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client/");
		
		
		driver.findElement(By.cssSelector("#userEmail")).sendKeys("sele123@gmail.com");
		driver.findElement(By.cssSelector("#userPassword")).sendKeys("Test@123");
		driver.findElement(By.cssSelector("#login")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".toast-container")));
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".mb-3"))));
		
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3 b"));
	
		products.stream().forEach(s->System.out.println(s));
		
		WebElement prod = products.stream()
				.filter(p->p.getText().equalsIgnoreCase(productName)).findFirst().orElse(null);
		
		prod.findElement(By.xpath("parent::h5/following-sibling::button[2]")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".toast-container")));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		
		driver.findElement(By.cssSelector(".fa-shopping-cart")).click();
		
		
		List<WebElement> cardList = driver.findElements(By.cssSelector(".cartSection h3"));
		
		
		
		Boolean match = cardList.stream().anyMatch(cart->cart.getText().equalsIgnoreCase(productName));
		Assert.assertTrue(match);
		
		driver.findElement(By.cssSelector(".totalRow button")).click();
		
		driver.findElement(By.cssSelector(".form-group input")).sendKeys("india");
		
		List<WebElement> nations = driver.findElements(By.cssSelector(".ta-results button"));
		
		
		nations.stream().filter(n->n.getText().equalsIgnoreCase("India")).iterator().next().click();
		
		//nations.stream().filter(n->n.getText().equalsIgnoreCase("India")).findFirst().get().click();
		
//		for (WebElement s : nations) {
//			if(s.getText().equalsIgnoreCase("India")){
//				s.click();
//			}
//		}
		
		wait.until(ExpectedConditions
				.elementToBeClickable(driver.findElement(By.xpath("//a[contains(text(),'Place Order')]"))));

		driver.findElement(By.cssSelector(".action__submit")).click();
	}
}
