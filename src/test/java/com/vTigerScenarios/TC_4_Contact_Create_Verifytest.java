package com.vTigerScenarios;

import java.util.Set;

import org.openqa.selenium.Keys;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Object.Resource.ContactInfoPage;
import com.VTIGER.generic.BaseClassUtiity;
import com.VTIGER.generic.FakeData;
import com.VTIGER.generic.RetryAnalyzer;
import com.VTIGER.generic.WebDriverUtility;


//@Listeners(com.VTIGER.generic.ListenerImplementations.class)
public class TC_4_Contact_Create_Verifytest extends BaseClassUtiity {

	@Test(groups="regression",retryAnalyzer = RetryAnalyzer.class)

	public void contactCreateTest() throws Throwable {

		FakeData fakeData = new FakeData();
		String fname = fakeData.firstName();
		String lname = fakeData.lastName();

		WebDriverUtility driverutility = new WebDriverUtility(driver);
		
		ContactInfoPage contactInfoPage = new ContactInfoPage(driver);
		
		contactInfoPage.getContactLink().click();
		contactInfoPage.getCreateContactLinkBtn().click();
		contactInfoPage.getFirstNameDD().click();
		
		driverutility.selectDD(contactInfoPage.getFirstNameDD(), 2);
		
		contactInfoPage.getFirstName().sendKeys(fname);
		contactInfoPage.getLastName().sendKeys(lname);
		contactInfoPage.getOrgNameLink().click();
		
		String mainid = driver.getWindowHandle();
		Set<String> allid = driver.getWindowHandles();
		for (String i : allid) {
			if (!mainid.equals(i))
				driver.switchTo().window(i);
		}
				
		contactInfoPage.getOrgNameWindow();
		
		contactInfoPage.getOrgNameWindow().sendKeys("tt", Keys.ENTER);
		
		contactInfoPage.getOrgNameWindowClose().click();
		
		driver.switchTo().window(mainid);
		
		contactInfoPage.getSaveBtn().click();
		String data= contactInfoPage.getContactVerifyText().getText();

		if (data.contains(fname))
			System.out.println("Contact created and saved...");
		else
			System.out.println("Contact not created and saved");

	}

}




//driver.get(url);
//driver.findElement(By.name("user_name")).sendKeys(uN, Keys.TAB, pW, Keys.ENTER);
//driver.findElement(By.xpath("//a[text()='Contacts']")).click();
//driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
//driver.findElement(By.name("salutationtype")).click();
//driver.findElement(By.xpath("//option[@value='Mrs.']")).click();
//driver.findElement(By.name("firstname")).sendKeys(fname);
//driver.findElement(By.name("lastname")).sendKeys(lname);
//driver.findElement(By.xpath("//img[@title='Select'][1]")).click();

//WebElement ele = driver.findElement(By.id("search_txt"));

//driver.findElement(By.xpath("//a[@href='javascript:window.close();']")).click();
// driver.findElement(By.xpath("//a[text()='testyantra1']")).click();

//driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
//String data = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();



