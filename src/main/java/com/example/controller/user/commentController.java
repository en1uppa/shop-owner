package com.example.controller.user;


import com.example.DTO.CommentDTO;
import com.example.common.R;
import com.example.entity.Cart;
import com.example.entity.Comment;
import com.example.entity.ProductCart;
import com.example.entity.User;
import com.example.exception.CustomException;
import com.example.mapper.CartMapper;
import com.example.mapper.ProductCartMapper;
import com.example.mapper.ProductMapper;
import com.example.mapper.UserMapper;
import com.example.vo.CartVo;
import com.example.vo.ProductVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.*;

@Slf4j
@Component("userCommentController")
@RestController
@RequestMapping("/user/comment")

public class commentController {


    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/listComment/{product_id}")
    public List<CommentDTO> listComment(@PathVariable("product_id") Integer product_id) {
        List<Comment> CommentList = productMapper.listComment(product_id);

        List<CommentDTO> commentDTOList = new ArrayList<CommentDTO>();

        for (Comment comment : CommentList){
            CommentDTO commentDTO = new CommentDTO();
            commentDTO.setId(comment.getId());
            User user=userMapper.getUserById(comment.getUser_id());
            String userName=user.getUser_name();
            commentDTO.setUser_name(userName);
            commentDTO.setCreatetime(comment.getCreatetime());
            commentDTO.setContent(comment.getContent());
            commentDTOList.add(commentDTO);
    }
        return commentDTOList;
    }

    @PostMapping("/addComment")
    public R<String> addComment(@RequestBody Comment comment) {
        System.out.println("comment = " + comment);
        productMapper.addComment(comment);
        return R.success("评论成功");
    }
}
