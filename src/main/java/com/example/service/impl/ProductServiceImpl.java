package com.example.service.impl;

import com.example.entity.Product;
import com.example.mapper.ProductMapper;
import com.example.service.ProductService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
/**
* @author testwin1
* @description 针对表【product】的数据库操作Service实现
* @createDate 2024-06-14 15:23:01
*/
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product>
    implements ProductService{

}




