# XML-Based Configuration in Spring

This module demonstrates how to configure and manage Spring objects using **XML-based configuration**.

The purpose of this project is to understand the fundamentals of the Spring Framework, especially how **IoC (Inversion of Control)** and **Dependency Injection (DI)** work using XML configuration.

## 📌 What is XML-Based Configuration?

In XML-based configuration, Spring uses an XML file to define:

* Beans
* Dependencies
* Bean scopes
* Constructor injection
* Setter injection
* Other Spring configuration details

Instead of using annotations such as `@Component` or `@Autowired`, we define the configuration inside an XML file.

## 📂 Project Structure

```text
src/
├── main/
│   ├── java/
│   │   └── ...
│   └── resources/
│       └── beans.xml
└── test/
    └── java/
```

The `applicationContext.xml` file contains the Spring bean configuration.

## 🔄 How It Works

The basic flow is:

```text
applicationContext.xml
        ↓
Spring Container
        ↓
Bean Creation
        ↓
Dependency Injection
        ↓
Application
```

Spring reads the XML configuration file and creates the objects (beans) defined inside it.

## 🫘 Defining a Bean

A bean can be defined using the `<bean>` element:

```xml
<bean id="student" class="com.example.Student"/>
```

Here:

* `id` → Unique name of the bean
* `class` → Fully qualified class name
* Spring creates and manages the object

## 💉 Dependency Injection

Spring can inject dependencies into objects using XML configuration.

### Constructor Injection

```xml
<bean id="student" class="com.example.Student">
    <constructor-arg ref="address"/>
</bean>

<bean id="address" class="com.example.Address"/>
```

Spring creates the `Address` object and passes it to the `Student` constructor.

### Setter Injection

```xml
<bean id="student" class="com.example.Student">
    <property name="address" ref="address"/>
</bean>

<bean id="address" class="com.example.Address"/>
```

Spring uses the setter method to inject the dependency.

## 🌱 Spring Container

The Spring Container is responsible for:

1. Reading the configuration
2. Creating beans
3. Managing bean lifecycle
4. Injecting dependencies
5. Providing beans when required

Example:

```java
ApplicationContext context =
        new ClassPathXmlApplicationContext("applicationContext.xml");

Student student = context.getBean("student", Student.class);
```

## 🧠 Key Concepts Learned

* Spring IoC Container
* Inversion of Control (IoC)
* Dependency Injection (DI)
* XML Configuration
* Spring Beans
* Constructor Injection
* Setter Injection
* `ApplicationContext`
* `ClassPathXmlApplicationContext`
* Bean Lifecycle
* Bean Scopes

## ⚖️ XML Configuration vs Annotation Configuration

| XML Configuration                   | Annotation Configuration                   |
| ----------------------------------- | ------------------------------------------ |
| Configuration is written in XML     | Configuration is written using annotations |
| Less Java code                      | Less XML                                   |
| Dependencies are explicitly defined | Dependencies can be automatically detected |
| Common in older Spring applications | Common in modern Spring applications       |

## ▶️ Running the Project

Make sure Java and Maven are installed.

Compile the project:

```bash
mvn clean compile
```

Run tests:

```bash
mvn test
```

If this is a Spring Boot application, it can be started using:

```bash
mvn spring-boot:run
```

## 🎯 Purpose of This Module

This project is part of my journey to learn **Spring Boot and Java Backend Development from scratch**.

I am starting with the fundamentals of the Spring Framework and understanding how Spring manages objects and their dependencies before moving toward annotation-based and Spring Boot configurations.


