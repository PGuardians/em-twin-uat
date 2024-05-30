package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Cusromer_Profile {
		
		public WebDriver driver;
		
		@FindBy(xpath="//div[@class='avatar']")
		private WebElement clickCustomerProfile;
		
		@FindBy(xpath="//div[text()='View Profile']")
		private WebElement viewCustomerProfile;
		
		@FindBy(xpath ="//input[@data-testid='updatepassword-current-password']")
		private WebElement currentCustomerPassword;
		
		@FindBy(xpath="//input[@data-testid='updatepassword-new-password']")
		private WebElement newCustomerPassword;
		
		@FindBy(xpath="//input[@data-testid='updatepassword-confirm-new-password']")
		private WebElement confirmnewCustomerPassword;
		
		@FindBy(xpath="//button[@type='submit']")
		private WebElement CustomersaveChanges;
		
		@FindBy(xpath="//input[@data-testid= 'profile-user-lastname-input']")
		private WebElement EditCustomerLastname;
		
		public WebElement getEditLastname() {
			return CustomersaveChanges;		
		}
		
		public WebElement getCurrentPassword() {
			return currentCustomerPassword;
		}

		public WebElement getNewPassword() {
			return newCustomerPassword;
		}

		public WebElement getConfirmnewPassword() {
			return confirmnewCustomerPassword;
		}

		public WebElement getSaveChanges() {
			return CustomersaveChanges;
		}

		@FindBy(xpath = "//div[@data-testid='navigate-to-update-password-page-btn']")
		private WebElement changeCustomerPassword;
		
		public WebElement getChangePassword() {
			return changeCustomerPassword;
		}

		public Cusromer_Profile(WebDriver driver2) {
			this.driver=driver2;
			PageFactory.initElements(driver, this);
		}

		public WebDriver getDriver() {
			return driver;
		}

		public WebElement getClickProfile() {
			return clickCustomerProfile;
		}

		public WebElement getViewProfile() {
			return viewCustomerProfile;
		}

}
