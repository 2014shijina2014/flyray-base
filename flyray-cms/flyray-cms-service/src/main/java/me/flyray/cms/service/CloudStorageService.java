package me.flyray.cms.service;

import java.io.InputStream;
import java.util.Date;
import java.util.UUID;

import org.springframework.util.StringUtils;

import me.flyray.cms.util.DateUtils;


/** 
* @author: bolei
* @date：2017年4月2日 下午4:09:15 
* @description：云存储(支持七牛、阿里云、腾讯云、又拍云)
*/

public abstract class CloudStorageService {

	/** 云存储配置信息 */
    CloudStorageConfig config = new CloudStorageConfig();

    /**
     * 文件路径
     * @param prefix 前缀
     * @return 返回上传路径
     */
    public String getPath(String prefix) {
        //生成uuid
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        //文件路径
        String path = DateUtils.format(new Date(), "yyyyMMdd") + "/" + uuid;
        if(StringUtils.hasText(prefix)){
            path = prefix + "/" + path;
        }
        return path;
    }

    /**
     * 文件上传
     * @param data    文件字节数组
     * @param path    文件路径，包含文件名
     * @return        返回http地址
     */
    public abstract String upload(byte[] data, String path);

    /**
     * 文件上传
     * @param data    文件字节数组
     * @return        返回http地址
     */
    public abstract String upload(byte[] data);

    /**
     * 文件上传
     * @param inputStream   字节流
     * @param path          文件路径，包含文件名
     * @return              返回http地址
     */
    public abstract String upload(InputStream inputStream, String path);

    /**
     * 文件上传
     * @param inputStream  字节流
     * @return             返回http地址
     */
    public abstract String upload(InputStream inputStream);
}
