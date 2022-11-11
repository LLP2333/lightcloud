package com.llp.lightcloud.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName user_files
 */
@TableName(value ="user_files")
@Data
public class UserFiles implements Serializable {
    /**
     * 自增id
     */
    @TableId
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 文件名（uuid）
     */
    private String filename;

    /**
     * 文件名（真实的文件名）
     */
    private String filepath;

    /**
     * 0表示未删除，1表示软删除
     */
    private Integer isdelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}