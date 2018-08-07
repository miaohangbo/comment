package com.example.util.payment.weixin;/*
package com.example.util.payment.weixin;

import com.lanxiong.util.payment.PayParamFactory;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.io.UnsupportedEncodingException;
import java.util.*;


public class WeixinPayUtil {

	public static String getWeixinSign(final String orderno, final Integer money, final String body,
			final String notify_url, final String ip, final String type) {
		StringBuffer xml = new StringBuffer();
		String url = String.format("https://api.mch.weixin.qq.com/pay/unifiedorder");
		try {
			xml.append("</xml>");
			String wxappid = PayParamFactory.APP_ID;
			Map<String, String> packageParams = new HashMap<String, String>();

			packageParams.put("appid", wxappid);// 公众账号ID
			packageParams.put("body", body);// 商品描述
			packageParams.put("mch_id", PayParamFactory.MCH_ID);// 商户号
			packageParams.put("nonce_str", genNonceStr());// 随机字符串
			packageParams.put("notify_url", notify_url);// 通知地址
			packageParams.put("out_trade_no", orderno);// 订单号
			packageParams.put("spbill_create_ip", ip);
			packageParams.put("total_fee", money.toString());
			packageParams.put("trade_type", type);
			String sign = genPackageSign(packageParams);
			packageParams.put("sign", sign);
			String entity = toXml(packageParams);
			byte[] buf = Util.httpPost(url, entity);
			String content = new String(buf);
			Document document = DocumentHelper.parseText(content);
			Element root = document.getRootElement();
			String return_code = root.element("return_code").getText();
			if ("SUCCESS".equals(return_code)) {
				if("NATIVE".equals(type)){
					return root.element("code_url").getText();
				}
				String prepayId = root.element("prepay_id").getText();
				String nonceStr = genNonceStr();
				String timestamp = String.valueOf(genTimeStamp());
				List<NameValuePair> signParams = new LinkedList<NameValuePair>();
				signParams.add(new BasicNameValuePair("appid", wxappid));
				signParams.add(new BasicNameValuePair("noncestr", nonceStr));
				signParams.add(new BasicNameValuePair("package", "Sign=WXPay"));
				signParams.add(new BasicNameValuePair("partnerid", PayParamFactory.MCH_ID));
				signParams.add(new BasicNameValuePair("prepayid", prepayId));

				signParams.add(new BasicNameValuePair("timestamp", timestamp));
				StringBuffer sb = new StringBuffer("appid=");
				sb.append(wxappid);
				sb.append("&noncestr=");
				sb.append(nonceStr);
				sb.append("&partnerid=");
				sb.append(PayParamFactory.MCH_ID);
				sb.append("&packagevalue=");
				sb.append("Sign=WXPay");
				sb.append("&prepayid=");
				sb.append(prepayId);
				sb.append("&timestamp=");
				sb.append(timestamp);
				sb.append("&sign=");
				sb.append(genAppSign(signParams));
				return sb.toString();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}

	public static String sendRedPacket(final String orderno, final Integer total_amount, final String re_openid,
			final String ip) {
		StringBuffer xml = new StringBuffer();
		// String url =
		// String.format("https://api.mch.weixin.qq.com/mmpaymkttransfers/sendredpack");
		String url = String.format("https://api.mch.weixin.qq.com/mmpaymkttransfers/promotion/transfers");
		try {
			xml.append("</xml>");
			String wxappid = PayParamFactory.APP_ID;
			Map<String, String> packageParams = new HashMap<String, String>();

			packageParams.put("nonce_str", genNonceStr());// 随机字符串
			// packageParams.put("mch_billno", orderno);// 通知地址
			// packageParams.put("mch_id", PayParamFactory.MCH_ID);// 商户号
			// packageParams.put("wxappid", wxappid);// 公众账号ID
			// packageParams.put("send_name", "单檬");// 商品描述
			// packageParams.put("re_openid", re_openid);// 订单号
			// packageParams.put("total_amount", total_amount.toString());
			// packageParams.put("total_num", "1");
			// packageParams.put("wishing", "恭喜你成功提现" + total_amount/100f +
			// "元");
			// packageParams.put("client_ip", ip);
			// packageParams.put("act_name", "单檬提现");
			// packageParams.put("remark", "单檬提现");
			packageParams.put("mch_appid", wxappid);// 公众账号ID
			packageParams.put("mchid", PayParamFactory.MCH_ID);// 商户号
			packageParams.put("partner_trade_no", orderno);// 订单号
			packageParams.put("openid", re_openid);// 订单号
			packageParams.put("check_name", "NO_CHECK");
			packageParams.put("amount", total_amount.toString());
			packageParams.put("desc", "恭喜你成功提现" + total_amount / 100f + "元");
			packageParams.put("spbill_create_ip", ip);
			String sign = genPackageSign(packageParams);
			packageParams.put("sign", sign);
			String entity = toXml(packageParams);
			byte[] buf = Util.httpPost(url, entity);
			String content = new String(buf);
			Document document = DocumentHelper.parseText(content);
			System.out.println(document.asXML());
			Element root = document.getRootElement();
			String return_code = root.element("return_code").getText();
			if ("SUCCESS".equals(return_code)) {
				return root.element("payment_no").getText();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}

	private static String toXml(Map<String, String> params) {
		StringBuilder sb = new StringBuilder();
		sb.append("<xml>");
		Iterator<String> it = params.keySet().iterator();
		String key;
		while (it.hasNext()) {
			key = it.next();
			sb.append("<" + key + ">");
			sb.append(params.get(key));
			sb.append("</" + key + ">");
		}
		sb.append("</xml>");
		try {
			return new String(sb.toString().getBytes(), "ISO8859-1");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

	private static String genPackageSign(Map<String, String> params) {
		StringBuilder sb = new StringBuilder();
		sb.append(createLinkString(params));
		sb.append("&key=");
		sb.append(PayParamFactory.API_KEY);
		String packageSign = MD5.getMessageDigest(sb.toString().getBytes()).toUpperCase();
		return packageSign;
	}

	private static String genAppSign(List<NameValuePair> params) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < params.size(); i++) {
			sb.append(params.get(i).getName());
			sb.append('=');
			sb.append(params.get(i).getValue());
			sb.append('&');
		}
		sb.append("key=");
		sb.append(PayParamFactory.API_KEY);
		return MD5.getMessageDigest(sb.toString().getBytes()).toUpperCase();
	}

	private static String createLinkString(Map<String, String> params) {
		List<String> keys = new ArrayList<String>(params.keySet());
		Collections.sort(keys);
		String prestr = "";
		for (int i = 0; i < keys.size(); i++) {
			String key = keys.get(i);
			String value = params.get(key);
			if (value != null) {
				if (i == keys.size() - 1) {
					prestr = prestr + key + "=" + value;
				} else {
					prestr = prestr + key + "=" + value + "&";
				}
			}
		}
		return prestr;
	}

	private static String genNonceStr() {
		Random random = new Random();
		return MD5.getMessageDigest(String.valueOf(random.nextInt(10000)).getBytes());
	}

	private static long genTimeStamp() {
		return System.currentTimeMillis() / 1000;
	}

	public static boolean chekcSign(Map<String, String> params, final String sign) {
		String str = genPackageSign(params);
		if (sign == null || str == null || !str.equals(sign)) {
			return false;
		}
		return true;
	}

	public static void main(String[] arg) {
		// System.out.println(content);
		//System.out.println(getWeixinSign("00000001", 1, "测试", "http://localhost/a.jsp", "127.0.0.1"));
	}
}
*/
