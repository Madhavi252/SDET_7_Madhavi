package vTigerScenarios;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.Object.Resource.CreateOrgPage;
import com.Object.Resource.HomePage;
import com.Object.Resource.OrganizationInfoPage;
import com.VTIGER.generic.BaseClassUtiity;
import com.VTIGER.generic.FakeData;
import com.VTIGER.generic.PropertyFile;
import com.VTIGER.generic.WebDriverUtility;
import com.fasterxml.jackson.databind.deser.Deserializers.Base;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Org_Name_Create_Deletetest extends BaseClassUtiity{

	@Test

	public void deleteOrgName() throws Throwable {
	
		FakeData fakeData = new FakeData();
		String orgname = fakeData.name();		

		HomePage homepage = new HomePage(driver);
		homepage.getOrglinkbtn().click();

		OrganizationInfoPage organizationInfoPage = new OrganizationInfoPage(driver);
		organizationInfoPage.getCreateorglinkbtn().click();

		CreateOrgPage createOrgPage = new CreateOrgPage(driver);
		
		WebDriverUtility driverUtility = new WebDriverUtility(driver);

		Thread.sleep(5000);
		createOrgPage.getOrgNametextbox().sendKeys(orgname);
		System.out.println(orgname);
		Thread.sleep(2000);
		createOrgPage.getSavebtn().click();

		Thread.sleep(5000);
		homepage.getOrglinkbtn().click();
		Thread.sleep(2000);
		organizationInfoPage.getSearchorgtxtbox().click();
		Thread.sleep(2000);
		organizationInfoPage.getSearchorgtxtbox().sendKeys(orgname,Keys.TAB);
		System.out.println(orgname);
		Thread.sleep(2000);
		organizationInfoPage.getSearchorgtypeDD().click();
		
		driverUtility.selectDD("Organization Name", organizationInfoPage.getSearchorgtypeDD());
		organizationInfoPage.searchorgbtn.click();
		Thread.sleep(5000);
		
		organizationInfoPage.getCheckBox().click();
		organizationInfoPage.getDeletebtn().click();
		
		driverUtility.acceptAlert();
		
	}
}

//		PropertyFile propertyFile = new PropertyFile();
//		String url = propertyFile.readDatafromPropfile("url");
//		System.out.println(url);
//		String browser = propertyFile.readDatafromPropfile("browser");
//		System.out.println(browser);
//		String uN = propertyFile.readDatafromPropfile("username");
//		System.out.println(uN);
//		String pW = propertyFile.readDatafromPropfile("password");
//		System.out.println(pW);
//
//		FakeData fakeData = new FakeData();
//		String orgname = fakeData.name();
//
//		if(browser.equalsIgnoreCase("chrome")) {
//
//			WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver();
//
//		}
//
//		else if(browser.equalsIgnoreCase("firefox")) {
//
//			WebDriverManager.firefoxdriver().setup();
//			driver = new FirefoxDriver();
//		}
//
//		else {
//
//			System.out.println("browser not found");
//		}
//
//		WebDriverUtility driverutility = new WebDriverUtility(driver);
//
//		driverutility.pagewait();
//
//		driverutility.maximizewindow();
//
//		driver.get(url);
//		driver.findElement(By.name("user_name")).sendKeys(uN, Keys.TAB, pW, Keys.ENTER);
//		driver.findElement(By.xpath("//td[@class='tabSelected']")).click();
//		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
//
//		driver.findElement(By.name("accountname")).sendKeys(orgname);
//		System.out.println(orgname);
//		driver.findElement(By.xpath("//input[@title='Save [Alt+S]'] ")).click();
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//td[@class='tabSelected']")).click();
//		driver.findElement(By.name("search_text")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.name("search_text")).sendKeys(orgname, Keys.TAB);
//		System.out.println(orgname);
//		WebElement ele2 = driver.findElement(By.id("basicsearchcolumns_real"));
//		ele2.click();
//		driver.findElement(By.xpath("//option[text()='Organization Name']")).click();
//		
//		//		Select sel = new Select(ele2);
//		//		sel.selectByVisibleText("Organization Name");
//		
//		driver.findElement(By.name("submit")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.name("selected_id")).click();
//		driver.findElement(By.xpath("//input[@class='crmbutton small delete']")).click();
//		
//		driverutility.acceptAlert();
//
//		Thread.sleep(2000);
//
//		boolean str = driver.findElement(By.xpath("//span[normalize-space()='No Organization Found !']")).isDisplayed();
//		
//		if(str==true) {
//
//			System.out.println("Organization deleted");
//		}
//
//		else
//			System.out.println("Organization  not deleted");
//
//
//		System.out.println("***************");
//
//
//		//logout
//
//		WebElement ele3 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
//		
//		driverutility.moveToElement(ele3);
//		
//		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
//
//		driverutility.closeBrowser();
//
//	}
//
//}
