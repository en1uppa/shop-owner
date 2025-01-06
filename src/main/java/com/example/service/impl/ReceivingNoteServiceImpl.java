package com.example.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.entity.ReceivingNote;
import com.example.mapper.ReceivingNoteMapper;
import org.springframework.stereotype.Service;

@Service
public class ReceivingNoteServiceImpl extends ServiceImpl<ReceivingNoteMapper, ReceivingNote>
        implements com.example.service.ReceivingNoteService {

}
