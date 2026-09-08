package com.akshat.crudSpringBootDemo.repository;

import com.akshat.crudSpringBootDemo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

// @Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
