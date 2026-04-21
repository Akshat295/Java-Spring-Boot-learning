# 🧪 JUnit – Complete Guide (Theory + Syntax)

## 📌 What is JUnit?

JUnit is a **unit testing framework for Java** used to test individual components (methods/classes) in isolation. It helps ensure code correctness, reliability, and maintainability.

---

## 🎯 Purpose

* Validate functionality of code
* Detect bugs early
* Support Test-Driven Development (TDD)
* Improve code quality

---

## 🏗️ Versions

* **JUnit 4** → Basic annotations, less flexible
* **JUnit 5 (Jupiter)** → Modern, modular, recommended

---

## 🧩 JUnit 5 Architecture

* **JUnit Platform** → Runs test engines
* **JUnit Jupiter** → API for writing tests
* **JUnit Vintage** → Supports older JUnit versions

---

## ⚙️ Maven Dependency

```xml
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter</artifactId>
    <version>5.x.x</version>
    <scope>test</scope>
</dependency>
```

---

## 🏷️ Annotations (Syntax + Description)

### Test Annotation

```java
@Test
```

Marks a method as a test case.

---

### Lifecycle Annotations

```java
@BeforeEach
@AfterEach
@BeforeAll
@AfterAll
```

* `@BeforeEach` → runs before each test
* `@AfterEach` → runs after each test
* `@BeforeAll` → runs once before all tests
* `@AfterAll` → runs once after all tests

---

### Disable Test

```java
@Disabled
```

Skips execution of a test.

---

### Display Name

```java
@DisplayName("Custom Name")
```

Provides custom name for test execution.

---

## 🧪 Assertions (Syntax)

```java
assertEquals(expected, actual);
assertNotEquals(expected, actual);
assertTrue(condition);
assertFalse(condition);
assertNull(object);
assertNotNull(object);
```

---

### Exception Assertion

```java
assertThrows(ExceptionType.class, executable);
```

---

### Timeout Assertion

```java
assertTimeout(duration, executable);
```

---

## 🔁 Test Lifecycle Flow

1. `@BeforeAll`
2. `@BeforeEach`
3. `@Test`
4. `@AfterEach`
5. `@AfterAll`

---

## 🔄 Types of Testing

* **Unit Testing** → individual components
* **Integration Testing** → interaction between modules
* **Functional Testing** → requirement-based testing
* **Regression Testing** → ensures no breakage

---

## 🔢 Parameterized Tests (Syntax)

```java
@ParameterizedTest
@ValueSource(...)
```

Other sources:

* `@CsvSource`
* `@MethodSource`
* `@EnumSource`

---

## 📊 Test Results

* Passed
* Failed
* Skipped

---

## 🧠 Key Concepts

* **Test Case** → single test unit
* **Test Suite** → collection of tests
* **Assertions** → validation checks
* **Fixtures** → setup/teardown logic

---

## 🔥 Best Practices

* Write independent tests
* Use clear naming
* Keep tests small and focused
* Cover edge cases
* Avoid dependencies between tests

---
