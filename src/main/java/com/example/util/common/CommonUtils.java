package com.example.util.common;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommonUtils {

	private static final Logger LOGGER = LoggerFactory.getLogger(CommonUtils.class);

	private static final String ERROR_ID_FORMAT = "%1$tH%1$tM%1$tS%2$s%1$tm%1$td";
	private static String localAddress;
	private static String localhostCode;
	public static final String DATE_PATTERN = "yyyy-MM-dd";

	private CommonUtils() {
	};


	/*public static String getUUID() {
		return StringUtils.remove(UUID.randomUUID().toString(), "-");
	}*/

	public static String filterChinese(String chin) {
		return chin.replaceAll("|官方|毒品|吸毒|黄色|赌博|色情|运营|公众号", "*");
	}

	// 隨機生成8位ID
	@SuppressWarnings("unused")
	private static final int LENGTH = 9;

	public static String generateNumber() {
		String no = "";
		int num[] = new int[9];
		int c = 0;
		for (int i = 1; i < 9; i++) {
			num[i] = new Random().nextInt(10);
			c = num[i];
			for (int j = 1; j < i; j++) {
				if (num[j] == c) {
					i--;
					break;
				}
			}
		}
		if (num.length > 0) {
			for (int i = 1; i < num.length; i++) {
				no += num[i];
			}
		}
		return no;
	}

	public static String isFilter(List<String> list, String inputWords) {
		changePattern(list);
		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
			String patStr = (String) it.next();
			Pattern pattern = Pattern.compile(patStr);
			Matcher matcher = pattern.matcher(inputWords);
			if (matcher.find()) {

				return patStr.replaceAll("\\\\s\\*", "");
			}
		}
		return null;
	}

	public static void changePattern(List<String> list) {
		if (null != list && list.size() > 0) {
			int index = 0;
			Iterator it = list.iterator();
			while (it.hasNext()) {
				String str = (String) it.next();
				int length = str.length();
				String temp = "";
				for (int i = 0; i < length; i++) {
					if (i == 0) {
						temp += str.charAt(i);
						continue;
					}
					temp = temp + "\\s*" + str.charAt(i);
				}
				list.set(index, temp);
				index++;
			}
		}
	}


	public static String getCurrentTimeString() {
		Calendar date = Calendar.getInstance();
		date.setTime(new Date());
		int year = date.get(Calendar.YEAR);
		int month = date.get(Calendar.MONTH);
		int day = date.get(Calendar.DAY_OF_MONTH);
		int hour = date.get(Calendar.HOUR_OF_DAY);
		int minute = date.get(Calendar.MINUTE);
		int second = date.get(Calendar.SECOND);

		String time = year + "-" + (month + 1) + "-" + day + " " + hour + ":"
				+ minute + ":" + second;

		return time;
	}

	public static Date getYesterday() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, -1);
		return calendar.getTime();
	}

	public static long getPages(int requestCount, Integer pageSize) {
		double pages = Double.valueOf(requestCount) / Double.valueOf(pageSize);
		return Math.round(pages + 0.4);
	}

/*	public static Date parseDate(String date) {
		return parseDate(date, Const.DATE_FORMAT);
	}*/

	/*public static Date parseShortDate(String date) {
		return parseDate(date, Const.SHORTDATE_FORMAT);
	}

	public static Date parseShortDateMonth(String date) {
		return parseDate(date, Const.SHORTDATE_MONTH_FORMAT);
	}

	public static Date parseTime(String date) {
		return parseDate(date, Const.TIME_FORMAT);
	}
*/
	public static Date parseDate(String date, String format)
			throws IllegalArgumentException {
		if (date == null)
			return null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		try {
			return simpleDateFormat.parse(date);
		} catch (ParseException e) {
			throw new IllegalArgumentException(e);
		}
	}

	public static String getTenSerialNo() {
		try {
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMddHHmmssSSSS");
			return sdf.format(date);
		} catch (Exception e) {
		}
		return null;
	}

	public static String isFilter2(List<String> list, String inputWords) {
		changePattern(list);
		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
			String patStr = (String) it.next();
			Pattern pattern = Pattern.compile(patStr);
			Matcher matcher = pattern.matcher(inputWords);
			if (matcher.find()) {
				return patStr.replaceAll("\\\\s\\*", "");
			}
		}
		return null;
	}

	public static void changePattern2(List<String> list) {
		if ((list != null) && (list.size() > 0)) {
			int index = 0;
			Iterator it = list.iterator();
			while (it.hasNext()) {
				String str = (String) it.next();
				int length = str.length();

				String temp = "";
				for (int i = 0; i < length; i++) {
					if (i == 0) {
						temp = temp + str.charAt(i);
					} else
						temp = temp + "\\s*" + str.charAt(i);
				}
				list.set(index, temp);
				index++;
			}
		}
	}


	public static boolean IsNumber(String str) {
		String regex = "^[0-9]*$";
		return match(regex, str);
	}

	/***
	 *
	 * <desc>正则验证</desc>
	 * @version
	 * @author mupeng
	 * @date 2017-5-19 上午9:08:05
	 * @param regex
	 * @param str
	 * @return
	 * @throws
	 */
	private static boolean match(String regex, String str) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);
		return matcher.matches();
	}

	public static boolean isMobile(String mobile) {
		if (mobile == null) {
			return false;
		}
		boolean flag = false;
		StringBuffer sb = new StringBuffer();
		sb.append("^(13[0-9]|14[0-9]|15[0-9]|17[0-9]|101|18[0-9]|100)\\d{8}$");
		Pattern pt = Pattern.compile(sb.toString());
		if (pt.matcher(mobile).matches()) {
			flag = true;
		}
		return flag;
	}

	/**
	 * 判断是否是数字
	 *
	 * @param num
	 * @return
	 */
	public static boolean isNumeric(Object num) {
		if (num == null || num.toString().length() <= 0) {
			return false;
		}
		String str = num.toString();
		if (str.length() <= 0) {
			return false;
		}
		if (str.matches("\\d{1,}")) {
			return true;
		}
		if (str.matches("^((-\\d+)|(0+))$")) {
			return true;
		}
		return false;
	}

	public static String getStreamId(final Long userid) {
		if (userid == null) {
			return null;
		}
		return getNewJoinId(userid);
	}

	public static String getNewJoinId(final Long userid) {
		if (userid != null) {
			return String.valueOf(userid) + "_" + System.currentTimeMillis() + "_" + new Random().nextInt(100)
					+ new Random().nextInt(100);
		}
		return null;
	}

	public static Map<String, Object> objectToMap(Object obj) throws Exception {
		if(obj == null){
			return null;
		}

		Map<String, Object> map = new HashMap<String, Object>();

		Field[] declaredFields = obj.getClass().getDeclaredFields();
		for (Field field : declaredFields) {
			field.setAccessible(true);
			map.put(field.getName(), field.get(obj));
		}

		return map;
	}

	/**
	 * 获取间隔的秒数
	 */
	public static int getBetweenSeconds(Date beginDate, Date endDate) {
		if (beginDate == null || endDate == null) {
			return 0;
		}
		return (int) (endDate.getTime() - beginDate.getTime()) / 1000;
	}

}
