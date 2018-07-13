package com.bootdo.common.utils;

import java.util.UUID;

public class IdUtils {

	/**
	 * 获取随机产生的UUID
	 * 
	 * @return
	 */
	public static String getId() {
		return UUID.randomUUID().toString();
	}
	
	public static void main(String[] args){
		String str = getId();
		System.out.println(str);
		System.out.println(str.length());
	}

}
