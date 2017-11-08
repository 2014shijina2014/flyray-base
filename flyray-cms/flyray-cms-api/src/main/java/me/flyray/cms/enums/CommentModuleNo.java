package me.flyray.cms.enums;

/** 
* @author: bolei
* @date：2017年11月2日 下午12:26:50
* @description：类说明 
*/

public enum CommentModuleNo {

	specialColumn_columnContentDetail("01","专栏详细页模块"),
	home_viewpoint("02","首页圈子模块"),
	home_topic("03","首页话题模块"),
	activity_activity("04","活动模块"),
	activity_highlights("05","活动亮点模块");
	
    private String code;
    private String desc;
    
    private CommentModuleNo (String code,String desc){
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
    
    public static CommentModuleNo getCommentModuleNo(String code){
        for(CommentModuleNo o : CommentModuleNo.values()){
            if(o.getCode().equals(code)){
                return o;
            }
        }
        return null;
    }
}
