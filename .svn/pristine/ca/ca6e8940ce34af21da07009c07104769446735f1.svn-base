package me.flyray.cms.service;

import me.flyray.cms.dao.PhotoFileDao;
import me.flyray.cms.model.PhotoFile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qiniu.util.StringUtils;

@Service("viewService")
public class ViewServiceImpl {

	@Autowired
	private PhotoFileDao photoFileDao;
	
	public String view(String id){
		PhotoFile photoFile = photoFileDao.findById(id);
		if(photoFile == null){
			throw new RuntimeException("缩略图信息不存在");
		}
		String path = photoFile.getPath();
		//图片规格
		return path;
	}
	
}
