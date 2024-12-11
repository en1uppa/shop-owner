package com.example.controller.user;
import com.example.common.R;
import com.example.entity.Product;
import com.example.entity.User;
import com.example.mapper.SearchMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/user/search")
public class searchController {
    @Autowired
    private SearchMapper searchMapper;
    @GetMapping("/getByProductName")
    public List<Product> getByProductName(@RequestParam(value ="searchTerm") String productName) {
        System.out.println("获取了productName:"+productName);
        return searchMapper.getByProductName(productName);
    }
}

