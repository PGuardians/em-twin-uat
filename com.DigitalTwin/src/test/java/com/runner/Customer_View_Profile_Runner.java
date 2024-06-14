package com.runner;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.base.BaseClass;
import com.filereader.Env_Reader;
import com.pom_manager.Pom_Manager;
import com.utils.BaseClass_Element_Methods;

public class Customer_View_Profile_Runner extends BaseClass{
	
	 static String Cus_newPassword;
	 public Pom_Manager pm;
	
	@Test(priority = 0, dependsOnMethods = {"com.runner.CustomerDashboard_Runner.uploadDataset"})
	public void clickChangeCustomerPassword() throws InterruptedException, AWTException 
	{
		 pm = new Pom_Manager(driver);		
		 Thread.sleep(5000);
//		 driver.findElement(By.xpath("//input[@data-testid='updatepassword-current-password']")).click();
		 BaseClass_Element_Methods.click(pm.cp().getClickProfile()); 
		 System.out.println("Customer profile clicked");
		 Thread.sleep(1000);
		 BaseClass_Element_Methods.click(pm.cp().getViewProfile());
		 System.out.println("Customer view profile clicked");
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//input[@data-testid= 'profile-user-lastname-input']")).sendKeys("S");
		 BaseClass_Element_Methods.click(pm.cp().getEditLastname());
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//input[@data-testid= 'profile-user-lastname-input']")).clear();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//input[@data-testid= 'profile-user-lastname-input']")).sendKeys("Devoop");
		 BaseClass_Element_Methods.click(pm.cp().getEditLastname());
		 Thread.sleep(2000);
//		 driver.findElement(By.xpath("//input[@data-testid= 'profile-user-lastname-input']")).sendKeys("VASAN");
		 BaseClass_Element_Methods.click(pm.cp().getEditLastname());
		 System.out.println("Last name edited successfully");
		 
		 JavascriptExecutor executor = (JavascriptExecutor)driver;
		 executor.executeScript("arguments[0].click();", pm.cp().getChangePassword());		
	}
	

	@Test(priority = 1,dependsOnMethods = {"com.runner.Customer_View_Profile_Runner.clickChangeCustomerPassword"})
	public void changeCustomerPassword() throws InterruptedException, IOException {
	
			Thread.sleep(2000);
			
		   String locn1= Env_Reader.getPropertyFromKey("Cpass");
		   //String locn1 = "C:\\\\Users\\\\Dell\\\\Downloads\\\\com.DigitalTwin(2)\\\\com.DigitalTwin\\\\Cust_forgetPasskey.txt";
		   FileReader fileReader1 = new FileReader(locn1);
		   BufferedReader reade1 = new BufferedReader(fileReader1);
		   
		   BaseClass_Element_Methods.sendKeys(pm.cp().getCurrentPassword(), reade1.readLine());
		   String Cus_crp = BaseClass_Element_Methods.getAttribute(pm.up().getCurrentPassword());
		   System.out.println("current_password:"+Cus_crp);
		
//		   // Create an instance of Random class
//		   Random random = new Random();
//		
//		   // Generate an 8-digit random number
//		   int randomNumber = random.nextInt(9999) + 1;
//		   
//		
//		   // Convert the random number to a string
//		      newPassword1 = String.valueOf("PoEminds@"+randomNumber);
		   
		   if(Cus_crp.equalsIgnoreCase("Customer@2")) {
		    	WebElement newpw = driver.findElement(By.xpath("//input[@data-testid='updatepassword-new-password']"));
		    	newpw.sendKeys("Customer@1");
		    	String np = BaseClass_Element_Methods.getAttribute(pm.up().getNewPassword());
	        	System.out.println("New_Password:"+ np);
	        	Thread.sleep(2000);
		    }else {
		    	WebElement newpw1 = driver.findElement(By.xpath("//input[@data-testid='updatepassword-new-password']"));
		    	newpw1.sendKeys("Customer@2");
		    	String np = BaseClass_Element_Methods.getAttribute(pm.up().getNewPassword());
	        	System.out.println("New_Password:"+ np);
		    }
		   
		    if(Cus_crp.equalsIgnoreCase("Customer@2")) {
		    	WebElement cnfm_new_pw = driver.findElement(By.xpath("//input[@data-testid='updatepassword-confirm-new-password']"));
		    	cnfm_new_pw.sendKeys("Customer@1");
		    	String cnp = BaseClass_Element_Methods.getAttribute(pm.up().getConfirmnewPassword());
	        	System.out.println("Confirm_New_Password:"+ cnp);
	        	Thread.sleep(2000);
		    }else {
		    	WebElement cnfm_new_pw1 = driver.findElement(By.xpath("//input[@data-testid='updatepassword-confirm-new-password']"));
		    	cnfm_new_pw1.sendKeys("Customer@2");
		    	String cnp = BaseClass_Element_Methods.getAttribute(pm.up().getConfirmnewPassword());
	        	System.out.println("Confirm_New_Password:"+ cnp);
		    	}
		
//		   BaseClass_Element_Methods.sendKeys(pm.cp().getNewPassword(), newPassword1);
//		   BaseClass_Element_Methods.sendKeys(pm.cp().getConfirmnewPassword(), newPassword1); 
		   BaseClass_Element_Methods.click(pm.cp().getSaveChanges());
		   Cus_newPassword = BaseClass_Element_Methods.getAttribute(pm.up().getConfirmnewPassword());
    	    System.out.println(Cus_newPassword);
		   
		   String filePath= Env_Reader.getPropertyFromKey("Cpass");
		   //String filePath = "C:\\Users\\Dell\\Downloads\\com.DigitalTwin(2)\\com.DigitalTwin\\Cust_forgetPasskey.txt"; // Specify the path to your file
		   String content = Cus_newPassword; // New text to overwrite the file
		   try {
		       // Read the file content
		       Path path = Paths.get(filePath);
		       String contents1 = Files.readString(path);
		       // Modify the content
		       contents1 = Cus_newPassword;
		       // Write the modified content back to the file
		       Files.write(path, content.getBytes());
		       System.out.println("File overwritten successfully.");
		   		} catch (IOException e) {
		       System.err.println("Error occurred while overwriting the file: " + e.getMessage());
		   		}   
	}

	
	@Test(priority = 2,dependsOnMethods = {"com.runner.Customer_View_Profile_Runner.changeCustomerPassword"})
	public void checkCustomerLogin() throws InterruptedException, IOException {
			
		   String customerId= Env_Reader.getPropertyFromKey("Customer");
	       System.out.println("customerId: "+customerId);
		   //String username = "eminds.edge@gmail.com"; //"srinivasansudharsanan95@gmail.com";  
	       String password = Cus_newPassword;
	       Thread.sleep(5000);
	       BaseClass_Element_Methods.sendKeys(pm.lp().getUserName(), customerId);
	       BaseClass_Element_Methods.sendKeys(pm.lp().getPassWord(), password);
	       BaseClass_Element_Methods.click(pm.lp().getSubmit());
	
	}

	@Test(priority = 3,dependsOnMethods = {"com.runner.Customer_View_Profile_Runner.checkCustomerLogin"})
	public void logOut() throws InterruptedException {
		 Thread.sleep(2000);
		 BaseClass_Element_Methods.click(pm.cp().getClickProfile());
		 Thread.sleep(1000);
		 BaseClass_Element_Methods.click(pm.lp().getLogOut());
		 System.out.println("Customer Logged out successfully");
		 driver.quit();
		 System.out.println("All the windows closed..");
	}
	
	@AfterTest()
	public void endTest() {
//		ExtentReports extents = ExtentManager.Login_Runner();
//		extentReport.flush();
		driver.quit();
	}
}
