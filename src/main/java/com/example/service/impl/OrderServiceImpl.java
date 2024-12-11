package com.example.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.entity.Order;
import com.example.mapper.OrderMapper;
import com.example.service.OrderService;
import org.springframework.stereotype.Service;

/**
* @author testwin1
* @description 针对表【order】的数据库操作Service实现
* @createDate 2024-06-14 15:23:01
*/
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order>
    implements OrderService {

}




