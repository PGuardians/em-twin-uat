package com.runner;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.base.BaseClass;
import com.pom_manager.Pom_Manager;
import com.utils.BaseClass_Driver_Methods;
import com.utils.BaseClass_Element_Methods;

public class userList_Runner extends BaseClass {

    private Pom_Manager pm;

    @DataProvider(name = "userData")
    public Object[][] getUserData() {
    	
        Object[][] data = new Object[][]{
                {"Srinivasan", "Sud", "sivasri691995@gmail.com", "Customer"},
                {"James", "Smith", "smithjamesjs7189@gmail.com", "Data Scientist"},
                {"William", "John", "johnwillamsjw2000@gmail.com", "Developer"}
        };
        return data;
    }

    @Test(priority = 0,dataProvider = "userData")
    public void createUser(String firstName, String lastName, String email, String role) throws InterruptedException {
        pm = new Pom_Manager(driver);
        Thread.sleep(10000);
        BaseClass_Element_Methods.click(pm.ul().getCreateUser());
        Thread.sleep(10000);
        BaseClass_Element_Methods.sendKeys(pm.ul().getFirstName(), firstName);
        BaseClass_Element_Methods.sendKeys(pm.ul().getLastName(), lastName);
        BaseClass_Element_Methods.sendKeys(pm.ul().getEmailId(), email);
        BaseClass_Element_Methods.click(pm.ul().getSelectRole());

        switch (role) {
            case "Customer":
                BaseClass_Element_Methods.click(pm.ul().getSelectCustomer());
                break;
            case "Data Scientist":
                BaseClass_Element_Methods.click(pm.ul().getSelectDataScientist());
                break;
            case "Developer":
                BaseClass_Element_Methods.click(pm.ul().getSelectDeveloper());
                break;
            default:
                break;
        }
        
        BaseClass_Element_Methods.click(pm.ul().getCreate());
        Thread.sleep(10000);
    }
    
    
    @Test(priority = 1)
    public void searchCustomer() throws InterruptedException {
    	
    	Thread.sleep(5000);
    	BaseClass_Element_Methods.sendKeys(pm.ul().getSearchBox(),"Srinivasan");
    	Thread.sleep(1000);
    	
    	String customerEmail=BaseClass_Element_Methods.getText(pm.ul().getCustomerMail());
    	String customerStatus=BaseClass_Element_Methods.getText(pm.ul().getCustomerStatus());
        Assert.assertEquals(customerEmail,"sivasri691995@gmail.com"); 
        Assert.assertEquals(customerStatus, "Inactive");
        Thread.sleep(1000);
        BaseClass_Driver_Methods.navigateBack(driver);  	
	}
    
    @Test(priority = 2)
    public void searchDatascientist() throws InterruptedException {
		
    	Thread.sleep(5000);
    	BaseClass_Element_Methods.sendKeys(pm.ul().getSearchBox(), "JAMES");
    	Thread.sleep(1000);
    	
    	
        String datascientistEmail=	BaseClass_Element_Methods.getText(pm.ul().getDatascientistEmail());
        String datascientStatus=BaseClass_Element_Methods.getText(pm.ul().getDatascientistStatus());
        
        Assert.assertEquals(datascientStatus, "Active");
        Assert.assertEquals(datascientistEmail, "smithjamesjs7189@gmail.com");
        Thread.sleep(1000);
        BaseClass_Driver_Methods.navigateBack(driver);
	}  
    
    @Test(priority = 3)
    public void searchDeveloper() throws InterruptedException {
		
    	Thread.sleep(5000);
    	BaseClass_Element_Methods.sendKeys(pm.ul().getSearchBox(), "WILLIAM");
    	Thread.sleep(1000);
    	
    	String developerEmail=BaseClass_Element_Methods.getText(pm.ul().getDeveloperEmail());
    	String developerStatus=BaseClass_Element_Methods.getText(pm.ul().getDeveloperStatus());
    	Assert.assertEquals(developerStatus, "Active");
    	Assert.assertEquals(developerEmail, "johnwillamsjw2000@gmail.com");	
    	Thread.sleep(1000);
    	BaseClass_Driver_Methods.navigateBack(driver);
    	Thread.sleep(2000);
	}
    
    @Test(priority = 4)//dlt customer
    public void deleteCustomer() throws InterruptedException {
    	Thread.sleep(5000);
    	BaseClass_Element_Methods.sendKeys(pm.ul().getSearchBox(),"sivasri691995@gmail.com");
    	Thread.sleep(1000);
    	
    	BaseClass_Element_Methods.click(pm.ul().getDeleteCustomer());
    	Thread.sleep(3000);
    	BaseClass_Element_Methods.click(pm.ul().getDeleteUser());
    	BaseClass_Driver_Methods.navigateBack(driver);
    	Thread.sleep(3000);
	}
    
    @Test(priority = 5)//dlt Datascientist
    public void deleteDatascientist() throws InterruptedException {
    	Thread.sleep(5000);
    	BaseClass_Element_Methods.sendKeys(pm.ul().getSearchBox(), "JAMES");
    	Thread.sleep(1000);
    	
		BaseClass_Element_Methods.click(pm.ul().getDeletedatascientist());
		Thread.sleep(3000);
		BaseClass_Element_Methods.click(pm.ul().getDeleteUser());
		BaseClass_Driver_Methods.navigateBack(driver);
		Thread.sleep(3000);
	}
    
    @Test(priority = 6)//dlt developer
    public void deleteDeveloper() throws InterruptedException {
    	Thread.sleep(5000);
    	BaseClass_Element_Methods.sendKeys(pm.ul().getSearchBox(), "WILLIAM");
    	Thread.sleep(1000);
    	
		BaseClass_Element_Methods.click(pm.ul().getDeleteDeveloper());
		Thread.sleep(5000);
		BaseClass_Element_Methods.click(pm.ul().getDeleteUser());
		BaseClass_Driver_Methods.navigateBack(driver);
	    BaseClass_Driver_Methods.refresh(driver);
	    Thread.sleep(2000);
	    BaseClass_Element_Methods.click(pm.up().getClickProfile());
	    Thread.sleep(1000);
	    BaseClass_Element_Methods.click(pm.up().getViewProfile());
	}
    
    
}