package com.bootdo.api.entity;

import com.bootdo.api.util.DateUtils;
import com.bootdo.api.util.GradesUtil;
import com.bootdo.system.domain.OrderDO;

/**
 * @author geyy
 * @date 2018年6月11日 下午3:10:33
 */
public class OrderDetailEntity {
	private Long orderId;// 订单id
	private String subjectName;// 科目名称
	private Long learnUser;// 学员id
	private String learnUserName;// 学员名称
	private String learnUserPhone;// 学员号码
	private Long teacherUser;// 教员id
	private String techerName;// 教员名称
	private String teacherPhone;// 教员电话
	private String gradeName;// 年级名称
	private String datetime;// 时间范围
	private String address;// 地址
	private String addressX;// 地址坐标x
	private String addressY;// 地址坐标x
	private String price;// 价格
	private String message;// 备注
	private String evaluate;// 评价
	private String learnTime;//授课时间
	private Integer status;// 订单状态
	private String addtime;// 添加时间

	/**
	 * @param order
	 */
	public OrderDetailEntity(OrderDO order) {
		this.orderId = order.getOrderId();
		this.learnUser = order.getOrderId();
		this.teacherUser = order.getTeacherUser();
		this.gradeName = order.getGrade();
		if (null != order.getStart() && null != order.getEnd()) {
			this.datetime = DateUtils.toDateTimeString2(order.getStart()) + "-"
					+ DateUtils.toDateTimeString2(order.getEnd());
		} else {
			this.setDatetime("");
		}
		this.address = (null != order.getAddress()) ? order.getAddress() : "";
		this.addressX = order.getAddressX();
		this.addressY = order.getAddressY();
		this.price = order.getPrice();
		this.evaluate = order.getEvaluate();
		this.status = order.getStatus();
		this.learnTime = order.getLearnTime();
		this.addtime = DateUtils.toDateTimeString(order.getAddtime());
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public Long getLearnUser() {
		return learnUser;
	}

	public void setLearnUser(Long learnUser) {
		this.learnUser = learnUser;
	}

	public String getLearnUserName() {
		return learnUserName;
	}

	public void setLearnUserName(String learnUserName) {
		this.learnUserName = learnUserName;
	}

	public Long getTeacherUser() {
		return teacherUser;
	}

	public void setTeacherUser(Long teacherUser) {
		this.teacherUser = teacherUser;
	}

	public String getTecherName() {
		return techerName;
	}

	public void setTecherName(String techerName) {
		this.techerName = techerName;
	}

	public String getGradeName() {
		return gradeName;
	}

	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddressX() {
		return addressX;
	}

	public void setAddressX(String addressX) {
		this.addressX = addressX;
	}

	public String getAddressY() {
		return addressY;
	}

	public void setAddressY(String addressY) {
		this.addressY = addressY;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getEvaluate() {
		return evaluate;
	}

	public void setEvaluate(String evaluate) {
		this.evaluate = evaluate;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getAddtime() {
		return addtime;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}

	public String getLearnUserPhone() {
		return learnUserPhone;
	}

	public void setLearnUserPhone(String learnUserPhone) {
		this.learnUserPhone = learnUserPhone;
	}

	public String getTeacherPhone() {
		return teacherPhone;
	}

	public void setTeacherPhone(String teacherPhone) {
		this.teacherPhone = teacherPhone;
	}

	public String getLearnTime() {
		return learnTime;
	}

	public void setLearnTime(String learnTime) {
		this.learnTime = learnTime;
	}

}
