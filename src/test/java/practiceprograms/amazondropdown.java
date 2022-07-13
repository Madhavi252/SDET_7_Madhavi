package practiceprograms;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class amazondropdown {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("start-maximized");
		
		//opt.addArguments("headless");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(opt);
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//div[@class='nav-search-scope nav-sprite']")).click();
		Thread.sleep(3000);
		String str = driver.findElement(By.xpath("//div[@class='nav-search-scope nav-sprite']")).getText();
		System.out.println(str);
		System.out.println("*************");
		driver.findElement(By.xpath("//option[text()='Books']")).click();
		String ele = driver.findElement(By.xpath("//option[text()='Books']")).getText();
		System.out.println(ele);
	}

}
