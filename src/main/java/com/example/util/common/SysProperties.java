package com.example.util.common; /**
 * 
 *//*

package com.example.util.common;

*/
/**
 * <desc></desc>
 * @author mupeng
 * @date 2017-5-25 上午10:15:25
 * @version 
 *//*


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Properties;

@Component
public class SysProperties {
	public static String getShareurl() {
		return shareurl;
	}

	private static String user_search;
	private static String shareurl;
	private static String officialAccount;
	private static boolean istest = false;
	private static String testIcon;
	private static String pushURl;//推流地址
	private static String pullURL;//拉流地址
	private static String hdlURL;
	private static String hlsUrl;
	
	private static String qiniuCallBackUrl; 		//七牛回调
	
	private static String ZEGO_APPID;					//
	private static String ZEGO_SECRET;
	private static String ZEGO_LIVE_KEY;				//
	private static String ZEGO_CALLCBACK_SECRECT_KEY;	//回调
	
	private static String showScreencapShareUrl; 		//直播间录屏分享URL（H5的URL）
	private static String showScreencapShowUrl; 		//直播间录屏观看URL（H5的URL）
	
	static {
		Properties proper = new Properties();
		try {
			proper.load(SysProperties.class.getResourceAsStream("/sys.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		user_search = proper.getProperty("search") + "/search.jsp";
		shareurl = proper.getProperty("shareurl");
		officialAccount = proper.getProperty("officialAccount");
		pushURl = proper.getProperty("pushUrl");
		pullURL = proper.getProperty("pullUrl");
		hdlURL = proper.getProperty("hdlUrl");
		hlsUrl = proper.getProperty("hlsUrl");
		if (proper.getProperty("test") != null && "on".equals(proper.getProperty("test"))) {
			istest = true;
		}
		
		*/
/***
		 * ZEGO相关的环境变量
		 * ***//*

		ZEGO_APPID = proper.getProperty("zego.appid");
		ZEGO_SECRET = proper.getProperty("zego.secret");
		ZEGO_LIVE_KEY = proper.getProperty("zego.signkey");
		ZEGO_CALLCBACK_SECRECT_KEY = proper.getProperty("zego.callbackkey");
		showScreencapShareUrl = proper.getProperty("show.screencap.share.url");
		showScreencapShowUrl = proper.getProperty("show.screencap.show.url");
		
	}

	public static boolean isTest() {
		System.out.println(SysProperties.getTestIcon());
		if (SysProperties.getTestIcon()!=null && SysProperties.getTestIcon().equals("on")) {
			istest = true;
		}
		return true;
	}

	@Value("#{cfgProperty.search}")
	public static String getUserSearchUrl() {
		return user_search;
	}

	@Value("#{cfgProperty.officialAccount}")
	public static String getOfficialAccount() {
		return officialAccount;
	}
	
	@Value("#{cfgProperty.pushUrl}")
	public static String getPushURl() {
		return pushURl;
	}
	@Value("#{cfgProperty.pullUrl}")
	public static String getPullURL() {
		return pullURL;
	}

	@Value("#{cfgProperty.hdlUrl}")
	public static String getHdlURL() {
		return hdlURL;
	}

	@Value("#{cfgProperty.hlsUrl}")
	public static String getHlsUrl() {
		return hlsUrl;
	}

	@Value("#{cfgProperty.test}")
	public static String getTestIcon() {
		return testIcon;
	}

	@Value("#{cfgProperty.zego.appid}")
	public static String getZEGO_APPID() {
		return ZEGO_APPID;
	}

	public static void setZEGO_APPID(String zEGO_APPID) {
		ZEGO_APPID = zEGO_APPID;
	}

	@Value("#{cfgProperty.zego.secret}")
	public static String getZEGO_SECRET() {
		return ZEGO_SECRET;
	}

	public static void setZEGO_SECRET(String zEGO_SECRET) {
		ZEGO_SECRET = zEGO_SECRET;
	}

	@Value("#{cfgProperty.zego.signkey}")
	public static String getZEGO_LIVE_KEY() {
		return ZEGO_LIVE_KEY;
	}

	public static void setZEGO_LIVE_KEY(String zEGO_LIVE_KEY) {
		ZEGO_LIVE_KEY = zEGO_LIVE_KEY;
	}
	
	@Value("#{cfgProperty.zego.callbackkey}")
	public static String getZEGO_CALLCBACK_SECRECT_KEY() {
		return ZEGO_CALLCBACK_SECRECT_KEY;
	}

	public static void setZEGO_CALLCBACK_SECRECT_KEY(
			String zEGO_CALLCBACK_SECRECT_KEY) {
		ZEGO_CALLCBACK_SECRECT_KEY = zEGO_CALLCBACK_SECRECT_KEY;
	}

	@Value("#{cfgProperty.qiniucallback}")
	public static String getQiniuCallBackUrl() {
		return qiniuCallBackUrl;
	}
	
	@Value("#{cfgProperty.show.screencap.share.url}")
	public static String getShowScreencapShareUrl() {
	    return showScreencapShareUrl;
	}
	@Value("#{cfgProperty.show.screencap.show.url}")
	public static String getShowScreencapShowUrl() {
	    return showScreencapShowUrl;
	}

}
*/
