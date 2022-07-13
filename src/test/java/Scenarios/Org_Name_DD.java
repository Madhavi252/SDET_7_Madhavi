package Scenarios;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.VTIGER.generic.FakeData;
import com.VTIGER.generic.PropertyFile;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Org_Name_DD {
	
	static WebDriver driver = null;

@Test
public void Orgname_DD() throws Throwable {
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
	String orgname = fakeData.name();
	
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


	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("http://localhost:8888/index.php?module=Accounts&action=index");
	driver.findElement(By.name("user_name")).sendKeys(uN, Keys.TAB, pW, Keys.ENTER);
	driver.findElement(By.xpath("//td[@class='tabSelected']")).click();
	driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

	driver.findElement(By.name("accountname")).sendKeys(orgname);
	System.out.println(orgname);
	Thread.sleep(5000);
	
	WebElement industryDD = driver.findElement(By.name("industry"));
	Thread.sleep(5000);
	WebElement typeDD = driver.findElement(By.name("accounttype"));
	Thread.sleep(5000);
	WebElement ratingDD = driver.findElement(By.name("rating"));
	Thread.sleep(5000);
	 
	
	Select select_industry = new Select(industryDD);
	Thread.sleep(5000);
	Select select_type = new Select(typeDD);
	Thread.sleep(5000);
	Select select_rating = new Select(ratingDD);
	Thread.sleep(5000);
	
	
	select_industry.selectByIndex(3);
	Thread.sleep(5000);
	select_type.selectByValue("3");
	Thread.sleep(5000);
	select_rating.selectByVisibleText("Active");
	
	
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]'] ")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//td[@class='tabSelected']")).click();
	driver.findElement(By.name("search_text")).click();
	Thread.sleep(2000);
	driver.findElement(By.name("search_text")).sendKeys(orgname, Keys.TAB);
	System.out.println(orgname);
	WebElement ele2 = driver.findElement(By.id("basicsearchcolumns_real"));
	ele2.click();
	driver.findElement(By.xpath("//option[text()='Organization Name']")).click();
	driver.findElement(By.name("submit")).click();
	 
	
	
}


}
