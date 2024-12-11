package com.example.exception;


import com.example.common.R;
import com.example.exception.CustomException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLIntegrityConstraintViolationException;

/**
 * 定义异常处理器
 */

@ControllerAdvice(annotations = {RestController.class, Controller.class})//拦截加了RestController,Controller注解的类
@ResponseBody //作为响应体
@Slf4j
public class GlobalExceptionHandler {
    /**
     * 异常处理方法
     * @param ex
     * @return
     */
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public R<String> exceptionHandler(SQLIntegrityConstraintViolationException ex){
        log.error(ex.getMessage());//用于控制台报红色ERROR信息
        if (ex.getMessage().contains("Duplicate entry")){//用于判断getMessage里是否包含Duplicate entry,
            String [] split = ex.getMessage().split(" ");//用于将getMessage里的内容以空格分隔开来成数组
            String msg =split[2]+"已存在";//数组索引2是字符串: zhangsan ==>源异常句子:Duplicate entry zhangsan for key'idx_username
            return R.error(msg);
        }
        return R.error("失败了");//给前端的响应
    }


    //进行异常处理方法
    @ExceptionHandler(CustomException.class)
    public R<String >exceptionHandler(CustomException ex){
        log.error(ex.getMessage());
        return R.error(ex.getMessage());
    }
}
