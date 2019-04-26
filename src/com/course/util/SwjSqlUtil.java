package com.course.util;

import com.course.domain.Course;
import com.course.domain.Student;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

public class SwjSqlUtil {
	
    QueryRunner qr = new QueryRunner(C3P0Util.dataSource);

	public List<Course> select(String sql) {
        try {
            return  qr.query(sql, new BeanListHandler<Course>(Course.class));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Student select1(String sql) {
		try {
			System.out.println("iii");
			return  (Student) qr.query(sql, new BeanHandler(Student.class));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
