package ecommerce.Tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import eCommerce.PageObjects.CartPage;
import eCommerce.PageObjects.CheckOutPage;
import eCommerce.PageObjects.ConfirmationPage;
import eCommerce.PageObjects.ProductCatalogue;
import ecommerce.Tests.TestComponents.BaseTest;

public class SubmitOrderTest extends BaseTest {
	@Test
	public void submitOrder() throws InterruptedException, IOException {

		String productName = "ADIDAS ORIGINAL";
		ProductCatalogue productCatalogue = landingP.loginApplication("sele123@gmail.com", "Test@123");
		List<WebElement> products = productCatalogue.getProductList();
		products.stream().forEach(s->System.out.println(s));
		productCatalogue.addToCart(productName);
		CartPage cartPage = productCatalogue.goToCartPage();
		Boolean match = cartPage.verifyProductDisplay(productName);
		Assert.assertTrue(match);
		CheckOutPage checkoutPage = cartPage.goToCheckOut();
		ConfirmationPage confirmationPage = checkoutPage.nationList();	
		String confirmMessage = confirmationPage.confirmOrder();
		Assert.assertEquals(confirmMessage, "THANKYOU FOR THE ORDER.");
		
	}
}
