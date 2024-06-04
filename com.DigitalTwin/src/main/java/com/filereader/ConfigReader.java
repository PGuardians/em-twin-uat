package com.filereader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	public static String getPropertyFromKey(String key) throws IOException {
		
		Properties property = new Properties();
		FileInputStream propertyFile=null;
		
	try {
		
		 propertyFile=new FileInputStream("C:\\Users\\Dell\\Downloads\\com.DigitalTwin(2)\\com.DigitalTwin\\Config\\config.properties");
	}
	catch (FileNotFoundException e) {
		System.out.println("Unable to locate config.properties file.");
	}
	
	try {
		property.load(propertyFile);
	} catch (IOException e) {
		System.out.println("Unable to open config.properties file.");
	}
	
		return property.getProperty(key);
	}
}
