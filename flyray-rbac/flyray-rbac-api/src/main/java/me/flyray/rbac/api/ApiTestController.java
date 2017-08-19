package me.flyray.rbac.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import me.flyray.rbac.annotation.IgnoreAuth;
import me.flyray.rbac.annotation.LoginUser;
import me.flyray.rbac.entity.UserEntity;
import me.flyray.rbac.utils.R;

/**
 * API测试接口
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-03-23 15:47
 */
@RestController
@RequestMapping("/api")
public class ApiTestController {

    /**
     * 获取用户信息
     */
	@RequestMapping(value="userInfo",method = RequestMethod.GET)
    public R userInfo(@LoginUser UserEntity user){

        return R.ok().put("user", user);
    }

    /**
     * 忽略Token验证测试
     */
    @IgnoreAuth
    @RequestMapping(value="notToken",method = RequestMethod.GET)
    public R notToken(){

        return R.ok().put("message", "无需token也能访问。。。");
    }
}
