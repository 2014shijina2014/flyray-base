/**
 * jwt 载荷类
 */
package me.flyray.common.security;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author goba
 *
 */
public class JwtClaimItems {

   /*
    * 自定义载荷各个载荷Key Name
    * PL0：__userId,PL1:__userName,PL2:__roleId,
    * PL3:__orgId,PL4:__orgName,PL5:__custNo,
    * PL6:__merchId(商户号),PL7:__actNo
    */
	private String tagKey; 

	/*
	 * 用3Des加密的内容
	 */
	private String threeDesValue;
	
	/*
	 * 明文内容
	 */
	private String realValue;
	
	/**
	 * @return the tagKey
	 */
	public String getTagKey() {
		return tagKey;
	}

	/**
	 * @param tagKey the tagKey to set
	 */
	public void setTagKey(String tagKey) {
		this.tagKey = tagKey;
	}

	/**
	 * @return the threeDesValue
	 */
	public String getThreeDesValue() {
		return threeDesValue;
	}

	/**
	 * @param threeDesValue the threeDesValue to set
	 */
	public void setThreeDesValue(String threeDesValue) {
		this.threeDesValue = threeDesValue;
	}

	/**
	 * @return the realValue
	 */
	public String getRealValue() {
		return realValue;
	}

	/**
	 * @param realValue the realValue to set
	 */
	public void setRealValue(String realValue) {
		this.realValue = realValue;
	}

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
	    List<JwtClaimItems> jwtClaimItems = new ArrayList<JwtClaimItems>();
	    JwtClaimItems jwtClaimItem =new JwtClaimItems();
	    jwtClaimItem.setTagKey("PL0"); //__userId
	    jwtClaimItem.setRealValue("liuzihuang");
	    jwtClaimItems.add(jwtClaimItem);
	    jwtClaimItem =new JwtClaimItems();
	    jwtClaimItem.setTagKey("PL1"); //__userName
	    jwtClaimItem.setRealValue("刘子煌");
	    jwtClaimItems.add(jwtClaimItem);
	    for (int i=0;i<jwtClaimItems.size();i++){
	    	jwtClaimItem =(JwtClaimItems)jwtClaimItems.get(i);
	    	jwtClaimItem.setThreeDesValue(
	    		ThreeDes.to3DESAndBase64(
	    		  jwtClaimItem.getRealValue(),
	    		  HexStrFromToStr.encode("床老前顽明童月光")
	    		  )
	    	);
	    	System.out.println("TagKey:"
	    	    +jwtClaimItem.getTagKey()
	    	    +"=="+"RealValue:"+jwtClaimItem.getRealValue()
	    	    +"=="+"ThreeDesValue:"+jwtClaimItem.getThreeDesValue()
	    	    +"=="+"revert value："+ThreeDes.from3DESAndBase64(
	  	    		  jwtClaimItem.getThreeDesValue(),
		    		  HexStrFromToStr.encode("床老前顽明童月光")
		    		  ));
	    }
	}

}
