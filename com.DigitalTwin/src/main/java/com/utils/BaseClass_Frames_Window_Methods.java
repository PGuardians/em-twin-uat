package com.utils;

import org.openqa.selenium.WebDriver;

public class BaseClass_Frames_Window_Methods {
	
	public static WebDriver driver;
	
	public BaseClass_Frames_Window_Methods(WebDriver _driver) {
		driver=_driver;		
	}
	
	public static void windowHandle() {
		driver.getWindowHandle();
	}
	
	public static void windowHandles() {
		driver.getWindowHandles();
	}
	
	public static void switchWindow(String windowhandle) {
		driver.switchTo().window(windowhandle);
	}
	
	public static void frameIndex(int index) {		
        driver.switchTo().frame(index);
	}
	
	public static void frameString(String frame){		
		driver.switchTo().frame(frame);		
	}
	
	public static void defaultFrame() {
		driver.switchTo().defaultContent();
	}

}
