package me.flyray.rbac.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import com.google.common.collect.Lists;  

/** 
* @author: bolei
* @date：Sep 22, 2017 4:43:15 PM 
* @description：http请求客户端
*/

public class HttpClientUtil {

	public static String postRequestJson(String url,String sendJsonStr) {
		
		final int timeout = 30000;
		//创建HttpClient对象  
		CloseableHttpClient closeHttpClient = HttpClients.createDefault();  
		CloseableHttpResponse httpResponse = null;  
		//发送Post请求  
		HttpPost httpPost = new HttpPost("http://localhost:8080/MyWebxTest/getCityByProvinceEname.do");  
		//设置Post参数  
		List<NameValuePair> params = Lists.newArrayList();
		params.add(new BasicNameValuePair("cityEname", "henan"));  
		String line = null;  
		try {  
		    //转换参数并设置编码格式  
		    httpPost.setEntity(new UrlEncodedFormEntity(params,Consts.UTF_8));  
		    //执行Post请求 得到Response对象  
		    httpResponse = closeHttpClient.execute(httpPost);  
		    //httpResponse.getStatusLine() 响应头信息  
		    System.out.println(httpResponse.getStatusLine());  
		    //返回对象 向上造型  
		    HttpEntity httpEntity = httpResponse.getEntity();  
		    if(httpEntity != null){  
		        //响应输入流  
		        InputStream is = httpEntity.getContent();  
		        //转换为字符输入流  
		        BufferedReader br = new BufferedReader(new InputStreamReader(is,Consts.UTF_8));  
		        
		        while((line=br.readLine())!=null){  
		            System.out.println(line);  
		        }  
		        //关闭输入流  
		        is.close();  
		    }  
		} catch (Exception e) {  
		    e.printStackTrace();  
		}finally{
		    if(httpResponse != null){  
		        try {  
		            httpResponse.close();  
		        } catch (IOException e) {  
		            e.printStackTrace();  
		        }  
		    }  
		    if(closeHttpClient != null){  
		        try {  
		            closeHttpClient.close();  
		        } catch (IOException e) {  
		            e.printStackTrace();  
		        }  
		    }  
		}
		return line;
	} 

}
