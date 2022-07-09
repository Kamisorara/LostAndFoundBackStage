package com.laf.entity.entity.sys;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * (Menu)表实体类
 *
 * @author Kamisora
 * @since 2022-06-25 10:40:38
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value= "sys_menu")
public class Menu {
    //详细权限对应id
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    //权限名
    private String menuName;
    //权限表示(例如sys:common:user)
    private String perms;
    //(0启用，1禁用)
    private String status;

}

