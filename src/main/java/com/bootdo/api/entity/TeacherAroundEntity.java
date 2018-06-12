package com.bootdo.api.entity;

/**
 * 附近教员信息
 * */
public class TeacherAroundEntity {

	private Long userId;// 用户id
	private Float longitude;// 经度
	private Float latitude;// 维度
	private String avatar;// 头像

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Float getLongitude() {
		return longitude;
	}

	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}

	public Float getLatitude() {
		return latitude;
	}

	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

}
