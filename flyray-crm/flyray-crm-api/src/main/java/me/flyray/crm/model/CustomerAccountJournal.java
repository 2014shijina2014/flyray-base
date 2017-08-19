package me.flyray.crm.model;

import java.math.BigDecimal;
import java.util.Date;

/** 
* @author: bolei
* @date：Jul 9, 2017 9:25:24 AM 
* @description：客户账户流水账（分类账）
*/

public class CustomerAccountJournal {
	
	/**
	 * 客户自增ID
	 */
	private Long id;
	
	/**
	 * 流水号
	 */
	private String JournalNo;
	
	/**
	 * 账户
	 */
	private String customerAccountNo;
	
	/**
	 * 发生额
	 */
	private BigDecimal amt;
	
	/**
	 * 发生额方向 借方 贷方
	 */
	private String fundsDirection;
	
	/**
	 * 时间
	 */
	private Date createTime ;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getJournalNo() {
		return JournalNo;
	}

	public void setJournalNo(String journalNo) {
		JournalNo = journalNo;
	}

	public String getCustomerAccountNo() {
		return customerAccountNo;
	}

	public void setCustomerAccountNo(String customerAccountNo) {
		this.customerAccountNo = customerAccountNo;
	}

	public BigDecimal getAmt() {
		return amt;
	}

	public void setAmt(BigDecimal amt) {
		this.amt = amt;
	}

	public String getFundsDirection() {
		return fundsDirection;
	}

	public void setFundsDirection(String fundsDirection) {
		this.fundsDirection = fundsDirection;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
}
