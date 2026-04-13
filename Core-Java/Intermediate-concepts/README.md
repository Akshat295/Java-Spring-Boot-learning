# 🏗️ Classes and Objects in Java

## 📌 Introduction

Java is an **object-oriented programming (OOP)** language.
The core concepts of OOP are **classes** and **objects**.

* A **class** is a blueprint or template
* An **object** is an instance of a class

---

## 🧠 What is a Class?

A class is a user-defined data type that contains:

* **Variables (data / attributes)**
* **Methods (functions / behavior)**

It defines the structure and behavior that objects created from it will have.

---

## 🧠 What is an Object?

An object is a real-world entity created from a class.
It represents a specific instance with actual values.

---

## 🔹 Syntax of Class

```java id="cls123"
class ClassName {
    // variables (fields)
    dataType variableName;

    // methods
    returnType methodName() {
        // code
    }
}
```

---

## 🔹 Syntax of Object Creation

```java id="obj123"
ClassName objectName = new ClassName();
```

---

## ⚙️ Accessing Members

* Variables and methods are accessed using the **dot (`.`) operator**

```java id="dot123"
objectName.variableName
objectName.methodName()
```

---

## ⚠️ Important Concepts

### 🔸 Constructor

* Special method used to initialize objects
* Same name as class
* Called automatically when object is created

---

### 🔸 this Keyword

* Refers to the current object
* Used to differentiate instance variables from parameters

---

### 🔸 Multiple Objects

* Multiple objects can be created from one class
* Each object has its own copy of instance variables

---
# 📚 Arrays in Java

## 📌 Introduction

An **array** in Java is a collection of elements of the same data type stored in contiguous memory locations. It is used to store multiple values in a single variable instead of declaring separate variables.

---

## 🧠 Key Features

* Stores **multiple values of same data type**
* Fixed size (defined at the time of creation)
* Index-based access (starts from 0)
* Faster access using index

---

## 🔹 Syntax of Array Declaration

```java id="arrsyn1"
dataType[] arrayName;
```

---

## 🔹 Syntax of Array Creation

```java id="arrsyn2"
arrayName = new dataType[size];
```

---

## 🔹 Syntax of Declaration + Initialization

```java id="arrsyn3"
dataType[] arrayName = {value1, value2, value3};
```

---

## 🔹 Accessing Elements

```java id="arrsyn4"
arrayName[index];
```

---

## ⚠️ Important Concepts

### 🔸 Indexing

* Array index starts from **0**
* Last index = size - 1

---

### 🔸 Array Length

* Use `.length` to get size of array

---

### 🔸 Fixed Size

* Cannot change size after creation

---

### 🔸 Default Values

| Data Type | Default Value |
| --------- | ------------- |
| int       | 0             |
| double    | 0.0           |
| boolean   | false         |
| object    | null          |

---

# 🔤 Strings, StringBuilder, and StringBuffer in Java

## 📌 Introduction

In Java, text data is handled using:

* **String**
* **StringBuilder**
* **StringBuffer**

They differ mainly in **mutability** and **thread safety**.

---

## 🧠 1. String

### 🔹 Definition

A `String` is an immutable sequence of characters.

👉 Immutable means:

* Once created, it **cannot be changed**

---

### 🔹 Key Features

* Stored in **String Pool**
* Any modification creates a **new object**
* Memory efficient but slower for frequent changes

---

## 🧠 2. StringBuilder

### 🔹 Definition

A `StringBuilder` is a mutable sequence of characters.

👉 Mutable means:

* Can be modified without creating new objects

---

### 🔹 Key Features

* Faster than String
* Not thread-safe
* Suitable for single-threaded environments

---

## 🧠 3. StringBuffer

### 🔹 Definition

A `StringBuffer` is also mutable but **thread-safe**.

---

### 🔹 Key Features

* Slower than StringBuilder
* Safe for multi-threaded environments
* Methods are synchronized

---

## ⚖️ Difference Between String, StringBuilder, StringBuffer

| Feature       | String    | StringBuilder | StringBuffer |
| ------------- | --------- | ------------- | ------------ |
| Mutability    | Immutable | Mutable       | Mutable      |
| Performance   | Slow      | Fast          | Medium       |
| Thread Safety | Yes       | No            | Yes          |
| Memory Usage  | More      | Less          | More         |

---

## ⚠️ Important Concepts

### 🔸 String Pool

Special memory area where string literals are stored to optimize memory usage.

---

### 🔸 Immutability

String objects cannot be changed once created.

---

### 🔸 Thread Safety

* `StringBuffer` is thread-safe (synchronized)
* `StringBuilder` is not thread-safe

---
