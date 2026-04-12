# Java Basics 

# 📦 Variables in Java

## 📌 Introduction

A **variable** in Java is a container used to store data values in memory.
Each variable has:

* a **data type** (what kind of data it can store)
* a **name** (identifier)
* a **value** (data stored inside)

---

## 🧠 Syntax

```java
dataType variableName = value;
```

### Example:

```java
int age = 21;
```

---

## 🔢 Types of Variables in Java

### 1️⃣ Local Variables

* Declared inside methods, constructors, or blocks
* Scope is limited to that method/block
* Must be initialized before use

```java
public class Demo {
    public static void main(String[] args) {
        int x = 10; // local variable
        System.out.println(x);
    }
}
```

---

### 2️⃣ Instance Variables

* Declared inside a class but outside methods
* Belong to an object (instance of class)
* Each object gets its own copy

```java
class Student {
    int marks; // instance variable
}
```

---

### 3️⃣ Static Variables

* Declared using `static` keyword
* Shared among all objects of the class
* Memory allocated only once

```java
class Student {
    static String college = "ABC College";
}
```

---

## 🔤 Data Types in Java

### ✅ Primitive Data Types

| Data Type | Example             |
| --------- | ------------------- |
| int       | `int a = 10;`       |
| float     | `float b = 10.5f;`  |
| double    | `double c = 20.99;` |
| char      | `char d = 'A';`     |
| boolean   | `boolean e = true;` |

---

### ✅ Non-Primitive (Reference Types)

* Used to store complex data
* Store reference (address) instead of actual value

```java
String name = "Akshat";
int[] arr = {1, 2, 3};
```

---

## ⚡ Rules for Naming Variables

* Must start with a letter, `_`, or `$`
* Cannot start with a number
  ❌ `1age`
* Cannot use Java keywords
  ❌ `int class = 10;`
* Case-sensitive
  `age` and `Age` are different

---

## ⚠️ Important Points

### 🔸 Initialization

Local variables must be initialized before use:

```java
int x;
System.out.println(x); // ❌ Compilation Error
```

---

### 🔸 Default Values

Instance and static variables get default values:

| Type         | Default Value |
| ------------ | ------------- |
| int          | 0             |
| float/double | 0.0           |
| boolean      | false         |
| object       | null          |


# 🔄 Type Conversion & Type Casting in Java

## 📌 Introduction

In Java, sometimes we need to convert data from one type to another. This is called:

* **Type Conversion (Implicit / Automatic)**
* **Type Casting (Explicit / Manual)**

---

## 🧠 1. Type Conversion (Implicit Casting)

### ✅ Definition

Type conversion happens automatically when:

* converting **smaller data type → larger data type**

👉 Also called **Widening Conversion**

---

### 🔢 Order of Conversion

```java id="ord123"
byte → short → int → long → float → double
```

### ⚡ Key Points

* No data loss ✅
* Done automatically by JVM
* Safe conversion

---

## 🧠 2. Type Casting (Explicit Casting)

### ❗ Definition

Type casting is done manually when:

* converting **larger data type → smaller data type**

👉 Also called **Narrowing Conversion**

---

### 💡 Syntax

```java id="syn456"
(dataType) variable
```
---

### ⚠️ Important Note

* Data loss may occur ❌
* Decimal part is truncated
* Must be done manually



## ⚖️ Type Conversion vs Type Casting

| Feature   | Type Conversion | Type Casting  |
| --------- | --------------- | ------------- |
| Type      | Automatic       | Manual        |
| Direction | Small → Large   | Large → Small |
| Safety    | Safe            | Risky         |
| Data Loss | No              | Possible      |

---

# ⚙️ Operators in Java

## 📌 Introduction

Operators in Java are special symbols used to perform operations on variables and values. They are fundamental to writing expressions and controlling program logic.

---

## 🔢 Types of Operators in Java

---

## 1️⃣ Arithmetic Operators

Used to perform basic mathematical operations such as addition, subtraction, multiplication, division, and modulus (remainder).

---

## 2️⃣ Relational (Comparison) Operators

Used to compare two values. These operators return a boolean result (`true` or `false`) based on the comparison.

---

## 3️⃣ Logical Operators

Used to combine multiple conditions or boolean expressions. They help in decision-making and control flow.

---

## 4️⃣ Assignment Operators

Used to assign values to variables. They also include shorthand operators that combine arithmetic operations with assignment.

---

## 5️⃣ Unary Operators

Operate on a single operand. These include increment, decrement, and logical negation operations.

---

## 6️⃣ Bitwise Operators

Operate directly on binary representations (bits) of integers. Commonly used in low-level programming and optimization.

---

## 7️⃣ Ternary Operator

A shorthand conditional operator used to replace simple if-else statements. It evaluates a condition and returns one of two values.

---

## ⚠️ Important Concepts

### 🔸 Operator Precedence

Determines the order in which operations are performed in an expression. Operators with higher precedence are evaluated before lower precedence ones.

---

### 🔸 Associativity

Defines the direction of evaluation when multiple operators of the same precedence appear in an expression (left-to-right or right-to-left).

---

### 🔸 Short-Circuit Evaluation

Logical operators may skip evaluation of the second condition if the result is already determined by the first condition.

---
# 🔀 Conditional Statements in Java

## 📌 Introduction

Conditional statements in Java are used to control the flow of execution based on certain conditions. They allow programs to make decisions and execute specific blocks of code depending on whether a condition evaluates to `true` or `false`.

---

## 🧠 Types of Conditional Statements

---

## 1️⃣ if Statement

The `if` statement is used to execute a block of code only if a specified condition is true.

---

## 2️⃣ if-else Statement

The `if-else` statement provides an alternative block of code that executes when the condition is false.

---

## 3️⃣ if-else-if Ladder

Used when multiple conditions need to be checked sequentially. The first true condition’s block is executed, and the rest are skipped.

---

## 4️⃣ Nested if Statement

An `if` statement inside another `if` statement. Useful for checking multiple dependent conditions.

---

## 5️⃣ switch Statement

Used to execute one block of code from multiple options based on the value of a variable or expression. It improves readability when dealing with multiple fixed cases.

---

## ⚠️ Important Concepts

### 🔸 Boolean Expressions

All conditional statements rely on boolean expressions that evaluate to either `true` or `false`.

---

### 🔸 Fall-through in switch

If `break` is not used in a `switch` case, execution continues to the next case (fall-through behavior).

---

### 🔸 break Statement

Used to terminate a `switch` block or loop when a condition is met.

---

### 🔸 default Case

Executed in a `switch` statement when no case matches the given expression.

---

# 🔁 Loops in Java

## 📌 Introduction

Loops in Java are used to execute a block of code repeatedly as long as a specified condition is true. They help reduce code redundancy and are essential for handling repetitive tasks efficiently.

---

## 🧠 Types of Loops in Java

---

## 1️⃣ for Loop

### 🔹 Syntax

```java
for (initialization; condition; update) {
    // code to be executed
}
```

---

## 2️⃣ while Loop

### 🔹 Syntax

```java
while (condition) {
    // code to be executed
}
```

---

## 3️⃣ do-while Loop

### 🔹 Syntax

```java
do {
    // code to be executed
} while (condition);
```

---

## 4️⃣ Enhanced for Loop (for-each)

### 🔹 Syntax

```java
for (dataType variable : collection) {
    // code to be executed
}
```

---

## ⚠️ Important Concepts

### 🔸 Infinite Loop

Occurs when the loop condition never becomes false, causing continuous execution.

---

### 🔸 Loop Control Statements

#### break

* Terminates the loop immediately

#### continue

* Skips the current iteration and moves to the next iteration

---

### 🔸 Nested Loops

A loop inside another loop used for complex iterations.

---
