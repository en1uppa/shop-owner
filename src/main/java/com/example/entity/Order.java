package com.example.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

/**
 * @TableName order
 */
@TableName(value ="order")
@Data
public class Order implements Serializable {
    private Integer order_id;

    private Integer user_id;

    private String createTime;

    private String endTime;

    private String destination;

    private String status;

    private String receive_status;

    private static final long serialVersionUID = 1L;
}