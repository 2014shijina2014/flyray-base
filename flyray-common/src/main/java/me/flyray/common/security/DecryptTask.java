package me.flyray.common.security;

import java.io.ByteArrayOutputStream;
import java.security.PrivateKey;
import java.security.Security;
import java.util.concurrent.Callable;

import javax.crypto.Cipher;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//解密Task
public class DecryptTask implements Callable<byte[]>{
    
    private final static Logger logger = LoggerFactory.getLogger(DecryptTask.class);
    
    private static final String ALGORITHOM = "RSA";
    /**
     * 最大文件解密块
     */
    private static final int MAX_DECRYPT_BLOCK = 256;
    
    private static final ThreadLocal<Cipher> localCipher = new ThreadLocal<Cipher>() {
        @Override
        protected Cipher initialValue() {
            try {
                Security.addProvider(new BouncyCastleProvider());
                Cipher cipher = Cipher.getInstance(ALGORITHOM, "BC");
                return cipher;
            } catch (Exception e) {
                // ugly but necessary
                throw new RuntimeException(e);
            }
        }
    };
    
    private String keyStorePath;
    private String alias;
    private String password;
    private byte[] encryptedData;
    
    public DecryptTask(String keyStorePath, String alias, String password, byte[] encryptedData) {
        super();
        this.keyStorePath = keyStorePath;
        this.alias = alias;
        this.password = password;
        this.encryptedData = encryptedData;
    }
    public String getKeyStorePath() {
        return keyStorePath;
    }
    public void setKeyStorePath(String keyStorePath) {
        this.keyStorePath = keyStorePath;
    }
    public String getAlias() {
        return alias;
    }
    public void setAlias(String alias) {
        this.alias = alias;
    }
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public byte[] call() throws Exception {
        //加载证书进行解密
        Cipher cipher = localCipher.get();
        logger.debug("DecryptTask cipher:{}",cipher);
        logger.debug("DecryptTask get getPrivateKey start");
        PrivateKey privateKey = PrivateKeyCacheUtils.getPrivateKey(keyStorePath, alias, password);
        logger.debug("DecryptTask get getPrivateKey end");
        logger.debug("DecryptTask get decryptData start");
        byte[] decryptData = decrypt(cipher,privateKey,encryptedData);
        logger.debug("DecryptTask get decryptData end");
        return decryptData;
    }
    
    private byte[] decrypt(Cipher cipher,PrivateKey privateKey,byte[] encryptedData) throws Exception{
        //初始化密钥
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
}
