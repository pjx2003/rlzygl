package com.WebServlet;

import com.JavaBean.person;
import com.Servlet.Personmeservlet;
import com.Servlet.impl.PersonmeservletImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/indexservlet")
public class indexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码，获取值
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //调方法，获取值，转发
        Personmeservlet log = new PersonmeservletImpl();
        Object log1 = log.log(username, password);

        //判断返回值是否包含字符串
        if (log1 instanceof String) {
            request.setAttribute("usernull", log1);
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } else {
            //存入session转发
            HttpSession session = request.getSession();
            session.setAttribute("um", log1);
            request.getRequestDispatcher("/home.jsp").forward(request, response);
        }

    }
}
