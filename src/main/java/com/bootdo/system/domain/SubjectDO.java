package com.bootdo.system.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author geyy
 * @email geyueyuan@qq.com
 * @date 2018-06-06 15:56:54
 */
public class SubjectDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//科目id
	private String subjectId;
	//科目名称
	private String name;
	//科目代码
	private String code;
	//科目图标
	private String icon;
	//类型
	private Integer type;
	//
	private Date addtime;
	//排序
	private Integer sort;
	//
	private Integer enable;

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
	 * 设置：科目名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：科目名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：科目代码
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * 获取：科目代码
	 */
	public String getCode() {
		return code;
	}
	/**
	 * 设置：科目图标
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}
	/**
	 * 获取：科目图标
	 */
	public String getIcon() {
		return icon;
	}
	/**
	 * 设置：类型
	 */
	public void setType(Integer type) {
		this.type = type;
	}
	/**
	 * 获取：类型
	 */
	public Integer getType() {
		return type;
	}
	/**
	 * 设置：
	 */
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}
	/**
	 * 获取：
	 */
	public Date getAddtime() {
		return addtime;
	}
	/**
	 * 设置：排序
	 */
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	/**
	 * 获取：排序
	 */
	public Integer getSort() {
		return sort;
	}
	/**
	 * 设置：
	 */
	public void setEnable(Integer enable) {
		this.enable = enable;
	}
	/**
	 * 获取：
	 */
	public Integer getEnable() {
		return enable;
	}

	@Override
	public String toString() {
		return "SubjectDO{" +
				"aa=aa"+
				
			", subjectId=" + subjectId +
			", name=" + name +
			", code=" + code +
			", icon=" + icon +
			", type=" + type +
			", addtime=" + addtime +
			", sort=" + sort +
			", enable=" + enable +
					
				'}';
	}
}
