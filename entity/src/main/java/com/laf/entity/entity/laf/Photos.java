package com.laf.entity.entity.laf;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * (Phptos)表实体类
 *
 * @author Kamisora
 * @since 2022-06-25 10:42:58
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value= "laf_photos")
public class Photos {
    //启示对应图片id
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    //启示对应图片url
    private String lafPhotourl;
    //图片对应的启示id
    @JsonSerialize(using = ToStringSerializer.class)
    private Long lafId;

}

