package com.WebServlet;

import com.Servlet.Personmeservlet;
import com.Servlet.impl.PersonmeservletImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/forgetservlet")
public class forgetServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        //获取值
        String nwname = request.getParameter("newusername");
        String nwpass = request.getParameter("newpassword");
        String againpass = request.getParameter("againpass");

        //调用方法
        Personmeservlet personmeservlet=new PersonmeservletImpl();
        Object forgets = personmeservlet.forgets(nwname, nwpass, againpass);

        //判断是否含有字符串
        if(forgets instanceof String){
            request.setAttribute("nullzhi", forgets);
            request.getRequestDispatcher("/forget.jsp").forward(request, response);
        }else {
            request.setAttribute("usernull","密码修改成功");
            request.getRequestDispatcher("/index.jsp").forward(request,response);
        }

    }
}
