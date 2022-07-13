package practiceprograms;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class lenskart {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.lenskart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.name("q")).click();
		String s = driver.findElement(By.xpath("//ul[@class='trending_list menu-link']")).getText();
		System.out.println(s);
		String s1 = driver.findElement(By.xpath("//a[text()='Do More, Be More']")).getAttribute("title");
		System.out.println(s1);
	}

}
