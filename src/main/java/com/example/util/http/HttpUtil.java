package com.example.util.http;/*
package com.example.util.http;

import io.netty.util.internal.StringUtil;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class HttpUtil {
	*/
/**
	 * 发送post请求
	 * 
	 * @throws IOException
	 * @throws ClientProtocolException
	 * *//*

	public static String executePost(String url, Map<String, String> param)
			throws ClientProtocolException, IOException {
//		DefaultHttpClient httpclient = new DefaultHttpClient();
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpost = new HttpPost(url.trim());
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		if (param != null) {
			Iterator<String> it = param.keySet().iterator();
			String key;
			while (it.hasNext()) {
				key = it.next();
				if (!StringUtil.isNullOrEmpty(key)) {
					nvps.add(new BasicNameValuePair(key, param.get(key)==null?"":param.get(key)));
				}
			}
		}
		httpost.setEntity(new UrlEncodedFormEntity(nvps, Consts.UTF_8));
		CloseableHttpResponse hresponse = httpclient.execute(httpost);
		HttpEntity entity = hresponse.getEntity();
		String result = EntityUtils.toString(entity);
		EntityUtils.consume(entity);
		httpclient.close();
		nvps = null;
		return result;
	}

	public static boolean checkUrl(String url) {
		boolean flag = false;
		if (url == null || url.length() <= 0 || !url.startsWith("http")) {
			return flag;
		}
		try {
			HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
			connection.setConnectTimeout(1000);
			int state = connection.getResponseCode();
			if (state == 200) {
				flag = true;
			}
		} catch (Exception ex) {
			flag=false;
		}
		return flag;
	}
	
	*/
/**
	 * 
	 * <desc>GET请求</desc>
	 * @author mupeng
	 * @date 2017-6-15 下午2:45:53
	 * @param url
	 * @return
	 * @throws Exception
	 * String
	 *//*

	public static String executeGet(String url){
		BufferedReader in = null;
		String content = null;
		try {
			// 定义HttpClient
//			HttpClient client = new DefaultHttpClient();
			CloseableHttpClient httpclient = HttpClients.createDefault();
			// 实例化HTTP方法
			HttpGet request = new HttpGet();
			request.setURI(new URI(url));
			CloseableHttpResponse response = httpclient.execute(request);
			in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			StringBuffer sb = new StringBuffer("");
			String line = "";
			*/
/*
			 * String NL = System.getProperty("line.separator"); while ((line =
			 * in.readLine()) != null) { sb.append(line + NL); }
			 *//*

			while ((line = in.readLine()) != null) {
				sb.append(line);
			}
			in.close();
			httpclient.close();
			content = sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}// 最后要关闭BufferedReader
		}
		return content;
	}  
	
	public static void main(String[] args) {
		System.out.println(HttpUtil.executeGet("https://imglive.beijing.com/0003022e2375bf53978781707c884395.jpg?image_porn"));
	}
}
*/
