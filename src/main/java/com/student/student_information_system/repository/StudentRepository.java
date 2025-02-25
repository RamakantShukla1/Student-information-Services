package com.student.student_information_system.repository;

import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.student.student_information_system.domain.Student;
import com.student.student_information_system.mapper.StudentMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class StudentRepository {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final StudentMapper studentMapper;

    private static final String INSERT_STUDENT = "INSERT INTO student (student_id, student_name, email, phone_number, address) VALUES (:student_id, :student_name, :email, :phone_number, :address)";
    private static final String UPDATE_STUDENT = "UPDATE student SET student_name = :student_name, last_name = :last_name, email = :email, phone_number = :phone_number, address = :address WHERE student_id = :student_id";
    private static final String DELETE_STUDENT = "DELETE FROM student WHERE student_id = :student_id";
    private static final String GET_STUDENT = "SELECT * FROM student WHERE student_id = :student_id";
    private static final String GET_ALL_STUDENTS = "SELECT * FROM student";

    public void insertStudent(Student student) {
        
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
         parameterSource.addValue("student_id", student.getStdId());
         parameterSource.addValue("student_name", student.getStdName());
         parameterSource.addValue("email", student.getStdEmail());
         parameterSource.addValue("phone_number", student.getStdPhone());
         parameterSource.addValue("address", student.getStdAddress());
        namedParameterJdbcTemplate.update(INSERT_STUDENT, parameterSource);
        }

    public void updateStudent(Student student) {

        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("student_id", student.getStdId());
        parameterSource.addValue("student_name", student.getStdName());
        parameterSource.addValue("email", student.getStdEmail());
        parameterSource.addValue("phone_number", student.getStdPhone());
        parameterSource.addValue("address", student.getStdAddress());
        
        namedParameterJdbcTemplate.update(UPDATE_STUDENT, parameterSource);
    }

    public void deleteStudent(Integer studentId) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("student_id", studentId);
        namedParameterJdbcTemplate.update(DELETE_STUDENT, parameterSource);
    }

    public Student getStudent(Integer studentId) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("student_id", studentId);
        return namedParameterJdbcTemplate.queryForObject(GET_STUDENT,parameterSource,studentMapper);
    }

    public List<Student> getAllStudents() {
        return namedParameterJdbcTemplate.query(GET_ALL_STUDENTS, studentMapper);
    }
    

}
