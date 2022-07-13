package Scenarios;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Compare_OrgName {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888/index.php?module=Accounts&action=index");
		driver.findElement(By.name("user_name")).sendKeys("admin", Keys.TAB, "admin", Keys.ENTER);
		driver.findElement(By.xpath("//td[@class='tabSelected']")).click();

		List<WebElement> colname = driver.findElements(By.xpath("//table[@class='lvt small']//tr/td[3]"));
		for (WebElement colname1 : colname) {
			String name = colname1.getText();
			System.out.println(name);
		}
		System.out.println("*************");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//table[@class='lvt small']//tr/td[3]/a")).click();

		List<WebElement> colname11 = driver.findElements(By.xpath("//table[@class='lvt small']//tr/td[3]"));
		for (WebElement colname22 : colname11) {
			String name1 = colname22.getText();
			System.out.println(name1);
		}
	}

}
