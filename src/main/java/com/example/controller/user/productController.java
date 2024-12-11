package com.example.controller.user;


import com.example.entity.Product;
import com.example.mapper.ProductMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@Component("userProductController")
@RequestMapping("/user/product")
public class productController {
    @Autowired
    private ProductMapper productMapper;

    /**
     * 获取所有商品信息
     * @param
     * @param
     * @param
     * @return
     */
    @GetMapping("/list")
    public List<Product>list() {
        log.info("list:{}",productMapper.list());
        return productMapper.list();
    }

    /**
     * 通过商品id查询商品信息
     * @return
     */
    @GetMapping("/getById/{productId}")
    public Product getById(@PathVariable Integer productId) {
        log.info("该商品:{}", productMapper.getByProductId(productId));
        return productMapper.getByProductId(productId);
    }
}

