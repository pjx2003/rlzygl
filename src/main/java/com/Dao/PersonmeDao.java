package com.Dao;

import com.JavaBean.person;
import com.JavaBean.training;

import java.util.List;
import java.util.Map;

public interface PersonmeDao {
    //登录接口
    person log(String username, String password);

    //忘记密码接口
    int forgets(String username, String password);

    //查询管理员接口
    List<person> selectnetwork();

    //查询搜索结果接口
    List<person> selectserch(Map<String, String[]> parameterMap, int nowPageCount, int pageShowrow);

    //查询培训机构接口
    List<training> selecttraining();

    //注册员工接口
    int add(person person);

    //修改员工1接口
    List<person> modify1(String id);

    ///修改员工2接口
    int modify2(person p);

    //删除员工接口
    void delete(String id);

    //查总记录数接口
    int findTotalCouunt(Map<String, String[]> parameterMap);

}
