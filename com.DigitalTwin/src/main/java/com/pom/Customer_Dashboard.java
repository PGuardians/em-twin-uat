package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Customer_Dashboard {
	
	public WebDriver driver;
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getCreateRegId() {
		return createRegId;
	}
	
	public WebElement getCreateRegId1() {
		return createRegId1;
	}

	public Customer_Dashboard(WebDriver driver2) {
		this.driver=driver2;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getClickCreateRegId() {
		return clickCreateRegId;
	}
	
	public WebElement getClickCreateRegId1() {
		return clickCreateRegId1;
	}

	public WebElement getDatasetName() {
		return datasetName;
	}
	
	public WebElement getDatasetName1() {
		return datasetName1;
	}
	
	@FindBy(xpath="//input[@data-testid='create-popup-dataset-input']")
	private WebElement datasetName1;

	@FindBy(xpath ="//div[@class='file-container']")
	private WebElement createRegId;
	
	@FindBy(xpath ="//div[@class='file-container']")
	private WebElement createRegId1;
	
	@FindBy(xpath="//button[text()='CREATE REG-ID']")
	private WebElement clickCreateRegId;
	
	@FindBy(xpath="//button[text()='CREATE REG-ID']")
	private WebElement clickCreateRegId1;
	
	@FindBy(xpath="//input[@data-testid='create-popup-dataset-input']")
	private WebElement datasetName;
	
	@FindBy(xpath="//div[@class='d-flex justify-content-center align-items-center my-2']")
	private WebElement chooseAFile;
	
	@FindBy(xpath="//button[@data-testid='training-data-upload-btn']")
	private WebElement upload;
	
	@FindBy(xpath="(//div[@class= 'regid-action'])[1]")
	private WebElement EditRegId;
	
	@FindBy(xpath="(//div[@class= 'regid-action'])[2]")
	private WebElement DeleteRegId;

	public WebElement getUpload() {
		return upload;
	}

	public WebElement getChooseAFile() {
		return chooseAFile;
	}
	
	public WebElement getEditRegId() {
		return EditRegId;
	}
	
	public WebElement getDeleteRegId() {
		return DeleteRegId;
	}
	
	

}
