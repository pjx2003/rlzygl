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
import java.util.Map;

@WebServlet("/registerservlet")
public class registerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        //获取所有值
        Map<String, String[]> parameterMap = request.getParameterMap();
        //调用方法
        Personmeservlet personmeservlet = new PersonmeservletImpl();
        int add = personmeservlet.add(parameterMap);
        if (add == 0) {
            //注册失败
            request.setAttribute("error", "注册失败,请检查内容的完整和正确");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
        } else {
            //注册成功
            response.sendRedirect(request.getContextPath()+"/paginationservlet");
        }

    }
}
