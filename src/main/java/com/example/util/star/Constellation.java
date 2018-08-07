package com.example.util.star;

import java.util.Calendar;
import java.util.Date;

/**
 * 《星座》实现类
 * 
 */
public class Constellation {

	public static final String[] zodiac = { "猴", "鸡", "狗", "猪", "鼠", "牛", "虎", "兔", "龙", "蛇", "马", "羊" };
	public static final String[] zodiacid = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" };

	public static final String[] constellation = { "水瓶座", "双鱼座", "白羊座", "金牛座", "双子座", "巨蟹座", "狮子座", "处女座", "天秤座", "天蝎座", "射手座", "魔羯座" };
	public static final Integer[] constellationid = { 1, 2, 3,4, 5, 6, 7, 8, 9, 10, 11, 12 };
	public static final int[] constellationEdgeDay = { 20, 19, 21, 21, 21, 22, 23, 23, 23, 23, 22, 22 };

	/**
	 * 根据日期获取生肖
	 * 
	 * @return Calendar
	 */
	public static String zodiacByDate(Calendar time) {
		return zodiac[time.get(Calendar.YEAR) % 12];
	}

	/**
	 * 根据日期获取生肖ID
	 * 
	 * @return Calendar
	 */
	public static String zodiacByDateId(Date time) {
		if (time == null) {
			return null;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(time);
		return zodiacid[calendar.get(Calendar.YEAR) % 12];
	}

	/**
	 * 根据日期获取生肖
	 * 
	 * @param time
	 * @return String
	 */
	public static String zodiacByDate(Date time) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(time);

		return zodiacByDate(calendar);
	}

	/**
	 * 根据日期获取星座ID
	 * 
	 * @param time
	 * @return String
	 */
	public static String constellation(Calendar time) {
		if (time == null) {
			return null;
		}
		int month = time.get(Calendar.MONTH);
		int day = time.get(Calendar.DAY_OF_MONTH);
		if (day < constellationEdgeDay[month]) {
			month = month - 1;
		}

		if (month >= 0) {
			return constellation[month];
		}

		return constellation[11];
	}

	/**
	 * 根据日期获取星座ID
	 * 
	 * @param time
	 * @return String
	 */
	public static Integer constellationid(Date time) {
		if (time == null) {
			return null;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(time);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		if (day < constellationEdgeDay[month]) {
			month = month - 1;
		}

		if (month >= 0) {
			return constellationid[month];
		}

		return constellationid[11];
	}

	/**
	 * 根据日期获取星座
	 * 
	 * @param time
	 * @return String
	 */
	public static String constellation(Date time) {
		if (time == null) {
			return null;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(time);

		return constellation(calendar);
	}
}
