package testCases;

import org.testng.annotations.Test;
import com.github.javafaker.Faker;
import pageObjects.SignUpPage;
import pageObjects.loginPage;
import utilities.BaseClass;
import utilities.Utils;

public class UserRegister extends BaseClass {
	public String email;
	public String password;
	@Test(priority = 1)
	public void registerUser() throws InterruptedException {
		logger.info("************ registerUser Test is STARTED **********");
		Faker fk = new Faker();
		SignUpPage signUp = new SignUpPage(driver);
		email = Utils.randomEmail();
		password = Utils.randomAlphaNumeric();
		signUp.registerUser(
			fk.address().firstName(),
			fk.address().lastName(),
			email,
			Utils.randomNumber(),
			password
		);
		
		signUp.logout();
		logger.info("************ registerUser Test is ENDED **********");

	}

//	@Test(priority = 2)
//	public void login() throws InterruptedException {
//		logger.info("************ login Test is STARTED **********");
//
//		loginPage lp = new loginPage(driver);
//		System.out.println("email :"+email+"password : "+password);
//		lp.login(email, password);
//		lp.logout();
//		logger.info("************ login Test is ENDED **********");
//
//	}


}






























//package testCases;
//
//import org.openqa.selenium.WebDriver;
//import org.testng.annotations.Parameters;
//import org.testng.annotations.Test;
//
//import com.github.javafaker.Faker;
//import pageObjects.SignUpPage;
//import pageObjects.loginPage;
//import utilities.BrowserFactory;
//
//public class UserRegister {
//	WebDriver driver;
//	public String email;
//	public String password;
//	
//	@Parameters({"registerURL","browser"})
//	@Test(priority=1)
//	public void registerUser(String url,String browser) throws InterruptedException {
//		driver = BrowserFactory.openBrowser(browser,url);
//        Faker fk = new Faker();
//        SignUpPage signUp = new SignUpPage(driver);
//        email =fk.address().firstName()+".doe@example.com" ;
//        password = "Test@123";
//        signUp.registerUser(fk.address().firstName(),fk.address().lastName(),email,"9206262015",password);
//
//        BrowserFactory.closeBrowser();
//
//	}
//	
//	@Parameters({"loginURL","browser"})
//	@Test(priority=2)
//	public void login(String url,String browser) throws InterruptedException {
//		driver = BrowserFactory.openBrowser(browser,url);
//        loginPage lp =new loginPage(driver);
//        lp.login(email,password);
//  
//        BrowserFactory.closeBrowser();
//        
//	}
//	
//	
//	
//	
//	
//}
