package com.example.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @TableName keeper
 */
@TableName(value ="comment")
@Data
public class Comment implements Serializable{
    private Integer id;

    private Integer user_id;

    private Integer product_id;

    private String createtime;

    private String content;

    private static final long serialVersionUID = 1L;
}
