package me.flyray.cms.service;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import me.flyray.cms.api.CmsViewFavortService;
import me.flyray.cms.dao.CmsViewFavortDao;
import me.flyray.cms.model.CmsViewFavort;

@Service("cmsViewFavortService")
public class CmsViewFavortServiceImpl implements CmsViewFavortService{
	@Autowired
	private CmsViewFavortDao dao;
	@Override
	public List<CmsViewFavort> queryObject(Long id) {
		// TODO Auto-generated method stub
		return dao.queryObject(id);
	}

	@Override
	public List<CmsViewFavort> queryList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.queryList(map);
	}

	@Override
	public List<CmsViewFavort> query(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.query(map);
	}

	@Override
	public Integer queryCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.queryCount(map);
	}

	@Override
	public Integer queryTotal() {
		// TODO Auto-generated method stub
		return dao.queryTotal();
	}

	@Override
	public void save(CmsViewFavort favort) {
		// TODO Auto-generated method stub
		dao.save(favort);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

	@Override
	public Map<String, Object> doFavort(Map<String, Object> param) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			String customerId = (String) param.get("customerId");
			String favortStatus = (String) param.get("favortStatus");
			String pointId = (String) param.get("pointId");
			List<CmsViewFavort> favortList = dao.query(param);
			CmsViewFavort favort = new CmsViewFavort();
			if (null != favortList && favortList.size() > 0){
				//说明已经点赞过--更新
				favort = favortList.get(0);
				favort.setUpdateTime(new Timestamp(System.currentTimeMillis()));
				favort.setFavortStatus(Integer.valueOf(favortStatus));
				dao.updateById(favort);
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
