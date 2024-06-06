package com.filereader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Env_Reader {
	
	static String InputStreams = "Config\\env.properties";
	
// Admin login - env
public static String getPropertyFromKey(String key) throws IOException {
		
		Properties property = new Properties();
		FileInputStream stream=null;
		
	try {
		
//		Apass=new FileInputStream("C:\\Users\\Dell\\Downloads\\com.DigitalTwin_Local\\em-twin-uat\\com.DigitalTwin\\Config\\env.properties");
		stream=new FileInputStream(InputStreams);
	}
	catch (FileNotFoundException e) {
		System.out.println("Unable to locate env.properties file.");
	}
	
	try {
		property.load(stream);
	} catch (IOException e) {
		System.out.println("Unable to open env.properties file.");
	}
	
		return property.getProperty(key);
	}

}
