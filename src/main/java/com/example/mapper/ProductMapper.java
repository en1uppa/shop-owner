package com.example.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.example.entity.Comment;
import com.example.entity.Order;
import com.example.entity.Product;
import com.example.vo.ProductVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
* @author testwin1
* @description 针对表【product】的数据库操作Mapper
* @createDate 2024-06-14 15:14:09
* @Entity generator.domain.Product
*/
public interface ProductMapper extends BaseMapper<Product> {
    @Select("select * from `product`")
    List<Product> list();

    @Select("select * from `product` where product_id = #{id}")
    Product getByProductId(long id);

    @Insert("insert into `product` (product_name, product_price, product_num, description, image_url, product_type) values (#{product_name}, #{product_price}, #{product_num}, #{description}, #{image_url}, #{product_type})")
    int addProduct(Product product);

    @Update("update `product` set product_name = #{product_name},product_price = #{product_price},product_num = #{product_num},description=#{description},image_url=#{image_url},product_type=#{product_type} where product_id=#{product_id}")
    int updateProduct(Product product);


    @Select("select product_price from `product` where product_id = #{product_id}")
    BigDecimal getPriceByProductId(Integer product_id);

    @Select("select product_name from `product` where product_id = #{product_id}")
    String getProductNameByProductId(Integer product_id);

    @Select("select image_url from `product` where product_id = #{product_id}")
    String getImgByProductId(Integer product_id);

    @Select("select * from `comment` where product_id = #{product_id}")
    List<Comment> listComment(Integer productId);

    @Insert("insert into `comment` (product_id, user_id, content) values (#{product_id}, #{user_id}, #{content})")
    void addComment(Comment comment);
}




