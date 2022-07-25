package com.VTIGER.generic;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	
	WebDriver driver;
	/*
	 * Description : creating constructor with formal arguments
	 * to aviod formal arguments in every method
	 */
	
	public WebDriverUtility(WebDriver driver)
	{
		this.driver=driver;		
	}
	
	public void maximizewindow()
	{
		driver.manage().window().maximize();
	}
	
	public void pagewait() 
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void selectDD(String visibletext, WebElement element) 
	{
		Select select = new Select(element);
		select.selectByVisibleText(visibletext);
	}
	
	public void selectDD(WebElement element, String value) 
	{
		Select select = new Select(element);
		select.selectByValue(value);  
	}
	
	public void selectDD(WebElement element, int index)
	{
		Select select = new Select(element);
		select.selectByIndex(index);
		
	}
	
	public void waitandclick(WebElement element) 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
		
	}
	
	public void moveToElement(WebElement element)
	{
		Actions action = new Actions(driver);
		action.moveToElement(element).click().build().perform();
	}
	
	public void dragAndDrop(WebElement source, WebElement target) {
		Actions action = new Actions(driver);
		action.dragAndDrop(source, target).build().perform();
		
	}
	
	public void closeBrowser() {
		driver.close();
		
	}
	
	public void refreshPage() {
		driver.navigate().refresh();
		
	}
	
	public void acceptAlert() {
		driver.switchTo().alert().accept();
		
	}
	
}












