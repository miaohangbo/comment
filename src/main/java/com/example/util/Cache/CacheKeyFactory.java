package com.example.util.Cache;

public class CacheKeyFactory {
	/**
	 * 1秒后过期
	 * */
	public static final int ONE_SECOND = 1;
	/**
	 * 1分钟过期
	 * */
	public static final int ONE_MINUTE = 60;
	/**
	 * 1小时过期
	 * */
	public static final int ONE_HOUR = 60 * 60;
	/**
	 * 1天过期
	 * */
	public static final int ONE_DAY = 60 * 60 * 24;
	/**
	 * 1周过期
	 * */
	public static final int ONE_WEEK = 60 * 60 * 24 * 7;
	/**
	 * 1月过期
	 * */
	public static final int ONE_MONTH = 60 * 60 * 24 * 30;// 最大不能超过30天
	/**
	 * 永不过期
	 * */
	public static final int ALWAYS = 0;
}
