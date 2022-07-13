package practiceprograms;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Reports {
	
	//used for giving path, title, name to the screenshot, colour
	
	ExtentSparkReporter reporter;
	
	ExtentReports reports;
	
	ExtentTest test;

	@Test
	public void reportCreation() throws IOException{
		
		reporter = new ExtentSparkReporter("../SDET7_MADHAVI/sdet7/fb1.html");
		
		reporter.config().setDocumentTitle("Facebook");
		
		reporter.config().setTheme(Theme.STANDARD);
		
		
		reports = new ExtentReports();
		
		reports.attachReporter(reporter);
		
		reports.setSystemInfo("application version", "5.0.9");
		
		reports.setSystemInfo("browser", "chrome");
		
		reports.setSystemInfo("env", "qa");
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.facebook.com");
		
		Assert.assertFalse(true);
		
		test = reports.createTest("facebook123");
		
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		String path = "../SDET7/screenshots/Facebook12 .png";
		
		//String path = "/SDET7_MADHAVI/sdet7.png";
		
		File dest = new File(path);
		FileUtils.copyFile(src, dest);
		
		
		test.addScreenCaptureFromPath(path);
		
		
		reports.flush();
		
		
	
	}

}










