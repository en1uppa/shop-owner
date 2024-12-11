package com.example.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @TableName cartVO
 */
@Accessors(chain = true)
@Data
public class ProductVo implements Serializable {
    //购物车的商品信息展示(包括书名,图片,书的类型)和他的价格(product表)
    private Integer product_id;

    private String product_name;

    private String image_url;

    private BigDecimal product_price;

    private Integer buy_num;

    private static final long serialVersionUID = 1L;
}