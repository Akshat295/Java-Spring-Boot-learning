# Spring MVC

This project and notes focus on understanding **Spring MVC**, its **internal architecture**, and how an HTTP request travels from the client to a Spring controller.

> JSP and server-side view rendering are intentionally excluded.

---

## What is Spring MVC?

**Spring MVC** is the official web framework of the Spring ecosystem.

It is used to build web applications, especially:

* REST APIs
* HTTP-based backend applications
* Web applications

The Spring MVC module provides commonly used web-related annotations such as:

* `@Controller`
* `@RestController`
* `@RequestMapping`
* `@GetMapping`
* `@PostMapping`
* `@PutMapping`
* `@DeleteMapping`

Spring MVC handles the underlying web infrastructure so that developers can focus primarily on application logic.

---

# Spring MVC vs Spring Boot

Spring MVC provides the actual web framework and request-handling infrastructure.

Spring Boot makes working with Spring MVC easier by providing:

* Auto-configuration
* Dependency management
* Embedded server support
* Reduced boilerplate configuration

For example, in a traditional Spring MVC application, several things may need to be configured manually:

* Spring MVC dependencies
* Embedded or external Tomcat
* `DispatcherServlet`
* Spring IoC container
* Component scanning
* Request mappings
* JSON conversion

Spring Boot automatically configures much of this infrastructure, allowing developers to focus more on business logic.

In simple terms:

```text
Spring MVC → Provides the web framework
Spring Boot → Makes Spring MVC easier to configure and use
```

---

# High-Level Spring MVC Architecture

The basic request flow is:

```text
Client
   ↓
Tomcat
   ↓
DispatcherServlet
   ↓
HandlerMapping
   ↓
Controller
   ↓
Service
   ↓
Repository
   ↓
Database
```

The response travels back through the application:

```text
Database
   ↓
Repository
   ↓
Service
   ↓
Controller
   ↓
DispatcherServlet
   ↓
Tomcat
   ↓
Client
```

The key concept is:

> The controller does not directly listen to a port or directly communicate with Tomcat.

The central component between Tomcat and Spring controllers is the **DispatcherServlet**.

---

# 1. Client

The process starts when a client sends an HTTP request.

For example:

```http
GET /students
```

or:

```http
POST /students
```

The client can send data in different forms:

### Request Body

For example:

```json
{
  "id": 1,
  "name": "Akshat",
  "email": "akshat@example.com"
}
```

### Path Variable

For example:

```text
/users/1
```

Here, `1` can represent the user ID.

### Query Parameter

For example:

```text
/users?id=1
```

---

# 2. Tomcat

Tomcat acts as the web server and servlet container.

It listens for incoming HTTP requests.

When a request arrives, Tomcat processes the request and creates servlet-related request and response objects.

Conceptually:

```text
HTTP Request
     ↓
Tomcat
     ↓
HttpServletRequest
HttpServletResponse
```

Tomcat then forwards the request to a servlet.

In Spring MVC, instead of managing many application-specific servlets directly, Spring uses a central servlet called the **DispatcherServlet**.

---

# 3. DispatcherServlet

The `DispatcherServlet` is the central entry point of Spring MVC.

It receives requests from Tomcat and coordinates the rest of the request-processing flow.

```text
Tomcat
   ↓
DispatcherServlet
```

Instead of having separate servlets such as:

```text
UserServlet
OrderServlet
PaymentServlet
```

Spring MVC uses a central servlet:

```text
DispatcherServlet
```

and routes requests to different controllers:

```text
                    ┌──→ UserController
DispatcherServlet ──┼──→ OrderController
                    └──→ PaymentController
```

This centralization helps avoid repetitive request-processing logic across multiple servlets. The transcript describes the `DispatcherServlet` as the layer between Tomcat and controllers and highlights its role as the central entry point for HTTP requests.

---

# 4. HandlerMapping

A major question in a web framework is:

> Which controller method should handle a particular HTTP request?

For example:

```http
GET /students
```

might need to execute:

```java
StudentController.getAllStudents()
```

While:

```http
POST /students
```

might need to execute:

```java
StudentController.createStudent()
```

This mapping is handled with the help of **HandlerMapping**.

Conceptually, it maintains mapping information like:

```text
GET /students
        ↓
StudentController.getAllStudents()

POST /students
        ↓
StudentController.createStudent()
```

The `DispatcherServlet` uses this mapping information to determine which controller and method should handle the incoming request.

---

## How Does HandlerMapping Know About Endpoints?

Spring's IoC container manages application beans.

For example:

```text
IoC Container
    │
    ├── Controller Beans
    ├── Service Beans
    └── Repository Beans
```

Controller classes are identified through annotations such as:

```java
@Controller
```

or:

```java
@RestController
```

Handler mappings inspect controller beans and their request-mapping annotations.

For example:

```java
@GetMapping("/students")
```

or:

```java
@PostMapping("/students")
```

From these annotations, Spring builds the information required to map:

```text
HTTP Method + URL
        ↓
Controller Method
```

The transcript specifically describes `HandlerMapping` as creating the mapping between endpoints and controller methods by scanning controller mappings after Spring-managed beans are available.

---

# 5. Controller

Once the correct mapping is found, the appropriate controller method is invoked.

Example:

```java
@RestController
@RequestMapping("/students")
public class StudentController {

    @GetMapping
    public List<Student> getAllStudents() {
        // Controller logic
    }
}
```

The controller is responsible for handling HTTP-level interactions.

A typical controller forwards business-related work to the service layer:

```text
Controller
    ↓
Service
```

For example:

```java
@PostMapping
public Student createStudent(@RequestBody Student student) {
    return studentService.createStudent(student);
}
```

The controller receives the processed data and returns the result.

---

# 6. Service Layer

The service layer contains application and business logic.

```text
Controller
    ↓
Service
```

Example:

```java
@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }
}
```

The service layer communicates with the repository when data needs to be stored or retrieved.

---

# 7. Repository Layer

The repository layer is responsible for data access.

```text
Service
   ↓
Repository
```

Depending on the application, the repository may interact with:

* A database
* An in-memory data structure
* An external data source

Example:

```java
@Repository
public class StudentRepository {

    public Student save(Student student) {
        // Save student
        return student;
    }
}
```

---

# Complete Request Flow

Consider the following request:

```http
GET /students
```

The complete flow is:

### Step 1: Client sends request

```text
Client
   ↓
GET /students
```

### Step 2: Tomcat receives the request

Tomcat listens for incoming HTTP requests and forwards the request into the servlet-based infrastructure.

```text
Client
   ↓
Tomcat
```

### Step 3: Request reaches DispatcherServlet

Tomcat provides the request to the central Spring MVC servlet.

```text
Tomcat
   ↓
DispatcherServlet
```

### Step 4: DispatcherServlet finds the correct handler

The `DispatcherServlet` uses `HandlerMapping`.

```text
DispatcherServlet
        ↓
   HandlerMapping
        ↓
Find matching controller method
```

For example:

```text
GET /students
        ↓
StudentController.getAllStudents()
```

### Step 5: Controller method is executed

```text
DispatcherServlet
   ↓
StudentController
```

### Step 6: Controller calls the service

```text
StudentController
   ↓
StudentService
```

### Step 7: Service calls the repository

```text
StudentService
   ↓
StudentRepository
```

### Step 8: Data is returned

```text
Repository
   ↓
Service
   ↓
Controller
```

### Step 9: Response is processed

The controller result is handled by the Spring MVC infrastructure.

For REST APIs, Java objects can be converted into JSON before being returned.

```text
Java Object
    ↓
JSON Response
```

### Step 10: Response reaches the client

```text
DispatcherServlet
   ↓
Tomcat
   ↓
Client
```

The full high-level architecture presented in the source is summarized as client → Tomcat → `DispatcherServlet` → handler mapping/controller processing, with the response ultimately returned through Tomcat to the client.

---

# Request Data Handling

Spring MVC applications commonly receive data in three forms:

```text
1. Request Body
2. Path Variable
3. Query Parameter
```

---

## Request Body

A request body can contain JSON:

```json
{
  "id": 1,
  "name": "Akshat",
  "email": "akshat@example.com"
}
```

It can be mapped to a Java object:

```java
public class Student {

    private Long id;
    private String name;
    private String email;

    // Getters and Setters
}
```

In a controller:

```java
@PostMapping("/students")
public Student createStudent(@RequestBody Student student) {
    return studentService.createStudent(student);
}
```

Spring's web infrastructure handles the conversion between the HTTP request body and Java objects, using JSON conversion support such as Jackson.

The same idea applies in the reverse direction when returning Java objects as JSON responses.

---

## Path Variable

Example URL:

```text
/students/1
```

The `1` can be extracted using:

```java
@GetMapping("/students/{id}")
public Student getStudent(@PathVariable Long id) {
    return studentService.getStudent(id);
}
```

Conceptually:

```text
/students/1
          ↓
        id = 1
```

---

## Query Parameter

Example:

```text
/students?id=1
```

It can be received using:

```java
@GetMapping("/students")
public Student getStudent(@RequestParam Long id) {
    return studentService.getStudent(id);
}
```

Conceptually:

```text
/students?id=1
              ↓
           id = 1
```

The transcript distinguishes these three common ways of transferring request data and discusses how request-body conversion, path-variable resolution, and query/request parameters are handled within the servlet/Spring MVC request flow.

---

# Important Components

| Component             | Responsibility                                            |
| --------------------- | --------------------------------------------------------- |
| **Client**            | Sends HTTP requests and receives responses                |
| **Tomcat**            | Listens for HTTP requests and acts as a servlet container |
| **DispatcherServlet** | Central entry point and request coordinator               |
| **HandlerMapping**    | Determines which controller method matches a request      |
| **Controller**        | Handles HTTP requests                                     |
| **Service**           | Contains business logic                                   |
| **Repository**        | Handles data access                                       |
| **IoC Container**     | Creates and manages Spring beans                          |

---

# Key Annotations

## `@RestController`

Used to create a REST controller.

```java
@RestController
public class StudentController {
}
```

---

## `@RequestMapping`

Used for request mapping.

```java
@RequestMapping("/students")
```

---

## `@GetMapping`

Used for GET requests.

```java
@GetMapping
public List<Student> getAllStudents() {
    // ...
}
```

---

## `@PostMapping`

Used for POST requests.

```java
@PostMapping
public Student createStudent(@RequestBody Student student) {
    // ...
}
```

---

## `@RequestBody`

Maps the HTTP request body to a Java object.

```java
public Student createStudent(@RequestBody Student student)
```

---

## `@PathVariable`

Extracts values from the URL path.

```java
@GetMapping("/{id}")
public Student getStudent(@PathVariable Long id)
```

---

## `@RequestParam`

Extracts query parameters.

```java
@GetMapping
public Student getStudent(@RequestParam Long id)
```

---

# DispatcherServlet: The Most Important Concept

If you remember only one thing from Spring MVC architecture, remember this:

```text
Tomcat
   ↓
DispatcherServlet
   ↓
Find correct handler/controller
   ↓
Execute controller logic
```

The `DispatcherServlet` acts as the **central request-processing entry point**.

Controllers do not directly listen to ports.

Instead:

```text
Tomcat listens to the port
        ↓
DispatcherServlet receives the request
        ↓
HandlerMapping identifies the correct handler
        ↓
Correct controller method is executed
```

---

# Spring MVC and IoC Container

Spring's IoC container manages application objects as beans.

Examples include:

```text
@Controller / @RestController
        ↓
Controller Bean

@Service
        ↓
Service Bean

@Repository
        ↓
Repository Bean
```

The IoC container creates and manages these objects.

Handler mappings can then inspect controller beans and their mapping annotations to determine endpoint-to-method mappings.

For example:

```java
@GetMapping("/students")
```

creates the relationship:

```text
GET + /students
        ↓
Specific Controller Method
```

---

# Why Spring MVC Is Better Than Managing Multiple Servlets Manually

Without this centralized approach, multiple servlets could repeat similar infrastructure-related tasks:

```text
UserServlet
├── Read request parameters
├── Parse request body
├── Convert JSON
├── Create response
└── Handle errors

OrderServlet
├── Read request parameters
├── Parse request body
├── Convert JSON
├── Create response
└── Handle errors

PaymentServlet
├── Read request parameters
├── Parse request body
├── Convert JSON
├── Create response
└── Handle errors
```

Spring MVC centralizes much of this web-related processing through its framework infrastructure.

This allows application code to focus more on:

```text
Controller → HTTP handling
Service    → Business logic
Repository → Data access
```

---

# Spring MVC vs Spring Boot Summary

### Spring MVC

You may need to configure more things manually, such as:

* Dependencies
* Server integration
* DispatcherServlet
* Application context
* Component scanning
* JSON support

### Spring Boot

Spring Boot reduces this manual setup through:

* Auto-configuration
* Starter dependencies
* Embedded server support
* Convention over configuration

Conceptually:

```text
Spring MVC
    +
Auto Configuration
    +
Embedded Server Support
    +
Starter Dependencies
    ↓
Spring Boot Development Experience
```

Spring Boot does not replace the core Spring MVC request-processing concepts; it makes setting up and using them significantly easier.

---

# Final Architecture Diagram

```text
                    HTTP Request
                         │
                         ▼
                     ┌────────┐
                     │ Client │
                     └───┬────┘
                         │
                         ▼
                     ┌────────┐
                     │ Tomcat │
                     └───┬────┘
                         │
                         ▼
              ┌─────────────────────┐
              │ DispatcherServlet   │
              └──────────┬──────────┘
                         │
                         ▼
                 ┌───────────────┐
                 │ HandlerMapping│
                 └───────┬───────┘
                         │
                  Finds Matching
                  Controller Method
                         │
                         ▼
                  ┌─────────────┐
                  │ Controller  │
                  └──────┬──────┘
                         │
                         ▼
                    ┌─────────┐
                    │ Service │
                    └────┬────┘
                         │
                         ▼
                  ┌────────────┐
                  │ Repository │
                  └─────┬──────┘
                        │
                        ▼
                    Data Source


Response:

Data Source
    ↓
Repository
    ↓
Service
    ↓
Controller
    ↓
Spring MVC Response Processing
    ↓
Tomcat
    ↓
Client
```

---

# Key Takeaways

* Spring MVC is Spring's web framework.
* It is used to build REST APIs and web applications.
* Tomcat listens for incoming HTTP requests.
* Controllers do **not** directly listen to ports.
* `DispatcherServlet` is the central entry point of Spring MVC.
* `HandlerMapping` helps determine which controller method should handle a request.
* Spring IoC manages controllers, services, repositories, and other beans.
* Request data can commonly come through:

    * Request Body
    * Path Variables
    * Query Parameters
* JSON can be converted to Java objects and Java objects can be converted back to JSON.
* A typical application flow is:

```text
Client
→ Tomcat
→ DispatcherServlet
→ HandlerMapping
→ Controller
→ Service
→ Repository
→ Data Source
```

* The response travels back through the application to the client.
* Spring Boot makes Spring MVC easier to use by reducing manual configuration and boilerplate.
