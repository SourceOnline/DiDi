package com.bootdo.system.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 订单管理
 * 
 * @author geyy
 * @email geyueyuan@qq.com
 * @date 2018-06-07 15:58:21
 */
public class OrderDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//订单id
	private Long orderId;
	//科目id
	private String subjectId;
	//学员id
	private Long learnUser;
	//教员id
	private Long teacherUser;
	//年级
	private Integer grade;
	//开始时间
	private Date start;
	//结束时间
	private Date end;
	//地址
	private String address;
	//地址坐标x
	private Float addressX;
	//地址坐标x
	private Float addressY;
	//价格
	private String price;
	//备注
	private String message;
	//评价
	private String evaluate;
	//订单状态
	private Integer status;
	//添加时间
	private Date addtime;
	//是否删除
	private Integer enable;

	/**
	 * 设置：订单id
	 */
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	/**
	 * 获取：订单id
	 */
	public Long getOrderId() {
		return orderId;
	}
	/**
	 * 设置：科目id
	 */
	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}
	/**
	 * 获取：科目id
	 */
	public String getSubjectId() {
		return subjectId;
	}
	/**
	 * 设置：学员id
	 */
	public void setLearnUser(Long learnUser) {
		this.learnUser = learnUser;
	}
	/**
	 * 获取：学员id
	 */
	public Long getLearnUser() {
		return learnUser;
	}
	/**
	 * 设置：教员id
	 */
	public void setTeacherUser(Long teacherUser) {
		this.teacherUser = teacherUser;
	}
	/**
	 * 获取：教员id
	 */
	public Long getTeacherUser() {
		return teacherUser;
	}
	/**
	 * 设置：年级
	 */
	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	/**
	 * 获取：年级
	 */
	public Integer getGrade() {
		return grade;
	}
	/**
	 * 设置：开始时间
	 */
	public void setStart(Date start) {
		this.start = start;
	}
	/**
	 * 获取：开始时间
	 */
	public Date getStart() {
		return start;
	}
	/**
	 * 设置：结束时间
	 */
	public void setEnd(Date end) {
		this.end = end;
	}
	/**
	 * 获取：结束时间
	 */
	public Date getEnd() {
		return end;
	}
	/**
	 * 设置：地址
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取：地址
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 设置：地址坐标x
	 */
	public void setAddressX(Float addressX) {
		this.addressX = addressX;
	}
	/**
	 * 获取：地址坐标x
	 */
	public Float getAddressX() {
		return addressX;
	}
	/**
	 * 设置：地址坐标x
	 */
	public void setAddressY(Float addressY) {
		this.addressY = addressY;
	}
	/**
	 * 获取：地址坐标x
	 */
	public Float getAddressY() {
		return addressY;
	}
	/**
	 * 设置：价格
	 */
	public void setPrice(String price) {
		this.price = price;
	}
	/**
	 * 获取：价格
	 */
	public String getPrice() {
		return price;
	}
	/**
	 * 设置：备注
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * 获取：备注
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * 设置：评价
	 */
	public void setEvaluate(String evaluate) {
		this.evaluate = evaluate;
	}
	/**
	 * 获取：评价
	 */
	public String getEvaluate() {
		return evaluate;
	}
	/**
	 * 设置：订单状态
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：订单状态
	 */
	public Integer getStatus() {
		return status;
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
		return "OrderDO{" +
				"aa=aa"+
				
			", orderId=" + orderId +
			", subjectId=" + subjectId +
			", learnUser=" + learnUser +
			", teacherUser=" + teacherUser +
			", grade=" + grade +
			", start=" + start +
			", end=" + end +
			", address=" + address +
			", addressX=" + addressX +
			", addressY=" + addressY +
			", price=" + price +
			", message=" + message +
			", evaluate=" + evaluate +
			", status=" + status +
			", addtime=" + addtime +
			", enable=" + enable +
					
				'}';
	}
}
