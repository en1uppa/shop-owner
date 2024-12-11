package com.example.controller.user;
import com.example.common.R;
import com.example.entity.Order;
import com.example.mapper.OrderMapper;
import com.example.vo.OrderVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;

@Slf4j
@Component("userOrderController")
@RestController
@RequestMapping("/user/order")
public class orderController {
    @Autowired(required = false)
    private OrderMapper orderMapper;

    //支付成功的同时创建好订单,在paymentController中实现

    //用户支付成功创建订单, 订单状态为待接单, 管家接单后订单状态为待取货, 用户取货后订单状态为已完成

//    /**
//     * 订单已完成(用户取货后)
//     * @param orderId
//     * @return
//     */
//    @GetMapping("/getProduct/{orderId}")
//    public R<String> getProduct(@PathVariable Integer orderId) {
//        Order order = orderMapper.getOrderById(orderId);
//        order.setEndTime(String.valueOf(LocalTime.now()));
//        order.setStatus("已收货,订单已完成!");
//        orderMapper.updateOrder(order);
//        return R.success("订单已完成");
//    }


    @GetMapping("/getOrderId/{userId}")
    public Integer getOrderId(@PathVariable  Integer userId) {
        System.out.println("后台:userId:"+userId);
        return orderMapper.getOrderId(userId);
    }

    /**
     * 用户查询自己的个人详细订单
     * @return
     */
    @GetMapping("/getOrderDetails/{orderId}")
    public Order getOrderDetails(@PathVariable  Integer orderId) {
        return orderMapper.getOrderDetails(orderId);
    }



    /**
     * 用户查询自己的个人的历史订单
     * @param userId
     * @return
     */
    @GetMapping("/getOrderHistory/{userId}")
    public List<OrderVo> getOrderHistory(@PathVariable  Integer userId) {
        List<OrderVo> orders = orderMapper.getUserOrder(userId);
        System.out.println("传入后端userID:"+userId);
        System.out.println("orders: "+orders);
        return orders;
    }


    /**
     * 修改订单
     * @param order
     * @return
     */
    @PutMapping("/update")
    public R<String> updateOrder(@RequestBody Order order) {
        Order order1=new Order();
        BeanUtils.copyProperties(order,order1);
//        System.out.println("原状态"+order.getStatus());
        orderMapper.updateUserOrder(order1);
        return R.success("修改订单成功");
    }


    /**
     * 删除订单
     * @param orderId
     * @return
     */
    @DeleteMapping("/deleteOrderByUser/{orderId}")
    public String deleteOrder(@PathVariable Integer orderId) {
        orderMapper.deleteOrder(orderId);
        return "删除订单成功";
    }
}

