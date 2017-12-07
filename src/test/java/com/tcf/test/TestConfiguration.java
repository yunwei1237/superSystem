package com.tcf.test;

import java.io.InputStream;

import org.junit.Assert;
import org.junit.Test;

import com.tcf.util.Configuration;
import com.tcf.util.Configuration2;
import com.tcf.util.Configuration3;

public class TestConfiguration {
	
	@Test
	public void getVal(){
		String prop = Configuration3.getInstance().getVal("username");
		System.out.println(prop);
		Assert.assertEquals(prop.length()>0, true);
	}
}
