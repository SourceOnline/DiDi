package com.bootdo.api.util;

public class PhoneUtil {

	/*
	 * 手机号隐藏中间4位
	 * **/
	public static String middleHide(String phone){
		String back = "";
		if(null!=phone&&phone.length()>7){
			back = phone.replace(phone.substring(3,7),"****");
		}
		return back;
	}
}
