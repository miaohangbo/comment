package com.example.util.common;


import java.util.ArrayList;
import java.util.List;

/**
 * 《分页帮助》实现类
 * 
 * @author wanlingzhi
 * 
 */
public final class PagerHelper {



	@SuppressWarnings("unchecked")
	public static List getList(Pager pager, List list) {
		if (list == null || list.isEmpty()) {
			return new ArrayList();
		}

		List ret = new ArrayList();
		int totalRows = pager.getTotalRows();

		int from = pager.getStartRow();
		int end = from + pager.getPagesize();
		if (end > totalRows) {
			end = totalRows;
		}
		if (list != null && list.size() > 0 && from < list.size()) {
			if (end > list.size()) {
				end = list.size();
			}
			ret = list.subList(from, end);
		}

		return ret;
	}

}
