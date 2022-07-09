package com.laf.entity.entity.sys;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * (Photos)表实体类
 *
 * @author Kamisora
 * @since 2022-06-25 10:40:38
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value= "sys_photos")
public class Photos {
    //用户个性背景图片url
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    //url地址
    private String photoUrl;
    //对应用户id
    @JsonSerialize(using = ToStringSerializer.class)
    private Long userId;
    //启用状态(0启用，1禁用)
    private String status;

}

