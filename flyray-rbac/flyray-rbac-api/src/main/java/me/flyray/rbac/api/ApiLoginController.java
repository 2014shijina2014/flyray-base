package me.flyray.rbac.api;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import me.flyray.rbac.service.TokenService;
import me.flyray.rbac.service.UserService;
import me.flyray.rbac.utils.R;
import me.flyray.rbac.validator.Assert;

/**
 * API登录授权
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-03-23 15:31
 */
@RestController
@RequestMapping("/api")
public class ApiLoginController {
    @Autowired
    private UserService userService;
    @Autowired
    private TokenService tokenService;

    /**
     * 登录
     */
    @RequestMapping(value="login",method = RequestMethod.POST)
    public R login(String mobile, String password){
        Assert.isBlank(mobile, "手机号不能为空");
        Assert.isBlank(password, "密码不能为空");

        //用户登录
        long userId = userService.login(mobile, password);

        //生成token
        Map<String, Object> map = tokenService.createToken(userId);

        return R.ok(map);
    }

}
