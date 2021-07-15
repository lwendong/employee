package com.employee.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.employee.pub.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Dept extends BaseModel {

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    @TableField("name")
    private String name;

    @TableField("code")
    private String code;

    @TableField("mana_id")
    private String manaId;

    @TableField(value = "manaName",exist = false)
    private String manaName;

    @TableField(value = "count",exist = false)
    private long count;

    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(exist = false)
    private String createTimeString;

    @TableLogic
    private Boolean isDeleted;

    public String getCreateTimeString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
        String format = simpleDateFormat.format(this.createTime);
        return format;
    }
}
