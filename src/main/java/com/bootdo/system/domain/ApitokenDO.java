package com.bootdo.system.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author geyy
 * @email geyueyuan@qq.com
 * @date 2018-07-09 10:45:54
 */
public class ApitokenDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//token值
	private String tokenId;
	//openid
	private String openId;
	//用户id
	private Long userId;
	//登陆时间
	private Date loginTime;
	//退出时间
	private Date logoutTime;
	//登陆状态
	private Integer status;
	//设备号
	private String deviceId;
	//
	private Integer enable;

	/**
	 * 设置：token值
	 */
	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}
	/**
	 * 获取：token值
	 */
	public String getTokenId() {
		return tokenId;
	}
	/**
	 * 设置：openid
	 */
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	/**
	 * 获取：openid
	 */
	public String getOpenId() {
		return openId;
	}
	/**
	 * 设置：用户id
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：用户id
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * 设置：登陆时间
	 */
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}
	/**
	 * 获取：登陆时间
	 */
	public Date getLoginTime() {
		return loginTime;
	}
	/**
	 * 设置：退出时间
	 */
	public void setLogoutTime(Date logoutTime) {
		this.logoutTime = logoutTime;
	}
	/**
	 * 获取：退出时间
	 */
	public Date getLogoutTime() {
		return logoutTime;
	}
	/**
	 * 设置：登陆状态
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：登陆状态
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置：设备号
	 */
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	/**
	 * 获取：设备号
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
			", openId=" + openId +
			", userId=" + userId +
			", loginTime=" + loginTime +
			", logoutTime=" + logoutTime +
			", status=" + status +
			", deviceId=" + deviceId +
			", enable=" + enable +
					
				'}';
	}
}
