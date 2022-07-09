package com.laf.entity.entity.sys;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * (Message)表实体类
 *
 * @author Kamisora
 * @since 2022-06-25 10:40:38
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value= "sys_message")
public class Message {
    //用户留言板对应id
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    //用户留言信息
    private String message;
    //留下留言的用户id
    @JsonSerialize(using = ToStringSerializer.class)
    private Long leaveUserid;
    //留给用户的id
    @JsonSerialize(using = ToStringSerializer.class)
    private Long toUserid;

}

