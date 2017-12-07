package com.tcf.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
	private static ApplicationContext app;
	@BeforeClass
	public static void beforeClass(){
		app = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	@AfterClass
	public static void afterClass(){
		
	}
}
