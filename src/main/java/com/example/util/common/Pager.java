package com.example.util.common;

import java.io.Serializable;

public class Pager implements Serializable {
    /** 默认分页的size大小 */
    private static final int PAGE_SIZE = 10;
    /** 最大限制的分页的size大小 */
    private static final int MAX_LIMIT_PAGE_SIZE = 100;
    
	private static final long serialVersionUID = -1947680625885149463L;
	/**
	 * 当前页
	 */
	private Integer currentPage;
	/**
	 * 每页大小
	 */
	private Integer pagesize;
	/**
     * 查询开始的位置
     */
    private Integer startRow;
    /**
     * 总记录
     */
	private Integer totalRows = 0;
	/**
	 * 是否有下一页
	 */
	private int pageNext;
	
	public int getPageNext() {
        return getTotalRows() <= (getStartRow() + getPagesize()) ? 0 : 1;
    }
	
	public void setPageNext(int pageNext) {
        this.pageNext = pageNext;
    }

	public Integer getCurrentPage() {
	    if(null==currentPage || currentPage.intValue()<=1){
            return 1;
        }
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getPagesize() {
	    if (pagesize != null) {
            return pagesize > 0 && pagesize <= MAX_LIMIT_PAGE_SIZE ? pagesize
                    : PAGE_SIZE;
        }
        return PAGE_SIZE;
	}
	public void setPagesize(Integer pagesize) {
		this.pagesize = pagesize;
	}
	public Integer getTotalRows() {
		return totalRows;
	}
	public void setTotalRows(Integer totalRows) {
		this.totalRows = totalRows;
	}
	/**
     * 分页开始位置
     * @return 分页开始的位置
     */
    public Integer getStartRow() {
        startRow = (getCurrentPage() - 1) * getPagesize();
        return startRow;
    }

    public void setStartRow(Integer startRow) {
        this.startRow = startRow;
    }
}
