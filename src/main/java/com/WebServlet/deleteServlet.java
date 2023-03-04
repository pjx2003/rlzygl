package com.WebServlet;

import com.Servlet.Personmeservlet;
import com.Servlet.impl.PersonmeservletImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/deleteservlet")
public class deleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取id
        String id = request.getParameter("id");
        //调用方法
        Personmeservlet personmeservlet=new PersonmeservletImpl();
        personmeservlet.delete(id);
        //重定向
        response.sendRedirect(request.getContextPath()+"/paginationservlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
