package com.utils;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass_Wait_Methods {
	
	public static WebDriver driver;
	
	public BaseClass_Wait_Methods(WebDriver _driver) {
		driver=_driver;
	}
	
	public static void implicitWait(int time) {	
		driver.manage().timeouts().implicitlyWait(time,TimeUnit.SECONDS);
	}
	
	public static void explicitWaitElementToBeClickable(Duration time,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public static void explicitWaitElementToBeVisible(Duration time,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOfAllElements(element));
	}
	
}
