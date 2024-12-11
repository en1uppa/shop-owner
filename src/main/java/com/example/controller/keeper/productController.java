package com.example.controller.keeper;


import com.example.common.R;
import com.example.entity.Product;
import com.example.mapper.ProductMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Component("keeperProductController")
@RestController
@RequestMapping("/keeper/product")
public class productController {
    @Autowired
    private ProductMapper productMapper;

    /**
     * 添加商品
     * @param product
     * @return
     */
    @PostMapping("/add")
    public int add(@RequestBody Product product) {
        Product product1 = new Product();
        BeanUtils.copyProperties(product, product1);
        productMapper.addProduct(product1);
        return 1;
    }

    /**
     *  查询所有商品
     * @return
     */
    @GetMapping("/list")
    public List<Product>list() {
        log.info("list:{}",productMapper.list());
        return productMapper.list();
    }

    /**
     * 根据id查询商品
     * @return
     */
    @GetMapping("/getById/{productId}")
    public Product getById(@PathVariable Integer productId) {
        log.info("该商品:{}", productMapper.getByProductId(productId));
        return productMapper.getByProductId(productId);
    }

    /**
     *  修改商品信息
     * @param product
     * @return
     */
    @PutMapping("/update")
    public void update(@RequestBody Product product) {
        System.out.println("参数:"+product);
        Product product1 = new Product();
        BeanUtils.copyProperties(product, product1);
        System.out.println("product1:"+product1);
        productMapper.updateProduct(product1);
    }
}

