package me.flyray.common.exception;

/** 
* @author: bolei
* @date：2017年4月30日 上午11:18:04 
* @description：业务异常
*/

public class BusinessException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public BusinessException(String code) {
		super(code);
	}
	
	public BusinessException(String code, Object... arguments) {
		super(code);
	}
	
	BusinessException(String code, Throwable cause) {
		super(code);
	}
	
	public static void main(String[] args) {
      String[] sexs = {"男性","女性","中性"};
      for(int i = 0; i < sexs.length; i++){
          if("中性".equals(sexs[i])){
              //throw new BusinessException("你全家都是中性！");
        	  throw new BusinessException("22","你全家都是中性！");
          }else{
              System.out.println(sexs[i]);
          }
      }
     }

}
