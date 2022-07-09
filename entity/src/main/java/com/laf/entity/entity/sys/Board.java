package com.laf.entity.entity.sys;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * (Board)表实体类
 *
 * @author Kamisora
 * @since 2022-06-25 10:40:38
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value= "sys_board")
public class Board {
    //公告板对应id

    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    //公告板信息
    private String message;
    //公告板需要跳转的url
    private String boardUrl;
    //显示状态(0不显示，1显示)
    private String status;

}

