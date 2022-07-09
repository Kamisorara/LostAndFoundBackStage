package com.laf.entity.entity.sys;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.experimental.Accessors;

/**
 * (User)表实体类
 *
 * @author Kamisora
 * @since 2022-06-25 10:38:12
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@TableName(value = "sys_user")
public class User {
    //用户id
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    //用户名
    private String userName;
    //用户手机号
    private String phoneNumber;
    //用户邮箱号
    private String email;
    //用户头像url
    private String avatar;
    //用户启用状态(0启用，1禁用)
    private String status;
    //账号创建时间
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    //密码
    private String password;

    //是否为管理员0(是)1(不是)
    private String admin;


}

