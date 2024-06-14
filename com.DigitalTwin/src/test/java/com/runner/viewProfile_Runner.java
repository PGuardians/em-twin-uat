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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.filereader.Env_Reader;
import com.pom_manager.Pom_Manager;
import com.utils.BaseClass_Element_Methods;

public class viewProfile_Runner extends BaseClass{
	
	 static String newPassword;
	 public Pom_Manager pm;
	 
//	 String [][] data3= {
//		 {"Eminds@123"},
//		 {"Eminds@3364"}
//	 };
	
	@Test(priority = 0, dependsOnMethods = {"com.runner.userList_Runner.deleteDeveloper"})
	public void clickChangePassword() throws InterruptedException 
	{
		 pm = new Pom_Manager(driver);		
		 Thread.sleep(2000);
		 //BaseClass_Element_Methods.click(pm.up().getChangePassword());
		 	
		 JavascriptExecutor executor = (JavascriptExecutor)driver;
		 executor.executeScript("arguments[0].click();", pm.up().getChangePassword());//click on change password button		
	}
	
//	@DataProvider() 
//	public String [][] AdminForgetPWDP() {
//		return data3;
//	}
	
//	@Test(priority = 1,dependsOnMethods = {"com.runner.viewProfile_Runner.clickChangePassword"})
//	public void changePassword(String AdminNewPw) throws IOException {
//		WebDriverWait AConfirmPw = new WebDriverWait(driver, Duration.ofSeconds(5));
//		AConfirmPw.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@data-testid='updatepassword-current-password']")));
//		
//		String locn= Env_Reader.getPropertyFromKey("Apass");
//		FileReader fileReader = new FileReader(locn);
//		BufferedReader reade = new BufferedReader(fileReader);
//		WebElement AcrntPw = driver.findElement(By.xpath("//input[@data-testid='updatepassword-current-password']"));
//		BaseClass_Element_Methods.sendKeys(pm.up().getCurrentPassword(), reade.readLine());
//		WebElement asd = driver.findElement(By.xpath("//input[@data-testid='updatepassword-current-password']"));
////		asd.sendKeys(com.runner.Login_Runner.);
//	}
	
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
        	Thread.sleep(2000);
	    }else {
	    	WebElement newpw1 = driver.findElement(By.xpath("//input[@data-testid='updatepassword-new-password']"));
	    	newpw1.sendKeys("Eminds@2");
	    	String np = BaseClass_Element_Methods.getAttribute(pm.up().getNewPassword());
        	System.out.println("New_Password:"+ np);
	    }
	   
	    if(crp.equalsIgnoreCase("Eminds@2")) {
	    	WebElement cnfm_new_pw = driver.findElement(By.xpath("//input[@data-testid='updatepassword-confirm-new-password']"));
	    	cnfm_new_pw.sendKeys("Eminds@1");
	    	String cnp = BaseClass_Element_Methods.getAttribute(pm.up().getConfirmnewPassword());
        	System.out.println("Confirm_New_Password:"+ cnp);
        	Thread.sleep(2000);
	    }else {
	    	WebElement cnfm_new_pw1 = driver.findElement(By.xpath("//input[@data-testid='updatepassword-confirm-new-password']"));
	    	cnfm_new_pw1.sendKeys("Eminds@2");
	    	String cnp = BaseClass_Element_Methods.getAttribute(pm.up().getConfirmnewPassword());
        	System.out.println("Confirm_New_Password:"+ cnp);
	    	}
	    
//	    // Create an instance of Random class
//	    Random random = new Random();
//
//	    // Generate an 8-digit random number
//	    int randomNumber = random.nextInt(9999) + 1;
//
//	    // Convert the random number to a string
//	       newPassword = String.valueOf("Eminds@"+randomNumber);
	   
     	    Thread.sleep(2000);
     	    BaseClass_Element_Methods.click(pm.up().getSaveChanges());
     	    
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
			Thread.sleep(3000);
		    String username = "dinesh@eminds.ai";
	        String password = newPassword;
	        Thread.sleep(5000);
	        BaseClass_Element_Methods.sendKeys(pm.lp().getUserName(), username);
	        BaseClass_Element_Methods.sendKeys(pm.lp().getPassWord(), password);
	        BaseClass_Element_Methods.click(pm.lp().getSubmit());
	        System.out.println("Re-login .... success!");		
	}
	
	@Test(priority = 3,dependsOnMethods = {"com.runner.viewProfile_Runner.checkLogin"})
	public void logOut() throws InterruptedException {
		 Thread.sleep(2000);
		 BaseClass_Element_Methods.click(pm.up().getClickProfile());
		 Thread.sleep(1000);
		 BaseClass_Element_Methods.click(pm.lp().getLogOut());
		 System.out.println("Re-logout .... success!");
		 driver.quit();
		 System.out.println("Admin...view...tab...closed");
	}	
}
