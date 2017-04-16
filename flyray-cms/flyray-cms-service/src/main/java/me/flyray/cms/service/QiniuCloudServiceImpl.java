package me.flyray.cms.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;

import me.flyray.cms.dao.PhotoFileDao;
import me.flyray.cms.model.PhotoFile;
import me.flyray.cms.util.RRException;

/** 
* @author: bolei
* @date：2017年4月2日 下午4:05:38 
* @description：七牛云存储
*/

@Service("qiniuCloudServiceImpl")
public class QiniuCloudServiceImpl extends CloudStorageService {

	private static final Logger logger = LoggerFactory.getLogger(QiniuCloudServiceImpl.class);
	
	@Autowired
	public PhotoFileDao photoFileDao;
	
	public QiniuCloudServiceImpl(){
		
	}
	
	private UploadManager uploadManager;
    private String token;

    public QiniuCloudServiceImpl(CloudStorageConfig config){
        this.config = config;
        //初始化
        init();
    }

    private void init(){
        uploadManager = new UploadManager(new Configuration(Zone.autoZone()));
        token = Auth.create(config.getQiniuAccessKey(), config.getQiniuSecretKey()).
                uploadToken(config.getQiniuBucketName());
    }

    @Override
    public String upload(byte[] data, String path) {
    	this.init();
        try {
            Response res = uploadManager.put(data, path, token);
            if (!res.isOK()) {
                throw new RuntimeException("上传七牛出错：" + res.toString());
            }
        } catch (Exception e) {
            throw new RRException("上传文件失败，请核对七牛配置信息", e);
        }
        //文件上传完毕之后，将文件信息存入数据库
        String filePath = config.getQiniuDomain() + "/" + path;
        PhotoFile photoFile = new PhotoFile();
        photoFile.setAddDate(new Date());
        photoFile.setFileName(path);
        photoFile.setPath(filePath);
        photoFileDao.insert(photoFile);
        return Integer.valueOf(photoFile.getId()).toString();
    }

    @Override
    public String upload(InputStream inputStream, String path) {
        try {
            byte[] data = IOUtils.toByteArray(inputStream);
            return this.upload(data, path);
        } catch (IOException e) {
            throw new RRException("上传文件失败", e);
        }
    }

    @Override
    public String upload(byte[] data) {
        return upload(data, getPath(config.getQiniuPrefix()));
    }

    @Override
    public String upload(InputStream inputStream) {
        return upload(inputStream, getPath(config.getQiniuPrefix()));
    }

}
