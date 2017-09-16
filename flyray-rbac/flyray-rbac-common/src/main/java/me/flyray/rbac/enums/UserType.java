package me.flyray.rbac.enums;

/** 
* @author: bolei
* @date：2017年9月16日 上午11:52:15
* @description：类说明 
*/

public enum UserType {

	/**
     * saas管理员
     */
    SAAS_ADMIN("0"),
	/**
     * saas平台下商户
     */
    SAAS_MER("1"),
    /**
     * 平台商户
     */
    PLAT_MERT("2"),
	
	/**
     * 平台商户管理员
     */
	PLAT_ADMIN("3"),
    
    /**
     * 平台子商户
     */
	PLAT_SUB_MERT("4");

    public String code;

    private UserType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public static UserType get(String code) {
        for (UserType c : UserType.values()) {
            if (c.getCode().equals(code)) {
                return c;
            }
        }
        return null;
    }
}
