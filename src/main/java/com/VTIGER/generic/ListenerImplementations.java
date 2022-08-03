package com.VTIGER.generic;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.io.Files;

public class ListenerImplementations implements ITestListener  {
	WebDriver driver;
	
	ExtentSparkReporter reporter;
	ExtentReports reports;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		System.out.println("test started");
		test=reports.createTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getMethod().getMethodName()+" Got Pass");
		System.out.println("test success");

	}

	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL,result.getMethod().getMethodName()+" Got Failed" );
		System.out.println("test fail");
		//WebDriverUtility wb= new WebDriverUtility(driver);
		
		
		TakesScreenshot sh = (TakesScreenshot)BaseClassUtiity.sdriver;
		File src = sh.getScreenshotAs(OutputType.FILE);
		String path = IAutoconsts.screenShotFile + result.getMethod().getMethodName()+".png";
		File dest = new File(path);
		try {
			Files.copy(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block  
			e.printStackTrace();
		}	
		test.addScreenCaptureFromPath(path);


	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("test skipped");
		test.log(Status.SKIP,result.getMethod().getMethodName()+" Got Skipped" );

	}

	

	public void onStart(ITestContext context) {

		reporter = new ExtentSparkReporter(IAutoconsts.extendReportFile);
		reporter.config().setTheme(Theme.DARK);
		reporter.config().setDocumentTitle("vtiger app");
		reporter.config().setReportName("CRM Report");

		reports = new ExtentReports();
		reports.attachReporter(reporter);
		reports.setSystemInfo("browser", "chrome");
		reports.setSystemInfo("created by", "Test team"); 		
	}

	public void onFinish(ITestContext context) {

		reports.flush();

	}




}
