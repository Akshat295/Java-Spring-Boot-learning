package com.akshat.filterDemo.service;


import com.akshat.filterDemo.dto.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    public void createStudent(Student student){
        System.out.println("Student created");
        System.out.println("Student id: " + student.getId());
        System.out.println("Student name: " + student.getName());
        System.out.println("Student email: " + student.getEmail());
    }
}
