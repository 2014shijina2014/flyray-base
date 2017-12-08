package me.flyray.rest.util.security;

 import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

import javax.crypto.Cipher;
 
 /**
  * <p>
  * 数字签名/加密解密工具包
  * </p>
  * 
  * @author goba
  * @date 2012-4-26
  * @version 1.0
  */
 public class CertificateUtils {
 
     /**
      * Java密钥库(Java 密钥库，JKS)KEY_STORE PKCS12
      */
//     public static final String KEY_STORE = "JKS";
     public static final String KEY_STORE = "PKCS12";
 
     public static final String X509 = "X.509";
     
     /**
      * 文件读取缓冲区大小
      */
     private static final int CACHE_SIZE = 2048;
     
     /**
      * 最大文件加密块
      */
     private static final int MAX_ENCRYPT_BLOCK = 117;
     
     /**
      * 最大文件解密块
      */
     private static final int MAX_DECRYPT_BLOCK = 128;
 
     /**
      * <p>
      * 根据密钥库获得私钥
      * </p>
      * 
      * @param keyStorePath 密钥库存储路径
      * @param alias 密钥库别名
      * @param password 密钥库密码
      * @return
      * @throws Exception
      */
     public  static PrivateKey getPrivateKey(String keyStorePath, String alias, String password) 
             throws Exception {
         KeyStore keyStore = getKeyStore(keyStorePath, password);
         PrivateKey privateKey = (PrivateKey) keyStore.getKey(alias, password.toCharArray());
         return privateKey;
     }
     
     /**
      * <p>
      * 获得密钥库
      * </p>
      * 
      * @param keyStorePath 密钥库存储路径
      * @param password 密钥库密码
      * @return
      * @throws Exception
      */
     public  static KeyStore getKeyStore(String keyStorePath, String password)
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
      * @param certificatePath 证书存储路径
      * @return
      * @throws Exception
      */
     public  static PublicKey getPublicKey(String certificatePath) throws Exception {
         Certificate certificate = getCertificate(certificatePath);
         PublicKey publicKey = certificate.getPublicKey();
         return publicKey;
     }
 
     /**
      * <p>
      * 获得证书
      * </p>
      * 
      * @param certificatePath 证书存储路径
      * @return
      * @throws Exception
      */
     private  static Certificate getCertificate(String certificatePath) throws Exception {
         CertificateFactory certificateFactory = CertificateFactory.getInstance(X509);
         FileInputStream in = new FileInputStream(certificatePath);
         Certificate certificate = certificateFactory.generateCertificate(in);
         in.close();
         return certificate;
     }
 
     /**
      * <p>
      * 根据密钥库获得证书
      * </p>
      * 
      * @param keyStorePath 密钥库存储路径
      * @param alias 密钥库别名
      * @param password 密钥库密码
      * @return
      * @throws Exception
      */
     private  static Certificate getCertificate(String keyStorePath, String alias, String password) throws Exception {
         KeyStore keyStore = getKeyStore(keyStorePath, password);
         Certificate certificate = keyStore.getCertificate(alias);
         return certificate;
     }
 
     /**
      * <p>
      * 私钥加密
      * </p>
      * 
      * @param data 源数据
      * @param keyStorePath 密钥库存储路径
      * @param alias 密钥库别名
      * @param password 密钥库密码
      * @return
      * @throws Exception
      */
     public  static byte[] encryptByPrivateKey(byte[] data, String keyStorePath, String alias, String password) 
             throws Exception {
         // 取得私钥
         PrivateKey privateKey = getPrivateKey(keyStorePath, alias, password);
         Cipher cipher = Cipher.getInstance(privateKey.getAlgorithm());
         cipher.init(Cipher.ENCRYPT_MODE, privateKey);
         int inputLen = data.length;
         ByteArrayOutputStream out = new ByteArrayOutputStream();
         int offSet = 0;
         byte[] cache;
         int i = 0;
         // 对数据分段加密
         while (inputLen - offSet > 0) {
             if (inputLen - offSet > MAX_ENCRYPT_BLOCK) {
                 cache = cipher.doFinal(data, offSet, MAX_ENCRYPT_BLOCK);
             } else {
                 cache = cipher.doFinal(data, offSet, inputLen - offSet);
             }
             out.write(cache, 0, cache.length);
             i++;
             offSet = i * MAX_ENCRYPT_BLOCK;
         }
         byte[] encryptedData = out.toByteArray();
         out.close();
         return encryptedData;
     }
     
     /**
      * <p>
      * 文件加密
      * </p>
      * 
      * @param srcFilePath 源文件
      * @param destFilePath 加密后文件
      * @param keyStorePath 密钥库存储路径
      * @param alias 密钥库别名
      * @param password 密钥库密码
      * @throws Exception
      */
     public  static void encryptFileByPrivateKey(String srcFilePath, String destFilePath, String keyStorePath, String alias, String password)
             throws Exception {
         // 取得私钥
         PrivateKey privateKey = getPrivateKey(keyStorePath, alias, password);
         Cipher cipher = Cipher.getInstance(privateKey.getAlgorithm());
         cipher.init(Cipher.ENCRYPT_MODE, privateKey);
         File srcFile = new File(srcFilePath);
         FileInputStream in = new FileInputStream(srcFile);
         File destFile = new File(destFilePath);
         if (!destFile.getParentFile().exists()) {
             destFile.getParentFile().mkdirs();
         }
         destFile.createNewFile();
         OutputStream out = new FileOutputStream(destFile);   
         byte[] data = new byte[MAX_ENCRYPT_BLOCK];
         byte[] encryptedData;    // 加密块
         while (in.read(data) != -1) {
             encryptedData = cipher.doFinal(data);
             out.write(encryptedData, 0, encryptedData.length);
             out.flush();
         }
         out.close();
         in.close();
     }
 
     
     /**
      * <p>
      * 私钥解密
      * </p>
      * 
      * @param encryptedData 已加密数据
      * @param keyStorePath 密钥库存储路径
      * @param alias 密钥库别名
      * @param password 密钥库密码
      * @return
      * @throws Exception
      */
     public  static byte[] decryptByPrivateKey(byte[] encryptedData, String keyStorePath, String alias, String password) 
             throws Exception {
         // 取得私钥
         PrivateKey privateKey = getPrivateKey(keyStorePath, alias, password);
         Cipher cipher = Cipher.getInstance(privateKey.getAlgorithm());
         cipher.init(Cipher.DECRYPT_MODE, privateKey);
         // 解密byte数组最大长度限制: 128
         int inputLen = encryptedData.length;
         ByteArrayOutputStream out = new ByteArrayOutputStream();
         int offSet = 0;
         byte[] cache;
         int i = 0;
         // 对数据分段解密
         while (inputLen - offSet > 0) {
             if (inputLen - offSet > MAX_DECRYPT_BLOCK) {
                 cache = cipher.doFinal(encryptedData, offSet, MAX_DECRYPT_BLOCK);
             } else {
                 cache = cipher.doFinal(encryptedData, offSet, inputLen - offSet);
             }
             out.write(cache, 0, cache.length);
             i++;
             offSet = i * MAX_DECRYPT_BLOCK;
         }
         byte[] decryptedData = out.toByteArray();
         out.close();
         return decryptedData;
     }
 
     /**
      * <p>
      * 公钥加密
      * </p>
      * 
      * @param data 源数据
      * @param certificatePath 证书存储路径
      * @return
      * @throws Exception
      */
     public  static byte[] encryptByPublicKey(byte[] data, String certificatePath)
             throws Exception {
         // 取得公钥
         PublicKey publicKey = getPublicKey(certificatePath);
         Cipher cipher = Cipher.getInstance(publicKey.getAlgorithm());
         cipher.init(Cipher.ENCRYPT_MODE, publicKey);
         int inputLen = data.length;
         ByteArrayOutputStream out = new ByteArrayOutputStream();
         int offSet = 0;
         byte[] cache;
         int i = 0;
         // 对数据分段加密
         while (inputLen - offSet > 0) {
             if (inputLen - offSet > MAX_ENCRYPT_BLOCK) {
                 cache = cipher.doFinal(data, offSet, MAX_ENCRYPT_BLOCK);
             } else {
                 cache = cipher.doFinal(data, offSet, inputLen - offSet);
             }
             out.write(cache, 0, cache.length);
             i++;
             offSet = i * MAX_ENCRYPT_BLOCK;
         }
         byte[] encryptedData = out.toByteArray();
         out.close();
         return encryptedData;
     }
 
     /**
      * <p>
      * 公钥解密
      * </p>
      * 
      * @param encryptedData 已加密数据
      * @param certificatePath 证书存储路径
      * @return
      * @throws Exception
      */
     public  static byte[] decryptByPublicKey(byte[] encryptedData, String certificatePath)
             throws Exception {
         PublicKey publicKey = getPublicKey(certificatePath);
         Cipher cipher = Cipher.getInstance(publicKey.getAlgorithm());
         cipher.init(Cipher.DECRYPT_MODE, publicKey);
         int inputLen = encryptedData.length;
         ByteArrayOutputStream out = new ByteArrayOutputStream();
         int offSet = 0;
         byte[] cache;
         int i = 0;
         // 对数据分段解密
         while (inputLen - offSet > 0) {
             if (inputLen - offSet > MAX_DECRYPT_BLOCK) {
                 cache = cipher.doFinal(encryptedData, offSet, MAX_DECRYPT_BLOCK);
             } else {
                 cache = cipher.doFinal(encryptedData, offSet, inputLen - offSet);
             }
             out.write(cache, 0, cache.length);
             i++;
             offSet = i * MAX_DECRYPT_BLOCK;
         }
         byte[] decryptedData = out.toByteArray();
         out.close();
         return decryptedData;
     }
     
     /**
      * <p>
      * 文件解密
      * </p>
      * 
      * @param srcFilePath 源文件
      * @param destFilePath 目标文件
      * @param certificatePath 证书存储路径
      * @throws Exception
      */
     public  static void decryptFileByPublicKey(String srcFilePath, String destFilePath, String certificatePath)
             throws Exception {
         PublicKey publicKey = getPublicKey(certificatePath);
         Cipher cipher = Cipher.getInstance(publicKey.getAlgorithm());
         cipher.init(Cipher.DECRYPT_MODE, publicKey);
         File srcFile = new File(srcFilePath);
         FileInputStream in = new FileInputStream(srcFile);
         File destFile = new File(destFilePath);
         if (!destFile.getParentFile().exists()) {
             destFile.getParentFile().mkdirs();
         }
         destFile.createNewFile();
         OutputStream out = new FileOutputStream(destFile);   
         byte[] data = new byte[MAX_DECRYPT_BLOCK];
         byte[] decryptedData;    // 解密块
         while (in.read(data) != -1) {
             decryptedData = cipher.doFinal(data);
             out.write(decryptedData, 0, decryptedData.length); 
             out.flush();
         }
         out.close();
         in.close();
     }
     
     /**
      * <p>
      * 生成数据签名
      * </p>
      * 
      * @param data 源数据
      * @param keyStorePath 密钥库存储路径
      * @param alias 密钥库别名
      * @param password 密钥库密码
      * @return
      * @throws Exception
      */
     public  static byte[] sign(byte[] data, String keyStorePath, String alias, String password) 
             throws Exception {
         // 获得证书
//         X509Certificate x509Certificate = (X509Certificate) getCertificate(keyStorePath, alias, password);
         // 取得私钥
         PrivateKey privateKey = PrivateKeyCacheUtils.getPrivateKey(keyStorePath, alias, password);
         // 构建签名
         Signature signature = Signature.getInstance("MD5WithRSA");
         signature.initSign(privateKey);
         signature.update(data);
         return signature.sign();
     }
     
     /**
      * <p>
      * 生成数据签名并以BASE64编码
      * </p>
      * 
      * @param data 源数据
      * @param keyStorePath 密钥库存储路径
      * @param alias 密钥库别名
      * @param password 密钥库密码
      * @return
      * @throws Exception
      */
     public  static String signToBase64(byte[] data, String keyStorePath, String alias, String password) 
             throws Exception {
         return Base64Utils.encode(sign(data, keyStorePath, alias, password));
     }
     
     /**
      * <p>
      * 生成文件数字签名
      * </p>
      * 
       * <p>
      * <b>注意：</b><br>
      * 生成签名时update的byte数组大小和验证签名时的大小应相同，否则验证无法通过
      * </p>
      * 
      * @param filePath
      * @param keyStorePath
      * @param alias
      * @param password
      * @return
      * @throws Exception
      */
     public static byte[] generateFileSign(String filePath, String keyStorePath, String alias, String password)
             throws Exception {
         byte[] sign = new byte[0];
         // 获得证书
         X509Certificate x509Certificate = (X509Certificate) getCertificate(keyStorePath, alias, password);
         // 获取私钥
         KeyStore keyStore = getKeyStore(keyStorePath, password);
         // 取得私钥
         PrivateKey privateKey = (PrivateKey) keyStore.getKey(alias, password.toCharArray());
         // 构建签名
         Signature signature = Signature.getInstance(x509Certificate.getSigAlgName());
         signature.initSign(privateKey);
         File file = new File(filePath);
         if (file.exists()) {
             FileInputStream in = new FileInputStream(file);
             byte[] cache = new byte[CACHE_SIZE];
             int nRead = 0;
             while ((nRead = in.read(cache)) != -1) {
                 signature.update(cache, 0, nRead);
             }
             in.close();
             sign = signature.sign();
          }
         return sign;
     }
     
     /**
      * <p>
      * 文件签名成BASE64编码字符串
      * </p>
      * 
      * @param filePath
      * @param keyStorePath
      * @param alias
      * @param password
      * @return
      * @throws Exception
      */
     public static String signFileToBase64(String filePath, String keyStorePath, String alias, String password)
             throws Exception {
         return Base64Utils.encode(generateFileSign(filePath, keyStorePath, alias, password));
     }
     
     /**
      * <p>
      * 验证签名
      * </p>
      * 
      * @param data 待验证数据
      * @param sign 数据签名[BASE64]
      * @param certificatePath 证书存储路径
      * @return
      * @throws Exception
      */
     public static boolean verifySign(byte[] data, String sign, String certificatePath) throws Exception {
         // 获得证书
         X509Certificate x509Certificate = (X509Certificate) getCertificate(certificatePath);
         // 获得公钥
         PublicKey publicKey = x509Certificate.getPublicKey();
         // 构建签名
         Signature signature = Signature.getInstance("MD5WithRSA");
         signature.initVerify(publicKey);
         signature.update(data);
         return signature.verify(Base64Utils.decode(sign));
     }
     
     /**
      * <p>
      * 校验文件签名
      * </p>
      * 
      * @param filePath
      * @param sign
      * @param certificatePath
      * @return
      * @throws Exception
      */
     public static boolean validateFileSign(String filePath, String sign, String certificatePath) 
             throws Exception {
         boolean result = false;
         // 获得证书
         X509Certificate x509Certificate = (X509Certificate) getCertificate(certificatePath);
         // 获得公钥
         PublicKey publicKey = x509Certificate.getPublicKey();
         // 构建签名
         Signature signature = Signature.getInstance(x509Certificate.getSigAlgName());
         signature.initVerify(publicKey);
         File file = new File(filePath);
         if (file.exists()) {
             byte[] decodedSign = Base64Utils.decode(sign);
             FileInputStream in = new FileInputStream(file);
             byte[] cache = new byte[CACHE_SIZE];
             int nRead = 0;
             while ((nRead = in.read(cache)) != -1) {
                 signature.update(cache, 0, nRead);
             }
             in.close();
             result = signature.verify(decodedSign);
          }
         return result;
     }
     
     /**
      * <p>
      * BASE64解码->签名校验
      * </p>
      * 
      * @param base64String BASE64编码字符串
      * @param sign 数据签名[BASE64]
      * @param certificatePath 证书存储路径
      * @return
      * @throws Exception
      */
     public static boolean verifyBase64Sign(String base64String, String sign, String certificatePath) 
             throws Exception {
         byte[] data = Base64Utils.decode(base64String);
         return verifySign(data, sign, certificatePath);
     }
     
     /**
      * <p>
      * BASE64解码->公钥解密-签名校验
      * </p>
      * 
      * 
      * @param base64String BASE64编码字符串
      * @param sign 数据签名[BASE64]
      * @param certificatePath 证书存储路径
      * @return
      * @throws Exception
      */
     public static boolean verifyBase64SignWithDecrypt(String base64String, String sign, String certificatePath) 
             throws Exception {
         byte[] encryptedData = Base64Utils.decode(base64String);
         byte[] data = decryptByPublicKey(encryptedData, certificatePath);
         return verifySign(data, sign, certificatePath);
     }

 }
