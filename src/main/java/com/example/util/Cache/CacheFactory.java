package com.example.util.Cache;


public class CacheFactory   {
	
	public static final int DAY = 60*60*24;
	public static final int HOUR = 60*60;
    public static final int MINUTE = 60;
    
	private final static String DATE = "20171205";
	
	/** **********************sys************************/
	public final static String CACHE_TSRC = "beijing.com.busi.sys.dao.bean.TSrc_";// 来源信息

	public final static String CACHE_TREGION = "beijing.com.busi.sys.dao.bean.TRegion_";// +id行政区划
	public final static String CACHE_TREGION_BYNAME = "beijing.com.busi.sys.dao.bean.TRegion_name_";// +name行政区划
	public final static String CACHE_TSYS = "beijing.com.busi.sys.dao.bean.TSys_";// 应用信息
	public final static String BANNER_LIST= "beijing.com.busi.sys.dao.bean.TBanner_";//Banner列表
	
	
	
	/** **********************user********************** **/
	public static final String USER_USER_ACCOUNT = "beijing.com.busi.user.dao.bean.UserAccount_new_"
			+ DATE;// +userid用户基本信息
	
	public static final String USER_NUMS_IP = "beijing.com.busi.user.dao.bean.UserAccount_ip_"
			+ DATE;// +某个ip的用户

	public static final String USER_ACCOUNT_M = "beijing.com.busi.user.dao.bean.UserAccount_mobile_new_"
			+ DATE;// +mobile_appid用户基本信息

	public static final String APP_VISITOR = "beijing.com.busi.user.dao.bean.AppVisitor_"
			+ DATE;// +imei_appid访客的的基本信息
	public static final String IDFA_PARTNER = "beijing.com.busi.user.dao.bean.IdfaPartner_"
			+ DATE;// +IDFA 合作方推广的idfa
	public static final String APP_VISITOR_BYUID = "beijing.com.busi.user.dao.bean.AppVisitor_uid_"
			+ DATE;// +uid访客的的基本信息

	public static final String USER_USER_MESS_CONF = "beijing.com.busi.user.dao.bean.UserMessConf_"
			+ DATE;// +userid 接收消息的配置


	public static final String USER_BLACK_LIST = "beijing.com.busi.user.dao.bean.UserBlackList_"
			+ DATE;// +imei+"_"+appid 黑名单

	public static final String USER_ACCUSATION = "beijing.com.busi.user.dao.hibernate.UserAccusation_"
			+ DATE;// +被举报人id+_+举报人id
	
	
	
	
	
	/** **********************contact********************** **/
	// 关注begin
	public static final String USER_FOLLOWME_LIST = "beijing.com.busi.contact.dao.bean_FollowMe_"
			+ DATE;// +关注我的人的列表
	public static final String USER_FOLLOWME_NUM = "beijing.com.busi.contact.dao.bean_FollowMe_num_"
			+ DATE;// +关注我的人书
	public static final String USER_FOLLOWFRIEND_NUM = "beijing.com.busi.contact.dao.bean_Followfriend_num_"
			+ DATE;// +我关注的人的数

	public static final String USER_FOLLOWFRIEND_LIST = "beijing.com.busi.contact.dao.bean.ContactFriend_followlist_"
			+ DATE;// +userid我关注的人员的列表

	public static final String USER_FOLLOWFRIEND_UID_LIST = "beijing.com.busi.contact.dao.bean.ContactFriend_followlist_fuid_list_"
			+ DATE;// +userid我关注的人员的列表

	public static final String USER_BLOCKFRIEND_LIST = "beijing.com.busi.contact.dao.bean.ContactFriend_blocklist_"
			+ DATE;// +userid用户加黑的列表信息

	public static final String USER_VISITOR_LIST_TOPN = "beijing.com.busi.contact.dao.bean.UserVisitor_list_topn_"
			+ DATE;// +userid用户的访客列表

	public static final String USER_FRIEND = "beijing.com.busi.contact.dao.bean.ContactFriend_"
			+ DATE;// +userid+"_"+fuid用户好友信息

	public static final String USER_YUNYIN_LIST = "beijing.com.busi.contact.dao.bean.UserAccount_list_yunyin_"
			+ DATE;//
	
	
	
	
	
	/** **********************search********************** **/
	public static final String SEARCH_HOT_WORDS = "com.busi.search.dao.bean.SearchHotWords_";// 热词列表
	// 消息和通知begin
	public static final String USER_PUSH_LIST = "beijing.com.busi.message.dao.bean.PushDetail_";// +userid送消息列表
	// 消息和通知end
	public static final String USER_PUSHALL_LIST = "beijing.com.busi.contact.dao.bean.UserPushAll_list_"
			+ DATE;// 全局推送用户

	public static final String PUSH_ALL_DETAIL = "beijing.com.busi.message.dao.bean.PushAllDetail_times_";
	// 全局推送用户次数

	public static final String USER_PUSH = "beijing.com.busi.contact.dao.bean.UserPush_"
			+ DATE;// +userid接收消息列表
	public static final String USER_VIDEO_LIST = "beijing.com.busi.show.dao.bean.ShowAudience_"
			+ DATE;// +最新的show列表

	public static final String STAR_USER_RANKING_AD = "beijing.com.busi.show.dao.bean.ShowUserRanking_ad_";// +红人榜视频

	public static final String USER_USER_RANKING = "beijing.com.busi.show.dao.bean.ShowUserRanking_";// +红人榜

	public static final String USER_USER_TOTAL_RANKING = "beijing.com.busi.show.dao.bean.ShowUserTotalRanking_";// +红人总榜

	public static final String USER_VIDEO_LIST_NEW = "beijing.com.busi.show.dao.bean.ShowAudience_new_"
			+ DATE;// +最新的show列表
	public static final String USER_LATEST_VIDEO_LIST = "beijing.com.busi.show.dao.bean.ShowAudience_latest_userid_"
			+ DATE;// +userid 用户最新一条可以看的show
	public static final String USER_LAST_VIDEO = "beijing.com.busi.show.dao.bean.ShowAudience_last_userid_"
			+ DATE;// +userid 用户最新一条show
	public static final String USER_VIDEO = "beijing.com.busi.show.dao.bean.ShowAudience_" + DATE;// +id show的明细
	public static final String USER_VIDEO_LIVE = "beijing.com.busi.show.dao.bean.ShowAudience_live_"
			+ DATE;// +id 直播show的明细
	public static final String USER_VIDEO_BYJOINID = "beijing.com.busi.show.dao.bean.ShowAudience_join_id_"
			+ DATE;// +joinid的明细
	public static final String USER_VIDEO_JOIN_LIST = "beijing.com.busi.show.dao.bean.ShowAudience_join_list_"
			+ DATE;// 看直播的人员列表
	
	
	
	
	/** **********************show********************** **/
	public static final String SHOW_STAR_RECOMMEND_LIST = "beijing.com.busi.show.dao.bean.ShowAudienceRecommend_list_"
			+ DATE;// 推荐直播列表

	public static final String TOP = "TOP";// 推荐直播列表

	public static final String SHOW_STAR_RECOMMEND_VIDEO_LIST = "beijing.com.busi.show.dao.bean.ShowAudienceRecommend_video_list_"
			+ DATE;// 重播列表

	public static final String SHOW_STAR_RECOMMEND = "beijing.com.busi.show.dao.bean.ShowAudienceRecommend_"
			+ DATE;// 推荐直播

	public static final String SHOW_FORECAST_LIST = "haibo.com.busi.show.dao.bean.ShowForecast_list_"
			+ DATE;// 预告列表
	public static final String SHOW_NEW_FORECAST_LIST = "haibo.com.busi.show.dao.bean.ShowForecast_list_"
			+ DATE;// 预告列表
	public static final String SHOW_FORECAST_TIMES = "haibo.com.busi.show.dao.bean.ShowForecast_times_"
			+ DATE;// 预告列表
	public static final String SHOW_FORECAST_DETAIL = "haibo.com.busi.show.dao.bean.ShowForecast_detail_"
			+ DATE;// +id
	public static final String SHOW_FORECAST_INFO = "haibo.com.busi.show.dao.bean.ShowForecast_info_"
			+ DATE;// +id
	public static final String SHOW_USER_NUM = "beijing.com.busi.show.dao.bean.ShowUser_NUMS_"
			+ DATE;
	public static final String SHOW_RECOMMEND_LIST = "beijing.com.busi.show.dao.bean.ShowRecommend_list_"
			+ DATE;
	public static final String SHOW_RECOMMEND_ONEDAY_LIST = "beijing.com.busi.show.dao.bean.ShowRecommend_oneday_list_"
			+ DATE;// 一天内的推荐视频
	public static final String SHOW_RECOMMEND_HOT_LIST = "beijing.com.busi.show.dao.bean.ShowRecommend_hot_list_"	;// 热门视频
	public static final String SHOW_RECOMMEND_STAR_HOT_LIST = "beijing.com.busi.show.dao.bean.ShowRecommend_star_hot_list_"
			+ DATE;// 红人推荐视频
	public static final String SHOW_LABEL_LIST = "beijing.com.busi.show.dao.bean.ShowLabel_list_"
			+ DATE;	
	public static final String SHOW_LABEL = "beijing.com.busi.show.dao.bean.ShowLabel_"
			+ DATE; // +labelid
	public static final String SHOW_LABEL_TEXT = "beijing.com.busi.show.dao.bean.ShowLabel_TEXT_"
			+ DATE; // +labelid
	public static final String SHOW_THEME_VIDEO_LIST = "beijing.com.busi.show.dao.bean.ShowTHEME_video_list_"
			+ DATE;
	public static final String SHOW_LABEL_VIDEO_LIST = "beijing.com.busi.show.dao.bean.ShowLABEL_video_list_"
			+ DATE;
	public static final String SHOW_VIDEO_LABEL_LIST = "beijing.com.busi.show.dao.bean.ShowLABEL_video_list_"
			+ DATE;
	public static final String SHOW_GAG_PERMANENT_LIST = "beijing.com.busi.show.dao.bean.ShowGag_list_permanent_"
			+ DATE;// 永久禁言
	public static final String SHOW_GAG_LIST = "beijing.com.busi.show.dao.bean.ShowGag_list_show_"
			+ DATE;// + showid 视频内禁言
	public static final String SHOW_VIDEO = "haibo.com.busi.show.dao.bean.Showvideo_"
			+ DATE;// + userid+_+showid录播地址
	
	public static final String USER_VIDEO_FRIENDT = "beijing.com.busi.show.dao.bean.ShowAudience_friend_"
			+ DATE;// +userid 好友直播的列表
	public static final String USER_VIDEO_FRIENDT_OVER_SIZE = "beijing.com.busi.show.dao.bean.ShowAudience_friend_over_size_"
			+ DATE;// +userid 录播数
	public static final String USER_VIDEO_DETAIL_LIST = "beijing.com.busi.show.dao.bean.ShowAudienceDetail_"
			+ DATE;// +showid 评论或者赞的明细
	public static final String USER_VIDEO_DETAIL_HISTORY_LIST = "beijing.com.busi.show.dao.bean.ShowAudienceDetail_history_"
			+ DATE;// +showid 获取录播的弹幕
	public static final String USER_MY_OPT_SHOW_NUMS = "beijing.com.busi.show.dao.bean.ShowOptText_my_list_"
			+ DATE;// +userid获取对我评价过的直播数
	public static final String USER_SHOW_USER_OPT = "beijing.com.busi.show.dao.bean.show_opt_"
			+ DATE;// +userid+_wuid+wid我对whisper做的操作

	public static final String USER_RECOMMEND_SHOW_LIST_SIZE = "beijing.com.busi.photo.dao.bean.ShowAudience_recommend_list_size_userid_"
			+ DATE;// 用户照片列表
	public static final String USER_PHOTO_LIST = "beijing.com.busi.photo.dao.bean.PhotoText_list_"
			+ DATE;// 用户照片列表
	public static final String USER_NICKNAME_LIST = "beijing.com.busi.sys.dao.bean.TNickName_list_"
			+ DATE;// 用户昵称列表
	public static final String USER_VISITOR_IMEI = "beijing.com.busi.user.dao.bean.UserVisitor_imei_"
			+ DATE;// 游客信息
	public static final String USER_VISITOR_UID = "beijing.com.busi.user.dao.bean.UserVisitor_uid_"
			+ DATE;// 游客信息
	public static final String HOT_SCORE_CONFIG = "beijing.com.busi.user.dao.bean.THotConfig_"
			+ DATE;// 热度配置
	public static final String OPERATING_CONFIG = "beijing.com.busi.user.dao.bean.TOperatingConfig_"
			+ DATE;// 运营配置
	public static final String VIDEO_SERVER = "beijing.com.busi.user.dao.bean.TVideoStore_";// 运营配置

	public static final String T_VIP_LEVEL = "beijing.com.busi.user.dao.bean.TVipLevel_";// 会员等级配置

	public static final String T_RED_PACKET = "beijing.com.busi.user.dao.bean.TRedPacket_";// 红包配置

	public static final String COMMENT_CONFIG = "beijing.com.busi.user.dao.bean.TCommentConfig_"
			+ DATE;// 随机评论配置
	public static final String SHOW_DETAIL = "beijing.com.busi.user.dao.bean.ShowAudience_"
			+ DATE;// 视频操作明细

	public static final String SHOW_AUDIENCE_DETAIL = "beijing.com.busi.user.dao.bean.ShowAudienceDetail_detail_"
			+ DATE;// 视频操作明细
	public static final String SHOW_DETAIL_INFO = "beijing.com.busi.user.dao.bean.ShowAudienceDetail_info_"
			+ DATE;// 视频操作二级明细
	public static final String SHOW_DETAIL_INFO_NUMS = "beijing.com.busi.user.dao.bean.ShowAudienceDetail_info_nums_"
			+ DATE;// 视频操作二级明细

	public static final String PAYMENT_PRODUCT = "beijing.com.busi.payment.dao.bean.Product_"
			+ DATE;// 銷售的產品
	public static final String PAYMENT_PRODUCT_TYPE = "beijing.com.busi.payment.dao.bean.Product_type_"
			+ DATE;// 銷售的產品
	public static final String PAYMENT_PRODUCT_DETAIL = "beijing.com.busi.payment.dao.bean.ProductDetail_"
			+ DATE;// 銷售的產品
	public static final String PAYMENT_PRODUCT_DETAIL_UNAVAILABLE = "beijing.com.busi.payment.dao.bean.Product_detail_unavailable_"
			+ DATE;// 銷售的產品
	public static final String PAYMENT_SERVICE = "beijing.com.busi.payment.dao.bean.Service_"
			+ DATE;// 銷售的服务
	public static final String PAYMENT_SERVICE_PRODUCT = "beijing.com.busi.payment.dao.bean.Service_product_"
			+ DATE;// 銷售的服务
	public static final String PAY_ACCOUNT = "beijing.com.busi.payment.dao.bean.pay_account_"
			+ DATE;// 账户信息
	public static final String USER_SUBSCRIBE = "beijing.com.busi.payment.dao.bean.user_subscribe_"
			+ DATE;// 用户的服务信息
	public static final String USER_SUBSCRIBE_ACTIVE = "beijing.com.busi.payment.dao.bean.user_subscribe_active_"
			+ DATE;// 用户的有效服务
	public static final String USER_SUBSCRIBETIMES = "beijing.com.busi.payment.dao.bean.user_subscribe_times_"
			+ DATE;// 用户按次的服务信息
	public static final String USER_SUBSCRIBETIMES_ACTIVE = "beijing.com.busi.payment.dao.bean.user_subscribe_times_active_"
			+ DATE;// 用户按次的服务信息
	public static final String USER_PRODUCT_LOG = "beijing.com.busi.payment.dao.bean.ConsumeProductLog_"
			+ DATE;// 用户消费产品日志
	public static final String USER_SERVICE_LOG = "beijing.com.busi.payment.dao.bean.ConsumeServiceLog_"
			+ DATE;// 用户购买服务日志
	public static final String USER_PRODUCT = "beijing.com.busi.payment.dao.bean.UserProduct_"
			+ DATE;// 用户消费产品日志
	public static final String PAY_RANKING = "beijing.com.busi.payment.dao.bean.PayRanking_"
			+ DATE;// 榜单
	public static final String PAY_CASH_APPLYMENT_ID= "beijing.com.busi.payment.dao.bean.PayCashApply_ID_"
			+ DATE;// 用户提现日志
	public static final String PAY_CASH_APPLYMENT = "beijing.com.busi.payment.dao.bean.PayCashApply_"
			+ DATE;// 用户提现日志
	public static final String PAY_CASH_APPLYMENT_MONTH = "beijing.com.busi.payment.dao.bean.PayCashApply_month_"
			+ DATE;// 用户本月提现成功记录
	public static final String USER_MESSAGE_RECEIVE = "beijing.com.busi.message.dao.bean.MessageText_userid_"
			+ DATE;// 用户接收消息
	public static final String PRESENT_ORDERS = "beijing.com.busi.payment.dao.bean.PresentOrders_"
			+ DATE;// 用户获取收益记录
	public static final String PRESENT_ORDERS_TIMES = "beijing.com.busi.payment.dao.bean.PresentOrders_times_"
			+ DATE;// 用户获取收益记录
	public static final String SEXYWORD_LIST = "beijing.com.busi.sys.dao.bean.SexWords_"
			+ DATE;// 脏词
	public static final String SEXYWORD_LIST_MANAGER = "beijing.com.busi.sys.dao.bean.SexWords_manager_";// 后台管理设置的敏感词
	public static final String beijing_BANNER_LIST = "beijing.com.busi.acitvity.dao.bean.Banner_"
			+ DATE;// 首页的banner
	public static final String STAR_IMG = "beijing.com.busi.sys.dao.bean.star_img"
			+ DATE;// 启动图
	public static final String STAR_SYS_NOTICE = "beijing.com.busi.sys.dao.bean.star_sys_notice"
			+ DATE;// 系统公告
	public static final String PAYMENT_GIFT="beijing.com.busi.payment.dao.bean.payment_gift"
			+ DATE;//礼物
	
	public static final String PAYMENT_GIFT_price="beijing.com.busi.payment.dao.bean.payment_gift_price"
			+ DATE;//礼物价格
	
	public static final String RED_PACKAGE="beijing.com.busi.payment.dao.bean.payment.red_package_"
			+ DATE;//红包
	public static final String SHOW_RED_PACKAGE="beijing.com.busi.payment.dao.bean.payment.show_red_package_"
			+ DATE;//红包
	public static final String RED_PACKAGE_RECORD="beijing.com.busi.payment.dao.bean.payment.red_package_record"
			+ DATE;//红包
	public static final String EXCHANGE_ORDERS_LIST="beijing.com.busi.payment.dao.bean.exchange_orders_"
			+ DATE;//兑换记录
	public static final String EXCHANGE_SHOW_SEND="beijing.com.busi.payment.dao.bean.exchange_orders_show_send_"
			+ DATE;//兑换记录

	//榜单
	public static final String BILLBOARD_STARE_ORDERS_GROUP_BY_USER="billBoard.starOrders.popularity.user_";//直播间人气值榜单
	public static final String BILLBOARD_STARE_ORDERS_GROUP_BY_USER_MIRROR="billBoard.starOrders.popularity.user_mirror_";//直播间人气值榜单(5s更新）
	public static final String BILLBOARD_PRESENT_ORDERS="billBoard.presentOrders.userExp_";//活力榜（实时）
	 public static final String BILLBOARD_PRESENT_ORDERS_MIRROR="billBoard.presentOrders.userExp.mirror_";//活力榜缓存镜像（每小时更新）
	public static final String BILLBOARD_STAR_ORDERS_ARTIST = "billBoard.starOrders.artist_";//F00.108艺人榜（实时更新）
	public static final String BILLBOARD_STAR_ORDERS_ARTIST_MIRROR = "billBoard.starOrders.artist.mirror_";//F00.108艺人榜（每小时更新）
	public static final String BILLBOARD_STAR_ORDERS_DEVOTE= "billBoard.starOrders.devote_";//F00.108贡献榜（实时更新）
	public static final String BILLBOARD_STAR_ORDERS_DEVOTE_MIRROR= "billBoard.starOrders.devote.mirror_";//F00.108贡献榜（每小时更新）
	public static final String BILLBOARD_STAR_ORDERS_DEVOTE_FROM_ME= "billBoard.starOrders.devote.from.me_";//F00.36我的贡献榜（实时更新）
	public static final String BILLBOARD_STAR_ORDERS_DEVOTE_FROM_ME_MIRROR= "billBoard.starOrders.devote.from.me.mirror_";//F00.36我的贡献榜（每小时更新）
	public static final String USERSHAREBOARD = "USERSHARELIST"+ DATE;//F00.108分享榜


	public static final String ACTIVITY_SHOW_LIST="beijing.com.busi.show.dao.bean.show_list_activity_"
			+ DATE;//活动视频列表
	public static final String ACTIVITY_LIST="beijing.com.busi.search.dao.bean.activity_list_"
			+ DATE;
	public static final String ACTIVITY_INFO="ACTIVITY_INFO";
	public static final String ACTIVITY_INFO_ID="ACTIVITY_INFO_ID";
	public static final String ACTIVITY_INFO_LIST="ACTIVITY_INFO_LIST";
	/**节假日*/
	public static final String HOLIDAY_INFO_LIST="HOLIDAY_INFO_LIST";
	//55接口启动图
	public static final String STARIMG="STARIMG";

	//地域
	public static final String SYS_TREGION="SYS_TREGION_";


	public static final String ACTIVITY_PEOPLE_LIST="beijing.com.busi.search.dao.bean.activity_people_"
			+ DATE;
	public static final String IDENTIFYING_CODE_UID="beijing.com.busi.sys.dao.bean.Identifying_Code_uid_"
			+ DATE;
	public static final String IDENTIFYING_CODE="beijing.com.busi.sys.dao.bean.Identifying_Code_new_"
			+ DATE;
	public static final String PC_BANNER_LIST="beijing.com.busi.sys.dao.bean.PC_Banner_new_"
			+ DATE;
	public static final String RECHARGE_RECORD_LIST="beijing.com.busi.payment.dao.bean.order_new_" + DATE; //充值记录
	
	public static final String RECHARGE_EXPR_RECORD_LIST="beijing.com.busi.payment.dao.bean.expr_order_new_" + DATE; //潮人表情购买历史录

	public static final String THRID_LOGIN="thrid.login" + DATE; //第三方登录
	
	public static final String DIANZAN="beijing.com.lanxiong.modle.live.po.ShowAudience_dianzan_"; //点赞
	public static final String DIANLIANG="beijing.com.lanxiong.modle.live.po.ShowAudience_dianliang_"; //每个直播间的每个观众第一次点赞要同时点亮，此集合记录每个直播间用户（不重复）
	public static final String ACTIVITY_BROWSE_NUM="beijing.com.busi.activity.dao.bean.Activity.browsenum_"; //活动浏览次数
	public static final String SHOWAUDIENCEDETAIL_QUEUE="beijing.com.lanxiong.modle.live.po.ShowAudienceDetail_insertBatch_queue"; //点赞详细队列
	
	
	public static final String SHOWSENDMONEY = "com.busi.payment.helper.PaymentUtil_SendMoney"+ DATE;//捡钻石防重
	public static final String SHOWPAYMENT = "SHOWPAYMENTLIST"+ DATE;//F00.35直播榜

	public static final String SHOWSHAREBOARD = "SHAREEBOARDLISTLIMIT100"+ DATE;//F00.99 用户分享榜
	public static final String BANNERLIST = "BANNERLIST";//F00.53接口
	public static final String OPERATION = "OPERATION"+ DATE;//F00.53运营公告
	public static final String USER_VIDEO_CONTROL_LIST = "beijing.com.busi.show.dao.bean.ShowAudienceControl_"+ DATE;// +showid 场控

	//礼物gift和gift15
	public static final String GIFT="beijing.com.lanxiong.modle.trans.po.Gift_";
	public static final String GIFT_ID="beijing.com.lanxiong.modle.trans.po.Gift_id_";
	//public static final String SHOW_AUDIENCE_OPT1="beijing.com.busi.show.dao.bean.ShowAudience_"; //点赞

	//通用用户缓存
	public static final String USERACCOUNT="user_account_";


	public static final String USER_ONLINE = "user_online_";
	//用户邀请码
	public static final String IDENTIFYINGCODE="identifying_code_";

	//两个用户关系
	public static final String CONTACT_FRIEND_="contact_friend_userid_fuid_";

	//两个用户关系为关注
	public static final String CONTACT_FRIEND_NO_CONTACT="contact_friend_no_contact_userid_fuid_";

	//没有加黑
	public static final String CONTACT_FRIEND_IS_BLOCK_="contact_friend_userid_fuid_is_block";

	public static final String CONTROL_USERID_FUID="control_userid_fuid";

	public static final String NO_CONTROL_USERID_FUID="no_control_userid_fuid";




	//消费MQ队列（生产者添加，消费者删除），用于判断此消息是否已经被消费，防止重复消费
	public static final String CONSUME_QUERY="CONSUME_QUERY_";
	//消费者用于再并发消费时判断是否重复消费
	public static final String CONSUME_SHOUKUAN_ONLY="CONSUME_SHOUKUAN_ONLY_";
	//视频监控消息通知
	public static final String SCROLL_NOTICE_LIST="beijing.com.live.monitor.scroll.notice";


	public static final String SHOWOPT_TYPE1_QUEUE="beijing.com.busi.show.dao.bean.showopt_type1_queue"; //点赞详细队列
	public static final String ACTIVITY_BROWSENUM="beijing.com.busi.activity.dao.bean.Activity.browsenum_"; //浏览次数


	public static final String SHOW_HEART="beijing.show.heart_"; //直播心跳

	//图片长宽缓存
	public static final String SHOW_IMG_WH="beijing.show.img_"; //
	
	

	public static final String SHOW_ALLANCHOR="show_allanchor";//所有主播
	/**
	 * 消息未读数键
	 */
	public static final String NOITCE_KEY = "beijing.com.live.app.notice_";


	//APP首页缓存
	public static final String APP_UPDATE_PAGE_BY_ID="app.update.page.byid_";

	//我的关注列表
	public static final String FOLLOWFRIENDLIST="followFriendList_";

	//直播间收到关注数
	public static final String CONTACT_IN_SHOW="do_contact_in_showid_";

	//直播间收到关注数，记录防止一个用户多关注多次
	public static final String CONTACT_IN_SHOW_USERID_FUID_SHOWID="do_contact_in_showid_showid_userid_fuid";
}
