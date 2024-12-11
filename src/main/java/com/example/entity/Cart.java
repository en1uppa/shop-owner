package com.example.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @TableName cart
 */
@TableName(value ="cart")
@Accessors(chain = true)
@Data
public class Cart implements Serializable {
    private Integer cart_id;

    private Integer user_id;

    private BigDecimal total_price;

    private String status;

    private static final long serialVersionUID = 1L;
}