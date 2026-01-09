🧑‍💼 Employee Management System (EMS)

📌 Description

The Employee Management System (EMS) is a RESTful backend application built using Spring Boot and Spring Data JPA (Hibernate) with a PostgreSQL database.

It provides a clean API for managing employee records, supporting full CRUD operations (Create, Read, Update, Delete) with fields such as first name, last name, and email.

This project emphasizes clean backend architecture, proper separation of concerns, DTO usage, validation, and centralized exception handling — following industry best practices.

🏗️ Architecture Overview

The application follows a layered architecture:

Controller Layer – Handles HTTP requests and responses

Service Layer – Contains business logic and DTO ↔ Entity mapping

Repository Layer – Manages database access via Spring Data JPA

Entity Layer – Represents database tables

DTO Layer – Controls API input/output structure

Global Exception Handling – Centralized error handling for clean responses

✨ Features

➕ Add a new employee

📄 Retrieve all employees

🔍 Retrieve an employee by ID

❌ Delete an employee

🧪 Input validation using Jakarta Bean Validation

⚠️ Global exception handling with meaningful error responses

🐘 PostgreSQL persistence (Dockerized)

🔄 DTO mapping for clean and secure API responses

🚀 Tech Stack

Java 17+

Spring Boot

Spring Data JPA / Hibernate

PostgreSQL

Docker

Maven

Jakarta Validation

Postman (API testing)

🐳 Docker Setup (PostgreSQL)

The PostgreSQL database runs inside a Docker container.

Run PostgreSQL using Docker:
docker run --name ems-postgres \
  -e POSTGRES_USER=emsuser \
  -e POSTGRES_PASSWORD=emspassword \
  -e POSTGRES_DB=emsdb \
  -p 5432:5432 \
  -d postgres:15

⚙️ Application Configuration

The application is configured using application.properties:

PostgreSQL datasource

Hibernate auto schema generation

SQL logging for development

🔌 API Endpoints
Method	Endpoint	Description
POST	/api/employees	Create a new employee
GET	/api/employees	Retrieve all employees
GET	/api/employees/{id}	Retrieve employee by ID
DELETE	/api/employees/{id}	Delete employee
🧪 API Testing

All endpoints were tested using Postman.

Validation errors return 400 Bad Request

Non-existent resources return 404 Not Found

Successful operations return appropriate HTTP status codes

📚 Learning Outcomes

This project demonstrates:

Building REST APIs with Spring Boot

Proper use of DTOs and validation

Clean layered architecture

Dockerized database setup

PostgreSQL integration with Hibernate

Global exception handling

🔮 Future Improvements

Update employee endpoint (PUT/PATCH)

Pagination and sorting

Search/filter employees

Authentication & authorization

Environment-based profiles (dev/prod)
