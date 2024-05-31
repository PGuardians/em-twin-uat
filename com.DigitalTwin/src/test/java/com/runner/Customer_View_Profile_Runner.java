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
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pom_manager.Pom_Manager;
import com.utils.BaseClass_Element_Methods;

public class Customer_View_Profile_Runner extends BaseClass{
	
	 static String newPassword1;
	 public Pom_Manager pm;
	 
	
	@Test(priority = 0, dependsOnMethods = {"com.runner.CustomerDashboard_Runner.uploadDataset"})
	public void clickChangeCustomerPassword() throws InterruptedException, AWTException 
	{
		 pm = new Pom_Manager(driver);		
		 Thread.sleep(5000);
//		 driver.findElement(By.xpath("//input[@data-testid='updatepassword-current-password']")).click();
		 BaseClass_Element_Methods.click(pm.cp().getClickProfile()); 
		 Thread.sleep(1000);
		 BaseClass_Element_Methods.click(pm.cp().getViewProfile());
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//input[@data-testid= 'profile-user-lastname-input']")).sendKeys("VASAN");
		 BaseClass_Element_Methods.click(pm.cp().getEditLastname());
		 Thread.sleep(2000);
//		 Robot robot = new Robot();
//		 robot.keyPress(KeyEvent.CTRL_MASK);
//		 robot.keyPress(KeyEvent.VK_A);
//		 robot.keyRelease(KeyEvent.VK_A);
//		 robot.keyRelease(KeyEvent.CTRL_MASK);
//		 robot.keyPress(KeyEvent.VK_BACK_SPACE);
//		 robot.keyRelease(KeyEvent.VK_BACK_SPACE);
		 
		 driver.findElement(By.xpath("//input[@data-testid= 'profile-user-lastname-input']")).clear();
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
			
			String locn1 = "/home/eminds/auto-test/em-twin-uat/com.DigitalTwin/Cust_forgetPasskey.txt";
		   FileReader fileReader1 = new FileReader(locn1);
		   BufferedReader reade1 = new BufferedReader(fileReader1);
		   
		   BaseClass_Element_Methods.sendKeys(pm.cp().getCurrentPassword(), reade1.readLine());
		
//		   // Create an instance of Random class
		   Random random = new Random();
		
		   // Generate an 8-digit random number
		   int randomNumber = random.nextInt(9) + 1;
		
		   // Convert the random number to a string
		      newPassword1 = String.valueOf("Customer@"+randomNumber);
		
		   BaseClass_Element_Methods.sendKeys(pm.cp().getNewPassword(), newPassword1);
		   BaseClass_Element_Methods.sendKeys(pm.cp().getConfirmnewPassword(), newPassword1); 
		   BaseClass_Element_Methods.click(pm.cp().getSaveChanges());
		   System.out.println(newPassword1);
		   
		   String filePath = "/home/eminds/auto-test/em-twin-uat/com.DigitalTwin/Cust_forgetPasskey.txt"; // Specify the path to your file
		   String content = newPassword1; // New text to overwrite the file
		   try {
		       // Read the file content
		       Path path = Paths.get(filePath);
		       String contents1 = Files.readString(path);
		       // Modify the content
		       contents1 = newPassword1;
		       // Write the modified content back to the file
		       Files.write(path, content.getBytes());
		       System.out.println("File overwritten successfully.");
		   		} catch (IOException e) {
		       System.err.println("Error occurred while overwriting the file: " + e.getMessage());
		   		}   
	}

	
	@Test(priority = 2,dependsOnMethods = {"com.runner.Customer_View_Profile_Runner.changeCustomerPassword"})
	public void checkCustomerLogin() throws InterruptedException {
	
		   String username = "srinivasansudharsanan95@gmail.com";
	       String password = newPassword1;
	       Thread.sleep(5000);
	       BaseClass_Element_Methods.sendKeys(pm.lp().getUserName(), username);
	       BaseClass_Element_Methods.sendKeys(pm.lp().getPassWord(), password);
	       BaseClass_Element_Methods.click(pm.lp().getSubmit());
	
	}

	
	@Test(priority = 3,dependsOnMethods = {"com.runner.Customer_View_Profile_Runner.checkCustomerLogin"})
	public void logOut() throws InterruptedException {
		 Thread.sleep(2000);
		 BaseClass_Element_Methods.click(pm.cp().getClickProfile());
		 Thread.sleep(1000);
		 BaseClass_Element_Methods.click(pm.lp().getLogOut());
	}
}
