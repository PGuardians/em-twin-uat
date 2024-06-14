package com.utils;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BaseClass_Element_Methods {

	
	  public static void sendKeys(WebElement element,String value) {	  
	  element.sendKeys(value); 
	  }
	    
	  public static void click(WebElement element) {		  
	  element.click(); 
	  }
	 
	  public static void isSelected(WebElement element) {
		  element.isSelected();		  
	  }
	  
	  public static void isDisplayed(WebElement element) {
		  element.isDisplayed();
	  }
	  
	  public static void isEnabled(WebElement element) {
		  element.isEnabled();
	  }
	  
	  public static String getText(WebElement element) {
		return  element.getText();
	  }
	  
	  public static String getAttribute(WebElement element) {
		  return element.getAttribute("value");
	  }
	  
	  public static void submit(WebElement element) {
		  element.submit();
	  }
	  
	  public static void location(WebElement element) {
		  Point point=element.getLocation();		  
		  int x= point.getX();
		  int y=point.getY();
	  }

	  public static void dropdownSelectByIndex(WebElement element,int index) {		  
		  Select select=new Select(element);
		  select.selectByIndex(index);	  
	  }
	  
	  public static void dropdownSelectByValue(WebElement element,String value) {		
		  Select select=new Select(element);
		  select.selectByValue(value);
	  }
	  
	  public static void dropdownSelectByVisibleTest(WebElement element,String text) {
		Select select =new Select(element);
		select.selectByVisibleText(text);
	  }
	  
	  
	  
}
