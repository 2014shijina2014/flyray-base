package me.flyray.erp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.flyray.common.service.AbstractBaseService;
import me.flyray.erp.api.PurchaseOrderService;
import me.flyray.erp.dao.PurchaseOrderDao;
import me.flyray.erp.model.PurchaseOrder;

/** 
* @author: bolei
* @date：2017年4月9日 上午12:24:02 
* @description：采购订单
*/

@Service("purchaseOrderService")
public class PurchaseOrderServiceImpl extends AbstractBaseService<PurchaseOrder> implements PurchaseOrderService{

	@Autowired
	private PurchaseOrderDao purchaseOrderDao;
}
