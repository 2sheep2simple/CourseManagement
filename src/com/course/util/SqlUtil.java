package com.course.util;

import com.course.domain.*;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class SqlUtil {
    QueryRunner qr = new QueryRunner(C3P0Util.dataSource);

    public User login(String sql){
		try {
			return (User) qr.query(sql, new BeanHandler(User.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

    public List<Elective> select(String sql) {
        try {
            return qr.query(sql, new BeanListHandler<Elective>(Elective.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

	public  Student select1(String sql) {
        try {
            return (Student) qr.query(sql, new BeanHandler(Student.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Score> select2(String sql) {
        try {
            return qr.query(sql, new BeanListHandler<Score>(Score.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<Student> getStudent(String sql) {
        try {
            return qr.query(sql, new BeanListHandler<Student>(Student.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<Yxcourse> select3(String sql) {
        try {
            return qr.query(sql, new BeanListHandler<Yxcourse>(Yxcourse.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Course> getCourse(String sql) {
        try {
            return qr.query(sql, new BeanListHandler<Course>(Course.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public  Yxcourse select4(String sql) {
        try {
            return (Yxcourse) qr.query(sql, new BeanHandler(Yxcourse.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Clas> getClas(String sql) {
        try {
            return qr.query(sql, new BeanListHandler<Clas>(Clas.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Nation> getNation(String sql) {
        try {
            return qr.query(sql, new BeanListHandler<Nation>(Nation.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Type> getType(String sql) {
        try {
            return qr.query(sql, new BeanListHandler<Type>(Type.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Status> getStatus(String sql) {
        try {
            return qr.query(sql, new BeanListHandler<Status>(Status.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<User> getTeacher(String sql) {
        try {
            return qr.query(sql, new BeanListHandler<User>(User.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addStudent(String sql, Object[] params) {
        try {
            qr.update(sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delStudent(String sql, Object[] params) {
        try {
            qr.update(sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editStudent(String sql, Object[] params) {
        try {
            qr.update(sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
public int delete(String sql){
    try {
		     return qr.update(sql);
		     
	      } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return 0;
}
}
