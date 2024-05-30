package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class User_Profile {
	
	public WebDriver driver;
	
	@FindBy(xpath="//div[@class='avatar']")
	private WebElement clickProfile;
	
	@FindBy(xpath="//div[text()='View Profile']")
	private WebElement viewProfile;
	
	@FindBy(xpath ="//input[@data-testid='updatepassword-current-password']")
	private WebElement currentPassword;
	
	@FindBy(xpath="//input[@data-testid='updatepassword-new-password']")
	private WebElement newPassword;
	
	@FindBy(xpath="//input[@data-testid='updatepassword-confirm-new-password']")
	private WebElement confirmnewPassword;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement saveChanges;
	
	public WebElement getCurrentPassword() {
		return currentPassword;
	}

	public WebElement getNewPassword() {
		return newPassword;
	}

	public WebElement getConfirmnewPassword() {
		return confirmnewPassword;
	}

	public WebElement getSaveChanges() {
		return saveChanges;
	}

	@FindBy(xpath = "//div[@data-testid='navigate-to-update-password-page-btn']")
	private WebElement changePassword;
	
	public WebElement getChangePassword() {
		return changePassword;
	}

	public User_Profile(WebDriver driver2) {
		this.driver=driver2;
		PageFactory.initElements(driver, this);
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getClickProfile() {
		return clickProfile;
	}

	public WebElement getViewProfile() {
		return viewProfile;
	}

}
