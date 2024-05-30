package com.runner;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pom_manager.Pom_Manager;
import com.utils.BaseClass_Driver_Methods;
import com.utils.BaseClass_Element_Methods;

public class CustomerDashboard_Runner extends BaseClass {

	private Pom_Manager pm;

	@Test(priority = 0, dependsOnMethods = { "com.runner.CustomerLogin_Runner.loginCustomer" })
	public void uploadDataset() throws InterruptedException, AWTException {
		pm = new Pom_Manager(driver);

		BaseClass_Element_Methods.click(pm.cd().getCreateRegId());

		Random random = new Random();
		int i = random.nextInt(90) + 100;

		String datasetName = "RoyalEnfield" + i;

		BaseClass_Element_Methods.sendKeys(pm.cd().getDatasetName(), datasetName);

		BaseClass_Element_Methods.click(pm.cd().getClickCreateRegId());

		Thread.sleep(2000);

		WebElement j = driver.findElement(By.xpath("//div[@class='dataset-name'][text()='" + datasetName + "']"));
		String attribute = j.getAttribute("data-testid");
		String regidName = attribute.substring(13, 21);

		WebElement clickUpload = driver
				.findElement(By.xpath("//button[@data-testid='upload-csv-button-" + regidName + "']"));

		Thread.sleep(2000);
		BaseClass_Element_Methods.click(clickUpload);

		Thread.sleep(1000);
		BaseClass_Element_Methods.click(pm.cd().getChooseAFile());
		
		Thread.sleep(3000);
		
		  String file=
		  "C:\\Users\\Dell\\Downloads\\com.DigitalTwin(2)\\com.DigitalTwin\\Resources\\batch-1-23x.csv";
		  file = file.replace("\\\\", "\\");
		  StringSelection stringSelection = new StringSelection(file);
		  
		  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection,
		  null);
		  
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
		  Thread.sleep(10000);
		  WebElement clickOkButton = driver.findElement(By.xpath("//div[@class= 'py-2 mx-auto text-center']"));
		  clickOkButton.click();
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
		  
		  
		  //-----------------------------------------------------------------------------------------------------------
		  //Test_samp_reg
		  
//		  BaseClass_Driver_Methods.refresh(driver);
//		  Thread.sleep(3000);
//		  
//		  BaseClass_Element_Methods.click(pm.cd().getCreateRegId1());
		  
//
//			Random rand = new Random();
//			int i1 = rand.nextInt(90) + 100;
//
//			String datasetName1 = "TestFile" + i1;
//
//			BaseClass_Element_Methods.sendKeys(pm.cd().getDatasetName1(), datasetName1);
//
//			BaseClass_Element_Methods.click(pm.cd().getClickCreateRegId1());
//			
//			driver.findElement(By.cssSelector("div.file-container svg[fill=\"none\"]")).click();
//			Thread.sleep(2000);
			

//			WebElement j = driver.findElement(By.xpath("//div[@class='dataset-name'][text()='" + datasetName1 + "']"));
//			String attribute1 = j.getAttribute("data-testid");
//			String regidName1 = attribute.substring(13, 21);
//			Thread.sleep(2000);

		  
		  //view-prof click and logout
//		  driver.findElement(By.xpath("//img[@alt= ' arrow-back']")).click();
//		  Actions action = new Actions(driver);
//		  action.moveToElement(driver.findElement(By.xpath("//div[@data-testid= 'header-logout']"))).click().perform();
//		  System.out.println("logged out success from the customer dashboard");
		  //WebElement customerDropDown = driver.findElement(By.xpath("//div[@class= 'popover-content']"));
		
	}

}
