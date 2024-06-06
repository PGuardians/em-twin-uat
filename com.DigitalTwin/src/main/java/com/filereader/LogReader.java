package com.filereader;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.log4j.PropertyConfigurator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogReader {
    
    static {
    	//PropertyConfigurator.configure("C:\\Users\\Dell\\Downloads\\com.DigitalTwin_Local\\em-twin-uat\\com.DigitalTwin\\Config\\log4j.properties");
    	try {
			PropertyConfigurator.configure(Env_Reader.getPropertyFromKey("LogReader"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(LogReader.class);

    public static void logInfo(String message) {
        logger.info(message);
    }

    public static void logError(String message) {
        logger.error(message);
    }

    public static void logWarn(String message) {
        logger.warn(message);
    }

    public static void logDebug(String message) {
        logger.debug(message);
    }
}
