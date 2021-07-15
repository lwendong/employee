package com.employee.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.employee.pub.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee extends BaseModel {

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    @TableField("code")
    private String code;

    @TableField("dept_code")
    private String deptCode;

    @TableField(exist = false)
    private String deptName;

    @TableField(exist = false)
    private String managerName;

    @TableField("name")
    private String name;

    @TableField("birthday")
    private String birthday;

    @TableField("sex")
    private String sex;

    @TableField("work")
    private String work;

    @TableField("work_date")
    private String workDate;

    @TableField(exist = false)
    private String workDateString;

    @TableField("money")
    private String money;

    @TableField("money_b")
    private String moneyB;

    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private Date createTime;

    @TableLogic
    private Boolean isDeleted = false;
}
