package com.laf.entity.entity.sys;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * (Rank)表实体类
 *
 * @author Kamisora
 * @since 2022-06-25 10:40:38
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value= "sys_rank")
public class Rank {
    //用户排行榜对应id
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    //排行榜对应用户id
    @JsonSerialize(using = ToStringSerializer.class)
    private Long userId;
    //用户帮助次数
    private Integer helpTimes;

}

