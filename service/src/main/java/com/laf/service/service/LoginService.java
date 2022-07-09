package com.laf.service.service;


import com.laf.entity.entity.resp.ResponseResult;
import com.laf.entity.entity.sys.User;


public interface LoginService {
    ResponseResult login(User user);

    ResponseResult logout();
}
