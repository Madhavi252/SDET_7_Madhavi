package practiceprograms;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class flipkart_addingtwoprices {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//button[text()='✕']")).click();

		driver.findElement(By.name("q")).sendKeys("iphone 13", Keys.ENTER);
		Thread.sleep(1000);

		WebElement element = driver.findElement(By.xpath("//img[@title='Flipkart']"));

		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		Thread.sleep(1000);
		// String ele = driver.findElement(By.xpath("//div[text()=\"APPLE iPhone 11
		// (Black, 64
		// GB)\"]/ancestor::div[@class='_2kHMtA']/descendant::div[@class='_30jeq3
		// _1_WHN1']" )).getText();
		WebElement phone = driver.findElement(
				By.xpath("//div[@class='_1YokD2 _3Mn1Gg']//div[@class='_1AtVbE col-12-12'][1]//div[@class='_4rR01T']"));

		String pname = phone.getText();
		WebElement phoneprice = driver.findElement(By.xpath(
				"//div[@class='_1YokD2 _3Mn1Gg']//div[@class='_1AtVbE col-12-12'][1]//div[@class='_30jeq3 _1_WHN1']"));

		String price = phoneprice.getText();
		System.out.println(price);
		phone.click();

		// System.out.println(ele);
		// String e = ele.replace("₹", "");
		// System.out.println(e);
		// String e1 = e.replace(",", "");
		// System.out.println(e1);
		// driver.findElement(By.xpath("//div[text()=\"APPLE iPhone 11 (Black, 64
		// GB)\"]/ancestor::div[@class='_2kHMtA']/descendant::div[@class='_30jeq3
		// _1_WHN1']")).click();
		String id = driver.getWindowHandle();
		Set<String> id1 = driver.getWindowHandles();
		// Iterator<String> itr = id1.iterator();
		// itr.next();
		// String s = itr.next();
		for (String i : id1) {
			if (!id.equals(i))
				driver.switchTo().window(i);
		}
		Thread.sleep(3000);

		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")).click();
		Thread.sleep(3000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,10000)");
		driver.findElement(By.xpath("//button[text()='+']")).click();
		Thread.sleep(3000);

		String finalprice = driver
				.findElement(By.xpath(
						"//div[text()='Total Amount']/ancestor::div[@class='Ob17DV']//div[@class='Ob17DV _3X7Jj1']"))
				.getText();

		System.out.println(finalprice);
	}

}
