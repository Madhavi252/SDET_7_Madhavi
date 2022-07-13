package practiceprograms;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class mobileUnder20000 {

	public static void main(String[] args) throws AWTException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.println(driver.getTitle());
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("mobile under 20000", Keys.ENTER);
		// driver.findElement(By.cssSelector("input[type='submit']"));
		driver.findElement(By.xpath("//span[text()='Samsung']")).click();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(5000);
		driver.findElement(By.xpath(
				"//span[text()='Samsung Galaxy M32 (Black, 6GB RAM, 128GB | FHD+ sAMOLED 90Hz Display | 6000mAh Battery | 64MP Quad Camera']"))
				.click();
		System.out.println(driver.getTitle());
		String mainid = driver.getWindowHandle();
		Set<String> allid = driver.getWindowHandles();
		Iterator<String> itr = allid.iterator();
		itr.next();
		String s = itr.next();
		driver.switchTo().window(s);
		System.out.println(driver.getTitle());

	}

}
