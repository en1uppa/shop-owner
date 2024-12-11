package com.example.mapper;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import com.example.DTO.UserDTO;
import com.example.entity.User;
import com.example.vo.UserVo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

/**
* @author testwin1
* @description 针对表【user】的数据库操作Mapper
* @createDate 2024-06-14 15:14:09
* @Entity generator.domain.User
*/
public interface UserMapper extends BaseMapper<User> {
    /**
     * 查询所有用户
     * @return
     */
    @Select("select user_name,tel,email from `user`")
    List<UserVo> list();

    /**
     * 通过id查询
     * @param id
     * @return
     */
    @Select("select * from user where user_id = #{id}")
    User getById(Integer id);

    /**
     * 登录
     * @return
     */
    @Select("select user_id from user where user_name = #{user_name} and password = #{password}")
    Integer login(User user);

    /**
     * 注册添加
     */
    @Select("insert into user(user_name,password,tel,email) values(#{user_name},#{password},#{tel},#{email})")
    void add(User user);


    //    ----------------以上是店家接口------------------------

    @Select("select * from user where user_id = #{id}")
    User getUserById(Integer id);

    @Update("update user set user_name = #{user_name}, password = #{password}, tel = #{tel}, email = #{email} where user_id =#{user_id}")
    void updateUserById(User user);

    @Delete("delete from user where user_id = #{id}")
    void deleteUserById(Integer id);
}




