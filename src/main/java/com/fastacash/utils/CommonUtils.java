package com.fastacash.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

public class CommonUtils {

	// public static String getPropertyValue(String key) {
	// Resource resource = new ("/src/main/webapp/WEB-INF/project.properties");
	// Properties props = null;
	// try {
	// props = PropertiesLoaderUtils.loadProperties(resource);
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// if(props != null) {
	// return props.getProperty(key);
	// }
	// return null;
	// }

	public static Properties getProjectProperties() {
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream(
					"src/main/webapp/WEB-INF/project.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}

	public static String getPropertyValue(String key) {
		Properties properties = getProjectProperties();
		return properties.getProperty(key);
	}

}
