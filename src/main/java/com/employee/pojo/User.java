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
public class User extends BaseModel {

    @TableId(value = "id",type = IdType.AUTO)
    private String id;

    @TableField("username")
    private String username;

    @TableField("password")
    private String password;

    @TableField("isAdmin")
    private Boolean isAdmin = false;

    @TableLogic
    private Boolean isDeleted = false;

}
