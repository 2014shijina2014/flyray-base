package me.flyray.crm.enums;

/** 
* @author: bolei
* @date：Jun 14, 2017 8:06:04 PM 
* @description：账户类型
*/

public enum AccountType {
	
	BALANCE("00","余额账户"),
    BRIBERY_MONEY("02","红包账户"),
    POINTS("03","积分账户");
	
    private String code;
    private String desc;
    
    private AccountType (String code,String desc){
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
    
    public static AccountType getAcountType(String code){
        for(AccountType o : AccountType.values()){
            if(o.getCode().equals(code)){
                return o;
            }
        }
        return null;
    }
}
