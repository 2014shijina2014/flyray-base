package me.flyray.crm.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import me.flyray.common.service.AbstractBaseService;
import me.flyray.common.utils.GenerateSequenceUtil;
import me.flyray.common.utils.SnowFlake;
import me.flyray.common.utils.UUIDTool;
import me.flyray.crm.api.CustomerAccountService;
import me.flyray.crm.dao.CustomerAccountDao;
import me.flyray.crm.dao.CustomerAccountJournalDao;
import me.flyray.crm.enums.FundsDirection;
import me.flyray.crm.model.CustomerAccount;
import me.flyray.crm.model.CustomerAccountJournal;

/** 
* @author: bolei
* @date：2017年4月15日 上午2:09:29 
* @description：客户账务处理
*/

@Transactional
@Service("customerAccountService")
public class CustomerAccountServiceImpl extends AbstractBaseService<CustomerAccount> implements CustomerAccountService{
	
	@Autowired
	private CustomerAccountDao customerAccountDao;
	@Autowired
	private CustomerAccountJournalDao customerAccountJournalDao;
	
	/**
	 * 根据参数生成客户账户信息
	 * 参数账户类型必输 是枚举值
	 */
	@Override
	@Transactional( rollbackFor={Exception.class})
	public String openAccount(CustomerAccount customerAccount) {
		CustomerAccount ca = new CustomerAccount();
		String customerAccountNo = "0ca0"+UUIDTool.getUUID();
		ca.setCustomerAccountNo(customerAccountNo);
		ca.setFreezeValue("0");
		ca.setStatus("00");
		customerAccountDao.save(ca);
		return customerAccountNo;
	}

	/**
	 * 个人账户入金
	 */
	@Override
	public void deposit(CustomerAccount customerAccount,String amt) {
		accountingTreatment(customerAccount, amt, FundsDirection.DEBITS.getCode());
	}
	
	/**
	 * 个人账户出金
	 */
	@Override
	public void withdraw(CustomerAccount customerAccount,String amt) {
		accountingTreatment(customerAccount, amt, FundsDirection.CREDITS.getCode());
	}

	/**
	 * 个人转账
	 * 转账给商家
	 * 转账给个人
	 */
	@Override
	public void transfer(Map<String, Object> param) {
		//记账明细
	}
	
	/**
	 * 账户处理
	 */
	public void accountingTreatment(CustomerAccount customerAccount,String amt, String fundsDirection){
		//记账明细
		String custAccountNo = customerAccount.getCustomerAccountNo();
		String journalNo = GenerateSequenceUtil.generateSequenceNo();
		CustomerAccountJournal customerAccountJournal = new CustomerAccountJournal();
		long id = SnowFlake.getId();//目的防止伪造造成脏数据
		customerAccountJournal.setId(String.valueOf(id));
		customerAccountJournal.setFundsDirection(fundsDirection);
		customerAccountJournal.setCustomerAccountNo(custAccountNo);
		BigDecimal amtDec = new BigDecimal(amt);
		customerAccountJournal.setAmt(amtDec);
		customerAccountJournal.setCreateTime(new Date());
		customerAccountJournal.setJournalNo(journalNo);
		customerAccountJournalDao.save(customerAccountJournal);
		//查询该账户下的金额
		CustomerAccount ca = customerAccountDao.queryByCustomerAccountNo(custAccountNo);
		if (FundsDirection.CREDITS.getCode() == fundsDirection) {
			ca.setValue(String.valueOf(new BigDecimal(ca.getValue()).subtract(amtDec)));
		}else if (FundsDirection.DEBITS.getCode() == fundsDirection) {
			ca.setValue(String.valueOf(new BigDecimal(ca.getValue()).add(amtDec)));
		}
		//更新账户金额
		customerAccountDao.update(ca);
	}

	@Override
	public void save(CustomerAccount customerAccount) {
		customerAccountDao.save(customerAccount);
	}

}
