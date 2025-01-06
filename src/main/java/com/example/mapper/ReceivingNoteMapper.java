package com.example.mapper;
import com.example.common.R;
import com.example.entity.ReceivingNote;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.example.entity.Order;

import org.apache.ibatis.annotations.Insert;

public interface ReceivingNoteMapper extends BaseMapper<ReceivingNote> {
    @Insert("INSERT INTO `receiving_note` (user_id, order_id, receive_status,comment_status) VALUES (#{user_id}, #{order_id}, #{receive_status},#{comment_status})")
    void add(ReceivingNote receivingNote);
}
