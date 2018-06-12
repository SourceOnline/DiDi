package com.bootdo.api.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.alibaba.druid.util.StringUtils;

/**
 * 日期工具类
 */
public class DateUtils {
	/**
	 * 全局默认日期格式
	 */
	public static final String Format_Date = "yyyy-MM-dd";

	/**
	 * 全局默认时间格式
	 */
	public static final String Format_Time = "HH:mm:ss";

	/**
	 * 全局默认日期时间格式
	 */
	public static final String Format_DateTime = "yyyy-MM-dd HH:mm:ss";

	/**
	 * 得到以yyyy-MM-dd格式表示的当前日期字符串
	 */
	public static String getCurrentDate() {
		return new SimpleDateFormat(Format_Date).format(new Date());
	}

	/**
	 * 得到以format格式表示的当前日期字符串
	 */
	public static String getCurrentDate(String format) {
		SimpleDateFormat t = new SimpleDateFormat(format);
		return t.format(new Date());
	}

	/**
	 * 得到以HH:mm:ss表示的当前时间字符串
	 */
	public static String getCurrentTime() {
		return new SimpleDateFormat(Format_Time).format(new Date());
	}

	/**
	 * 获取时间的是属于上午、中午还是下午
	 */
	public static String getTime(Date date) {
		String time = null;
		if(date == null) {
			return time;
		}
		SimpleDateFormat t = new SimpleDateFormat("H");
		String hour =  t.format(date);
		System.out.println(hour);
		if(hour != null && Integer.parseInt(hour) > 12) {
			time="下午";
		}else if(hour != null && Integer.parseInt(hour) ==12){
			time="中午";
		}else if(hour != null && Integer.parseInt(hour) <12){
			time="上午";
		}
		return time;
	}
	
	/**
	 * 获取时间的是属于上午、中午还是下午(-1,0,1,默认为-2)
	 */
	public static int getTimeAMOrPM(Date date) {
		int time = -2;
		if(date == null) {
			return time;
		}
		SimpleDateFormat t = new SimpleDateFormat("H");
		String hour =  t.format(date);
		System.out.println(hour);
		if(hour != null && Integer.parseInt(hour) > 12) {
			time = 1;
		}else if(hour != null && Integer.parseInt(hour) ==12){
			time = 0;
		}else if(hour != null && Integer.parseInt(hour) <12){
			time = -1;
		}
		return time;
	}
	
	/**
	 * 得到以format格式表示的当前时间字符串
	 */
	public static String getCurrentTime(String format) {
		SimpleDateFormat t = new SimpleDateFormat(format);
		return t.format(new Date());
	}

	/**
	 * 得到以yyyy-MM-dd HH:mm:ss表示的当前时间字符串
	 */
	public static String getCurrentDateTime() {
		String format = DateUtils.Format_Date + " " + DateUtils.Format_Time;
		return getCurrentDateTime(format);
	}
	
	/**
	 * 判断日期是否本月
	 * */
	public static boolean isThisMonth(Date date){
		Date today = new Date();
		String todayStr = toString(today, "yyyy-MM");
		String dateStr = toString(date, "yyyy-MM");
		if(todayStr.equals(dateStr)){
			return true;
		}else{
			return false;
		}
	}

	/**
	 * 今天是星期几
	 * 
	 * @return
	 */
	public static int getDayOfWeek() {
		Calendar cal = Calendar.getInstance();
		return cal.get(Calendar.DAY_OF_WEEK);
	}

	/**
	 * 指定日期是星期几
	 * (日一二...六  ==> 1,2,3...7)
	 * @param date
	 * @return
	 */
	public static int getDayOfWeek(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.DAY_OF_WEEK);
	}

	/**
	 * 今天是本月的第几天
	 * 
	 * @return
	 */
	public static int getDayOfMonth() {
		Calendar cal = Calendar.getInstance();
		return cal.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 指定日期是当月的第几天
	 * 
	 * @param date
	 * @return
	 */
	public static int getDayOfMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 获取某一个月的天数
	 * 
	 * @param date
	 * @return
	 */
	public static int getMaxDayOfMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.getActualMaximum(Calendar.DATE);
	}

	/**
	 * 以yyyy-MM-dd格式获取某月的第一天
	 * 
	 * @param date
	 * @return
	 */
	public static String getFirstDayOfMonth(String date) {
		return getFirstDayOfMonth(parse(date));
	}

	public static String getFirstDayOfMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		return new SimpleDateFormat(Format_Date).format(cal.getTime());
	}

	/**
	 * 以yyyy-MM-dd格式获取某月的最后一天
	 * 
	 * @param date
	 * @return
	 */
	public static String getLastDayOfMonth(String date) {
		return getLastDayOfMonth(parse(date));
	}

	public static String getLastDayOfMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DAY_OF_MONTH,
				cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		return new SimpleDateFormat(Format_Date).format(cal.getTime());
	}
	
	/**
	 * 某个月有多少天
	 * */
	public static int getDaysOfMonth(Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DAY_OF_MONTH,
				cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		String dd = new SimpleDateFormat("dd").format(cal.getTime());
		return Integer.parseInt(dd);
	}

	/**
	 * 今天是本年的第几天
	 * 
	 * @return
	 */
	public static int getDayOfYear() {
		Calendar cal = Calendar.getInstance();
		return cal.get(Calendar.DAY_OF_YEAR);
	}

	/**
	 * 指定日期是当年的第几天
	 * 
	 * @param date
	 * @return
	 */
	public static int getDayOfYear(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.DAY_OF_YEAR);
	}

	/**
	 * 以yyyy-MM-dd解析字符串date，并返回其表示的日期是周几
	 * 
	 * @param date
	 * @return
	 */
	public static int getDayOfWeek(String date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(parse(date));
		return cal.get(Calendar.DAY_OF_WEEK);
	}

	/**
	 * 以yyyy-MM-dd解析字符串date，并返回其表示的日期是当月第几天
	 * 
	 * @param date
	 * @return
	 */
	public static int getDayOfMonth(String date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(parse(date));
		return cal.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 以yyyy-MM-dd解析字符串date，并返回其表示的日期是当年第几天
	 * 
	 * @param date
	 * @return
	 */
	public static int getDayOfYear(String date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(parse(date));
		return cal.get(Calendar.DAY_OF_YEAR);
	}

	/**
	 * 以指定的格式返回当前日期时间的字符串
	 * 
	 * @param format
	 * @return
	 */
	public static String getCurrentDateTime(String format) {
		SimpleDateFormat t = new SimpleDateFormat(format);
		return t.format(new Date());
	}

	/**
	 * 以yyyy-MM-dd格式输出只带日期的字符串
	 */
	public static String toString(Date date) {
		if (date == null) {
			return "";
		}
		return new SimpleDateFormat(Format_Date).format(date);
	}
	
	/**
	 * 以MM-dd格式输出只带日期的字符串
	 */
	public static String toMMddString(Date date) {
		if (date == null) {
			return "";
		}
		return new SimpleDateFormat("MM-dd").format(date);
	}
	
	/**
	 * 以yyyyMMdd格式输出只带日期的字符串
	 */
	public static String toyyyyMMddString(Date date) {
		if (date == null) {
			return "";
		}
		return new SimpleDateFormat("yyyyMMdd").format(date);
	}

	/**
	 * 以yyyy-MM-dd HH:mm:ss输出带有日期和时间的字符串
	 */
	public static String toDateTimeString(Date date) {
		if (date == null) {
			return "";
		}
		return new SimpleDateFormat(Format_DateTime).format(date);
	}
	
	/**
	 * 以yyyy-MM-dd HH:mm输出带有日期和时间的字符串
	 */
	public static String toDateTimeString2(Date date) {
		if (date == null) {
			return "";
		}
		return new SimpleDateFormat("yyyy-MM-dd HH:mm").format(date);
	}

	/**
	 * 按指定的format输出日期字符串
	 */
	public static String toString(Date date, String format) {
		return toString(date, format, "");
	}

	/**
	 * 按指定的format输出日期字符串
	 */
	public static String toString(Date date, String format, String defauleValue) {
		String v = defauleValue;
		if (null != date) {
			SimpleDateFormat t = new SimpleDateFormat(format);
			v = t.format(date);
		}
		return v;

	}

	/**
	 * 以HH:mm:ss输出只带时间的字符串
	 */
	public static String toTimeString(Date date) {
		if (date == null) {
			return "";
		}
		return new SimpleDateFormat(Format_Time).format(date);
	}
	
	/**
	 * 以HH:mm输出只带时间的字符串
	 */
	public static String toTimeString2(Date date) {
		if (date == null) {
			return "";
		}
		return new SimpleDateFormat("HH:mm").format(date);
	}

	/**
	 * 以yyyy-MM-dd解析两个字符串，并比较得到的两个日期的大小;
	 * date1 = date2  返回     0 ;
	 * date1 < date2  返回 -1 ;
	 * date1 > date2  返回    1 ;
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int compareDate(Date date1, Date date2) {
		return compare(toString(date1), toString(date2));
	}

	/**
	 * 比较两个dateTime的日期及时间
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int compareDateAndTime(Date date1, Date date2) {
		int result = -1;
		if(compare(toString(date1), toString(date2))>0) {
			result = compare(toString(date1), toString(date2));
		}else if(compare(toString(date1), toString(date2)) == 0){
			result =compareTime(toTimeString(date1),toTimeString(date2));
		}
		return result;
	}
	
	/**
	 * 以yyyy-MM-dd解析两个字符串，并比较得到的两个日期的大小
	 * date1 = date2  返回     0 ;
	 * date1 < date2  返回 -1 ;
	 * date1 > date2  返回    1 ;
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int compare(String date1, String date2) {
		return compare(date1, date2, Format_Date);
	}

	/**
	 * 以HH:mm:ss解析两个字符串，并比较得到的两个时间的大小
	 * 
	 * @param time1
	 * @param time2
	 * @return
	 */
	public static int compareTime(String time1, String time2) {
		return compareTime(time1, time2, Format_Time);
	}

	/**
	 * 以指定格式解析两个字符串，并比较得到的两个日期的大小
	 * 
	 * @param date1
	 * @param date2
	 * @param format
	 * @return
	 */
	public static int compare(String date1, String date2, String format) {
		Date d1 = parse(date1, format);
		Date d2 = parse(date2, format);
		return d1.compareTo(d2);
	}

	/**
	 * 以指定解析两个字符串，并比较得到的两个时间的大小
	 * 
	 * @param time1
	 * @param time2
	 * @param format
	 * @return
	 */
	public static int compareTime(String time1, String time2, String format) {
		String[] arr1 = time1.split(":");
		String[] arr2 = time2.split(":");
		if (arr1.length < 2) {
			throw new RuntimeException("错误的时间值:" + time1);
		}
		if (arr2.length < 2) {
			throw new RuntimeException("错误的时间值:" + time2);
		}
		int h1 = Integer.parseInt(arr1[0]);
		int m1 = Integer.parseInt(arr1[1]);
		int h2 = Integer.parseInt(arr2[0]);
		int m2 = Integer.parseInt(arr2[1]);
		int s1 = 0, s2 = 0;
		if (arr1.length == 3) {
			s1 = Integer.parseInt(arr1[2]);
		}
		if (arr2.length == 3) {
			s2 = Integer.parseInt(arr2[2]);
		}
		if (h1 < 0 || h1 > 23 || m1 < 0 || m1 > 59 || s1 < 0 || s1 > 59) {
			throw new RuntimeException("错误的时间值:" + time1);
		}
		if (h2 < 0 || h2 > 23 || m2 < 0 || m2 > 59 || s2 < 0 || s2 > 59) {
			throw new RuntimeException("错误的时间值:" + time2);
		}
		if (h1 != h2) {
			return h1 > h2 ? 1 : -1;
		} else {
			if (m1 == m2) {
				if (s1 == s2) {
					return 0;
				} else {
					return s1 > s2 ? 1 : -1;
				}
			} else {
				return m1 > m2 ? 1 : -1;
			}
		}
	}

	/**
	 * 判断指定的字符串是否符合HH:mm:ss格式，并判断其数值是否在正常范围
	 * 
	 * @param time
	 * @return
	 */
	public static boolean isTime(String time) {
		String[] arr = time.split(":");
		if (arr.length < 2) {
			return false;
		}
		try {
			int h = Integer.parseInt(arr[0]);
			int m = Integer.parseInt(arr[1]);
			int s = 0;
			if (arr.length == 3) {
				s = Integer.parseInt(arr[2]);
			}
			if (h < 0 || h > 23 || m < 0 || m > 59 || s < 0 || s > 59) {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	/**
	 * 判断指定的字符串是否符合yyyy:MM:ss格式，但判断其数据值范围是否正常
	 * 
	 * @param date
	 * @return
	 */
	public static boolean isDate(String date) {
		String[] arr = date.split("-");
		if (arr.length < 3) {
			return false;
		}
		try {
			int y = Integer.parseInt(arr[0]);
			int m = Integer.parseInt(arr[1]);
			int d = Integer.parseInt(arr[2]);
			if (y < 0 || m > 12 || m < 0 || d < 0 || d > 31) {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	/**
	 * 判断是否是日期或者带时间的日期，日期必须符合格式yy-MM-dd或yy-MM-dd HH:mm:ss
	 */
	public static boolean isDateTime(String str) {
		if (StringUtils.isEmpty(str)) {
			return false;
		}
		if (str.indexOf(" ") > 0) {
			String[] arr = str.split(" ");
			if (arr.length == 2) {
				return isDate(arr[0]) && isTime(arr[1]);
			} else {
				return false;
			}
		} else {
			return isDate(str);
		}
	}

	/**
	 * 判断指定日期是否是周末
	 * 
	 * @param date
	 * @return
	 */
	public static boolean isWeekend(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int t = cal.get(Calendar.DAY_OF_WEEK);
		if (t == Calendar.SATURDAY || t == Calendar.SUNDAY) {
			return true;
		}
		return false;
	}

	/**
	 * 以yyyy-MM-dd解析指定字符串，并判断相应的日期是否是周末
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isWeekend(String str) {
		return isWeekend(parse(str));
	}

	/**
	 * 以yyyy-MM-dd解析指定字符串，返回相应java.util.Date对象
	 * 
	 * @param str
	 * @return
	 */
	public static Date parse(String str) {
		if (StringUtils.isEmpty(str)) {
			return null;
		}
		try {
			return new SimpleDateFormat(Format_Date).parse(str);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * 按指定格式解析字符串，并返回相应的java.util.Date对象
	 * 
	 * @param str
	 * @param format
	 * @return
	 */
	public static Date parse(String str, String format) {
		if (StringUtils.isEmpty(str)) {
			return null;
		}
		try {
			SimpleDateFormat t = new SimpleDateFormat(format);
			return t.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 以yyyy-MM-dd HH:mm:ss格式解析字符串，并返回相应的java.util.Date对象
	 * 
	 * @param str
	 * @return
	 */
	public static Date parseDateTime(String str) {
		if (StringUtils.isEmpty(str)) {
			return null;
		}
		if (str.length() <= 10) {
			return parse(str);
		}
		try {
			return new SimpleDateFormat(Format_DateTime).parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 以指定格式解析字符串，并返回相应的java.util.Date对象
	 * 
	 * @param str
	 * @param format
	 * @return
	 */
	public static Date parseDateTime(String str, String format) {
		if (StringUtils.isEmpty(str)) {
			return null;
		}
		try {
			SimpleDateFormat t = new SimpleDateFormat(format);
			return t.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 日期date上加count秒，count为负表示减
	 */
	public static Date addSeconds(Date date, int count) {
		return new Date(date.getTime() + 1000L * count);
	}

	/**
	 * 日期date上加count分钟，count为负表示减
	 */
	public static Date addMinute(Date date, int count) {
		return new Date(date.getTime() + 60000L * count);
	}

	/**
	 * 日期date上加count小时，count为负表示减
	 */
	public static Date addHour(Date date, int count) {
		return new Date(date.getTime() + 3600000L * count);
	}

	/**
	 * 日期date上加count天，count为负表示减
	 */
	public static Date addDay(Date date, int count) {
		return new Date(date.getTime() + 86400000L * count);
	}

	/**
	 * 日期date上加count星期，count为负表示减
	 */
	public static Date addWeek(Date date, int count) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.WEEK_OF_YEAR, count);
		return c.getTime();
	}

	/**
	 * 日期date上加count月，count为负表示减
	 */
	public static Date addMonth(Date date, int count) {
		/* ${_ISYSTEM_LICENSE_CODE_} */

		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MONTH, count);
		return c.getTime();
	}

	/**
	 * 日期date上加count年，count为负表示减
	 */
	public static Date addYear(Date date, int count) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.YEAR, count);
		return c.getTime();
	}

	/**
	 * 人性化显示时间日期,date格式为：yyyy-MM-dd HH:mm:ss
	 * 
	 * @param date
	 * @return
	 */
	public static String toDisplayDateTime(String date) {
		if (StringUtils.isEmpty(date)) {
			return null;
		}
		try {
			if (isDate(date)) {
				return toDisplayDateTime(parse(date));
			} else {
				SimpleDateFormat t = new SimpleDateFormat(Format_DateTime);
				Date d = t.parse(date);
				return toDisplayDateTime(d);
			}

		} catch (ParseException e) {
			e.printStackTrace();
			return "不是标准格式时间!";
		}
	}

	/**
	 * 人性化显示时间日期
	 * 
	 * @param date
	 * @return
	 */
	public static String toDisplayDateTime(Date date) {
		long minite = (System.currentTimeMillis() - date.getTime()) / 60000L;
		if (minite < 60) {
			return toString(date, "MM-dd") + " " + minite + "分钟前";
		}
		if (minite < 60 * 24) {
			return toString(date, "MM-dd") + " " + minite / 60L + "小时前";
		} else {
			return toString(date, "MM-dd") + " " + minite / 1440L + "天前";
		}
	}

	/**
	 * 获取当前年份
	 * 
	 * @return
	 */
	public static int getCurrentYear() {
		return getYearOfDate(new Date());
	}

	/**
	 * 获取指定日期所在的年份
	 * 
	 * @param date
	 * @return
	 */
	public static int getYearOfDate(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.YEAR);
	}
	
	/**
	 * 获取当前月份
	 * 
	 * @return
	 */
	public static int getCurrentMonth() {
		return getMonthOfDate(new Date());
	}

	/**
	 * 获取指定日期所在的月份
	 * 
	 * @param date
	 * @return
	 */
	public static int getMonthOfDate(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.MONTH)+1;
	}

	/**
	 * 比较date1是否大于date2
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static boolean afterDate(Date date1, Date date2) {
		return (compareDate(date1, date2) > 0);
	}

	/**
	 * 比较date1是否小于date2
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static boolean beforeDate(Date date1, Date date2) {
		return (compareDate(date1, date2) < 0);
	}

	/**
	 * 比较date1是否等于date2
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static boolean equalDate(Date date1, Date date2) {
		return (compareDate(date1, date2) == 0);
	}
	
	/**
	 * 获取本周周一
	 * */
	public static Date getThisWeekMonday(Date date){
		Calendar cal = Calendar.getInstance();  
        cal.setTime(date);  
        // 获得当前日期是一个星期的第几天  
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);  
        if (1 == dayWeek) {  
            cal.add(Calendar.DAY_OF_MONTH, -1);  
        }  
        // 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一  
        cal.setFirstDayOfWeek(Calendar.MONDAY);  
        // 获得当前日期是一个星期的第几天  
        int day = cal.get(Calendar.DAY_OF_WEEK);  
        // 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值  
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);  
        return cal.getTime();  
	}
	
	/**
	 * 获取上个月第一天
	 * */
	public static Date getFirstDayOfLastMonth(Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		
		cal.add(Calendar.MONTH, -1);
		//第一天
		Date d = cal.getTime();
		return d;
	}
	
	/**
	 * 获取本月第一天
	 * */
	public static Date getFirstDay(Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		//第一天
		Date d = cal.getTime();
		return d;
	}
	
	/**
	 * 获取本月最后一天
	 * */
	public static Date getLastDay(Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DAY_OF_MONTH,
				cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		//最后一天
		Date d = cal.getTime();
		return d;
	}
	
	/**
	 * 获取当前月份的第一个星期一（星期三以前为当前周）
	 * */
	public static Date getFirstMondayOfMouth(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		//第一天
		Date d = cal.getTime();

		int n = d.getDay(); // 得到当天星期
		long t = d.getTime() / 1000;
		//星期三以前为当前周
		if(n<=3){
			n = n - 1; // 这个星期一
			t -= 3600 * 24 * n;
			d.setTime(t * 1000); // 对应日期
		}else{
			n = (8 - n) % 7; // 下一个星期一
			t += 3600 * 24 * n;
			d.setTime(t * 1000); // 对应日期
		}
		
		//转换时间为 00:00
		String dstr = toString(d);
		d = parse(dstr);
		return d;
	}
	
	/**
	 * 获取当前月份的最后一个星期五（星期三以前为当前周）
	 * */
	public static Date getLastFridayOfMouth(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DAY_OF_MONTH,
				cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		//最后一天
		Date d = cal.getTime();

		int n = d.getDay(); // 得到当天星期
		long t = d.getTime() / 1000;
		if(n==0){
			n = 7;
		}
		//星期三以前为当前周
		if(n<=3){
			n = 3 - n + 3; 		// 上个星期五
			t -= 3600 * 24 * n;
			d.setTime(t * 1000); // 对应日期
		}else{
			n = (- n + 5)%7; 	 // 这个星期五
			t += 3600 * 24 * n;
			d.setTime(t * 1000); // 对应日期
		}
		
		//转换时间为 00:00
		String dstr = toString(d);
		d = parse(dstr);
		return d;
	}
	
	/**
	 * 数字转换字符串，如：4 ==> "04"
	 * */
	public static String NumToString(int num){
		String day = null;
		if(num<10){
			day = "0"+num;
		}else{
			day = num+"";
		}
		if(num<0){
			day = "00";
		}
		return day;
	}

}
