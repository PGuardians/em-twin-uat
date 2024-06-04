package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerLogin {
	
	public WebDriver driver;
	
	@FindBy(xpath="//input[@id='login-email-input']")
	private WebElement CustomerUsername;
	
	@FindBy(xpath = "//input[@id='login-password-input']")
	private WebElement CustomerPassword;
	
	@FindBy(xpath="//button[text()='Login']")
	private WebElement login;
	
	public CustomerLogin(WebDriver driver2) {
		this.driver=driver2;
		PageFactory.initElements(driver, this);
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getCustomerUsername() {
		return CustomerUsername;
	}

	public WebElement getCustomerPassword() {
		return CustomerPassword;
	}

	public WebElement getLogin() {
		return login;
	}

}
