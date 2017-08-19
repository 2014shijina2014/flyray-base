package me.flyray.cms.dao;

import java.util.List;

import me.flyray.cms.model.Viewpoint;

public interface CmsViewPointMapper {
	public void deleteById(Long id);
	public void insert(Viewpoint point);
	public void updateById(Viewpoint point);
	public List<Viewpoint> queryAll(Viewpoint point);
	public Integer queryCountAll(Viewpoint point);
	public Viewpoint selectById(Long id);
}
