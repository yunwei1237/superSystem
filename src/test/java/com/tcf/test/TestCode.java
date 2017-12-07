package com.tcf.test;

import org.apache.commons.codec.digest.DigestUtils;

public class TestCode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String md5 = DigestUtils.md5Hex("wan");
		System.out.println(md5);
	}

}
