package com.runner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.base.BaseClass;
import com.filereader.Env_Reader;
import com.pom_manager.Pom_Manager;
import com.utils.BaseClass_Element_Methods;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Login_Runner extends BaseClass {

    private Pom_Manager pm; // Declare Pom_Manager
    

    @BeforeMethod
    public void setUp() throws IOException {
        initializeDriver();
        pm = new Pom_Manager(driver); // Initialize Pom_Manager
    }

   	@Test
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
        
    }    
}
