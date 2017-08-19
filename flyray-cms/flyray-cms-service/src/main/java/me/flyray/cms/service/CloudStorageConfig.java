package me.flyray.cms.service;

import java.io.Serializable;

/**
 * 云存储配置信息
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-03-25 16:12
 */
public class CloudStorageConfig implements Serializable {
    private static final long serialVersionUID = 1L;

    //类型 1：七牛  2：阿里云  3：腾讯云
    private Integer type;

   
    //七牛绑定的域名
    private String qiniuDomain = "http://7xqb1u.com1.z0.glb.clouddn.com";
    //七牛路径前缀
    private String qiniuPrefix = "";
    //七牛ACCESS_KEY
    private String qiniuAccessKey = "VWVtz0J12wmueOrWF-12T53cDnsvLua4bh8ll2ft";
    //七牛SECRET_KEY
    private String qiniuSecretKey = "G5nFIxxhbIkeyXnqy1JDfDRL-kiDTHD6vIsfEbHZ";
    //七牛存储空间名
    private String qiniuBucketName = "blxd";
    
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getQiniuDomain() {
		return qiniuDomain;
	}
	public void setQiniuDomain(String qiniuDomain) {
		this.qiniuDomain = qiniuDomain;
	}
	public String getQiniuPrefix() {
		return qiniuPrefix;
	}
	public void setQiniuPrefix(String qiniuPrefix) {
		this.qiniuPrefix = qiniuPrefix;
	}
	public String getQiniuAccessKey() {
		return qiniuAccessKey;
	}
	public void setQiniuAccessKey(String qiniuAccessKey) {
		this.qiniuAccessKey = qiniuAccessKey;
	}
	public String getQiniuSecretKey() {
		return qiniuSecretKey;
	}
	public void setQiniuSecretKey(String qiniuSecretKey) {
		this.qiniuSecretKey = qiniuSecretKey;
	}
	public String getQiniuBucketName() {
		return qiniuBucketName;
	}
	public void setQiniuBucketName(String qiniuBucketName) {
		this.qiniuBucketName = qiniuBucketName;
	}

}
