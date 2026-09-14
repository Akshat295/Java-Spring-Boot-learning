package com.akshat.CrudDTODemo.controller;

import com.akshat.CrudDTODemo.dto.CreateStudentRequestDTO;
import com.akshat.CrudDTODemo.dto.CreateStudentResponseDTO;
import com.akshat.CrudDTODemo.dto.UpdateStudentRequestDTO;
import com.akshat.CrudDTODemo.dto.UpdateStudentResponseDTO;
import com.akshat.CrudDTODemo.entity.Student;
import com.akshat.CrudDTODemo.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")

public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/create")
    public ResponseEntity<CreateStudentResponseDTO> createStudent(@RequestBody @Valid CreateStudentRequestDTO studentRequestDto) {
        CreateStudentResponseDTO createdStudent = studentService.createStudent(studentRequestDto) ;
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdStudent);
    }

    @GetMapping("/get")
    public ResponseEntity<CreateStudentResponseDTO> getStudent(@RequestParam Long id) {
        CreateStudentResponseDTO studentResp = studentService.getStudent(id) ;

        if (studentResp == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(studentResp);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<CreateStudentResponseDTO>> getAllStudent() {
        List<CreateStudentResponseDTO> studentList = studentService.getAllStudent() ;

        if (studentList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(studentList);
    }

    @PutMapping("/update")
    public ResponseEntity<UpdateStudentResponseDTO> updateStudent(@RequestParam Long id, @RequestBody UpdateStudentRequestDTO updateStudentRequestDto) {
        UpdateStudentResponseDTO studentResp = studentService.updateStudent(id,updateStudentRequestDto) ;

        if (studentResp == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(studentResp);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteStudent(@RequestParam Long id) {
        Boolean isDeleted = studentService.deleteStudent(id);

        if (!isDeleted) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body("Student with id " + id + " was deleted successfully");
    }

    @PatchMapping("/delete-soft")
    public ResponseEntity<String> deleteStudentSoftly(@RequestParam Long id) {
        Boolean isDeleted = studentService.deleteStudentSoftly(id) ;
        if (!isDeleted) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body("Student with id " + id + " was deleted successfully");
    }
}
