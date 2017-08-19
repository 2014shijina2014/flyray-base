package me.flyray.message.common;

import java.util.Date;

import org.apache.ibatis.reflection.MetaObject;

import com.baomidou.mybatisplus.mapper.MetaObjectHandler;

/** 
* @author: bolei
* @date：Jul 14, 2017 5:51:17 PM 
* @description：自定义填充处理器
*/

public class MyMetaObjectHandler extends MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
    	this.insertFill(metaObject);
    }

    @Override
    public boolean openUpdateFill() {
        return false;
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        // 关闭更新填充、这里不执行
    }
}

