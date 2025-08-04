package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends BasePage {

	WebDriver driver;

	public SignUpPage(WebDriver driver) {

		super(driver);
	}
	
	@FindBy(xpath="//a[@title='My Account']")
	WebElement myAccount;
	
	@FindBy(xpath="//a[text()='Register']")
	WebElement registerLink;

	@FindBy(id = "input-firstname")
	WebElement firstName;

	@FindBy(id = "input-lastname")
	WebElement lastName;

	@FindBy(id = "input-email")
	WebElement Email;

	@FindBy(id = "input-password")
	WebElement password;

	@FindBy(id = "input-telephone")
	WebElement Telephone;

	@FindBy(id = "input-confirm")
	WebElement cPassword;

	@FindBy(xpath = "//input[@type='checkbox'][@name='agree']")
	WebElement agree;

	@FindBy(xpath = "//*[@value='Continue']")
	WebElement signUpButton;
	@FindBy(xpath="//a[text()='Logout']")
	WebElement logoutLink;
	
	

	// ✅ action methods
	public void enterFirstName(String fname) {
		firstName.sendKeys(fname);
	}

	public void enterLastName(String lname) {
		lastName.sendKeys(lname);
	}

	public void enterEmail(String email) {
		Email.sendKeys(email);
	}

	public void enterTelephone(String telephone) {
		Telephone.sendKeys(telephone);
	}


	public void enterPassword(String pass) {
		password.sendKeys(pass);
	}

	public void enterConfirmPassword(String cPass) {
		cPassword.sendKeys(cPass);
	}

	public void clickAgreeCheckbox() {
		agree.click();
	}

	public void clickSignUp() {
		signUpButton.click();
	}
	
	
	public void clickRegisterLink() {
		registerLink.click();
	}

	public void clickMyAccount() {
		myAccount.click();
	}
	
	public void clickLogout() {
	 logoutLink.click();
	}
	
	
	
	public void registerUser(String fname,String lname,String email, String mobile,String password) {
		this.clickMyAccount();
		this.clickRegisterLink();
        this.enterFirstName(fname);
        this.enterLastName(lname);
        this.enterEmail(email);
        this.enterTelephone(mobile);
        this.enterPassword(password);
        this.enterConfirmPassword(password);
        this.clickAgreeCheckbox();
        this.clickSignUp();
	}
	
	public void logout() {
		this.clickMyAccount();
		this.clickLogout();
	}
	
	
}
