package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import utilities.BaseClass;

public class AddToCartProduct extends BaseClass {

	

	@Test
	public void addToCart() throws InterruptedException {
		logger.info("************ login Test is STARTED **********");

		HomePage hp = new HomePage(driver);
		hp.clickNavbarTablet();
		hp.clickAddToCartBtn();
		boolean isdisplayed= hp.isSuccessAlertDisplayed();
		Thread.sleep(5000);

		Assert.assertEquals(isdisplayed, true);
		logger.info("************ login Test is ENDED **********");

	}
	
	
	
}
