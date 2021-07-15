package com.employee.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.employee.pub.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Dept extends BaseModel {

    @TableId(value = "id",type = IdType.AUTO)
    private String id;

    @TableField("name")
    private String name;

    @TableField("dept_id")
    private String deptId;

    @TableLogic
    private String isDeleted;
}
