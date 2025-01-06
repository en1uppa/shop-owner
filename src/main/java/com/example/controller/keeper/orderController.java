package com.example.controller.keeper;//package com.example.controller;


import com.example.common.R;
import com.example.entity.Order;
import com.example.mapper.OrderMapper;
import com.example.vo.OrderVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@Component("keeperOrderController")
@RequestMapping("/keeper/order")
public class orderController {
    @Autowired(required = false)
    private OrderMapper orderMapper;

    /**
     * 查询待处理订单
     * @return
     */
    @GetMapping("/getUnfinishOrderList")
    public List<OrderVo> getUnfinishOrderList() {
        return orderMapper.getUnfinishOrderList();
    }

    /**
     * 查询已完成的订单
     * @return
     */
    @GetMapping("/getFinishOrderList")
    public List<OrderVo> getFinishOrderList() {
        return orderMapper.getFinishOrderList();
    }

    /**
     *通过userId查询指定用户订单
     * @param userId
     * @return
     */
    @GetMapping("/getByUserId/{userId}")
    public List<OrderVo> getUserOrderForKeeper(@PathVariable Integer userId) {
        return orderMapper.getOrderByUserId(userId);
    }

    /**
     * 通过orderId查询指定用户订单
     * @param orderId
     * @return
     */
    @GetMapping("/getByOrderId/{orderId}")
    public OrderVo getOrderById(@PathVariable Integer orderId) {
        return orderMapper.getUserOrderById(orderId);
    }

    //用户支付成功创建订单, 订单状态为待接单, 管家接单后订单状态为待取货, 用户取货后订单状态为已完成
    /**
     * 店家接单
     * @param orderId
     * @return
     */
    @GetMapping("/acceptOrder/{orderId}")
    public R<String> acceptOrder(@PathVariable Integer orderId) {
        Order order = orderMapper.getOrderById(orderId);
        order.setEndTime("等待客户接收");
        order.setStatus("已接单,等待客户收货");
        orderMapper.updateOrder(order);
        return R.success("接单成功，等待客户接收");
    }




    /**
     * 店家拒单
     * @param orderId
     * @return
     */
    @GetMapping("/rejectOrder/{orderId}")
    public R<String> rejectOrder(@PathVariable Integer orderId) {
        Order order = orderMapper.getOrderById(orderId);
        order.setEndTime(String.valueOf(LocalDateTime.now()));
        order.setStatus("商家已拒单");
        orderMapper.updateOrder(order);
        return R.success("拒单成功");
    }
}
