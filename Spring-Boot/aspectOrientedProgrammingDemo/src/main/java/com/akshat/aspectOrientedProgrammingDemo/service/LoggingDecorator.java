package com.akshat.aspectOrientedProgrammingDemo.service;

import com.akshat.aspectOrientedProgrammingDemo.dto.Student;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class LoggingDecorator implements StudentService {

    private StudentServiceImpl studentServiceImpl;

    public LoggingDecorator(StudentServiceImpl studentServiceImpl) {
        this.studentServiceImpl = studentServiceImpl;
    }

    @Override
    public void createStudent(Student student) {
        //Logging related logic

        LoggingServiceUtil.logStart("StudentServiceImpl", "createStudent");

        studentServiceImpl.createStudent(student);

        LoggingServiceUtil.logEnd("StudentServiceImpl", "createStudent");


    }
}
