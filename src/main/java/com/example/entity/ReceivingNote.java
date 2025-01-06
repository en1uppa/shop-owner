package com.example.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.io.Serializable;
@TableName(value ="receiving_note")
@Data
public class ReceivingNote implements Serializable{
    private int user_id;          // 用户 ID

    private int order_id;       // 订单 ID

    private String receive_status; // 接收状态

    private String comment_status; // 评论状态

    private static final long serialVersionUID = 1L;
}
