package com.runner;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.filereader.Env_Reader;
import com.pom_manager.Pom_Manager;
import com.utils.BaseClass_Driver_Methods;
import com.utils.BaseClass_Element_Methods;

public class CustomerDashboard_Runner extends BaseClass {

	private Pom_Manager pm;

	@Test(priority = 0, dependsOnMethods = { "com.runner.CustomerLogin_Runner.loginCustomer" })
	public void uploadDataset() throws InterruptedException, AWTException, IOException {
		pm = new Pom_Manager(driver);

		BaseClass_Element_Methods.click(pm.cd().getCreateRegId());

		Random random = new Random();
		int i = random.nextInt(90) + 100;

		String datasetName = "RoyalEnfield" + i;

		BaseClass_Element_Methods.sendKeys(pm.cd().getDatasetName(), datasetName);

		BaseClass_Element_Methods.click(pm.cd().getClickCreateRegId());
		System.out.println("RegId ...."+datasetName+"....Created");
		Thread.sleep(2000);

		WebElement j = driver.findElement(By.xpath("//div[@class='dataset-name'][text()='" + datasetName + "']"));
		String attribute = j.getAttribute("data-testid");
		String regidName = attribute.substring(13, 21);

		WebElement clickUpload = driver.findElement(By.xpath("//button[@data-testid='upload-csv-button-" + regidName + "']"));

		Thread.sleep(3000);
		BaseClass_Element_Methods.click(clickUpload);

//		Thread.sleep(4000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
		wait.until(ExpectedConditions.visibilityOfElementLocated
				(By.xpath("//div[@class='d-flex justify-content-center align-items-center my-2']")));
		BaseClass_Element_Methods.click(pm.cd().getChooseAFile());
		
		  Thread.sleep(3000);
		  String file= Env_Reader.getPropertyFromKey("csvpath");
	      System.out.println("csv path: "+file);
		  //String file= "C:\\Users\\Dell\\Downloads\\com.DigitalTwin(2)\\com.DigitalTwin\\Resources\\batch-1-23x.csv";
		  file = file.replace("\\\\", "\\");
		  StringSelection stringSelection = new StringSelection(file);
		  
		  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		  
		  Robot robot=new Robot();
		  
		  robot.keyPress(KeyEvent.VK_CONTROL);
		  
		  robot.keyPress(KeyEvent.VK_V);
		  
		  robot.keyRelease(KeyEvent.VK_V);
		  
		  robot.keyRelease(KeyEvent.VK_CONTROL);
		  
		  robot.keyPress(KeyEvent.VK_ENTER);
		  
		  robot.keyRelease(KeyEvent.VK_ENTER);
		 
		  BaseClass_Element_Methods.click(pm.cd().getUpload());		
		  WebElement uploadClick = driver.findElement(By.xpath("//button[text()= 'UPLOAD']"));
		  uploadClick.click();
		  
//		  Thread.sleep(10000);
		  WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class= 'py-2 mx-auto text-center']")));
//		  WebElement clickOkButton = driver.findElement(By.xpath("//div[@class= 'py-2 mx-auto text-center']"));
//		  clickOkButton.click();
		  BaseClass_Element_Methods.click(pm.cd().getCustomerConfirmationOkButton());
		  System.out.println("The dataset has been successfully uploaded");
		  Thread.sleep(2000);
		  
		  
		  
		  
		  //edit reg id's
//		  driver.findElement(By.cssSelector("div.file-container svg[fill=\"none\"]")).click();
//		  Thread.sleep(2000);
//		  BaseClass_Element_Methods.click(pm.cd().getEditRegId());
//		  driver.findElement(By.xpath("//input[@data-testid= 'create-popup-dataset-input']")).sendKeys("4");
//		  driver.findElement(By.xpath("//button[@class= 'login_btn']")).click();
//		  Thread.sleep(3000);
		  
		  //delete reg id's 
//		  driver.findElement(By.cssSelector("div.file-container svg[fill=\"none\"]")).click();
//		  Thread.sleep(2000);
//		  BaseClass_Element_Methods.click(pm.cd().getDeleteRegId());
//		  driver.findElement(By.xpath("(//button[@class= 'me-2 px-3 py-2'])[1]")).click();
//		  driver.findElement(By.xpath("(//button[@class= 'me-2 px-3 py-2'])[2]")).click();
		
	}

}
