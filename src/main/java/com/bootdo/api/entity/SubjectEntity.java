package com.bootdo.api.entity;

import com.bootdo.system.domain.SubjectDO;

/**
 * 科目列表
 * @author geyy
 * @date 2018年6月7日 上午11:27:06
 */
public class SubjectEntity {

	private String subjectId;// 科目id
	private String subName;// 科目名称
	private String code;// 科目代码
	private String icon;// 科目图标
	
	public SubjectEntity(SubjectDO bean){
		this.subjectId = bean.getSubjectId();
		this.subName = bean.getName();
		this.code = bean.getCode();
		this.icon = (null==bean.getIcon())?"":bean.getIcon();
	}

	public String getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubName() {
		return subName;
	}

	public void setSubName(String subName) {
		this.subName = subName;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

}
