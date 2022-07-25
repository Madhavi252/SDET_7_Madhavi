package com.Object.Resource;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaginInfoPage {
	
	WebDriver driver;

	public CampaginInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//table[@class='hdrTabBg']//tr/td/a[text()='More']")
	private WebElement moreLink;
	
	@FindBy(xpath="//a[text()='Campaigns']")
	private WebElement campaginLink;
	
	@FindBy(xpath="//img[@title='Create Campaign...']")
	private WebElement campaginLinkBtn;
	
	@FindBy(name="campaignname")
	private WebElement campaginNameTxtBox;
	
	@FindBy(xpath="//input[@class='crmButton small save']")
	private WebElement saveBtn;
	
	@FindBy(name="search_text")
	private WebElement campsearchTxtBox;
	
	@FindBy(xpath="//select[@class='txtBox']")
	private WebElement campTxtBox;
	
	@FindBy(name="submit")
	private WebElement campsearch;
	
	@FindBy(name="selected_id")
	private WebElement checkBoxBtn;
	
	@FindBy(xpath="(//input[@class='crmbutton small delete'])[1]")
	private WebElement deleteBtn;

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getMoreLink() {
		return moreLink;
	}

	public WebElement getCampaginLink() {
		return campaginLink;
	}

	public WebElement getCampaginLinkBtn() {
		return campaginLinkBtn;
	}

	public WebElement getCampaginNameTxtBox() {
		return campaginNameTxtBox;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getCampsearchTxtBox() {
		return campsearchTxtBox;
	}

	public WebElement getCampTxtBox() {
		return campTxtBox;
	}

	public WebElement getCampsearch() {
		return campsearch;
	}

	public WebElement getCheckBoxBtn() {
		return checkBoxBtn;
	}

	public WebElement getDeleteBtn() {
		return deleteBtn;
	}
	
	
}
