package practiceprograms;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class firstPhonePrice {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("mobile under 20000", Keys.ENTER);
		WebElement ele1 = driver.findElement(By.xpath("//span[text()='Redmi']"));
		ele1.click();
		Thread.sleep(3000);
		String s = driver.findElement(By.xpath(
				"//span[@class='a-size-medium a-color-base a-text-normal']/ancestor::div[@class='sg-col-inner']/descendant::span[@class='a-price-whole']"))
				.getText();
		System.out.println(s);
		driver.findElement(By.xpath(
				"//span[@class='a-size-medium a-color-base a-tex t-normal']/ancestor::div[@class='sg-col-inner']"))
				.click();
		String str = s.replaceAll(",", "");
		System.out.println(str);
		int value = Integer.parseInt(str);
		if (value < 20000)
			System.out.println("test case pass");
		else
			System.out.println("test case fail");
		// WebElement element = driver.findElement(By.xpath("//div[@class='s-main-slot
		// s-result-list s-search-results sg-row']/div[2]"));

		// element.click();

		// JavascriptExecutor js = (JavascriptExecutor)driver;
		// js.executeScript("arguments[0].click();", element);

	}

}
