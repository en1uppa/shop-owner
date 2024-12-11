package com.example.controller.user;

import com.example.DTO.UserDTO;
import com.example.common.R;
import com.example.entity.User;
import com.example.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@Component("userUserController")
@RequestMapping("/user/user")
public class userController {
    @Autowired
    private UserMapper userMapper;

    /**
     * 注册
     * @param user
     * @return
     */
    @PostMapping("/register")
    public R<User> add(@RequestBody User user) {
        User user1= new User();
        BeanUtils.copyProperties(user,user1);
        userMapper.add(user1);
        return R.success(user1);
    }

    /**
     * 登录
     * @param user
     * @return
     */
    @PostMapping("/login")
    public Integer login(@RequestBody User user) {
        User user1=new User();
        user1.setUser_name(user.getUser_name());
        user1.setPassword(user.getPassword());
        //查询不到,设置为0
        if (userMapper.login(user1) == null) {
            return 0;
        }else{
            return userMapper.login(user1);
        }
    }



    /**
     * 通过id获取个人信息
     * @return
     */
    @GetMapping("/getById/{userId}")
    public User getById(@PathVariable Integer userId) {
        log.info("getUser:{}",userMapper.getUserById(userId));
        return userMapper.getUserById(userId);
    }

    /**
     *  更新个人信息
     * @param user
     * @return
     */
    @PutMapping("/update/{userId}")
    public R<String> update(@RequestBody User user,@PathVariable Integer userId) {
        User user1=userMapper.getUserById(userId);
        BeanUtils.copyProperties(user, user1);
        user1.setUser_id(userId);
        userMapper.updateUserById(user1);
        return R.success("修改个人信息成功");
    }

    /**
     * 删除个人信息
     * @return
     */
    @DeleteMapping("delete/{userId}")
    public R<String> delete(@PathVariable Integer userId) {
        userMapper.deleteUserById(userId);
        return R.success("注销成功");
    }


}

