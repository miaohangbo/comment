package com.example.util.common;

import java.io.Serializable;

/**
 * @ClassName: ReqHeader
 * @Description: 请求头部信息
 * @author guokp
 * @date 2017年3月20日 上午9:35:03
 */
public class ReqHeader implements Serializable {
    private static final long serialVersionUID = 2392734769195394676L;

    private Long userid; //
    private String token; // token
    private String reqtype; // 请求类型
    private String imei; // 设备IMEI
    private Integer src; // 请求渠道
    private String version; // 请求版本
    private String mac; // mac地址
    private String ip; // 请求IP地址
    private Integer appid; // 应用的id
    private boolean check; //

    public Long getUserid() {
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

    public String getReqtype() {
        return reqtype;
    }

    public void setReqtype(String reqtype) {
        this.reqtype = reqtype;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public Integer getSrc() {
        return src;
    }

    public void setSrc(Integer src) {
        this.src = src;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getAppid() {
        return appid;
    }

    public void setAppid(Integer appid) {
        this.appid = appid;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }
}
