package com.Object.Resource;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {

	WebDriver driver;
	 public OrganizationInfoPage(WebDriver driver) {
		 PageFactory.initElements(driver, this);
	 }
	
	 @FindBy(xpath="//img[@title='Create Organization...']")
	 private WebElement createorglinkbtn;
	 
	 @FindBy(name="search_text")
	 private WebElement searchorgtxtbox;
	 
	 @FindBy(id="bas_searchfield")
	 private WebElement searchorgtypeDD;
	 
	 
	public WebElement getCreateorglinkbtn() {
		return createorglinkbtn;
	}

	public WebElement getSearchorgtxtbox() {
		return searchorgtxtbox;
	}

	public WebElement getSearchorgtypeDD() {
		return searchorgtypeDD;
	}
	 
	 
	@FindBy(name="submit")
	public WebElement searchorgbtn;


	@FindBy(xpath="//a[@title='Organizations']")
	private WebElement searchedorgname;


	public WebElement getSearchedorgname() {
		return searchedorgname;
	}
	
	@FindBy(xpath="//option[text()='Organization Name']")
	private WebElement orgnameDD;
	
	public WebElement getOrgnameDD() {
		return orgnameDD;
	}
	 
	@FindBy(name="selected_id")
	private WebElement checkBox;
	
	public WebElement getCheckBox() {
		return checkBox;
	}
	
	@FindBy(xpath="//input[@class='crmbutton small delete']")
	private WebElement deletebtn;
	
	public WebElement getDeletebtn() {
		return deletebtn;
	}
	
	
}








