package com.bootdo.api.commen;

/**
 * Framework constants
 * 
 * @author King64
 *
 */
public class Constants {

	public final static String NULL = "null";
	public final static String UNDEFINED = "undefined";

	public final static String ROOT = "ROOT";
	public final static int JSON_STATUS_FAILURE = 0;
	public final static int JSON_STATUS_SUCCESS = 1;
	public final static int JSON_STATUS_REDIRECT = 2;

	// login status
	public final static String LOGIN = "Login";
	public final static String LOGOUT = "Logout";
	public final static String LOG = "Log";

	public final static String YES_TRUE = "Y";
	public final static String NO_FALSE = "N";

	public final static String GENDER_MALE = "M";
	public final static String GENDER_FEMALE = "F";
	
	/**
	 * Cookie中SessionID对应的Cookie项名称，不同的中间件可能有所不同
	 */
	public static final String SESSION_ID_COOKIE_NAME = "JSESSIONID";

}
