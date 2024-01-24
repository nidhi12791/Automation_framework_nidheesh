
package genericUTilities;
import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class provides implementation to ITestListener Interface of TestNG
 * @author nidheesh m
 *
 */
public class ListenersImplementation implements ITestListener{
	
	ExtentReports report;
	ExtentTest test;
	public void onTestStart(ITestResult result) {
	//@Test - method
	String methodName = result.getMethod().getMethodName();
				
	System.out.println(methodName +" --- Test Execution started --- ");
	//for Extent Report to recoganise the @Test
	test=report.createTest(methodName)	;		
	
	}

	
public void onTestSuccess(ITestResult result) {
String methodName = result.getMethod().getMethodName();
		
System.out.println(methodName +" --- Test pass --- ");

//for logging the status of test in Extent Reports

test.log(Status.PASS, methodName +" --- Test pass --- ");
}

	
public void onTestFailure(ITestResult result) {
String methodName = result.getMethod().getMethodName();
		
System.out.println(methodName +" --- Test Fail --- ");
System.out.println(result.getThrowable());//getThrowable()-it help to  print the exception

//for logging the status of test in Extent Reports
test.log(Status.FAIL, methodName +" --- Test Fail --- ");
test.log(Status.INFO, result.getThrowable());
//capture screenshot
SeleniumUTility s=new SeleniumUTility();
JavaUTility j=new JavaUTility();
String screenshotName = methodName+"-"+j.getSystemDate();	
try {
String path=	s.captureScreenShot(BaseClass.sdriver, screenshotName);
test.addScreenCaptureFromPath(path);
	
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}


public void onTestSkipped(ITestResult result) {
String methodName = result.getMethod().getMethodName();
		
System.out.println(methodName +" --- Test Skip --- ");	
System.out.println(result.getThrowable());//getThrowable()-it help to  print the exception

//for logging the status of test in Extent Reports
test.log(Status.SKIP, methodName +" --- Test Skip --- ");
test.log(Status.INFO, result.getThrowable());
}


public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
}


public void onTestFailedWithTimeout(ITestResult result) {
		
}


public void onStart(ITestContext context) {
System.out.println("--- suite execution started ---");
		
ExtentSparkReporter htmlrep = new ExtentSparkReporter(".\\ExtentReports\\Report-"+new JavaUTility().getSystemDate()+".html");
htmlrep.config().setDocumentTitle("Execution Report");
htmlrep.config().setReportName("Vtiger Report");
htmlrep.config().setTheme(Theme.DARK);
		
report = new ExtentReports();
report.attachReporter(htmlrep);

report.setSystemInfo("Base Browser", "Edge");
report.setSystemInfo("Base Platform", "Windows");
report.setSystemInfo("Base Env", "Test Env");
report.setSystemInfo("Base URL", "http://localhost:8888");
report.setSystemInfo("Reporter Name", "Chaitra");
		
		
}


public void onFinish(ITestContext context) {
System.out.println("--- suite execution finished ---");
		
report.flush();
		
}
}
