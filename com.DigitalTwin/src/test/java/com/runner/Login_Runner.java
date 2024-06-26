package com.runner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.base.BaseClass;
import com.filereader.Env_Reader;
import com.pom_manager.Pom_Manager;
import com.utils.BaseClass_Element_Methods;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login_Runner extends BaseClass {

    private Pom_Manager pm; // Declare Pom_Manager
    ExtentReports extentReport;
    
    @BeforeMethod
    public void setUp() throws IOException {
        initializeDriver();
        pm = new Pom_Manager(driver); // Initialize Pom_Manager
        
        String reportPath= Env_Reader.getPropertyFromKey("repPath");
        System.out.println("Extent_Report_location:"+reportPath);
    }

   	@Test(testName = "Admin_Login_test")
    public void loginUser() throws InterruptedException, IOException {
        //String username = "dinesh@eminds.ai";
    	String username = Env_Reader.getPropertyFromKey("Admin");
    	System.out.println("Admin: "+username);
        
       String locn= Env_Reader.getPropertyFromKey("Apass");
       System.out.println("location:"+locn);
       
       
       // String locn = "C:\\Users\\Dell\\Downloads\\com.DigitalTwin(2)\\com.DigitalTwin\\forgetPasskey_Dictonary.txt";
        FileReader fileReader = new FileReader(locn);
        BufferedReader readr = new BufferedReader(fileReader);
        String password = readr.readLine();
        
//        String password = "Eminds@1";
        Thread.sleep(5000);
        BaseClass_Element_Methods.sendKeys(pm.lp().getUserName(), username);
        BaseClass_Element_Methods.sendKeys(pm.lp().getPassWord(), password);        
        BaseClass_Element_Methods.click(pm.lp().getSubmit());
        
        WebDriverWait alwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        alwait.until(ExpectedConditions.urlToBe("https://digitaltwinarc-uat.ddns.net/userlist"));
        String adminUrl = driver.getCurrentUrl();
        System.out.println(adminUrl);
        if(adminUrl != "https://digitaltwinarc-uat.ddns.net/" ) {
        	System.out.println("Admin login -- SUCCESS...!");
        }else {
        	System.out.println("Admin login -- FAILED...?");
        }
   	}    
}
