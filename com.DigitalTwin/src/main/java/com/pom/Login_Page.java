package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page {
	
	public WebDriver driver;
	
	@FindBy(id ="login-email-input")
	private WebElement userName;
	
	@FindBy(id = "login-password-input")
	private WebElement passWord;
	
	@FindBy(xpath = "//button[text()='Login']")
	private WebElement submit;
	
    @FindBy(xpath = "//div[text()='Logout']")
    private WebElement logOut;
	
	public WebElement getLogOut() {
		return logOut;
	}

	public Login_Page(WebDriver driver2) {
		
		this.driver=driver2;
		PageFactory.initElements(driver, this);
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getUserName() {
		return userName;
	}

	public WebElement getPassWord() {
		return passWord;
	}

	public WebElement getSubmit() {
		return submit;
	}
}
