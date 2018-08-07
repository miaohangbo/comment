package com.example.util.common;

public final class QiniuConfig {/*
	
//	private static String ACCESSKEY = "bsThzvg_JHNquYFaBT_Bb2ulbUOPrAB60lR0mWpw";
//	private static String SECRETKEY = "BWffDirXa98ed3drp7Chm9Z7PqnuCx4C-H_UJrB9";
	
	private static String ACCESSKEY = "N5JlC7j47V83d0uuJCEeWOMyjvMuZGvxwmONtPjt";
	private static String SECRETKEY = "79bOMGWIy_xm9lk6dPIwxySbH1r9mk3GnSpgRGdb";
	private static final Auth auth = Auth.create(ACCESSKEY, SECRETKEY);
//	private static final String bucket = "beijing";
	private static final String bucket = "beijinglive";
	
	private static final String bucket_huabei = "beijing";

	private QiniuConfig() {
	}

	public static Auth getAuth() {
		return auth;
	}

	public static String getBucket() {
		return bucket;
	}

	public static boolean isTravis() {
		return "travis".equals(System.getenv("QINIU_TEST_ENV"));
	}

	*//**
	 * 鉴黄
	 * *//*
	public static boolean nrop(final String url) {
		// 新建一个OperationManager对象
		OperationManager operater = new OperationManager(auth);
		try {
			return operater.nrop(url + "?nrop");
		} catch (QiniuException e) {
			return true;
		}
	}

	*//**
	 * 剪切人脸
	 * *//*
	public static boolean head(final String url) {
		// 新建一个OperationManager对象
		OperationManager operater = new OperationManager(auth);
		try {
			return operater.head(url + "?facecrop2/300x300");
		} catch (QiniuException e) {
			return false;
		}
	}

	*//**
	 * 检测人脸
	 * *//*
	public static boolean checkhead(final String url) {
		if (url == null || !url.startsWith("http")) {
			return false;
		}
		// 新建一个OperationManager对象
		OperationManager operater = new OperationManager(auth);
		try {
			return operater.checkhead(url + "?tusdk-face/detection");
		} catch (QiniuException e) {
			return false;
		}
	}

	public static String pop(final int type, final String key) {
		// 新建一个OperationManager对象
		OperationManager operater = new OperationManager(auth);
		String bucketname = bucket;
		String fops = null;
		if (type == 1) {
			bucketname += "head";
			// fops = "facecrop2/240x240";
			fops = "imageView2/1/w/200/h/200";
		} else if (type == 2) {
			fops = "imageView2/1/w/240/h/240";
			bucketname += "200";
		} else if (type == 3) {
			bucketname += "300";
			fops = "imageView2/0/h/600";
		} else {
			return null;
		}
		// 可以对转码后的文件进行使用saveas参数自定义命名，当然也可以不指定文件会默认命名并保存在当前空间。
		String urlbase64 = UrlSafeBase64.encodeToString(bucketname + ":" + key);
		String pipeline = "pipelinename" + type;
		String pfops = fops + "|saveas/" + urlbase64;
		// 设置pipeline参数
		StringMap params = new StringMap().putWhen("force", 1, true)
				.putNotEmpty("persistentPipeline", pipeline);
		try {
			return operater.pfop(bucket, key, pfops, params);
			// 打印返回的persistid
		} catch (QiniuException e) {
			// 捕获异常信息
			e.printStackTrace();
		}
		return null;
	}

	*//**
	 * @return the bucketHuabei
	 *//*
	public static String getBucketHuabei() {
		return bucket_huabei;
	}

	public static void main(String[] args) {
		System.out.println(checkhead("http://7xsj1i.com2.z0.glb.qiniucdn.com/3b5c853bd791b71295b2a00099be56a6.jpg"));
	}
*/}
