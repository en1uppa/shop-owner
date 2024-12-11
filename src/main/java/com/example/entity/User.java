package com.example.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @TableName user
 */
@TableName(value ="user")
@Data
public class User implements Serializable {
    private Integer user_id;

    private String user_name;

    private String password;

    private String tel;

    private String email;

    private String img_url;

    private static final long serialVersionUID = 1L;
}