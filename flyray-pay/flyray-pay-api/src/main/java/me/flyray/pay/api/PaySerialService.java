package me.flyray.pay.api;

import me.flyray.common.service.BaseService;
import me.flyray.pay.model.PaySerial;

/** 
* @author: bolei
* @date：2017年3月18日 下午11:20:37 
* @description：支付流水
*/

public interface PaySerialService extends BaseService{

	void insert(PaySerial paySerial);

}
