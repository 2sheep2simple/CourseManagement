package com.course.util;

import com.course.domain.*;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class lxSqlUtil {
    QueryRunner qr = new QueryRunner(C3P0Util.dataSource);

    public List<Department> select(String sql) {
        try {
            return qr.query(sql, new BeanListHandler<Department>(Department.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<User> select3(String sql) {
        try {
            return qr.query(sql, new BeanListHandler<User>(User.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<Major> select1(String sql) {
        try {
            return qr.query(sql, new BeanListHandler<Major>(Major.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<Clas> select2(String sql) {
        try {
            return qr.query(sql, new BeanListHandler<Clas>(Clas.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int delete(String sql){
        try {
            return qr.update(sql);//成功则返回1

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return 0;
    }

    public int add(Object []params,String sql){

        try {
            return qr.update(sql, params);

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return 0;
    }

    public int update(Object []params,String sql){
        try {
            return qr.update(sql, params);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return 0;
    }
}
