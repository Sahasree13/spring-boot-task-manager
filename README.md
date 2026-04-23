# Task Management Microservice

A robust, enterprise-grade RESTful API built with **Spring Boot 3.2.5**. This project demonstrates advanced backend patterns including **Asynchronous Processing**, **Soft Deletes**, and **Global Exception Handling**, designed with a focus on system reliability and data integrity.

## 🚀 Key Features & Innovations

* **Asynchronous Audit Logging:** Utilizes Spring's `@Async` to offload logging tasks to background threads, ensuring zero impact on API response latency.
* **Logical "Soft" Delete:** Implements a state-aware deletion strategy using custom JPA queries, preserving records for audit trails while maintaining a clean client-facing state.
* **Automated API Documentation:** Fully integrated with **OpenAPI 3 / Swagger UI** for interactive endpoint testing and self-documenting code.
* **Global Exception Handling:** Centralized error management using `@ControllerAdvice` to provide standardized, developer-friendly JSON error responses (404, 400).

## 🛠 Tech Stack

* **Framework:** Spring Boot 3.2.5
* **Language:** Java 17
* **Persistence:** Spring Data JPA
* **Database:** H2 (In-Memory)
* **Documentation:** Springdoc-OpenAPI / Swagger

---

## 🏁 Getting Started

### Installation & Running
1. **Clone the repository:**
   ```bash
   git clone [https://github.com/Sahasree13/spring-boot-task-manager.git](https://github.com/Sahasree13/spring-boot-task-manager.git)
   cd spring-boot-task-manager