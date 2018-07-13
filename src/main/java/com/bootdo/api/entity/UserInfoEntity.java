package com.bootdo.api.entity;

import com.bootdo.system.domain.UserDO;

public class UserInfoEntity {

	private Long userId;// 用户id
	private String name;// 用户真实姓名
	private String phone;// 手机号
	private String sex;//性别，男、女
	private String avatar;// 头像
	private boolean isTeacher;// 是否是教师
	private String token;
	// private Integer status;// 状态 0:禁用，1:正常

	public UserInfoEntity(UserDO bean) {
		this.userId = bean.getUserId();
		this.name = bean.getName();
		this.phone = bean.getMobile();
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public boolean isTeacher() {
		return isTeacher;
	}

	public void setTeacher(boolean isTeacher) {
		this.isTeacher = isTeacher;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
