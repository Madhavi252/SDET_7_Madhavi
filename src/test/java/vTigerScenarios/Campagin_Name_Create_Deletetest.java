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
import org.testng.annotations.Test;

import com.Object.Resource.CampaginInfoPage;
import com.VTIGER.generic.BaseClassUtiity;
import com.VTIGER.generic.FakeData;
import com.VTIGER.generic.PropertyFile;
import com.VTIGER.generic.WebDriverUtility;
import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import com.mysql.cj.x.protobuf.MysqlxExpect.Open.Condition.Key;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Campagin_Name_Create_Deletetest extends BaseClassUtiity {


	@Test
	public void campaginCreate() throws InterruptedException, Throwable {

		FakeData fakeData = new FakeData();
		String campname = fakeData.name();
		String name = fakeData.name();

		WebDriverUtility driverutility = new WebDriverUtility(driver);

		CampaginInfoPage campaginInfoPage = new CampaginInfoPage(driver);
		
		campaginInfoPage.getMoreLink();
		Thread.sleep(3000);
		Thread.sleep(3000);

		driverutility.moveToElement(campaginInfoPage.getMoreLink());

		campaginInfoPage.getCampaginLink().click();
		campaginInfoPage.getCampaginLinkBtn().click();
		Thread.sleep(3000);
		campaginInfoPage.getCampaginNameTxtBox().sendKeys(campname);
		System.out.println(campname);
		campaginInfoPage.getSaveBtn().click();

		driverutility.moveToElement(campaginInfoPage.getMoreLink());
		Thread.sleep(3000);

		campaginInfoPage.getCampaginLink().click();
		campaginInfoPage.getCampsearchTxtBox().click();
		Thread.sleep(3000);
		
		campaginInfoPage.getCampsearchTxtBox().sendKeys(campname, Keys.TAB);
		System.out.println(campname);
		Thread.sleep(3000);


		driverutility.selectDD("Campaign Name", campaginInfoPage.getCampTxtBox());
		Thread.sleep(3000);

		campaginInfoPage.getCampsearch().click();

		Thread.sleep(2000);
		
		campaginInfoPage.getCheckBoxBtn().click();
		
		Thread.sleep(3000);
		
		campaginInfoPage.getDeleteBtn().click();

		driverutility.acceptAlert();
		
		Thread.sleep(2000);


	}

}




//WebElement ele = driver.findElement(By.xpath("//table[@class='hdrTabBg']//tr/td/a[text()='More']"));
//
//driver.findElement(By.xpath("//a[text()='Campaigns']")).click();
//driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
//
////		Faker faker = new Faker();
////		String name = faker.name().firstName();
//
//driver.findElement(By.name("campaignname")).sendKeys(campname);
//driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
////		String name1 = "testyantra";

//Actions act1 = new Actions(driver);
//WebElement ele1 = driver.findElement(By.xpath("//table[@class='hdrTabBg']//tr/td/a[text()='More']"));
//
//act1.moveToElement(ele1).perform();

//driver.findElement(By.xpath("//a[text()='Campaigns']")).click();
//driver.findElement(By.name("search_text")).click();
//
//driver.findElement(By.name("search_text")).sendKeys(campname, Keys.TAB);
//WebElement ele2 = driver.findElement(By.xpath("//select[@class='txtBox']"));
//ele2.click();
//Select sel = new Select(ele2);
//sel.selectByVisibleText("Campaign Name");
//driver.findElement(By.name("submit")).click();

//driver.findElement(By.xpath("//table[@class='lvt
// small']//tr[3]/td[1]")).click(); wrong approach

//driver.findElement(By.name("selected_id")).click();
//Thread.sleep(3000);
//driver.findElement(By.xpath("(//input[@class='crmbutton small delete'])[1]")).click();
//
//Thread.sleep(2000);

//Alert alt = driver.switchTo().alert();
//alt.accept();





