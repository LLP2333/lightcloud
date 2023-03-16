package com.llp.lightcloud.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName shared_files
 */
@TableName(value ="shared_files")
@Data
public class SharedFiles implements Serializable {
    /**
     * 自增id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 文件id
     */
    private Long fileid;

    /**
     * 文件分享码
     */
    private String filepassword;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}