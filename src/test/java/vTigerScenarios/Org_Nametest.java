package vTigerScenarios;

import org.testng.annotations.Test;

import com.Object.Resource.CreateOrgPage;
import com.Object.Resource.HomePage;
import com.Object.Resource.OrganizationInfoPage;
import com.VTIGER.generic.BaseClassUtiity;
import com.VTIGER.generic.FakeData;


public class Org_Nametest extends BaseClassUtiity {

	@Test
	public void orgNameCreate() throws Throwable {

		FakeData fakeData = new FakeData();
		String orgname = fakeData.name();		

		HomePage homepage = new HomePage(driver);
		homepage.getOrglinkbtn().click();

		OrganizationInfoPage organizationInfoPage = new OrganizationInfoPage(driver);
		organizationInfoPage.getCreateorglinkbtn().click();

		CreateOrgPage createOrgPage = new CreateOrgPage(driver);

		//Thread.sleep(5000);
		createOrgPage.getOrgNametextbox().sendKeys(orgname);
		//Thread.sleep(7000);
		createOrgPage.getSavebtn().click();

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

//PropertyFile propertyFile = new PropertyFile();
//String url = propertyFile.readDatafromPropfile("url");
//String browser = propertyFile.readDatafromPropfile("browser");
//System.out.println(browser);
//String uN = propertyFile.readDatafromPropfile("username");
//System.out.println(uN);
//String pW = propertyFile.readDatafromPropfile("password");
//System.out.println(pW);
//

//
//if(browser.equalsIgnoreCase("chrome")) {
//
//	WebDriverManager.chromedriver().setup();
//	driver = new ChromeDriver();
//
//}
//
//else if(browser.equalsIgnoreCase("firefox")) {
//
//	WebDriverManager.firefoxdriver().setup();
//	driver = new FirefoxDriver();
//}
//
//else {
//
//	System.out.println("browser not found");
//}
//driver.get(url);
//LoginPage loginpage = new LoginPage(driver);
//loginpage.getUsernametextbox().sendKeys(uN);
//loginpage.getPasswordtextbox().sendKeys(pW);
//loginpage.getLoginbtn().click();
//homepage.getSignoutlink().click();
//
//driverutility.closeBrowser();
//WebElement ele = createOrgPage.getImage(); 

//static WebDriver driver = null; 


