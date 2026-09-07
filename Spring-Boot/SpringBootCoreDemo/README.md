# Spring Boot Core Demo

A beginner-friendly Spring Boot project created to understand the **core concepts of Spring Boot**, including Spring vs Spring Boot, Dependency Injection, important annotations, `application.properties`, configuration binding, `ApplicationRunner`, and Bean creation.

---

## Project Structure

```text
SpringBootCoreDemo/
│
├── .gitignore
├── pom.xml
│
├── .idea/
│
├── .mvn/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── org/
│   │   │       └── akshat/
│   │   │           │
│   │   │           ├── Main.java
│   │   │           ├── OrderService.java
│   │   │           ├── PaymentService.java
│   │   │           ├── Test.java
│   │   │           │
│   │   │           └── demo/
│   │   │               ├── DemoApplication.java
│   │   │               ├── DemoRunner.java
│   │   │               ├── PaymentGateway.java
│   │   │               └── PaymentProperties.java
│   │   │
│   │   └── resources/
│   │       └── application.properties
│   │
│   └── test/
│       └── java/
│
└── target/
```

> **Note:** The `target/` directory contains generated Maven build files and compiled `.class` files. It should not normally be edited manually or committed to Git.

---

# 1. What is Spring?

**Spring** is a Java framework used to build enterprise applications.

Some important features provided by Spring are:

* Inversion of Control (IoC)
* Dependency Injection (DI)
* Aspect-Oriented Programming
* Database integration
* Web development
* Transaction management
* Security
* REST API development

One of the most important concepts in Spring is:

> **Dependency Injection**

Instead of creating objects manually:

```java
PaymentService paymentService = new PaymentService();
```

Spring can create and manage the object for us.

---

# 2. What is Spring Boot?

**Spring Boot** is built on top of the Spring Framework.

It simplifies Spring application development by providing:

* Auto Configuration
* Starter Dependencies
* Embedded Servers
* Production-ready features
* Reduced configuration
* Easy project setup

A Spring Boot application can be started using:

```java
SpringApplication.run(DemoApplication.class, args);
```

---

# 3. Spring vs Spring Boot

| Spring                           | Spring Boot                   |
| -------------------------------- | ----------------------------- |
| Java framework                   | Built on top of Spring        |
| Requires more configuration      | Reduces configuration         |
| More manual setup                | Auto-configuration            |
| Server setup can be manual       | Embedded server               |
| More configuration files         | Convention over configuration |
| Flexible but configuration-heavy | Faster development            |

### Easy way to remember

```text
Spring
   ↓
Framework

Spring Boot
   ↓
Simplifies Spring development
```

Spring Boot does **not replace Spring**.

It makes Spring applications easier and faster to build.

---

# 4. Inversion of Control (IoC)

Normally, Java code creates its own objects.

Example:

```java
PaymentService paymentService = new PaymentService();
```

Here, the developer controls object creation.

With Spring:

```text
Developer
    ↓
Defines classes and dependencies
    ↓
Spring Container
    ↓
Creates and manages objects
```

The responsibility of object creation and management is transferred to Spring.

This is called:

> **Inversion of Control (IoC)**

Objects managed by Spring are called:

> **Beans**

---

# 5. Dependency Injection

Dependency Injection means that a class receives the objects it depends on instead of creating them itself.

For example:

```java
@Component
public class PaymentService {

}
```

`OrderService` requires `PaymentService`:

```java
@Component
public class OrderService {

    private final PaymentService paymentService;

    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
}
```

Spring automatically creates `PaymentService` and injects it into `OrderService`.

### Dependency flow

```text
OrderService
      |
      | depends on
      ↓
PaymentService
```

Spring manages this dependency.

---

# 6. Constructor Injection

The project uses **constructor injection** for dependency injection.

Example:

```java
@Component
public class OrderService {

    private final PaymentService paymentService;

    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
}
```

Constructor injection is generally preferred because:

* Dependencies are explicit
* Dependencies can be `final`
* Easier unit testing
* Prevents partially initialized objects
* Encourages better class design

If a class has only one constructor, `@Autowired` is not required.

---

# 7. Important Spring Boot Annotations

| Annotation                 | Purpose                            |
| -------------------------- | ---------------------------------- |
| `@SpringBootApplication`   | Main Spring Boot configuration     |
| `@Component`               | Registers a class as a Spring Bean |
| `@Service`                 | Marks business logic class         |
| `@Repository`              | Marks data-access class            |
| `@Controller`              | Creates MVC controller             |
| `@RestController`          | Creates REST controller            |
| `@Autowired`               | Dependency injection               |
| `@Configuration`           | Configuration class                |
| `@Bean`                    | Explicit Bean creation             |
| `@Value`                   | Reads property values              |
| `@ConfigurationProperties` | Binds configuration properties     |
| `@GetMapping`              | Maps HTTP GET requests             |
| `@PostMapping`             | Maps HTTP POST requests            |

---

# 8. @Component

`@Component` tells Spring to create and manage an object of the class.

Example:

```java
@Component
public class PaymentService {

    public void pay() {
        System.out.println("Payment successful");
    }
}
```

Spring detects the class through component scanning and creates a Bean.

---

# 9. @Service

`@Service` is used for classes that contain business logic.

Example:

```java
@Service
public class OrderService {

    public void createOrder() {
        System.out.println("Order created");
    }
}
```

`@Service` is a specialized form of `@Component`.

```text
@Component
    ↑
 @Service
```

---

# 10. @Repository

`@Repository` is normally used for classes responsible for database operations.

Example:

```java
@Repository
public class UserRepository {

}
```

It is also a specialized form of `@Component`.

---

# 11. @Controller

`@Controller` is used for Spring MVC controllers.

Example:

```java
@Controller
public class HomeController {

}
```

It is generally used when the application returns views such as HTML pages.

---

# 12. @RestController

`@RestController` is commonly used to create REST APIs.

Example:

```java
@RestController
public class UserController {

    @GetMapping("/users")
    public String getUsers() {
        return "Users";
    }
}
```

`@RestController` combines:

```text
@Controller
+
@ResponseBody
```

Therefore, returned values are written directly to the HTTP response.

---

# 13. @Autowired

`@Autowired` tells Spring to inject a dependency.

Example:

```java
@Component
public class OrderService {

    @Autowired
    private PaymentService paymentService;
}
```

However, constructor injection is generally preferred.

Instead of:

```java
@Autowired
private PaymentService paymentService;
```

Prefer:

```java
private final PaymentService paymentService;

public OrderService(PaymentService paymentService) {
    this.paymentService = paymentService;
}
```

---

# 14. @Configuration

`@Configuration` is used to define a configuration class.

Example:

```java
@Configuration
public class AppConfig {

}
```

It is commonly used with `@Bean`.

---

# 15. @Bean

`@Bean` tells Spring to manage the object returned by a method.

Example:

```java
@Configuration
public class AppConfig {

    @Bean
    public PaymentGateway paymentGateway() {
        return new PaymentGateway();
    }
}
```

Spring will create and manage the returned `PaymentGateway` object.

### @Component vs @Bean

Use `@Component` when you can annotate the class directly:

```java
@Component
public class PaymentService {

}
```

Use `@Bean` when you want explicit control over object creation:

```java
@Bean
public PaymentGateway paymentGateway() {
    return new PaymentGateway();
}
```

---

# 16. @SpringBootApplication

The main Spring Boot class in this project is:

```text
DemoApplication.java
```

It contains:

```java
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
```

`@SpringBootApplication` is one of the most important annotations in Spring Boot.

It combines:

```text
@SpringBootApplication
        |
        +── @Configuration
        |
        +── @EnableAutoConfiguration
        |
        +── @ComponentScan
```

### @Configuration

Indicates that the class contains Spring configuration.

### @EnableAutoConfiguration

Enables Spring Boot's automatic configuration.

### @ComponentScan

Searches for Spring components such as:

```text
@Component
@Service
@Repository
@Controller
```

and registers them as Beans.

---

# 17. Package Structure and Component Scanning

The project contains:

```text
org.akshat.demo
```

with:

```text
DemoApplication.java
DemoRunner.java
PaymentGateway.java
PaymentProperties.java
```

The main application class should generally be placed in a package above the components that need to be discovered.

For example:

```text
org.akshat
└── demo
    ├── DemoApplication
    ├── DemoRunner
    ├── PaymentGateway
    └── PaymentProperties
```

Spring's component scanning can then discover classes in the relevant sub-packages.

---

# 18. application.properties

The project's configuration file is:

```text
src/main/resources/application.properties
```

This is the **source configuration file**.

Example:

```properties
spring.application.name=SpringBootCoreDemo
```

Application properties allow configuration to be kept outside Java code.

---

# 19. Why use application.properties?

Instead of hardcoding configuration:

```java
String applicationName = "SpringBootCoreDemo";
```

we can write:

```properties
app.name=SpringBootCoreDemo
```

and read it from Java.

This makes configuration easier to change without modifying application logic.

---

# 20. Common application.properties Configuration

### Application Name

```properties
spring.application.name=SpringBootCoreDemo
```

### Server Port

```properties
server.port=8081
```

### Custom Property

```properties
app.payment-provider=Stripe
```

Configuration can be changed depending on the environment.

For example:

```text
Development
     ↓
application.properties

Production
     ↓
different configuration
```

---

# 21. @Value

`@Value` can be used to read a value from `application.properties`.

Example:

```properties
app.payment-provider=Stripe
```

Java:

```java
@Component
public class PaymentGateway {

    @Value("${app.payment-provider}")
    private String provider;

}
```

Spring injects:

```text
Stripe
```

into the `provider` variable.

---

# 22. @ConfigurationProperties

Instead of reading every property individually using `@Value`, related properties can be grouped together using `@ConfigurationProperties`.

Example:

```properties
payment.provider=Stripe
payment.currency=INR
payment.timeout=30
```

A configuration class can represent these properties:

```java
@ConfigurationProperties(prefix = "payment")
public class PaymentProperties {

    private String provider;
    private String currency;
    private int timeout;

}
```

This is useful when there are multiple related configuration values.

### Concept

```text
application.properties
        ↓
@ConfigurationProperties
        ↓
Java Object
        ↓
Application Code
```

---

# 23. PaymentProperties

This project contains:

```text
PaymentProperties.java
```

Its purpose is to represent payment-related configuration.

Instead of scattering configuration values throughout the application, related configuration can be grouped into one Java object.

For example:

```text
payment.provider
payment.currency
payment.timeout
```

can be represented by:

```java
PaymentProperties
```

This makes configuration cleaner and easier to maintain.

---

# 24. ApplicationRunner

The project contains:

```text
DemoRunner.java
```

`ApplicationRunner` is used to execute code **after the Spring Boot application has started**.

Example:

```java
@Component
public class DemoRunner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) {
        System.out.println("Application started");
    }
}
```

The execution flow is:

```text
Spring Boot starts
        ↓
Application Context created
        ↓
Beans created
        ↓
Dependencies injected
        ↓
Application starts
        ↓
ApplicationRunner.run()
        ↓
Startup logic executes
```

---

# 25. Why use ApplicationRunner?

`ApplicationRunner` is useful for:

* Initializing application data
* Testing Beans
* Running startup logic
* Loading configuration
* Performing startup checks
* Debugging
* Executing one-time initialization tasks

Example:

```java
@Component
public class DemoRunner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) {
        System.out.println("Spring Boot application has started!");
    }
}
```

---

# 26. ApplicationRunner vs CommandLineRunner

Spring Boot provides two similar interfaces:

```text
ApplicationRunner
CommandLineRunner
```

### ApplicationRunner

Uses:

```java
ApplicationArguments
```

Example:

```java
@Override
public void run(ApplicationArguments args) {
}
```

### CommandLineRunner

Uses:

```java
String... args
```

Example:

```java
@Override
public void run(String... args) {
}
```

### Difference

```text
ApplicationRunner
        ↓
ApplicationArguments

CommandLineRunner
        ↓
String arguments
```

Both execute after the Spring Boot application starts.

---

# 27. PaymentGateway

The project contains:

```text
PaymentGateway.java
```

This class can be used to demonstrate how Spring manages application components and dependencies.

For example:

```java
@Component
public class PaymentGateway {

    public void processPayment() {
        System.out.println("Processing payment...");
    }
}
```

Once registered as a Bean, it can be injected into another component.

---

# 28. OrderService and PaymentService

The project also contains:

```text
OrderService.java
PaymentService.java
```

These classes demonstrate **Dependency Injection**.

The dependency relationship is:

```text
OrderService
      |
      | requires
      ↓
PaymentService
```

Instead of `OrderService` creating the `PaymentService` itself:

```java
new PaymentService();
```

Spring provides it through constructor injection.

---

# 29. Complete Application Flow

The concepts in this project can be connected together as:

```text
DemoApplication
       ↓
SpringApplication.run()
       ↓
Spring Boot starts
       ↓
Application Context created
       ↓
Component Scanning
       ↓
Spring finds @Component / @Service / etc.
       ↓
Beans are created
       ↓
Dependencies are injected
       ↓
application.properties is loaded
       ↓
@ConfigurationProperties binds configuration
       ↓
Application starts
       ↓
DemoRunner executes
       ↓
Application is ready
```

---

# 30. Source vs Target Directory

The project contains both:

```text
src/
```

and:

```text
target/
```

### src

Contains the actual source code.

```text
src/main/java
src/main/resources
src/test/java
```

### target

Contains generated build output.

```text
target/
├── classes/
├── test-classes/
├── generated-sources/
└── *.jar
```

For example:

```text
src/main/resources/application.properties
```

is the source configuration file.

Maven copies it into:

```text
target/classes/application.properties
```

during the build.

Therefore:

> **Always modify the file inside `src/main/resources`, not the generated file inside `target/classes`.**

Changes made directly inside `target` can be overwritten during the next Maven build.

---

# 31. Maven

The project uses Maven.

The main Maven configuration file is:

```text
pom.xml
```

Maven is responsible for:

* Dependency management
* Compilation
* Testing
* Packaging
* Build lifecycle

Common commands:

```bash
mvn clean
```

```bash
mvn compile
```

```bash
mvn test
```

```bash
mvn package
```

The packaged JAR is generated inside:

```text
target/
```

---

# 32. Important Files in This Project

| File                     | Purpose                              |
| ------------------------ | ------------------------------------ |
| `DemoApplication.java`   | Main Spring Boot application         |
| `DemoRunner.java`        | Demonstrates `ApplicationRunner`     |
| `PaymentGateway.java`    | Payment-related Bean/component       |
| `PaymentProperties.java` | Configuration properties binding     |
| `OrderService.java`      | Demonstrates dependency injection    |
| `PaymentService.java`    | Dependency used by `OrderService`    |
| `application.properties` | Application configuration            |
| `pom.xml`                | Maven configuration                  |
| `Main.java`              | Java entry-point experimentation     |
| `Test.java`              | Java/Spring learning experimentation |

---

# 33. Quick Revision

```text
Spring
  ↓
Java Framework

Spring Boot
  ↓
Simplifies Spring

IoC
  ↓
Spring manages objects

Bean
  ↓
Object managed by Spring

Dependency Injection
  ↓
Spring provides dependencies

@Component
  ↓
Creates Spring Bean

@Service
  ↓
Business Logic

@Repository
  ↓
Data Access

@Controller
  ↓
MVC

@RestController
  ↓
REST API

@Configuration
  ↓
Configuration Class

@Bean
  ↓
Explicit Bean Creation

@SpringBootApplication
  ↓
@Configuration
+ @EnableAutoConfiguration
+ @ComponentScan

application.properties
  ↓
Application Configuration

@Value
  ↓
Read individual property

@ConfigurationProperties
  ↓
Bind related properties

ApplicationRunner
  ↓
Execute logic after startup
```

---

# 34. Key Takeaways

1. **Spring is a Java framework; Spring Boot simplifies Spring development.**
2. **IoC means Spring takes responsibility for managing objects.**
3. **A Bean is an object managed by the Spring container.**
4. **Dependency Injection allows Spring to provide required dependencies.**
5. **Constructor injection is generally preferred over field injection.**
6. **`@Component` registers a class as a Spring Bean.**
7. **`@Service`, `@Repository`, and `@Controller` are specialized component annotations.**
8. **`@RestController` is commonly used for REST APIs.**
9. **`@SpringBootApplication` combines configuration, auto-configuration, and component scanning.**
10. **`application.properties` should be maintained under `src/main/resources`.**
11. **`target/` contains generated build output and should not normally be edited.**
12. **`@Value` can inject individual configuration values.**
13. **`@ConfigurationProperties` is useful for grouping related configuration.**
14. **`ApplicationRunner` executes startup logic after the application starts.**
15. **Maven manages the project's dependencies and build lifecycle.**

---
