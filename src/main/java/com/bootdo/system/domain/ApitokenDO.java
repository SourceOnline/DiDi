package com.bootdo.system.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-06-04 09:44:59
 */
public class ApitokenDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String tokenid;
	//
	private Long userid;
	//
	private Date logintime;
	//
	private Date logouttime;
	//
	private Integer status;
	//
	private String deviceid;
	//
	private Integer enable;

	/**
	 * 设置：
	 */
	public void setTokenid(String tokenid) {
		this.tokenid = tokenid;
	}
	/**
	 * 获取：
	 */
	public String getTokenid() {
		return tokenid;
	}
	/**
	 * 设置：
	 */
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	/**
	 * 获取：
	 */
	public Long getUserid() {
		return userid;
	}
	/**
	 * 设置：
	 */
	public void setLogintime(Date logintime) {
		this.logintime = logintime;
	}
	/**
	 * 获取：
	 */
	public Date getLogintime() {
		return logintime;
	}
	/**
	 * 设置：
	 */
	public void setLogouttime(Date logouttime) {
		this.logouttime = logouttime;
	}
	/**
	 * 获取：
	 */
	public Date getLogouttime() {
		return logouttime;
	}
	/**
	 * 设置：
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置：
	 */
	public void setDeviceid(String deviceid) {
		this.deviceid = deviceid;
	}
	/**
	 * 获取：
	 */
	public String getDeviceid() {
		return deviceid;
	}
	/**
	 * 设置：
	 */
	public void setEnable(Integer enable) {
		this.enable = enable;
	}
	/**
	 * 获取：
	 */
	public Integer getEnable() {
		return enable;
	}
}
