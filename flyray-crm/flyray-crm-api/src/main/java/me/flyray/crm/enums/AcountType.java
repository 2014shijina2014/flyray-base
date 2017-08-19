package me.flyray.crm.enums;

/** 
* @author: bolei
* @date：Jun 14, 2017 8:06:04 PM 
* @description：账户类型
*/

public enum AcountType {
	
	BALANCE("00","余额账户"),
    BRIBERY_MONEY("02","红包账户"),
    POINTS("03","积分账户");
	
    private String code;
    private String desc;
    
    private AcountType (String code,String desc){
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
    
    public static AcountType getAcountType(String code){
        for(AcountType o : AcountType.values()){
            if(o.getCode().equals(code)){
                return o;
            }
        }
        return null;
    }
}
