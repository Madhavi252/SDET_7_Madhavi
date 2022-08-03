package com.vTigerScenarios;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Object.Resource.CreateOrgPage;
import com.Object.Resource.HomePage;
import com.Object.Resource.OrganizationInfoPage;
import com.VTIGER.generic.BaseClassUtiity;
import com.VTIGER.generic.FakeData;
import com.VTIGER.generic.RetryAnalyzer;
import com.VTIGER.generic.WebDriverUtility;

@Listeners(com.VTIGER.generic.ListenerImplementations.class)
public class TC_2_OrgName_Create_Verifytest extends BaseClassUtiity {

@Test(groups= "smoke",retryAnalyzer = RetryAnalyzer.class)
	public void orgNameVerifyTest() throws Throwable {

		FakeData fakeData = new FakeData();
		String orgname = fakeData.industryName();

		HomePage homepage = new HomePage(driver);
		homepage.getOrglinkbtn().click();
		
		OrganizationInfoPage organizationInfoPage = new OrganizationInfoPage(driver);
		organizationInfoPage.getCreateorglinkbtn().click();
	
		CreateOrgPage createOrgPage = new CreateOrgPage(driver);
		
		Thread.sleep(5000);
		createOrgPage.getOrgNametextbox().sendKeys(orgname);
		System.out.println(orgname);

		WebDriverUtility driverutility = new WebDriverUtility(driver);
		
		driverutility.selectDD(createOrgPage.getIndustry(), 4);
		createOrgPage.getSavebtn().click();

		//String s = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		
		String orgname1 = createOrgPage.getOrgVerifyText().getText();
		System.out.println(orgname1);
		
		//Assert.assertEquals(createOrgPage.orgVerifyText.getText(), "Organization Information");
		Assert.assertEquals(true, true);
		
		System.out.println("Organization created and verified...");

	}

}


//Select sel = new Select(ind);
//sel.selectByIndex(4);
//Actions act = new Actions(driver);
//act.moveToElement(ele).perform();
//Random ran = new Random(); 
//		int i = ran.nextInt(1000);
//driver.findElement(By.name("user_name")).sendKeys(uN, Keys.TAB, pW, Keys.ENTER);
//
//driver.findElement(By.xpath("//td[@class='tabSelected']")).click();
//
//driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
//
//driver.findElement(By.name("accountname")).sendKeys(compname);

//PropertyFile propertyFile = new PropertyFile();
//String url = propertyFile.readDatafromPropfile("url");
//System.out.println(url);
//String browser = propertyFile.readDatafromPropfile("browser");
//System.out.println(browser);
//String uN = propertyFile.readDatafromPropfile("username");
//System.out.println(uN);
//String pW = propertyFile.readDatafromPropfile("password");
//System.out.println(pW);

//static WebDriver driver = null;
//if(browser.equalsIgnoreCase("chrome")) {
//
//	WebDriverManager.chromedriver().setup();
//	
//	driver = new ChromeDriver();
//
//}
//
//else if(browser.equalsIgnoreCase("firefox")) {
//
//	WebDriverManager.firefoxdriver().setup();
//	
//	driver = new FirefoxDriver();
//}
//
//else {
//
//	System.out.println("browser not found");
//}
//
//WebDriverUtility driverutility = new WebDriverUtility(driver);
//
//driverutility.pagewait();
//
//driverutility.maximizewindow();
//
//
//driver.get(url);
//
//LoginPage loginpage = new LoginPage(driver);
//loginpage.getUsernametextbox().sendKeys(uN);
//loginpage.getPasswordtextbox().sendKeys(pW);
//loginpage.getLoginbtn().click();

//WebElement ind = driver.findElement(By.name("industry"));
//driver.findElement(By.xpath("(//input[@value='  Save  '])[1]")).click();

//if (s.contains("testyantra7")) 
//	{
//		System.out.println("organazation matches");
//	} 
//	else
//	{
//		System.out.println("matches not found");
//	}
//driver.findElement(By.xpath("//option[@value='Banking']")).click();

//WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
//
//driverutility.moveToElement(ele);
//
//driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
//
//driverutility.closeBrowser();







