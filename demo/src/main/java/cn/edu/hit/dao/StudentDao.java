package cn.edu.hit.dao;

import cn.edu.hit.entity.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentDao {
    void add(Student student) throws SQLException;
    void modify(Student student);
    void remove(String sid);
    List<Student> getAll(String sql);
    Student getStudent(String sid);
    List<Student> getByName(String sql);
}
