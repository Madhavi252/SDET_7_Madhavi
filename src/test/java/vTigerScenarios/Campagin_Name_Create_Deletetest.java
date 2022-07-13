package vTigerScenarios;

import java.io.IOException;
import java.lang.module.FindException;
import java.time.Duration;

import org.openqa.selenium.Alert;
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
import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import com.mysql.cj.x.protobuf.MysqlxExpect.Open.Condition.Key;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Campagin_Name_Create_Deletetest {

	static WebDriver driver = null;

	public static void main(String[] args) throws InterruptedException, Throwable {

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
		String campname = fakeData.name();
		String name = fakeData.name();

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

		driver.get("http://localhost:8888/index.php?module=Accounts&action=index");
		driver.findElement(By.name("user_name")).sendKeys(uN, Keys.TAB, pW, Keys.ENTER);
		WebElement ele = driver.findElement(By.xpath("//table[@class='hdrTabBg']//tr/td/a[text()='More']"));
		
		driverutility.moveToElement(ele);
		
		driver.findElement(By.xpath("//a[text()='Campaigns']")).click();
		driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();

		//		Faker faker = new Faker();
		//		String name = faker.name().firstName();

		driver.findElement(By.name("campaignname")).sendKeys(campname);
		driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
		//		String name1 = "testyantra";

		Actions act1 = new Actions(driver);
		WebElement ele1 = driver.findElement(By.xpath("//table[@class='hdrTabBg']//tr/td/a[text()='More']"));

		act1.moveToElement(ele1).perform();
		driver.findElement(By.xpath("//a[text()='Campaigns']")).click();
		driver.findElement(By.name("search_text")).click();

		driver.findElement(By.name("search_text")).sendKeys(campname, Keys.TAB);
		WebElement ele2 = driver.findElement(By.xpath("//select[@class='txtBox']"));
		ele2.click();
		Select sel = new Select(ele2);
		sel.selectByVisibleText("Campaign Name");
		driver.findElement(By.name("submit")).click();

		// driver.findElement(By.xpath("//table[@class='lvt
		// small']//tr[3]/td[1]")).click(); wrong approach
		Thread.sleep(3000);
		driver.findElement(By.name("selected_id")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@class='crmbutton small delete'])[1]")).click();

		Thread.sleep(2000);
		Alert alt = driver.switchTo().alert();
		alt.accept();

		System.out.println("************");
		WebElement ele3 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act3 = new Actions(driver);
		act3.moveToElement(ele3).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		driver.close();

	}

}
