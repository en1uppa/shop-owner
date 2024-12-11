package com.example.mapper;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.example.entity.Product;
import com.example.entity.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SearchMapper extends BaseMapper<Product> {
    @Select("select * from product where product_name like concat('%',#{productName},'%')")
    List<Product> getByProductName(String productName);
}




