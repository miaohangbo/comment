package com.example.util.common;

import java.util.HashMap;
import java.util.Map;

public class Enums {

	public static final int ISO_CODE = 1;
	public static final int ANDROID_CODE = 2;

	public static final int START_IMAGE_TYPE_HMLT5 = 1;//启动页html5类型
	public static final int START_IMAGE_TYPE_SMALL_VIDEO = 2;//启动页小视频
	public static final int START_IMAGE_TYPE_BACK_VIDEO = 3; //启动页回放
	public static final int START_IMAGE_TYPE_USER_DETAIL  = 4;//启动页个人主页
	public static final int START_IMAGE_TYPE_LIVE_VIDEO = 5;//启动页直播
	public static final int START_IMAGE_TYPE_BILLBOARD = 6;//启动页榜单

	public static final int STATUS_SYS_DELETE = -2;// 系统删除
	public static final int STATUS_DELETE = -1;// 已作废
	public static final int STATUS_TODO = 0;// 未处理
	public static final int STATUS_SUCCESS = 2;// 成功
	public static final int STATUS_OK = 1;// 正常

	public static final int PUSH_POST = 1;// 已发送给客户端
	public static final int PUSH_NEW = 0;// 未发送给客户端

	public static final int OPT0 = 0;// 退出观看直播
	public static final int OPT1 = 1;// 1点赞
	public static final int OPT2 = 2;// 分享
	public static final int OPT3 = 3;// 评论
	public static final int OPT4 = 4;// 观看直播

	public static final int REGION_LEVEL1 = 1;// 1级行政区划
	public static final int REGION_LEVEL2 = 2;// 2级行政区划

	public static int EXT_REG_RESET = 1;// 注册
	public static int EXT_SMS_MODIFY = 2;// 重置密码
	public static int EXT_SMS_BANG = 3;// 绑定验证码
	public static int EXT_SMS_LOGIN = 7;// 密码登录

	public static final int NOTICE_TYPE_OPT4 = 1;// 观看
	public static final int NOTICE_TYPE_OPT1 = 2;// 观看
	public static final int NOTICE_TYPE_OPT3 = 3;// 评论
	public static final int NOTICE_TYPE_OPT5 = 9;// 抽奖
	public static final int NOTICE_TYPE_OPT6 = 10;// 捡钻石
	public static final int NOTICE_TYPE_OPT7 = 11;// 关注
	public static final int NOTICE_TYPE_OPT8 = 12;// 分享
	public static final int NOTICE_TYPE_STAR_SEND = 4;// 有人送京票
	public static final int NOTICE_TYPE_GAP = 5;// 禁言
	public static final int NOTICE_SEND_OPT1 = 6;// 点赞
	public static final int NOTICE_CONTACT_USER_SHOW = 7;// 关注的人开播提醒
	public static final int NOTICE_TYPE_GAP_REMOVE = 8;// 取消禁言
	public static final int NOTICE_TYPE_CONTACT_EACH = 10;// 被关注
	public static final int NOTICE_TYPE_SHOW_FORECAST = 11;// 直播预报
	public static final int NOTICE_TYPE_15 = 15;// 发红包
	public static final int NOTICE_TYPE_MIC = 110;// 直播间连麦
	public static final int NOTICE_CONNECT_CLOSE = 104;// 关闭连麦
	//public static final int NOTICE_SHOW_CLOSE = 111;// 直播结束

	
	

	public static final int NOTICE_BAT = 20;// 批量推送
	public static final int NOTICE_USER = 21;// 定時推送
	// 搜索更新类型
	public static final int IUD_ADD = 1;// insert
	public static final int IUD_MOD = 2;// update
	public static final int IUD_DEL = 3;// delete

	// 状态
	public static final int AUDIT_DELETE = -2;// 用户删除
	public static final int AUDIT_BLACK = -1;// 加黑
	public static final int AUDIT_FORBID = 0;// 未审核
	public static final int AUDIT_NORMAL = 1;// 已发布待审核
	public static final int AUDIT_PASS = 2;// 审核通过
	public static final int AUDIT_NORMAL_CHANGE = 2;// 已发布未审核(变更后)
	public static final int AUDIT_PASS_CHANGE = 3;// 已发布已审核 (变更后)

	public static final int MULTICHAT_TYPE_CREATE = 1;// 创建房间
	public static final int MULTICHAT_TYPE_SEND = 2;// 发送消息

	public static final int NETWORD_WIFI = 4;// wifi网络

	public static final String PHOTO_100 = "100";

	public static final String PHOTO_300 = "400";

	public static final String PHOTO_600 = "600";

	public static final String PHOTO_640 = "640";
	
	public static final String PHOTO_PC = "2000";

	public static final int SHOW_TYPE0 = 0;// 未发布
	public static final int SHOW_TYPE1 = 1;// 直播
	public static final int SHOW_TYPE2 = 2;// 录播
	public static final int SHOW_TYPE3 = 3;// 过期
	public static final int SHOW_TYPE4 = 4;// 删除

	public static final int CDN_TYPE_1 = 1;// 1网宿

	public static final int FORBID_DAYS = 15;// 暂封直播权限天数

	public static final int PUSH_LIMIT = 1;// 用户当天推送次数限制

	public static final int PUSH_ALL_LIMIT = 5;// 用户每天接收推送次数限制

	public static final int SEX_FEMALE = 1;// 女

	public static final int SEX_MALE = 2;// 男

	public static final int SEX_NONE = 3;// 无性别

	public static final String IOS_DEFAULT_MAC = "0000000000";// ios默认mac

	public static final Long ACTIVE_OPPO = 2L;

	public static final int PAY_STATUS_UNABLE = 0;// 无效
	public static final int PAY_STATUS_ENABLE = 1;// 有效未支付
	public static final int PAY_STATUS_PAYED = 2;// 有效已支付

	public static final int GIFT_RATE = 1;// 钻石转化京票比率1：1
	public static final double EXCHANGE_RATE = 0.7;// 京票兑换钻石比例70%（100京票=70钻石）
	public static final double EXCHANE_MONEY = 0.07;// 京票兑换人民币比例7%（100京票=7元）

	public static final int PAY_TYPE_1 = 1;// 支付寶
	public static final int PAY_TYPE_2 = 2;// 微信
	public static final int PAY_TYPE_3 = 3;// APPSTORE
	public static final int PAY_TYPE_4 = 4;// 使用钻石余额购买

	public static final int PRESENT_TYPE_LOGIN = 1;// 注册
	public static final int PRESENT_TYPE_VIDEO = 2;// 发直播
	public static final int PRESENT_TYPE_WATCH = 3;// 看直播
	public static final int PRESENT_TYPE_SHARE = 4;// 分享
	public static final int PRESENT_TYPE_MESSAGE = 5;// 发言
	public static final int PRESENT_TYPE_PAY = 6;// 消费
	public static final int PRESENT_TYPE_LOTTERY = 7;//抽奖

	public static final int EXCHANGE = 1;// 京票兑换钻石
	public static final int EXCHANGE_RED = 2;// 红包领取
	public static final int EXCHANGE_RECEIVE_RED = 3;// 红包返还
	public static final int EXCHANGE_SYSTEM_SEND_MONEY = 4;// 财务系统发放钻石
	public static final int EXCHANGE_SYSTEM_SEND_STARS = 5;// 财务系统发放看豆
	public static final int EXCHANGE_CASH_APPLY = 6;// 京票提现
	public static final int EXCHANGE_SHOW_SEND = 7;// 直播间赠送钻石

	public static final int SERVICE_STATUS_INVALID = -1;// 无效
	public static final int SERVICE_STATUS_NONE = 0;// 无
	public static final int SERVICE_STATUS_UNACTIVATED = 1;// 未使用
	public static final int SERVICE_STATUS_ACTIVED = 2;// 已使用
	public static final int SERVICE_STATUS_EXPIRED = 3;// 已过期

	public static final int SERVICE_TYPE1 = 1;// 服务类型按次
	public static final int SERVICE_TYPE2 = 2;// 服务类型按时间

	public static final int CASH_APPLY_MIN = 1;// 提现下限
	public static final int CASH_APPLY_MAX = 200;// 提现上限

	public static final int CASH_APPLY_ING = 1;// 提现审核中
	public static final int CASH_APPLY_OK = 2;// 提现审核通过
	public static final int CASH_APPLY_SUCESS = 3;// 财务转账通过

	public static final int VIP_CARD_BY_VIP12 = 1;// 购买12个月VIP赠送
	public static final int VIP_CARD_BY_UPGRADE = 2;// 升级奖励
	public static final int VIP_CARD_BY_FRIEND = 3;// 好友赠送
	public static final int VIP_CARD_BY_LOTTERY = 4;// 抽奖获得
	public static final int VIP_CARD_BY_LEVEL = 5;// 用户等级升级获得
	public static final int VIP_CARD_BY_SYS = 6;// 首充礼包

	public static final int COMMENT_PERSECOND = 3;// 评论每秒条数
	public static final int COMMENT_DELAY_MAX = 60;// 评论延迟时间上限

	public static final int REPORT_TYPE_SILENCE = 0;// 禁言
	public static final int REPORT_TYPE_VIDEO = 1;// 视频
	public static final int REPORT_TYPE_USER = 2;// 用户

	public static final int APPID_QQ = 1;// qq
	public static final int APPID_WEIXIN = 2;// 微信
	public static final int APPID_WEIBO = 3;// 微博
	public static final int APPID_RONGYUN = 4;// 融云

	public static final int PHOTO_TYPE_HEAD = 100;// 头像
	public static final int PHOTO_TYPE_SMALL = 300;// 小图
	public static final int PHOTO_TYPE_BIG = 600;// 大图
	public static final int PHOTO_TYPE_ORG = 0;// 原图
//	public static final String qiniuurl = "https://liveimg.beijing.com/";
	public static final String qiniuurl = "https://imglive.beijing.com/";

	public static final String redurl = qiniuurl + "/redpacket.png";// 红包图片

	public static final String PHOTO_MALE = "male.png";// 默认头像男
	public static final String PHOTO_FEMALE = "female.png";// 默认头像女

	public static final Integer TYPE_THEME = 1;// 主题
	public static final Integer TYPE_LABEL = 2;// 话题

	public static final long[] exps = { 20, 1000, 2000, 5000, 10000, 100000, 1000000, 2000000, 5000000, 10000000,
			50000000, 100000000, 500000000, 1000000000 };
	public static final int[] levels = { 0, 9, 19, 29, 39, 59, 69, 99, 129, 159, 199, 249, 299, 500 };

	public static final String TEXT1 = "兰雄直播提倡绿色直播，头像、封面、直播内容包含暴露、低俗等不良内容将会被封号噢，北京直播网警7*24小时在线巡查噢！";// 直播间里的通告
	
	public static final int SRC_PC = 5000;// 来源pc站
	
	//捡取钻石的时候根据次数获得钻石数
	public static Map<String, Integer> DIAMOND_COUNT = new HashMap<String, Integer>(){/**
		 * 
		 */
	private static final long serialVersionUID = 1L;

	{
		put("1", 1);
		put("2", 2);
		put("3", 3);
		put("4", 10);
		put("5", 15);
		put("6", 20);
		put("7", 30);
		put("8", 1);
		put("9", 2);
		put("10", 3);
		put("11", 10);
		put("12", 15);
		put("13", 20);
		put("14", 30);
	}};
}
