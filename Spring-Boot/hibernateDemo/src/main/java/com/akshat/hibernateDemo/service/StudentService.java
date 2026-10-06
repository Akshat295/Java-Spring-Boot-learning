package com.akshat.hibernateDemo.service;

import com.akshat.hibernateDemo.model.Student;
import com.akshat.hibernateDemo.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Transactional
    public void createStudent(Student student){
        studentRepository.save(student);
    }

    @Transactional
    public Student getStudentById(Long id){
        return studentRepository.findById(id);
    }

    public void updateStudent(Student student, Long id){
        Student student1 = studentRepository.findById(id);
        if (student1 == null){
            throw new RuntimeException("Student not found");
        }
        student1.setName(student.getName());
        student1.setAge(student.getAge());
        student1.setEmail(student.getEmail());
    }

    public void deleteStudent(Long id){
        Student student = studentRepository.findById(id);

        if(student == null){
            throw new RuntimeException("Student not found");
        }

        studentRepository.remove(id);
    }

}
