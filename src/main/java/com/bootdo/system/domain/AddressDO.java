package com.bootdo.system.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 地址管理
 * 
 * @author geyy
 * @email geyueyuan@qq.com
 * @date 2018-06-19 10:52:06
 */
public class AddressDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//记录id
	private Long addressId;
	//用户id
	private Long userId;
	//类型
	private String type;
	//经度
	private Float longitude;
	//维度
	private Float latitude;
	//详细地址
	private String message;
	//默认值
	private Integer detault;
	//添加时间
	private Date addtime;
	//是否删除
	private Integer enable;

	/**
	 * 设置：记录id
	 */
	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}
	/**
	 * 获取：记录id
	 */
	public Long getAddressId() {
		return addressId;
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
	 * 设置：类型
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：类型
	 */
	public String getType() {
		return type;
	}
	/**
	 * 设置：经度
	 */
	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}
	/**
	 * 获取：经度
	 */
	public Float getLongitude() {
		return longitude;
	}
	/**
	 * 设置：维度
	 */
	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}
	/**
	 * 获取：维度
	 */
	public Float getLatitude() {
		return latitude;
	}
	/**
	 * 设置：详细地址
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * 获取：详细地址
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * 设置：默认值
	 */
	public void setDetault(Integer detault) {
		this.detault = detault;
	}
	/**
	 * 获取：默认值
	 */
	public Integer getDetault() {
		return detault;
	}
	/**
	 * 设置：添加时间
	 */
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}
	/**
	 * 获取：添加时间
	 */
	public Date getAddtime() {
		return addtime;
	}
	/**
	 * 设置：是否删除
	 */
	public void setEnable(Integer enable) {
		this.enable = enable;
	}
	/**
	 * 获取：是否删除
	 */
	public Integer getEnable() {
		return enable;
	}

	@Override
	public String toString() {
		return "AddressDO{" +
				"aa=aa"+
				
			", addressId=" + addressId +
			", userId=" + userId +
			", type=" + type +
			", longitude=" + longitude +
			", latitude=" + latitude +
			", message=" + message +
			", detault=" + detault +
			", addtime=" + addtime +
			", enable=" + enable +
					
				'}';
	}
}
