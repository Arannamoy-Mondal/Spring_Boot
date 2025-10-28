package com.aranna.java5_spring_jdbc.Student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {
    private JdbcTemplate jdbcTemplate;
    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Student std){
        String sql="insert into student (id,name,age) values (?,?,?)";
        int rows=jdbcTemplate.update(sql,std.getId(),std.getName(),std.getAge());
        System.out.println("save method called. Affected "+rows);
    }

    public List<Student> getStudents(){
        String sql="select * from student";
        RowMapper<Student> mapper=new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet rs,int rowNum) throws SQLException{
                Student std=new Student();
                std.setId(rs.getInt("id"));
                std.setName(rs.getString("name"));
                std.setAge(rs.getInt("age"));
                return std;
            }
        };
        List<Student> students=jdbcTemplate.query(sql, mapper);
        return students;
    }
}
