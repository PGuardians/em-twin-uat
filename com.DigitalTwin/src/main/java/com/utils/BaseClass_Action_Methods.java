package com.utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BaseClass_Action_Methods {
	
	
	public static void dragAndDrop(WebDriver driver,WebElement element1,WebElement element2) {
		Actions action=new Actions(driver);
		action.dragAndDrop(element1, element2).build().perform();	
	}
	
	public static void contextClick_Webelement(WebDriver driver,WebElement element) {
		Actions action=new Actions(driver);
		action.contextClick(element).build().perform();
	}
	
	public static void contextClick(WebDriver driver){
		Actions action=new Actions(driver);
		action.contextClick().build().perform();	
	}
}