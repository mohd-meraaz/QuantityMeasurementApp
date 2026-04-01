# 📐 Quantity Management System

## ⚙️ Microservices | Clean Architecture | Scalable Backend

---

## 🧩 Overview

The **Quantity Management System** is a backend application designed to:

- Compare different measurement units (feet, inches, meters, etc.)
- Convert values between units
- Perform arithmetic operations on quantities

The system is built with scalability and modularity in mind using modern backend architecture.

---

## 🏗️ Architecture Style

This project uses a **Microservices Architecture**, where:

- Each service is independently deployable
- Services are loosely coupled
- Every module has a single responsibility

---

## 🛠️ Tech Stack

| Layer              | Technology             |
|--------------------|------------------------|
| Backend            | Spring Boot            |
| Microservices      | Spring Cloud           |
| Service Discovery  | Eureka Server          |
| API Gateway        | Spring Cloud Gateway   |
| Security           | JWT + Google OAuth     |
| Communication      | REST APIs              |

---

## 🧱 System Architecture

```
                ┌─────────────────────┐
                │    API Gateway      │
                │      (8080)         │
                └─────────┬───────────┘
                          │
      ┌───────────────────┼───────────────────┐
      ▼                   ▼                   ▼
┌──────────────┐  ┌──────────────┐  ┌──────────────┐
│ Auth Service │  │ Quantity API │  │ Admin Panel  │
│   (8081)     │  │   (8082)     │  │   (8083)     │
└──────────────┘  └──────────────┘  └──────────────┘
                          │
                          ▼
                ┌──────────────────┐
                │ Eureka Registry  │
                │     (8761)       │
                └──────────────────┘
```

---

## 🔌 Services

| Service            | Port | Description                              |
|--------------------|------|------------------------------------------|
| Eureka Server      | 8761 | Service registry                         |
| API Gateway        | 8080 | Request routing & authentication         |
| Auth Service       | 8081 | Login and token generation               |
| Quantity Service   | 8082 | Business logic & unit operations         |
| Admin Service      | 8083 | Monitoring and management                |

---

## 🔄 Request Flow

### 🔐 Authentication

```
Client → Auth Service → JWT Token
```

### 📡 Authorized Requests

```
Client (JWT)
     ↓
API Gateway (validates token)
     ↓
Routes request
     ↓
Quantity Service (processes request)
```

---

## 🔑 Features

- Secure authentication with JWT and Google OAuth  
- Centralized API Gateway  
- Service discovery using Eureka  
- Scalable and modular architecture  
- Clean code practices and TDD approach  

---

## ▶️ How to Run

Start services in this order:

```bash
# 1. Eureka Server
cd eureka-server
mvn spring-boot:run

# 2. API Gateway
cd api-gateway
mvn spring-boot:run

# 3. Auth Service
cd auth-service
mvn spring-boot:run

# 4. Quantity Service
cd quantity-service
mvn spring-boot:run

# 5. Admin Service
cd admin-service
mvn spring-boot:run
```

---

## 🌐 URLs

| Service           | URL                      |
|-------------------|--------------------------|
| Eureka Dashboard  | http://localhost:8761    |
| API Gateway       | http://localhost:8080    |
| Auth Service      | http://localhost:8081    |
| Quantity Service  | http://localhost:8082    |
| Admin Service     | http://localhost:8083    |


---

## 👨‍💻 Author

Mohd Meraaz 
Backend Developer 🚀