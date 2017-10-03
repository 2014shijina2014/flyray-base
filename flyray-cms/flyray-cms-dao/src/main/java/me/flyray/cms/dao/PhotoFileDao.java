package me.flyray.cms.dao;

import java.util.List;
import java.util.Map;

import me.flyray.cms.model.PhotoFile;
import me.flyray.common.dao.BaseDao;

/** 
* @author: bolei
* @date：2017年3月7日 下午8:42:10 
* @description：类说明 
*/

public interface PhotoFileDao extends BaseDao<PhotoFile>{

	public List<PhotoFile> query(Map<String,Object> map);
	
	public PhotoFile findById(String id);
	
	public int insert(PhotoFile photoFile);
	
}
