package com.runner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.filereader.Env_Reader;
import com.pom_manager.Pom_Manager;
import com.utils.BaseClass_Element_Methods;

public class CustomerLogin_Runner extends BaseClass{
	
	 private Pom_Manager pm;
	
	@Test(priority = 0,dependsOnMethods = {"com.runner.viewProfile_Runner.logOut"})
	public void setUp() throws IOException {
        initializeDriver();
        pm = new Pom_Manager(driver); // Initialize Pom_Manager
    }
	
    @Test(priority = 1,dependsOnMethods= {"com.runner.CustomerLogin_Runner.setUp"})
	public void loginCustomer() throws InterruptedException, IOException {
    	Thread.sleep(2000);
    	
    	String customerId= Env_Reader.getPropertyFromKey("Customer");
        System.out.println("customerId: "+customerId);
//        String username = //"eminds.edge@gmail.com"; "srinivasansudharsanan95@gmail.com";  
        
        String locn1= Env_Reader.getPropertyFromKey("Cpass");
        System.out.println("location:"+locn1);
    	//String locn = "C:\\Users\\Dell\\Downloads\\com.DigitalTwin(2)\\com.DigitalTwin\\Cust_forgetPasskey.txt";
        FileReader fileReader = new FileReader(locn1);
        BufferedReader readr = new BufferedReader(fileReader);
        
        String password = readr.readLine();
        Thread.sleep(5000);
        BaseClass_Element_Methods.sendKeys(pm.cl().getCustomerUsername(), customerId);
        BaseClass_Element_Methods.sendKeys(pm.cl().getCustomerPassword(), password);
        BaseClass_Element_Methods.click(pm.cl().getLogin());
        
        WebDriverWait alwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        alwait.until(ExpectedConditions.urlToBe("https://digitaltwinarc-uat.ddns.net/regid"));
        String adminUrl = driver.getCurrentUrl();
        System.out.println(adminUrl);
        if(adminUrl != "https://digitaltwinarc-uat.ddns.net/" ) {
        	System.out.println("Admin login -- SUCCESS...!");
        }else {
        	System.out.println("Admin login -- FAILED...?");
        }
        Thread.sleep(2000);
    }        
}
