package com.example.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @TableName keeper
 */
@TableName(value ="keeper")
@Data
public class Keeper implements Serializable {
    private Integer keeper_id;

    private String keeper_name;

    private String password;

    private String tel;

    private String email;

    private Integer status;

    private static final long serialVersionUID = 1L;
}