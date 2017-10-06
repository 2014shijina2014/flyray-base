package me.flyray.cms.service;

import java.awt.peer.LightweightPeer;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.aspectj.internal.lang.annotation.ajcDeclareAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.flyray.cms.api.ViewFavortService;
import me.flyray.cms.dao.ViewFavortDao;
import me.flyray.cms.dao.ViewpointDao;
import me.flyray.cms.model.ViewFavort;
import me.flyray.cms.model.Viewpoint;
import me.flyray.common.service.AbstractBaseService;
import me.flyray.common.utils.SnowFlake;

@Service("viewFavortService")
public class ViewFavortServiceImpl extends AbstractBaseService<ViewFavort> implements ViewFavortService{
	@Autowired
	private ViewFavortDao dao;
	@Autowired
	private ViewpointDao pointDao;
	
	@Override
	public void delete(Long id) {
		dao.delete(id);
	}

	@Override
	public Map<String, Object> doFavort(Map<String, Object> param) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			Long customerId = (Long) param.get("customerId");
			Integer favortStatus = (Integer) param.get("favortStatus");
			Long pointId = (Long) param.get("pointId");
			//根据观点编号查询出观点，然后点赞数量+1
			Map<String, Object> pointMap = new HashMap<String, Object>();
			Viewpoint point = pointDao.selectById(pointId);
			Integer count = point.getFavortCount();
			count = count + 1;
			point.setFavortCount(count);
			pointDao.update(point);
			List<ViewFavort> favortList = dao.query(param);
			ViewFavort favort = new ViewFavort();
			if(favortStatus == 1){
				favort.setFavortStatus(2);
			}else if(favortStatus == 2){
				favort.setFavortStatus(1);
			}
			if (null != favortList && favortList.size() > 0){
				//说明已经点赞过--更新
				favort = favortList.get(0);
				favort.setUpdateTime(new Timestamp(System.currentTimeMillis()));
				dao.update(favort);
			} else {
				//没有点赞过--插入
				favort.setId(SnowFlake.getId());
				favort.setCreateBy(customerId);
				favort.setPointId(pointId);
				favort.setFavortStatus(Integer.valueOf(favortStatus));
				favort.setCreateTime(new Timestamp(System.currentTimeMillis()));
				favort.setUpdateTime(new Timestamp(System.currentTimeMillis()));
				dao.save(favort);
			}
			result.put("favort", favort);
			result.put("code", "00");
		} catch (Exception e) {
			e.printStackTrace();
			result.put("code", "01");
		}
		
		return result;
	}

}
