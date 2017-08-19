package me.flyray.common.utils;

import java.util.UUID;

/** 
* @author: bolei
* @date：Jul 9, 2017 8:40:25 AM 
* @description：类描述
*/

public class UUIDTool {

	public UUIDTool() {  
    }  
    /**  
     * 自动生成32位的UUid，对应数据库的主键id进行插入用。  
     * @return  
     */  
    public static String getUUID() {  
        /*UUID uuid = UUID.randomUUID();  
        String str = uuid.toString();  */  
        // 去掉"-"符号  
        return UUID.randomUUID().toString().replace("-", "");  
    }  
  
  
    public static void main(String[] args) {  
//      String[] ss = getUUID(10);  
        for (int i = 0; i < 10; i++) {  
            System.out.println("ss[" + i + "]=====" + getUUID());  
        }  
    }  
}
