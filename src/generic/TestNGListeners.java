package generic;

import org.openqa.selenium.WebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class TestNGListeners implements ISuiteListener, ITestListener{

	public WebDriver driver;
	ITestContext testblock;
	
	@Override
	public void onStart(ISuite suite) {
		//code to connect to database
		Reporter.log(suite.getName() +" : is started here....", true);
		
		
	}
	@Override
	public void onFinish(ISuite suite) {
		//code to flush put the data
		Reporter.log(suite.getName() + ": is finished here....", true);
		
	}
	
	@Override
	public void onFinish(ITestContext testblock) {
		Reporter.log(testblock.getName() + " ==> Test block finished here..", true);
		
	}
	@Override
	public void onStart(ITestContext testblock) {
		Reporter.log(testblock.getName() + " ==> Test block started here..", true);
		
	}
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onTestFailure(ITestResult res) {
	//	Lib.captureScreenshots(driver, res.getName());
		Reporter.log(res.getName() + " --> test method is Failed..", true);
	}
	@Override
	public void onTestSkipped(ITestResult res) {
		Reporter.log(res.getName() + " --> test method is Skipped..", true);
		
	}
	@Override
	public void onTestStart(ITestResult res) {
		Reporter.log(res.getName() +" of "+ this.testblock.getName() + " --> test method is started..", true);
	}
	@Override
	public void onTestSuccess(ITestResult res) {
		Reporter.log(res.getName() + " --> test method is Pass..", true);
		
	}

	

}
