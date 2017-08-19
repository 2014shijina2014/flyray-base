package me.flyray.message.common;

/** 
* @author: bolei
* @date：Jul 14, 2017 5:21:26 PM 
* @description：类描述
*/

public interface SuperMapper<T> extends com.baomidou.mybatisplus.mapper.BaseMapper<T> {

    // 这里可以写自己的公共方法、注意不要让 mp 扫描到误以为是实体 Base 的操作
}
