package com.bootdo.api.entity;

/**
 * 年级列表
 * 
 * @author geyy
 * @date 2018年6月7日 上午11:48:49
 */
public class GradeAndNameEntity {

	private String gradeName;//年级名称
	private int gradeNum;//年级序号

	public String getGradeName() {
		return gradeName;
	}

	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}

	public int getGradeNum() {
		return gradeNum;
	}

	public void setGradeNum(int gradeNum) {
		this.gradeNum = gradeNum;
	}

}
