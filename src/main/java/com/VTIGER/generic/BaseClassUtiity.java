   package com.VTIGER.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.Object.Resource.HomePage;
import com.Object.Resource.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClassUtiity {

	public WebDriver driver;
	PropertyFile propertyFile = new PropertyFile();

	@BeforeSuite
	//connect to database
	public void connectDataBase() {
		System.out.println("========DataBase connected==========");
	}


	@BeforeClass
	//Launch browser and connect to url
	public void lanuchBrowser() throws Throwable {

		String browser= propertyFile.readDatafromPropfile("browser");

		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else {
			System.out.println("browser not found");
		}
		driver.get(propertyFile.readDatafromPropfile("url"));

		WebDriverUtility webDriverUtility = new WebDriverUtility(driver);
		webDriverUtility.pagewait();
		webDriverUtility.maximizewindow();
	}


	@BeforeMethod
	//login to application
	public void loginPage() throws Throwable {

		LoginPage loginPage = new LoginPage(driver);
		loginPage.getUsernametextbox().sendKeys(propertyFile.readDatafromPropfile("username"));
		loginPage.getPasswordtextbox().sendKeys(propertyFile.readDatafromPropfile("password"));
		loginPage.getLoginbtn().click();
		
	}


	@AfterMethod
	//logout to application
	public void logoutPage() throws InterruptedException{
		
		WebDriverUtility driverUtility = new WebDriverUtility(driver);
		HomePage homePage = new HomePage(driver);
		Thread.sleep(2000);
		driverUtility.moveToElement(homePage.getSignoutimg());
		Thread.sleep(7000);
		driverUtility.moveToElement(homePage.getSignoutlink());
		Thread.sleep(2000);
		
		
	}


	@AfterClass
	//close browser
	public void closeBrowser() {
		driver.close();
	}


	@AfterSuite
	//close connection to database
	public void closeConnectDataBase() {
		System.out.println("-----connection with database closed----");
	}

}












