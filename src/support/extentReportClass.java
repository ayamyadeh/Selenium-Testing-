package support;

import org.testng.ITestContext;
import org.testng.ITestListener;  
  import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extentReportClass implements ITestListener {
	public static ExtentReports extentReport = new ExtentReports();
	public static ExtentSparkReporter htmlReporter = new ExtentSparkReporter("reports/index.html");
	 public static ExtentTest extentTest ;    
    public void onTestStart(ITestResult result) {  
		extentReport.attachReporter(htmlReporter);
		
	}  

	public void onTestSuccess(ITestResult result) {  
		//extentTest.pass("All Steps are Passed");
		extentTest.log(Status.PASS ,"All Steps are Passed");
	} 

	public void onTestFailure(ITestResult result){  
		extentTest.log(Status.FAIL, "Test Fail");
	}  

	public void onFinish(ITestContext context) {  
    extentTest.log(Status.INFO, "Test Done");
		extentReport.flush();
	}  
   
    
}
