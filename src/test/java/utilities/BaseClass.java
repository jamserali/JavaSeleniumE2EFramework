package utilities;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import pageObjects.loginPage;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
public class BaseClass {
	protected WebDriver driver;
    public  Logger logger; 
    public Properties p;
    public DesiredCapabilities cap;
       

//	@SuppressWarnings("deprecation")
//	public  WebDriver openBrowser(String os,String br) throws IOException {
//		p=Utils.ReadPropertyFile("src/test/resources/config.properties");
//    	 	logger = LogManager.getLogger(this.getClass());
//    	 	
//    	 	if(p.getProperty("execution_env").equalsIgnoreCase("remote")) {
//    	 		cap = new DesiredCapabilities();
//    	 		if(os.equalsIgnoreCase("windows")) {
//    	 			cap.setPlatform(Platform.WIN11);
//    	 		}
//    	 		else if(os.equalsIgnoreCase("linux")) {
//    	 			cap.setPlatform(Platform.LINUX);
//    	 		}
//    	 		else if(os.equalsIgnoreCase("mac")) {
//    	 			cap.setPlatform(Platform.MAC);
//    	 		}else {
//    	 			System.out.println("No matching OS Found...");
//    	 		}
//    	 		
//    	 		
//    	 		
//    	 	}
//    	 	
//		ChromeOptions option =new ChromeOptions();
//		FirefoxOptions firefoxoption =new FirefoxOptions();
//		firefoxoption.addArguments("--headless");
//		option.addArguments("--headless");
//        if (br.equalsIgnoreCase("chrome")) {
//            driver = new ChromeDriver(option);
//        } else if (br.equalsIgnoreCase("firefox")) {
//            driver = new FirefoxDriver(firefoxoption);
//        } else if (br.equalsIgnoreCase("edge")) {
//            driver = new EdgeDriver();
//        } else {
//            System.out.println("Please select correct browser...");
//            return null;
//        }
//        driver = new RemoteWebDriver(new URL("https://localhost:4444/wd/hub"),cap);
//    	 	
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.get(p.getProperty("baseURL"));
//        loginPage lp = new loginPage(driver);
//		lp.login(p.getProperty("email"), p.getProperty("password"));
//        return driver;
//    }

    
    @SuppressWarnings("deprecation")
	public WebDriver openBrowser(String os, String br) throws IOException {
        p = Utils.ReadPropertyFile("src/test/resources/config.properties");
        logger = LogManager.getLogger(this.getClass());

        String env = p.getProperty("execution_env").trim().toLowerCase();

        // Browser Options
        ChromeOptions chromeOptions = new ChromeOptions();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        EdgeOptions edgeOptions = new EdgeOptions();

//        chromeOptions.addArguments("--headless=new");
        firefoxOptions.addArguments("--headless");

        if (env.equals("remote")) {
            DesiredCapabilities capabilities = new DesiredCapabilities();

            // Set platform
            switch (os.toLowerCase()) {
                case "windows":
                    capabilities.setPlatform(Platform.WIN11);
                    break;
                case "linux":
                    capabilities.setPlatform(Platform.LINUX);
                    break;
                case "mac":
                    capabilities.setPlatform(Platform.MAC);
                    break;
                default:
                    System.out.println("No matching OS Found...");
                    return null;
            }

            // Set browser capabilities
            switch (br.toLowerCase()) {
                case "chrome":
                    capabilities.setBrowserName("chrome");
                    chromeOptions.merge(capabilities);
                    driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeOptions);
                    break;
                case "firefox":
                    capabilities.setBrowserName("firefox");
                    firefoxOptions.merge(capabilities);
                    driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), firefoxOptions);
                    break;
                case "edge":
                    capabilities.setBrowserName("MicrosoftEdge");
                    edgeOptions.merge(capabilities);
                    driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), edgeOptions);
                    break;
                default:
                    System.out.println("Please select correct browser...");
                    return null;
            }

        } else if (env.equals("local")) {
            switch (br.toLowerCase()) {
                case "chrome":
                    driver = new ChromeDriver(chromeOptions);
                    break;
                case "firefox":
                    driver = new FirefoxDriver(firefoxOptions);
                    break;
                case "edge":
                    driver = new EdgeDriver(edgeOptions);
                    break;
                default:
                    System.out.println("Please select correct browser...");
                    return null;
            }
        } else {
            System.out.println("Invalid execution environment in config file.");
            return null;
        }

        // Common post-init
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(p.getProperty("baseURL"));

        loginPage lp = new loginPage(driver);
        lp.login(p.getProperty("email"), p.getProperty("password"));

        return driver;
    }

	
	@Parameters({"os","browser"})
	@BeforeClass
	public void setup(String os,String browser) throws IOException {
		openBrowser(os,browser);
	}

	@AfterClass
    public void closeBrowser() {
        loginPage lp = new loginPage(driver);
		lp.logout();

        if (driver != null) {
            driver.quit();
        }
    }
	
}
