package com.example.servlet;


import org.springframework.http.HttpRequest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/servletTest")
public class ServleTest extends HttpServlet {
    /**
     * get方法测试
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        get方法调用后打印在idea控制台
        System.out.println("get..");
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        post方法调用后打印在idea控制台
        System.out.println("post..");
        String name=req.getParameter("name");//单个参数
        String ps=req.getParameter("password");
        System.out.println("name = " + name);
        System.out.println("ps = " + ps);
    }
}
