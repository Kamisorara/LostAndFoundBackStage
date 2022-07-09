package com.laf.dao.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.laf.entity.entity.sys.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuMapper extends BaseMapper<Menu> {
    //根据用户id查询用户所对应的权限
    List<String> selectPermsByUserId(Long id);

}
