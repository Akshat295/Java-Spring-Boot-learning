package com.akshat.aspectOrientedProgrammingDemo.service;

import com.akshat.aspectOrientedProgrammingDemo.dto.Student;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary

public class ExecutionTimeService  implements StudentService {

    private LoggingDecorator loggingDecorator;

    public ExecutionTimeService(LoggingDecorator loggingDecorator) {
        this.loggingDecorator = loggingDecorator;
    }

    @Override
    public void createStudent(Student student) {
        Long startTime = System.currentTimeMillis();

        loggingDecorator.createStudent(student);

        Long endTime = System.currentTimeMillis();

        System.out.println("Duration: " + (endTime - startTime));
    }
}
