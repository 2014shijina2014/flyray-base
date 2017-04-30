package me.flyray.pay.service.pay.wechat.domain;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/** 
* @author: bolei
* @date：2017年4月30日 下午1:53:32 
* @description：微信支付相应
*/

@XmlRootElement(name = "xml")
public class ResponseElement {

	@XmlAttribute(name = "return_code")
	private String returnCode;
	
	@XmlAttribute(name = "return_msg")
	private String returnMsg;
	
	@XmlAttribute(name = "appid")
	private String appid;
	
	@XmlAttribute(name = "mch_id")
	private String mchId;
	
	@XmlAttribute(name = "nonce_str")
	private String nonceStr;
	
	@XmlAttribute(name = "sign")
	private String sign;
	
	@XmlAttribute(name = "result_code")
	private String resultCode;
	
	@XmlAttribute(name = "prepay_id")
	private String prepayId;
	
	@XmlAttribute(name = "trade_type")
	private String tradeType;

	public String getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}

	public String getReturnMsg() {
		return returnMsg;
	}

	public void setReturnMsg(String returnMsg) {
		this.returnMsg = returnMsg;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getMchId() {
		return mchId;
	}

	public void setMchId(String mchId) {
		this.mchId = mchId;
	}

	public String getNonceStr() {
		return nonceStr;
	}

	public void setNonceStr(String nonceStr) {
		this.nonceStr = nonceStr;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getPrepayId() {
		return prepayId;
	}

	public void setPrepayId(String prepayId) {
		this.prepayId = prepayId;
	}

	public String getTradeType() {
		return tradeType;
	}

	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}
	
	
	
}

