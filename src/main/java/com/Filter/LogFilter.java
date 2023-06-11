package com.Filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*")
public class LogFilter implements Filter {
    //初始(未使用)
    public void init(FilterConfig config) throws ServletException {
    }

    //销毁(未使用)
    public void destroy() {
    }

    //过滤器
    @Override
    public void doFilter(ServletRequest reques1, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        //强转请求
        HttpServletRequest request = (HttpServletRequest) reques1;
        //获取资源请求路径
        String uri = request.getRequestURI();
        if (uri.contains("/index.jsp") || uri.contains("/indexservlet") || uri.contains("/bootstrap/css/") || uri.contains("/bootstrap/js/") || uri.contains("/bootstrap/image/") || uri.contains("/forget.jsp") || uri.contains("/forgetservlet")) {
            //证明用户想登录,放行
            //放行
            chain.doFilter(reques1, response);
        } else {
            //不包含
            //获取user,判断是否包含用户
            Object um = request.getSession().getAttribute("um");
            if (um != null) {
                //放行
                chain.doFilter(reques1, response);
            } else {
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            }
        }
    }
}
