package com.bootdo.api.entity;

/**
 * 附近教员信息
 * */
public class TeacherAroundEntity {

	private Long userId;// 用户id
	private String longitude;// 经度
	private String latitude;// 维度
	private String avatar;// 头像
	private String userName;//用户姓名
	private String price;//授课价格
	private String msg;//用户简单信息

	public Long getUserId() {
		return userId;
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

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

}
