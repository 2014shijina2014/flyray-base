package me.flyray.rbac.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import me.flyray.rbac.entity.UserEntity;
import me.flyray.rbac.service.UserService;
import me.flyray.rbac.utils.R;
import me.flyray.rbac.validator.Assert;

/**
 * 注册
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-03-26 17:27
 */	
@RestController
@RequestMapping("/api")
public class ApiRegisterController {
    @Autowired
    private UserService userService;

    /**
     * 注册
     */
    @RequestMapping(value="register",method = RequestMethod.POST)
    public R register(@RequestBody UserEntity user){
        Assert.isBlank(user.getMobile(), "手机号不能为空");
        Assert.isBlank(user.getPassword(), "密码不能为空");

        userService.save(user);

        return R.ok();
    }
}
