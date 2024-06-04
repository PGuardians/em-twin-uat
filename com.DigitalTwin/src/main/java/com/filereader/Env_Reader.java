package com.filereader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Env_Reader {
// Admin login - env
public static String getPropertyFromKey(String key) throws IOException {
		
		Properties property = new Properties();
		FileInputStream Apass=null;
		
	try {
		
		Apass=new FileInputStream("C:\\Users\\Dell\\Downloads\\com.DigitalTwin(2)\\com.DigitalTwin\\Config\\env.properties");
	}
	catch (FileNotFoundException e) {
		System.out.println("Unable to locate env.properties file for Admin.");
	}
	
	try {
		property.load(Apass);
	} catch (IOException e) {
		System.out.println("Unable to open env.properties file for Admin.");
	}
	
		return property.getProperty(key);
	}

// Customer login - env
public static String getPropertyFromKey1(String key) throws IOException {
	
	Properties property1 = new Properties();
	FileInputStream Cpass=null;
	
try {
	
	Cpass=new FileInputStream("C:\\Users\\Dell\\Downloads\\com.DigitalTwin(2)\\com.DigitalTwin\\Config\\env.properties");
}
catch (FileNotFoundException e) {
	System.out.println("Unable to locate env.properties file for customer.");
}

try {
	property1.load(Cpass);
} catch (IOException e) {
	System.out.println("Unable to open env.properties file for customer.");
}

	return property1.getProperty(key);
}

//Upload csv - env
public static String getPropertyFromKey2(String key) throws IOException {
	
	Properties property2 = new Properties();
	FileInputStream csvpath=null;
	
try {
	
	csvpath=new FileInputStream("C:\\Users\\Dell\\Downloads\\com.DigitalTwin(2)\\com.DigitalTwin\\Config\\env.properties");
}
catch (FileNotFoundException e) {
	System.out.println("Unable to locate env.properties file for upload csv.");
}

try {
	property2.load(csvpath);
} catch (IOException e) {
	System.out.println("Unable to open env.properties file for upload csv.");
}

	return property2.getProperty(key);
}
	
}
