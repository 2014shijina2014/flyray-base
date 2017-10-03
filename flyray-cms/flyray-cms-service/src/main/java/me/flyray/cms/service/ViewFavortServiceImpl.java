package me.flyray.cms.service;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.flyray.cms.api.ViewFavortService;
import me.flyray.cms.dao.ViewFavortDao;
import me.flyray.cms.model.ViewFavort;
import me.flyray.common.service.AbstractBaseService;

@Service("viewFavortService")
public class ViewFavortServiceImpl extends AbstractBaseService<ViewFavort> implements ViewFavortService{
	@Autowired
	private ViewFavortDao dao;

	@Override
	public void delete(Long id) {
		dao.delete(id);
	}

	@Override
	public Map<String, Object> doFavort(Map<String, Object> param) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			String customerId = (String) param.get("customerId");
			String favortStatus = (String) param.get("favortStatus");
			String pointId = (String) param.get("pointId");
			List<ViewFavort> favortList = dao.query(param);
			ViewFavort favort = new ViewFavort();
			if (null != favortList && favortList.size() > 0){
				//说明已经点赞过--更新
				favort = favortList.get(0);
				favort.setUpdateTime(new Timestamp(System.currentTimeMillis()));
				favort.setFavortStatus(Integer.valueOf(favortStatus));
				dao.update(favort);
			} else {
				//没有点赞过--插入
				favort.setCustomerId(Long.valueOf(customerId));
				favort.setCustomerId(Long.valueOf(pointId));
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
