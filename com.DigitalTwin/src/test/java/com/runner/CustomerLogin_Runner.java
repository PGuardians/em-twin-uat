package com.runner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.testng.annotations.Test;

import com.base.BaseClass;
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
    	String locn = "C:\\Users\\Dell\\Downloads\\com.DigitalTwin(2)\\com.DigitalTwin\\Cust_forgetPasskey.txt";
        FileReader fileReader = new FileReader(locn);
        BufferedReader readr = new BufferedReader(fileReader);
    	
        String username = "srinivasansudharsanan95@gmail.com";
        String password = readr.readLine();
        Thread.sleep(5000);
        BaseClass_Element_Methods.sendKeys(pm.cl().getCustomerUsername(), username);
        BaseClass_Element_Methods.sendKeys(pm.cl().getCustomerPassword(), password);
        BaseClass_Element_Methods.click(pm.cl().getLogin());
        Thread.sleep(2000);
    }    

    
    
    
}