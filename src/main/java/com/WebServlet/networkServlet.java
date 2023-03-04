package com.WebServlet;

import com.JavaBean.person;
import com.Servlet.Personmeservlet;
import com.Servlet.impl.PersonmeservletImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/networkservlet")
public class networkServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Personmeservlet personmeservlet=new PersonmeservletImpl();
        List<person> selectnetwork = personmeservlet.selectnetwork();
        //转发
        request.setAttribute("user",selectnetwork);
        request.getRequestDispatcher("/network.jsp").forward(request,response);
    }
}
