package utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class myListener implements ITestListener {
	
	public void onTestStart(ITestResult result) {
		System.out.println("Test execution STARTED...");

	}
	
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test execution SUCCESS...");
		

	    // not implemented
	  }

	public void onTestFailure(ITestResult result) {
		System.out.println("Test execution FAILED...");

	    // not implemented
	  }
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test execution SKIP...");

		    // not implemented
		  }
	  
	public void onFinish(ITestContext context) {
		System.out.println("Test execution FINISHED...");

		    // not implemented
		  }
	

}
