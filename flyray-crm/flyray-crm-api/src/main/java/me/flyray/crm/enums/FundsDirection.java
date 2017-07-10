package me.flyray.crm.enums;

/** 
* @author: bolei
* @date：Jul 9, 2017 9:44:02 AM 
* @description：发生额方向
*/

public enum FundsDirection {
	//收方 借方增加
	DEBITS("00","借方"),
	//贷方 贷方减少
    CREDITS("01","贷方");
    private String code;
    private String desc;
    
    private FundsDirection (String code,String desc){
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
    
    public static FundsDirection getFundsDirection(String code){
        for(FundsDirection o : FundsDirection.values()){
            if(o.getCode().equals(code)){
                return o;
            }
        }
        return null;
    }
}
