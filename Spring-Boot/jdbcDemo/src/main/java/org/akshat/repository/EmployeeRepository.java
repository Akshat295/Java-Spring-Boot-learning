package org.akshat.repository;

import org.akshat.model.Employee;

import java.sql.*;

public class EmployeeRepository {

    String url = "jdbc:mysql://127.0.0.1:3306/jdbc_demo";
    String username = "root";
    String password = "Akshat@2905";

    public void createEmployee() {

        String sql = """
                        INSERT INTO employee (id, name, department, salary) 
                        VALUES (?, ?, ?, ?)
                         """ ;
        try (Connection connection =
                     DriverManager.getConnection(url, username, password);


             PreparedStatement preparedStatement = connection.prepareStatement(sql);){

            preparedStatement.setInt(1, 1);
            preparedStatement.setString(2, "Akshat");
            preparedStatement.setString(3, "Developer");
            preparedStatement.setDouble(4, 25000.00);

            int result = preparedStatement.executeUpdate();

            if (result > 0) {
                System.out.println("Employee created successfully");
            } else {
                System.out.println("Employee not created");
            }

        } catch (SQLException e) {
            System.out.println("Error connecting to database");
            e.printStackTrace();
        }
    }

    public void updateEmployee() {

        String sql = """
                   UPDATE employee 
                   SET name = ?, department = ?, salary = ?
                   WHERE id = ?
                    """ ;

        try(Connection connection =
                    DriverManager.getConnection(url, username, password);

            PreparedStatement preparedStatement = connection.prepareStatement(sql);) {

            preparedStatement.setString(1, "Akshat Johri");
            preparedStatement.setString(2, "Development Team");
            preparedStatement.setDouble(3, 21000.00);
            preparedStatement.setInt(4, 1);

            int result = preparedStatement.executeUpdate(sql);

            if ( result == 1 ) System.out.println(result + " row updated successfully");
            else  System.out.println(result + " row updation failed");

        } catch (SQLException e) {
            System.out.println("Error connecting to database");
            e.printStackTrace();
        }
    }

    public void deleteEmployee() {

        String sql = """
                    DELETE FROM employee
                    WHERE id = ?
""";
        try (Connection connection =
                     DriverManager.getConnection(url, username, password);

             PreparedStatement preparedStatement = connection.prepareStatement(sql);) {


            preparedStatement.setInt(1, 1);


            int result = preparedStatement.executeUpdate();

            if ( result == 1 ) System.out.println(result + " row deleted successfully");
            else  System.out.println(result + " row deletion failed");

        } catch (SQLException e) {
            System.out.println("Error connecting to database");
            e.printStackTrace();
        }
    }

    public void getEmployeeById() {

        String sql = """
                    SELECT id, name, department, salary FROM employee WHERE id = ?;
                    """ ;
        try(Connection connection =
                    DriverManager.getConnection(url, username, password);

            PreparedStatement preparedStatement = connection.prepareStatement(sql);){


            preparedStatement.setInt(1, 1);

            try(ResultSet resultSet = preparedStatement.executeQuery();){
                while (resultSet.next()) {
                    Employee employee = mapRow(resultSet);
                    System.out.println(employee);
                }
            }


        } catch (SQLException e) {
            System.out.println("Error connecting to database");
            e.printStackTrace();
        }
    }

    private Employee mapRow(ResultSet resultSet) throws SQLException {
        Employee employee = new Employee();

        employee.setId(resultSet.getInt("id"));
        employee.setName(resultSet.getString("name"));
        employee.setDepartment(resultSet.getString("department"));
        employee.setSalary(resultSet.getDouble("salary"));
        return employee;
    }
}