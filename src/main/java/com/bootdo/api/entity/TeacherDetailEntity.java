package com.bootdo.api.entity;

/**
 * 附近教员信息
 * */
public class TeacherDetailEntity {

	private Long userId;// 用户id
	private String avatar;// 头像
	private String userName;//用户姓名
	private String price;//授课价格
	private String msg;//用户简单信息

	public Long getUserId() {
		return userId;
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
