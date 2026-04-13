# 🔒 Encapsulation in Java

## 📌 Introduction

Encapsulation is one of the core concepts of **Object-Oriented Programming (OOP)**.

It is the process of **wrapping data (variables) and code (methods) into a single unit**, i.e., a class, and restricting direct access to the data.

---

## 🧠 Key Idea

* Hide internal details of an object
* Allow controlled access using methods

👉 Also known as **Data Hiding**

---

## 🔹 How to Achieve Encapsulation

1. Declare variables as **private**
2. Provide **public getter and setter methods**

---

## 🔹 Syntax

```java id="encap_syn"
class ClassName {
    private dataType variable;

    public dataType getVariable() {
        return variable;
    }

    public void setVariable(dataType value) {
        this.variable = value;
    }
}
```

---

## ⚠️ Important Concepts

### 🔸 Access Modifiers

* `private` → restrict direct access
* `public` → allow controlled access

---

### 🔸 Getter Method

* Used to **read** data

---

### 🔸 Setter Method

* Used to **update/modify** data

---

### 🔸 Data Hiding

* Protects data from unauthorized access

---

## 🎯 Advantages of Encapsulation

* Improves **security**
* Provides **controlled access**
* Makes code more **maintainable**
* Increases **flexibility** (you can change logic inside methods without affecting users)

# Java Constructors

## 📌 Overview

This project demonstrates the concept of **constructors in Java**, which are special methods used to initialize objects.

A constructor is automatically called when an object of a class is created.

---

## 🧠 What is a Constructor?

A **constructor** in Java is:

* A special method with the same name as the class
* Has no return type (not even `void`)
* Used to initialize object properties

---

## 🔑 Types of Constructors

### 1. Default Constructor

* Provided by Java if no constructor is defined
* Initializes variables with default values

```java
class Example {
    int x;

    Example() {
        x = 10;
    }
}
```

---

### 2. Parameterized Constructor

* Accepts parameters to initialize variables

```java
class Example {
    int x;

    Example(int value) {
        x = value;
    }
}
```

---

### 3. Copy Constructor

* Creates a new object using another object

```java
class Example {
    int x;

    Example(int value) {
        x = value;
    }

    Example(Example obj) {
        x = obj.x;
    }
}
```



## 📚 Key Points

* Constructor name must match class name
* No return type
* Can be overloaded
* Called automatically during object creation

---

# Inheritance in Java

## 📌 Overview

**Inheritance** is a core concept of Object-Oriented Programming (OOP) that allows one class to acquire the properties and behaviors of another class.

It helps developers build reusable and structured code.

---

## 🧠 What is Inheritance?

Inheritance enables a class (child/subclass) to inherit fields and methods from another class (parent/superclass).

It creates an **"is-a" relationship** between classes.

---

## 🔑 Types of Inheritance in Java

1. **Single Inheritance**
   One class inherits from another class

2. **Multilevel Inheritance**
   A class inherits from a class, which itself inherits from another class

3. **Hierarchical Inheritance**
   Multiple classes inherit from a single parent class

> ⚠️ Java does not support multiple inheritance using classes (it can be achieved using interfaces)

---

## ⚙️ Key Features

* Achieved using the `extends` keyword
* Supports method overriding
* Enables code reuse
* Improves code organization

---

## 📚 Key Concepts

* **Superclass (Parent Class):** The class whose properties are inherited
* **Subclass (Child Class):** The class that inherits properties
* **Method Overriding:** Redefining parent class methods in child class
* **Access Modifiers:** Control visibility of inherited members

---

## 🎯 Advantages

* Promotes code reusability
* Reduces redundancy
* Enhances maintainability
* Supports polymorphism

---

## ⚠️ Disadvantages

* Creates tight coupling between classes
* Changes in parent class may affect child classes
* Can increase complexity in large projects

---

# Method Overloading in Java

## 📌 Overview

**Method Overloading** is a feature in Java that allows a class to have multiple methods with the same name but different parameters.

It is a form of **compile-time polymorphism**.

---

## 🧠 What is Method Overloading?

Method overloading occurs when multiple methods in the same class share the same name but differ in:

* Number of parameters
* Type of parameters
* Order of parameters

---

## 🔑 Key Features

* Same method name
* Different parameter list
* Happens in the same class
* Improves code readability
* Achieves compile-time polymorphism

---

## ⚙️ How it works

The compiler decides which method to call based on the method signature during compilation.

---

## 📚 Rules of Method Overloading

* Methods must have the same name
* Parameters must be different
* Return type alone cannot create overloading
* Access modifiers can be different

---

## 🎯 Advantages

* Increases code readability
* Reduces complexity
* Improves reusability
* Makes program easier to maintain

---

# Method Overriding in Java

## 📌 Overview

**Method Overriding** is a feature in Java that allows a subclass to provide a specific implementation of a method that is already defined in its superclass.

It is a key part of **runtime polymorphism**.

---

## 🧠 What is Method Overriding?

Method overriding occurs when a child class defines a method that has the same:

* Method name
* Parameters
* Return type

as the method in the parent class.

---

## 🔑 Key Features

* Requires inheritance
* Same method signature in parent and child class
* Decided at runtime
* Supports dynamic method dispatch

---

## ⚙️ Rules of Method Overriding

* Method must have the same name and parameters
* Must be done in different classes (parent-child relationship)
* Cannot reduce access level (e.g., public → private not allowed)
* `@Override` annotation is optional but recommended

---

## 🎯 Advantages

* Provides specific implementation in child class
* Improves flexibility
* Supports runtime polymorphism
* Enhances code maintainability

---

# Polymorphism in Java

## 📌 Overview

**Polymorphism** is one of the core concepts of Object-Oriented Programming (OOP) in Java. It allows a single action to behave in different ways.

The word *polymorphism* means **"many forms"**.

---

## 🧠 What is Polymorphism?

Polymorphism allows a method, object, or operator to behave differently based on the context.

In Java, polymorphism is mainly achieved in two ways:

* **Compile-time Polymorphism (Method Overloading)**
* **Runtime Polymorphism (Method Overriding)**

---

## 🔑 Types of Polymorphism

### 1. Compile-time Polymorphism

* Achieved using method overloading
* Method call is resolved at compile time
* Faster execution

---

### 2. Runtime Polymorphism

* Achieved using method overriding
* Method call is resolved at runtime
* Uses inheritance

---

## ⚙️ Key Features

* One interface, multiple implementations
* Improves flexibility and scalability
* Supports dynamic behavior
* Reduces code complexity

---

## 🎯 Advantages

* Increases code reusability
* Improves readability
* Supports dynamic method dispatch
* Makes code extensible

---

# Abstraction in Java

## 📌 Overview

**Abstraction** is an OOP concept that focuses on hiding implementation details and showing only the essential features of an object.

It helps reduce complexity and increases efficiency.

---

## 🧠 What is Abstraction?

Abstraction means **hiding internal details** and showing only the necessary functionality to the user.

Example idea:

* You know how to use a mobile phone
* But you don’t know its internal working → that is abstraction

---

## 🔑 Ways to Achieve Abstraction in Java

1. **Abstract Classes**
2. **Interfaces**

---

## ⚙️ Abstract Class

* Declared using `abstract` keyword
* Can have both abstract and non-abstract methods
* Cannot create object of abstract class

---

## ⚙️ Interface

* Used to achieve full abstraction
* Contains only abstract methods (Java 7 and earlier)
* Supports multiple inheritance

---

## 🎯 Key Features

* Hides implementation details
* Shows only essential features
* Achieved using abstract classes and interfaces
* Improves code security and reusability

---

## 📚 Rules of Abstraction

* Cannot instantiate abstract class
* Abstract methods must be implemented in child class
* Interface methods must be overridden

---

## 🎯 Advantages

* Reduces complexity
* Improves security
* Increases reusability
* Enhances maintainability

---

# Upcasting and Downcasting in Java

## 📌 Overview

In Java, **upcasting and downcasting** are used to convert objects between parent and child class types in an inheritance hierarchy.

They are important concepts in **runtime polymorphism**.

---

## 🧠 What is Upcasting?

**Upcasting** is when a child class object is assigned to a parent class reference.

### ✔ Key Idea:

* Child → Parent conversion
* Done automatically (implicit)
* Used for generalization

---

## 🧠 What is Downcasting?

**Downcasting** is when a parent class reference is converted back to a child class type.

### ✔ Key Idea:

* Parent → Child conversion
* Must be done manually (explicit)
* Used for accessing child-specific methods

---

## 🔑 Key Features

### Upcasting:

* Automatic conversion
* Safe
* Only parent class methods are accessible

### Downcasting:

* Manual conversion
* Risky (may cause `ClassCastException`)
* Allows access to child-specific methods

---

## ⚙️ Rules

* Upcasting happens implicitly
* Downcasting requires explicit casting
* Must be used with inheritance
* Object must actually be of child type before downcasting

---

## 🎯 Advantages

* Supports polymorphism
* Enables flexible code design
* Helps in method overriding usage
* Improves code reusability

---

# Interfaces in Java

## 📌 Overview

An **interface** in Java is a blueprint of a class that defines a set of abstract methods that a class must implement.

It is used to achieve **100% abstraction** and **multiple inheritance** in Java.

---

## 🧠 What is an Interface?

An interface is a reference type in Java that contains:

* Abstract methods (by default)
* Constants (public static final variables)
* No object creation allowed

A class implements an interface using the `implements` keyword.

---

## 🔑 Key Features

* Achieves full abstraction
* Supports multiple inheritance
* Methods are public and abstract by default (Java 7 and earlier)
* Variables are public, static, and final by default
* Cannot be instantiated

---

## ⚙️ Why Use Interfaces?

* To achieve abstraction
* To support multiple inheritance
* To achieve loose coupling
* To define common behavior for unrelated classes

---

## 📚 Rules of Interfaces

* A class must implement all methods of an interface
* Interface methods must be overridden
* Multiple interfaces can be implemented by a single class
* Interface cannot have constructors

---

## 🎯 Advantages

* Provides full abstraction
* Supports multiple inheritance
* Improves code flexibility
* Makes system design scalable

---
