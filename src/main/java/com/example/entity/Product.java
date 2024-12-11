package com.example.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @TableName product
 */
@TableName(value ="product")
@Data
public class Product implements Serializable {
    private Integer product_id;

    private String product_name;

    private BigDecimal product_price;

    private Integer product_num;

    private String description;

    private String image_url;

    private String product_type;

    private static final long serialVersionUID = 1L;
}