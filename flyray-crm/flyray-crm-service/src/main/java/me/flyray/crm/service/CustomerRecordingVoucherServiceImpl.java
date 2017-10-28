package me.flyray.crm.service;

import org.springframework.stereotype.Service;

import me.flyray.common.service.AbstractBaseService;
import me.flyray.crm.api.CustomerRecordingVoucherService;
import me.flyray.crm.model.CustomerRecordingVoucher;

/** 
* @author: bolei
* @date：2017年10月19日 上午10:02:22
* @description：客户记账凭证(用户记录账户交易明细不可更改)
*/

@Service("customerRecordingVoucherService")
public class CustomerRecordingVoucherServiceImpl extends AbstractBaseService<CustomerRecordingVoucher> implements CustomerRecordingVoucherService{

}
