package com.example.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.entity.Cart;
import com.example.mapper.CartMapper;
import com.example.service.CartService;
import org.springframework.stereotype.Service;

/**
* @author testwin1
* @description 针对表【cart】的数据库操作Service实现
* @createDate 2024-06-14 15:23:02
*/
@Service
public class CartServiceImpl extends ServiceImpl<CartMapper, Cart>
    implements CartService {

}




