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

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee extends BaseModel {

    @TableId(value = "id",type = IdType.AUTO)
    private String id;

    @TableField("code")
    private String code;

    @TableField("dept_id")
    private String deptId;

    @TableField("name")
    private String name;

    @TableField("birthday")
    private Date birthday;

    @TableField("sex")
    private String sex;

    @TableField("work")
    private String work;

    @TableField("work_date")
    private Date workDate;

    @TableField("money")
    private String money;

    @TableField("money_b")
    private String moneyB;

    @TableField("update_time")
    private Date updateTime;

    @TableLogic
    private Boolean isDeleted = false;
}
