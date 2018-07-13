package com.bootdo.common.utils;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class MD5Utils {
//	private static final String SALT = "1qazxsw2";
	private static final String SALT = "hzxckjdd";
	
	private static final String ALGORITH_NAME = "md5";

	private static final int HASH_ITERATIONS = 2;

	public static String encrypt(String pswd) {
		String newPassword = new SimpleHash(ALGORITH_NAME, pswd, ByteSource.Util.bytes(SALT), HASH_ITERATIONS).toHex();
		return newPassword;
	}

	public static String encrypt(String username, String pswd) {
		String newPassword = new SimpleHash(ALGORITH_NAME, pswd, ByteSource.Util.bytes(username + SALT),
				HASH_ITERATIONS).toHex();
		System.out.println("username : "+username+"\n"+"pwd : "+pswd);
		System.out.println("new pwd code : "+newPassword);
		System.out.println(newPassword.length());
		//00006b02-d54d-4080-8006-dfad62109790
		//23a04de50aefb8206e3e4d9068ab11cd
		//o1UjW5Y6GSSmuA50_xdA8XnuqVLI
		return newPassword;
	}
	
	public static void main(String[] args) {
		String pwd = "111111";
		String username = "副本";
		MD5Utils.encrypt(username, pwd);
		
	}

}
