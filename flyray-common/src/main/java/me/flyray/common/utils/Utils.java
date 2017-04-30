package me.flyray.common.utils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Time;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * 工具类
 * @author 
 *
 */
@Component
public class Utils {
	public static BigDecimal turnNullToZero(BigDecimal nullValue){
		return nullValue == null ? BigDecimal.ZERO : nullValue;
	}
	
	/**
	 * @author 
	 * @param nullValue
	 * @return
	 */
    public static BigInteger turnNullToZero(BigInteger nullValue){
    	return nullValue == null ? BigInteger.ZERO : nullValue;
    }
    
    public static  Integer turnNullToZero(Integer nullValue) {
		return  nullValue==null ? Integer.valueOf(0):nullValue;
	}
    
    /**
     * 格式化时间
     * @author 
     * @param time
     * @return
     */
    public static Time formatTime(Time time){
    	SimpleDateFormat sf=new SimpleDateFormat("HH:mm:ss");
    	try {
			time=new Time(sf.parse(sf.format(new Date(time.getTime()))).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	return time;
    }
    /**
     * 格式化日期
     * @author 
     * @param date
     * @return
     */
    public static Date formatDate(Date date){
    	SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
    	try {
			date=new Date(sf.parse(sf.format(date)).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	return date;
    }
    /**
     * 格式化日期
     * @author liming
     * @param String
     * @return
     */
    public static Date parseDate(String dateStr){
    	SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
    	Date date = null;
    	try {
			date=sf.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	return date;
    }
    /**
    * @Description: 格式化日期，date to string(HH:mm:ss)
    * @author wang.hai 
    * @return String
    * @throws
     */
    public static String formatTimeToString(Date date){
    	SimpleDateFormat sf=new SimpleDateFormat("HH:mm:ss");
    	return sf.format(date);
    }
    
    
    /**
     * @Description: 格式化日期，date to string
     * @author wang.hai 
     * @return String
     * @throws
      */
     public static String formatDateToString(Date date){
     	SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
     	return sf.format(date);
     }
    
     public static String addDayOfYear(Date date,int amt)
     {
    	 Calendar rightNow = Calendar.getInstance();
		 rightNow.setTime(date);
		 rightNow.add(Calendar.DAY_OF_YEAR, amt);
    	 Date dt1= rightNow.getTime();
    	 return formatDateToString(dt1);
     }
    
     /**
      * 时间比大小
      * @param t1
      * @param t2
      * @return 0:t1=t2; <0:t1<t2; >0:t1>t2;
      */
     public static int timeCompare(String t1,String t2){
         SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
         Calendar c1=Calendar.getInstance();
         Calendar c2=Calendar.getInstance();
         try {
             c1.setTime(formatter.parse(t1));
             c2.setTime(formatter.parse(t2));
         } catch (ParseException e) {
             e.printStackTrace();
         }
         /*eg.
          * i=r1.compareTo(r);//比较两个时间的先后r1是当前时间 r是你指定的时间
         if(i==0)System.out.println("ri=r");
         if(i<0)System.out.println("ri<r");
         if(i>0)System.out.println("ri>r");*/

         int result=c1.compareTo(c2);
         return result;
     }

    /**
    * @Description: 获取日期
    * @author wang.hai 
    * @date 2014-7-3下午7:14:33
    * @return Date
    * @throws
     */
    public static Date getSessionDate(){
    	return new Date();
    }
    
    /**
     * @Description: 检验验证码是否为纯数字
     * @author wu.zj 
     * @return boolean
     * @throws
      */
    public static boolean checkVerificationCode(String str){
    	String regex = "^[0-9]{6}$";
    	return Pattern.matches(regex, str);
    }
    
    /**
     * @Description: 格式化日期，date to string(HHmmss)
     * @author wang.hai 
     * @return String
     * @throws
     */
    public static String formatTimeToStringNoSign(Date date){
   	 SimpleDateFormat sf=new SimpleDateFormat("HHmmss");
   	 return sf.format(date);
    }
    
    
    /**
     * @Description: 格式化日期，date to string(yyyyMMdd)
     * @author wang.hai 
     * @return String
     * @throws
     */
    public static String formatDateToStringNoSign(Date date){
   	 SimpleDateFormat sf=new SimpleDateFormat("yyyyMMdd");
   	 return sf.format(date);
    }
    
    /**
     * 把分转成元
     * liming
     */
    public static String changeToYuan(String tradeAmount){
    	if(!StringUtils.hasText(tradeAmount)){
    		return "";
    	}
    	BigDecimal amt = new BigDecimal(tradeAmount);
	    BigDecimal divide = new BigDecimal(100);
	    DecimalFormat format = new DecimalFormat("0.00");
	    return format.format(amt.divide(divide));
    }
    
    /**
     * 
     * @param tradeAmount
     * @return
     */
    public static BigDecimal changeToYuanDecimal(String tradeAmount){
    	if(!StringUtils.hasText(tradeAmount)){
    		return new BigDecimal("0.00");
    	}
    	BigDecimal amt = new BigDecimal(tradeAmount);
	    BigDecimal divide = new BigDecimal(100);
	    return amt.divide(divide).setScale(2);
    }
    
    /**
     * 把元转成分
     * @param tradeAmount
     * @return
     */
    public static String changeToDivide(String tradeAmount){
    	if(!StringUtils.hasText(tradeAmount)){
    		return "";
    	}
        BigDecimal amt = new BigDecimal(tradeAmount);
        BigDecimal divide = new BigDecimal("100");
        return amt.multiply(divide).setScale(0).toString();
    }
    
    /**
     * 把元转成分
     * liming
     */
    public static BigInteger changeToCent(String tradeAmount){
    	if(!StringUtils.hasText(tradeAmount)){
    		return BigInteger.valueOf(0);
    	}
    	BigDecimal amt = new BigDecimal(tradeAmount);
	    BigDecimal divide = new BigDecimal(100);
	    return amt.multiply(divide).toBigInteger();
    }
    /**
     * 判断是否全部为中文，是则返回false，只要有一个不是中文就返回true
     * @param str
     * @return
     */
    public static boolean isChineseChar(String str){
        boolean temp = false;
        for(int i=0; i<str.length(); i++){
	        Pattern p=Pattern.compile("[\u4e00-\u9fa5]");
	        Matcher m=p.matcher(String.valueOf(str.charAt(i)));
	        if(m.find()){
	            temp =  false;
	        }else{
	        	temp = true;
	        	return temp;
	        }
        }
        return temp;
    }
    
    /**
     * 生成订单编号  6位日期+6位时间+4位随机数
     * @author Dzxing
     * @param time
     * @return
     */
    public static String generateOrderNo(){
    	return formatDateToStringNoSign(new Date()) + formatTimeToStringNoSign(new Date()) + ((int)(Math.random()*89999) + 10000);
    }
    
    
	/**
	 * 根据返回的参数创建一个map
	 * @param resStr http提交后返回的参数串
	 * @return
	 */
	public static Map<String, Object> getResponseMap(String resStr) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		String[] strArray = resStr.split("&");
		for(String s : strArray){
			String[] nameValue = s.split("=");
			if(nameValue.length == 1){
				resMap.put(nameValue[0], "");
			}else {
				resMap.put(nameValue[0], nameValue[1]);
			}
		}
		return resMap;
	}
	
	public static String formatDateToString14(Date date){
		SimpleDateFormat sf=new SimpleDateFormat("yyyyMMddHHmmss");
     	return sf.format(date);
    }
}
