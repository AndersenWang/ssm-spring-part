package com.ansersen.jdbc;

import com.alibaba.druid.pool.DruidDataSource;
import com.andersen.controller.StudentController;
import com.andersen.pojo.Student;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JdbcTemplateTest {
    public void testForJava() {

        /**
         * JdbcTemplate 简化数据库的crud 不提供连接池
         * DruidDataSource 负责连接的创建和数据库驱动的注册等
         */

        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl("jdbc:mysql:///studb");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUsername("root");
        dataSource.setPassword("730504");

        JdbcTemplate jdbcTemplate = new JdbcTemplate();

        jdbcTemplate.setDataSource(dataSource);

        // jdbcTemplate.update(); DDL DML DCL ... 非查询语句
        // jdbcTemplate.queryForObject(); DQL 查询单个对象
        // jdbcTemplate.query(); DQL 查询集合

    }

    @Test
    public void testForIoC() {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-01.xml");

        JdbcTemplate jdbcTemplate = applicationContext.getBean(JdbcTemplate.class);

        String sql = "insert into students (id, name, gender, age, class) value (?, ?, ?, ?, ?)";
        int rows = jdbcTemplate.update(sql, 9, "安德森", "男", 18, "6班");
        System.out.println("rows = " + rows);

        sql = "select * from students where id = ?;";
        Student student1 = jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            Student student = new Student();
            student.setId(rs.getInt("id"));
            student.setName(rs.getString("name"));
            student.setGender(rs.getString("gender"));
            student.setAge(rs.getInt("age"));
            student.setClasses(rs.getString("class"));
            return student;
        }, 1);
        System.out.println("student1 = " + student1);

        sql = "select id, name, gender, age, class as classes from students";
        List<Student> studentList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class));
        System.out.println("studentList = " + studentList);

    }

    @Test
    public void testQueryAll() {
        // 1.创建ioc容器
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-02.xml");

        // 2.获取组件对象
        StudentController controller = applicationContext.getBean(StudentController.class);

        // 3.使用组件对象
        controller.findAll();

        // 4.关闭容器
        applicationContext.close();
    }
}
