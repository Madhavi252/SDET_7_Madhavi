package practiceprograms;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class firstPhonePrice1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//button[.='✕']")).click();
		driver.findElement(By.name("q")).sendKeys("samsungphone", Keys.ENTER);
		WebElement ele = driver.findElement(By.xpath("//img[@class='_2xm1JU']"));
		Actions act = new Actions(driver);
		act.moveToElement(ele).build().perform();
		WebElement phnename = driver.findElement(
				By.xpath("//div[@class='_1YokD2 _3Mn1Gg']//div[@class='_1AtVbE col-12-12'][1]//div[@class='_4rR01T']"));
		System.out.println(phnename.getText());
		WebElement phoneprice = driver.findElement(By.xpath(
				"//div[@class='_1YokD2 _3Mn1Gg']//div[@class='_1AtVbE col-12-12'][1]//div[@class='_30jeq3 _1_WHN1']"));
		System.out.println(phoneprice.getText());
		phnename.click();
		String id = driver.getWindowHandle();
		Set<String> allid = driver.getWindowHandles();
		for (String i : allid) {
			if (!id.equals(i))
				driver.switchTo().window(i);
		}
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")).click();
		Thread.sleep(2000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,6000)");
		driver.findElement(By.xpath("//button[text()='+']")).click();
		String s = driver
				.findElement(By.xpath(
						"//div[.='Total Amount']/ancestor::div[@class='_3LxTgx']/descendant::div[@class='_1dqRvU']"))
				.getText();
		System.out.println(s);
	}

}
