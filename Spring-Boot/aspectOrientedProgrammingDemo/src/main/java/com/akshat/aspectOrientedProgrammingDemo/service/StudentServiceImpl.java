package com.akshat.aspectOrientedProgrammingDemo.service;

import com.akshat.aspectOrientedProgrammingDemo.dto.Student;
import com.akshat.aspectOrientedProgrammingDemo.repository.StudentRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void createStudent(Student student){
        studentRepository.save(student);
    }
}
