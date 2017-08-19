package me.flyray.message.common;

import java.io.Serializable;

/** 
* @author: bolei
* @date：Jul 14, 2017 5:22:06 PM 
* @description：类描述
*/

public class SuperEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
