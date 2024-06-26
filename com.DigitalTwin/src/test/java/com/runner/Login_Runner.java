package com.runner;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.BaseClass;
import com.filereader.Env_Reader;
import com.pom_manager.Pom_Manager;
import com.utils.BaseClass_Element_Methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login_Runner extends BaseClass {

    private Pom_Manager pm; // Declare Pom_Manager
    SoftAssert SoftAssert = new SoftAssert();
    
    String [][] data= {
        	{"dinesh@eminds.ai", "Eminds@1"},
        	{"dinesh@eminds.ai", "Eminds@2"}
        };
    
    @BeforeMethod
    public void setUp() throws IOException {
        initializeDriver();
        pm = new Pom_Manager(driver); // Initialize Pom_Manager
        
        String reportPath= Env_Reader.getPropertyFromKey("repPath");
        System.out.println("Extent_Report_location:"+reportPath);
        
        
    }
    //----nw->
    @DataProvider(name= "LoginData")
	public String[][] AdminLogDP() {
	return data;
    }

   	@Test(testName = "Admin_Login_test", dataProvider = "LoginData")
    public void loginUser(String username, String password) 
    		throws InterruptedException, IOException {
   		
    	WebDriverWait adminid = new WebDriverWait(driver, Duration.ofSeconds(5));
    	adminid.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id= 'login-email-input']")));
    	WebElement uid = driver.findElement(By.xpath("//input[@id= 'login-email-input']"));
    	uid.sendKeys(username);
    	WebElement upw = driver.findElement(By.xpath("//input[@id= 'login-password-input']"));
    	upw.sendKeys(password);
//    	String filePath = Env_Reader.getPropertyFromKey("Currentpasswd");
//    	String content = password; // New text to overwrite the file
    	BaseClass_Element_Methods.click(pm.lp().getSubmit());
    	String CurrentAdminPswd = password;
    	System.out.println(CurrentAdminPswd);
    	Thread.sleep(2000);

    	String actualErrorMsg = driver.findElement(By.xpath("//div[text()='Incorrect password']")).getText();
    	System.out.println("Actual_ErrorMsg: "+actualErrorMsg);
    	String expectedErrorMsg = "Incorrect password";
    	SoftAssert.assertEquals(actualErrorMsg, expectedErrorMsg, "Login failed with msg as "+actualErrorMsg);
    	
    	if (actualErrorMsg.equalsIgnoreCase(expectedErrorMsg)) {
    		driver.quit();
    	}

//      try {
//          // Read the file content
//          Path path = Paths.get(filePath);
//          String contents = Files.readString(path);
//          // Modify the content
//          contents = password;
//          System.out.println(contents);
//          // Write the modified content back to the file
//          Files.write(path, content.getBytes());
//          System.out.println("File overwritten successfully.");
//      } catch (IOException e) {
//          System.err.println("Error occurred while overwriting the file: " + e.getMessage());
//      }   
    	 
//    	WebElement asub = driver.findElement(By.xpath("//button[text()='Login']"));
//    	asub.click();
    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement loginMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id
        		("//input[@placeholder= 'Search by name, email, phone']")));

        // Verify login message with soft assertion
//        softAssert.assertEquals(loginMessage.getText());
    	
    	WebDriverWait alwait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	alwait.until(ExpectedConditions.urlToBe("https://digitaltwinarc-uat.ddns.net/userlist"));
    	String adminUrl = driver.getCurrentUrl();
    	System.out.println(adminUrl);
    	if(adminUrl != "https://digitaltwinarc-uat.ddns.net/" ) {
      	System.out.println("Admin login -- SUCCESS...!");
    	}else {
      	System.out.println("Admin login -- FAILED...?");
      	SoftAssert.assertAll();
      	Thread.sleep(5000);
    	}
        //---------nw<-
   		//String username = "dinesh@eminds.ai";
//    	String username = Env_Reader.getPropertyFromKey("Admin");
//    	System.out.println("Admin: "+username);
//        
//       String locn= Env_Reader.getPropertyFromKey("Apass");
//       System.out.println("location:"+locn);
//       
//       
//       // String locn = "C:\\Users\\Dell\\Downloads\\com.DigitalTwin(2)\\com.DigitalTwin\\forgetPasskey_Dictonary.txt";
//        FileReader fileReader = new FileReader(locn);
//        BufferedReader readr = new BufferedReader(fileReader);
//        String password = readr.readLine();
//        
//        Thread.sleep(5000);
//        BaseClass_Element_Methods.sendKeys(pm.lp().getUserName(), username);
//        BaseClass_Element_Methods.sendKeys(pm.lp().getPassWord(), password);        
//        BaseClass_Element_Methods.click(pm.lp().getSubmit());
//        
//        WebDriverWait alwait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        alwait.until(ExpectedConditions.urlToBe("https://digitaltwinarc-uat.ddns.net/userlist"));
//        String adminUrl = driver.getCurrentUrl();
//        System.out.println(adminUrl);
//        if(adminUrl != "https://digitaltwinarc-uat.ddns.net/" ) {
//        	System.out.println("Admin login -- SUCCESS...!");
//        }else {
//        	System.out.println("Admin login -- FAILED...?");
//        }
   	}    
}
