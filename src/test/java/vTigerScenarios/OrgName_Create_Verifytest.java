package vTigerScenarios;

import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.VTIGER.generic.FakeData;
import com.VTIGER.generic.PropertyFile;
import com.VTIGER.generic.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrgName_Create_Verifytest {

	static WebDriver driver = null;

	public static void main(String[] args) throws IOException {

		PropertyFile propertyFile = new PropertyFile();
		String url = propertyFile.readDatafromPropfile("url");
		System.out.println(url);
		String browser = propertyFile.readDatafromPropfile("browser");
		System.out.println(browser);
		String uN = propertyFile.readDatafromPropfile("username");
		System.out.println(uN);
		String pW = propertyFile.readDatafromPropfile("password");
		System.out.println(pW);

		FakeData fakeData = new FakeData();
		String compname = fakeData.industryName();

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

		WebDriverUtility driverutility = new WebDriverUtility(driver);
		
		driverutility.pagewait();
		
		driverutility.maximizewindow();
		

		driver.get(url);

		driver.findElement(By.name("user_name")).sendKeys(uN, Keys.TAB, pW, Keys.ENTER);

		driver.findElement(By.xpath("//td[@class='tabSelected']")).click();

		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

		driver.findElement(By.name("accountname")).sendKeys(compname);

		WebElement ind = driver.findElement(By.name("industry"));

		// driver.findElement(By.xpath("//option[@value='Banking']")).click();

		driverutility.selectDD(ind, 4);

		driver.findElement(By.xpath("(//input[@value='  Save  '])[1]")).click();

		String s = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();

		if (s.contains("testyantra7")) 
		{
			System.out.println("organazation matches");
		} 
		else
		{
			System.out.println("matches not found");
		}

		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));

		driverutility.moveToElement(ele);

		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

		driverutility.closeBrowser();

	}

}


//Select sel = new Select(ind);
//sel.selectByIndex(4);
//Actions act = new Actions(driver);
//act.moveToElement(ele).perform();
//Random ran = new Random(); 
//		int i = ran.nextInt(1000);
