package com.bootdo.api.util;

/**
 * @author geyy
 * @date 2018年6月11日 下午3:37:19
 */
public class ATest {

	public static void main(String[] args){
		String str = "";
		System.out.println(str.length());
		
		String a = "-2876.99812376443";
		float f = Float.valueOf(a);//使用Float.valueOf方法转换
		double b = Double.parseDouble(a);
		System.out.println(f);
		System.out.println(b);
		//-2876.998
	}

}
