package org.akshat;

import org.akshat.repository.EmployeeRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        EmployeeRepository employeeRepository = new EmployeeRepository();
//        employeeRepository.createEmployee();
//        employeeRepository.updateEmployee();
//        employeeRepository.deleteEmployee();
        employeeRepository.getEmployeeById();
    }

}