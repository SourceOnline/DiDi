package com.bootdo.api.entity;

import java.util.List;

public class FindStuSelectEntity {

	private List<SelectEntity> order_list;
	private List<SelectEntity> grade_list;
	private List<SelectEntity> subject_list;

	public List<SelectEntity> getOrder_list() {
		return order_list;
	}

	public void setOrder_list(List<SelectEntity> order_list) {
		this.order_list = order_list;
	}

	public List<SelectEntity> getGrade_list() {
		return grade_list;
	}

	public void setGrade_list(List<SelectEntity> grade_list) {
		this.grade_list = grade_list;
	}

	public List<SelectEntity> getSubject_list() {
		return subject_list;
	}

	public void setSubject_list(List<SelectEntity> subject_list) {
		this.subject_list = subject_list;
	}

}
