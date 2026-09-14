package com.akshat.CrudDTODemo.dto;

import jakarta.validation.constraints.*;

public class CreateStudentRequestDTO {

    @NotBlank(message = "Name cannot be empty")
    @Size(min = 2, max = 50, message = "Student name must be between 2 to 50 character long")
    private String name;

    @NotNull(message = "Age is required")
    @Min(value = 18, message = "Student must be 18 years old")
    private int age;

    @Email(message = "Student email must be valid")
    @NotBlank(message = "Student email cannot be blank")
    private String email;

    @NotNull(message = "Roll No is required")
    private Integer rollNo;

    @NotBlank(message = "Subject cannot be blank")
    private String subject;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
