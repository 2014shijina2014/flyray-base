package me.flyray.common.service;

import java.security.Key;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.jsonwebtoken.Claims;
import me.flyray.common.security.HexStrFromToStr;
import me.flyray.common.security.JwtClaimItems;
import me.flyray.common.security.JwtUtil;
import me.flyray.common.security.ThreeDes;

/** 
* @author: bolei
* @date：Jun 25, 2017 3:22:26 PM 
* @description：Jwt生成器
*/

public class JwtGenerateUitl {
	
	private final static Logger logger = LoggerFactory.getLogger(JwtUtil.class);
	
	/**
	 * 
	 * @param param 
	 * username
	 * password
	 * 生成jwt
	 */
	public static String genarateJwt(Map<String, Object> param){
		
		String[] jwtPayLoadArr = new String[0];
		jwtPayLoadArr="PL0,PL1".split(",");
		List<JwtClaimItems> jwtClaimItems = new ArrayList<JwtClaimItems>();
		if (jwtPayLoadArr.length >0){
			for (int i=0;i<jwtPayLoadArr.length;i++){
			    JwtClaimItems jwtClaimItem =new JwtClaimItems();
            	jwtClaimItem.setTagKey(jwtPayLoadArr[i]);
                if (jwtPayLoadArr[i].equals("PL0")){
                	jwtClaimItem.setRealValue((String)param.get("username"));
                }
                else if (jwtPayLoadArr[i].equals("PL1")){
                	jwtClaimItem.setRealValue((String)param.get("password"));
                }
              //加密
                jwtClaimItem.setThreeDesValue(
			    		ThreeDes.to3DESAndBase64(
			    		  jwtClaimItem.getRealValue(),
			    		  HexStrFromToStr.encode("雨田飞")
			    		  )
			    	);
			    jwtClaimItems.add(jwtClaimItem);
			}
		}
		Key key=null;
		try {
	        key=JwtUtil.getKey("/home/bolei/software/jwt/SignatureAlgorithmKey.txt");
        } catch (Exception e) {
        }
		String jwtStr=null;
	    try {
		    jwtStr=JwtUtil.generateJwt(key, "BP00", "flyray", "http channel json transfer", 
		    		"goba", JwtUtil.getExpiryDate(2), new Date(), jwtClaimItems);
	    }
	    catch (Exception e){
	    }
	    return jwtStr;
	}
	
	public static Map<String, Object> parserJwt(String jwt){
		Key key=null;
		Map<String, Object> resultMap = new HashMap<>();
		try {
			key = JwtUtil.getKey("/home/bolei/software/jwt/SignatureAlgorithmKey.txt");
			 Claims claims = JwtUtil.getParserJwt(key,jwt);
			 logger.info("==提取jwt关键要素 jti Id:{} Issuer:{} Sub:{} Aud:{} Exp:{} NBF:{}\n PL0:{} PL1:{} PL2:{} PL3:{} PL4:{} OK！ ",
						claims.getId(),claims.getIssuer(),claims.getSubject(),claims.getAudience(),
						claims.getExpiration(),claims.getNotBefore(),
						claims.get("PL0"),claims.get("PL1"),claims.get("PL2"),
						claims.get("PL3"),claims.get("PL4"));
			   String PL0= (String)claims.get("PL0"); //_userId
			   if (PL0 != null) 
			  	   logger.info("==agKey:{} RealValue:{} ThreeDesValue:{}","PL0",
			  			   ThreeDes.from3DESAndBase64(PL0, HexStrFromToStr.encode("雨田飞")),PL0);
			   resultMap.put("PL0", ThreeDes.from3DESAndBase64(PL0, HexStrFromToStr.encode("雨田飞")));
			   String PL1= (String)claims.get("PL1"); //_userName
			   if (PL1 != null)
			  	   logger.info("==agKey:{} RealValue:{} ThreeDesValue:{}", "PL1",
			  			   ThreeDes.from3DESAndBase64(PL1,HexStrFromToStr.encode("雨田飞")),PL1);
			   resultMap.put("PL1", ThreeDes.from3DESAndBase64(PL1, HexStrFromToStr.encode("雨田飞")));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resultMap;
	}
	
}
