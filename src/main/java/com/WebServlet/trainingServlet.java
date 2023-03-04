package com.WebServlet;

import com.JavaBean.training;
import com.Servlet.Personmeservlet;
import com.Servlet.impl.PersonmeservletImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/trainingservlet")
public class trainingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //创建对象，调用方法
        Personmeservlet personmeservlet=new PersonmeservletImpl();
        List<training> selecttraining = personmeservlet.selecttraining();
        //存值转发
        request.setAttribute("train",selecttraining);
        request.getRequestDispatcher("/training.jsp").forward(request,response);
    }
}
