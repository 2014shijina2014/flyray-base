package me.flyray.cms.service;

import java.awt.peer.LightweightPeer;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.aspectj.internal.lang.annotation.ajcDeclareAnnotation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	protected Logger logger = LoggerFactory.getLogger(getClass());
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
		logger.info("点赞或取消....start...{}", param);
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			Long customerId = (Long) param.get("customerId");
			Integer favortStatus = (Integer) param.get("favortStatus");
			String pointId = (String) param.get("pointId");
			//根据观点编号查询出观点，然后点赞数量+1
			Map<String, Object> pointMap = new HashMap<String, Object>();
			Viewpoint point = pointDao.selectById(Long.valueOf(pointId));
			
			List<ViewFavort> favortList = dao.query(param);
			ViewFavort favort = new ViewFavort();
			logger.info("点赞或取消....favortList.size...{}", favortList.size());
			logger.info("点赞或取消....favortStatus...{}", favortStatus);
			if (null != favortList && favortList.size() > 0){
				//说明已经点赞过--更新
				favort = favortList.get(0);
				if(favortStatus == 1){
					favort.setFavortStatus(2);
					Integer count = point.getFavortCount();
					count = count - 1;
					point.setFavortCount(count);
					pointDao.update(point);
				}else if(favortStatus == 2){
					favort.setFavortStatus(1);
					Integer count = point.getFavortCount();
					count = count + 1;
					point.setFavortCount(count);
					pointDao.update(point);
				}
				favort.setUpdateTime(new Timestamp(System.currentTimeMillis()));
				dao.update(favort);
			} else {
				//没有点赞过--插入
				favort.setId(SnowFlake.getId());
				if(favortStatus == 1){
					favort.setFavortStatus(2);
					Integer count = point.getFavortCount();
					count = count - 1;
					point.setFavortCount(count);
					pointDao.update(point);
				}else if(favortStatus == 2){
					favort.setFavortStatus(1);
					Integer count = point.getFavortCount();
					count = count + 1;
					point.setFavortCount(count);
					pointDao.update(point);
				}
				favort.setCreateBy(customerId);
				favort.setPointId(Long.valueOf(pointId));
				favort.setCreateTime(new Timestamp(System.currentTimeMillis()));
				favort.setUpdateTime(new Timestamp(System.currentTimeMillis()));
				dao.save(favort);
			}
			result.put("favort", favort);
			result.put("code", "00");
			logger.info("点赞或取消....result...{}", result);
		} catch (Exception e) {
			e.printStackTrace();
			result.put("code", "01");
		}
		
		return result;
	}

}
