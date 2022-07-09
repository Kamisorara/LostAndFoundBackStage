package com.laf.entity.entity.laf;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * (Notice)表实体类
 *
 * @author Kamisora
 * @since 2022-06-25 10:42:59
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value= "laf_notice")
public class Notice {
    //启示对应id
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    //启示发布者对应id
    private Long  createId;
    //启示简介
    private String message;
    //启示浏览次数
    private Integer view;
    //启示显示状态(0显示，1不显示)
    private String status;
    //启示是否已完成(0完成，1未完成)
    private String done;
    //帮助者的id
    private Long helperUserid;
    //启示创建时间
    private Date createTime;
    //启示类型(0寻物启事，1拾物启示)
    private String type;
    //紧急事件（0紧急，1非紧急）
    private String urgency;

}

