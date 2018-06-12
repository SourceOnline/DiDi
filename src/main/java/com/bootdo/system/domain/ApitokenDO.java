package com.bootdo.system.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author geyy
 * @email geyueyuan@qq.com
 * @date 2018-06-08 09:59:42
 */
public class ApitokenDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String tokenId;
	//
	private Long userId;
	//
	private Date loginTime;
	//
	private Date logoutTime;
	//
	private Integer status;
	//
	private String deviceId;
	//
	private Integer enable;

	/**
	 * 设置：
	 */
	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}
	/**
	 * 获取：
	 */
	public String getTokenId() {
		return tokenId;
	}
	/**
	 * 设置：
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * 设置：
	 */
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}
	/**
	 * 获取：
	 */
	public Date getLoginTime() {
		return loginTime;
	}
	/**
	 * 设置：
	 */
	public void setLogoutTime(Date logoutTime) {
		this.logoutTime = logoutTime;
	}
	/**
	 * 获取：
	 */
	public Date getLogoutTime() {
		return logoutTime;
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
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	/**
	 * 获取：
	 */
	public String getDeviceId() {
		return deviceId;
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

	@Override
	public String toString() {
		return "ApitokenDO{" +
				"aa=aa"+
				
			", tokenId=" + tokenId +
			", userId=" + userId +
			", loginTime=" + loginTime +
			", logoutTime=" + logoutTime +
			", status=" + status +
			", deviceId=" + deviceId +
			", enable=" + enable +
					
				'}';
	}
}
