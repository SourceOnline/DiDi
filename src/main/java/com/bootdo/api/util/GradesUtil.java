package com.bootdo.api.util;


public class GradesUtil {

	/**
	 * 年级转换数字
	 * */
	public static int getGradesNum(String grade) {
		int num = 0;//0特殊处理
//		if (grade.equals("小小班")) {
//			return -6;
//		}
//		if (grade.equals("小班")) {
//			return -5;
//		}
//		if (grade.equals("中班")) {
//			return -4;
//		}
//		if (grade.equals("大班")) {
//			return -3;
//		}
//		if (grade.equals("大大班")) {
//			return -2;
//		}
//		if (grade.equals("学前")) {
//			return -1;
//		}
		if (grade.equals("一年级")) {
			return 1;
		}
		if (grade.equals("二年级")) {
			return 2;
		}
		if (grade.equals("三年级")) {
			return 3;
		}
		if (grade.equals("四年级")) {
			return 4;
		}
		if (grade.equals("五年级")) {
			return 5;
		}
		if (grade.equals("六年级")) {
			return 6;
		}
		if (grade.equals("初一")) {
			return 7;
		}
		if (grade.equals("初二")) {
			return 8;
		}
		if (grade.equals("初三")) {
			return 9;
		}
		if (grade.equals("高一")) {
			return 10;
		}
		if (grade.equals("高二")) {
			return 11;
		}
		if (grade.equals("高三")) {
			return 12;
		}
		return num;
	}

	/**
	 * 数字转换年级
	 * */
	public static String getGradeBynum(int num) {
		String grade = "";
		switch (num) {
//		case -6:
//			grade = "小小班";
//			break;
//		case -5:
//			grade = "小班";
//			break;
//		case -4:
//			grade = "中班";
//			break;
//		case -3:
//			grade = "大班";
//			break;
//		case -2:
//			grade = "大大班";
//			break;
//		case -1:
//			grade = "学前";
//			break;
		case 1:
			grade = "一年级";
			break;
		case 2:
			grade = "二年级";
			break;
		case 3:
			grade = "三年级";
			break;
		case 4:
			grade = "四年级";
			break;
		case 5:
			grade = "五年级";
			break;
		case 6:
			grade = "六年级";
			break;
		case 7:
			grade = "初一";
			break;
		case 8:
			grade = "初二";
			break;
		case 9:
			grade = "初三";
			break;
		case 10:
			grade = "高一";
			break;
		case 11:
			grade = "高二";
			break;
		case 12:
			grade = "高三";
			break;
		default:
			break;
		}
		return grade;
	}
}
