package api.utilities;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;



public class ExtentReporterNG implements ITestListener
{
	public ExtentSparkReporter  sparkReporter ;
	public ExtentReports extents;
	public ExtentTest test;
	String repName;
	public void onStart(ITestContext testcontext)
	{
		String timestamp=new SimpleDateFormat("yyyy.mm.dd.HH.mm.ss")
				.format(new Date());
				repName="Test-Report-"+timestamp+".htmal";
	sparkReporter=new ExtentSparkReporter(".\\reports\\"+repName);
	sparkReporter.config().setDocumentTitle("RestAssured AutomationProject");
	sparkReporter.config().setReportName("Pet store user Api");	
	sparkReporter.config().setTheme(Theme.DARK);
	extents=new ExtentReports();
	extents.attachReporter(sparkReporter);
	extents.setSystemInfo("Application", "Pet store user Api");
	//extents.setSystemInfo("", timestamp);
	//extents.set
	}
	public void onTestSuccess(ITestResult result)
	{
		test=extents.createTest(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.createNode(result.getName());
		test.log(Status.PASS, "Test Passed");
		
		} 
	
	public void onTestFailure(ITestResult result)
	{
		test=extents.createTest(result.getName());
		test.createNode(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.FAIL, "Test Failed");
		test.log(Status.FAIL,result.getThrowable().getMessage());
			
	}
	
	public void onTestSkipped(ITestResult result)
	{
		test=extents.createTest(result.getName());
		test.createNode(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, "Test Skipped");
		test.log(Status.SKIP,result.getThrowable().getMessage());
			
	}
	
	public void onFinish(ITestContext testcontext)
	
	{
		extents.flush();
	}
	
	
	
}