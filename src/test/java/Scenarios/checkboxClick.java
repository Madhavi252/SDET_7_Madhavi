package Scenarios;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class checkboxClick {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888/index.php?module=Accounts&action=index");
		driver.findElement(By.name("user_name")).sendKeys("admin", Keys.TAB, "admin", Keys.ENTER);
		driver.findElement(By.xpath("//td[@class='tabSelected']")).click();
		List<WebElement> ele = driver.findElements(By.xpath("//table[@class='lvt small']//tr[*]/td[1]/input"));
		for (int i = 5; i <= ele.size(); i++) {
			driver.findElement(By.xpath("//table[@class='lvt small']//tr[" + i + " ]/td[1]/input")).click();
		}
//		for(WebElement ele1 : ele) {
//			ele1.click();
//			
//			
//		}

	}
}
