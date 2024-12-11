package com.example.vo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.example.entity.Product;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @TableName cart
 */
@Accessors(chain = true)
@Data
public class CartVo implements Serializable {
    //商品信息(包括书名,图片,书的类型)和他的价格(product表)
    private Integer cart_id;

    private List<ProductVo> productVoList;

    //总价格==>去结算(product_cart表)
    private BigDecimal total_price;

    private static final long serialVersionUID = 1L;
}