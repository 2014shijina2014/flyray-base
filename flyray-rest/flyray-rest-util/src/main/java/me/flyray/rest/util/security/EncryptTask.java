package me.flyray.rest.util.security;

import java.io.ByteArrayOutputStream;
import java.security.PublicKey;
import java.util.concurrent.Callable;

import javax.crypto.Cipher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//加密Task
public class EncryptTask implements Callable<byte[]>{
    
    private final static Logger logger = LoggerFactory.getLogger(EncryptTask.class);
    /**
     * 最大加密块
     */
    private static final int MAX_ENCRYPT_BLOCK = 245;
    
    private static final ThreadLocal<Cipher> localCipher = new ThreadLocal<Cipher>() {
        @Override
        protected Cipher initialValue() {
            try {
                Cipher cipher = Cipher.getInstance("RSA/ECB/NoPadding");
                return cipher;
            } catch (Exception e) {
                // ugly but necessary
                throw new RuntimeException(e);
            }
        }
    };
    
    private String certificatePath;
    private byte[] data;
    
    public EncryptTask(String certificatePath, byte[] data) {
        super();
        this.certificatePath = certificatePath;
        this.data = data;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public String getCertificatePath() {
        return certificatePath;
    }

    public void setCertificatePath(String certificatePath) {
        this.certificatePath = certificatePath;
    }

    public byte[] call() throws Exception {
        //加载证书进行加密
        Cipher cipher = localCipher.get();
        logger.debug("EncryptTask cipher:{}",cipher);
        logger.debug("EncryptTask get getPublicKey start");
        PublicKey publicKey = PrivateKeyCacheUtils.getPublicKey(certificatePath);
        logger.debug("EncryptTask get getPublicKey end");
        logger.debug("EncryptTask get encrypt start");
        byte[] decryptData = encrypt(cipher,publicKey,data);
        logger.debug("EncryptTask get encrypt end");
        return decryptData;
    }
    
    private byte[] encrypt(Cipher cipher,PublicKey publicKey,byte[] data) throws Exception{
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
}
