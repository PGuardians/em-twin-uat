package com.base;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.filereader.ConfigReader;
import com.filereader.Env_Reader;
import com.filereader.LogReader;
import com.utils.BaseClass_Driver_Methods;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
		
	 private static boolean isLinux() {
	        String osName = System.getProperty("os.name").toLowerCase();
	        return osName.contains("linux");
	    }

	public static WebDriver initializeDriver() throws IOException {

		String browserName = ConfigReader.getPropertyFromKey("browser");
		String url = ConfigReader.getPropertyFromKey("url");
		
		try {
			if (browserName.equalsIgnoreCase("chrome")) {

				/*
				 * //System.setProperty("webdriver.chrome.driver",
				 * "C:\\Users\\Dell\\Downloads\\com.DigitalTwin_Local\\em-twin-uat\\com.DigitalTwin\\chome\\chromedriver.exe"
				 * ); WebDriverManager.chromedriver().setup();
				 * 
				 * 
				 * ChromeOptions options = new ChromeOptions();
				 * options.setBinary(getChromeLocation()); options.addArguments("--headless");
				 * options.addArguments("--no-sandbox");
				 * options.addArguments("--disable-dev-shm-usage");
				 * 
				 * 
				 * driver = new ChromeDriver();
				 */
				
				if(isLinux()) {
					//System.setProperty("webdriver.chrome.driver", Env_Reader.getPropertyFromKey("Ldriverloc"));
					
					WebDriverManager.chromedriver().setup();
			    	 
//					 "C:\\Users\\Dell\\Downloads\\com.DigitalTwin_Local\\em-twin-uat\\com.DigitalTwin\\chome\\chromedriver.exe");
					 ChromeOptions chromeOptions = new ChromeOptions();
					 chromeOptions.addArguments("--no-sandbox");
					 chromeOptions.addArguments("--headless");
					 chromeOptions.addArguments("disable-gpu");
					 driver = new ChromeDriver(chromeOptions);
				}
				else
				{
					WebDriverManager.chromedriver().setup();
					
					driver = new ChromeDriver();
				}
				
				LogReader.logInfo("chrome browser launched");
			}   /*
			     * else if (browserName.equalsIgnoreCase("Edge")) {
				 * WebDriverManager.edgedriver().setup(); driver = new EdgeDriver(); } else if
				 * (browserName.equalsIgnoreCase("Firefox")) {
				 * WebDriverManager.firefoxdriver().setup(); driver = new FirefoxDriver(); }
				 */
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
	// BaseClass_Driver_Methods BSDM = new BaseClass_Driver_Methods(driver);
	// Add instances of other helper classes if needed
}
