package com.laf.web.controller.sys;

import com.laf.dao.mapper.UserMapper;
import com.laf.entity.entity.resp.ResponseResult;
import com.laf.entity.entity.sys.User;
import com.laf.service.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/sys/user-common")
public class userCommon {

    @Autowired
    private LoginService loginService;

    @Autowired
    private UserMapper userMapper;


    /**
     * 登录接口
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseResult login(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User();
        user.setUserName(username);
        user.setPassword(password);
        //登录操作
        return loginService.login(user);
    }


    /**
     * 退出
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ResponseResult logout() {
        return loginService.logout();
    }


    /**
     * 测试用(之后删除)
     */
    @RequestMapping(value = "/select-user")
    public ResponseResult select(@RequestParam("id") Long id) {
        User user = userMapper.selectById(id);
        return new ResponseResult(200, "获取", user);

    }
}
