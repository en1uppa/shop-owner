package com.example.vo;


import lombok.Data;
import lombok.experimental.Accessors;
import java.util.Date;

/**
 * 返回订单对象封装
 */

@Data
@Accessors(chain = true)
public class OrderVo{
    private Integer order_id;

//    private Integer user_id;

    private String user_name;

    private String createTime;

    private String endTime;

    private String destination;

    private String status;

    private String receive_status;

    private static final long serialVersionUID = 1L;
}
