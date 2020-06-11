package com.hrms.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigsReader {
	static FileInputStream fis;
	static Properties prop;

	/**
	 * @param String filePath (configuration.properties)
	 */
	public static void readConfigs(String filePath) {
		try {
			fis = new FileInputStream(filePath);
			prop = new Properties();
			prop.load(fis);
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param String key
	 * @return String value
	 */
	public static String getValueOfProperty(String key) {
		return prop.getProperty(key);
	}
}
