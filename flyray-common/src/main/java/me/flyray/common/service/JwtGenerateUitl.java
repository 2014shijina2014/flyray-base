package me.flyray.common.service;

import java.security.Key;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import me.flyray.common.config.Constants;
import me.flyray.common.security.JwtClaimItems;
import me.flyray.common.security.JwtUtil;

/** 
* @author: bolei
* @date：Jun 25, 2017 3:22:26 PM 
* @description：Jwt生成器
*/

public class JwtGenerateUitl {
	
	/**
	 * 
	 * @param param
	 * 生成jwt
	 */
	public static String genarateJwt(Map<String, Object> param){
		
		String[] jwtPayLoadArr = new String[0];
		jwtPayLoadArr="PL0".split(",");
		List<JwtClaimItems> jwtClaimItems = new ArrayList<JwtClaimItems>();
		JwtClaimItems jwtClaimItem =new JwtClaimItems();
		jwtClaimItem.setTagKey(jwtPayLoadArr[0]);
		jwtClaimItem.setRealValue((String)param.get("userName"));
		Key key=null;
		try {
	        key=JwtUtil.getKey(Constants.jwtKey+"SignatureAlgorithmKey.dat");
        } catch (Exception e) {
        }
		String jwtStr=null;
	    try {
		    jwtStr=JwtUtil.generateJwt(key, "BP00", "vivebest", "http channel json transfer", 
		    		"goba", JwtUtil.getExpiryDate(2), new Date(), jwtClaimItems);
	    }
	    catch (Exception e){
	    }
	    return jwtStr;
	}
	
	public static Map<String, Object> parserJwt(String jwt){
		return null;
	}
	
}
