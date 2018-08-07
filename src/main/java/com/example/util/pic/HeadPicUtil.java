package com.example.util.pic; /**
 * 
 *//*

package com.example.util.pic;


import com.example.util.common.Enums;
import com.mysql.jdbc.StringUtils;

*/
/**
 * <desc></desc>
 * @author mupeng
 *//*

public class qHeadPicUtil {
	
	*/
/**
	 * 
	 * <desc>返回指定大小的头像地址</desc>
	 * @author mupeng
	 * @date 2017-6-30 下午3:02:26
	 * @param src
	 * @param size
	 * @return
	 * String
	 *//*

	public static String head(String src, int size) {
	    
	    if (src != null && src.contains("wx.qlogo.cn")) {
            return src;
        }
	    
		if(StringUtils.isNotNullOrNotBlank(src)){
			if(src.contains("http")){
				return src;
			}
			
			String pic = null;
			switch (size) {
			case Enu                                                                                                                                               ms.PHOTO_TYPE_HEAD:
				pic = Enums.QINIU_BUCKET_URL + src.trim() + "?imageView2/1/w/400/h/400";
				break;
			case Enums.PHOTO_TYPE_SMALL:
				pic = Enums.QINIU_BUCKET_URL + src.trim() + "?mageView2/1/w/440/h/440";
				break;
			case Enums.PHOTO_TYPE_BIG:
				pic = Enums.QINIU_BUCKET_URL + src.trim() + "?imageView2/0/h/600";
				break;
			default:
				pic = Enums.QINIU_BUCKET_URL + src.trim() + "?imageView2/0/h/600";
				break;
			}
			return pic;
		}
		return com.lanxiong.util.common.Enums.qiniuurl+ com.lanxiong.util.common.Enums.PHOTO_FEMALE+"?imageView2/1/w/400/h/400";
	}
	
	public static String headPic(String src) {
		if(MyStringUtils.isNotNullOrNotBlank(src)){
			if(src.contains("http")){
				return src;
			}
			String pic = Enums.QINIU_BUCKET_URL + src.trim() + "?imageView2/1/w/400/h/400";
			return pic;
		}
		return null;
	}
}
*/
