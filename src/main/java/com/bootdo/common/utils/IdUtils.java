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

}
