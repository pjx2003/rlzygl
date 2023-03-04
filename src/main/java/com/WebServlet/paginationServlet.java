package com.WebServlet;

import com.JavaBean.pagination;
import com.JavaBean.person;
import com.Servlet.Personmeservlet;
import com.Servlet.impl.PersonmeservletImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Map;

@WebServlet("/paginationservlet")
public class paginationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //获取当前页码和每页显示条数
        String nowPageCount = request.getParameter("nowPageCount");
        String pageShowrow = request.getParameter("pageShowrow");
        Map<String, String[]> parameterMap = request.getParameterMap();
        //调用方法
        Personmeservlet p=new PersonmeservletImpl();
        pagination<person> p1=p.pagination(nowPageCount,pageShowrow,parameterMap);

        //存域转发
        request.setAttribute("pg",p1);
        request.setAttribute("pg1",parameterMap);
        request.getRequestDispatcher("/worker.jsp").forward(request,response);

    }
}
