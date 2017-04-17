package me.flyray.erp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.flyray.common.service.AbstractBaseService;
import me.flyray.erp.api.ProductService;
import me.flyray.erp.dao.ProductDao;
import me.flyray.erp.model.Product;

/** 
* @author: bolei
* @date：2017年4月9日 上午12:23:15 
* @description：商品 
*/

@Service("goodsService")
public class ProductServiceImpl extends AbstractBaseService<Product> implements ProductService{

	@Autowired
	private ProductDao productDao;
}
