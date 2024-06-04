package com.base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.filereader.ConfigReader;
import com.filereader.LogReader;
import com.utils.BaseClass_Driver_Methods;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
    public static WebDriver driver;
    
    

    public static WebDriver initializeDriver() throws IOException {
    	
    	String browserName = ConfigReader.getPropertyFromKey("browser");
		String url=ConfigReader.getPropertyFromKey("url");
        
        try {
            if (browserName.equalsIgnoreCase("chrome")) {
            	
                WebDriverManager.chromedriver().setup();
                
                driver = new ChromeDriver();
                
                LogReader.logInfo("chrome browser launched");
            } else if (browserName.equalsIgnoreCase("Edge")) {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            } else if (browserName.equalsIgnoreCase("Firefox")) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
            driver.manage().window().maximize();
            driver.navigate().to(url);
            LogReader.logInfo("url launched");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            LogReader.logError(e.getMessage());
        }
        
        return driver;
    }

    public static void quitDriver() {
        try {
            try {
                driver.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Creating instances of helper classes
	/* BaseClass_Driver_Methods BSDM = new BaseClass_Driver_Methods(driver); */
    // Add instances of other helper classes if needed
}
