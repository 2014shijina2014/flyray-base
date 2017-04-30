package me.flyray.pay.dto;

import java.math.BigDecimal;
import java.util.Date;

/** 
* @author: bolei
* @date：2017年2月23日 上午11:37:46 
* @description：支付请求对象
*/

public class OnlinePaymentRequest extends AbstractRequest{

	/**
	 * 支付流水号
	 */
	private String serialNo;
	/**
	 * 订单总金额
	 */
	private BigDecimal orderAmt;
	/**
	 * 币种
	 */
	private String CCY;
	/**
	 * 商品展示网址
	 */
	private String productUrl;
	/**
	 * 商品名称
	 */
	private String productName;
	/**
	 * 商品简称
	 */
	private String productShortName;
	/**
	 * 商品描述
	 */
	private String body;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 单价
	 */
	private BigDecimal unitPrice;
	/**
	 * 数量
	 */
	private int quantity;

	/**
	 * 银行编号
	 */
	private String bankCode;
	/**
	 * 订单生成日期
	 */
	private Date txDate;
	/**
	 * 订单生成时间
	 */
	private Date txTime;
	
	/**
	 * 防钓鱼时间戳
	 */
	private String antiPhishingKey;
	/**
	 * 客户端IP
	 */
	private String exterInvokeIp;

	// xiaoxiao 2015-09-14
	/**
	 * 商户客户号
	 */
	private String merchantNo;
	/**
	 * 订单超时时间(分钟)
	 */
	private long timeOut;
	
	/**
	 * 操作完成后的跳转URL
	 */
	private String returnUrl;
	
	/**
	 * 接受结果通知接口
	 */
	private String notifyUrl;

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	public BigDecimal getOrderAmt() {
		return orderAmt;
	}

	public void setOrderAmt(BigDecimal orderAmt) {
		this.orderAmt = orderAmt;
	}

	public String getCCY() {
		return CCY;
	}

	public void setCCY(String cCY) {
		CCY = cCY;
	}

	public String getProductUrl() {
		return productUrl;
	}

	public void setProductUrl(String productUrl) {
		this.productUrl = productUrl;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductShortName() {
		return productShortName;
	}

	public void setProductShortName(String productShortName) {
		this.productShortName = productShortName;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public Date getTxDate() {
		return txDate;
	}

	public void setTxDate(Date txDate) {
		this.txDate = txDate;
	}

	public Date getTxTime() {
		return txTime;
	}

	public void setTxTime(Date txTime) {
		this.txTime = txTime;
	}

	public String getAntiPhishingKey() {
		return antiPhishingKey;
	}

	public void setAntiPhishingKey(String antiPhishingKey) {
		this.antiPhishingKey = antiPhishingKey;
	}

	public String getExterInvokeIp() {
		return exterInvokeIp;
	}

	public void setExterInvokeIp(String exterInvokeIp) {
		this.exterInvokeIp = exterInvokeIp;
	}

	public String getMerchantNo() {
		return merchantNo;
	}

	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	public long getTimeOut() {
		return timeOut;
	}

	public void setTimeOut(long timeOut) {
		this.timeOut = timeOut;
	}

	public String getReturnUrl() {
		return returnUrl;
	}

	public void setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
	}

	public String getNotifyUrl() {
		return notifyUrl;
	}

	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}
	
}
