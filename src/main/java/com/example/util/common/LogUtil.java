package com.example.util.common;


import java.util.logging.Logger;

public class LogUtil {
	protected static final Logger ACCESS_LOG = Logger.getLogger("access");// 客户端请求
	protected static final Logger USER_ERROR_LOG = Logger.getLogger("runerror");// 运行错误

	/**
	 * 用户访问日志
	 */
	protected static final Logger USER_ACCESS_LOG = Logger
			.getLogger("access.user");
	/**
	 * 分享后的访问
	 */
	protected static final Logger SHARE_VISITOR_LOG = Logger
			.getLogger("share.visitor");

	/**
	 * 客户端视频加载日志
	 */
	protected static final Logger SHOW_LOAD_LOG = Logger
			.getLogger("show.load");
	
	/**
	 * 客户端视频推流日志
	 */
	protected static final Logger SHOW_PUSH_LOG = Logger
			.getLogger("show.push");
	
	/**
	 * 用户访问日志
	 * 
	 * @param
	 */
	public static void userAccessLog(String log) {
		USER_ACCESS_LOG.info(log);
	}

	/**
	 * 分享后的访问日志
	 * 
	 * @param
	 */
	public static void shareVisitorLog(String log) {
		SHARE_VISITOR_LOG.info(log);
	}

	/**
	 * 直播加载日志
	 * 
	 * @param
	 */
	public static void showLoadLog(String log) {
		SHOW_LOAD_LOG.info(log);
	}
	
	/**
	 * 直播推流日志
	 * 
	 * @param
	 */
	public static void showPushLog(String log) {
		SHOW_PUSH_LOG.info(log);
	}
	
	/*public static void log(Exception e) {
		USER_ERROR_LOG.error("error", e);
	}*/
}
