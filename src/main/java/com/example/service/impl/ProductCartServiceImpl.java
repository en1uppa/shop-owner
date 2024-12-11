package com.example.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.entity.ProductCart;
import com.example.mapper.ProductCartMapper;
import com.example.service.ProductCartService;
import org.springframework.stereotype.Service;

/**
* @author testwin1
* @description 针对表【product_cart】的数据库操作Service实现
* @createDate 2024-06-15 23:53:28
*/
@Service
public class ProductCartServiceImpl extends ServiceImpl<ProductCartMapper, ProductCart>
    implements ProductCartService {

}




