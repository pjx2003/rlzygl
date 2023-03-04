package com.Servlet.impl;

import com.Dao.PersonmeDao;
import com.Dao.impl.personmeDaoImpl;
import com.JavaBean.pagination;
import com.JavaBean.person;
import com.JavaBean.training;
import com.Servlet.Personmeservlet;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

public class PersonmeservletImpl implements Personmeservlet {
    //登录方法实现
    @Override
    public Object log(String username, String password) {
        //判断用户名或者密码是否为空
        if ((username == null || "".equals(username)) && (password == null || "".equals(password))) {
            return "用户名为或密码为空";
        } else {
            PersonmeDao p = new personmeDaoImpl();
            person log = p.log(username, password);
            if (log != null) {
                //判断是否登录成功
                //存入实体类
                person aaa = new person();
                aaa.setUsername(username);
                return aaa;
            } else {
                //登录失败
                return "用户名或者密码错误";
            }
        }
    }

    //忘记密码方法实现
    @Override
    public Object forgets(String username, String password, String againpassword) {
        //判断用户名或者密码是否为空
        if (username == null || "".equals(username) || password == null || "".equals(password) || password == null) {
            return "用户名或密码为空";
        } else {
            //判断两次输入的密码
            if (password.equals(againpassword)) {
                PersonmeDao forge = new personmeDaoImpl();
                int forgets = forge.forgets(username, password);
                //判断是否存在改用户
                if (forgets > 0) {
                    return forgets;
                } else {
                    return "不存在该用户";
                }
            } else {
                return "两次输入密码不一致";
            }
        }
    }

    //查询管理员方法的实现
    @Override
    public List<person> selectnetwork() {
        PersonmeDao personmeDao = new personmeDaoImpl();
        return personmeDao.selectnetwork();
    }

    //分页接口方法实现
    @Override
    public pagination<person> pagination(String nowPageCount, String pageShowrow,Map<String, String[]> parameterMap) {
        //判断参数是否为空
        if (("".equals(nowPageCount) || nowPageCount == null) & ("".equals(pageShowrow) || pageShowrow == null)) {
            nowPageCount = "1";
            pageShowrow = "5";
        }
        //创建对象
        pagination<person> pb = new pagination<person>();
        //设置参数并进行转换
        int nowpagecount = Integer.parseInt(nowPageCount);
        int pageshowrow = Integer.parseInt(pageShowrow);

        pb.setNowPageCount(nowpagecount);
        pb.setPageShowrow(pageshowrow);

        //调用方法查总记录数
        PersonmeDao personmeDao = new personmeDaoImpl();
        int pageCount = personmeDao.findTotalCouunt(parameterMap);
        pb.setPageCount(pageCount);
        //调用方法查询集合
        int start = (nowpagecount - 1) * pageshowrow;
        List<person> listlimt = personmeDao.selectserch(parameterMap,start, pageshowrow);
        pb.setPageShow(listlimt);
        //计算总页码
        int pagePageCount = pageCount % pageshowrow == 0 ? pageCount / pageshowrow : (pageCount / pageshowrow) + 1;
        pb.setPagePageCount(pagePageCount);
        return pb;
    }

    //注册员工接口方法实现
    @Override
    public int add(Map<String, String[]> p1) {
        //创建实体类对象
        person p = new person();
        int add;
        try {
            //封装并保存到实体类
            BeanUtils.populate(p, p1);
            //判断是否含有空值
            if ("".equals(p.getUsername()) || "".equals(p.getPassword()) || "".equals(p.getDepartment())
                    || "".equals(p.getGender()) || "".equals(p.getPhone()) || String.valueOf(p.getAge())
                    .equals("")) {
                int i = 10 / 0;
            }
            //调用方法
            PersonmeDao personmeDao = new personmeDaoImpl();
            add = personmeDao.add(p);
        } catch (Exception e) {
            return 0;
        }
        return add;
    }

    //修改员工接口1方法实现
    @Override
    public List<person> modify1(String id) {
        PersonmeDao personmeDao = new personmeDaoImpl();
        List<person> people = personmeDao.modify1(id);
        return people;
    }

    //修改员工接口2方法实现
    @Override
    public void modify2(Map<String, String[]> m) {
        //创建对象
        person p = new person();
        //封装内容
        try {
            BeanUtils.populate(p, m);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //调用方法
        PersonmeDao personmeDao = new personmeDaoImpl();
        personmeDao.modify2(p);
    }

    //删除员工接口方法实现
    @Override
    public void delete(String id) {
        PersonmeDao personmeDao = new personmeDaoImpl();
        personmeDao.delete(id);
    }


    //查询培训机构接口方法实现
    @Override
    public List<training> selecttraining() {
        PersonmeDao personmeDao = new personmeDaoImpl();
        List<training> selecttraining = personmeDao.selecttraining();
        return selecttraining;
    }

}
