package com.tcf.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration3 {
	private Properties props;
	private String propName;
	
	private Configuration3() {
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
	public static class Singleton{
		private static final Configuration3 cfg = new Configuration3();
	}
	public static Configuration3 getInstance(){
		return Singleton.cfg;
	}
	public String getVal(String key){
		return props.getProperty(key);
	}
}
