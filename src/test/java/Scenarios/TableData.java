package Scenarios;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TableData {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888/index.php?module=Accounts&action=index");
		driver.findElement(By.name("user_name")).sendKeys("admin", Keys.TAB, "admin", Keys.ENTER);
		driver.findElement(By.xpath("//td[@class='tabSelected']")).click();

		List<WebElement> colname = driver.findElements(By.xpath("//table[@class='lvt small']//tr/td[3]"));
		for (WebElement colname1 : colname) {
			System.out.println(colname1.getText());
		}

		System.out.println("******************");

		List<WebElement> colname2 = driver.findElements(By.xpath("//table[@class='lvt small']//tr/td[3]"));
		for (int i = 3; i <= colname2.size(); i++) {
			WebElement orgname = driver.findElement(By.xpath("//table[@class='lvt small']//tr[" + i + "]/td[3]"));

			String name = orgname.getText();
			if (name.equalsIgnoreCase("tt")) {
				WebElement s = driver.findElement(By.xpath("//table[@class='lvt small']//tr[" + i + "]/td[1]"));
				s.click();
				System.out.println(
						driver.findElement(By.xpath("//table[@class='lvt small']//tr[" + i + "]/td[3]")).getText());
			}

		}

	}

}
