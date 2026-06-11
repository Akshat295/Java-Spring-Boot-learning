# JDBC CRUD Operations with MySQL

## Introduction to JDBC

### What is JDBC?

JDBC (Java Database Connectivity) is a Java API that enables Java applications to interact with relational databases. It provides a standard way to connect, execute SQL queries, and retrieve results from databases such as MySQL, PostgreSQL, Oracle, and SQL Server.

JDBC acts as a bridge between a Java application and a database.

```text
Java Application
       |
       v
     JDBC
       |
       v
    Database
```

### Why JDBC?

Before JDBC, every database required a different way of communication. JDBC provides a common interface that allows Java applications to work with different databases using similar code.

### JDBC Architecture

```text
Java Application
       |
       v
    JDBC API
       |
       v
  JDBC Driver
       |
       v
    Database
```

### Key JDBC Components

#### 1. DriverManager

Responsible for establishing a connection with the database.

```java
DriverManager.getConnection(url, username, password);
```

#### 2. Connection

Represents an active connection between the Java application and the database.

```java
Connection conn;
```

#### 3. Statement

Used for executing static SQL queries.

```java
Statement stmt = conn.createStatement();
```

#### 4. PreparedStatement

Used for executing parameterized SQL queries. It improves performance and helps prevent SQL Injection attacks.

```java
PreparedStatement pstmt =
    conn.prepareStatement(sql);
```

#### 5. ResultSet

Stores the data returned by SELECT queries.

```java
ResultSet rs =
    stmt.executeQuery(sql);
```

### JDBC Workflow

A typical JDBC application follows these steps:

1. Establish a database connection.
2. Create a Statement or PreparedStatement.
3. Execute SQL queries.
4. Process the ResultSet.
5. Close database resources.

```text
Connect → Execute Query → Process Result → Close Connection
```

---

# Project: Employee Management CRUD Application

## Project Overview

This project demonstrates how to perform CRUD (Create, Read, Update, Delete) operations using JDBC and MySQL.

The application connects to a MySQL database, inserts employee records, retrieves employee data, updates existing records, and deletes records using JDBC APIs.

The primary objective of this project is to gain hands-on experience with JDBC fundamentals before moving to advanced frameworks such as Spring Boot and Spring Data JPA.

---

## Technologies Used

* Java
* JDBC
* MySQL
* MySQL Connector/J
* VS Code

---

## Project Structure

```text
JDBC-concepts
│
├── lib
│   └── mysql-connector-j-9.7.0.jar
│
└── src
    └── com
        └── jdbc
            └── DBConnection.java
```

---

## Database Setup

### Create Database

```sql
CREATE DATABASE jdbc_demo;
```

### Select Database

```sql
USE jdbc_demo;
```

### Create Employee Table

```sql
CREATE TABLE employee(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    department VARCHAR(100),
    salary DOUBLE
);
```

---

## Features Implemented

### Create Employee

Adds a new employee record to the database.

```sql
INSERT INTO employee(name, department, salary)
VALUES (?, ?, ?);
```

### Read Employees

Fetches and displays all employee records.

```sql
SELECT * FROM employee;
```

### Update Employee

Updates employee information.

```sql
UPDATE employee
SET salary = ?
WHERE id = ?;
```

### Delete Employee

Removes an employee record from the database.

```sql
DELETE FROM employee
WHERE id = ?;
```

---

## JDBC Concepts Used in This Project

### Database Connection

```java
Connection conn =
    DriverManager.getConnection(
        URL,
        USER,
        PASSWORD
    );
```

Used to establish communication with MySQL.

---

### PreparedStatement

```java
PreparedStatement pstmt =
    conn.prepareStatement(query);
```

Used for:

* INSERT
* UPDATE
* DELETE

Benefits:

* Better performance
* Reusable SQL
* Protection against SQL Injection

---

### Statement

```java
Statement stmt =
    conn.createStatement();
```

Used for executing simple SQL queries such as SELECT.

---

### ResultSet

```java
ResultSet rs =
    stmt.executeQuery(query);
```

Used to retrieve and process records returned by SELECT queries.

---

## How to Compile

```powershell
javac -cp ".;lib/*" -d . src\com\jdbc\DBConnection.java
```

---

## How to Run

### If Package Declaration Exists

```powershell
java -cp ".;lib/*" com.jdbc.DBConnection
```

### If Package Declaration Does Not Exist

```powershell
java -cp ".;lib/*" DBConnection
```

---

## Sample Output

```text
Connected Successfully
1 row inserted

Employees:
1 Akshat SDET 50000.0
```

---

## Learning Outcomes

Through this project, the following concepts were learned:

* Understanding JDBC architecture
* Establishing database connections using DriverManager
* Executing SQL queries through Java
* Working with PreparedStatement and Statement
* Retrieving records using ResultSet
* Implementing CRUD operations
* Connecting Java applications to MySQL databases
* Managing database resources effectively

---

## Future Enhancements

* Menu-driven console application using Scanner
* Search employee by ID
* User input-based CRUD operations
* Exception handling improvements
* DAO Design Pattern implementation
* Transaction management
* Migration to Spring Boot JdbcTemplate
* Integration with Spring Data JPA

---

## Author

**Akshat Johri**

Learning Project: JDBC Fundamentals and CRUD Operations using MySQL
