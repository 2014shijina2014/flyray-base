package me.flyray.common.security;

/**
 *为json Web Token提供一个工具类，包括
 **A、jwt提取签名算法Key、
 **B、生成jwt签名算法Key文件、
 **C、验证jwt有效并提取有效载荷、
 **D、生成jwt、
 **E、解释jwt 头和载荷？？？
 * * @author goba
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.impl.crypto.MacProvider;
import java.io.*;
import java.security.Key;
import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class JwtUtil {
    
    private final static Logger logger = LoggerFactory.getLogger(JwtUtil.class);

	/** 
	 * 提取签名算法Key
	 * @param Strng jwtAlgKeyPath jwt签名算法文件所在的路径 
	 * @return java.security.Key Key实例 
	 * @throws Exception 
	 */
    
    public static Key getKey(String jwtAlgKeyPath)
            throws Exception {
        File file=new File(jwtAlgKeyPath);
        Key key=null;
        try {
          if(!file.exists()){
              key=MacProvider.generateKey(SignatureAlgorithm.HS512);
              ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(file));
              oo.writeObject(key);
              oo.close();
      		  logger.info("=jwt算法key路径和文件不存在，请检查！并自动生成！！！{}",jwtAlgKeyPath);
      		  logger.info("======恭喜jwt签名算法文件生成成功=请查看!!!=========:jwtAlgKeyPath:{} ",jwtAlgKeyPath);
              return key;
          }
          ObjectInputStream ois = null;
          ois = new ObjectInputStream(new FileInputStream(file));
          key= (Key) ois.readObject();
          ois.close();
          return key;
        } catch (Exception e) {
			logger.error("======读取键值异常==========errMsg:{} ",e);
			throw e;
        }
    }
	/** 
	 * 生成签名算法Key文件
	 * @param Strng jwtAlgKeyPath jwt签名算法文件所在的路径 
	 * @return boolean true 生成， false 产生异常 
	 * @throws Exception 
	 */
    
    public static boolean generateKey(String jwtAlgKeyPath)
            throws Exception {
        File file=new File(jwtAlgKeyPath);
        Key key=null;
        try {
	           if(!file.exists()){
	         	  key=MacProvider.generateKey(SignatureAlgorithm.HS512);
	              ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(file));
	              oo.writeObject(key);
	              oo.close();
				  logger.error("======恭喜jwt签名算法文件生成成功=请查看!!!=========:jwtAlgKeyPath:{} ",jwtAlgKeyPath);
	              return true;
	           }
	           else
	           {
					logger.error("======jwt签名算法文件已存在无须生成，请检查!==========:jwtAlgKeyPath:{} ",jwtAlgKeyPath);
		              return true;
	           }
	        } catch (Exception e) {
				logger.error("======jwt签名算法文件生成，请检查!!!==========:errCode:{} ",e);
				return false;
	        }
    }

	/** 
	 * 生成claim jwt
	 * @param  
	 * @return boolean true 生成， false 产生异常 
	 * @throws Exception 
	 */
  
    public static String  generateJwt(Key key,String jti,String issuer,String Subject,String audience,Date expires,Date issuedAt ,List<JwtClaimItems>jwtClaimItems )
    		throws ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, SignatureException, IllegalArgumentException {
    	//非顺序Map 
    	//Map<String, Object> claims = new HashMap<String, Object>();
    	//升序Map
    	TreeMap<String, Object> claims =new TreeMap<String, Object>();
    	JwtClaimItems jwtClaimItem=null;
	    for (int i=0;i<jwtClaimItems.size();i++){
	    	jwtClaimItem =(JwtClaimItems)jwtClaimItems.get(i);
	    	claims.put(jwtClaimItem.getTagKey(), jwtClaimItem.getThreeDesValue());
	    }
		SignatureAlgorithm signatureAlgorithm =SignatureAlgorithm.HS256;
		String jwtString = Jwts.builder()
		.setClaims(claims)
		.setId(jti)//版本1
		.setIssuer(issuer)//设置发行人
		.setSubject(Subject)//设置抽象主题
		.setAudience(audience)//设置角色
		.setExpiration(expires)//过期时间
		.setIssuedAt(issuedAt)//设置现在时间
		.signWith(signatureAlgorithm,key)
		.compact();
//		logger.info("=生成json web token:{}",jwtString);
	    return jwtString;
    }
	/** 
	 * 提取 claims 根据jwtString
	 * @param  
	 * @return boolean true 生成， false 产生异常 
	 * @throws Exception 
	 */
    
    public static Claims  getParserJwt(Key key,String jwtString)
    		throws ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, SignatureException, IllegalArgumentException {
    	Claims claims=Jwts.parser()
    			.setSigningKey(key)
    			.parseClaimsJws(jwtString.trim()).getBody();
//		logger.info("==getParserJwt提取jwt关键要素 jti Id:{} Issuer:{} Sub:{} Aud:{} Exp:{} NBF:{}！ ",
//				claims.getId(),
//				claims.getIssuer(),
//				claims.getSubject(),
//				claims.getAudience(),
//				claims.getExpiration(),
//				claims.getNotBefore());
		return claims;
   	
    }

    
	/**
	 * 计算失效时间，起点从当前系统时间计算，过多久失效
	 * @param minutes 失效分钟数
	 * @return Date
	 */
	public static Date getExpiryDate(int minutes) {
       // 根据当前日期，来得到到期日期
       Calendar calendar = Calendar.getInstance();
       calendar.setTime(new Date());
       calendar.add(Calendar.MINUTE, minutes);
       Date expireDate=calendar.getTime();
       return expireDate;
	}
	/**
	 * 计算失效时间，起点从设定的时间计算，过多久失效
	 * @param minutes 失效分钟数
	 * @return Date
	 */
	public static Date getExpiryDate(Date firstDate,int minutes) {
       // 根据当前日期，来得到到期日期
       Calendar calendar = Calendar.getInstance();
       calendar.setTime(firstDate);
       calendar.add(Calendar.MINUTE, minutes);
       Date expireDate=calendar.getTime();
       return expireDate;
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
	    //组织自定义载荷
	    List<JwtClaimItems> jwtClaimItems = new ArrayList<JwtClaimItems>();
	    JwtClaimItems jwtClaimItem =new JwtClaimItems();
	    jwtClaimItem.setTagKey("PL0"); //_userId
	    jwtClaimItem.setRealValue("liuzihuang");
	    jwtClaimItem.setThreeDesValue(
	    		ThreeDes.to3DESAndBase64(
	    		  jwtClaimItem.getRealValue(),
	    		  HexStrFromToStr.encode("床老前顽明童月光")
	    		  )
	    	);
	    jwtClaimItems.add(jwtClaimItem);
	    jwtClaimItem =new JwtClaimItems();
	    jwtClaimItem.setTagKey("PL1"); //_userName
	    jwtClaimItem.setRealValue("刘子煌");
	    jwtClaimItem.setThreeDesValue(
	    		ThreeDes.to3DESAndBase64(
	    		  jwtClaimItem.getRealValue(),
	    		  HexStrFromToStr.encode("床老前顽明童月光")
	    		  )
	    	);	    
	    jwtClaimItems.add(jwtClaimItem);
	    Key key=JwtUtil.getKey("E://tmp/SignatureAlgorithmKey.txt");
	    //int expireMins=30 * 24 * 60;// 30天的有效日期 分钟
	    int expireMins=24 * 60;// 分钟数

	    //生成 json web token
	    String jwtStr=JwtUtil.generateJwt(key, "BP00", "vivebest", "http channel json transfer", 
	    		"goba", JwtUtil.getExpiryDate(expireMins), new Date(), jwtClaimItems);
		logger.info("=生成json web token:{}",jwtStr);
	    //Thread.sleep(3000);
	    //解释json web token
	    Claims claims=JwtUtil.getParserJwt(key, jwtStr);
		logger.info("==提取jwt关键要素 jti Id:{} Issuer:{} Sub:{} Aud:{} Exp:{} NBF:{}\n PL0:{} PL1:{} PL2:{} PL3:{} PL4:{} OK！ ",
				claims.getId(),
				claims.getIssuer(),
				claims.getSubject(),
				claims.getAudience(),
				claims.getExpiration(),
				claims.getNotBefore(),
				claims.get("PL0"),
				claims.get("PL1"),
				claims.get("PL2"),
				claims.get("PL3"),
				claims.get("PL4"));
	   String PL0= (String)claims.get("PL0"); //_userId
	   if (PL0 != null) 
	  	   logger.info("==agKey:{} RealValue:{} ThreeDesValue:{}",
	  			 "PL0",ThreeDes.from3DESAndBase64(
		    	    		PL0,
				    		  HexStrFromToStr.encode("床老前顽明童月光")
				    		  ),PL0);
	   
	   String PL1= (String)claims.get("PL1"); //_userName
	    
	   if (PL1 != null) 
	  	   logger.info("==agKey:{} RealValue:{} ThreeDesValue:{}",
	  			 "PL1",ThreeDes.from3DESAndBase64(
		    	    		PL1,
				    		  HexStrFromToStr.encode("床老前顽明童月光")
				    		  ),PL1);
	}
}
