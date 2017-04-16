package me.flyray.pay.servicetest;

import java.util.HashMap;
import java.util.Map;

import me.flyray.common.BeanUtil;
import me.flyray.pay.model.PayChannel;

/** 
* @author: bolei
* @date：2017年4月16日 下午6:02:29 
* @description：类说明 
*/

public class ReflectionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("PayChannelId", 1);
			map.put("payChannelNo", "2");
			map.put("payCompanyNo", "3");
			map.put("feeRatio", 1);
			PayChannel payChannel = (PayChannel)BeanUtil.mapToObject(map, PayChannel.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
