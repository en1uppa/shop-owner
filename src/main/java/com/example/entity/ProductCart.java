package com.example.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @TableName product_cart
 */
@TableName(value ="product_cart")
@Data
public class ProductCart implements Serializable {
    private Integer productCart_id;

    private Integer cart_id;

    private Integer user_id;//看后期是否需要,不需要则删除

    private Integer product_id;

    private BigDecimal product_price;

    private static final long serialVersionUID = 1L;
}