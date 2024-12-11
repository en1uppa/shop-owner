package com.example.controller.user;

import com.example.common.R;
import com.example.entity.Order;
import com.example.mapper.OrderMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Slf4j
@RestController
@RequestMapping("/user/payment")
public class paymentController {

    @Autowired
    private OrderMapper orderMapper;
    /**
     *
     * 用户下单
     * @param userId
     * @return
     */
    @GetMapping("/paySuccess/{userId}")
    public String paySuccess(@PathVariable Integer userId) {
        Order order = new Order();
        order.setUser_id(userId);
        order.setCreateTime(String.valueOf(LocalDateTime.now()));
        order.setStatus("已支付,正在等待店主接单...");
        order.setDestination("广州市海珠区仲恺农业工程学院东沙街24号");
        order.setEndTime("订单尚未完成,完成时间未定..");
        orderMapper.add(order);
        return "支付成功";
    }

    //用户支付成功创建订单1, 订单状态为待接单, 管家接单后订单状态为待取货, 用户取货后订单状态为已完成












//    ------------------------功能待开发（可添加可以不用添加）——-------------------------

    /**
     * 支付失败
     * @return
     */
    @GetMapping("/payFail")
    public R<String > payFail() {
        return R.error("支付失败");
    }

    //创建之后没有支付,订单已经创建,只是状态是支付
//    /**
//     * 取消支付
//     * @return
//     */
//    @GetMapping("/cancel/{orderId}")
//    public R<String > cancel(@RequestBody Order order, @PathVariable  Integer orderId) {
//        Order order1 = new Order();
//        BeanUtils.copyProperties(order,order1);
//        order1.setStatus("订单取消");
//        orderMapper.cancel(orderId);
//        return R.success("取消订单成功");
//    }
//
}
