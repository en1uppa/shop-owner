package com.example.DTO;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @TableName keeper
 */
@TableName(value ="comment")
@Data

public class CommentDTO implements Serializable{
    private Integer id;

    private String user_name;

    private Integer product_id;

    private String createtime;

    private String content;

    private static final long serialVersionUID = 1L;
}
