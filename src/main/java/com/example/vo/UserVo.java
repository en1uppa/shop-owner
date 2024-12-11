package com.example.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Accessors(chain = true)
@Data
public class UserVo implements Serializable {

    private String user_name;

    private String tel;

    private String email;
    private static final long serialVersionUID = 1L;
}