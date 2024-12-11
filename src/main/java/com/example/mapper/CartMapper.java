package com.example.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.example.entity.Cart;
import com.example.vo.CartVo;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
* @author testwin1
* @description 针对表【cart】的数据库操作Mapper
* @createDate 2024-06-14 15:14:09
* @Entity generator.domain.Cart
*/
public interface CartMapper extends BaseMapper<Cart> {
    @Select("select * from cart where cart_id = #{cart_id}")
    CartVo getUserCartVo(@Param("cart_id")Integer cart_id);

















    //通过cart_id获取用户购买的商品
    @Select("select cart_id from cart where user_id = #{user_id}")
    Integer getCartID(@Param("user_id")Integer user_id);

    @Select("select * from cart where user_id = #{user_id}")
    Cart getUserCart(@Param("user_id")Integer user_id);

    @Insert("insert into cart (user_id) values (#{user_id})")
    void addCart(Cart cart);

    @Update("update cart set user_id = #{user_id},total_price = #{total_price},status = #{status} where user_id=#{user_id}")
    void updateCart(Cart cart);

    @Delete("delete from cart where cart_id = #{cartId}")
    void deleteCart(Integer cartId);
}




