package practiceprograms;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STSourceType;

import io.github.bonigarcia.wdm.WebDriverManager;

public class comparePrice {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//button[.='✕']")).click();
		driver.findElement(By.name("q")).sendKeys("redmi note 10 pro", Keys.ENTER);
		WebElement ele = driver.findElement(By.xpath(
				"//div[text()='REDMI Note 10 Pro (Dark Night, 128 GB)']/ancestor::div[@class='_13oc-S'][1]/descendant::div[@class='_30jeq3 _1_WHN1'][1]"));
		String s = ele.getText();
		String s1 = s.replaceAll("₹", "");
		String s2 = s1.replaceAll(",", "");
		int value = Integer.parseInt(s2);
		System.out.println(value);
		driver.close();
		WebDriverManager.chromedriver().setup();
		WebDriver driver1 = new ChromeDriver();

		driver1.get("https://www.amazon.in/");
		driver1.manage().window().maximize();
		driver1.findElement(By.id("twotabsearchtextbox")).sendKeys("REDMI Note 10 Pro (Dark Night, 128 GB)",
				Keys.ENTER);
		WebElement ele1 = driver1.findElement(By.xpath(
				"//span[text()='Redmi Note 10 Pro (Dark Night, 6GB RAM, 128GB Storage) -120hz Super Amoled Display|64MPwith 5mp Super Tele-Macro | 33W Charger Included']/ancestor::div[@class='sg-col-inner'][1]/descendant::span[@class='a-price-whole']"));
		String e = ele1.getText();
		String e1 = e.replaceAll("₹", "");
		String e2 = e1.replaceAll(",", "");
		int value1 = Integer.parseInt(e2);
		System.out.println(value1);
		driver1.close();
		if (value > value1)
			System.out.println("flipkart price is more");
		else if (value < value1)
			System.out.println("amazon price is more");
		else
			System.out.println("both prices are same");

	}

}
