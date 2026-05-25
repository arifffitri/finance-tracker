# 💰 Finance Tracker API

> A simple RESTful backend API for personal finance management — built with Java 21, Spring Boot, Spring Security, and MySQL.

---

## 📋 Table of Contents

- [About the Project](#about-the-project)
- [Features](#features)
- [Tech Stack](#tech-stack)
- [Architecture](#architecture)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
  - [Configuration](#configuration)
  - [Running the Application](#running-the-application)
- [API Endpoints](#api-endpoints)
- [Project Structure](#project-structure)

---

## 📖 About the Project

**Finance Tracker** is a secure, production-ready REST API that enables users to manage their personal finances. The application provides full CRUD operations for income and expense records, secured with Spring Security authentication. It follows a clean layered architecture (Controller → Service → Repository) and is built on modern Java and the Spring ecosystem.

This project was built to demonstrate proficiency in:
- Designing and building RESTful APIs with Spring Boot
- Implementing application security with Spring Security
- Persisting data using Spring Data JPA with a MySQL relational database
- Reducing boilerplate with Lombok and simplifying object mapping with MapStruct

---

## ✨ Features

- 🔐 **Secure Authentication** — Request-level security via Spring Security
- 📊 **Transaction Management** — Create, read, update, and delete income and expense records
- 🗂️ **Category Support** — Organise transactions by category
- 🗃️ **Persistent Storage** — MySQL database with JPA/Hibernate ORM
- 🧩 **DTO Pattern** — Clean separation between API contracts and domain models using MapStruct
- 🏗️ **Layered Architecture** — Follows Controller → Service → Repository design principles
- ✅ **Unit & Integration Tests** — Test coverage via Spring Boot Test, Data JPA Test, and Security Test

---

## 🛠️ Tech Stack

| Layer | Technology |
|---|---|
| Language | Java 21 |
| Framework | Spring Boot 4.0.6 |
| Security | Spring Security |
| Persistence | Spring Data JPA / Hibernate |
| Database | MySQL 8.x |
| Build Tool | Apache Maven |
| Object Mapping | MapStruct 1.5.5 |
| Boilerplate Reduction | Lombok |
| Testing | Spring Boot Test, Spring Security Test |

---

## 🏛️ Architecture

The application follows a standard **3-layer Spring Boot architecture**:

```
HTTP Request
     │
     ▼
┌─────────────┐
│  Controller │  ← Handles HTTP requests, validates input, returns responses
└──────┬──────┘
       │
       ▼
┌─────────────┐
│   Service   │  ← Contains business logic, orchestrates data flow
└──────┬──────┘
       │
       ▼
┌─────────────┐
│ Repository  │  ← Communicates with the MySQL database via JPA
└─────────────┘
```

**MapStruct** is used to map between entity models and DTOs, keeping the API contract decoupled from the database schema. **Spring Security** sits as a filter layer, securing endpoints before requests reach the controllers.

---

## 🚀 Getting Started

### Prerequisites

Make sure you have the following installed:

- [Java 21](https://adoptium.net/) or higher
- [Maven 3.8+](https://maven.apache.org/download.cgi) (or use the included `./mvnw` wrapper)
- [MySQL 8.x](https://dev.mysql.com/downloads/mysql/)
- [Git](https://git-scm.com/)

### Installation

1. **Clone the repository**

   ```bash
   git clone https://github.com/arifffitri/finance-tracker.git
   cd finance-tracker
   ```

2. **Create a MySQL database**

   ```sql
   CREATE DATABASE finance_tracker;
   ```

### Configuration

Create or edit `src/main/resources/application.properties` with your database credentials:

```properties
# DataSource
spring.datasource.url=jdbc:mysql://localhost:3306/finance_tracker
spring.datasource.username=your_mysql_username
spring.datasource.password=your_mysql_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# JPA / Hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

# Server
server.port=8080
```

> ⚠️ **Security Note:** Never commit credentials to version control. Use environment variables or a `.env` file in production and add `application.properties` to `.gitignore`.

### Running the Application

Using the Maven wrapper (no separate Maven installation needed):

```bash
# On macOS / Linux
./mvnw spring-boot:run

# On Windows
mvnw.cmd spring-boot:run
```

Or build and run the JAR:

```bash
./mvnw clean package
java -jar target/demo-0.0.1-SNAPSHOT.jar
```

The API will be available at `http://localhost:8080`.

---

## 📡 API Endpoints

Base URL: `http://localhost:8080`

> All endpoints are secured. Include valid credentials/token in the `Authorization` header.

### Transactions

| Method | Endpoint | Description |
|--------|----------|-------------|
| `GET` | `/api/expenses` | Get all transactions |
| `POST` | `/api/expenses` | Create a new transaction |
| `DELETE` | `/api/expenses/{id}` | Delete a transaction |

### Example Request — Create Transaction

```http
POST /api/expenses
Content-Type: application/json
Authorization: Basic <credentials>

{
  "type": "EXPENSE",
  "amount": 50.00,
  "category": "Food",
  "description": "Groceries",
  "date": "2025-05-20"
}
```

---

## 📁 Project Structure

```
finance-tracker/
├── .mvn/wrapper/               # Maven wrapper config
├── src/
│   ├── main/
│   │   ├── java/com/example/demo/
│   │   │   ├── controller/     # REST controllers
│   │   │   ├── service/        # Business logic
│   │   │   ├── repository/     # JPA repositories
│   │   │   ├── model/          # JPA entity classes
│   │   │   ├── dto/            # Data Transfer Objects
│   │   │   ├── mapper/         # MapStruct mappers
│   │   │   ├── security/       # Spring Security config
│   │   │   └── DemoApplication.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/                   # Unit and integration tests
├── pom.xml                     # Maven dependencies & build config
├── mvnw                        # Maven wrapper (Unix)
├── mvnw.cmd                    # Maven wrapper (Windows)
└── README.md
```

---

## 🧪 Running Tests

```bash
./mvnw test
```

Test coverage includes:
- **Spring Boot Test** — Integration testing of the full application context
- **Spring Data JPA Test** — Repository layer testing with an in-memory database
- **Spring Security Test** — Verifying that security rules are correctly applied

---

## 👤 Author

**Ariff Fitri**  
GitHub: [@arifffitri](https://github.com/arifffitri)

---
