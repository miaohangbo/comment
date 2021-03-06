package com.example.util.payment;

public class PayParamFactory {
	// ////////支付宝开始
	// 合作商户ID。用签约支付宝账号登录ms.alipay.com后，在账户信息页面获取。
	public static final String ALIPAY_PARTNER = "2088521528758742";//"2088521528758742";//"2088111854386315";
	// 账户ID。用签约支付宝账号登录ms.alipay.com后，在账户信息页面获取。
	public static final String ALIPAY_SELLER = "zb@lanxiong.com";//"guoguangxingkong@163.com";
	// 商户（RSA）私钥
	public static final String ALIPAY_RSA_PRIVATE ="MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAOD5CT/6M1jsGYPF7DacFr0QPRRlSfraLP7kXTt3zS17yKNNnDHnyjR2ETLhgoXsHxMZGvTHqbf4WgQOv/gM5hX0gortILGnwyIWMzTQaafddef4p9Zkvl+tPy3U2XxVueuZGXBW2OmC0WoQg4kXafN2g1V9L7YP3JPFgBmS5UlLAgMBAAECgYAkBt17WFbms5B2cLieGiruBe6yGHJbcJrqCqn/fvTlhsAfnqsXttXDxvCEJGbhiWmEhm2xq1O7eVL4+V+2mmIx7vglDn4Ehq9w6G6RxUAqYMAUheWvGJRP57CNvjPGXq8TV7RbIjSTZea7RLq6jRCPCagOmBI1czPZ6v1NG5/qaQJBAPh9/gZjHI3wjKOzMJ5pY2iDXE3tvDP2MWFGx9RnT+ZqD/fWp29OxCIr/A5ADWsQ0GJvmOj+X06xWM1Qnv34fDUCQQDnxSEL1v/Anqlzx/5xbFwk4T6cgESHlcxii/BDx/8/o1Qic4Zrx2GK15nhPHOBu1CKee91agO2VMrXOctlaF9/AkB6uUbvAp4En+vloUb+xY/Z+x5oQmRzyUBECcABb/CvHGy8e2AAAget1MlMhGfcG9a+9tyvHYoWhFIWPJ35UnKNAkEA0jcYPBbrrZe69krlW5b/FGxAT85/WcLiuFdYuwHBX8USYJULzOHwdPAMoCAmW/q7mH30VTis2UmbGQ9Qjk/WnQJAOQcfVDvHbjJwUw//JgsD4RVofPc6p+XlKExI3jZH0FrU6hEEHejQS84mxMVg87zT3Z3DEtFuDJ9j966q/ZkQwA==";//
	//"MIICXAIBAAKBgQDg+Qk/+jNY7BmDxew2nBa9ED0UZUn62iz+5F07d80te8ijTZwx58o0dhEy4YKF7B8TGRr0x6m3+FoEDr/4DOYV9IKK7SCxp8MiFjM00Gmn3XXn+KfWZL5frT8t1Nl8VbnrmRlwVtjpgtFqEIOJF2nzdoNVfS+2D9yTxYAZkuVJSwIDAQABAoGAJAbde1hW5rOQdnC4nhoq7gXushhyW3Ca6gqp/3705YbAH56rF7bVw8bwhCRm4YlphIZtsatTu3lS+PlftppiMe74JQ5+BIavcOhukcVAKmDAFIXlrxiUT+ewjb4zxl6vE1e0WyI0k2Xmu0S6uo0QjwmoDpgSNXMz2er9TRuf6mkCQQD4ff4GYxyN8IyjszCeaWNog1xN7bwz9jFhRsfUZ0/mag/31qdvTsQiK/wOQA1rENBib5jo/l9OsVjNUJ79+Hw1AkEA58UhC9b/wJ6pc8f+cWxcJOE+nIBEh5XMYovwQ8f/P6NUInOGa8dhiteZ4TxzgbtQinnvdWoDtlTK1znLZWhffwJAerlG7wKeBJ/r5aFG/sWP2fseaEJkc8lARAnAAW/wrxxsvHtgAAIHrdTJTIRn3BvWvvbcrx2KFoRSFjyd+VJyjQJBANI3GDwW662XuvZK5VuW/xRsQE/Of1nC4rhXWLsBwV/FEmCVC8zh8HTwDKAgJlv6u5h99FU4rNlJmxkPUI5P1p0CQDkHH1Q7x24ycFMP/yYLA+EVaHz3Oqfl5ShMSN42R9Ba1OoRBB3o0EvOJsTFYPO8092dwxLRbgyfY/euqv2ZEMA=";
	// 支付宝（RSA）公钥 用签约支付宝账号登录ms.alipay.com后，在密钥管理页面获取。
	public static final String ALIPAY_RSA_ALIPAY_PUBLIC = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCnxj/9qwVfgoUh/y2W89L6BkRAFljhNhgPdyPuBV64bfQNN1PjbCzkIM6qRdKBoLPXmKKMiFYnkd6rAoprih3/PrQEB/VsW8OoM8fxn67UDYuyBTqA23MML9q1+ilIZwBC2AQ2UBVOrFXfFl75p6/B5KsiNG9zpgmLCUYuLkxpLQIDAQAB";
	// 支付宝芝麻认证（RSA）公钥 用签约支付宝账号登录ms.alipay.com后，在密钥管理页面获取。
	public static final String ALIPAY_ZM_REQURL ="https://zmopenapi.zmxy.com.cn/openapi.do";
	public static final String ALIPAY_ZM_APPID ="2018020502147038";
	public static final String ALIPAY_ZM_RSA_PRIVATE ="MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCAUh+BLA1NfONSeO6QqnX7ZlpgczrL1OutajoKGYBsu+Ni3JfL21nTVcPRzoYoisd559I77vwNBXxTyI8VqsX9xrLrSiPqlXieWo7yw9/OP0MTeb56YnHrhDCb158TqNKrXDc7uKOhTVhAFis+OK5PqZKMpFEqJ7nwfHFtMezsiFcXOMADa+V5nNlaBJnM0U5k5CSqIkbSXcYfvuSclSbl2ikJIidd1EUltVGKirIaulqFpoRvVReqNTF6vMylhaZPL60Rt65L5mcrX0M+ZKFKPzyhVLxrRghSbPEd3Si8eTopD5iBX3iiqk9Y89pLXChivySGiplieJ1n3sPD0EJdAgMBAAECggEAY1+12DIGR0j9PoQ6tDveTIeyW9lA4lONBGoscl/Xbd1/tbMBtzSy9pAHqvZWPRVkb4rQ6+sitO7XnobGEFCFLgfvzXlIIUYJ+BBHfcelDbM+PdndYifU80AW6Mlt/yqRo3UxrQVLawJb4p2IdZIto7G9tT8XQB8txwiISrkMMww1d0wh8WXtNkFbwSsrwA0ljt//NVgHzmtg4Y8dANaTL307p6ykKsJzFiOTZeOpG+w4V6E2hK7JIp864DPCkL7AyKxpq2s4Ez4ntOG/OAb/liibZPYGTh8b0AFCC9Kcd/SgenjLzpP8EgYzKY0YphE3tTwN/SpwlN0dlB2uueY9fQKBgQDC4UEG+iVsLbaUJdS0FaipAAcsgilOVLaAys4dZQj9RQU4UUFZdjkZ6MTkj8zRe2GSXj3maumWX8ThTf40pqZM7Mhfjcdt4TsIOrq3Cox3Urp1jJYFYz3+njagos0y87qT+4k4ldCfWpkSA/JDX9mv3YdRN5IZCd0RuHvu0iMMTwKBgQCokOS8X2m37Wgb3DrEg7XKT6pSXz+6R8wbHRAO9/l/PYhkKqnuWI8mVQ+7OF/fKWpiWx9Tn5AZtudin6oleSX8/E5iLoDOYkE6vSAvxEJVMDzluH9dlbDq6iHvq4wfZQTCUWluO7Vz2daxR9RzDlgte6aWF8q1M3hKZ20wIdt/kwKBgCR+rH/S/okYsnVh9EhZOgGUGMPUCEo8AQVzdU/56MoNT+HxDYzkX+MjPSQUbeXY9jfD4FGzOdVIUAVlZrKTdtc3DHsggPVp1XVAElFO72k1G+gBkOKnaCezl0VT15uwGwO1ekgXfj8pZzsBdC/71jdiBAJIptp7h2PXKZZa0edvAoGAb/Rj5vSb22vTNIXNhk1QBQFqRvE5+zfKSMvBqZ9q1uaAWr63RDUPRk9Cdn8XtbjlDlQk9z5Hz7xZ63fN4ruWznKogK8QH4LEfgW0heUchUXXfF9QQFC2Qx+j0HGoTAWk5oZ5tpvzhPFOlUn2wT/qsrKoTpGYsUZxA0G0FD64cP8CgYAI6VvpSMC69dhPgzLqhqFHM/ZnjuJeS1qTXsrVOu7bcTpsWU7fbxGIxdO72saBKXlSd8OONX+Hzgu5KEbT9VIcFgSLdMOhOUg8brdYtEbQ51y6Fy8H1TZ2ancrD+iNqflyK6DjtWEY1SbR6JzV5OCz66PhDQioWGp6YLizCYbf5g==";
	public static final String ALIPAY_ZM_RSA_ALIPAY_PUBLIC = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDDI6d306Q8fIfCOaTXyiUeJHkrIvYISRcc73s3vF1ZT7XN8RNPwJxo8pWaJMmvyTn9N4HQ632qJBVHf8sxHi/fEsraprwCtzvzQETrNRwVxLO5jVmRGi60j8Ue1efIlzPXV9je9mkjzOmdssymZkh2QhUrCmZYI/FCEa3/cNMW0QIDAQAB";
	// ////////支付宝结束
	// appid
	// 微信开始
	// 商户号
	public static final String MCH_ID = "1431179802";//"1396017502";//"1347169201";
	// API密钥，在商户平台设置
	public static final String APP_ID = "wxa579c20ee3426684";//"wxd3cb2c16fa8c3c78";//"wx7fe48ab7290715cb";
	public static final String API_KEY ="beijinglivedevforpay324453214532";//"kandongfangandroiddevforpay88866";// "kandongfangandroiddevforpay32445";
	// 微信
}
