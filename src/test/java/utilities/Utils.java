package utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;

public class Utils {

	
	
	@SuppressWarnings("deprecation")
	public static String randomString() {
		return RandomStringUtils.randomAlphabetic(5);
	}
	
	@SuppressWarnings("deprecation")
	public static String randomNumber() {
		return RandomStringUtils.randomNumeric(10);
	}
	
	@SuppressWarnings("deprecation")
	public static String randomAlphaNumeric() {
		String alphabet = RandomStringUtils.randomAlphabetic(5);
		String numeric= RandomStringUtils.randomNumeric(5);
		return (alphabet+"@"+numeric);
	}
	@SuppressWarnings("deprecation")
	public static String randomEmail() {
		String alphabet = RandomStringUtils.randomAlphabetic(5);
		String numeric= RandomStringUtils.randomNumeric(5);
		return (alphabet+numeric+"@"+"gmail.com");
	}
	
	    
	    public static Properties ReadPropertyFile(String fileLocation) throws IOException {
	    	
	    		FileReader f =new FileReader(fileLocation);
	    		Properties prop = new Properties();
	    		prop.load(f);
			return prop;
	    		
	    }
	    
	
}
