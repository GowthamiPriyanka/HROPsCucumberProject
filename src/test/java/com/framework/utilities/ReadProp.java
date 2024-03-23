package com.framework.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadProp {
	
	//will have common method to read data from properties file
	
	public static Properties readData(String filename) {
		Properties prop = new Properties();
		
			FileInputStream fis;
			try {
				fis = new FileInputStream(System.getProperty("user.dir")+"//Config//"+filename);
				prop.load(fis);//load all properties from file into variable
			} catch (FileNotFoundException e) {				
				e.printStackTrace();
			} catch (IOException e) {				
				e.printStackTrace();
			}
			
		
		return prop;
	}

}
