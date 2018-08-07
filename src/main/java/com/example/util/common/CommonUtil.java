package com.example.util.common;




import com.example.util.encrypt.MD5;
import com.sun.media.jfxmedia.logging.Logger;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class CommonUtil extends FrameUtil {
	private static final List<String> EXCLUDE_METHODS = new ArrayList<String>();
	private static final int MILLIS_PER_DAY = 86400000;
	private static final int MILLIS_PER_HOUR = 3600000;
	private static final int MILLIS_PER_MINUTE = 60000;
	private static final int MILLIS_PER_SECOND = 1000;
	static {
		EXCLUDE_METHODS.add("getHibernateLazyInitializer");
		EXCLUDE_METHODS.add("getCallbacks");
		EXCLUDE_METHODS.add("getClass");
	}
	public static final String[] defaultChars = { "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f",
			"g", "h", "j", "k", "m", "n", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "=", "A", "B", "D",
			"E", "G", "H", "Q" };

	/**
	 * 获取指定格式的日期
	 * 
	 */
	public static String getDateFormatString(Date date, String format) {
		if (date == null) {
			return "";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			return sdf.format(date);
		} catch (Exception ex) {
		//	LogUtil.log(ex);
		}
		return null;
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

	/**
	 * 获取指定格式的日期
	 * 
	 */
	public static Date getDateFormat(Date date, String format) {
		if (date == null) {
			return null;
		}
		DateFormat sdf = new SimpleDateFormat(format);
		try {
			return sdf.parse(sdf.format(date));
		} catch (Exception ex) {
			//LogUtil.log(ex);
		}
		return null;
	}

	/**
	 * 获取指定日期所在星期的周一（返回format格式）
	 * 
	 */
	public static Date getMonday(final Date date, final String format) {
		if (date == null) {
			return null;
		}
		DateFormat sdf = new SimpleDateFormat(format);
		Calendar calendar = Calendar.getInstance();
		try {
			calendar.setTime(sdf.parse(sdf.format(date)));
			if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
				calendar.add(Calendar.DAY_OF_YEAR, -1);
			}
			calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
			return calendar.getTime();
		} catch (Exception ex) {
			//Logger.ERROR(ex.getMessage());
		}
		return null;
	}

	/**
	 * 获取指定格式的日期
	 * 
	 */
	public static Date getDateFormat(String date, String format) {
		if (date == null) {
			return null;
		}
		DateFormat sdf = new SimpleDateFormat(format);
		try {
			return sdf.parse(date);
		} catch (Exception ex) {
			//LogUtil.log(ex);
		}
		return null;
	}

	public static Map<String, Object> modelToMap(final Object modelObj) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		Method[] methods = modelObj.getClass().getMethods();
		Method method;
		for (int i = 0; i < methods.length; i++) {
			method = methods[i];
			fillFieldToMap(method, modelObj, map);
		}
		return map;
	}

	private static void fillFieldToMap(final Method m, final Object obj, Map<String, Object> result) {
		String methodName = m.getName();
		try {
			if (methodName.startsWith("get") && methodName.length() > 3 && m.getParameterTypes().length == 0
					&& !EXCLUDE_METHODS.contains(methodName)) {
				String key = String.valueOf(Character.toLowerCase(methodName.charAt(3)));
				if (methodName.length() > 4) {
					key += methodName.substring(4);
				}
				boolean isset = true;
				if (isset) {
					Object valueObj = m.invoke(obj, new Object[] {});
					if (valueObj != null) {
						String value = null;
						if (valueObj instanceof Date) {
							value = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format((Date) valueObj);
							result.put(key, value);
						} else if (valueObj instanceof List) {
							List<Map<String, Object>> retlist = new ArrayList<Map<String, Object>>();
							List list = (List) valueObj;
							for (int i = 0, size = list.size(); i < size; i++) {
								retlist.add(modelToMap(list.get(i)));
							}
							result.put(key, retlist);
						} else if (valueObj instanceof Boolean) {
							// boolean返回给前台是统一为1 true,0 false
							if ((Boolean) valueObj) {
								value = "1";
							} else {
								value = "0";
							}
							result.put(key, value);
						} else {
							value = valueObj.toString();
							result.put(key, value);
						}
					}
				}
			}
		} catch (Exception e) {
			//LogUtil.log(e);
		}
	}

	/**
	 * 是否是指定类型的日期
	 * 
	 *            date 被验证的字符串
	 *            format 被验证的日期格式
	 * @return boolean true为是
	 */
	public static boolean isDate(String date, String format) {
		if (date == null) {
			return false;
		}
		if (format == null) {
			format = "yyyy-MM-dd HH:mm:ss";
		}
		StringBuffer sb = new StringBuffer(2000);
		if (format.equals("yyyy-MM-dd")) {
			sb.append("\\d{4}-\\d{2}-\\d{2}");
		} else if (format.equals("yyyy-MM-dd HH:mm:ss")) {
			sb.append("\\d{4}-\\d{2}-\\d{2}\\s+\\d{2}:\\d{2}:\\d{2}");
		} else if (format.equals("yyyy-MM-dd HH")) {
			sb.append("\\d{4}-\\d{2}-\\d{2}\\s+\\d{2}");
		} else if (format.equals("yyyyMM")) {
			sb.append("\\d{4}(0[1-9]|1[0-2])$");
		} else if (format.equals("yyyyMMdd")) {
			sb.append("\\d{4}(0[1-9]|1[0-2])(0[1-9]|1[0-9]|2[0-9]|3[0-1])$");
		} else if (format.equals("yyyy.MM.dd")) {
			sb.append("^(2)\\d{3}.(0[1-9]|1[0-2]).(0[1-9]|1[0-9]|2[0-9]|3[0-1])$");
		}
		Pattern p = Pattern.compile(sb.toString());
		if (p.matcher(date).matches()) {
			return true;
		}
		return false;

	}

	/**
	 * 获取手机验证码
	 * 
	 * @param size
	 * @return
	 */
	public static String getNumCode(int size) {
		String[] number = new String[] { "0", "1", "2", "3", "4", "5", "7", "8", "9" };
		Random rnd = new Random();
		int p = number.length - 1;
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < size; i++) {
			int j = rnd.nextInt(p) + 1;
			sb.append(number[j]);
		}
		return sb.toString();
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
	 * 过滤emoji 或者 其他非文字类型的字符
	 * 
	 * @param source
	 * @return
	 */
	public static String filterEmoji(String source) {
		if (source == null) {
			return null;
		}
		Pattern emoji = Pattern.compile("[\ud83c\udc00-\ud83c\udfff]|[\ud83d\udc00-\ud83d\udfff]|[\u2600-\u27ff]",
				Pattern.UNICODE_CASE | Pattern.CASE_INSENSITIVE);
		Matcher emojiMatcher = emoji.matcher(source);
		return emojiMatcher.replaceAll("");
	}

	/**
	 * 获取推送的token
	 */
	public static String getPushToken(final Long userid, final boolean ios) {
		String pushToken = null;
		if (userid != null) {
			pushToken = userid.toString();
		}
		return pushToken;
	}

	public static List getCacheList(Object entity, List list, Pager pager) {
		List retList = null;
		if (entity != null && list != null && list.size() > 0) {
			pager.setTotalRows(list.size());
			int index = list.indexOf(entity);
			if (index != -1) {
				if (index + 1 != list.size()) {
					retList = list.subList(index + 1, list.size());
					if (retList.size() > pager.getPagesize()) {
						retList = retList.subList(0, pager.getPagesize());
					}
				} else {
					retList = null;
				}
			}
		}
		return retList;
	}

	public static long getDateDiff(Date before, Date after, int unit) {
		Calendar nowDate = Calendar.getInstance(), oldDate = Calendar.getInstance();
		oldDate.setTime(before);
		nowDate.setTime(after);
		long l = 1l;
		switch (unit) {
		case Calendar.DAY_OF_YEAR:
			l *= 24 * 60 * 60 * 1000;
			break;
		case Calendar.HOUR:
			l *= 60 * 60 * 1000;
			break;
		case Calendar.MINUTE:
			l *= 60 * 1000;
			break;
		case Calendar.SECOND:
			l *= 1000;
			break;
		case Calendar.MILLISECOND:
			break;
		default:
			break;
		}
		return (nowDate.getTimeInMillis() - oldDate.getTimeInMillis()) / (l);// 化为天
	}

	public static <T> List<T> getRandomList(final List<T> srcList, int size) {
		if (srcList == null || srcList.size() == 0 || size == 0) {
			return null;
		}
		size = Math.min(srcList.size(), size);
		List<T> rlist = new ArrayList<T>(size);
		List<T> destList = new ArrayList(Arrays.asList(srcList.toArray()));
		Collections.copy(destList, srcList);
		Random random = new Random();
		for (int i = 0; i < size; i++) {
			if (destList.size() == 0) {
				break;
			}
			rlist.add(i, destList.remove(random.nextInt(destList.size())));
		}
		destList.clear();
		return rlist;
	}

	public static Object deepClone(Object obj) throws IOException, ClassNotFoundException {
		if (obj == null) {
			return obj;
		}
		// 将对象写入流
		ByteArrayOutputStream bo = new ByteArrayOutputStream();
		ObjectOutputStream oo = new ObjectOutputStream(bo);
		oo.writeObject(obj);

		// 从流里读回来
		ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
		ObjectInputStream oi = new ObjectInputStream(bi);
		return (oi.readObject());
	}

	public static String getCashApplyNo(String id, int nums) {
		if (id == null || id.length() < 1)
			return null;
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < nums - id.length(); i++) {
			sb.append("0");
		}
		sb.append(id);
		return sb.toString();
	}

	/**
	 * 判断是否为小数
	 */
	public static boolean isPrice(Object obj) {
		if (obj == null || obj.toString().length() < 0) {
			return false;
		}
		String str = obj.toString();
		if (str.matches("\\d+\\.\\d+$")) {
			return true;
		} else if (str.matches("\\d{1,}")) {
			return true;
		} else if (str.matches("^((-\\d+)|(0+))$")) {
			return true;
		}
		return false;
	}

	/**
	 * 获取价格
	 */
	public static Long getPrice(String price) {
		if (!isPrice(price)) {
			return null;
		}
		BigDecimal a = new BigDecimal(price);
		BigDecimal b = new BigDecimal(100);
		a = a.multiply(b).setScale(2, BigDecimal.ROUND_HALF_UP);
		return a.longValue();
	}

	/**
	 * 获取展示价格
	 */
	public static String getPriceValue(Long price) {
		if (price == null) {
			return null;
		}
		BigDecimal a = new BigDecimal(price);
		BigDecimal b = new BigDecimal(100);
		a = a.divide(b, 2, BigDecimal.ROUND_HALF_UP);
		if (a.doubleValue() % 1 > 0) {
			return a.toString();
		} else {
			a = a.setScale(0, BigDecimal.ROUND_HALF_UP);
		}
		return a.toString();
	}

	/**
	 * @return true 老版本小于等于新版本   false老版本大于新版本
	 * */
	public static boolean compareVersion(final String oldversion, final String newVersion) {
		if (oldversion.indexOf(".") > 0) {
			String[] oldargs = oldversion.split("\\.");
			String[] newargs = newVersion.split("\\.");
			for (int i = 0; i < oldargs.length; i++) {
				if (Integer.valueOf(oldargs[i]).compareTo(Integer.valueOf(newargs[i])) != 0) {
					return Integer.valueOf(oldargs[i]).compareTo(Integer.valueOf(newargs[i])) < 0;
				}
			}
			return false;
		} else {
			return oldversion.compareTo(newVersion) < 0;
		}
	}
	
	/*public static boolean isGoodJson(String json) {
		try {
			new JsonParser().parse(json);
			return true;
		} catch (JsonParseException e) {
			return false;
		}
	}*/
	
	
/*
	public static String spliteTable(Long id, Long splite) {
		String uid = String.valueOf(id);
		if(uid.length()>String.valueOf(TableConfig.USERSPLITE).length()){
			return "";
		}
		if (id == null || id==-1||splite == null) {
			return "";
		}
		long a = splite;
		while (a <= id) {
			a += splite;
		}
		a -= splite;
		if (a <= id && a > 0l) {
			StringBuffer ret = new StringBuffer();
			ret.append("_");
			ret.append(a);
			return ret.toString();
		}
		return "";
	}*/
	
	public static String spliteTable(Date date) {
		return "_" + CommonUtil.getDateFormatString(date, "yyMM");
	}
	
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
	/**
	 * 
	 * <desc>禁播名单</desc>
	 * @author mupeng
	 * @date 2017年9月7日 下午2:59:08
	 * @param currentDate
	 * @return
	 */
	public static boolean isTimeBetween(Date currentDate){
		Date nightDate = getCurrentDayStartTime();
		Date morningDate = getCurrentDaySevenTime();
		if(currentDate.getTime()>nightDate.getTime() && currentDate.getTime() < morningDate.getTime()){
			return true;
		}
		return false;
	}
	/**
	 * 
	 * <desc>一天的开始</desc>
	 * @author mupeng
	 * @date 2017年9月7日 下午2:56:47
	 * @return
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
	 * <desc>每天的七点</desc>
	 * @author mupeng
	 * @date 2017年9月7日 下午2:57:15
	 * @return
	 */
	public static Date getCurrentDaySevenTime(){
        Calendar now = Calendar.getInstance();
        Date date = new Date();
        now.setTime(date);  
        now.set(Calendar.HOUR_OF_DAY, 7);
        now.set(Calendar.MINUTE, 0);
        now.set(Calendar.SECOND, 0);
        return now.getTime();
	}
	
	/**
	 * 
	 * <desc>若干小时后的时间</desc>
	 * @author mupeng
	 * @date 2017年11月15日 下午6:52:12
	 * @return
	 */
	public static Date getCurrentDayAfterOneHour(Integer min){
        Calendar now = Calendar.getInstance();
        Date date = new Date();
        now.setTime(date);  
        now.set(Calendar.MINUTE, min);
        now.set(Calendar.SECOND, 0);
        return now.getTime();
	}

	public static Integer getDaysBetweenDate(Date lastDay, Date currentDay){
		if(lastDay==null || currentDay==null ){
			return 0;
		}
		Calendar lastCalendar = Calendar.getInstance();
		lastCalendar.setTime(lastDay);
		Calendar currentCalendar = Calendar.getInstance();
		currentCalendar.setTime(currentDay);

		int day = 0;
		if(currentCalendar.get(Calendar.YEAR)==lastCalendar.get(Calendar.DAY_OF_YEAR)){
			day = currentCalendar.get(Calendar.DAY_OF_YEAR) - lastCalendar.get(Calendar.DAY_OF_YEAR);
		}else{
			try {
				day= (int) ((currentCalendar.getTimeInMillis() - lastCalendar.getTimeInMillis())/(1000*3600*24));
			} catch (Exception e) {
				return 0;
			}
		}

		return day;
	}
	
	public static List<String> generateIds() {
		List<String> ids = new ArrayList<String>();
		Properties prop = new Properties();
        try {
			prop.load(CommonUtil.class.getClassLoader().getResourceAsStream("resources/superManager.properties"));
		} catch (IOException e) {
			System.out.println("=========获取superManager.properties异常==============");
			e.printStackTrace();
		}
		
        String userids = prop.getProperty("idList");
        if(userids ==null){
        	return null;
        }
        String[]uids=userids.split(",");
        for(String str:uids){
        	ids.add(str);
        }
		return ids;
	}
	
	public static int getShowControlMaxPeople(){
		Properties prop = new Properties();
        try {
			prop.load(CommonUtil.class.getClassLoader().getResourceAsStream("resources/sys.properties"));
		} catch (IOException e) {
			System.out.println("=========获取sys.properties异常==============");
			e.printStackTrace();
		}
		
        int showControlMaxPerson =Integer.parseInt(prop.getProperty("showControlMaxPerson"));
        return showControlMaxPerson;
	}
	
	public static String encryptByMD5(String str) {
		return new MD5().getMD5ofStr(str);
	}
	public static long getBetweenDateTime(Date beginDate, Date endDate){
		return (endDate.getTime() - beginDate.getTime())/1000;
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
	/**
	 * 处理图片，获取宽和高
	 * @param imgUrl
	 * @return
	 */
	public static Map getImgWH(String imgUrl){
		Map<String,String> map = new HashMap<String,String>();
		map.put("w", "400");
		map.put("h", "400");
        URL url;
		try {
			url = new URL(imgUrl);
	        URLConnection connection = url.openConnection();
	        connection.setDoOutput(true);
	        BufferedImage image = ImageIO.read(connection.getInputStream());  
	        int srcWidth = image .getWidth();      // 源图宽度
	        int srcHeight = image .getHeight();    // 源图高度
	        
	        System.out.println("srcWidth = " + srcWidth);
	        System.out.println("srcHeight = " + srcHeight);
	        map.put("w", srcWidth+"");
	        map.put("h", srcHeight+"");
	        return map;
		} catch (MalformedURLException e) {
			return map;
		} catch (IOException e) {
			return map;
		}
	}
	public static String durationEnd(Date date) {
		if (date == null) {
			return "";
		}

		Calendar before = Calendar.getInstance();
		before.setTime(date);

		Calendar today = Calendar.getInstance();
		long durationMillis = today.getTimeInMillis() - before.getTimeInMillis();

		StringBuffer sb = new StringBuffer();

		int days = 0;
		if (durationMillis > 0) {
			return "已结束";
		} else {
			durationMillis = durationMillis * -1;
			if (durationMillis / MILLIS_PER_DAY > 0) {
				days = (int) (durationMillis / MILLIS_PER_DAY);
				sb.append(days);
				sb.append("天");
				Long h=durationMillis % MILLIS_PER_DAY;
				if(h !=0){
					int ho=(int) (h/MILLIS_PER_HOUR);
					sb.append(ho);
					sb.append("小时");
					return sb.toString();
				}else{
					return sb.toString();
				}
			}
			int hours = 0;
			if (durationMillis / MILLIS_PER_HOUR > 0) {
				hours = (int) (durationMillis / MILLIS_PER_HOUR);
				sb.append(hours);
				sb.append("小时");
				return sb.toString();
			}

			int minutes = 0;
			if (durationMillis / MILLIS_PER_MINUTE > 0) {
				minutes = (int) (durationMillis / MILLIS_PER_MINUTE);
				sb.append(minutes);
				sb.append("分钟");
				return sb.toString();
			}
		}
		return "1分钟";
	}
}