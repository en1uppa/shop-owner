package com.example.service.impl;

import com.example.entity.Keeper;
import com.example.mapper.KeeperMapper;
import com.example.service.KeeperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.util.List;

/**
* @author testwin1
* @description 针对表【keeper】的数据库操作Service实现
* @createDate 2024-06-14 15:23:02
*/
@Service
public class KeeperServiceImpl extends ServiceImpl<KeeperMapper, Keeper>
    implements KeeperService {
}






