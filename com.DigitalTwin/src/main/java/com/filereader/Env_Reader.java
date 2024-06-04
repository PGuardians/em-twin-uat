package com.filereader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Env_Reader {
public static String getPropertyFromKey(String key) throws IOException {
		
		Properties property = new Properties();
		FileInputStream Apass=null;
		
	try {
		
		Apass=new FileInputStream("Config/env.properties");
	}
	catch (FileNotFoundException e) {
		System.out.println("Unable to locate config.properties file.");
	}
	
	try {
		property.load(Apass);
	} catch (IOException e) {
		System.out.println("Unable to open config.properties file.");
	}
	
		return property.getProperty(key);
	}

public static String getPropertyFromKey1(String key) throws IOException {
	
	Properties property = new Properties();
	FileInputStream Apass=null;
	
try {
	
	Apass=new FileInputStream("C:\\Users\\Dell\\Downloads\\com.DigitalTwin(2)\\com.DigitalTwin\\Config\\env.properties");
}
catch (FileNotFoundException e) {
	System.out.println("Unable to locate config.properties file.");
}

try {
	property.load(Apass);
} catch (IOException e) {
	System.out.println("Unable to open config.properties file.");
}

	return property.getProperty(key);
}
	

}
