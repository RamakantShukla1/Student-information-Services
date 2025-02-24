package com.student.student_information_system.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer stdId;
    @Column
    private String stdName;
    @Column
    private String stdEmail;
    private String stdAddress;
    private String stdPhone;
    private String stdDepartment;
    private String stdGender;
   
    private void validate () {
        List <String> errors = new ArrayList <String> ();
        if (stdName == null || stdName.isEmpty ()) {
            errors.add ("Name is required");
        }
        if (stdEmail == null || stdEmail.isEmpty ()) {
            errors.add ("Email is required");
        }
        if (stdAddress == null || stdAddress.isEmpty ()) {
            errors.add ("Address is required");
        }
        if (stdPhone == null || stdPhone.isEmpty ()) {
            errors.add ("Phone is required");
        }
        if (stdDepartment == null || stdDepartment.isEmpty ()) {
            errors.add ("Department is required");
        }
        if (stdGender == null || stdGender.isEmpty ()) {    
            errors.add ("stdGender is required");
        }
        if (!errors.isEmpty ()) {
            throw new IllegalArgumentException (errors.toString ());
        }
    }
}
