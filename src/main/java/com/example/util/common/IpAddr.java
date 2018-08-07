package com.example.util.common;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 《IP地址》实现类
 * 
 */
public final class IpAddr {

	private static String REG_CONTAINS_1 = "([0-9]+)\\.([0-9]+)\\.([0-9]+)\\.([0-9]+)/([0-9]+)";
	private static String REG_CONTAINS_2 = "([0-9]+)\\.([0-9]+)\\.([0-9]+)\\.([0-9]+)/([0-9]+)\\.([0-9]+)\\.([0-9]+)\\.([0-9]+)";
	private static String REG_CONTAINS_3 = "\\[([0-9]+)\\-([0-9]+)\\]";

	private static String REG_RANGE = "([0-9]+)\\.([0-9]+)\\.([0-9]+)\\.([0-9]+)/([0-9]+)\\.([0-9]+)\\.([0-9]+)\\.([0-9]+)";

	private static String SPLIT_DOT = "\\.";
	private static String SPLIT_RANGE = "~";

	private static String STR_DOT = ".";

	/**
	 * 判断IP地址是否在指定的IP地址段
	 * 
	 * @param range
	 *            IP地址段
	 * @param ip
	 *            IP地址
	 * @return 存在返回true，否则为false
	 */
	public static boolean contains(String range, String ip) {
		if (range.matches(REG_CONTAINS_1)) {
			range = normalizeFromCIDR(range);
			return range(range, ip);
		}

		if (range.matches(REG_CONTAINS_2)) {
			return range(range, ip);
		}

		Pattern p = Pattern.compile(REG_CONTAINS_3);

		String[] ips = ip.split(SPLIT_DOT);
		String[] net = range.split(SPLIT_DOT);

		for (int i = 0; i < ips.length; i++) {
			Matcher m = p.matcher(net[i]);
			if (m.matches()) {
				int k = Integer.parseInt(ips[i]);
				int min = Integer.parseInt(m.group(1));
				int max = Integer.parseInt(m.group(2));
				if (k < min || k > max) {
					return false;
				}
			}
		}

		return true;
	}

	private static String normalizeFromCIDR(final String netspec) {
		int pos = netspec.indexOf('/') + 1;

		final int bits = 32 - Integer.parseInt(netspec.substring(pos));
		final int mask = (bits == 32) ? 0 : 0xFFFFFFFF - ((1 << bits) - 1);

		StringBuilder sb = new StringBuilder();
		sb.append(netspec.substring(0, pos));
		sb.append(Integer.toString(mask >> 24 & 0xFF, 10));
		sb.append(STR_DOT);
		sb.append(Integer.toString(mask >> 16 & 0xFF, 10));
		sb.append(STR_DOT);
		sb.append(Integer.toString(mask >> 8 & 0xFF, 10));
		sb.append(STR_DOT);
		sb.append(Integer.toString(mask >> 0 & 0xFF, 10));

		return sb.toString();
	}

	private static Integer[] range(String r) {
		Pattern p = Pattern.compile(REG_RANGE);
		Matcher m = p.matcher(r);

		if (!m.matches()) {
			return new Integer[] {};
		}

		List<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i <= m.groupCount(); i++) {
			list.add(Integer.parseInt(m.group(i)));
		}

		return (Integer[]) list.toArray(new Integer[] {});
	}

	private static boolean range(String range, String ip) {
		Integer[] net = range(range);
		if (net == null || net.length < 8) {
			return false;
		}

		String[] ips = ip.split(SPLIT_DOT);
		for (int i = 0; i < ips.length; i++) {
			int mask = net[i + 4] & 0xff;
			int ipbyte = Integer.parseInt(ips[i]);
			if ((net[i] & mask) != (ipbyte & mask)) {
				return false;
			}
		}

		return true;
	}

	public static boolean between(String range, String ip) {
		String[] r = range.split(SPLIT_RANGE);
		if (r == null || r.length < 2) {
			return false;
		}

		long from = toLong(r[0]);
		if (from < 0) {
			return false;
		}

		long to = toLong(r[1]);
		if (to < 0) {
			return false;
		}

		long ips = toLong(ip);

		if (from < ips && ips < to) {
			return true;
		}

		return false;
	}

	private static long toLong(String ip) {
		String[] f = ip.split(SPLIT_DOT);
		if (f == null || f.length < 4) {
			return -1;
		}

		long ret = 0l;
		for (int i = 0; i < f.length; i++) {
			long item = Long.parseLong(f[i]);
			for (int j = 0; j < 3 - i; j++) {
				item = item * 256;
			}
			ret += item;
		}

		return ret;
	}
}
