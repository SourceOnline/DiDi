package com.bootdo.api.entity;

import com.bootdo.system.domain.AddressDO;

public class AddressEntity {

	// 记录id
	private Long addressId;
	// 类型
	private String type;
	// 经度
	private String longitude;
	// 维度
	private String latitude;
	// 地点和门号
	private String addressNameAndDoor;
	// 地址信息
	private String message;
	// 称呼和联系号码
	private String nameAndhone;
	// 默认值
	private boolean ifDefault;

	public AddressEntity(AddressDO bean) {
		this.addressId = bean.getAddressId();
		this.latitude = bean.getLatitude();
		this.longitude = bean.getLongitude();
		this.ifDefault = (null != bean.getDef() && bean.getDef() == 1) ? true : false;
	}

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}


	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isIfDefault() {
		return ifDefault;
	}

	public void setIfDefault(boolean ifDefault) {
		this.ifDefault = ifDefault;
	}

	public String getNameAndhone() {
		return nameAndhone;
	}

	public void setNameAndhone(String nameAndhone) {
		this.nameAndhone = nameAndhone;
	}

	public String getAddressNameAndDoor() {
		return addressNameAndDoor;
	}

	public void setAddressNameAndDoor(String addressNameAndDoor) {
		this.addressNameAndDoor = addressNameAndDoor;
	}

}
