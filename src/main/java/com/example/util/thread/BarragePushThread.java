package com.example.util.thread;



public class BarragePushThread implements Runnable {
	private Long showuid;
	private Long showid;
	private Long userid;
	private Integer type;
	private long delay;
	private String versionCode;
	private Long giftid;
	private Integer nums;
	private Integer index;
	private String content;
	private Integer mix;// 是否连麦
	private Long id;
	private Integer sys;// 系统通知
	private Integer connect;
	private String param;
	private Long controlid;	//场控者的ID
	private String comment;	//飘瓶内容
	private Long fabulousCount;//当前直播点赞总量

	public BarragePushThread(final Integer type, final Long showid, final Long showuid, final String content,
			final Long userid, final Integer nums, final Long fabulousCount, final long delay, final Long giftid, final Integer index,
			final Integer mix, final Long id, final Integer sys,final String param) {
		this.content = content;
		this.type = type;
		this.showuid = showuid;
		this.showid = showid;
		this.userid = userid;
		this.delay = delay;
		this.nums = nums;
		this.giftid = giftid;
		this.index = index;
		this.mix = mix;
		this.id = id;
		this.fabulousCount = fabulousCount;
		this.sys = sys;
		this.param=param;
	}
	
	public BarragePushThread(final Integer type, final Long showid, final Long showuid, final String content,
			final Long userid, final Integer nums, final long delay, final Long giftid, final Integer index,
			final Integer mix, final Long id, final Integer sys,final String param) {
		this.content = content;
		this.type = type;
		this.showuid = showuid;
		this.showid = showid;
		this.userid = userid;
		this.delay = delay;
		this.nums = nums;
		this.giftid = giftid;
		this.index = index;
		this.mix = mix;
		this.id = id;
		this.sys = sys;
		this.param=param;
	}
	
	public BarragePushThread(final Integer type, final Long showid, final Long showuid, final String content,
			final Long userid, final Integer nums, final long delay, String versionCode, final Long giftid, final Integer index,
			final Integer mix, final Long id, final Integer sys,final String param) {
		this.content = content;
		this.type = type;
		this.showuid = showuid;
		this.showid = showid;
		this.userid = userid;
		this.delay = delay;
		this.nums = nums;
		this.versionCode = versionCode;
		this.giftid = giftid;
		this.index = index;
		this.mix = mix;
		this.id = id;
		this.sys = sys;
		this.param=param;
	}
	public BarragePushThread(final Integer type, final Long showid, final Long showuid, final String content,
			final Long userid, final Integer nums, final long delay, final Long giftid, final Integer index,
			final Integer mix, final Long id, final Integer sys,final String param,final String comment) {
		this.content = content;
		this.type = type;
		this.showuid = showuid;
		this.showid = showid;
		this.userid = userid;
		this.delay = delay;
		this.nums = nums;
		this.giftid = giftid;
		this.index = index;
		this.mix = mix;
		this.id = id;
		this.sys = sys;
		this.param=param;
		this.comment = comment;
	}
	public BarragePushThread(final Integer type, final Long showid, final Long showuid, final Integer connect) {
		this.type = type;
		this.showuid = showuid;
		this.showid = showid;
		this.connect = connect;
	}
	
	public BarragePushThread(final Integer type, final Long showid, final Long showuid, final String comment) {
		this.type = type;
		this.showuid = showuid;
		this.showid = showid;
		this.comment = comment;
	}
	
	public BarragePushThread(final Integer type, final Long controlid, final String content) {
		this.type = type;
		this.content = content; 
		this.controlid = controlid;
	}
	public void run() {
		if (type != null) {
			index = index==null?0:index;
			if (delay > 0) {
				try {
					Thread.currentThread().sleep(delay);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
//			PushDetail tempDetail = new PushDetail();
//			tempDetail.setShowid(showid);
//			tempDetail.setHostid(showuid);
//			tempDetail.setType(type);
//			tempDetail.setUserid(userid);
//			tempDetail.setNums(nums);
//			tempDetail.setSys(sys);
//			tempDetail.setGiftime(param);
//			tempDetail.setConnect(connect);
//			// 发红包
//			if (type == Enums.NOTICE_TYPE_15) {
//				RedPackage pack = RedPackageFunctions.RedPackage(id);
//				if (pack != null) {
//					tempDetail.setTitle(pack.getTitle());
//					tempDetail.setId(pack.getId());
//				}
//			} else {
//				tempDetail.setContent(content);
//			}
//			if (type != Enums.NOTICE_TYPE_GAP || type != Enums.NOTICE_TYPE_OPT13) {
//				UserAccount account = UserFunctions.account(userid);
//				if (account != null) {
//					tempDetail.setLevel(account.getLevel());
//					tempDetail.setNickname(account.getNickname());
//					tempDetail.setPhoto(Functions.head(account.getPhoto(), Enums.PHOTO_TYPE_HEAD));
//					tempDetail.setStar(account.getStar());
//					boolean exp = UserServiceFunctions.subscribeExp(account.getUserid(), ProductFactory.SERVICE_VIP);
//					if (exp) {
//						tempDetail.setVip(1);
//					} else {
//						tempDetail.setVip(0);
//					}
//				}
//			}
//			if (type == Enums.NOTICE_TYPE_STAR_SEND) {// 送京票
//				Gift gift = ProductFactory.getGift(giftid);
//				if (gift != null) {	
//					tempDetail.setUrl(Functions.head(gift.getUrl(), Enums.PHOTO_TYPE_ORG));
//					tempDetail.setName(gift.getName());
//					tempDetail.setIndex(index);
//					if(gift.getGiftVersion().contains("/1.4/")){
//						tempDetail.setGift(giftid);				//发送原来的礼物ID
//						tempDetail.setGifttype(gift.getType());
//					}else{
//						tempDetail.setGift(Long.valueOf(1));	//新礼物ID为糖葫芦
//						tempDetail.setGiftNewId(giftid);
//						tempDetail.setGifttype(1);
//						tempDetail.setGifttypeNew(gift.getType());
//					}
//					tempDetail.setPrice(gift.getPrice());
//					tempDetail.setCoin(gift.getPrice()*index);
//					tempDetail.setLottieAnimationName(gift.getLottieAnimationName());
//				}
//				tempDetail.setShowcoin(PaymentFunctions.getShowStarNums(showuid));
//			} else if (type == Enums.NOTICE_TYPE_OPT5) {// 抽奖
//				System.out.println("【全平台公告5】：抽中大礼物，全平台广播:");
//				Gift gift = ProductFactory.getGift(giftid);
//				if (gift != null) {
//					tempDetail.setUrl(Functions.head(gift.getUrl(), Enums.PHOTO_TYPE_ORG));
//					tempDetail.setName(gift.getName());
//					tempDetail.setIndex(index);
//					tempDetail.setGift(giftid);
//					tempDetail.setGifttype(gift.getType());
//					tempDetail.setPrice(gift.getPrice());
//				}
//				tempDetail.setShowcoin(PaymentFunctions.getShowStarNums(showuid));
//			}else if (type == Enums.NOTICE_TYPE_OPT6) {// 捡钻石
//				Gift gift = ProductFactory.getGift(giftid);
//				if (gift != null) {
//					tempDetail.setUrl(Functions.head(gift.getUrl(), Enums.PHOTO_TYPE_ORG));
//					tempDetail.setName(gift.getName());
//					tempDetail.setIndex(index);
//					tempDetail.setGift(giftid);
//					tempDetail.setGifttype(gift.getType());
//					tempDetail.setPrice(gift.getPrice());
//				}
//				tempDetail.setShowcoin(PaymentFunctions.getShowStarNums(showuid));
//			}else if (type == Enums.NOTICE_TYPE_OPT4) {// 观看
//				tempDetail.setShowcoin(PaymentFunctions.getShowStarNums(showuid));
//				ShowAudience show = ShowFunctions.getShowAudience(showuid, showid);
//				Integer onlineCount = ShowFunctions.getShowAudienceDetailCount(show);
////				ShowAudienceDetail detail = ShowFunctions.getShowAudienceDetail(show, userid, Enums.STATUS_OK, Enums.OPT4); //第二次进入直播间opt4不在加1
//				int controlCount = ShowFunctions.getShowControlRelation(show.getUserid(), userid);
//				if(show.getPrice()!=null){
//					if(show.getPrice()>0){
//						tempDetail.setCoin(show.getPrice().intValue());
//					}
//				}
//				if(controlCount>0){
//					tempDetail.setControlid(userid);
//					tempDetail.setControl(1);
//				}
//				if (show != null) {
//					if(onlineCount==null){
//						tempDetail.setOpt4(0);
//					}else{
//						tempDetail.setOpt4(onlineCount);
//					}
//				}
//				if (ShowFunctions.getType(show) > Enums.SHOW_TYPE1) {
//					return;
//				}
//
//			} else if (type == Enums.NOTICE_TYPE_MIC) {// 修改连麦状态
//				tempDetail.setMix(mix);
//			} else if (type == Enums.NOTICE_SHOW_CLOSE || type==Enums.NOTICE_SHOW_FORBIDDEN || type == Enums.NOTICE_SHOW_WATCH_FORBIDDEN){
//				UserAccount userAccount = UserFunctions.account(showuid);
//				if(userAccount!=null){
//					tempDetail.setHostnickname(userAccount.getNickname());
//				}
//			}
//			
//			if (type == Enums.NOTICE_TYPE_OPT3) {   // 评论
//				if(content.contains("点亮")){
//					tempDetail.setFabulous("1");
//				}
//				SendMessageUtil.sendMessage(Long.valueOf(SysProperties.getOfficialAccount()), showid, content,
//						JSONObject.toJSONString(tempDetail));
//			}else if (type == Enums.NOTICE_SHOW_FORBIDDEN) {   // 133の消息，直播下架，发送原因
//				tempDetail.setReason("您已经被超管强制关闭，半小时内不得再次开播。");
//				SendMessageUtil.sendMessage(Long.valueOf(SysProperties.getOfficialAccount()), showid, "",
//						JSONObject.toJSONString(tempDetail));
//			}else if (type == Enums.NOTICE_SEND_OPT1) {   // 点赞
//				tempDetail.setFabulousCount(fabulousCount);
//				SendMessageUtil.sendMessage(Long.valueOf(SysProperties.getOfficialAccount()), showid, "1111",
//						JSONObject.toJSONString(tempDetail));
//			}else if (type == Enums.NOTICE_TYPE_OPT7){//关注
//				SendMessageUtil.sendMessage(Long.valueOf(SysProperties.getOfficialAccount()), showid, content,
//						JSONObject.toJSONString(tempDetail));
//			}else if(type == Enums.NOTICE_TYPE_OPT8){// 分享
//				SendMessageUtil.sendMessage(Long.valueOf(SysProperties.getOfficialAccount()), showid, content,
//						JSONObject.toJSONString(tempDetail));
//			}else if(type == Enums.NOTICE_TYPE_OPT9){// 场控
//				SendMessageUtil.sendSysMessageToController(controlid, content, "");
//			}else if (type == Enums.NOTICE_TYPE_OPT13) {   // 飘瓶弹幕
//			    tempDetail.setShowcoin(PaymentFunctions.getShowStarNums(showuid));
//			    tempDetail.setCoin(5);
//			    tempDetail.setComment(comment);
//				System.out.println(JSONObject.toJSONString(tempDetail));
//				SendMessageUtil.sendMessage(Long.valueOf(SysProperties.getOfficialAccount()), showid, "",
//						JSONObject.toJSONString(tempDetail));
//			}else if (type == Enums.NOTICE_TYPE_OPT29) {  //在直播间取消
//			    tempDetail.setComment(comment);
//				System.out.println(JSONObject.toJSONString(tempDetail));
//				SendMessageUtil.sendMessage(Long.valueOf(SysProperties.getOfficialAccount()), showid, "",
//						JSONObject.toJSONString(tempDetail));
//			} else if(type == Enums.NOTICE_TYPE_STAR_SEND){
//				System.out.println("送礼1："+JSONObject.toJSONString(tempDetail));
//	    		SendMessageUtil.sendMessage(Long.valueOf(SysProperties.getOfficialAccount()), showid, "",
//	    				JSONObject.toJSONString(tempDetail));
//			}else if(type == Enums.NOTICE_TYPE_OPT4){
//				Object obj = CacheFactory.get(userid+showid+"WATCHSHOW");//防止进入多次直播间发多次推送
//		    	if(null==obj){
//		    		tempDetail.setIsFirstIncome("1");
//		    		System.out.println("观看推送tempDetail="+JSONObject.toJSONString(tempDetail));
//		    		SendMessageUtil.sendMessage(Long.valueOf(SysProperties.getOfficialAccount()), showid, "",
//		    				JSONObject.toJSONString(tempDetail));
//		    	}else{
//		    		tempDetail.setIsFirstIncome("0");
//		    		System.out.println("10秒重复观看推送tempDetail="+JSONObject.toJSONString(tempDetail));
//		    		SendMessageUtil.sendMessage(Long.valueOf(SysProperties.getOfficialAccount()), showid, "",
//		    				JSONObject.toJSONString(tempDetail));
//		    	}
//		    	//10秒内进入同一直播间不推送 防止进入多次直播间发多次推送
//				CacheFactory.add(userid+showid+"WATCHSHOW", "WATCHSHOW", 10);
//			}else if(type != Enums.NOTICE_TYPE_OPT5){	//抽中大礼物不再向当前聊天室里面发送礼物
//				if(type==Enums.NOTICE_CONNECT_CLOSE){
//					System.out.println("【104消息发送了】");
//					System.out.println("【104消息发送了】："+JSONObject.toJSONString(tempDetail));
//				}
//				System.out.println("送礼2："+JSONObject.toJSONString(tempDetail));
//	    		SendMessageUtil.sendMessage(Long.valueOf(SysProperties.getOfficialAccount()), showid, "",
//	    				JSONObject.toJSONString(tempDetail));
//			}
//			
//			boolean operation = false;
//			if(type == Enums.NOTICE_TYPE_OPT5){
//				System.out.println("【全平台公告3】：抽中大礼物，全平台广播:");
//			}
//			System.out.println(JSONObject.toJSONString(tempDetail));
//			if(type == Enums.NOTICE_TYPE_STAR_SEND || type == Enums.NOTICE_TYPE_OPT5){
//				System.out.println("【全平台公告4】：抽中大礼物，全平台广播:");
//				System.out.println("【全平台公告6。1，id：】"+ giftid);
//				System.out.println("【全平台公告6。2，versionCode：】"+ versionCode);
//				versionCode = versionCode==null?"1.4":versionCode;
//				if ("1.4".equals(versionCode)) {
//					if(giftid == 8||giftid == 9){
//						/**
//						 * 礼物ID: 8（月季花）、9（皇家园林）
//						 */
//						operation = true;
//					}
//				}else {
//					if(giftid == 8||giftid == 21||giftid == 36){
//						/**
//						 * 礼物ID: 8（月季花）、36（四合院）
//						 */
//						operation = true;
//					}
//				}
//				
//			}
//			
//			if(operation==true){
//				List<Long> showList = ShowFunctions.getCurrentLiveLiveIDList();
//				if(showList!=null&&showList.size()>0){
//					showList.remove(showid);
//				}
//				if(showList!=null && showList.size()>0){
//					if(type == Enums.NOTICE_TYPE_STAR_SEND){
//						System.out.println("【全平台公告1】：送大礼物，全平台广播:");
//						tempDetail.setType(Enums.NOTICE_TYPE_OPT33);
//					}else if(type == Enums.NOTICE_TYPE_OPT5){
//						System.out.println("【全平台公告2】：抽中大礼物，全平台广播:");
//						tempDetail.setType(Enums.NOTICE_TYPE_OPT32);
//					}
//					UserAccount userAccount = UserFunctions.account(showuid);
//					if(userAccount!=null){
//						tempDetail.setHostnickname(userAccount.getNickname());
//					}
//					System.out.println(JSONObject.toJSONString(tempDetail));
//					SendMessageUtil.sendMessage(Long.valueOf(SysProperties.getOfficialAccount()), showList, "",
//		    				JSONObject.toJSONString(tempDetail));
//				}
//			}
//			
//			
		}
	}
}
