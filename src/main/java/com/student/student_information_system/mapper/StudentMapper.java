package com.student.student_information_system.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.student.student_information_system.domain.Student;

public class StudentMapper implements RowMapper<Student> {
    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Student.builder()
                .stdId(rs.getInt("student_id"))
                .stdName(rs.getString("student_name"))
                .stdEmail(rs.getString("email"))
                .stdPhone(rs.getString("phone_number"))
                .stdAddress(rs.getString("address"))
                .build();
    }
}
