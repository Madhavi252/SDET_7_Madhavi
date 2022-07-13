package Scenarios;

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

import com.VTIGER.generic.FakeData;
import com.VTIGER.generic.PropertyFile;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Org_Name_Create_Delete {
	
	static WebDriver driver = null;

	public static void main(String[] args) throws Throwable {
		
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
//		Select sel = new Select(ele2);
//		sel.selectByVisibleText("Organization Name");
		driver.findElement(By.name("submit")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("selected_id")).click();
		driver.findElement(By.xpath("//input[@class='crmbutton small delete']")).click();
		Alert alt = driver.switchTo().alert();
		alt.accept();
		
		Thread.sleep(2000);
		
		boolean str = driver.findElement(By.xpath("//span[normalize-space()='No Organization Found !']")).isDisplayed();
		if(str==true) {
			
			System.out.println("Organization deleted");
		}
		
		else
			System.out.println("Organization  not deleted");
		
		 
		 System.out.println("***************");
		
		
		//logout
		
		WebElement ele3 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act3 = new Actions(driver);
		act3.moveToElement(ele3).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
		driver.close();

	}

}
