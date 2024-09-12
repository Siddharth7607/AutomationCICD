package ecommerce.Tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import eCommerce.PageObjects.CartPage;
import eCommerce.PageObjects.ProductCatalogue;
import ecommerce.Tests.TestComponents.BaseTest;

public class ErrorValidation extends BaseTest {
	@Test
	public void loginErrorValidation() throws InterruptedException, IOException {

		landingP.loginApplication("sele123@gmdfail.com", "Test@123");
		System.out.println(landingP.errorValidation());
		Assert.assertEquals("Incorrect email or password.",landingP.errorValidation());
		
	}
	
	@Test(enabled = false)
	public void productErrorValidation() {

			String productName = "ADIDAS ORIGINAL";
			ProductCatalogue productCatalogue = landingP.loginApplication("sele123@gmail.com", "Test@123");
			List<WebElement> products = productCatalogue.getProductList();
			products.stream().forEach(s->System.out.println(s));
			productCatalogue.addToCart(productName);
			CartPage cartPage = productCatalogue.goToCartPage();
			Boolean match = cartPage.verifyProductDisplay("ABIBAS ORIGINAL");
			Assert.assertFalse(match);
		}
	}

