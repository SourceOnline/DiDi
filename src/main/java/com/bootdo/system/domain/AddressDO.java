package com.bootdo.system.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 地址管理
 * 
 * @author geyy
 * @email geyueyuan@qq.com
 * @date 2018-06-28 10:46:47
 */
public class AddressDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//记录id
	private Long addressId;
	//用户id
	private Long userId;
	//称呼
	private String userName;
	//联系电话
	private String phone;
	//类型
	private String type;
	//经度
	private String longitude;
	//维度
	private String latitude;
	//省份
	private String province;
	//城市
	private String city;
	//地区
	private String district;
	//街道
	private String street;
	//街道和门号
	private String streetNumber;
	//地址名称
	private String addressName;
	//详细地址
	private String addressDetail;
	//楼栋和门号
	private String door;
	//默认值
	private Integer def;
	//添加时间
	private Date addtime;
	//是否删除
	private Integer enable;
	
	private boolean isDefault;

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
	 * 设置：称呼
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * 获取：称呼
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * 设置：联系电话
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * 获取：联系电话
	 */
	public String getPhone() {
		return phone;
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
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	/**
	 * 获取：经度
	 */
	public String getLongitude() {
		return longitude;
	}
	/**
	 * 设置：维度
	 */
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	/**
	 * 获取：维度
	 */
	public String getLatitude() {
		return latitude;
	}
	/**
	 * 设置：省份
	 */
	public void setProvince(String province) {
		this.province = province;
	}
	/**
	 * 获取：省份
	 */
	public String getProvince() {
		return province;
	}
	/**
	 * 设置：城市
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * 获取：城市
	 */
	public String getCity() {
		return city;
	}
	/**
	 * 设置：地区
	 */
	public void setDistrict(String district) {
		this.district = district;
	}
	/**
	 * 获取：地区
	 */
	public String getDistrict() {
		return district;
	}
	/**
	 * 设置：街道
	 */
	public void setStreet(String street) {
		this.street = street;
	}
	/**
	 * 获取：街道
	 */
	public String getStreet() {
		return street;
	}
	/**
	 * 设置：街道和门号
	 */
	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}
	/**
	 * 获取：街道和门号
	 */
	public String getStreetNumber() {
		return streetNumber;
	}
	/**
	 * 设置：地址名称
	 */
	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}
	/**
	 * 获取：地址名称
	 */
	public String getAddressName() {
		return addressName;
	}
	/**
	 * 设置：详细地址
	 */
	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}
	/**
	 * 获取：详细地址
	 */
	public String getAddressDetail() {
		return addressDetail;
	}
	/**
	 * 设置：楼栋和门号
	 */
	public void setDoor(String door) {
		this.door = door;
	}
	/**
	 * 获取：楼栋和门号
	 */
	public String getDoor() {
		return door;
	}
	/**
	 * 设置：默认值
	 */
	public void setDef(Integer def) {
		this.def = def;
	}
	/**
	 * 获取：默认值
	 */
	public Integer getDef() {
		return def;
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

	public boolean isDefault() {
		return isDefault;
	}
	public void setDefault(boolean isDefault) {
		this.isDefault = isDefault;
	}
	@Override
	public String toString() {
		return "AddressDO{" +
				"aa=aa"+
				
			", addressId=" + addressId +
			", userId=" + userId +
			", userName=" + userName +
			", phone=" + phone +
			", type=" + type +
			", longitude=" + longitude +
			", latitude=" + latitude +
			", province=" + province +
			", city=" + city +
			", district=" + district +
			", street=" + street +
			", streetNumber=" + streetNumber +
			", addressName=" + addressName +
			", addressDetail=" + addressDetail +
			", door=" + door +
			", def=" + def +
			", addtime=" + addtime +
			", enable=" + enable +
					
				'}';
	}
}
