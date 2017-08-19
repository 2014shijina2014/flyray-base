package me.flyray.common.security;

import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Hex;


public class ThreeDes {
  /**
   *  3DES+BASE64加密
   *  to3DESAndBase64
   * @param sourceString
   * @param hex3DES
   * @return
   */
   public static String to3DESAndBase64(String sourceString, String hex3DES) {
       //返回加密后的结果
	   String strRTN = null;
       try {
    	    byte[] bytesString = sourceString.getBytes("UTF-8");
    	    byte[] bytesKey = Hex.decode(hex3DES);
    	    Security.addProvider(new BouncyCastleProvider());
    	    Cipher cEnc = Cipher.getInstance("DESede/CBC/PKCS7Padding", "BC");
    	    cEnc.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(bytesKey, "DESede"),
    	    new IvParameterSpec(Hex.decode("0102030405060708")));
    	    byte[] bytes3DES = cEnc.doFinal(bytesString);
    	    strRTN=Base64.encode(bytes3DES);
       }
       catch (Exception e) {
          System.out.println( "CommonAlgorithm.calculateRS(String sourceString,String hex3DES)" + e.getMessage());
          return strRTN;
       }
       return strRTN;
   }

   /**
    *  BASE64+3DES解密
    *  from3DESAndBase64
    * @param sourceString
    * @param hex3DES
    * @return
    */
   public static String from3DESAndBase64(String sourceString, String hex3DES) {
	   String strRTN = null;
	   try {
		   byte[] bytesString = Base64.decode(sourceString);
		   byte[] bytesKey = Hex.decode(hex3DES);
		   Security.addProvider(new BouncyCastleProvider());
		   Cipher cEnc = Cipher.getInstance("DESede/CBC/PKCS7Padding", "BC");
		   cEnc.init(Cipher.DECRYPT_MODE, new SecretKeySpec(bytesKey, "DESede"), 
				   new IvParameterSpec( Hex.decode("0102030405060708")));
		   byte[] bytes3DES = cEnc.doFinal(bytesString);
		   strRTN=new String(bytes3DES,"UTF-8");
	   } catch (Exception e) {
           System.out.println("CommonAlgorithm.calculateRS(String sourceString,String hex3DES)"+ e.getMessage());
	       return strRTN;
	   }
	   return strRTN;	   
}
 public static void main(String[] args)throws Exception {
	//汉字占三个字节
    //密码
	String keyStr="红老掌顽拨童清波";
	String keyEncode=HexStrFromToStr.encode(keyStr);
    System.out.println("原密码:"+keyStr+"==="+"16进制密码串："+keyEncode+"==还原字符串:"+HexStrFromToStr.decode(keyEncode));
    System.out.println(ThreeDes.to3DESAndBase64("测试adasdfa毛", keyEncode));
    String cryCode = ThreeDes.to3DESAndBase64("测试adasdfa毛", keyEncode);
    System.out.println(ThreeDes.from3DESAndBase64(cryCode,keyEncode));
   }
}
