package com.Dao.impl;

import com.DBUtil.JDBCUtils;
import com.Dao.PersonmeDao;
import com.JavaBean.person;
import com.JavaBean.training;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class personmeDaoImpl implements PersonmeDao {
    //创建jdbc连接对象
    JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    //登录实现方法
    @Override
    public person log(String username, String password) {
        try {
            //创建语句
            String sql = "select * from logon where username= ? and password= ? ;";
            //建立查询
            person person = template.queryForObject(sql, new BeanPropertyRowMapper<>(person.class), username, password);
            return person;
        } catch (Exception e) {
            return null;
        }
    }

    //忘记密码实现方法
    @Override
    public int forgets(String username, String password) {
        //创建sql语句
        String sql = "update logon set password = ? where username = ? ;";
        int update = template.update(sql, password, username);
        return update;
    }

    //查询管理员实现方法
    @Override
    public List<person> selectnetwork() {
        //sql语句
        String sql = "select * from logon ; ";
        List<person> query = template.query(sql, new BeanPropertyRowMapper<>(person.class));
        return query;
    }

    //查询搜索接口实现方法
    @Override
    public List<person> selectserch(Map<String, String[]> parameterMap, int nowPageCount, int pageShowrow) {
        String sql = "select * from person where 1 = 1 ";
        StringBuilder sb = new StringBuilder(sql);
        List<Object> list = new ArrayList<Object>();
        //遍历map
        Set<String> keySet = parameterMap.keySet();
        //定义一个参数的集合
        List<Object> params = new ArrayList<Object>();
        for (String key : keySet) {
            //排除分页条件参数
            if ("nowPageCount".equals(key) || "pageShowrow".equals(key)) {
                continue;
            }
            //获取value
            String value = parameterMap.get(key)[0];
            //判断value是否有值
            if (value != null && !"".equals(value)) {
                //有值
                sb.append(" and " + key + " like ? ");
                params.add("%"+value+"%");//条件的值
            }
        }
        //添加分页查询
        sb.append("limit ?,? ");
        //添加分页查询参数值
        params.add(nowPageCount);
        params.add(pageShowrow);
        List<person> query = template.query(sb.toString(), new BeanPropertyRowMapper<person>(person.class), params.toArray());
        return query;

    }

    //查总记录方法的实现
    @Override
    public int findTotalCouunt(Map<String, String[]> parameterMap) {
        //动态sql
        //编写sql
        String sql="select count(*) from person where 1=1 ";
        //创建StringBuilder对象
        StringBuilder sb=new StringBuilder(sql);
        List<Object> list=new ArrayList<Object>();
        //获取键值
        Set<String> strings = parameterMap.keySet();
        for (String key : strings) {
            if ("nowPageCount".equals(key) || "pageShowrow".equals(key)) {
                continue;
            }
            String value = parameterMap.get(key)[0];
            //判断值是否为空
            if(value != null && !"".equals(value)){
                sb.append(" and " + key + " like ? ");
                list.add("%"+value+"%");//条件的值
            }
        }
        return template.queryForObject(sb.toString(),Integer.class,list.toArray());
    }

    //注册员工方法实现
    @Override
    public int add(person person) {
        //编写sql语句
        try {
            String sql = "insert into person (username,password,gender,age,department,phone ) values ( ?,?,?,?,?,? ) ; ";
            int update = template.update(sql, person.getUsername(), person.getPassword(), person.getGender(), person.getAge(), person.getDepartment(), person.getPhone());
            return update;
        } catch (Exception e) {
            return 0;
        }
    }

    //修改员工1方法实现
    @Override
    public List<person> modify1(String id) {
        //编写语句
        String sql = "select * from person where id = ? ; ";
        List<person> query = template.query(sql, new BeanPropertyRowMapper<person>(person.class), id);
        return query;
    }

    //修改员工2方法实现
    @Override
    public int modify2(person p) {
        //编写sql语句
        String sql = "update person set username = ? ,password = ? ,gender = ? ,age = ? ,phone = ?  where id = ? ;";
        int update = template.update(sql, p.getUsername(), p.getPassword(), p.getGender(), p.getAge(), p.getPhone(), p.getId());
        return update;
    }

    //删除员工方法实现
    @Override
    public void delete(String id) {
        //编写语句
        String sql = "delete from person where id = ? ;";
        template.update(sql, id);
    }

    //查询培训机构方法实现
    @Override
    public List<training> selecttraining() {
        //编写sql
        String sql = "select * from training ;";
        List<training> query = template.query(sql, new BeanPropertyRowMapper<>(training.class));
        return query;
    }
}
