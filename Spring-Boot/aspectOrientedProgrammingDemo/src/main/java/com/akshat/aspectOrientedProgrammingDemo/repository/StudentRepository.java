package com.akshat.aspectOrientedProgrammingDemo.repository;

import com.akshat.aspectOrientedProgrammingDemo.dto.Student;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {

    public void save(Student student){
        System.out.println("save student");
    }
}
