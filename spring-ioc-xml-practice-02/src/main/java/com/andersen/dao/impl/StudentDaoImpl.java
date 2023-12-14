package com.andersen.dao.impl;

import com.andersen.dao.StudentDao;
import com.andersen.pojo.Student;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class StudentDaoImpl implements StudentDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * 数据库查询全部学生数据
     * @return List<Student>
     */
    @Override
    public List<Student> queryAll() {

        String sql = "select id, name, gender, age, class as classes from students;";

        List<Student> students = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class));

        System.out.println("studentDao:" + students);

        return students;
    }
}
