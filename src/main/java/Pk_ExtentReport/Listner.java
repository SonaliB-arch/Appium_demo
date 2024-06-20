package Pk_ExtentReport;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
	
	


//Listener is defined as interface that modifies the default TestNG's behavior. 
//As the name suggests Listeners "listen" to the event defined in the selenium script
//and behave accordingly. It is used in selenium by implementing Listeners Interface.
//It allows customizing TestNG reports or logs
public class Listner implements ITestListener {
	ExtentReports extent = ExtentReportBase.ExtentReportGenerator();
	ExtentTest test;
	//This is the concept of ThreadSafe
	// make it private static, so no other class will have access and when you are dealing with ThreadSafe, its good to have private
	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	public void onFinish(ITestContext context) {
		extent.flush();
	}

	public void onStart(ITestContext context) {
		
	}

	public void onTestFailure(ITestResult result) {
		extentTest.get().fail(result.getThrowable());
		
	}

	public void onTestSkipped(ITestResult result) {

	}

	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	}

	public void onTestSuccess(ITestResult result) {
		extentTest.get().log(Status.PASS, "Test Successful");
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}}


