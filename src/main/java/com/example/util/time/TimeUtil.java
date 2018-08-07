/**
 * 
 */
package com.example.util.time;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * <desc></desc>
 * @author mupeng
 */
public class TimeUtil {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TimeUtil.class);

	
	/**
	 * 
	 * <desc>获取当前时间</desc>
	 * @author mupeng
	 * @date 2017-6-26 下午5:02:14
	 * @return
	 * Date
	 */
	public static Date getCurrentTime(){
        Calendar now = Calendar.getInstance();
        Date date = new Date();
        now.setTime(date);  

        return now.getTime();
	}


	public static String getCurrDateStr(String pattern) {
		SimpleDateFormat df = new SimpleDateFormat(pattern); // 设置日期格式
		return df.format(new Date());
	}
	
	/**
	 * 
	 * <desc>获取时间戳格式的Date</desc>
	 * @author mupeng
	 * @date 2017年8月28日 下午4:01:07
	 * @param pattern
	 * @return
	 */
	public static Date getCurrDateFromStr(String pattern) {
		SimpleDateFormat df = new SimpleDateFormat(pattern); // 设置日期格式
		return df.getCalendar().getTime();
	}
	/**
	 * 
	 * <desc>获取5分钟之后的时间</desc>
	 * @author mupeng
	 * @date 2017-6-26 下午5:02:38
	 * @return
	 * Date
	 */
	public static Date getCurrentTimeAfterFiveMin(){
        Calendar now = Calendar.getInstance();
        Date date = new Date();
        now.setTime(date);
        now.set(Calendar.MINUTE, now.get(Calendar.MINUTE) + 5);  
        
        return now.getTime();
	}
	
	/**
	 * 
	 * <desc>获取多少天之后的时间</desc>
	 * @author mupeng
	 * @date 2017-6-7 下午2:11:23
	 * @param d
	 * @param day
	 * @return
	 * Date
	 */
	public static Date getDateAfter(Date d, int day) {  
        Calendar now = Calendar.getInstance();  
        now.setTime(d);  
        now.set(Calendar.DATE, now.get(Calendar.DATE) + day);  
        return now.getTime();  
    }
	
	/**
	 * 
	 * <desc>获取多少天之前的时间</desc>
	 * @author mupeng
	 * @date 2017-6-7 下午2:11:39
	 * @param d
	 * @param day
	 * @return
	 * Date
	 */
    public static Date getDateBefore(Date d, int day) {  
        Calendar now = Calendar.getInstance();  
        now.setTime(d);  
        now.set(Calendar.DATE, now.get(Calendar.DATE) - day);  
        return now.getTime();  
    }
    
	/**
	 * 
	 * <desc> 获取指定格式的日期</desc>
	 * @author mupeng
	 * @date 2017-6-28 下午4:56:43
	 * @param date
	 * @param format
	 * @return
	 * Date
	 */
	public static Date getDateFormat(Date date, String format) {
		if (date == null) {
			return null;
		}
		DateFormat sdf = new SimpleDateFormat(format);
		try {
			return sdf.parse(sdf.format(date));
		} catch (Exception ex) {
			LOGGER.error(ex.toString());
		}
		return null;
	}
	
	/**
	 * 
	 * <desc></desc>
	 * @author mupeng
	 * @date 2017年8月28日 下午4:23:34
	 * @param date
	 * @param format
	 * @return
	 */
	public static Date getDateFormat(String date, String format) {
		if (date == null) {
			return null;
		}
		DateFormat sdf = new SimpleDateFormat(format);
		try {
			return sdf.parse(date);
		} catch (Exception ex) {
			LOGGER.error("【时间格式转换异常,】",ex);
		}
		return null;
	}
	
	/**
	 * 
	 * <desc></desc>
	 * @author mupeng
	 * @date 2017-6-30 上午10:26:32
	 * @return
	 * Date
	 */
	public static Date getCurrentDayStartTime(){
        Calendar now = Calendar.getInstance();
        Date date = new Date();
        now.setTime(date);  
        now.set(Calendar.HOUR_OF_DAY, 0);
        now.set(Calendar.MINUTE, 0);
        now.set(Calendar.SECOND, 0);
        return now.getTime();
	}
	
	/**
	 * 
	 * <desc></desc>
	 * @author mupeng
	 * @date 2017-6-30 上午10:26:38
	 * @return
	 * Date
	 */
	public static Date getCurrentDayEndTime(){
        Calendar now = Calendar.getInstance();
        Date date = new Date();
        now.setTime(date);  
        now.set(Calendar.HOUR_OF_DAY, 23);
        now.set(Calendar.MINUTE, 59);
        now.set(Calendar.SECOND, 59);
        return now.getTime();
	}
	
	/**
	 * 计算两个日期之间相差的天数
	 * 
	 * @param begindate
	 *            较小的时间
	 * @param enddate
	 *            较大的时间
	 * @return 相差天数
	 * @throws ParseException
	 */
	public static int daysBetween(Date begindate, Date enddate) {
		if (begindate != null && enddate != null) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(begindate);
			cal.set(Calendar.HOUR_OF_DAY, 0);
			cal.set(Calendar.MINUTE, 0);
			cal.set(Calendar.SECOND, 0);
			cal.set(Calendar.MILLISECOND, 0);
			long time1 = cal.getTimeInMillis();
			cal.setTime(enddate);
			long time2 = cal.getTimeInMillis();
			long between_days = (time2 - time1) / (1000 * 3600 * 24);

			return Integer.parseInt(String.valueOf(between_days));
		}
		return 0;
	}
	
	/**
	 * 
	 * <desc>年，两个时间戳之间的年</desc>
	 * @author mupeng
	 * @date 2017年9月4日 上午11:29:20
	 * @param begindate
	 * @param enddate
	 * @return
	 */
	public static int yearsBetween(Date begindate, Date enddate) {
		if (begindate != null && enddate != null) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(begindate);
			cal.set(Calendar.HOUR_OF_DAY, 0);
			cal.set(Calendar.MINUTE, 0);
			cal.set(Calendar.SECOND, 0);
			cal.set(Calendar.MILLISECOND, 0);
			long time1 = cal.getTimeInMillis();
			cal.setTime(enddate);
			long time2 = cal.getTimeInMillis();
			long between_years = (time2 - time1) / (1000 * 3600 * 24 * 365);	//365天

			return Integer.parseInt(String.valueOf(between_years));
		}
		return 0;
	}
	
	/**
	 * 
	 * <desc>计算年龄</desc>
	 * @author mupeng
	 * @date 2017-6-30 上午11:06:23
	 * @param date
	 * @return
	 * Integer
	 */
	public static Integer age(Date date) {
		if (date == null) {
			return 18;
		}
		Calendar birthday = Calendar.getInstance();
		birthday.setTime(date);
		Calendar today = Calendar.getInstance();
		int age = today.get(Calendar.YEAR) - birthday.get(Calendar.YEAR);
		birthday.add(Calendar.YEAR, age);
		return age;
	}
	
	public static Integer getDaysBetweenDate(Date lastDay, Date currentDay){
		if(lastDay==null || currentDay==null ){
			return null;
		}
		Calendar lastCalendar = Calendar.getInstance();
		lastCalendar.setTime(lastDay);
		Calendar currentCalendar = Calendar.getInstance();
		currentCalendar.setTime(currentDay);
		
		int day = currentCalendar.get(Calendar.DAY_OF_YEAR) - lastCalendar.get(Calendar.DAY_OF_YEAR);
		
		return day;
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
	/**
	 * 获取明天的开始时间
	 * @author wangpb
	 * @date 2017年11月24日13:39:59
	 * @return
	 */
	public static Date getTomorrowTime(){
		Calendar cal = Calendar.getInstance();
		cal.setTime(getCurrentDayStartTime());
		cal.add(Calendar.DAY_OF_YEAR, 1);
		return cal.getTime();
	}
	public static long getBetweenDateTime(Date beginDate, Date endDate){
		return (endDate.getTime() - beginDate.getTime())/1000;
	}
    
    public static void main(String[] args) {
    	int days = TimeUtil.getDaysBetweenDate(TimeUtil.getDateBefore( TimeUtil.getCurrentTime(), 3), TimeUtil.getCurrentTime());
    	System.out.println(days);
    }
}
