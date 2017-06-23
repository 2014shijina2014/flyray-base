package me.flyray.common.security;

import java.io.ByteArrayOutputStream;

/** 
 * @Package: 
 * @ClassName:HexStrFromToStr 
 * @Description:字符串与16进制字符串互转换,中文字符支持 
 * @author:goba 
 * @date:12 20, 2016 5:00:08 PM 
 */  
public class HexStrFromToStr {  
	private static String hexString = "0123456789ABCDEFabcdef";
	public static void main(String[] args) {
		//汉字占3个字节
	    String msg= "千山鸟飞绝老顽童";
//	    String msg= "千山鸟飞绝老万径人踪灭顽孤舟蓑笠翁童独钓寒江雪刘";
//        String msg= "abcdefABCDEFGH1234567890";
	        System.out.println(encode(msg));
	        System.out.println(decode(encode(msg)));
	    }
	 
	    public static String encode(String str) {
	        byte[] bytes = str.getBytes();
	        StringBuilder sb = new StringBuilder(bytes.length * 2);
	        //转换hex编码
	        for (byte b : bytes) {
	            sb.append(Integer.toHexString(b + 0x800).substring(1));
	        }
	        str = sb.toString();
	        return str;
	    }
	    //把hex编码转换为string
	    public static String decode(String bytes) {
	        bytes = bytes.toUpperCase();
	        ByteArrayOutputStream baos = new ByteArrayOutputStream(bytes.length() / 2);
	        // 将每2位16进制整数组装成一个字节
	        for (int i = 0; i < bytes.length(); i += 2)
	            baos.write((hexString.indexOf(bytes.charAt(i)) << 4 | hexString.indexOf(bytes.charAt(i + 1))));
	        return new String(baos.toByteArray());
	    }
} 