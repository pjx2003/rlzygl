package com.WebServlet;

import com.JavaBean.person;
import com.Servlet.Personmeservlet;
import com.Servlet.impl.PersonmeservletImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

@WebServlet("/modify1servlet")
public class modify1Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取值
        String id = request.getParameter("id");
        //调用方法
        Personmeservlet p = new PersonmeservletImpl();
        List<person> people = p.modify1(id);
        //存入域中，并进行转发
        request.setAttribute("modify1", people);
        request.getRequestDispatcher("/modify.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        //获取值
        Map<String, String[]> parameterMap = request.getParameterMap();
        //调用方法
        Personmeservlet personmeservlet = new PersonmeservletImpl();
        personmeservlet.modify2(parameterMap);
        //重定向
       response.sendRedirect(request.getContextPath()+"/paginationservlet");
    }
}
