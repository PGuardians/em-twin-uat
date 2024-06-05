package com.runner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.filereader.Env_Reader;
import com.pom_manager.Pom_Manager;
import com.utils.BaseClass_Element_Methods;

public class viewProfile_Runner extends BaseClass{
	
	 static String newPassword;
	 public Pom_Manager pm;
	
	@Test(priority = 0, dependsOnMethods = {"com.runner.userList_Runner.deleteDeveloper"})
	public void clickChangePassword() throws InterruptedException 
	{
		 pm = new Pom_Manager(driver);		
		 Thread.sleep(2000);
		 //BaseClass_Element_Methods.click(pm.up().getChangePassword());
		 	
		 JavascriptExecutor executor = (JavascriptExecutor)driver;
		 executor.executeScript("arguments[0].click();", pm.up().getChangePassword());		
	}
	
	@Test(priority = 1,dependsOnMethods = {"com.runner.viewProfile_Runner.clickChangePassword"})
	public void changePassword() throws InterruptedException, IOException {
		
		Thread.sleep(2000);
		
		String locn= Env_Reader.getPropertyFromKey("Apass");
//		String locn = "C:\\Users\\Dell\\Downloads\\com.DigitalTwin(2)\\com.DigitalTwin\\forgetPasskey_Dictonary.txt";
        FileReader fileReader = new FileReader(locn);
        BufferedReader reade = new BufferedReader(fileReader);
        
	    BaseClass_Element_Methods.sendKeys(pm.up().getCurrentPassword(), reade.readLine());

	    // Create an instance of Random class
	    Random random = new Random();

	    // Generate an 8-digit random number
	    int randomNumber = random.nextInt(9999) + 1;

	    // Convert the random number to a string
	       newPassword = String.valueOf("Eminds@"+randomNumber);

	    BaseClass_Element_Methods.sendKeys(pm.up().getNewPassword(), newPassword);
	    BaseClass_Element_Methods.sendKeys(pm.up().getConfirmnewPassword(), newPassword); 
	    BaseClass_Element_Methods.click(pm.up().getSaveChanges());
	    System.out.println(newPassword);
	    
	    String filePath = Env_Reader.getPropertyFromKey("Apass");
//	    String filePath = "C:\\Users\\Dell\\Downloads\\com.DigitalTwin(2)\\com.DigitalTwin\\forgetPasskey_Dictonary.txt"; // Specify the path to your file
	    String content = newPassword; // New text to overwrite the file
        try {
            // Read the file content
            Path path = Paths.get(filePath);
            String contents = Files.readString(path);
            // Modify the content
            contents = newPassword;
            // Write the modified content back to the file
            Files.write(path, content.getBytes());
            System.out.println("File overwritten successfully.");
        } catch (IOException e) {
            System.err.println("Error occurred while overwriting the file: " + e.getMessage());
        }   
	}
	
	@Test(priority = 2,dependsOnMethods = {"com.runner.viewProfile_Runner.changePassword"})
	public void checkLogin() throws InterruptedException {
		
		    String username = "dinesh@eminds.ai";
	        String password = newPassword;
	        Thread.sleep(5000);
	        BaseClass_Element_Methods.sendKeys(pm.lp().getUserName(), username);
	        BaseClass_Element_Methods.sendKeys(pm.lp().getPassWord(), password);
	        BaseClass_Element_Methods.click(pm.lp().getSubmit());
		
	}
	
	@Test(priority = 3,dependsOnMethods = {"com.runner.viewProfile_Runner.checkLogin"})
	public void logOut() throws InterruptedException {
		 Thread.sleep(2000);
		 BaseClass_Element_Methods.click(pm.up().getClickProfile());
		 Thread.sleep(1000);
		 BaseClass_Element_Methods.click(pm.lp().getLogOut());

	}
	
	
}
