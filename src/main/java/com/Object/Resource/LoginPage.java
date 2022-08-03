package com.Object.Resource;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//login page should be page name
public class LoginPage {

	WebDriver driver;

	//rule 3: Create constructor for initilizing Page elements
	public LoginPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	//rule-2 : locate all the web elements with @findby annotation
	@FindBy(name="user_name")
	private WebElement usernametextbox;
	
	@FindBy(xpath="//input[@name='user_password']")
	private	WebElement passwordtextbox;

	@FindBy(id="submitButton")
	private WebElement loginbtn;
	
	//rule-4 : create getters for accessing webelements

	public WebElement getUsernametextbox() {
		return usernametextbox;
	}

	public WebElement getPasswordtextbox() {
		return passwordtextbox;
	}

	public WebElement getLoginbtn() {
		return loginbtn;
	}
	
}
