package com.runner;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
                {"Srinivasan", "Sud", "twinarcdemo@gmail.com", "Customer"},
                {"James", "Smith", "smithjamesjs7189@gmail.com", "Data Scientist"},
                {"William", "John", "johnwillamsjw2000@gmail.com", "Developer"}
        };
        return data;
    }

    @Test(testName = "Create_user's", priority = 0,dataProvider = "userData")
    public void createUser(String firstName, String lastName, String email, String role) throws InterruptedException {
        pm = new Pom_Manager(driver);
        Thread.sleep(10000);
//        WebDriverWait wait0 = new WebDriverWait(driver, Duration.ofSeconds(10000));
//        wait0.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[text()='Incorrect password']")));
        
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Create User']")));
        BaseClass_Element_Methods.click(pm.ul().getCreateUser());
        Thread.sleep(10000);
//        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
//        wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.id("create-user-first-name-input")));
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
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']")));
            System.out.println("Success!.... "+role+" Created");
        } catch (Exception e) {
            System.out.println("Failed?....on creating "+role+" Profile");
        }
//        Thread.sleep(10000);
    }   
    
    
    @Test(testName= "Search_Customer", priority = 1)
    public void searchCustomer() throws InterruptedException {
    	
//    	Thread.sleep(5000);
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    	wait.until(ExpectedConditions.visibilityOfElementLocated
    			(By.xpath("//input[@placeholder='Search by name, email, phone']")));
    	BaseClass_Element_Methods.sendKeys(pm.ul().getSearchBox(),"Srinivasan");
    	//Thread.sleep(1000);
    	WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='twinarcdemo@gmail.com']")));
    	
    	String customerEmail=BaseClass_Element_Methods.getText(pm.ul().getCustomerMail());
    	String customerStatus=BaseClass_Element_Methods.getText(pm.ul().getCustomerStatus());
        Assert.assertEquals(customerEmail,"twinarcdemo@gmail.com"); 
        Assert.assertEquals(customerStatus, "Inactive");
        Thread.sleep(3000);
        BaseClass_Driver_Methods.navigateBack(driver);
        System.out.println("success!....search customer");
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Search by name, email, phone']")));
//        Thread.sleep(3000);
	}
    
    
    @Test(testName= "Search_DataScientist",priority = 2)
    public void searchDatascientist() throws InterruptedException {
		
//    	Thread.sleep(5000);
    	BaseClass_Element_Methods.sendKeys(pm.ul().getSearchBox(), "JAMES");
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='smithjamesjs7189@gmail.com']")));
//    	Thread.sleep(1000);
    	
        String datascientistEmail=	BaseClass_Element_Methods.getText(pm.ul().getDatascientistEmail());
        String datascientStatus=BaseClass_Element_Methods.getText(pm.ul().getDatascientistStatus());
        
        Assert.assertEquals(datascientStatus, "Active");
        Assert.assertEquals(datascientistEmail, "smithjamesjs7189@gmail.com");
        Thread.sleep(3000);
        BaseClass_Driver_Methods.navigateBack(driver);
        System.out.println("success!....search Data scientist");
//        Thread.sleep(3000);
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Search by name, email, phone']")));
	}  
    
    
    @Test(testName= "Search_Developer", priority = 3)
    public void searchDeveloper() throws InterruptedException {
		
//    	Thread.sleep(5000);
    	BaseClass_Element_Methods.sendKeys(pm.ul().getSearchBox(), "WILLIAM");
//    	Thread.sleep(1000);
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='johnwillamsjw2000@gmail.com']")));
    	
    	String developerEmail=BaseClass_Element_Methods.getText(pm.ul().getDeveloperEmail());
    	String developerStatus=BaseClass_Element_Methods.getText(pm.ul().getDeveloperStatus());
    	Assert.assertEquals(developerStatus, "Active");
    	Assert.assertEquals(developerEmail, "johnwillamsjw2000@gmail.com");	
    	Thread.sleep(3000);
    	BaseClass_Driver_Methods.navigateBack(driver);
    	System.out.println("success!....search Developer");
//    	Thread.sleep(3000);
    	WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
    			("//input[@placeholder='Search by name, email, phone']")));
	}
    
    
    @Test(testName= "Delete_Customer", priority = 4)//dlt customer
    public void deleteCustomer() throws InterruptedException {
    	Thread.sleep(2000);
    	BaseClass_Element_Methods.sendKeys(pm.ul().getSearchBox(),"twinarcdemo@gmail.com");
    	Thread.sleep(1000);
//    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
//    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
//    			("(//img[@data-testid= 'delete-icon'])[1]")));
    	
    	BaseClass_Element_Methods.click(pm.ul().getDeleteCustomer());
//    	WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(2));
//    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
//    			("//button[text()='Delete']")));
    	Thread.sleep(3000);
    	BaseClass_Element_Methods.click(pm.ul().getDeleteUser());
    	Thread.sleep(2000);
    	BaseClass_Driver_Methods.navigateBack(driver);
    	System.out.println("success!....Delete customer"+" Srinivasan Sud");
//    	Thread.sleep(3000);
    	Thread.sleep(2000);
    	WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(5));
    	wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
    			("//input[@placeholder='Search by name, email, phone']")));
	}
    
    
    @Test(testName= "Delete_DataScientist", priority = 5)//dlt Datascientist
    public void deleteDatascientist() throws InterruptedException {
    	Thread.sleep(2000);
    	BaseClass_Element_Methods.sendKeys(pm.ul().getSearchBox(), "JAMES");
    	Thread.sleep(1000);
//    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
//    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//img[@data-testid= 'delete-icon'])[1]")));
    	
		BaseClass_Element_Methods.click(pm.ul().getDeletedatascientist());
		Thread.sleep(3000);
//		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(3));
//    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Delete']")));
		BaseClass_Element_Methods.click(pm.ul().getDeleteUser());
		Thread.sleep(2000);
		BaseClass_Driver_Methods.navigateBack(driver);
		System.out.println("success!....Delete Data scientist"+" James Smith");
//		Thread.sleep(3000);
		Thread.sleep(2000);
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(5));
    	wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Search by name, email, phone']")));
	}
    
    
    @Test(testName= "Delete_Developer", priority = 6)//dlt developer
    public void deleteDeveloper() throws InterruptedException {
    	Thread.sleep(2000);
    	BaseClass_Element_Methods.sendKeys(pm.ul().getSearchBox(), "WILLIAM");
    	Thread.sleep(1000);
//    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//img[@data-testid= 'delete-icon'])[1]")));
		BaseClass_Element_Methods.click(pm.ul().getDeleteDeveloper());
		Thread.sleep(3000);
//		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(3));
//		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Delete']")));
		BaseClass_Element_Methods.click(pm.ul().getDeleteUser());
		
		Thread.sleep(2000);
		BaseClass_Driver_Methods.navigateBack(driver);
		System.out.println("success!....Delete Developer"+" William Jhon");
		Thread.sleep(2000);
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(2));
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='avatar']")));
	    
	    BaseClass_Element_Methods.click(pm.up().getClickProfile());
	    WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='avatar']")));
            System.out.println("success!....Admin profile clicked");
        } catch (Exception e) {
            System.out.println("Failed?.... on click Admin profile");
        }
	    Thread.sleep(1000);
	    BaseClass_Element_Methods.click(pm.up().getViewProfile());
	    WebDriverWait alwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        alwait.until(ExpectedConditions.urlToBe("https://digitaltwinarc-uat.ddns.net/profile"));
        String adminUrl = driver.getCurrentUrl();
        System.out.println(adminUrl);
        if(adminUrl != "https://digitaltwinarc-uat.ddns.net/userlist" ) {
        	System.out.println("success!....Admin view profile clicked");
        }else {
        	System.out.println("Failed?....Unable to click Admin view profile");
        }    
    }
    
    
}
