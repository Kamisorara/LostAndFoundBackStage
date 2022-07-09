package com.laf.service.service.impl;


import com.laf.dao.mapper.UserMapper;
import com.laf.entity.entity.LoginUser;
import com.laf.entity.entity.resp.ResponseResult;
import com.laf.entity.entity.sys.User;
import com.laf.entity.utils.JwtUtil;
import com.laf.entity.utils.RedisCache;
import com.laf.service.service.LoginService;
import com.laf.service.service.VerifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    VerifyService verifyService;

    @Autowired
    private RedisCache redisCache;

    /**
     * 登录
     */
    @Override
    public ResponseResult login(User user) {
        //AuthenticationManager的authenticate方法来进行用户认证
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);//如果认证通过这个结果就不为null
        //如果认证不通过给出对应提示
        if (Objects.isNull(authenticate)) {
            throw new RuntimeException("登录失败");
        }
        //如果用户的status是处于被封禁状态则登录失败
        Long userId = userMapper.selectUserIdByUserName(user.getUserName());
        String userStatus = userMapper.getUserStatus(userId);
        String userAdminStatus = userMapper.getUserAdminStatus(userId);
        if (userAdminStatus.equals("1")) {

            return new ResponseResult(400, "该账号非管理员账号！");
        } else if (userStatus.equals("1")) {

            return new ResponseResult(400, "该账户已被管理员封禁，请联系管理员已获取详细信息！");
        } else {
            //如果认证通过使用userid生成jwt  存入ResponseBody进行返回
            LoginUser loginUser = (LoginUser) authenticate.getPrincipal(); //强转成LoginUser对象
            String userid = loginUser.getUser().getId().toString();
            //生成jwt
            String jwt = JwtUtil.createJWT(userid);
            Map<String, String> map = new HashMap<>();
            map.put("token", jwt);
            //把完整的用户信息存入redis
            redisCache.setCacheObject("login:" + userid, loginUser);
            return new ResponseResult(200, "登录成功", map);
        }
    }


    /**
     * 退出
     */
    @Override
    public ResponseResult logout() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        Long userid = loginUser.getUser().getId();
        redisCache.deleteObject("login:" + userid);
        return new ResponseResult(200, "退出成功");
    }
}
