package me.flyray.common.security;

import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PrivateKeyCacheUtils {
    
    private final static Logger logger = LoggerFactory.getLogger(PrivateKeyCacheUtils.class);
    /**
     * 私钥缓存
     */
    public static ConcurrentHashMap<String, PrivateKey> privateKeys = new ConcurrentHashMap<String, PrivateKey>();
    /**
     * 公钥缓存
     */
    public static ConcurrentHashMap<String, PublicKey> publicKeys = new ConcurrentHashMap<String, PublicKey>();
    
    /**
     * 解密线程执行器
     */
    private static ThreadPoolExecutor decryptExecutor = new ThreadPoolExecutor(10, 50, 20, TimeUnit.MINUTES,new ArrayBlockingQueue<Runnable>(5));
    /**
     * 加密线程执行执行器
     */
    private static ThreadPoolExecutor encryptExecutor = new ThreadPoolExecutor(10, 50, 20, TimeUnit.MINUTES,new ArrayBlockingQueue<Runnable>(5));

    /**
     * 从密钥库中获取私钥
     * @param keyStorePath
     * @param alias
     * @param password
     * @return
     * @throws Exception
     */
    public static synchronized PrivateKey getPrivateKeyFromStore(String keyStorePath, String alias,String password) throws Exception{
        logger.debug("PrivateKeyCacheUtils:::get Private Key From Store!");
        KeyStore keyStore = BouncyCertificateUtils.getKeyStore(keyStorePath, password);
        PrivateKey privateKey = (PrivateKey) keyStore.getKey(alias,password.toCharArray());
        return privateKey;
    }
    
    /**
     * 从证书中获取公钥
     * @param certificatePath
     * @return
     * @throws Exception
     */
    public static synchronized PublicKey getPublicKeyFromCertificate(String certificatePath) throws Exception{
        logger.debug("PrivateKeyCacheUtils:::get public Key From Store!");
        Certificate certificate = BouncyCertificateUtils.getCertificate(certificatePath);
        PublicKey publicKey = certificate.getPublicKey();
        return publicKey;
    }
    
    /**
     * 获取公钥
     * @param certificatePath
     * @return
     * @throws Exception
     */
    public static PublicKey getPublicKey(String certificatePath)throws Exception {
        PublicKey publicKey = publicKeys.get(certificatePath);
        if(publicKey !=null){
            logger.debug("PrivateKeyCacheUtils:::get PrivateKey From Cache!");
            return publicKey;
        }else{
            publicKey = getPublicKeyFromCertificate(certificatePath);
            publicKeys.put(certificatePath, publicKey);
            return publicKey;
        }
    }
    
    /**
     * 获取私钥
     * @param keyStorePath
     * @param alias
     * @param password
     * @return
     * @throws Exception
     */
    public static PrivateKey getPrivateKey(String keyStorePath, String alias,String password) throws Exception{
        String key = keyStorePath + alias + password;
        PrivateKey privateKey = privateKeys.get(key);
        if(privateKey !=null){
            logger.debug("PrivateKeyCacheUtils:::get PrivateKey From Cache!");
            return privateKey;
        }else{
            privateKey = getPrivateKeyFromStore(keyStorePath, alias, password);
            privateKeys.put(key, privateKey);
            return privateKey;
        }
    }
    
    /**
     * 解密
     * @param encryptedData
     * @param keyStorePath
     * @param alias
     * @param password
     * @return
     * @throws Exception
     */
    public static byte[] decryptByPrivateKey(byte[] encryptedData,String keyStorePath, String alias, String password) throws Exception{
        logger.debug("PrivateKeyCacheUtils:::decryptByPrivateKey start ");
        DecryptTask decryptTask = new DecryptTask(keyStorePath, alias, password, encryptedData);
        Future<byte[]> result = decryptExecutor.submit(decryptTask);
        byte[] decryptData  = result.get(1, TimeUnit.MINUTES);
        logger.debug("PrivateKeyCacheUtils:::decryptByPrivateKey end ");
        return decryptData;
    }
    
    /**
     * 加密
     * @param data
     * @param certificatePath
     * @return
     * @throws Exception
     */
    public static byte[] encryptByPublicKey(byte[] data, String certificatePath) throws Exception{
        logger.debug("PrivateKeyCacheUtils:::encryptByPublicKey start ");
        EncryptTask encryptTask = new EncryptTask(certificatePath, data);
        Future<byte[]> result = encryptExecutor.submit(encryptTask);
        byte[] encryptData  = result.get(1, TimeUnit.MINUTES);
        logger.debug("PrivateKeyCacheUtils:::encryptByPublicKey end ");
        return encryptData;
    }
}
