package com.example.util.payment;/*
package com.example.util.payment;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipaySystemOauthTokenRequest;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.alipay.api.response.AlipaySystemOauthTokenResponse;
import com.alipay.api.response.AlipayTradePrecreateResponse;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;


public class AlipayUtil {

	*/
/**
	 * y sign 准备待签名的数据
	 * 
	 * @param request
	 * @return
	 *//*

	public static String getSignDate(String orderid, String subject, String body, Integer totalFee,
			String ALIPAY_BACKURL) {
		StringBuilder signData = new StringBuilder();
		signData.append("partner=").append("\"").append(PayParamFactory.ALIPAY_PARTNER).append("\"");
		signData.append("&seller_id=").append("\"").append(PayParamFactory.ALIPAY_SELLER).append("\"");// 卖家帐号
		signData.append("&out_trade_no=").append("\"").append(orderid).append("\"");
		signData.append("&subject=").append("\"").append(subject).append("\"");
		signData.append("&body=").append("\"").append(body).append("\"");
		signData.append("&total_fee=").append("\"").append(totalFee / 100f).append("\"");
		String url = null;
		try {
			url = URLEncoder.encode(ALIPAY_BACKURL, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		signData.append("&notify_url=").append("\"").append(url).append("\"");
		signData.append("&service=\"mobile.securitypay.pay\"");
		signData.append("&payment_type=\"1\"");
		signData.append("&_input_charset=\"utf-8\"");
		signData.append("&it_b_pay=\"60m\"");
		signData.append("&return_url=").append("\"").append(url).append("\"");
		return signData.toString();
	}

	*/
/**
	 * y sign 准备待签名的数据
	 * 
	 * @param request
	 * @return
	 *//*

	public static String getSignWebDate(String orderid, String subject, String body, Integer totalFee,
			String ALIPAY_NOTURL, final String returnUrl) {
		*/
/*
		 * Map<String, String> map = new HashMap<String, String>();
		 * map.put("service", "create_direct_pay_by_user"); map.put("partner",
		 * PayParamFactory.ALIPAY_PARTNER); map.put("_input_charset", "utf-8");
		 * map.put("notify_url", ALIPAY_NOTURL); map.put("return_url",
		 * returnUrl); map.put("out_trade_no", orderid); map.put("subject",
		 * subject); map.put("payment_type", "1"); map.put("total_fee",
		 * String.valueOf(totalFee / 100f)); map.put("seller_id",
		 * PayParamFactory.ALIPAY_PARTNER); map.put("qr_pay_mode", "4");
		 * map.put("body", body); String str = createLinkString(map);
		 * map.put("sign", AlipayUtil.sign(str)); try { map.put("notify_url",
		 * URLEncoder.encode(ALIPAY_NOTURL, "UTF-8")); map.put("return_url",
		 * URLEncoder.encode(returnUrl, "UTF-8")); map.put("sign",
		 * URLEncoder.encode(map.get("sign"), "UTF-8")); } catch
		 * (UnsupportedEncodingException e) { e.printStackTrace(); } return
		 * "https://mapi.alipay.com/gateway.do?" + createLinkString(map);
		 *//*

		AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do",
				PayParamFactory.ALIPAY_ZM_APPID, PayParamFactory.ALIPAY_ZM_RSA_PRIVATE, "JSON", "utf-8",
				PayParamFactory.ALIPAY_ZM_RSA_ALIPAY_PUBLIC, "RSA");
		AlipayTradePrecreateRequest request = new AlipayTradePrecreateRequest();
		request.setNotifyUrl(ALIPAY_NOTURL);
		String str="{\"out_trade_no\":\"" + orderid + "\",\"total_amount\":\"" + String.valueOf(totalFee / 100f)
				+ "\",\"subject\":\"" + subject + "\"}";
		request.setBizContent(str);
		AlipayTradePrecreateResponse response = null;
		try {
			response = alipayClient.execute(request);
			if (response.isSuccess()) {
				return response.getQrCode().replace("https://qr.alipay.com/", "");
			} else {
				System.out.println("调用失败");
			}
		} catch (AlipayApiException e) {
			e.printStackTrace();
		}
		
		return "";
	}

	*/
/**
	 * 对参数进行签名
	 * 
	 * @param signData
	 *            待签名数据，key rsa商户私钥
	 * @return
	 * @throws SmsException
	 *//*

	public static String sign(String signData) {
		String sign = "";
		try {
			sign = RSASignature.sign(signData, PayParamFactory.ALIPAY_RSA_PRIVATE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sign;
	}

	private static Map<String, String> paraFilter(Map<String, String> sArray) {
		Map<String, String> result = new HashMap<String, String>();
		if (sArray == null || sArray.size() <= 0) {
			return result;
		}
		for (String key : sArray.keySet()) {
			String value = sArray.get(key);
			if (value == null || value.equals("") || key.equalsIgnoreCase("sign") || key.equalsIgnoreCase("sign_type")) {
				continue;
			}
			result.put(key, value);
		}
		return result;
	}

	*/
/**
	 * 把数组所有元素排序，并按照“参数=参数值”的模式用“&”字符拼接成字符串
	 * 
	 * @param params
	 *            需要排序并参与字符拼接的参数组
	 * @return 拼接后字符串
	 *//*

	private static String createLinkString(Map<String, String> params) {

		List<String> keys = new ArrayList<String>(params.keySet());
		Collections.sort(keys);
		String prestr = "";
		for (int i = 0; i < keys.size(); i++) {
			String key = keys.get(i);
			String value = params.get(key);
			if (i == keys.size() - 1) {// 拼接时，不包括最后一个&字符
				prestr = prestr + key + "=" + value;
			} else {
				prestr = prestr + key + "=" + value + "&";
			}
		}
		return prestr;
	}

	public static boolean getSignVeryfy(Map<String, String> Params, String sign) {
		// 过滤空值、sign与sign_type参数
		Map<String, String> sParaNew = paraFilter(Params);
		// 获取待签名字符串
		String preSignStr = createLinkString(sParaNew);
		// 获得签名验证结果
		boolean isSign = false;
		isSign = RSASignature.doCheck(preSignStr, sign, PayParamFactory.ALIPAY_RSA_ALIPAY_PUBLIC);
		return isSign;
	}

	public static boolean getPcSignVeryfy(Map<String, String> Params, String sign) {
		// 过滤空值、sign与sign_type参数
		Map<String, String> sParaNew = paraFilter(Params);
		// 获取待签名字符串
		String preSignStr = createLinkString(sParaNew);
		// 获得签名验证结果
		boolean isSign = false;
		isSign = RSASignature.doCheck(preSignStr, sign, PayParamFactory.ALIPAY_ZM_RSA_ALIPAY_PUBLIC);
		return isSign;
	}

	public static String getUserid(String code) {
		AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do",
				PayParamFactory.ALIPAY_ZM_APPID, PayParamFactory.ALIPAY_ZM_RSA_PRIVATE, "json", "UTF-8",
				PayParamFactory.ALIPAY_ZM_RSA_ALIPAY_PUBLIC, "RSA");
		AlipaySystemOauthTokenRequest request = new AlipaySystemOauthTokenRequest();// 创建API对应的request类
		request.setGrantType("authorization_code");
		request.setCode(code);
		try {
			AlipaySystemOauthTokenResponse oauthTokenResponse = alipayClient.execute(request);
			return oauthTokenResponse.getUserId();
		} catch (AlipayApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// 通过alipayClient调用API，获得对应的response类
		return null;
		// 根据response中的结果继续业务逻辑处理
		// ZhimaCustomerCertificationInitializeRequest req = new
		// ZhimaCustomerCertificationInitializeRequest();
		// req.setPlatform("zmop");
		// req.setTransactionId("10018560000000003");// 必要参数
		// req.setProductCode("w1010100000000002978");// 必要参数
		// req.setBizCode("FACE");// 必要参数
		// req.setIdentityParam("{\"identity_type\":\"CERT_INFO\",\"cert_type\":\"IDENTITY_CARD\",\"cert_name\":\"收委\",\"cert_no\":\"260104197909275964\"}");//
		// 必要参数
		// req.setExtBizParam("{}");// 必要参数
		// DefaultZhimaClient client = new
		// DefaultZhimaClient(PayParamFactory.ALIPAY_ZM_REQURL,
		// PayParamFactory.ALIPAY_ZM_APPID,
		// PayParamFactory.ALIPAY_ZM_RSA_PRIVATE,
		// PayParamFactory.ALIPAY_ZM_RSA_ALIPAY_PUBLIC);
		// try {
		// ZhimaCustomerCertificationInitializeResponse response =
		// client.execute(req);
		// if (response.isSuccess()) {
		// ZhimaCustomerCertificationCertifyRequest request = new
		// ZhimaCustomerCertificationCertifyRequest();
		// request.setPlatform("zmop");
		// request.setBizNo(response.getBizNo());// 必要参数
		// request.setReturnUrl("http://openapi.yanjiao.com/pay/zm.jsp");// 必要参数
		// return client.generatePageRedirectInvokeUrl(request);
		// }
		// } catch (ZhimaApiException e) {
		// e.printStackTrace();
		// }
	}

	public static void main(String[] agrs) {
		System.out.println(getUserid("8af2af3b6d624177bc330b71731fZB92"));
//		Map<String, String> params = new HashMap<String, String>();
//		params.put("trade_no","2017033021001004350230191054");
//		params.put("buyer_logon_id","wan***@163.com");
//		params.put("notify_time","2017-03-30 19:11:35");
//		params.put("charset","utf-8");
//		params.put("out_trade_no","013906");
//		params.put("gmt_create","2017-03-30 19:11:23");
//		params.put("notify_id","0886c29b496b96ff2c13dd7bcbc81f4ipa");
//		params.put("gmt_payment","2017-03-30 19:11:35");
//		params.put("version","1.0");
//		params.put("buyer_pay_amount","0.01");
//		params.put("fund_bill_list","[{\"amount\":\"0.01\",\"fundChannel\":\"ALIPAYACCOUNT\"}]");
//		params.put("seller_id","2088521528758742");
//		params.put("seller_email","zb@lanxiong.com");
//		params.put("buyer_id","2088002446433354");
//		params.put("point_amount","0.00");
//		params.put("invoice_amount","0.01");
//		params.put("subject","60钻石");
//		params.put("trade_status","TRADE_SUCCESS");
//		params.put("notify_type","trade_status_sync");
//		params.put("auth_app_id","2017011405079782");
//		params.put("open_id","20880085659103589784430800317435");
//		params.put("total_amount","0.01");
//		params.put("app_id","2017011405079782");
//		params.put("sign_type","RSA");
//		params.put("trade_no","2017033021001004350230191054");
//		params.put("sign","uO7LFEVjidmHOtFflBV16MabFTnrdLIxgLa9/M3YLLfNODcmf+Q2hsbkEmJeVUd47kolxzz6u9NJ8rm5d6QUgI+QsTwS9sK/PyLvDgEit7s8KV6cVbaSCqRp+FSRtJLgedtfySexaRpaadmFzMGBF8VOQze40+eFbsUeCmU95LA=");
//		params.put("receipt_amount","0.01");
//		System.out.println(AlipayUtil.getPcSignVeryfy(params, params.get("sign")));
	}
}
*/
