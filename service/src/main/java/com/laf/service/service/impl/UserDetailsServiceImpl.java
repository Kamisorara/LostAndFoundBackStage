package com.laf.service.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

import com.laf.dao.mapper.MenuMapper;
import com.laf.dao.mapper.UserMapper;
import com.laf.entity.entity.LoginUser;
import com.laf.entity.entity.sys.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserMapper userMapper;

    @Autowired
    MenuMapper menuMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //查询用户信息
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUserName,username);
        User user = userMapper.selectOne(queryWrapper);
        //如果没有查询到用户就抛出异常
        if(Objects.isNull(user)){
            throw new RuntimeException("用户名或者密码错误");
        }
        //因为UserDetailsService方法的返回值是UserDetails类型，所以需要定义一个类，实现该接口，把用户信息封装在其中。
        //TODO 根据用户查询权限信息 添加到LoginUser中
        List<String> permsList = menuMapper.selectPermsByUserId(user.getId());
//        List<String> permsList = new ArrayList<>(Arrays.asList("test", "admin"));
        //把数据封装成UserDetails类型返回
        return new LoginUser(user, permsList);
    }
}
