package practiceprograms;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTrip {

	@Test(dataProvider = "getValue")
	
	public void test(String src, String dest) {
		
		System.out.println(src +"-->"+ dest );
	}
	
	@Test
	
		public void test1() throws Throwable{

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
 
		driver.get("https://www.makemytrip.com/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//driver.findElement(By.id("webklipper-publisher-widget-container-notification-close-div")).click();
		
		driver.switchTo().frame("notification-frame-~19713b227");
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//a[@class='close']")).click();
		
		driver.switchTo().defaultContent();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		
		driver.findElement(By.id("fromCity")).click();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("hyd");
		driver.findElement(By.xpath("//div[.='HYD']")).click();
		
		Thread.sleep(3000);
		
		//driver.findElement(By.id("toCity")).click();
		driver.findElement(By.id("toCity")).sendKeys("del");
		driver.findElement(By.xpath("//div[.='DEL']")).click();
		
		Thread.sleep(2000);
		
		//driver.findElement(By.xpath("//label[@for='departure']")).click();
		driver.findElement(By.xpath("//span[.='DEPARTURE']")).click();
		
		driver.findElement(By.xpath("//div[@aria-label='Sat Jul 16 2022']")).click();
		
		driver.close();
		
	}
		@DataProvider()
		public Object[][] getValue() {
			
			Object[][] arr = new Object [5][2];
			
			arr[0][0] = "DEL";
			arr[0][1] = "HYD";
			
			arr[1][0] = "BOM";
			arr[1][1] = "MAA";
			
			arr[2][0] = "GOI";
			arr[2][1] = "NYC";
			
			arr[3][0] = "BOM";
			arr[3][1] = "HYD";
			
			arr[4][0] = "DEL";
			arr[4][1] = "PNQ";
			
			return arr;
		}
		
	}













