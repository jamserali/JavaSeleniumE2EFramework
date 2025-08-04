package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPage extends BasePage{
	WebDriver driver;
	public loginPage(WebDriver driver){
		super(driver);
	}
	@FindBy(id = "input-email")
	WebElement emailLoc;
	
	@FindBy(id = "input-password")
	WebElement passwordLoc;
	
	@FindBy(xpath = "//*[@value='Login']")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[@title='My Account']")
	WebElement myAccount;
	@FindBy(xpath="//a[text()='Login']")
	WebElement loginLink;
	@FindBy(xpath="//a[text()='Logout']")
	WebElement logoutLink;
	
	
	public void enterEmail(String email) {
		emailLoc.sendKeys(email);
	}

	public void enterPassword(String password) {
		passwordLoc.sendKeys(password);
	}

	public void clickLoginButton() {
		loginBtn.click();
	}
	public void clickMyAccount() {
		myAccount.click();
	}
	public void clickLoginLink() {
		loginLink.click();
	}
	
	public void clickLogout() {
		logoutLink.click();
	}
	
	public void login(String email, String password) {
		this.clickMyAccount();
		this.clickLoginLink();
		this.enterEmail(email);
	    this.enterPassword(password);
	    this.clickLoginButton();
	    
	}
	public void logout() {
		this.clickMyAccount();
		this.clickLogout();
	}
	
	
	
	
	
	
	
	
	
}
