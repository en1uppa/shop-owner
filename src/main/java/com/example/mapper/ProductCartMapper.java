package com.example.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.example.entity.ProductCart;
import com.example.vo.ProductVo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.math.BigDecimal;
import java.util.List;

/**
* @author testwin1
* @description 针对表【product_cart】的数据库操作Mapper
* @createDate 2024-06-15 23:53:28
* @Entity generator.domain.ProductCart
*/
public interface ProductCartMapper extends BaseMapper<ProductCart> {
    @Insert("INSERT INTO `product_cart` (cart_id, product_id, product_price) VALUES (#{cart_id}, #{product_id}, #{product_price})")
    void addProductCart(ProductCart productCart);

    @Select("select count(*) from `product_cart` where product_id = #{productId}")
    Integer getNumByProductId(Integer productId);

    @Select("select product_id from `product_cart` where cart_id=#{cartId}")
    List<Integer> getList(Integer cartId);

    @Select("select sum(product_price) from `product_cart` where cart_id=#{cartId}")
    BigDecimal getAllPrice(@Param("cartId") Integer cartId);

    @Select("select * from `product_cart` where product_id=#{productId} and cart_id=#{cartId}")
    ProductCart getProductCart(Integer productId, Integer cartId);

    @Delete("DELETE FROM product_cart\n" +
            "WHERE product_cart_id IN (\n" +
            "    SELECT temp.product_cart_id\n" +
            "    FROM (\n" +
            "             SELECT MIN(pc.product_cart_id) as product_cart_id\n" +
            "             FROM product_cart pc\n" +
            "             GROUP BY pc.cart_id\n" +
            "         ) AS temp\n" +
            ")\n" +
            "and cart_id=#{cartId};")
    Boolean minusProductCart(Integer cartId);

    @Delete("delete from product_cart where cart_id=#{cartId} and product_id=#{productId}")
    Boolean deleteProductCart(@Param("cartId")Integer cartId, @Param("productId")Integer productId);

    @Select("select product_name,product_price,image_url " +
            "from product " +
            "where product_id=#{productId};")
    ProductVo getProductVo(Integer productId);

    @Delete("delete from product_cart where cart_id=#{cartId}")
    void deleteProductCartData(Integer cartId);
}




