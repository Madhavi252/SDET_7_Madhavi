package Scenarios;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.VTIGER.generic.FakeData;
import com.VTIGER.generic.PropertyFile;
import com.mysql.cj.x.protobuf.MysqlxExpect.Open.Condition.Key;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Contact_Create_Verify {
	
	static WebDriver driver = null;

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		
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
		String fname = fakeData.firstName();
		String lname = fakeData.lastName();
		
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
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.name("salutationtype")).click();
		driver.findElement(By.xpath("//option[@value='Mrs.']")).click();
		driver.findElement(By.name("firstname")).sendKeys(fname);
		driver.findElement(By.name("lastname")).sendKeys(lname);
		driver.findElement(By.xpath("//img[@title='Select'][1]")).click();
		String mainid = driver.getWindowHandle();
		Set<String> allid = driver.getWindowHandles();
		for (String i : allid) {
			if (!mainid.equals(i))
				driver.switchTo().window(i);
		}
		Thread.sleep(3000);
		WebElement ele = driver.findElement(By.id("search_txt"));
		ele.sendKeys("tt", Keys.ENTER);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@href='javascript:window.close();']")).click();

		// driver.findElement(By.xpath("//a[text()='testyantra1']")).click();

		driver.switchTo().window(mainid);
		driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
		String data = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (data.contains(fname))
			System.out.println("contact saved");
		else
			System.out.println("contact not saved");
		WebElement img = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act = new Actions(driver);
		act.moveToElement(img).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		driver.close();

	}

}
