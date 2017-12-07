package com.tcf.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {
	private Properties props;
	private String propName;
	private static Configuration cfg;
	
	private Configuration() {
		propName = "jdbc.properties";
		try {
			InputStream is = this.getClass().getClassLoader().getResourceAsStream(propName);
			props = new Properties();
			props.load(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Configuration getInstance(){
		if(cfg == null){
			cfg = new Configuration();
		}
		return cfg;
	}
	public String getVal(String key){
		return props.getProperty(key);
	}
}
