/**
 * 
 */
package com.example.util.random;

import java.util.Date;
import java.util.Random;

/**
 * 
 * <desc>随机密码、随机数，随机手机验证码</desc>
 * @author mupeng
 * @date 2017年12月4日 下午8:23:25
 */
public class RandomUtil {
	
	public static String getSMSCode(){
		int code = getRandNum(899,999);
		return String.valueOf(code);
	} 
	
	private static int getRandNum(int min, int max) {
	    int randNum = min + (int)(Math.random() * ((max - min) + 1));
	    return randNum;
	}
	
	public static long getRandNum(long min, long max) {
	    long randNum = min + (long)(Math.random() * ((max - min) + 1));
	    return randNum;
	}
	
	public static String getFileName(Integer userId){
		Date date = new Date();
		return userId.toString()+createPassWord(18)+date.getTime();
	}
	
    public static String createPassWord(int len){  
        int random = createRandomInt();  
        return createPassWord(random, len);  
    }  
      
    public static String createPassWord(int random,int len){  
        Random rd = new Random(random);  
        final int  maxNum = 62;  
        StringBuffer sb = new StringBuffer();  
        int rdGet;//取得随机数  
        char[] str = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',  
                'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',  
                'x', 'y', 'z', 'A','B','C','D','E','F','G','H','I','J','K',  
                'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',  
                'X', 'Y' ,'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };  
          
        int count=0;  
        while(count < len){  
            rdGet = Math.abs(rd.nextInt(maxNum));//生成的数最大为62-1  
            if (rdGet >= 0 && rdGet < str.length) {  
                sb.append(str[rdGet]);  
                count ++;  
            }  
        }  
        return sb.toString();  
    }  
      
    public static int createRandomInt(){  
        //得到0.0到1.0之间的数字，并扩大100000倍  
        double temp = Math.random()*100000;  
        //如果数据等于100000，则减少1  
        if(temp>=100000){  
            temp = 99999;  
        }  
        int tempint = (int)Math.ceil(temp);  
        return tempint;  
    }  
    
    public static String getFixLenthString(int strLength) {  
        
        Random rm = new Random();  
        // 获得随机数  
        double pross = (1 + rm.nextDouble()) * Math.pow(10, strLength);  
        // 将获得的获得随机数转化为字符串  
        String fixLenthString = String.valueOf(pross);  
      
        // 返回固定的长度的随机数  
        return fixLenthString.substring(1, strLength + 1);  
    }  
    
    public static Long getRandomWithSixLength(){
    	Random rand = new Random();
    	long randNum = rand.nextInt(899999)+100000;
    	
    	return randNum;
    }
      
    public static void main(String[] args){  
    	for(int i=0; i<100; i++)
    	System.out.println(getRandomWithSixLength());
    }  
}
