package com.example.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.example.entity.Order;
import com.example.vo.OrderVo;
import com.example.vo.ProductVo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
* @author testwin1
* @description 针对表【order】的数据库操作Mapper
* @createDate 2024-06-14 15:14:09
* @Entity generator.domain.Order
*/
public interface OrderMapper extends BaseMapper<Order> {
    @Select("select user.user_name,`order`.order_id,`order`.createTime,`order`.endTime,`order`.destination,`order`.status, `order`.receive_status from user,`order`\n" +
            "            where user.user_id = `order`.user_id")
    List<OrderVo> getUnfinishOrderList();

    @Select("SELECT user.user_name, `order`.order_id, `order`.createTime, `order`.endTime, `order`.destination, `order`.status, `order`.receive_status " +
            "FROM user " +
            "JOIN `order` ON user.user_id = `order`.user_id " +
            "WHERE `order`.status IN ('商家已拒单', '订单完成', '已接单,等待客户收货')")
    List<OrderVo> getFinishOrderList();


    @Insert("insert into `order`(user_id,createTime,endTime,destination,status) values(#{user_id},#{createTime},#{endTime},#{destination},#{status})")
    void add(Order order);

    @Select("select * from `order` where order_id = #{orderId}")
    Order getOrderById(Integer orderId);


    @Update("update `order` set status = #{status},endTime = #{endTime},receive_status=#{receive_status}  where order_id = #{order_id}")
    void updateOrder(Order order);

    @Select("select u.user_name,o.order_id, o.createTime, o.endTime, o.destination, o.status, o.receive_status " +
            "from user u ,`order` o " +
            "where u.user_id=o.user_id " +
            "and o.user_id=#{userId}")
    List<OrderVo> getUserOrder(Integer userId);

    @Delete("delete from `order` where order_id = #{orderId}")
    void deleteOrder(Integer orderId);

    @Select("select user.user_name,`order`.createTime,`order`.endTime,`order`.destination,`order`.status " +
            "from user,`order` " +
            "where user.user_id = `order`.user_id " +
            "and `order`.order_id=#{orderId}")
    OrderVo getUserOrderById(Integer orderId);


    @Update("update `order` set status = #{status},destination=#{destination} where order_id = #{order_id}")
    void updateUserOrder(Order order1);

    @Select("select user.user_name,`order`.createTime,`order`.endTime,`order`.destination,`order`.status " +
            "from user,`order` " +
            "where user.user_id = `order`.user_id " +
            "and `order`.user_id=#{userId}")
    List<OrderVo> getOrderByUserId(Integer userId);

    @Select("select * from `order` where order_id = #{orderId}")
    Order getOrderDetails(Integer orderId);

    @Select("SELECT order_id FROM `order` WHERE user_id = #{userId} ORDER BY order_id DESC LIMIT 1")
    Integer getNewOrderId(Integer userId);

    ProductVo getProductVo1(Integer productId);
}




