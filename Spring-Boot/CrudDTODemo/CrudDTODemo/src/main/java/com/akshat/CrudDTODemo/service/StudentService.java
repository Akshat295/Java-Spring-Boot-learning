package com.akshat.CrudDTODemo.service;


import com.akshat.CrudDTODemo.dto.CreateStudentRequestDTO;
import com.akshat.CrudDTODemo.dto.CreateStudentResponseDTO;
import com.akshat.CrudDTODemo.dto.UpdateStudentRequestDTO;
import com.akshat.CrudDTODemo.dto.UpdateStudentResponseDTO;
import com.akshat.CrudDTODemo.entity.Student;
import com.akshat.CrudDTODemo.exception.DuplicateResourceException;
import com.akshat.CrudDTODemo.exception.ResourceNotFoundException;
import com.akshat.CrudDTODemo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public CreateStudentResponseDTO createStudent(CreateStudentRequestDTO studentReqDto){
        Student student = mapToEntity(studentReqDto);

        if(emailExists(student)) {
            throw new DuplicateResourceException("Student already exists");
        }

        Student studentResp = studentRepository.save(student);

        return mapToDto(studentResp);
    }

    public CreateStudentResponseDTO getStudent(Long id){
        Student student = studentRepository
                .findByIdAndDeletedIsFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student with id " + id + " not found"));

        return mapToDto(student);
    }

    public List<CreateStudentResponseDTO> getAllStudent(){
        List<Student> studentList = studentRepository.findByDeletedIsFalse();
        return studentList.stream()
                .map(this::mapToDto)
                .toList();
    }

    public UpdateStudentResponseDTO updateStudent(Long id, UpdateStudentRequestDTO studentReq) {
        Student exisitingStudent = studentRepository
                .findByIdAndDeletedIsFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student with id " + id + " not found"));

        exisitingStudent.setName(studentReq.getName());
        exisitingStudent.setAge(studentReq.getAge());
        exisitingStudent.setRollNo(studentReq.getRollNo());
        exisitingStudent.setSubject(studentReq.getSubject());

        exisitingStudent.setDeleted(false);
        exisitingStudent.setUpdatedAt(LocalDateTime.now());

        Student savedStudent = studentRepository.save(exisitingStudent);

        return mapTUpdateDto(savedStudent);
    }

    public void deleteStudent(Long id) {
        Student studentToBeDeleted = studentRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student with id " + id + " not found"));


        studentRepository.delete(studentToBeDeleted);
    }

    public void deleteStudentSoftly(Long id) {
        Student studentToBeDeleted = studentRepository
                .findByIdAndDeletedIsFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student with id " + id + " not found"));

        studentToBeDeleted.setDeleted(true);
        studentRepository.save(studentToBeDeleted);
    }

    private Student mapToEntity(CreateStudentRequestDTO studentReqDto){
        Student student = new Student();
        student.setName(studentReqDto.getName());
        student.setAge(studentReqDto.getAge());
        student.setEmail(studentReqDto.getEmail());
        student.setRollNo(studentReqDto.getRollNo());
        student.setSubject(studentReqDto.getSubject());
        student.setCreatedAt(LocalDateTime.now());
        student.setUpdatedAt(LocalDateTime.now());

        student.setDeleted(false);

        return student;
    }

    private CreateStudentResponseDTO mapToDto(Student student){
        CreateStudentResponseDTO studentResponseDTO = new CreateStudentResponseDTO();
        studentResponseDTO.setId(student.getId());
        studentResponseDTO.setName(student.getName());
        studentResponseDTO.setAge(student.getAge());
        studentResponseDTO.setEmail(student.getEmail());
        studentResponseDTO.setRollNo(student.getRollNo());
        studentResponseDTO.setSubject(student.getSubject());
        studentResponseDTO.setMessage("Student saved successfully");
        studentResponseDTO.setCreatedAt(student.getCreatedAt());
        studentResponseDTO.setUpdatedAt(student.getUpdatedAt());

        return studentResponseDTO;
    }

    private UpdateStudentResponseDTO mapTUpdateDto(Student student){
        UpdateStudentResponseDTO updateStudentResponseDTO = new UpdateStudentResponseDTO();
        updateStudentResponseDTO.setId(student.getId());
        updateStudentResponseDTO.setName(student.getName());
        updateStudentResponseDTO.setAge(student.getAge());
        updateStudentResponseDTO.setEmail(student.getEmail());
        updateStudentResponseDTO.setRollNo(student.getRollNo());
        updateStudentResponseDTO.setSubject(student.getSubject());
        updateStudentResponseDTO.setMessage("Student updated successfully");
        updateStudentResponseDTO.setUpdatedAt(student.getUpdatedAt());

        return updateStudentResponseDTO;
    }

    private boolean emailExists(Student student){
        return studentRepository.existsByEmail(student.getEmail());
    }
}
