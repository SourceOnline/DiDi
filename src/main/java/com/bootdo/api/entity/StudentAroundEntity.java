package com.bootdo.api.entity;

import com.bootdo.system.domain.OrderDO;

/**
 * 附近学生信息（家教资源）
 */
public class StudentAroundEntity {

	private long orderId;// 订单id
	private String subjectName;// 科目
	private String price;// 价格
	private String address;// 地址
	private String grade;// 年级
	private String learnTime;//学习时间
	private String message;// 备注
	private String distance;// 距离，目前没用到
	private String avatar;// 用户头像
	
	public StudentAroundEntity(OrderDO bean){
		this.orderId = bean.getOrderId();
		this.subjectName = bean.getSubject();
		this.address = bean.getAddress();
		this.learnTime = bean.getLearnTime();
		this.message = bean.getMessage();
		this.grade = bean.getGrade();
		this.price = bean.getPrice();
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getLearnTime() {
		return learnTime;
	}

	public void setLearnTime(String learnTime) {
		this.learnTime = learnTime;
	}

}
