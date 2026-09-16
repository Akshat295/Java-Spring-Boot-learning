# Spring Boot Filters Demo

A learning project demonstrating how **Servlet Filters** work in a Spring Boot application, how they fit into the request/response lifecycle, how multiple filters form a chain, and how filters can be used for cross-cutting concerns such as logging, authentication, request IDs, response headers, and request-duration measurement.

> **Note:** This README is based on the supplied learning-session transcript. The code snippets below are reconstructed from the concepts and examples discussed in the session, so small implementation details may differ from the original project.

---

## 📚 What This Project Covers

- Where a Filter sits in the Spring Boot request lifecycle
- Why cross-cutting logic should not be duplicated inside controllers
- `jakarta.servlet.Filter`
- Filter lifecycle:
  - `init()`
  - `doFilter()`
  - `destroy()`
- `ServletRequest` and `ServletResponse`
- `HttpServletRequest` and `HttpServletResponse`
- `FilterChain`
- Multiple filters and filter chaining
- Logging incoming requests
- Authentication checks
- API-key validation
- Returning an error response directly from a filter
- Adding request IDs to responses
- Measuring complete request/response duration
- Using `try/finally` around `filterChain.doFilter(...)`
- Ordering multiple filters with `@Order`
- Keeping each filter focused on a single responsibility
- Difference between Filters and Interceptors at a high level

---

## 🧠 Why Do We Need Filters?

Consider a normal Spring Boot application:

```text
Client
  |
  v
DispatcherServlet
  |
  v
Controller
  |
  v
Service
  |
  v
Repository
  |
  v
Database
```

A request eventually reaches the controller, but some operations are common to **many or all APIs**.

For example:

- Log every request
- Check authentication
- Validate a token/API key
- Generate a request ID
- Add a request ID to the response
- Measure API response time
- Add common response headers
- Perform encoding-related processing
- Reject a request before it reaches the controller

Putting all of this inside every controller would cause:

```text
Controller 1 -> logging + authentication + request ID
Controller 2 -> logging + authentication + request ID
Controller 3 -> logging + authentication + request ID
...
```

This creates duplicated code and tightly couples controllers with infrastructure/security concerns.

A Filter provides a common place for this type of logic.

---

## 🔄 Where Does a Filter Run?

The important request flow is:

```text
Client
  |
  v
Filter
  |
  v
DispatcherServlet
  |
  v
Controller
  |
  v
Service
  |
  v
Repository
  |
  v
Database
```

On the way back:

```text
Database
  |
  v
Repository
  |
  v
Service
  |
  v
Controller
  |
  v
DispatcherServlet
  |
  v
Filter
  |
  v
Client
```

The key point is that the Filter executes **before the DispatcherServlet handles the request** and gets control again while the response travels back.

Because it sits this early in the servlet flow, a Filter can also observe requests that may not eventually reach a controller, such as static resources or error-related endpoints.

---

## 🏗️ Filter vs Controller Responsibility

A controller's primary responsibility is to receive an API request and delegate application work to the appropriate service.

Cross-cutting concerns such as:

- request logging
- authentication
- request tracing
- common response headers
- timing

are better separated from controller/business logic.

This follows the **Single Responsibility Principle** discussed in the session.

---

# 🧩 Creating a Custom Filter

Servlet Filters come from the Servlet API rather than being a concept invented specifically by Spring.

For modern Spring Boot versions, the package is:

```java
jakarta.servlet
```

The core interface is:

```java
jakarta.servlet.Filter
```

A simple filter can be created as a Spring bean:

```java
@Component
public class LoggingFilter implements Filter {

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain filterChain
    ) throws IOException, ServletException {

        System.out.println("Request entered filter");

        filterChain.doFilter(request, response);
    }
}
```

### Why `@Component`?

`@Component` allows Spring's IoC container to discover and manage the filter bean.

### Why `implements Filter`?

Implementing `jakarta.servlet.Filter` tells the servlet environment that this class should participate in the servlet filter chain.

---

# 🔁 Filter Lifecycle

The `Filter` interface provides three lifecycle methods:

```java
init()
doFilter()
destroy()
```

Conceptually:

```text
Filter created
     |
     v
   init()
     |
     v
 doFilter()  <-- request processing
     |
     v
 destroy()
```

### `init()`

Called when the filter is initialized.

It is generally not the method you will work with for ordinary request processing.

### `doFilter()`

This is the main method.

It is where request/response filtering logic is performed.

```java
@Override
public void doFilter(
        ServletRequest request,
        ServletResponse response,
        FilterChain filterChain
) throws IOException, ServletException {

    // Filtering logic

    filterChain.doFilter(request, response);

    // Logic after the downstream request returns
}
```

### `destroy()`

Called when the filter is being destroyed.

Like `init()`, it is not normally where the application's request-processing logic lives.

---

# 📦 Understanding `doFilter()`

The method receives three important objects:

```java
ServletRequest request
ServletResponse response
FilterChain filterChain
```

## `ServletRequest`

Represents the incoming request in a generic servlet sense.

## `ServletResponse`

Represents the response in a generic servlet sense.

## `FilterChain`

Represents the chain of filters and the downstream processing.

The most important call is:

```java
filterChain.doFilter(request, response);
```

This tells the current filter:

> "I have finished my work. Continue processing the request."

---

# 🌐 HTTP Request and Response

The generic servlet API is not restricted to HTTP.

When working specifically with HTTP, the request/response objects can be treated as:

```java
HttpServletRequest
HttpServletResponse
```

For example:

```java
HttpServletRequest httpRequest =
        (HttpServletRequest) request;

HttpServletResponse httpResponse =
        (HttpServletResponse) response;
```

This gives access to HTTP-specific information such as:

```java
httpRequest.getMethod();
httpRequest.getRequestURI();
httpRequest.getHeader("Authorization");
httpResponse.setStatus(...);
httpResponse.setHeader(...);
```

For modern Spring Boot applications, use the `jakarta.servlet.*` imports.

Older Spring Boot generations may use `javax.servlet.*`.

---

# 🔗 Filter Chain

An application can contain multiple filters.

For example:

```text
Client
  |
  v
Authentication Filter
  |
  v
Logging Filter
  |
  v
DispatcherServlet
  |
  v
Controller
```

The request travels forward through the filters:

```text
Filter 1
   |
   v
Filter 2
   |
   v
Filter 3
   |
   v
DispatcherServlet
```

The response travels back in reverse order:

```text
DispatcherServlet
   |
   v
Filter 3
   |
   v
Filter 2
   |
   v
Filter 1
   |
   v
Client
```

This is why a filter can perform work both **before and after**:

```java
filterChain.doFilter(request, response);
```

---

# 🚦 What Does `filterChain.doFilter()` Actually Do?

Consider:

```java
System.out.println("Before");

filterChain.doFilter(request, response);

System.out.println("After");
```

The flow is conceptually:

```text
Current Filter
     |
     | "Before"
     v
filterChain.doFilter()
     |
     v
Next Filter / DispatcherServlet
     |
     v
Controller
     |
     v
Service
     |
     v
Controller
     |
     v
DispatcherServlet
     |
     v
Current Filter
     |
     | "After"
     v
Client
```

So the code after `doFilter()` executes when downstream processing returns.

This is particularly useful for measuring total request time and inspecting the final response status.

---

# 📝 Example: Logging Filter

A basic logging filter:

```java
@Component
public class LoggingFilter implements Filter {

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain filterChain
    ) throws IOException, ServletException {

        HttpServletRequest httpRequest =
                (HttpServletRequest) request;

        System.out.println(
                "Request: "
                + httpRequest.getMethod()
                + " "
                + httpRequest.getRequestURI()
        );

        filterChain.doFilter(request, response);
    }
}
```

This provides a centralized location for common request logging.

---

# 🔐 Authentication Filter

A filter can stop a request before it reaches the controller.

For example, the learning example checks a token and an API key.

Conceptually:

```text
Request
  |
  v
Authentication Filter
  |
  +---- invalid token ---> 401 Unauthorized
  |
  +---- invalid/missing API key ---> 401 Unauthorized
  |
  +---- valid credentials
              |
              v
        Filter Chain
              |
              v
       DispatcherServlet
```

Example structure:

```java
@Component
public class AuthenticationFilter implements Filter {

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain filterChain
    ) throws IOException, ServletException {

        HttpServletRequest httpRequest =
                (HttpServletRequest) request;

        HttpServletResponse httpResponse =
                (HttpServletResponse) response;

        String token = httpRequest.getHeader("token");
        String apiKey = httpRequest.getHeader("x-api-key");

        if (!"12345".equals(token)) {
            httpResponse.setStatus(
                    HttpServletResponse.SC_UNAUTHORIZED
            );
            return;
        }

        if (!"secret123".equals(apiKey)) {
            httpResponse.setStatus(
                    HttpServletResponse.SC_UNAUTHORIZED
            );
            return;
        }

        filterChain.doFilter(request, response);
    }
}
```

> The values above are intentionally simple demo values corresponding to the learning example. They are **not suitable for real authentication**.

---

# ❌ Returning an Error Directly From a Filter

A filter can reject a request without allowing it to continue.

For example:

```java
httpResponse.setStatus(
        HttpServletResponse.SC_UNAUTHORIZED
);

return;
```

This means:

```text
Filter
  |
  | validation failed
  v
401 Unauthorized
  |
  v
Client
```

The controller is never called.

A filter can also construct a response body:

```java
httpResponse.setStatus(
        HttpServletResponse.SC_UNAUTHORIZED
);

httpResponse.setContentType("application/json");

httpResponse.getWriter().write(
        "{\"message\":\"Invalid or missing API key\"}"
);

return;
```

This is useful when the application wants to reject a request early.

---

# 🆔 Request IDs

Another common filter use case is assigning every request a unique identifier.

Conceptually:

```text
Incoming Request
       |
       v
Generate Request ID
       |
       v
Continue Request
       |
       v
Controller / Service / Repository
       |
       v
Response
       |
       v
Add Request ID to Response
       |
       v
Client
```

A request ID can be used to connect:

```text
Request
   |
   +--> application logs
   |
   +--> downstream service logs
   |
   +--> client-visible response
```

For example:

```java
String requestId = UUID.randomUUID().toString();

httpResponse.setHeader(
        "X-Request-ID",
        requestId
);
```

The same ID can then be included in logs.

---

# ⏱️ Measuring Request Duration

A Filter is also a useful place to measure the total request/response cycle.

The important idea is:

```java
long startTime = System.currentTimeMillis();

filterChain.doFilter(request, response);

long endTime = System.currentTimeMillis();

long duration = endTime - startTime;
```

This measures the time spent while downstream processing executes.

Conceptually:

```text
Start Timer
    |
    v
Filter
    |
    v
DispatcherServlet
    |
    v
Controller
    |
    v
Service
    |
    v
Repository
    |
    v
Response
    |
    v
Filter
    |
    v
Stop Timer
```

The measured value represents the approximate total time for the downstream request-processing path.

---

# 🧯 Why `try/finally` Matters

If an exception occurs in the controller or service layer, code after:

```java
filterChain.doFilter(request, response);
```

may not execute normally.

Therefore, when cleanup/measurement/logging must happen regardless of success or failure, use:

```java
long startTime = System.currentTimeMillis();

try {
    filterChain.doFilter(request, response);
} finally {
    long duration =
            System.currentTimeMillis() - startTime;

    System.out.println(
            "Request duration: " + duration + " ms"
    );
}
```

The `finally` block is the appropriate place for logic that should execute even when downstream processing throws an exception.

---

# 📊 Example: Timing + Response Status

```java
long startTime = System.currentTimeMillis();

try {
    filterChain.doFilter(request, response);
} finally {

    long duration =
            System.currentTimeMillis() - startTime;

    HttpServletResponse httpResponse =
            (HttpServletResponse) response;

    System.out.println(
            "Response status: "
            + httpResponse.getStatus()
    );

    System.out.println(
            "API response time: "
            + duration
            + " ms"
    );
}
```

This can provide basic observability for APIs.

---

# 🔢 Multiple Filters and Ordering

Suppose we have:

```text
Authentication Filter
Logging Filter
```

We may want:

```text
1. Authentication
2. Logging
3. DispatcherServlet
```

Spring can be given an explicit order.

Example:

```java
@Component
@Order(1)
public class AuthenticationFilter implements Filter {
    // ...
}
```

and:

```java
@Component
@Order(2)
public class LoggingFilter implements Filter {
    // ...
}
```

The lower order value runs first.

Conceptually:

```text
@Order(1)
Authentication Filter
        |
        v
@Order(2)
Logging Filter
        |
        v
DispatcherServlet
```

The response travels back through the filters in reverse order.

---

# ⚠️ Why Explicit Ordering Matters

If multiple filters are registered without an explicit ordering requirement, you should not design critical application behavior around an assumed order.

If authentication must happen before another filter, make that relationship explicit.

Example:

```java
@Order(1)
AuthenticationFilter
```

followed by:

```java
@Order(2)
LoggingFilter
```

This makes the intended chain easier to understand and maintain.

---

# 🧱 Single Responsibility for Filters

A common mistake is creating one giant filter:

```text
MasterFilter
 ├── Authentication
 ├── Logging
 ├── Request ID
 ├── API key validation
 ├── Business logic
 ├── Response transformation
 └── Everything else
```

Although technically possible, this makes the filter difficult to maintain.

Instead:

```text
AuthenticationFilter
        |
        v
LoggingFilter
        |
        v
RequestIdFilter
        |
        v
Other Filter
```

Each filter should have a focused responsibility.

For example:

```text
AuthenticationFilter -> authentication
LoggingFilter       -> logging
RequestIdFilter     -> request identification
TimingFilter        -> request duration
```

The filter chain allows these concerns to remain separated.

---

# 🏛️ Demo Application Structure

The learning example builds a simple application with a controller and service:

```text
src/main/java/
└── ...
    ├── controller/
    │   └── StudentController.java
    │
    ├── service/
    │   └── StudentService.java
    │
    └── filter/
        ├── LoggingFilter.java
        └── AuthenticationFilter.java
```

The controller exposes a student-related endpoint, while the service represents the next application layer.

A simplified flow is:

```text
POST /api/students
       |
       v
AuthenticationFilter
       |
       v
LoggingFilter
       |
       v
DispatcherServlet
       |
       v
StudentController
       |
       v
StudentService
       |
       v
Response
       |
       v
Filters
       |
       v
Client
```

---

# 🧪 Testing the Filter

The session demonstrates testing through an API client such as Postman.

Example endpoint:

```text
POST http://localhost:8080/api/students
```

For the authentication example, the request contains headers such as:

```text
token: 12345
x-api-key: secret123
```

### Valid request

```text
token = 12345
x-api-key = secret123
```

Expected behavior:

```text
Authentication succeeds
        |
        v
Next filter executes
        |
        v
Controller executes
        |
        v
Successful response
```

### Missing/invalid token

Expected behavior:

```text
Authentication Filter
        |
        v
401 Unauthorized
```

The controller should not be reached.

### Missing/invalid API key

Expected behavior:

```text
Authentication Filter
        |
        v
401 Unauthorized
```

The learning example also demonstrates returning a JSON error body for a missing/invalid API key.

---

# 🗺️ Complete Request Flow

With two filters:

```text
                  REQUEST
                    |
                    v
            +----------------+
            | Authentication |
            |    Filter      |
            +----------------+
                    |
                    v
            +----------------+
            |    Logging     |
            |     Filter     |
            +----------------+
                    |
                    v
            +----------------+
            | Dispatcher     |
            |    Servlet     |
            +----------------+
                    |
                    v
            +----------------+
            |   Controller   |
            +----------------+
                    |
                    v
            +----------------+
            |    Service     |
            +----------------+
                    |
                    v
            +----------------+
            |   Repository   |
            +----------------+
                    |
                    v
                  RESPONSE
                    |
                    v
            Logging Filter
                    |
                    v
        Authentication Filter
                    |
                    v
                  Client
```

---

# 🔍 What Can a Filter Do?

The session discusses several possible uses:

| Use case | Filter suitable? |
|---|---|
| Request logging | ✅ |
| Response logging | ✅ |
| Authentication checks | ✅ |
| API-key checks | ✅ |
| Blocking requests | ✅ |
| Adding response headers | ✅ |
| Adding request IDs | ✅ |
| Measuring request duration | ✅ |
| Inspecting headers | ✅ |
| Inspecting cookies | ✅ |
| Encoding-related processing | ✅ |
| Common request/response processing | ✅ |
| Controller-specific business logic | ❌ |
| Application business logic | ❌ |

---

# ⚠️ Request Modification

Filters technically have access to the request and can participate in request modification.

However, the learning session emphasizes that modifying the actual application request structure is generally not the preferred approach when the goal is to transform application data.

For application-level transformations, other mechanisms such as DTOs can often be more appropriate.

The important distinction is:

```text
Filter
   -> cross-cutting HTTP/servlet concerns

Controller/Service
   -> application behavior and business logic
```

---

# 🆚 Filter vs Interceptor

The session introduces Interceptors as another important Spring concept.

A high-level distinction discussed is:

```text
Filter
  |
  | earlier in the servlet request lifecycle
  v
DispatcherServlet
  |
  v
Interceptor
  |
  v
Controller
```

A Filter belongs to the Servlet layer, while Spring MVC Interceptors operate within the Spring MVC request-processing flow.

The detailed study of Interceptors is outside this particular demo.

---

# 📌 Important Takeaways

### 1. Filters are part of the Servlet API

The custom filter implements:

```java
jakarta.servlet.Filter
```

rather than being a Spring-only concept.

### 2. `doFilter()` is the important method

Most request-processing logic goes inside:

```java
doFilter(...)
```

### 3. `filterChain.doFilter()` continues the request

Without it, the request can be stopped at the current filter.

```java
filterChain.doFilter(request, response);
```

### 4. Code after `doFilter()` handles the returning flow

```java
before();

filterChain.doFilter(request, response);

after();
```

### 5. Filters can form a chain

```text
Filter 1 -> Filter 2 -> Filter 3 -> DispatcherServlet
```

and the response returns in the opposite direction.

### 6. Filters are useful for cross-cutting concerns

Examples:

```text
Logging
Authentication
Request IDs
Timing
Common headers
Request blocking
```

### 7. Keep responsibilities separated

Prefer:

```text
AuthenticationFilter
LoggingFilter
TimingFilter
```

over one giant filter containing unrelated responsibilities.

### 8. Explicit ordering makes the chain predictable

Use ordering when one filter must execute before another:

```java
@Order(1)
@Order(2)
```

---

# 🚀 Running the Demo

The learning project is based on a Spring Boot application using the web dependency.

### Requirements

- Java 21
- Spring Boot
- Maven or Gradle
- IntelliJ IDEA or another Java IDE
- Postman/cURL for API testing

### Start the application

From IntelliJ:

```text
Run the Spring Boot main application class
```

Or with Maven:

```bash
./mvnw spring-boot:run
```

On Windows:

```powershell
.\mvnw.cmd spring-boot:run
```

The demo application runs on the default Spring Boot port:

```text
http://localhost:8080
```

---

# 🧑‍💻 Suggested Learning Exercises

After understanding the basic example, try implementing these independently:

### Exercise 1 — Request logging

Log:

```text
HTTP method
Request URI
```

### Exercise 2 — Request ID

Generate a UUID for every request and return it in:

```text
X-Request-ID
```

### Exercise 3 — Timing

Print:

```text
API response time: <duration> ms
```

### Exercise 4 — Authentication

Reject requests without a valid authentication header.

### Exercise 5 — API key

Require:

```text
x-api-key
```

before allowing the request to continue.

### Exercise 6 — Multiple filters

Create:

```text
AuthenticationFilter
LoggingFilter
TimingFilter
```

and give them explicit ordering.

### Exercise 7 — Exception-safe timing

Wrap:

```java
filterChain.doFilter(...)
```

inside:

```java
try/finally
```

and verify that timing/logging still executes when downstream code throws an exception.

---

# 📖 Quick Revision

```text
What is a Filter?
    ↓
A Servlet-level component for processing requests/responses
    ↓
Where does it run?
    ↓
Before/around DispatcherServlet processing
    ↓
Main method?
    ↓
doFilter()
    ↓
How do we continue?
    ↓
filterChain.doFilter(request, response)
    ↓
Can multiple filters exist?
    ↓
Yes — they form a chain
    ↓
How do we control order?
    ↓
@Order
    ↓
Common uses?
    ↓
Logging / Authentication / Request ID / Timing / Headers
```

---

## 🎯 Core Mental Model

The simplest way to remember Filters is:

> **A Filter is a common gate around the servlet request/response flow.**

It can perform work before the application handles the request:

```text
Request
  ↓
Filter → validate/log/modify/block
  ↓
Application
```

and can perform work after downstream processing returns:

```text
Application
  ↓
Filter → inspect/log/measure response
  ↓
Client
```

That makes Filters especially useful for functionality that should apply consistently across multiple APIs rather than being repeated inside individual controllers.
