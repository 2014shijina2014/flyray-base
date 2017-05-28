package me.flyray.cms.util;

import java.io.IOException;
import java.io.InputStream;

/**
 * 获取文件的Base64编码 
 * @author huoxiaoqiang
 */
public class Base64Util {

	
	
	
	
	
	public static byte[] toBase64(InputStream in){
	        byte[] data = null;  
	        //读取图片字节数组  
	        try   
	        {  
	            data = new byte[in.available()];  
	            in.read(data);  
	            in.close();  
	        }   
	        catch (IOException e)   
	        {  
	            e.printStackTrace();  
	        }  
	        return data;
	}
}
