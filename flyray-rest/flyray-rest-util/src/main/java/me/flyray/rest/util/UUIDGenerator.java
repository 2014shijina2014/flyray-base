package me.flyray.rest.util;

import java.util.UUID;

/** 
* @author: bolei
* @date：Jun 14, 2017 7:11:06 AM 
* @description：生成32位uuid
*/

public class UUIDGenerator {
	public UUIDGenerator() {  
    }  
  
    public static String getUUID() {  
        UUID uuid = UUID.randomUUID();  
        String str = uuid.toString();  
        // 去掉"-"符号  
        String temp = str.substring(0, 8) + str.substring(9, 13) + str.substring(14, 18) + str.substring(19, 23) + str.substring(24);  
        return str+","+temp;  
    }  
    //获得指定数量的UUID  
    public static String[] getUUID(int number) {  
        if (number < 1) {  
            return null;  
        }  
        String[] ss = new String[number];  
        for (int i = 0; i < number; i++) {  
            ss[i] = getUUID();  
        }  
        return ss;  
    }  
  
    public static void main(String[] args) {  
        String[] ss = getUUID(10);  
        for (int i = 0; i < ss.length; i++) {  
            System.out.println("ss["+i+"]====="+ss[i]);  
        }  
    }  
}  
