package com.utils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class BaseClass_Screenshot_Scroll_Methods {

	public static WebDriver driver;
	
	public BaseClass_Screenshot_Scroll_Methods(WebDriver _driver) {
		_driver=driver;
	}
	
	public static void scrollMethod(int i,int j) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy("+i,j+")", "");
	}
	
	public static void scrollToElement(WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", element);

	}
	
	public static void scrollToBottom() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	
	/*
	 * public static void screenShot(String filename) throws IOException { String
	 * screenshotpath=ConfigReader.getPropertyFromKey("screenshotpath");
	 * 
	 * File destinationpath=new File(screenshotpath);
	 * 
	 * File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	 * FileUtils.copyFile(scrFile, destinationpath); }
	 */
	
}
