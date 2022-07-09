package com.laf.entity.entity.sys;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * (sys_role_menu)表实体类
 *
 * @author Kamisora
 * @since 2022-06-25 10:40:39
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value= "sys_role_menu")
public class RoleMenu {
    //角色id
    @JsonSerialize(using = ToStringSerializer.class)
    private Long roleId;
    //权限id
    @JsonSerialize(using = ToStringSerializer.class)
    private Long menuId;

}

