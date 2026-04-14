# Annotations in Java

## 📌 Overview

**Annotations** in Java are metadata that provide additional information about the program but do not affect the execution of the code directly.

They are used by the compiler, tools, and frameworks to process code in a specific way.

---

## 🧠 What is an Annotation?

An annotation is a special form of syntactic metadata added to Java code using the `@` symbol.

It helps:

* Provide instructions to compiler
* Help frameworks (like Spring, Hibernate)
* Improve code readability and maintainability

---

## 🔑 Built-in Annotations in Java

### 1. `@Override`

Used to indicate a method is overriding a superclass method.

### 2. `@Deprecated`

Marks a method/class as outdated and not recommended for use.

### 3. `@SuppressWarnings`

Used to suppress compiler warnings.

---

## ⚙️ Meta-Annotations (Annotations for annotations)

* `@Retention` → Defines how long annotation is retained
* `@Target` → Defines where annotation can be used
* `@Inherited` → Allows annotation inheritance
* `@Documented` → Includes annotation in Javadoc

---

## 🎯 Key Features

* Provide metadata about code
* Do not change program logic
* Used heavily in frameworks like Spring
* Improve code clarity and structure

---

## 🚀 Advantages

* Reduces boilerplate code
* Improves code maintainability
* Helps in compile-time checks
* Supports framework configuration

---

## ⚠️ Limitations

* Do not directly affect runtime logic
* Overuse can make code complex
* Requires understanding of frameworks for full use

---
# Exception Handling in Java

## 📌 Overview

**Exception Handling** in Java is a mechanism used to handle runtime errors so that the normal flow of the program can be maintained.

It prevents the program from crashing unexpectedly.

---

## 🧠 What is an Exception?

An **exception** is an event that disrupts the normal flow of a program during execution.

Example causes:

* Divide by zero
* File not found
* Null pointer access
* Invalid input

---

## 🔑 Types of Exceptions

### 1. Checked Exceptions

* Checked at compile time
* Must be handled using try-catch or throws
* Example: IOException, SQLException

### 2. Unchecked Exceptions

* Occur at runtime
* Not checked by compiler
* Example: ArithmeticException, NullPointerException

---

## ⚙️ Keywords Used in Exception Handling

### 1. `try`

Block where risky code is written

### 2. `catch`

Handles the exception

### 3. `finally`

Always executes (used for cleanup)

### 4. `throw`

Used to explicitly throw an exception

### 5. `throws`

Declares exceptions in method signature

---

## 🎯 Key Features

* Prevents program crash
* Improves program reliability
* Handles runtime errors gracefully
* Separates error handling logic

---

## 🚀 Advantages

* Maintains normal program flow
* Improves debugging
* Increases application stability
* Provides meaningful error messages

---

## ⚠️ Disadvantages

* Can increase code complexity
* Improper handling may hide bugs
* Slight performance overhead

---
--

# 🧵 Thread in Java

## 📌 Introduction

A **Thread** in Java is a lightweight process used for **multitasking**.

Threads allow a program to **execute multiple tasks simultaneously**.

This is called **Multithreading**.

---

# 🔹 What is Thread?

### 📖 Definition

A **Thread** is a separate path of execution inside a program.

* Multiple threads run concurrently
* Improves performance
* Saves CPU time
* Used for background tasks

---

# 🔹 Ways to Create Thread

Java provides **2 ways**:

1. By extending **Thread class**
2. By implementing **Runnable interface**

---

# 🔹 Method 1: Extending Thread Class

### Syntax

```java
class MyThread extends Thread {

    public void run() {

    }
}
```

Start thread:

```java
MyThread t = new MyThread();
t.start();
```

---

# 🔹 Method 2: Implementing Runnable Interface

### Syntax

```java
class MyThread implements Runnable {

    public void run() {

    }
}
```

Start thread:

```java
MyThread obj = new MyThread();
Thread t = new Thread(obj);
t.start();
```

---

# 🔹 Thread Life Cycle

1. New
2. Runnable
3. Running
4. Waiting / Blocked
5. Terminated

---

# 🔹 Important Thread Methods

| Method    | Description     |
| --------- | --------------- |
| start()   | starts thread   |
| run()     | thread task     |
| sleep()   | pause thread    |
| join()    | wait for thread |
| getName() | get thread name |
| setName() | set thread name |

---

# 🔹 sleep() Syntax

```java
Thread.sleep(1000);
```

(1000 ms = 1 second)

---

# 🔹 Thread Example Structure

```java
class MyThread extends Thread {

    public void run() {
        // code to execute
    }
}

public class Test {

    public static void main(String[] args) {

        MyThread t = new MyThread();
        t.start();
    }
}
```

---

# 🔹 Key Points

✔ Thread used for multitasking
✔ start() method starts thread
✔ run() contains thread logic
✔ sleep() pauses thread
✔ Multiple threads run concurrently
✔ Improves performance

---

# 🚀 Summary

* Thread = lightweight process
* Used for multithreading
* Two ways to create thread
* start() begins execution
* run() contains logic
* Used in real-time applications

---

# 📚 Collection Framework in Java

## 📌 Definition

The **Collection Framework** in Java is a set of **classes and interfaces** used to **store and manipulate a group of objects dynamically**.

It is present in:

```java
java.util package
```

Collections provide:

* Dynamic size
* Built-in methods
* Easy data handling

---

# 🔹 Collection Hierarchy

```
                 Iterable
                     |
                 Collection
          ┌──────────┼──────────┐
          |          |          |
         List        Set       Queue
                                  |
                                 Deque
```

### Map (Separate Hierarchy)

```
Map
 ├── HashMap
 ├── LinkedHashMap
 ├── TreeMap
 └── Hashtable
```

---

# 🔹 List Implementations

* ArrayList
* LinkedList
* Vector

---

# 🔹 Set Implementations

* HashSet
* LinkedHashSet
* TreeSet

---

# 🔹 Queue Implementations

* PriorityQueue
* ArrayDeque

---

# 🔹 Key Points

✔ List → ordered, duplicates allowed
✔ Set → no duplicates
✔ Queue → FIFO
✔ Map → key-value pairs

---

# 🚀 Summary

* Collection framework stores group of objects
* Located in **java.util** package
* Main interfaces → List, Set, Queue
* Map is separate hierarchy
* List allows duplicates
* Set does not allow duplicates
* Queue follows FIFO order
* Used for dynamic data handling

---

# 📋 List Interface in Java

## 📌 Definition

**List** is an interface in Java Collection Framework used to **store ordered collection of elements**.

It allows:

* Duplicate values
* Insertion order maintained
* Index-based access
* Dynamic size

List is present in:

```java
java.util package
```

---

# 🔹 List Hierarchy

```
Iterable
   |
Collection
   |
   List
  ├── ArrayList
  ├── LinkedList
  └── Vector
```

---

# 🔹 Main Implementations

### ArrayList

* Dynamic array
* Fast access
* Slow insertion

### LinkedList

* Doubly linked list
* Fast insertion
* Slow access

### Vector

* Thread safe
* Slow performance

---

# 🔹 List Syntax

```java
List<Integer> list = new ArrayList<>();
```

---

# 🔹 Common List Methods

| Method     | Description    |
| ---------- | -------------- |
| add()      | add element    |
| get()      | get element    |
| set()      | update element |
| remove()   | remove element |
| size()     | list size      |
| contains() | check element  |

---

# 🔹 Key Points

✔ List maintains insertion order
✔ Allows duplicate elements
✔ Index based access
✔ Dynamic size
✔ Part of Collection framework

---

# 🚀 Summary

* List stores ordered elements
* Duplicates allowed
* Index based access
* ArrayList, LinkedList, Vector implementations
* Used for dynamic collections

--- 

# 🔗 LinkedList in Java

## 📌 Definition

**LinkedList** is a class in Java Collection Framework that **stores elements using doubly linked list structure**.

Each element is called a **node** and contains:

* Data
* Address of next node
* Address of previous node

LinkedList is present in:

```java
java.util package
```

---

# 🔹 LinkedList Hierarchy

```
Iterable
   |
Collection
   |
   List
    |
LinkedList
```

---

# 🔹 Features of LinkedList

* Maintains insertion order
* Allows duplicate elements
* Dynamic in size
* Fast insertion and deletion
* Slow random access
* Implements List and Deque

---

# 🔹 LinkedList Syntax

```java
LinkedList<Type> list = new LinkedList<>();
```

---

# 🔹 Example Syntax

```java
LinkedList<Integer> list = new LinkedList<>();
```

---

# 🔹 Common LinkedList Methods

| Method        | Description      |
| ------------- | ---------------- |
| add()         | add element      |
| addFirst()    | add at beginning |
| addLast()     | add at end       |
| remove()      | remove element   |
| removeFirst() | remove first     |
| removeLast()  | remove last      |
| get()         | get element      |
| size()        | list size        |

---

# 🔹 Key Points

✔ LinkedList uses doubly linked list
✔ Maintains insertion order
✔ Allows duplicates
✔ Fast insertion and deletion
✔ Slow accessing by index
✔ Part of List interface

---

# 🚀 Summary

* LinkedList stores elements as nodes
* Dynamic in size
* Doubly linked list structure
* Allows duplicate values
* Faster insertion than ArrayList
* Used when frequent modifications required

---

# 📦 Vector in Java

## 📌 Definition

**Vector** is a class in Java Collection Framework that implements **List interface** and stores **dynamic array of elements**.

Vector is **synchronized**, which means it is **thread-safe**.

It is present in:

```java
java.util package
```

---

# 🔹 Vector Hierarchy

```
Iterable
   |
Collection
   |
   List
    |
   Vector
```

---

# 🔹 Features of Vector

* Maintains insertion order
* Allows duplicate elements
* Dynamic in size
* Thread-safe (synchronized)
* Slower than ArrayList
* Legacy class

---

# 🔹 Vector Syntax

```java
Vector<Type> v = new Vector<>();
```

---

# 🔹 Example Syntax

```java
Vector<Integer> v = new Vector<>();
```

---

# 🔹 Common Vector Methods

| Method         | Description        |
| -------------- | ------------------ |
| add()          | add element        |
| addElement()   | add element        |
| get()          | get element        |
| remove()       | remove element     |
| size()         | number of elements |
| capacity()     | current capacity   |
| firstElement() | first value        |
| lastElement()  | last value         |

---

# 🔹 Key Points

✔ Vector implements List interface
✔ Maintains insertion order
✔ Allows duplicates
✔ Thread-safe (synchronized)
✔ Slower than ArrayList
✔ Legacy collection class

---

# 🚀 Summary

* Vector is dynamic array
* Thread-safe collection
* Allows duplicate elements
* Maintains insertion order
* Slower but synchronized
* Part of List interface

---

# 🧩 Set Interface in Java

## 📌 Definition

**Set** is an interface in Java Collection Framework used to **store unique elements**.

It **does not allow duplicate values** and **does not maintain insertion order** (except some implementations).

Set is present in:

```java
java.util package
```

---

# 🔹 Set Hierarchy

```
Iterable
   |
Collection
   |
   Set
  ├── HashSet
  ├── LinkedHashSet
  └── TreeSet
```

---

# 🔹 Features of Set

* No duplicate elements
* Unordered collection
* Dynamic size
* Stores objects only
* Allows one null value (HashSet)

---

# 🔹 Set Syntax

```java
Set<Type> set = new HashSet<>();
```

---

# 🔹 Set Implementations

### HashSet

* Unordered
* Fast performance
* Allows one null

### LinkedHashSet

* Maintains insertion order
* Slower than HashSet

### TreeSet

* Sorted order
* No null allowed
* Slower than HashSet

---

# 🔹 Common Set Methods

| Method     | Description        |
| ---------- | ------------------ |
| add()      | add element        |
| remove()   | remove element     |
| contains() | check element      |
| size()     | number of elements |
| clear()    | remove all         |
| isEmpty()  | check empty        |

---

# 🔹 Key Points

✔ Set does not allow duplicates
✔ Unordered collection
✔ Dynamic size
✔ HashSet, LinkedHashSet, TreeSet implementations
✔ Part of Collection framework

---

# 🚀 Summary

* Set stores unique elements
* Duplicates not allowed
* Unordered collection
* HashSet fastest
* TreeSet sorted
* Used when duplicates not needed

---

# #️⃣ HashSet in Java

## 📌 Definition

**HashSet** is a class in Java Collection Framework that implements **Set interface** and stores **unique elements**.

It **does not allow duplicates** and **does not maintain insertion order**.

HashSet is present in:

```java
java.util package
```

---

# 🔹 HashSet Hierarchy

```
Iterable
   |
Collection
   |
   Set
    |
  HashSet
```

---

# 🔹 Features of HashSet

* No duplicate elements
* Unordered collection
* Allows one null value
* Fast performance
* Uses hashing internally
* Not synchronized

---

# 🔹 HashSet Syntax

```java
HashSet<Type> set = new HashSet<>();
```

---

# 🔹 Example Syntax

```java
HashSet<Integer> set = new HashSet<>();
```

---

# 🔹 Common HashSet Methods

| Method     | Description        |
| ---------- | ------------------ |
| add()      | add element        |
| remove()   | remove element     |
| contains() | check element      |
| size()     | number of elements |
| clear()    | remove all         |
| isEmpty()  | check empty        |

---

# 🔹 Key Points

✔ HashSet implements Set interface
✔ Does not allow duplicates
✔ Does not maintain order
✔ Allows one null value
✔ Fastest Set implementation

---

# 🚀 Summary

* HashSet stores unique elements
* No duplicate values allowed
* Unordered collection
* Allows one null value
* Fast performance using hashing
* Part of Set interface

---

# 🌳 TreeSet in Java

## 📌 Definition

**TreeSet** is a class in Java Collection Framework that implements **Set interface** and stores **unique elements in sorted order**.

It **does not allow duplicates** and **automatically sorts elements**.

TreeSet is present in:

```java id="0e7m9q"
java.util package
```

---

# 🔹 TreeSet Hierarchy

```id="7q42p6"
Iterable
   |
Collection
   |
   Set
    |
  TreeSet
```

---

# 🔹 Features of TreeSet

* No duplicate elements
* Sorted order (ascending)
* Does not allow null values
* Slower than HashSet
* Uses Tree structure (Red-Black Tree)
* Not synchronized

---

# 🔹 TreeSet Syntax

```java id="4pqy3o"
TreeSet<Type> set = new TreeSet<>();
```

---

# 🔹 Example Syntax

```java id="nbpxc8"
TreeSet<Integer> set = new TreeSet<>();
```

---

# 🔹 Common TreeSet Methods

| Method   | Description        |
| -------- | ------------------ |
| add()    | add element        |
| remove() | remove element     |
| first()  | first element      |
| last()   | last element       |
| higher() | next greater       |
| lower()  | next smaller       |
| size()   | number of elements |

---

# 🔹 Key Points

✔ TreeSet implements Set interface
✔ Does not allow duplicates
✔ Stores elements in sorted order
✔ Null not allowed
✔ Slower than HashSet
✔ Uses tree structure

---

# 🚀 Summary

* TreeSet stores unique elements
* Automatically sorted
* No duplicates allowed
* Null values not allowed
* Slower but sorted collection
* Part of Set interface

---

# 🔗 LinkedHashSet in Java

## 📌 Definition

**LinkedHashSet** is a class in Java Collection Framework that implements **Set interface** and stores **unique elements while maintaining insertion order**.

It **does not allow duplicates** and **preserves order of insertion**.

LinkedHashSet is present in:

```java
java.util package
```

---

# 🔹 LinkedHashSet Hierarchy

```
Iterable
   |
Collection
   |
   Set
    |
LinkedHashSet
```

---

# 🔹 Features of LinkedHashSet

* No duplicate elements
* Maintains insertion order
* Allows one null value
* Slower than HashSet
* Faster than TreeSet
* Uses Linked list + Hash table

---

# 🔹 LinkedHashSet Syntax

```java
LinkedHashSet<Type> set = new LinkedHashSet<>();
```

---

# 🔹 Example Syntax

```java
LinkedHashSet<String> set = new LinkedHashSet<>();
```

---

# 🔹 Common LinkedHashSet Methods

| Method     | Description        |
| ---------- | ------------------ |
| add()      | add element        |
| remove()   | remove element     |
| contains() | check element      |
| size()     | number of elements |
| clear()    | remove all         |
| isEmpty()  | check empty        |

---

# 🔹 Key Points

✔ LinkedHashSet implements Set interface
✔ Does not allow duplicates
✔ Maintains insertion order
✔ Allows one null value
✔ Slower than HashSet but ordered

---

# 🚀 Summary

* LinkedHashSet stores unique elements
* Maintains insertion order
* No duplicates allowed
* Allows one null value
* Combination of HashSet + LinkedList
* Part of Set interface

---

# 🗺️ Map in Java

## 📌 Definition

**Map** is an interface in Java Collection Framework used to **store data in key-value pairs**.

* Each key maps to one value
* Keys must be unique
* Values can be duplicate
* Not part of Collection interface

Map is present in:

```java id="s0o0c3"
java.util package
```

---

# 🔹 Map Hierarchy

```id="p0zntn"
Map
 ├── HashMap
 ├── LinkedHashMap
 ├── TreeMap
 └── Hashtable
```

---

# 🔹 Features of Map

* Stores key-value pairs
* Keys are unique
* Values can duplicate
* Dynamic in size
* Faster searching using key

---

# 🔹 Map Syntax

```java id="0i2xfl"
Map<Key, Value> map = new HashMap<>();
```

---

# 🔹 Example Syntax

```java id="g33gn8"
Map<Integer, String> map = new HashMap<>();
```

---

# 🔹 Common Map Methods

| Method          | Description         |
| --------------- | ------------------- |
| put()           | add key-value       |
| get()           | get value using key |
| remove()        | remove entry        |
| containsKey()   | check key           |
| containsValue() | check value         |
| size()          | number of elements  |
| clear()         | remove all          |

---

# 🔹 Key Points

✔ Map stores key-value pairs
✔ Keys must be unique
✔ Values can duplicate
✔ Not part of Collection interface
✔ HashMap most used implementation

---

# 🚀 Summary

* Map stores data in pairs
* Key must be unique
* Value can duplicate
* HashMap, TreeMap, LinkedHashMap
* Used for fast lookup using key

---

# 📥 Queue in Java

## 📌 Definition

**Queue** is an interface in Java Collection Framework used to **store elements in FIFO order**.

FIFO means **First In First Out**.

Elements are **added at rear** and **removed from front**.

Queue is present in:

```java
java.util package
```

---

# 🔹 Queue Hierarchy

```
Iterable
   |
Collection
   |
   Queue
   ├── PriorityQueue
   ├── ArrayDeque
   └── LinkedList
```

---

# 🔹 Features of Queue

* Follows FIFO order
* Dynamic in size
* Allows duplicate elements
* Stores objects only
* Used in scheduling and buffering

---

# 🔹 Queue Syntax

```java
Queue<Type> q = new PriorityQueue<>();
```

---

# 🔹 Queue Methods

| Method    | Description        |
| --------- | ------------------ |
| add()     | insert element     |
| offer()   | insert element     |
| remove()  | remove element     |
| poll()    | remove head        |
| peek()    | view first element |
| element() | view head          |
| size()    | number of elements |

---

# 🔹 Queue Implementations

### PriorityQueue

* Sorted order
* No null allowed

### ArrayDeque

* Double ended queue
* Fast performance

### LinkedList

* FIFO queue
* Doubly linked list

---

# 🔹 Key Points

✔ Queue follows FIFO
✔ Insert at rear, remove from front
✔ Allows duplicates
✔ PriorityQueue most used
✔ Part of Collection framework

---

# 🚀 Summary

* Queue follows FIFO order
* Dynamic collection
* Allows duplicate values
* PriorityQueue, ArrayDeque implementations
* Used for scheduling and processing

---

# 🌊 Stream in Java

## 📌 Definition

**Stream** in Java is used to **process collections of data** in a **functional and efficient way**.

Stream does **not store data**, it only **processes data** from collections.

Streams are introduced in **Java 8**.

---

# 🔹 Features of Stream

* Does not modify original data
* Supports functional programming
* Used for filtering and sorting
* Improves readability
* Processes data in pipeline

---

# 🔹 Stream Hierarchy / Flow

```
Collection → Stream → Operations → Result
```

Example Flow:

```
List → stream() → filter() → map() → collect()
```

---

# 🔹 Creating Stream

```java
list.stream();
```

---

# 🔹 Common Stream Methods

### filter()

Used to filter elements

```java
filter(x -> x > 10)
```

---

### map()

Used to transform elements

```java
map(x -> x * 2)
```

---

### sorted()

Sort elements

```java
sorted()
```

---

### forEach()

Print elements

```java
forEach(System.out::println)
```

---

### collect()

Collect result

```java
collect(Collectors.toList())
```

---

# 🔹 Stream Syntax

```java
list.stream()
    .filter(...)
    .map(...)
    .sorted()
    .forEach(...);
```

---

# 🔹 Key Points

✔ Stream introduced in Java 8
✔ Used to process collections
✔ Does not store data
✔ Uses lambda expressions
✔ Supports chaining operations

---

# 🚀 Summary

* Stream processes collection data
* Functional style programming
* filter, map, sorted operations
* Improves readability
* Introduced in Java 8

---