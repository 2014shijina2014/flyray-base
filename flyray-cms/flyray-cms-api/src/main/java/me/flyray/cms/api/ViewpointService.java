package me.flyray.cms.api;

import java.util.List;

import me.flyray.cms.model.Viewpoint;

public interface ViewpointService {
	public void deleteById(Long id);
	public void insert(Viewpoint point);
	public void updateById(Viewpoint point);
	public List<Viewpoint> queryAll(Viewpoint point);
	public Integer queryCountAll(Viewpoint point);
	public Viewpoint selectById(Long id);
}
