package com.example.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.example.entity.Keeper;
import com.example.vo.KeeperVo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

/**
* @author testwin1
* @description 针对表【keeper】的数据库操作Mapper
* @createDate 2024-06-14 15:14:09
* @Entity generator.domain.Keeper
*/
public interface KeeperMapper extends BaseMapper<Keeper> {

    @Select("select * from keeper")
    Keeper getKeeperForKeeper();

    @Select("select keeper_name,tel,email,status from keeper")
    KeeperVo getKeeperForUser();

    @Update("update keeper set keeper_name = #{keeper_name},password = #{password},tel = #{tel},email = #{email},status =#{status} where keeper_id = 1")
    void updateKeeper(Keeper keeper);

    @Select("select keeper_id from keeper where keeper_name = #{keeper_name}")
    Integer login(Keeper keeper);

}




