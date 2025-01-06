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

    // 无参构造函数
    public Product() {
    }

    // 带参数构造函数
    public Product(Integer product_id, String product_name, BigDecimal product_price,
                   Integer product_num, String description, String image_url, String product_type) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_price = product_price;
        this.product_num = product_num;
        this.description = description;
        this.image_url = image_url;
        this.product_type = product_type;
    }


    private static final long serialVersionUID = 1L;
}