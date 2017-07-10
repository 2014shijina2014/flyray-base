package me.flyray.crm.enums;

/** 
* @author: bolei
* @date：Jul 9, 2017 11:01:30 AM 
* @description：账单类型
*/

public enum BillingType {
	//冲 提 转 支 收
	RECHARGE("00","充值"),
    WITHDRAWS("01","提现"),
    TRANSFER("02","转账"),
    PAY("02","消费"),
    COLLECTION("03","积分账户");
	
    private String code;
    private String desc;
    
    private BillingType (String code,String desc){
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    
    public static BillingType getBillingType(String code){
        for(BillingType o : BillingType.values()){
            if(o.getCode().equals(code)){
                return o;
            }
        }
        return null;
    }
}
