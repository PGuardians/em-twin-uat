package com.runner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
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
		 executor.executeScript("arguments[0].click();", pm.up().getChangePassword());//click on change password button		
	}
	
	@Test(priority = 1,dependsOnMethods = {"com.runner.viewProfile_Runner.clickChangePassword"})
	public void changePassword() throws InterruptedException, IOException {
		
		Thread.sleep(2000);
		
		String locn= Env_Reader.getPropertyFromKey("Apass");
//		String locn = "C:\\Users\\Dell\\Downloads\\com.DigitalTwin(2)\\com.DigitalTwin\\forgetPasskey_Dictonary.txt";
        FileReader fileReader = new FileReader(locn);
        BufferedReader reade = new BufferedReader(fileReader);
        
	    BaseClass_Element_Methods.sendKeys(pm.up().getCurrentPassword(),reade.readLine());//entering-current-pw
	    String CurrentPw = reade.readLine();
	    String crp = BaseClass_Element_Methods.getAttribute(pm.up().getCurrentPassword());
	    System.out.println("current_password:"+crp);
	    
	    if(crp.equalsIgnoreCase("Eminds@2")) {
	    	WebElement newpw = driver.findElement(By.xpath("//input[@data-testid='updatepassword-new-password']"));
	    	newpw.sendKeys("Eminds@1");
	    	String np = BaseClass_Element_Methods.getAttribute(pm.up().getNewPassword());
        	System.out.println("New_Password:"+ np);
        	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
        			("//input[@data-testid='updatepassword-confirm-new-password']")));
	    }else {
	    	WebElement newpw1 = driver.findElement(By.xpath("//input[@data-testid='updatepassword-new-password']"));
	    	newpw1.sendKeys("Eminds@2");
	    	String np = BaseClass_Element_Methods.getAttribute(pm.up().getNewPassword());
        	System.out.println("New_Password:"+ np);
        	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
        			("//input[@data-testid='updatepassword-confirm-new-password']")));
	    }
	   
	    if(crp.equalsIgnoreCase("Eminds@2")) {
	    	WebElement cnfm_new_pw = driver.findElement(By.xpath("//input[@data-testid='updatepassword-confirm-new-password']"));
	    	cnfm_new_pw.sendKeys("Eminds@1");
	    	String cnp = BaseClass_Element_Methods.getAttribute(pm.up().getConfirmnewPassword());
        	System.out.println("Confirm_New_Password:"+ cnp);
        	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
        			("//button[@type='submit']")));
        	//Thread.sleep(2000);
	    }else {
	    	WebElement cnfm_new_pw1 = driver.findElement(By.xpath("//input[@data-testid='updatepassword-confirm-new-password']"));
	    	cnfm_new_pw1.sendKeys("Eminds@2");
	    	String cnp = BaseClass_Element_Methods.getAttribute(pm.up().getConfirmnewPassword());
        	System.out.println("Confirm_New_Password:"+ cnp);
        	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
        			("//button[@type='submit']")));
	    	}
	    
//	    // Create an instance of Random class
//	    Random random = new Random();
//
//	    // Generate an 8-digit random number
//	    int randomNumber = random.nextInt(9999) + 1;
//
//	    // Convert the random number to a string
//	       newPassword = String.valueOf("Eminds@"+randomNumber);
	   
     	    //Thread.sleep(2000);
     	    BaseClass_Element_Methods.click(pm.up().getSaveChanges());
     	   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	        try {
	            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']")));
	            System.out.println("success!....new password updated");
	        } catch (Exception e) {
	            System.out.println("Failed?....cannot able to update new password");
	        }	
     	    
     	    newPassword = BaseClass_Element_Methods.getAttribute(pm.up().getConfirmnewPassword());
     	    System.out.println(newPassword);
     	    Thread.sleep(3000);
     	    String filePath = Env_Reader.getPropertyFromKey("Apass");
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
//	}
//	    BaseClass_Element_Methods.sendKeys(pm.up().getNewPassword(), newPassword);
//	    BaseClass_Element_Methods.sendKeys(pm.up().getConfirmnewPassword(), newPassword); 
//	    BaseClass_Element_Methods.click(pm.up().getSaveChanges());
//	    System.out.println(newPassword);
//	    System.out.println("Update password .... success!");
//	    Thread.sleep(3000);
//	    String filePath = Env_Reader.getPropertyFromKey("Apass");
//	    String filePath = "C:\\Users\\Dell\\Downloads\\com.DigitalTwin(2)\\com.DigitalTwin\\forgetPasskey_Dictonary.txt"; // Specify the path to your file
//	    String content = newPassword; // New text to overwrite the file
//        try {
//            // Read the file content
//            Path path = Paths.get(filePath);
//            String contents = Files.readString(path);
//            // Modify the content
//            contents = newPassword;
//            // Write the modified content back to the file
//            Files.write(path, content.getBytes());
//            System.out.println("File overwritten successfully.");
//        } catch (IOException e) {
//            System.err.println("Error occurred while overwriting the file: " + e.getMessage());
//        }   
	}
	
	@Test(priority = 2,dependsOnMethods = {"com.runner.viewProfile_Runner.changePassword"})
	public void checkLogin() throws InterruptedException {
			//Thread.sleep(3000);

		    String username = "dinesh@eminds.ai";
	        String password = newPassword;
	        //Thread.sleep(5000);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-email-input")));
	        BaseClass_Element_Methods.sendKeys(pm.lp().getUserName(), username);
	        BaseClass_Element_Methods.sendKeys(pm.lp().getPassWord(), password);
	        BaseClass_Element_Methods.click(pm.lp().getSubmit());
	        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
	        try {
	            wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Login']")));
	            System.out.println("success!....Re-login");
	        } catch (Exception e) {
	            System.out.println("Failed?....Re-login");
	        }		
	}
	
	@Test(priority = 3,dependsOnMethods = {"com.runner.viewProfile_Runner.checkLogin"})
	public void logOut() throws InterruptedException {
		 //Thread.sleep(2000);
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='avatar']")));
		 BaseClass_Element_Methods.click(pm.up().getClickProfile());
		 //Thread.sleep(1000);
		 WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(3));
		 wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Logout']")));
		 
		 BaseClass_Element_Methods.click(pm.lp().getLogOut());
		 WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(5));
	        try {
	            wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Logout']")));
	            System.out.println("success!....Re-logout");
	        } catch (Exception e) {
	            System.out.println("Failed?....Re-logout");
	        }
	}	
	@AfterClass
	public void adminEnd() {
		driver.quit();
		 System.out.println("Admin...view...tab...closed");
	}
}
