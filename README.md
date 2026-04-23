# Task Management Microservice

A robust, enterprise-grade RESTful API built with **Spring Boot 3.2.5**. This project demonstrates advanced backend patterns including **Asynchronous Processing**, **Soft Deletes**, and **Global Exception Handling**, designed with a focus on system reliability and data integrity.

---

## 🚀 Key Features & Innovations

* **Asynchronous Audit Logging:** Utilizes Spring's `@Async` to offload logging tasks to background threads, ensuring zero impact on API response latency.
* **Logical "Soft" Delete:** Implements a state-aware deletion strategy using custom JPA queries, preserving records for audit trails while maintaining a clean client-facing state.
* **Automated API Documentation:** Fully integrated with **OpenAPI 3 / Swagger UI** for interactive endpoint testing and self-documenting code.
* **Global Exception Handling:** Centralized error management using `@ControllerAdvice` to provide standardized, developer-friendly JSON error responses (404, 400).
* **Jakarta Validation:** Enforces strict data contracts using `@Valid` annotations to ensure data quality at the entry point.

---

## 🛠 Tech Stack

* **Framework:** Spring Boot 3.2.5
* **Language:** Java 17
* **Persistence:** Spring Data JPA
* **Database:** H2 (In-Memory)
* **Documentation:** Springdoc-OpenAPI / Swagger UI
* **Tools:** Maven, Git, Postman

---

## 🏁 Getting Started

### Prerequisites
* **JDK 17** or higher
* **Maven 3.6+**

### Installation & Running
1.  **Clone the repository:**
    ```bash
    git clone [https://github.com/Sahasree13/spring-boot-task-manager.git](https://github.com/Sahasree13/spring-boot-task-manager.git)
    cd spring-boot-task-manager
    ```
2.  **Build and Run:**
    ```bash
    ./mvnw clean spring-boot:run
    ```
3.  **Access the API Documentation:**
    Once the application starts, visit the interactive Swagger UI at:
    `http://localhost:8080/swagger-ui/index.html`

---

## 📡 API Endpoints

| Method | Endpoint | Description |
| :--- | :--- | :--- |
| **POST** | `/api/tasks` | Create a new task (includes Jakarta Validation) |
| **GET** | `/api/tasks` | Retrieve all active (non-deleted) tasks |
| **GET** | `/api/tasks/{id}` | Get specific task details |
| **DELETE** | `/api/tasks/{id}` | Perform a soft-delete (logical removal) |

---

## 🏗 System Design Decisions

### 1. Why Soft Delete?
In production environments, data is rarely physically deleted. I implemented a `deleted` flag to allow for data recovery and historical auditing while keeping the API response focused only on active tasks.

### 2. Why Async Logging?
By using an `AsyncService`, I ensured that the primary user request (e.g., creating a task) is completed instantly without waiting for the logging I/O operation, optimizing thread pool usage and improving user experience.

### 3. Global Exception Handling
Instead of returning messy stack traces, the application uses a custom `GlobalExceptionHandler` to return consistent JSON objects with timestamps and specific error messages, which is a requirement for modern frontend-backend integration.

---

## 🐳 Docker Support
This project is container-ready. To build and run using Docker:
```bash
docker build -t task-manager .
docker run -p 8080:8080 task-manager