# 📦 Maven Concepts – Day 01

## 📌 Overview

This project covers the basics of **Apache Maven**, including installation, project creation, and build lifecycle.

---

## 🚀 What is Maven?

**Apache Maven** is a build automation and dependency management tool used primarily for Java projects.

It helps to:

* Compile code
* Manage dependencies
* Build and package applications
* Maintain a standard project structure

---

## ⚙️ Installation & Setup

### 1. Install Java

Maven requires Java (JDK 8 or above)

```bash
java -version
```

---

### 2. Install Maven

* Download Maven
* Extract it
* Set environment variables:

  * `MAVEN_HOME`
  * Add `MAVEN_HOME/bin` to `PATH`

---

### 3. Verify Installation

```bash
mvn -v
```

---

## 📁 Maven Project Creation

### 🔹 Command Used

```bash
mvn archetype:generate
```

### 🔹 Archetype Selected

```
org.apache.maven.archetypes:maven-archetype-quickstart
```

### 🔹 Project Details

```
groupId: com.akshat
artifactId: akshat-app
```

---

## 📂 Project Structure

```
akshat-app/
 ├── pom.xml
 └── src/
     ├── main/java/com/akshat/App.java
     └── test/java/com/akshat/AppTest.java
```

---

## 🧠 Important Concepts

### 🔹 POM File (`pom.xml`)

* Project Object Model
* Contains:

  * Project metadata
  * Dependencies
  * Plugins
  * Build configuration

---

### 🔹 Maven Lifecycle

| Phase   | Description                  |
| ------- | ---------------------------- |
| clean   | Deletes old build files      |
| compile | Compiles source code         |
| test    | Runs test cases              |
| package | Creates JAR/WAR file         |
| install | Installs to local repository |

---

## 📦 Target Folder

* Created after running build commands
* Contains compiled code and final output

```
target/
 ├── classes/
 ├── test-classes/
 └── akshat-app-1.0-SNAPSHOT.jar
```

---

## ▶️ Commands Used

```bash
# Create project
mvn archetype:generate

# Navigate into project
cd akshat-app

# Build project
mvn clean package

# Install project
mvn clean install
```

---

## ❗ Important Notes

* Maven commands must be run **inside the project folder**
* `pom.xml` is required to execute build commands
* No plugin is needed to create the `target` folder

---

## 💡 Key Learnings

* Maven simplifies Java project management
* Standard project structure is followed
* Dependencies are managed automatically
* Build lifecycle handles compilation and packaging



