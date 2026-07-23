# Queue-Management-System

## 📖 Overview
A RESTful Queue Management System built using Spring Boot to manage customers and service tokens efficiently.

## ✨ Features
- Register Customers
- Generate Queue Tokens
- View All Tokens
- Get Token by ID
- View Waiting Tokens
- Call Next Token
- Complete Current Token
- Input Validation
- Global Exception Handling

## 🛠 Technologies Used
- Java 17
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- Git

## 📂 Project Structure
controller/
service/
repository/
entity/
dto/
exception/

## 📡 API Endpoints
POST /api/customers
POST /api/tokens
GET /api/tokens
GET /api/tokens/{id}
GET /api/tokens/waiting
PUT /api/tokens/call-next
PUT /api/tokens/complete

## 🚀 How to Run
1. Clone the repository
2. Configure MySQL
3. Update application.properties
4. Run the Spring Boot application
