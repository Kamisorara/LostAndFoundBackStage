package com.laf.entity.entity.sys;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * (sys_user_role)表实体类
 *
 * @author Kamisora
 * @since 2022-06-25 10:40:39
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "sys_user_role")
public class UserRole {
    //用户id
    @JsonSerialize(using = ToStringSerializer.class)
    private Long userId;
    //角色id
    @JsonSerialize(using = ToStringSerializer.class)
    private Long roleId;

}

