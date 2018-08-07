package com.example.util.common;/*
package com.example.util.common;

import com.alibaba.fastjson.JSONObject;
import com.lanxiong.framework.common.SysConst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class LBSUtil {

	*/
/**
	 * lng 经度坐标 lat 纬度坐标
	 * *//*

	public static LBS getLBS(String lng, String lat, String ip) {
		LBS lbs = new LBS();
		if (lng != null && lng.trim().indexOf(".") > 0 && lng != null
				&& lat != null && lat.trim().indexOf(".") > 0) {
			String url = "http://api.map.baidu.com/geocoder/v2/?coordtype=wgs84ll&ak="
					+ SysConst.LBS_KEY
					+ "&callback=&location="
					+ lat
					+ ","
					+ lng + "&output=json&pois=0";
			URL dataUrl;
			try {
				dataUrl = new URL(url);
				HttpURLConnection con = (HttpURLConnection) dataUrl
						.openConnection();
				con.setRequestMethod("GET");
				con.setDoOutput(true);
				con.setDoInput(true);
				InputStream is = con.getInputStream();
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(is, "utf-8"));
				StringBuffer sb = new StringBuffer();
				String line = null;
				while ((line = reader.readLine()) != null) {
					sb.append(line);
				}
				JSONObject json = (JSONObject) JSONObject.parse(sb.toString());
				if (json != null) {
					JSONObject result = json.getJSONObject("result");
					if (result != null) {
						JSONObject add = result
								.getJSONObject("addressComponent");
						if (add != null) {
							lbs.setCity(add.getString("city"));
							lbs.setProvince(add.getString("province"));
							lbs.setDistrict(add.getString("district"));
						}
					}
				}
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			String url = "http://api.map.baidu.com/location/ip?ak="
					+ SysConst.LBS_KEY + "&ip=" + ip + "&coor=bd09ll";
			URL dataUrl;
			try {
				dataUrl = new URL(url);
				HttpURLConnection con = (HttpURLConnection) dataUrl
						.openConnection();
				con.setRequestMethod("GET");
				con.setDoOutput(true);
				con.setDoInput(true);
				InputStream is = con.getInputStream();
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(is));
				StringBuffer sb = new StringBuffer();
				String line = null;
				while ((line = reader.readLine()) != null) {
					sb.append(line);
				}
				JSONObject json = (JSONObject) JSONObject.parse(sb.toString());
				if (json != null) {
					JSONObject result = json.getJSONObject("content");
					if (result != null) {
						JSONObject add = result.getJSONObject("address_detail");
						if (add != null) {
							lbs.setCity(add.getString("city"));
							lbs.setProvince(add.getString("province"));
							lbs.setDistrict(add.getString("district"));
						}
					}
				}
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (lbs.getProvince() != null && lbs.getProvince().length() > 0) {
			lbs.setProvince(lbs.getProvince().substring(0,
					lbs.getProvince().length() - 1));
		}
		return lbs;

	}

	public static void main(String[] args) {
		String lbs = "40.033005,116.417704";
		LBS l=getLBS(lbs.split(",")[1], lbs.split(",")[0], "125.33.115.89");
		System.out.println(l.getCity());
	}
}
*/
