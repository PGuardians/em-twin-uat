package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class User_List {
	
	public WebDriver driver;
	
	@FindBy(xpath ="//input[@placeholder='Search by name, email, phone']")
	private WebElement searchBox;
	
	@FindBy(xpath="//button[text()='Create User']")
	private WebElement createUser;

	
	@FindBy(id = "create-user-first-name-input")
	private WebElement firstName;
	
	@FindBy(id = "create-user-last-name-input")
	private WebElement lastName;
	
	@FindBy(id = "create-user-email-input")
	private WebElement emailId;
	
	@FindBy(id = "add-panel-role-select")
	private WebElement selectRole;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement create;
	
	@FindBy(xpath = "//td[text()='SRINIVASAN']")
	private WebElement customerUser;
	
	@FindBy(xpath = "//td[text()='smithjamesjs7189@gmail.com']")
	private WebElement datascientistUser;
	
	@FindBy(xpath = "//td[text()='WILLIAM']")
	private  WebElement developerUser;
	
	@FindBy(xpath = "//td[text()='twinarcdemo@gmail.com']")
	private WebElement customerMail;
	
	@FindBy(xpath="//td[text()='smithjamesjs7189@gmail.com']")
	private WebElement datascientistEmail;
	
	@FindBy(xpath="//td[text()='johnwillamsjw2000@gmail.com']")
	private WebElement developerEmail;
	
	@FindBy(xpath="//td[text()='smithjamesjs7189@gmail.com']/following-sibling::td/following-sibling::td[text()='Active']")
	private WebElement datascientistStatus;
	
	@FindBy(xpath="//td[text()='twinarcdemo@gmail.com']/following-sibling::td/following-sibling::td[text()='Inactive']")
	private WebElement customerStatus;
	
	@FindBy(xpath="//td[text()='johnwillamsjw2000@gmail.com']/following-sibling::td/following-sibling::td[text()='Active']")
	private WebElement developerStatus;
	
//	@FindBy(xpath="//td[text()='sivasri691995@gmail.com']/following-sibling::td/following-sibling::td[text()='Inactive']/following-sibling::td/following-sibling::td/child::div/child::img[@data-testid='delete-icon']")
//	private WebElement deleteCustomer;
	@FindBy(xpath="(//img[@data-testid= 'delete-icon'])[1]")//*dlt-cust
	private WebElement deleteCustomer;
	
//	@FindBy(xpath="//td[text()='smithjamesjs7189@gmail.com']/following-sibling::td/following-sibling::td[text()='Active']/following-sibling::td/following-sibling::td/child::div/child::img[@data-testid='delete-icon']")
//	private WebElement deletedatascientist;
	@FindBy(xpath="(//img[@data-testid= 'delete-icon'])[1]")//*dlt-ds
	private WebElement deletedatascientist;
	
	@FindBy(xpath="(//img[@data-testid= 'delete-icon'])[1]")//*dlt-dev
	private WebElement deleteDeveloper;
	
	@FindBy(xpath="//button[text()='Delete']")
	private WebElement deleteUser;
	
	public WebElement getDeleteUser() {
		return deleteUser;
	}

	public WebElement getDeleteCustomer() {
		return deleteCustomer;
	}

	public WebElement getDeletedatascientist() {
		return deletedatascientist;
	}

	public WebElement getDeleteDeveloper() {
		return deleteDeveloper;
	}

	public WebElement getDatascientistStatus() {
		return datascientistStatus;
	}

	public WebElement getCustomerStatus() {
		return customerStatus;
	}

	public WebElement getDeveloperStatus() {
		return developerStatus;
	}

	public WebElement getDeveloperEmail() {
		return developerEmail;
	}

	public WebElement getDatascientistEmail() {
		return datascientistEmail;
	}

	public WebElement getCustomerMail() {
		return customerMail;
	}

	public WebElement getCreate() {
		return create;
	}

	public WebElement getCustomerUser() {
		return customerUser;
	}

	public WebElement getDatascientistUser() {
		return datascientistUser;
	}

	public WebElement getDeveloperUser() {
		return developerUser;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getSearchBox() {
		return searchBox;
	}

	public WebElement getCreateUser() {
		return createUser;
	}

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getEmailId() {
		return emailId;
	}

	public WebElement getSelectRole() {
		return selectRole;
	}

	public WebElement getSelectCustomer() {
		return selectCustomer;
	}

	public WebElement getSelectDataScientist() {
		return selectDataScientist;
	}

	public WebElement getSelectDeveloper() {
		return selectDeveloper;
	}

	@FindBy(xpath="//a[text()='Customer']")
	private WebElement selectCustomer;
	
	@FindBy(xpath = "//a[text()='Data Scientist']")
	private WebElement selectDataScientist;
	
	@FindBy(xpath = "//a[text()='Developer']")
	private WebElement selectDeveloper;
	
	public User_List(WebDriver driver2) {
		
		this.driver=driver2;
		PageFactory.initElements(driver, this);
		
	}
	

	}
