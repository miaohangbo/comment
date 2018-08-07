package com.example.util.common;

import java.io.Serializable;


public class BaseReqVo implements Serializable {

    private Pager pager;
    
    /**
     * 0 新建 1修改
     */
    private Integer opType;
    
    /**
     * 是否预览
     */
    private Integer isPreview;
    /**
     * 解析出来的请求头
     */
    protected ReqHeader header;
    
    /**
     * 用户id
     */
    private Long userid;
    /**
     * token
     */
    public String token;
    /**
     * 分页开始位置
     * @return 分页开始的位置
     */

    public Integer getIsPreview() {
        return isPreview;
    }

    public Integer getOpType() {
        return opType;
    }

    public void setIsPreview(Integer isPreview) {
        this.isPreview = isPreview;
    }

    public void setOpType(Integer opType) {
        this.opType = opType;
    }

    public Long getUserid() {
        if (userid == null && header != null) {
            userid = header.getUserid();
        }
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Pager getPager() {
        return pager;
    }

    public void setPager(Pager pager) {
        this.pager = pager;
    }

    public ReqHeader getHeader() {
        return header;
    }

    public void setHeader(ReqHeader header) {
        this.header = header;
    }

}
