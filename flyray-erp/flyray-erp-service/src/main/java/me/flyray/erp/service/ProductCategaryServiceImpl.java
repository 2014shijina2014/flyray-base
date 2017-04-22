package me.flyray.erp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.flyray.common.service.AbstractBaseService;
import me.flyray.erp.api.ProductCategaryService;
import me.flyray.erp.dao.ProductCategaryDao;
import me.flyray.erp.model.ProductCategary;

/** 
* @author: bolei
* @date：2017年4月9日 上午12:22:35 
* @description：商品分类
*/

@Service("productCategaryService")
public class ProductCategaryServiceImpl extends AbstractBaseService<ProductCategary> implements ProductCategaryService{

	@Autowired
	private ProductCategaryDao productCategaryDao;
	
}
