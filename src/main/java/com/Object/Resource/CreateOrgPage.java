package com.Object.Resource;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrgPage {
	
	WebDriver driver;
	
	public CreateOrgPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(name="accountname")
	private WebElement orgNametextbox;
	
	
	
	public WebElement getOrgNametextbox() {
		return orgNametextbox;
	}

	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savebtn;


	public WebElement getSavebtn() {
		return savebtn;
	}
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement image;

	public WebElement getImage() {
		return image;
	}
	
	@FindBy(name="industry")
	private WebElement industry;

	public WebElement getIndustry() {
		return industry;
	}
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement orgVerifyText;

	public WebElement getOrgVerifyText() {
		return orgVerifyText;
	}
	
	

}
















