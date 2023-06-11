package com.Servlet;


import com.JavaBean.pagination;
import com.JavaBean.person;
import com.JavaBean.training;

import java.util.List;
import java.util.Map;

public interface Personmeservlet {
    //登录方法接口
    Object log(String username, String password);

    //忘记密码接口
    Object forgets(String username, String password, String againpassword);

    //查询管理员接口
    List<person> selectnetwork();


    //查询培训机构接口
    List<training> selecttraining();

    //注册员工接口
    int add(Map<String, String[]> p);

    //修改员工接口1
    List<person> modify1(String id);

    //修改员工接口2
    void modify2(Map<String, String[]> m);

    //删除员工接口
    void delete(String id);

    //分页接口
    pagination<person> pagination(String nowPageCount, String pageShowrow, Map<String, String[]> parameterMap);

}
