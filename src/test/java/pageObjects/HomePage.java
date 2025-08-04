package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	WebDriver driver;
	public HomePage(WebDriver driver){
		super(driver);
	}
	
	@FindBy(xpath="//ul[@class=\"nav navbar-nav\"]//a[text()='Tablets']")
	WebElement navbarTablet;
	
	@FindBy(xpath="//a[text()='Samsung Galaxy Tab 10.1']//parent::h4//parent::div//..//..//following-sibling::div[2]//div[@class='button-group']//span[text()='Add to Cart']")
	WebElement addToCart;
	
	@FindBy(xpath="//*[contains(text(),' Success: You have added ')]")
	WebElement successAlert;
	
	public void clickNavbarTablet() {
		navbarTablet.click();
	}
	public void clickAddToCartBtn() {
		addToCart.click();
	}
	
	public boolean isSuccessAlertDisplayed() {
		return successAlert.isDisplayed();
	}
	
	
	
	
	
	
}
