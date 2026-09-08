package com.akshat.crudSpringBootDemo.service;

import com.akshat.crudSpringBootDemo.entity.Student;
import com.akshat.crudSpringBootDemo.repository.StudentRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student studentReq){
        Student studentResp = studentRepository.save(studentReq) ;
        return studentResp;
    }

    public Student getStudent(Long id){
        Optional<Student> studentResp = studentRepository.findById(id);

        if(studentResp.isPresent()){
            return studentResp.get();
        }
        return null;
    }

    public List<Student> getAllStudent(){
        List<Student> studentList = studentRepository.findAll();
        return studentList;
    }

    public Student updateStudent(Long id, Student studentReq){
        Optional<Student> exisitingStudent = studentRepository.findById(id);

        if (exisitingStudent.isEmpty()) {
            return null;
        }

        Student studentToSave = exisitingStudent.get();
        studentToSave.setName(studentReq.getName());
        studentToSave.setAge(studentReq.getAge());
        studentToSave.setEmail(studentReq.getEmail());
        studentToSave.setRollNo(studentReq.getRollNo());
        studentToSave.setSubject(studentReq.getSubject());

        studentRepository.save(studentToSave);
        return studentToSave;
    }

    public Boolean deleteStudent(Long id) {
        Boolean isStudent = studentRepository.existsById(id);

        if (!isStudent) {
            return false;
        }

        studentRepository.deleteById(id);

        return true;
    }
}
