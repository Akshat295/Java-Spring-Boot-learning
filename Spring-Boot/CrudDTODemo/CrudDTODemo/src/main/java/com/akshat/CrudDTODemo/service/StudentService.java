package com.akshat.CrudDTODemo.service;


import com.akshat.CrudDTODemo.dto.CreateStudentRequestDTO;
import com.akshat.CrudDTODemo.dto.CreateStudentResponseDTO;
import com.akshat.CrudDTODemo.dto.UpdateStudentRequestDTO;
import com.akshat.CrudDTODemo.dto.UpdateStudentResponseDTO;
import com.akshat.CrudDTODemo.entity.Student;
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

        Student studentResp = studentRepository.save(student);

        return mapToDto(studentResp);
    }

    public CreateStudentResponseDTO getStudent(Long id){
        Optional<Student> studentResp = studentRepository.findByIdAndDeletedIsFalse(id);

        if(studentResp.isPresent()){
            return mapToDto(studentResp.get());
        }
        return null;
    }

    public List<CreateStudentResponseDTO> getAllStudent(){
        List<Student> studentList = studentRepository.findByDeletedIsFalse();
        return studentList.stream()
                .map(this::mapToDto)
                .toList();
    }

    public UpdateStudentResponseDTO updateStudent(Long id, UpdateStudentRequestDTO studentReq) {
        Optional<Student> exisitingStudent = studentRepository.findByIdAndDeletedIsFalse(id);

        if (exisitingStudent.isEmpty()) {
            return null;
        }

        Student studentToSave = exisitingStudent.get();
        studentToSave.setName(studentReq.getName());
        studentToSave.setAge(studentReq.getAge());
        studentToSave.setRollNo(studentReq.getRollNo());
        studentToSave.setSubject(studentReq.getSubject());

        studentToSave.setDeleted(false);
        studentToSave.setUpdatedAt(LocalDateTime.now());

        Student savedStudent = studentRepository.save(studentToSave);

        return mapTUpdateDto(savedStudent);
    }

    public Boolean deleteStudent(Long id) {
        Boolean isStudent = studentRepository.existsById(id);

        if (!isStudent) {
            return false;
        }

        studentRepository.deleteById(id);

        return true;
    }

    public Boolean deleteStudentSoftly(Long id) {
        Optional<Student> existingStudent = studentRepository.findByIdAndDeletedIsFalse(id);

        if (existingStudent.isEmpty()) {
            return false;
        }

        Student studentToSave = existingStudent.get();
        studentToSave.setDeleted(true);
        studentRepository.save(studentToSave);
        return true;
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
}
