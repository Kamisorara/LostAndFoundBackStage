package com.laf.entity.entity.sys;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * (Role)表实体类
 *
 * @author Kamisora
 * @since 2022-06-25 10:40:39
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value= "sys_role")
public class Role {
    //角色对应id
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    //角色名
    private String name;
    //角色权限字符串例如admin或user
    private String roleKey;
    //角色启用状态(0启用,1禁用)
    private String status;

}

