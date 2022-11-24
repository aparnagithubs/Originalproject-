package vTigerGenericLibrary;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * this class will provide implementation to all the abstract methods in ITestListener 
 * @author Family
 *
 */

public class ListenerImplemantationLibrary implements ITestListener  {
	ExtentReports report;
	ExtentTest test;
	

	public void onTestStart(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		//Reporter.log("test execution started;;" +MethodName, true);
		test=report.createTest(MethodName);//test script execution is started in report
		test.log(Status.INFO, "test executionstarted raa");
		
		System.out.println("test execution started aparna " +MethodName);
	}

	public void onTestSuccess(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		System.out.println("test is successful aparna" +MethodName);
		test.log(Status.PASS,MethodName+"-> pass");
	}

	public void onTestFailure(ITestResult result) //fail
	{
		WebDriverLibrary wLib= new WebDriverLibrary();
		JavaLibrary jLib=new JavaLibrary();
		
		String MethodName = result.getMethod().getMethodName()+jLib.getSystemDateInFormat();
		//System.out.println("test is failed aparna" +MethodName);
        test.log(Status.FAIL,"failed");
        test.log(Status.FAIL, result.getThrowable());
		try
		{
			String path=wLib.takeScreenShot(BaseClass.sDriver, MethodName);//driver gets refreshed at times so we r saving in sdriver
		    test.addScreenCaptureFromPath(path);
		}
	    catch(IOException e)
		{
	    	e.printStackTrace();	
	    		
		}	
	}

	public void onTestSkipped(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		//System.out.println("testis skipped aparna" +MethodName);
		test.log(Status.SKIP, MethodName+"-> skipped");
		test.log(Status.SKIP, result.getThrowable());
		
		
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
			}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		Reporter.log("Execution of suite started", true);
		ExtentSparkReporter htmlReport= new ExtentSparkReporter(".\\ExtentReports\\Report-"+new JavaLibrary().getSystemDateInFormat()+".html");
		htmlReport.config().setDocumentTitle("Execution reports for vTiger");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setReportName("vtiger execution reports aparna");
		
		//attach the report to  extent reports
		ExtentReports report= new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("BaseBrowser", "Chrome");
		report.setSystemInfo("BaseEnvironment","Testing");
		report.setSystemInfo("BaseUrl","http://localhost:8888");
		report.setSystemInfo("Base Platform","windows");
		report.setSystemInfo("Reporter Name ","Aparnaaaa");
	}

	public void onFinish(ITestContext context) {
		Reporter.log("Execution of suite finished",true);
		//flush the report.here the execution is finished
		report.flush();
	}
}
