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
	private WebElement searchorgbtn;


	@FindBy(xpath="//a[@title='Organizations']")
	private WebElement searchedorgname;


	public WebElement getSearchedorgname() {
		return searchedorgname;
	}
	 
}
