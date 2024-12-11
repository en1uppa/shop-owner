package com.example.controller.keeper;

import com.example.common.R;
import com.example.entity.User;
import com.example.mapper.UserMapper;
import com.example.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@Component("keeperUserController")
@RequestMapping("/keeper/user")
public class userController {
    @Autowired
    private UserMapper userMapper;

    /**
     * 查询所有用户的信息
     * @return
     */
    @GetMapping("/list")
    public List<UserVo> list() {
        return userMapper.list();
    }
}

