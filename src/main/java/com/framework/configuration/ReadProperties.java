package com.framework.configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperties {
	
	private static ReadProperties readProperty = null;
		
	Properties prop = new Properties();
	InputStream input = null;
	
	public static ReadProperties getInstance()
	{
		if(readProperty == null)
		{
			return new ReadProperties(); 
		}else
		{
			return readProperty;
		}
	}
	
	public ReadProperties()
	{
		try {

			String filename = "config.properties";
			input = getClass().getClassLoader().getResourceAsStream(filename);
			if (input == null) {
				System.out.println("Sorry, unable to find " + filename);
				return;
			}

			prop.load(input);

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public String getProperty(String propertyName)
	{
		return prop.getProperty(propertyName);
	}

}
