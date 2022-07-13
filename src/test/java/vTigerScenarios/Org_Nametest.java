package vTigerScenarios;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.Object.Resource.CreateOrgPage;
import com.Object.Resource.HomePage;
import com.Object.Resource.LoginPage;
import com.Object.Resource.OrganizationInfoPage;
import com.VTIGER.generic.FakeData;
import com.VTIGER.generic.PropertyFile;
import com.VTIGER.generic.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Org_Nametest {

	static WebDriver driver = null; 

	public static void main(String[] args) throws Throwable {

		PropertyFile propertyFile = new PropertyFile();
		String url = propertyFile.readDatafromPropfile("url");
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
		
		WebDriverUtility driverutility = new WebDriverUtility(driver);
		driverutility.pagewait();
		driverutility.maximizewindow();
		
		driver.get(url);
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.getUsernametextbox().sendKeys(uN);
		loginpage.getPasswordtextbox().sendKeys(pW);
		loginpage.getLoginbtn().click();
		
		HomePage homepage = new HomePage(driver);
		homepage.getOrglinkbtn().click();
		
		OrganizationInfoPage organizationInfoPage = new OrganizationInfoPage(driver);
		organizationInfoPage.getCreateorglinkbtn().click();
	
		
		
		CreateOrgPage createOrgPage = new CreateOrgPage(driver);
		
		Thread.sleep(5000);
		createOrgPage.getOrgNametextbox().sendKeys(orgname);
		createOrgPage.getSavebtn().click();
		
		Thread.sleep(2000);
		
		WebElement ele = createOrgPage.getImage(); 
		
		driverutility.moveToElement(ele);
		
		homepage.getSignoutlink().click();
		
		driverutility.closeBrowser();
	}

}


//	//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//	//	driver.manage().window().maximize();
//	//Actions act = new Actions(driver);
//	//act.moveToElement(ele).perform();
////driver.findElement(By.name("user_name")).sendKeys(uN, Keys.TAB, pW, Keys.ENTER);
////driver.findElement(By.xpath("//a[text()='Organizations']")).click();
////driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
////driver.findElement(By.name("accountname")).sendKeys(orgname);
////driver.findElement(By.xpath("(//input[@value='  Save  '])[1]")).click();
//driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
//WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));










