package testCases;

import pageObjects.loginPage;
import utilities.BaseClass;

public class UserLogin extends BaseClass {

	

//	@Test
	public void login() {
		logger.info("************ login Test is STARTED **********");

		loginPage lp = new loginPage(driver);
		lp.login(p.getProperty("email"), p.getProperty("password"));
		lp.logout();
		logger.info("************ login Test is ENDED **********");

	}
	
	
	
}
