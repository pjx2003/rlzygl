package com.Dao;

import com.JavaBean.person;
import com.JavaBean.training;

import java.util.List;
import java.util.Map;

public interface PersonmeDao {
    //登录接口
    public person log(String username,String password);

    //忘记密码接口
    public int forgets(String username,String password);


    //查询管理员接口
    public List<person> selectnetwork();

    //查询搜索结果接口
    public List<person> selectserch(Map<String, String[]> parameterMap, int nowPageCount, int pageShowrow);

    //查询培训机构接口
    public List<training> selecttraining();

    //注册员工接口
    public int add(person person);

    //修改员工1接口
    public List<person> modify1(String id);

    ///修改员工2接口
    public int modify2(person p);

    //删除员工接口
    public void delete(String id);

    //查总记录数接口
    public int findTotalCouunt(Map<String, String[]> parameterMap);

}
