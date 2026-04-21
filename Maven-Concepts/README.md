# 📦 Maven Concepts – Day 01

## 📌 Overview

This project covers the basics of **Apache Maven**, including installation, project creation, build lifecycle, and both **Standalone (JAR)** and **Web Application (WAR)** setups.

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

# 📁 Maven Project Creation

## 🔹 1. Standalone Java Project (JAR)

### Command Used

```bash
mvn archetype:generate
```

### Archetype Selected

```
org.apache.maven.archetypes:maven-archetype-quickstart
```

### Project Details

```
groupId: com.akshat
artifactId: akshat-app
```

---

## 📂 Project Structure (Standalone)

```
akshat-app/
 ├── pom.xml
 └── src/
     ├── main/java/com/akshat/App.java
     └── test/java/com/akshat/AppTest.java
```

---

## 📦 Build Output (JAR)

```
target/
 ├── classes/
 ├── test-classes/
 └── akshat-app-1.0-SNAPSHOT.jar
```

---

## 🔹 2. Java Web Application (WAR)

### Command Used

```bash
mvn archetype:generate
```

### Archetype Selected

```
org.apache.maven.archetypes:maven-archetype-webapp
```

### Version Used

```
1.5
```

### Project Details

```
groupId: com.akshat
artifactId: akshat-web-app
```

---

## 📂 Project Structure (Web App)

```
akshat-web-app/
 ├── pom.xml
 └── src/
     └── main/
         └── webapp/
             ├── index.jsp
             └── WEB-INF/
                 └── web.xml
```

---

## 🧠 Important Concepts

## 🔹 POM File (`pom.xml`)

* Stands for Project Object Model
* Heart of Maven project
* Contains:

  * Project metadata
  * Dependencies
  * Plugins
  * Build configuration

---

## 🔹 Maven Lifecycle

| Phase   | Description                  |
| ------- | ---------------------------- |
| clean   | Deletes old build files      |
| compile | Compiles source code         |
| test    | Runs test cases              |
| package | Creates JAR/WAR file         |
| install | Installs to local repository |

---

## 🔹 Packaging Types

### JAR (Java Archive)

* Used for standalone applications
* Output: `.jar`

### WAR (Web Archive)

* Used for web applications
* Output: `.war`

---

## 🔹 Target Folder

* Created after build commands
* Contains compiled code and final output

---

## ▶️ Commands Used

### Standalone Project

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

### Web Application

```bash
# Navigate into project
cd akshat-web-app

# Build WAR file
mvn clean package

# Install project
mvn clean install
```

---

## 🌐 Deployment (Web App)

To run the web application:

1. Install Apache Tomcat
2. Copy `.war` file into:

```
tomcat/webapps/
```

3. Start server
4. Open browser:

```
http://localhost:8080/akshat-web-app
```

---

## ❗ Important Notes

* Maven commands must be run **inside the project folder**
* `pom.xml` is required to execute build commands
* No plugin is required to create `target` folder
* `WEB-INF` folder is not directly accessible
* Web app uses **Servlet + JSP (traditional approach)**

---

## 💡 Key Learnings

* Maven simplifies Java project management
* Standard project structure is followed
* Dependencies are managed automatically
* Build lifecycle handles compilation and packaging
* Difference between **JAR vs WAR** understood
* Basics of **Java Web Application structure**

---

