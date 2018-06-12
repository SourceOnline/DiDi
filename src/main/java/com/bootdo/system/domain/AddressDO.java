package com.bootdo.system.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author geyy
 * @email geyueyuan@qq.com
 * @date 2018-06-06 15:56:47
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
			", addtime=" + addtime +
			", enable=" + enable +
					
				'}';
	}
}
