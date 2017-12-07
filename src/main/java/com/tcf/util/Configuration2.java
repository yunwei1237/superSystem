package com.tcf.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration2 {
	private Properties props;
	private String propName;
	private static Configuration2 cfg = new Configuration2();
	
	private Configuration2() {
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
	public static Configuration2 getInstance(){
		return cfg;
	}
	public String getVal(String key){
		return props.getProperty(key);
	}
}
