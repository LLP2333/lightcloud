package com.llp.lightcloud.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @TableName user
 */
@TableName(value ="user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    /**
     * 用户id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 用户权限，0表示管理员，1为用户
     */
    private Integer superuser;

    /**
     * 0表示未删除，1表示已经删除
     */
    @TableLogic(value = "0",delval = "1")
    private Integer isdelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}