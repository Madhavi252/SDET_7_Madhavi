package practiceprograms;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class notepad_fetching {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		FileInputStream fis = new FileInputStream("../SDET7_MADHAVI/src/test/java/notepad.properties");
		Properties pro = new Properties();
		pro.load(fis);
		pro.getProperty("browser");
	}

}
