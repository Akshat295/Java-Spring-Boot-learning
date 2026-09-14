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

        return ResponseEntity.ok(studentResp);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<CreateStudentResponseDTO>> getAllStudent() {
        List<CreateStudentResponseDTO> studentList = studentService.getAllStudent() ;

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(studentList);
    }

    @PutMapping("/update")
    public ResponseEntity<UpdateStudentResponseDTO> updateStudent(@RequestParam Long id, @RequestBody UpdateStudentRequestDTO updateStudentRequestDto) {
        UpdateStudentResponseDTO studentResp = studentService.updateStudent(id,updateStudentRequestDto) ;

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(studentResp);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteStudent(@RequestParam Long id) {
        studentService.deleteStudent(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PatchMapping("/delete-soft")
    public ResponseEntity<String> deleteStudentSoftly(@RequestParam Long id) {
        studentService.deleteStudentSoftly(id) ;

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();    }
}
