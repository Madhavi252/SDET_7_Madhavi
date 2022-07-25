package com.Object.Resource;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {
	
	WebDriver driver;
	
	public ContactInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[text()='Contacts']")
	private WebElement contactLink;
	
	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement createContactLinkBtn;
	
	@FindBy(name="salutationtype")
	private WebElement firstNameDD;
	
	@FindBy(name="firstname")
	private WebElement firstName;
	
	@FindBy(name="lastname")
	private WebElement lastName;
	
	@FindBy(xpath="//img[@title='Select'][1]")
	private WebElement orgNameLink;
	
	@FindBy(id="search_txt")
	private WebElement orgNameWindow;
	
	@FindBy(xpath="//a[@href='javascript:window.close();']")
	private WebElement orgNameWindowClose;

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getContactLink() {
		return contactLink;
	}

	public WebElement getCreateContactLinkBtn() {
		return createContactLinkBtn;
	}

	public WebElement getFirstNameDD() {
		return firstNameDD;
	}

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getOrgNameLink() {
		return orgNameLink;
	}

	public WebElement getOrgNameWindow() {
		return orgNameWindow;
	}

	public WebElement getOrgNameWindowClose() {
		return orgNameWindowClose;
	}
	
	@FindBy(xpath="//input[@class='crmButton small save']")
	private WebElement saveBtn;

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement contactVerifyText;

	public WebElement getContactVerifyText() {
		return contactVerifyText;
	}
	
	
	
	
	
}
