package me.flyray.rest.util.security;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.KeyFactory;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

//import org.bouncycastle.jcajce.provider.asymmetric.rsa.BCRSAPublicKey;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Base64;
import org.bouncycastle.util.encoders.Hex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class BouncyCertificateUtils {
    
	private static final Logger logger = LoggerFactory.getLogger(BouncyCertificateUtils.class);
    public static final String KEY_STORE = "PKCS12";
    public static final String X509 = "X.509";
    /**
     * 最大文件加密块
     */
    private static final int MAX_ENCRYPT_BLOCK = 245;

    /**
     * 最大文件解密块
     */
    private static final int MAX_DECRYPT_BLOCK = 256;
    
    private static final String ALGORITHOM = "RSA";
    
    /**
     * <p>
     * 根据密钥库获得私钥
     * </p>
     * 
     * @param keyStorePath
     *            密钥库存储路径
     * @param alias
     *            密钥库别名
     * @param password
     *            密钥库密码
     * @return
     * @throws Exception
     */
    public static PrivateKey getPrivateKey(String keyStorePath, String alias,
            String password) throws Exception {
        return PrivateKeyCacheUtils.getPrivateKey(keyStorePath, alias, password);
    }
    
    /**
     * <p>
     * 获得密钥库
     * </p>
     * 
     * @param keyStorePath
     *            密钥库存储路径
     * @param password
     *            密钥库密码
     * @return
     * @throws Exception
     */
    public static KeyStore getKeyStore(String keyStorePath, String password)
            throws Exception {
        FileInputStream in = new FileInputStream(keyStorePath);
        KeyStore keyStore = KeyStore.getInstance(KEY_STORE);
        keyStore.load(in, password.toCharArray());
        in.close();
        return keyStore;
    }
    /**
     * <p>
     * 根据证书获得公钥
     * </p>
     * 
     * @param certificatePath
     *            证书存储路径
     * @return
     * @throws Exception
     */
    public static PublicKey getPublicKey(String certificatePath)
            throws Exception {
        Certificate certificate = getCertificate(certificatePath);
        PublicKey publicKey = certificate.getPublicKey();
        return publicKey;
    }

    /**
     * <p>
     * 获得证书
     * </p>
     * 
     * @param certificatePath
     *            证书存储路径
     * @return
     * @throws Exception
     */
    public static Certificate getCertificate(String certificatePath)
            throws Exception {
        CertificateFactory certificateFactory = CertificateFactory
                .getInstance(X509);
        FileInputStream in = new FileInputStream(certificatePath);
        Certificate certificate = certificateFactory.generateCertificate(in);
        in.close();
        return certificate;
    }
    /**
     * <p>
     * 公钥加密
     * </p>
     * 
     * @param data
     *            源数据
     * @param certificatePath
     *            证书存储路径
     * @return
     * @throws Exception
     */
    public static byte[] encryptByPublicKey(byte[] data, String certificatePath)
            throws Exception {
        // 取得公钥
        return PrivateKeyCacheUtils.encryptByPublicKey(data, certificatePath);
    }

    /**
     * 私钥解密
     * @param encryptedData
     * @param keyStorePath
     * @param alias
     * @param password
     * @return
     * @throws Exception
     */
    public static byte[] decryptByPrivateKey(byte[] encryptedData,String keyStorePath, String alias, String password)
            throws Exception {
        // 取得私钥
        return PrivateKeyCacheUtils.decryptByPrivateKey(encryptedData, keyStorePath, alias, password);
    }

    /**
     * 提取RSA合数模 n
     * @param publicKeyPath
     * @return
     * @throws Exception
     */
    public static String getModulus(String publicKeyPath)throws Exception{
    	X509EncodedKeySpec spec =new X509EncodedKeySpec(CertificateUtils.getPublicKey(publicKeyPath).getEncoded());
        KeyFactory kf = KeyFactory.getInstance("RSA");
        kf.generatePublic(spec);
        RSAPublicKey publicKey = (RSAPublicKey) kf.generatePublic(spec);
        String modulus=  publicKey.getModulus().toString(16);
        return modulus;
    }
    
    /**
     * 提取publicExponent 是RSA的公开幂e
     * @param publicKeyPath
     * @return String
     * @throws Exception
     */
    public static String getPublicExponent(String publicKeyPath)throws Exception{
    	X509EncodedKeySpec spec =new X509EncodedKeySpec(CertificateUtils.getPublicKey(publicKeyPath).getEncoded());
        KeyFactory kf = KeyFactory.getInstance("RSA");
        kf.generatePublic(spec);
        RSAPublicKey publicKey = (RSAPublicKey) kf.generatePublic(spec);
        String publicExponent=publicKey.getPublicExponent().toString(16);
        return publicExponent;
    }

    /**
     * 提取privateExponent 是RSA的私有幂d
     * @param keyStorePath
     * @param alias
     * @param password
     * @return String
     * @throws Exception
     */
	public static String  getPrivateExponent(String keyStorePath, String alias,
            String password) throws Exception{
		PrivateKey privateKey =getPrivateKey( keyStorePath,  alias, password);
		RSAPrivateKey rsaPrivateKey = (RSAPrivateKey) privateKey;
		String privateExponent=rsaPrivateKey.getPrivateExponent().toString();
		return privateExponent;
	}

	/**
     * RSA合数模 n 和publicExponent 是RSA的公开幂e 还原公钥
     * @param modulus
     * @param publicExponent
     * @return PublicKey
     * @throws Exception
     */
	public static PublicKey getReducePublicKey(String modulus, String	publicExponent)
	        throws NoSuchAlgorithmException, InvalidKeySpecException {
	    BigInteger bigIntModulus = new BigInteger(modulus);
	    BigInteger bigIntPrivateExponent = new BigInteger(publicExponent);
	    RSAPublicKeySpec keySpec = new RSAPublicKeySpec(bigIntModulus,bigIntPrivateExponent);
	    KeyFactory keyFactory = KeyFactory.getInstance("RSA");
	    PublicKey publicKey = keyFactory.generatePublic(keySpec);
	    return publicKey;
	}
	 
	/**
     * RSA合数模 n 和privateExponent 是RSA的私有幂d 还原私鈅
     * @param modulus
     * @param privateExponent
     * @return PrivateKey
     * @throws Exception
     */
	public static PrivateKey getReducePrivateKey(String modulus, String
	privateExponent)
	        throws NoSuchAlgorithmException, InvalidKeySpecException {
	    BigInteger bigIntModulus = new BigInteger(modulus);
	    BigInteger bigIntPrivateExponent = new BigInteger(privateExponent);
	    RSAPrivateKeySpec keySpec = new RSAPrivateKeySpec(bigIntModulus,bigIntPrivateExponent);
	    KeyFactory keyFactory = KeyFactory.getInstance("RSA");
	    PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
	    return privateKey;
	}    
	/**
     * 解密js加密后的值,最后用私钥解密
     * @param encryptedData
     * @param keyStorePath
     * @param alias
     * @param password
     * @return
     * @throws Exception
     */
    public static String  decryptJsValue(String jsEncValue,String keyStorePath, String alias, String password)
            throws Exception {
		byte[] input = Hex.decode(jsEncValue);
		byte[] raw = decryptByPrivateKey(input,keyStorePath,alias,password);

        //下面的这段文字有待验证
		
		// 标志位为0之后的是输入的有效字节
		int i = raw.length - 1;
		while (i > 0 && raw[i] != 0) {
			i--;
		}
		i++;
		byte[] data = new byte[raw.length - i];
		for (int j = i; j < raw.length; j++) {
			data[j - i] = raw[j];
		}

//		return new String(data, charSet);
        String decJsStr= new String(data,Charset.forName("utf-8"));
        return decJsStr;
	}
	
	/**
	 * js加密时使用的公钥字符串
	 * <p><b>注意：</b>
	 * 生成的密钥对的值与 种子（seedKey）、虚拟机实现等都有关系，不同的机器生成的密钥值可能不同。
	 * 在实际测试时发现，同样的环境，有些机器每次生成的密钥值也不同，比如每次重启服务器后值不同。
	 * 所以在实际生产环境中使用时，该值需要通过服务器端输出到客户端。
	 * 如果有多台服务器，可能每台服务器的值不同，所以需要有类似F5的策略，保证多次请求路由到一台服务器上。
	 * @throws Exception 
	 */
//	public static String getJsPublicKey(PublicKey publicKey) throws Exception{
//		    String jsPublicKey;
//		    try {
//		      BCRSAPublicKey jce = (BCRSAPublicKey) publicKey;
////		      JCERSAPublicKey jce = (JCERSAPublicKey) publicKey;
//			  jsPublicKey = jce.getModulus().toString(16);
//		    }
//		    catch (Exception e)
//		    {
//		    	logger.info("===调试信息:errCode:{}",e);
//		    	throw e;
//		    }
//		return jsPublicKey;
//	}
    
    public static void main(String[] args) throws Exception {
        String encryDate = new String(Base64.encode(encryptByPublicKey("62108902001".getBytes(),"D:/key/epay_public20160906.pfx")));
        System.out.println( encryDate);
//      System.out.println(getPrivateKey("D:/key/epay_private20160906.pfx", "payment gateway 2016", "WebAS"));
//      System.out.println(getKeyStore("D:/key/epay_private20160906.pfx", "WebAS").aliases().nextElement());
      //String cardDD="ZytLM6VwOCwfOlhI+G4Eq0KxvM7WxCueY4OCSn1M5Wwt+vOar5ezPEM8dH9fL6xG+8EDrN2U1VTc2WKkgMMobIdA9a65dcUZ24gmCVt7yJixPWTc1zhS0MNeIigNG+p0kMJKO6r14Xg8ut1LLHOGrxNRl3kalL1dOimxmEkPVn0xjvmAb6PRW6EMvgK4GcVROwhTv1Uy1DUiXs05O4NKLMJGYpNf3g0Tpj1NoGbUkT6XgO2wU+Dk3TLpzSl5VaEXGG0gjkDAL3/955CvM+vxt/h/41zR4JmT8g1pBK1NHk4uKOjQqdUf+wWWFSzHaUTuKJsY838hX2U+SnPfkY8n2g==";
      //String cardDD="mXDizkf4vhEJNE6PTcMoYbSBaPfmPBp08D0TFY+AiC2EIWMbDmI3JfRmuUsrNGms1cjUXP5Ub6HhHje9rIAtVTOL7jnvreBQsZQgJGEJ2cqB/SgU590MTH9ANjDpIH8YQ1VzZ91tODCFPx7mI4oJnO4P+4qIl4IVu3Gnf+GdgTHlF0301DrVXx0XSdlGj0D4RGctS9c46hBChpSeU9t5W15z9t5RNyqAEg8uoUG5jHSetVJGsOKF/ocR8WIoCUt2FCPBVnZm8Lm5zakEh5c+9/94pFpmU4p3JiFL+kbaIeaYUY2U+9bbzwbBIMuF07TGcpNjMqyORxfIj/CcBS/pVg==";
      //x2LrUabU5CINw5POXjpFWTXZYYwGmp1jA7+ltl9N9N0aytRStefz1pFO99pLv0Vxzm7t1D/8NsEEzJmJiCQ27tqimbO1SsRkcXxi0OpffNCbDYCYe67Ff0PUKlk2rJ1/cnkhPh4c/MT691HoYutR/qolpSq+5ZDG1tTs7W8MAVizpv+SqgH1kBWhMSLpcrdZXdxE/hK3KOghC4njW4GdVsLnWsMURhvNwiU7k9/8XmfXqNF+65PvqsOs6v71XpM8dHnQ47zZ2NHn8J0dMa3p2QnhsUBHzpCpIcdOPxsZ9fdFEPOQBhzHls6l1CKIqPjfj2ba+0Wlub86WQBbQerKCQ==
//      String cardDD="x2LrUabU5CINw5POXjpFWTXZYYwGmp1jA7+ltl9N9N0aytRStefz1pFO99pLv0Vxzm7t1D/8NsEEzJmJiCQ27tqimbO1SsRkcXxi0OpffNCbDYCYe67Ff0PUKlk2rJ1/cnkhPh4c/MT691HoYutR/qolpSq+5ZDG1tTs7W8MAVizpv+SqgH1kBWhMSLpcrdZXdxE/hK3KOghC4njW4GdVsLnWsMURhvNwiU7k9/8XmfXqNF+65PvqsOs6v71XpM8dHnQ47zZ2NHn8J0dMa3p2QnhsUBHzpCpIcdOPxsZ9fdFEPOQBhzHls6l1CKIqPjfj2ba+0Wlub86WQBbQerKCQ==";
      //String cardDD="O7LFc/JVeF0oEX/l9Pm6tXiwNhuoflHoYPVrWaYvypCvncsLj87hP/BGr9pVYuIPcyq2U6ul7ToN66TlMWd9E3RnB2WfogBat11Cs5dbY0AEqGBu9MW/Yo1U86/anXnNCs008Jpea7jfyx8ONRislS+WXTOw1cu3PW7NVAsG0SujNSGldOQhPm0NhsjDXLW4qThnsz6kIBDGZ5eWsOnAgbdlBEaZbwScGoqHO/uxo+OV/ZxI7Qf1yrxLTPm3wCLhqhunYZOrbghU4PzTGxde1x0kRODFEBs2wr0wRSx/g6NqCPKMkIzjxfJ1MvPY+NXyYQuOmRGTa0JwBc/wXddtUw==";
      System.out.println(new String(decryptByPrivateKey(Base64.decode(encryDate), "D:/key/epay_private20160906.pfx", "payment gateway 2016", "WebAS")));
      System.out.println(new String(decryptByPrivateKey(Base64.decode(encryDate), "D:/key/epay_private20160906.pfx", "payment gateway 2016", "WebAS")));
    }
}
